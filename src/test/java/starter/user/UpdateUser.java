package starter.user;


import Utils.General;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.io.FileUtils;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class UpdateUser {

    String base_url = "http://44.201.153.46:8081/api/v1/";
    String token, email, phoneNumber, randomPhoneNumber;

    @Steps
    General general;

    @Step("I set an endpoint for user update")
    public String setAnEndpointForUserUpdate() { return base_url + "users";}

    @Step("I request {string} POST user")
    public void setRequestPOSTUser(String input) throws IOException {
        if (input.equals("inputValidToken")){ //? INPUT VALID TOKEN
            JSONObject requestBody = new JSONObject();
//          * Catch Email
            this.email = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/email.json"), StandardCharsets.UTF_8);
            System.out.println(this.email);

 //          * Catch Phone Numbers
            this.phoneNumber = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/phoneNumber.json"), StandardCharsets.UTF_8);
            System.out.println(this.phoneNumber);

            requestBody.put("name", "Name has change");
            requestBody.put("email", this.email);
            requestBody.put("phone", this.phoneNumber);
//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenUser.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).put(setAnEndpointForUserUpdate());

        }else if (input.equals("inputInvalidToken")){ //? INPUT INVALID TOKEN
            JSONObject requestBody = new JSONObject();

            requestBody.put("name", "Name has change");
            requestBody.put("email", "change@mail.com");
            requestBody.put("phone", "087778855522");

//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + "invalidToken")
                    .body(requestBody.toJSONString()).put(setAnEndpointForUserUpdate());

        }else{ //? INPUT EMAIL EXIST
            JSONObject requestBody = new JSONObject();
            this.randomPhoneNumber = general.randomPhoneNumbers(input);
//           * Catch Email
            this.email = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/email.json"), StandardCharsets.UTF_8);
            System.out.println(this.email);

            requestBody.put("name", "Name has change");
            requestBody.put("email", "user102@gmail.com");
            requestBody.put("phone", this.randomPhoneNumber);

//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenUser.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).put(setAnEndpointForUserUpdate());
        }
    }

    @Step("validate the data detail {string} after update user")
    public void setValidateTheDataDetailAfterUpdateUser(String message) {
        if (message.equals("updateSuccess")){
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Update user success")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("201")));
        }else if (message.equals("unauthorized")){
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Full authentication is required to access this resource")));
            restAssuredThat(response -> response.body("'status'", Matchers.equalTo(401)));
        }else {
            restAssuredThat(response -> response.body("message", Matchers.equalTo("User with email user102@gmail.com exist")));
            restAssuredThat(response -> response.body("'code'", Matchers.equalTo("400")));
        }
    }
}
