package starter.pulsaProduct;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeletePulsaProduct {

    String base_url = "http://44.201.153.46:8081/api-dev/v1/products/pulsa/";
    String token, IdPulsaProduct;

    @Step("I set an endpoint for delete pulsa product")
    public String setAnEndpointForDeletePulsaProduct() throws IOException {
//         * Catch ID Pulsa Product
        this.IdPulsaProduct = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                "/src/test/resources/filejson/idPulsaProduct.json"), StandardCharsets.UTF_8);
        System.out.println(this.IdPulsaProduct);

        return base_url + this.IdPulsaProduct;
    }

    @Step("I request {string} DELETE pulsa product")
    public void setRequestDELETEPulsaProduct(String input) throws IOException {
        if (input.equals("validToken")){
            JSONObject requestBody = new JSONObject();
//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenAdmin.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).delete(setAnEndpointForDeletePulsaProduct());
        }else {
            JSONObject requestBody = new JSONObject();
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + "invalidToken")
                    .body(requestBody.toJSONString()).delete(setAnEndpointForDeletePulsaProduct());
        }
    }

    @Step("validate the data detail {string} after delete pulsa product")
    public void setValidateTheDataDetailAfterDeletePulsaProduct(String message) {
        if (message.equals("DeletePulsaProduct")){
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Delete pulsa product success")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("201")));
        }else {
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Full authentication is required to access this resource")));
            restAssuredThat(response -> response.body("'status'", Matchers.equalTo(401)));
        }
    }
}
