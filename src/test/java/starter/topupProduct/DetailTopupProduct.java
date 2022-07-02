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

public class DetailTopupProduct {

    String base_url = "http://44.201.153.46:8081/api-dev/v1/products/";
    String token;

    @Step("I set an endpoint for detail Top up")
    public String setAnEndpointForDetailTopUp() { return base_url + "topup";}

    @Step("I request {string} GET detail top up")
    public void setRequestGETDetailTopUp(String input) throws IOException {
        if (input.equals("validToken")){
            JSONObject requestBody = new JSONObject();
//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenUser.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).get(setAnEndpointForDetailTopUp());

        }else {
            JSONObject requestBody = new JSONObject();
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + "invalidToken")
                    .body(requestBody.toJSONString()).get(setAnEndpointForDetailTopUp());
        }
    }

    @Step("validate the data detail {string} after get detail top up")
    public void setValidateTheDataDetailAfterGetDetailTopUp(String message) {
        if (message.equals("getDetailTopup")){
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Get topup product success")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("200")));
        }else {
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Full authentication is required to access this resource")));
            restAssuredThat(response -> response.body("'status'", Matchers.equalTo(401)));
        }
    }
}
