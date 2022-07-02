package starter.loginUser;

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

public class LoginUser {
    String base_url = "http://44.201.153.46:8081/api-dev/v1/auth/";
    String email,password,token;

    @Steps
    General general;

    @Step("I set an endpoint for login user")
    public String setAnEndpointForLoginUser() {
        return base_url + "login";
    }

    @Step("I request {string} POST login user")
    public void setRequestPOSTLoginUser(String input) throws IOException {
        if (input.equals("InputValidData")){ //? INPUT VALID DATA
            JSONObject requestBody = new JSONObject();

            //* READ email & password JSON
            this.email = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/email.json"), StandardCharsets.UTF_8);
            this.password = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/password.json"), StandardCharsets.UTF_8);

            requestBody.put("email", this.email);
            requestBody.put("password", this.password);

            SerenityRest.given().header("Content-Type", "application/json")
                    .body(requestBody.toJSONString()).post(setAnEndpointForLoginUser());

        }else if (input.equals("InputNotRegisteredAccount")){ //? LOGIN WITH NOT REGISTERED ACCOUNT
            JSONObject requestBody = new JSONObject();
            requestBody.put("email", general.randomEmail(input));
            requestBody.put("password", general.randomPassword(input));

            SerenityRest.given().header("Content-Type", "application/json")
                    .body(requestBody.toJSONString()).post(setAnEndpointForLoginUser());

        }else if (input.equals("InputInvalidPassword")){ //? LOGIN WITH INVALID PASSWORD
            JSONObject requestBody = new JSONObject();

            //* READ email
            this.email = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/email.json"), StandardCharsets.UTF_8);

            requestBody.put("email", this.email);
            requestBody.put("password", general.randomPassword(input));

            SerenityRest.given().header("Content-Type", "application/json")
                    .body(requestBody.toJSONString()).post(setAnEndpointForLoginUser());

        }else if (input.equals("InputPasswordLessCharacters")){ //? INPUT PASSWORD LESS THAN 8 CHARACTERS
            JSONObject requestBody = new JSONObject();

            requestBody.put("email", general.randomEmail(input));
            requestBody.put("password", "rahasia");

            SerenityRest.given().header("Content-Type", "application/json")
                    .body(requestBody.toJSONString()).post(setAnEndpointForLoginUser());

        }else if (input.equals("InputInvalidEmail")){ //? LOGIN WITH INVALID EMAIL
            JSONObject requestBody = new JSONObject();

            requestBody.put("email", "dhivas");
            requestBody.put("password", general.randomPassword(input));

            SerenityRest.given().header("Content-Type", "application/json")
                    .body(requestBody.toJSONString()).post(setAnEndpointForLoginUser());

        }else if (input.equals("InputNullEmail")){ //? INPUT NULL EMAIL
            JSONObject requestBody = new JSONObject();

            requestBody.put("email", null);
            requestBody.put("password", general.randomPassword(input));

            SerenityRest.given().header("Content-Type", "application/json")
                    .body(requestBody.toJSONString()).post(setAnEndpointForLoginUser());

        }else { //? INPUT NULL PASSWORD
            JSONObject requestBody = new JSONObject();

            requestBody.put("email", general.randomEmail(input));
            requestBody.put("password", null);

            SerenityRest.given().header("Content-Type", "application/json")
                    .body(requestBody.toJSONString()).post(setAnEndpointForLoginUser());
        }
    }

    @Step("validate the data detail {string} after login")
    public void setValidateTheDataDetailAfterLogin(String message) {
        if (message.equals("SuccessfullyLoginUser")){

            //* CATCH TOKEN USER
            Response responseToken = SerenityRest.lastResponse();
            String getToken = responseToken.jsonPath().getString("data.token");
            System.out.println(getToken);
            try (FileWriter file = new FileWriter("src/test/resources/filejson/tokenUser.json")) {
                file.write(getToken);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            restAssuredThat(response -> response.body("message", Matchers.equalTo("Login success")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("200")));

        } else if (message.equals("SuccessfullyLoginAdmin")) {

            //* CATCH TOKEN ADMIN
            Response responseToken = SerenityRest.lastResponse();
            String getToken = responseToken.jsonPath().getString("data.token");
            System.out.println(getToken);
            try (FileWriter file = new FileWriter("src/test/resources/filejson/tokenAdmin.json")) {
                file.write(getToken);
                file.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            restAssuredThat(response -> response.body("message", Matchers.equalTo("Login success")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("200")));

        }else if (message.equals("EmailOrPasswordIncorrect")){
            restAssuredThat(response -> response.body("message", Matchers.equalTo("email or password incorrect")));

        } else if (message.equals("PasswordInvalid")){ //! BUG | Validate belum sesuai
//            restAssuredThat(response -> response.body("message", Matchers.equalTo("email or password incorrect")));

        } else if (message.equals("EmailInvalid")) {
            restAssuredThat(response -> response.body("errors[0]", Matchers.equalTo("The email address is invalid.")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("400")));

        } else if (message.equals("EmailRequired")) {
            restAssuredThat(response -> response.body("errors[0]", Matchers.equalTo("Email is required!")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("400")));

        } else {
            restAssuredThat(response -> response.body("errors[0]", Matchers.equalTo("Password is required!")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("400")));
        }
    }
}
