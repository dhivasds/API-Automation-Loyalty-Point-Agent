package starter.quotaProduct;


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

public class AddQuotaProduct {

    String base_url = "http://44.201.153.46:8081/api/v1/products/";
    String token;

    @Step("I set an endpoint for add quota product")
    public String setAnEndpointForAddQuotaProduct() { return base_url + "quota";}

    @Step("I request {string} POST quota product")
    public void seRequestPOSTQuotaProduct(String input) throws IOException {
        if (input.equals("inputValidQuota")){
            JSONObject requestBody = new JSONObject();
            requestBody.put("name", "Quota 55GB");
            requestBody.put("description", "Quota utama 55GB berlaku 1 bulan");
            requestBody.put("provider_id", 1);
            requestBody.put("gross_amount", 151000);
            requestBody.put("stock", 5);

//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenAdmin.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).post(setAnEndpointForAddQuotaProduct());

        }else if (input.equals("inputInvalidProviderId")){
            JSONObject requestBody = new JSONObject();
            requestBody.put("name", "Quota 55GB");
            requestBody.put("description", "Quota utama 55GB berlaku 1 bulan");
            requestBody.put("provider_id", 231);
            requestBody.put("gross_amount", 151000);
            requestBody.put("stock", 5);

//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenAdmin.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).post(setAnEndpointForAddQuotaProduct());

        }else if (input.equals("inputInvalidStock")){
            JSONObject requestBody = new JSONObject();
            requestBody.put("name", "Quota 55GB");
            requestBody.put("description", "Quota utama 55GB berlaku 1 bulan");
            requestBody.put("provider_id", 1);
            requestBody.put("gross_amount", 151000);
            requestBody.put("stock", 0);

//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenAdmin.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).post(setAnEndpointForAddQuotaProduct());

        }else if (input.equals("inputNullProvider")){
            JSONObject requestBody = new JSONObject();
            requestBody.put("name", "Quota 55GB");
            requestBody.put("description", "Quota utama 55GB berlaku 1 bulan");
            requestBody.put("provider_id", null);
            requestBody.put("gross_amount", 151000);
            requestBody.put("stock", 5);

//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenAdmin.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).post(setAnEndpointForAddQuotaProduct());

        }else if (input.equals("inputNullGrossAmount")){
            JSONObject requestBody = new JSONObject();
            requestBody.put("name", "Quota 55GB");
            requestBody.put("description", "Quota utama 55GB berlaku 1 bulan");
            requestBody.put("provider_id", 1);
            requestBody.put("gross_amount", null);
            requestBody.put("stock", 5);

//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenAdmin.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).post(setAnEndpointForAddQuotaProduct());

        }else{
            JSONObject requestBody = new JSONObject();
            requestBody.put("name", "Quota 55GB");
            requestBody.put("description", "Quota utama 55GB berlaku 1 bulan");
            requestBody.put("provider_id", 1);
            requestBody.put("gross_amount", 151000);
            requestBody.put("stock", null);

//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenAdmin.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).post(setAnEndpointForAddQuotaProduct());
        }
    }

    @Step("validate the data detail {string} after add quota product")
    public void setValidateTheDataDetailAfterAddQuotaProduct(String message) {
        if (message.equals("AddQuotaSuccess")){
            //* CATCH ID QUOTA PRODUCT
            Response responseIDQuotaProduct = SerenityRest.lastResponse();
            String getIDQuotaProduct = responseIDQuotaProduct.jsonPath().getString("data.id");
            System.out.println(getIDQuotaProduct);
            try (FileWriter file = new FileWriter("src/test/resources/filejson/idQuotaProduct.json")) {
                file.write(getIDQuotaProduct);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            restAssuredThat(response -> response.body("message", Matchers.equalTo("Add quota product success")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("201")));
        }else if (message.equals("ProviderNotFound")){
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Provider not found")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("400")));
        }else if (message.equals("StockAtLeast")){
            restAssuredThat(response -> response.body("errors[0]", Matchers.equalTo( "stock is at least 1")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("400")));
        }else if (message.equals("ProviderIdRequired")){
            restAssuredThat(response -> response.body("errors[0]", Matchers.equalTo(  "provider_id is required!")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("400")));
        }else if (message.equals("GrossAmountRequired")){
            restAssuredThat(response -> response.body("errors[0]", Matchers.equalTo(   "gross_amount is required!")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("400")));
        }else {
            restAssuredThat(response -> response.body("errors[0]", Matchers.equalTo(   "stock is required!")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("400")));
        }
    }
}
