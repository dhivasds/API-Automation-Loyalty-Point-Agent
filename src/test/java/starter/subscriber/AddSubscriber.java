package starter.subscriber;


import Utils.General;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.io.FileUtils;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class AddSubscriber {

    String base_url = "http://44.201.153.46:8081/api/v1/";
    String token, emailSubscriber;

    @Steps
    General general;

    @Step("I set an endpoint for add subscriber")
    public String setAnEndpointForAddSubscriber() { return base_url + "subscribers";}

    @Step("I request {string} POST subscriber")
    public void setRequestPOSTSubscriber(String input) throws IOException {
        if (input.equals("InputRandomEmail")){
            JSONObject requestBody = new JSONObject();
            this.emailSubscriber = general.randomEmail(input);

            requestBody.put("email", this.emailSubscriber);

//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenAdmin.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).post(setAnEndpointForAddSubscriber());

        }else if (input.equals("InputEmailExist")){
            JSONObject requestBody = new JSONObject();
            requestBody.put("email", "user@gmail.com");

//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenAdmin.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).post(setAnEndpointForAddSubscriber());

        }else if (input.equals("InputInvalidEmail")){
            JSONObject requestBody = new JSONObject();
            requestBody.put("email", "user");

//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenAdmin.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).post(setAnEndpointForAddSubscriber());
        }else {
            JSONObject requestBody = new JSONObject();
            requestBody.put("email", null);

//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenAdmin.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).post(setAnEndpointForAddSubscriber());
        }
    }

    @Step("validate the data detail {string} after add subscriber")
    public void setValidateTheDataDetailAfterAddSubscriber(String message) {
        if (message.equals("AddSubscriberSuccess")){
            //* CATCH EMAIL SUBSCRIBER
            Response responseEmailSubs = SerenityRest.lastResponse();
            String getEmailSbus = responseEmailSubs.jsonPath().getString("data.id");
            System.out.println(getEmailSbus);
            try (FileWriter file = new FileWriter("src/test/resources/filejson/emailSubscriber.json")) {
                file.write(this.emailSubscriber);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            restAssuredThat(response -> response.body("message", Matchers.equalTo("Add subscriber success")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("201")));
        }else if (message.equals("EmailHasSubscriber")){
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Already subscribed")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("400")));
        }else if (message.equals("InvalidEmail")){
            restAssuredThat(response -> response.body("errors[0]", Matchers.equalTo("The email address is invalid.")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("400")));
        }else {
            restAssuredThat(response -> response.body("errors[0]", Matchers.equalTo("Email is required!")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("400")));
        }
    }
}
