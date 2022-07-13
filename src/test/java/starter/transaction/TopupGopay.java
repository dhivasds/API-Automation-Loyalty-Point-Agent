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

public class TopupGopay {

    String base_url = "http://44.201.153.46:8081/api/v1/transactions/topup/";
    String token;

    @Step("I set an endpoint for add Top up Gopay")
    public String setAnEndpointForAddTopUpGopay() { return base_url + "gopay";}

    @Step("I request {string} POST add top up Gopay")
    public void setRequestPOSTAddTopUpGopay(String input) throws IOException {
        if (input.equals("validToken")) {
            JSONObject requestBody = new JSONObject();
            requestBody.put("product_id", 51);
            requestBody.put("transfer_method", "gopay");

//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenUser.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).post(setAnEndpointForAddTopUpGopay());

        } else {
            if (input.equals("invalidToken")) {
                JSONObject requestBody = new JSONObject();
                requestBody.put("product_id", 51);
                requestBody.put("transfer_method", "gopay");

                SerenityRest.given().header("Content-Type", "application/json")
                        .header("Authorization", "Bearer " + "invalidToken")
                        .body(requestBody.toJSONString()).post(setAnEndpointForAddTopUpGopay());
            }
        }

    }

    @Step("validate the data detail {string} after add top up Gopay")
    public void validateTheDataDetailAfterAddTopUpGopay(String message) {
        if (message.equals("CreateTransaction")){
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Create transaction gopay success")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("201")));
        }else {
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Full authentication is required to access this resource")));
            restAssuredThat(response -> response.body("'status'", Matchers.equalTo(401)));
        }
    }

}
