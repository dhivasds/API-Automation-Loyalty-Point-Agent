package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class UpdatePassword {

    String base_url = "http://44.201.153.46:8081/api/v1/users/";
    String token,password;

    @Step("I set an endpoint for update password")
    public String setAnEndpointForUpdatePassword() { return base_url + "password";}

    @Step("I request {string} POST update password")
    public void setRequestPOSTUpdatePassword(String input) throws IOException {
        if (input.equals("InputValidToken")){ //? SUCCESSFULLY TO CHANGE PASSWORD
            JSONObject requestBody = new JSONObject();
//           * Catch Email
            this.password = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/password.json"), StandardCharsets.UTF_8);
            System.out.println(this.password);
            requestBody.put("password", this.password);

//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenUser.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).put(setAnEndpointForUpdatePassword());

        }else if (input.equals("InvalidToken")){ //? INVALID TOKEN
            JSONObject requestBody = new JSONObject();
            requestBody.put("password", "Password");
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + "invalidToken")
                    .body(requestBody.toJSONString()).put(setAnEndpointForUpdatePassword());

        }else if (input.equals("InputLessPassword")){ //? INPUT LESS PASSWORD
            JSONObject requestBody = new JSONObject();
            requestBody.put("password", "pass");

//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenUser.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).put(setAnEndpointForUpdatePassword());

        }else if (input.equals("InputNullPassword")){
            JSONObject requestBody = new JSONObject();
            requestBody.put("password", null);

//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenUser.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).put(setAnEndpointForUpdatePassword());
        }


    }

    @Step("validate the data detail {string} after update password")
    public void setValidateTheDataDetailAfterUpdatePassword(String message) {
        if (message.equals("UpdatePasswordSuccess")){
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Update password success")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("201")));
        }else if (message.equals("Unauthorized")){
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Full authentication is required to access this resource")));
            restAssuredThat(response -> response.body("'status'", Matchers.equalTo(401)));
        }else if (message.equals("PasswordInvalid")){
            restAssuredThat(response -> response.body("errors[0]", Matchers.equalTo("The length of password must be at least 8 characters.")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("400")));
        }else {
            restAssuredThat(response -> response.body("errors[0]", Matchers.equalTo("Password is required!")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("400")));
        }
    }
}
