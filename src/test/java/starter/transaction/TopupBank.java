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

public class TopupBank {
    String base_url = "http://44.201.153.46:8081/api-dev/v1/topup/transactions/";
    String token;

    @Step("I set an endpoint for add Top up Bank Transfer")
    public String setAnEndpointForAddTopUpBankTransfer() { return base_url + "bank-transfer";}

    @Step("I request {string} POST add top up Bank Transfer")
    public void setRequestPOSTAddTopUpBankTransfer(String input) throws IOException {
        if (input.equals("validToken")) {
            JSONObject requestBody = new JSONObject();
            requestBody.put("product_type", "topup");
            requestBody.put("product_id", 1);
            requestBody.put("gross_amount", 101000);
            requestBody.put("transfer_method", "bca");

//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenUser.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).post(setAnEndpointForAddTopUpBankTransfer());

        } else {
            if (input.equals("invalidToken")) {
                JSONObject requestBody = new JSONObject();
                requestBody.put("product_type", "topup");
                requestBody.put("product_id", 1);
                requestBody.put("gross_amount", 101000);
                requestBody.put("transfer_method", "bca");

                SerenityRest.given().header("Content-Type", "application/json")
                        .header("Authorization", "Bearer " + "invalidToken")
                        .body(requestBody.toJSONString()).post(setAnEndpointForAddTopUpBankTransfer());
            }
        }

    }

    @Step("validate the data detail {string} after add top up Bank Transfer")
    public void validateTheDataDetailAfterAddTopUpBankTransfer(String message) {
        if (message.equals("CreateTransaction")){
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Create transaction bank transfer success")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("201")));
        }else {
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Full authentication is required to access this resource")));
            restAssuredThat(response -> response.body("'status'", Matchers.equalTo(401)));
        }
    }
}
