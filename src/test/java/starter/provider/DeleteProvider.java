package starter.provider;


import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteProvider {

    String base_url = "http://44.201.153.46:8081/api/v1/products/provider/";
    String token, IdProvider;

    @Step("I set an endpoint for delete provider")
    public String setAnEndpointForDeleteProvider() throws IOException {
//      * Catch ID Top up Product
        this.IdProvider = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                "/src/test/resources/filejson/idProvider.json"), StandardCharsets.UTF_8);
        System.out.println(this.IdProvider);

        return base_url + this.IdProvider;
    }


    @Step("I request {string} DELETE provider")
    public void setRequestDELETEProvider(String input) throws IOException {
        if (input.equals("validToken")){
            JSONObject requestBody = new JSONObject();
//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenAdmin.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).delete(setAnEndpointForDeleteProvider());
        }else {
            JSONObject requestBody = new JSONObject();
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + "invalidToken")
                    .body(requestBody.toJSONString()).delete(setAnEndpointForDeleteProvider());
        }
    }

    @Step("validate the data detail {string} after delete provider")
    public void setValidateTheDataDetailAfterDeleteProvider(String message) {
        if (message.equals("DeleteProvider")){
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Delete provider success")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("201")));
        }else {
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Full authentication is required to access this resource")));
            restAssuredThat(response -> response.body("'status'", Matchers.equalTo(401)));
        }
    }
}
