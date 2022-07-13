package starter.topupProduct;


import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class AddNominalTopup {

    String base_url = "http://44.201.153.46:8081/api/v1/products/";
    String token;

    @Step("I set an endpoint for add Top up")
    public String setAnEndpointForAddTopUp() { return base_url + "topup";}

    @Step("I request {string} POST add top up")
    public void setRequestPOSTAddTopUp(String input) throws IOException {
        if (input.equals("validToken")){
            JSONObject requestBody = new JSONObject();
            requestBody.put("name", "TOPUP 350K");
            requestBody.put("amount", 350000);
            requestBody.put("gross_amount", 351000);

//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenAdmin.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).post(setAnEndpointForAddTopUp());

        }else if (input.equals("invalidToken")){
            JSONObject requestBody = new JSONObject();
            requestBody.put("name", "TOPUP 350K");
            requestBody.put("amount", 350000);
            requestBody.put("gross_amount", 351000);

            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + "invalidToken")
                    .body(requestBody.toJSONString()).post(setAnEndpointForAddTopUp());

        }else if (input.equals("inputNullAmount")){
            JSONObject requestBody = new JSONObject();
            requestBody.put("name", "TOPUP 350K");
            requestBody.put("amount", null);
            requestBody.put("gross_amount", 51000);

//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenAdmin.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).post(setAnEndpointForAddTopUp());

        }else {
            JSONObject requestBody = new JSONObject();
            requestBody.put("name", "TOPUP 350K");
            requestBody.put("amount", 50000);
            requestBody.put("gross_amount", null);

//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenAdmin.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).post(setAnEndpointForAddTopUp());
        }
    }

    @Step("validate the data detail {string} after add top up")
    public void setValidateTheDataDetailAfterAddTopUp(String message) {
        if (message.equals("AddTopupProduct")){
            //* CATCH ID TOP UP PRODUCT
            Response responseIDProduct = SerenityRest.lastResponse();
            String getIDProduct = responseIDProduct.jsonPath().getString("data.id");
            System.out.println(getIDProduct);
            try (FileWriter file = new FileWriter("src/test/resources/filejson/idTopupProduct.json")) {
                file.write(getIDProduct);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            restAssuredThat(response -> response.body("message", Matchers.equalTo("Add topup product success")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("201")));
        }else if (message.equals("Unauthorized")){
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Full authentication is required to access this resource")));
            restAssuredThat(response -> response.body("'status'", Matchers.equalTo(401)));
        }else if (message.equals("AmountRequired")){
            restAssuredThat(response -> response.body("errors[0]", Matchers.equalTo("amount is required")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("400")));
        }else {
            restAssuredThat(response -> response.body("errors[0]", Matchers.equalTo("gross_amount is required")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("400")));
        }
    }
}
