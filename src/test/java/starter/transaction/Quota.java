package starter.transaction;


import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Quota {

    String base_url = "http://44.201.153.46:8081/api-dev/v1/transactions/";
    String token;

    @Step("I set an endpoint for buy quota")
    public String setAnEndpointForBuyQuota() { return base_url + "quota";}

    @Step("I request {string} POST quota")
    public void setRequestPOSTQuota(String input) throws IOException {
        if (input.equals("inputValidQuota")){
            JSONObject requestBody = new JSONObject();
            requestBody.put("product_id", 3);
            requestBody.put("phone", "087852566325");

//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenAdmin.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).post(setAnEndpointForBuyQuota());

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
                    .body(requestBody.toJSONString()).post(setAnEndpointForBuyQuota());

        }else if (input.equals("inputEmptyStock")){
            JSONObject requestBody = new JSONObject();
            requestBody.put("product_id", 18);
            requestBody.put("phone", "087852566325");

//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenUser.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).post(setAnEndpointForBuyQuota());

        }else {
            JSONObject requestBody = new JSONObject();
            requestBody.put("product_id", 9);
            requestBody.put("phone", "087852566325");

            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + "invalidToken")
                    .body(requestBody.toJSONString()).post(setAnEndpointForBuyQuota());
        }

    }

    @Step("validate the data detail {string} after buy quota")
    public void setValidateTheDataDetailAfterBuyQuota(String message) {
        if (message.equals("BuyQuotaSuccess")){
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Buy quota success")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("201")));
        }else if (message.equals("ProductNotFound")){
            restAssuredThat(response -> response.body("message", Matchers.equalTo("product quota not found")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("400")));

        }else if (message.equals("ProductEmpty")){
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Product is empty")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("400")));

        }else {
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Full authentication is required to access this resource")));
            restAssuredThat(response -> response.body("'status'", Matchers.equalTo(401)));
        }
    }
}
