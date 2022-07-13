package starter.transaction;


import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Pulsa {

    String base_url = "http://44.201.153.46:8081/api/v1/transactions/";
    String token;

    @Step("I set an endpoint for buy pulsa")
    public String setAnEndpointForBuyPulsa() { return base_url + "pulsa";}

    @Step("I request {string} POST pulsa")
    public void setRequestPOSTPulsa(String input) throws IOException {

        if (input.equals("inputValidPulsa")){
            JSONObject requestBody = new JSONObject();
            requestBody.put("product_id", 7);
            requestBody.put("phone", "087852566325");

//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenUser.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).post(setAnEndpointForBuyPulsa());

        }else if (input.equals("inputInvalidProduct")){
            JSONObject requestBody = new JSONObject();
            requestBody.put("product_id", 87);
            requestBody.put("phone", "087852566325");

//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenUser.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).post(setAnEndpointForBuyPulsa());

        }else if (input.equals("inputEmptyStock")){
            JSONObject requestBody = new JSONObject();
            requestBody.put("product_id", 9);
            requestBody.put("phone", "087852566325");

//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenUser.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).post(setAnEndpointForBuyPulsa());

        }else {
            JSONObject requestBody = new JSONObject();
            requestBody.put("product_id", 9);
            requestBody.put("phone", "087852566325");

            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + "invalidToken")
                    .body(requestBody.toJSONString()).post(setAnEndpointForBuyPulsa());
        }
    }

    @Step("validate the data detail {string} after buy pulsa")
    public void setValidateTheDataDetailAfterBuyPulsa(String message) {
        if (message.equals("BuyPulsaSuccess")){
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Buy pulsa success")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("201")));
        }else if (message.equals("ProductNotFound")){
            restAssuredThat(response -> response.body("message", Matchers.equalTo("product pulsa not found")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("400")));

        }else if (message.equals("ProductEmpty")){
            restAssuredThat(response -> response.body("message", Matchers.equalTo("product pulsa not found")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("400")));

        }else {
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Full authentication is required to access this resource")));
            restAssuredThat(response -> response.body("'status'", Matchers.equalTo(401)));
        }
    }

}
