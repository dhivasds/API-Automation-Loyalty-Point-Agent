package starter.provider;


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

public class AddProvider {

    String base_url = "http://44.201.153.46:8081/api/v1/products/";
    String token;

    @Step("I set an endpoint for add provider")
    public String setAnEndpointForAddProvider() { return base_url + "provider";}

    @Step("I request {string} POST provider")
    public void seRequestPOSTProvider(String input) throws IOException {
        if (input.equals("inputValidToken")){
            JSONObject requestBody = new JSONObject();
            requestBody.put("name", "Indosat");

//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenAdmin.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).post(setAnEndpointForAddProvider());

        }else if (input.equals("inputInvalidToken")){
            JSONObject requestBody = new JSONObject();
            requestBody.put("name", "Indosat");

            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + "invalidToken")
                    .body(requestBody.toJSONString()).post(setAnEndpointForAddProvider());

        }else {
            JSONObject requestBody = new JSONObject();
            requestBody.put("name", null);

//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenAdmin.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).post(setAnEndpointForAddProvider());
        }
    }

    @Step("validate the data detail {string} after add provider")
    public void setValidateTheDataDetailAfterAddProvider(String message) {
        if (message.equals("AddProviderSuccess")){
            //* CATCH ID PROVIDER
            Response responseIDProvider = SerenityRest.lastResponse();
            String getIDProvider = responseIDProvider.jsonPath().getString("data.id");
            System.out.println(getIDProvider);
            try (FileWriter file = new FileWriter("src/test/resources/filejson/idProvider.json")) {
                file.write(getIDProvider);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            restAssuredThat(response -> response.body("message", Matchers.equalTo("Add provider success")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("201")));

        }else if (message.equals("Unauthorized")){
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Full authentication is required to access this resource")));
            restAssuredThat(response -> response.body("'status'", Matchers.equalTo(401)));
        }else {
            restAssuredThat(response -> response.body("errors[0]", Matchers.equalTo("name is required!")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("400")));
        }
    }

}
