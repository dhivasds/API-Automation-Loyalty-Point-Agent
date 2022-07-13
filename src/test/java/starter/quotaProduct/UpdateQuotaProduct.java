package starter.quotaProduct;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
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

public class UpdateQuotaProduct {

    String base_url = "http://44.201.153.46:8081/api/v1/products/quota/";
    String token, IdQuotaProduct;

    @Step("I set an endpoint for update quota product")
    public String setAnEndpointForUpdateQuotaProduct() throws IOException {
//      * Catch ID Quota Product
        this.IdQuotaProduct = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                "/src/test/resources/filejson/idQuotaProduct.json"), StandardCharsets.UTF_8);
        System.out.println(this.IdQuotaProduct);

        return base_url + this.IdQuotaProduct;
    }

    @Step("I request {string} PUT quota product")
    public void seRequestPUTQuotaProduct(String input) throws IOException {
        if (input.equals("inputValidUpdateQuota")){
            JSONObject requestBody = new JSONObject();
            requestBody.put("name", "Quota 55GB");
            requestBody.put("description", "Quota utama 55GB berlaku 1 bulan + 50 SMS ke semua Operator");
            requestBody.put("provider_id", 1);
            requestBody.put("gross_amount", 151000);
            requestBody.put("stock", 15);

//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenAdmin.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).put(setAnEndpointForUpdateQuotaProduct());

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
                    .body(requestBody.toJSONString()).put(setAnEndpointForUpdateQuotaProduct());

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
                    .body(requestBody.toJSONString()).put(setAnEndpointForUpdateQuotaProduct());

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
                    .body(requestBody.toJSONString()).put(setAnEndpointForUpdateQuotaProduct());

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
                    .body(requestBody.toJSONString()).put(setAnEndpointForUpdateQuotaProduct());

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
                    .body(requestBody.toJSONString()).put(setAnEndpointForUpdateQuotaProduct());
        }
    }

    @Step("validate the data detail {string} after update quota product")
    public void setValidateTheDataDetailAfterUpdateQuotaProduct(String message) {
        if (message.equals("UpdateQuotaSuccess")){
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Update quota product success")));
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
