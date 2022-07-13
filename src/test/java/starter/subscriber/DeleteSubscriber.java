package starter.subscriber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
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

public class DeleteSubscriber {

    String base_url = "http://44.201.153.46:8081/api/v1/subscribers/";
    String token, emailSubscriber;

    @Step("I set an endpoint for delete subscriber")
    public String setAnEndpointForDeleteSubscriber() throws IOException {
        //      * Catch Email Subscriber
        this.emailSubscriber = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                "/src/test/resources/filejson/emailSubscriber.json"), StandardCharsets.UTF_8);
        System.out.println(this.emailSubscriber);

        return base_url + this.emailSubscriber;
    }

    @Step("I request {string} DELETE subscriber")
    public void setRequestDELETESubscriber(String input) throws IOException {
        if (input.equals("emailHasSubscribe")){
            JSONObject requestBody = new JSONObject();
//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenAdmin.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).delete(setAnEndpointForDeleteSubscriber());

        }else if (input.equals("emailNotSubscribe")){
            JSONObject requestBody = new JSONObject();
//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenAdmin.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).delete("http://44.201.153.46:8081/api/v1/subscribers/a@b.com");
        }else {
            JSONObject requestBody = new JSONObject();

            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + "invalidToken")
                    .body(requestBody.toJSONString()).delete(setAnEndpointForDeleteSubscriber());
        }
    }

    @Step("validate the data detail {string} after delete subscriber")
    public void setValidateTheDataDetailAfterDeleteSubscriber(String message) {
        if (message.equals("DeleteSubsSuccess")){
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Delete subscriber success")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("201")));
        }else if (message.equals("SubscriberNotFound")){
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Subscriber not found")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("400")));
        }else {
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Full authentication is required to access this resource")));
            restAssuredThat(response -> response.body("'status'", Matchers.equalTo(401)));
        }
    }
}
