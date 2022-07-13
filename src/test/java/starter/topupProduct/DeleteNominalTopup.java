package starter.topupProduct;


import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteNominalTopup {

    String base_url = "http://44.201.153.46:8081/api/v1/products/topup/";
    String token, IdTopupProduct;

    @Step("I set an endpoint for delete nominal top up")
    public String setAnEndpointForDeleteNominalTopUp() throws IOException {

//      * Catch ID Top up Product
        this.IdTopupProduct = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                "/src/test/resources/filejson/idTopupProduct.json"), StandardCharsets.UTF_8);
        System.out.println(this.IdTopupProduct);

        return base_url + this.IdTopupProduct;
    }

    @Step("I request {string} DELETE nominal top up")
    public void setRequestDELETENominalTopUp(String input) throws IOException {
        if (input.equals("validToken")){ //? Delete topup product success
            JSONObject requestBody = new JSONObject();
//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenAdmin.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).delete(setAnEndpointForDeleteNominalTopUp());

        }else {
            JSONObject requestBody = new JSONObject();
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + "invalidToken")
                    .body(requestBody.toJSONString()).delete(setAnEndpointForDeleteNominalTopUp());
        }
    }

    @Step("validate the data detail {string} after delete nominal top up")
    public void setValidateTheDataDetailAfterDeleteNominalTopUp(String message) {
        if (message.equals("DeleteTopup")){
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Delete topup product success")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("201")));
        }else {
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Full authentication is required to access this resource")));
            restAssuredThat(response -> response.body("'status'", Matchers.equalTo(401)));
        }
    }
}
