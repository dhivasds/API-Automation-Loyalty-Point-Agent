package starter.authentication;

import Utils.General;
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

public class Register {
    String base_url = "http://44.201.153.46:8081/api/v1/auth/";
    String email, password, name, phoneNumber;

    @Steps
    General general;

    @Step("I set an endpoint for register")
    public String setAnEndpointForRegister() {
        return base_url + "register";
    }

    @Step("I request {string} POST register")
    public void setRequestPOSTRegister(String input) throws IOException {
        if (input.equals("InputValidRegister")) { //? VALID REGISTER
            JSONObject requestBody = new JSONObject();
            this.name = general.randomName(input);
            this.email = general.randomEmail(input);
            this.password = general.randomPassword(input);
            this.phoneNumber = general.randomPhoneNumbers(input);

            try (FileWriter file = new FileWriter("src/test/resources/filejson/email.json")) {
                file.write(this.email);
                file.flush();
            }
            try (FileWriter file = new FileWriter("src/test/resources/filejson/password.json")) {
                file.write(this.password);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (FileWriter file = new FileWriter("src/test/resources/filejson/phoneNumber.json")) {
                file.write(this.phoneNumber);
            } catch (IOException e) {
                e.printStackTrace();
            }

            requestBody.put("name", this.name);
            requestBody.put("email", this.email);
            requestBody.put("password", this.password);
            requestBody.put("phone", this.phoneNumber);

            SerenityRest.given().header("Content-Type", "application/json")
                    .body(requestBody.toJSONString()).post(setAnEndpointForRegister());

        } else if (input.equals("InputSameData")) { //? INPUT SAME DATA
            JSONObject requestBody = new JSONObject();

            this.email = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/email.json"), StandardCharsets.UTF_8);
            this.password = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/password.json"), StandardCharsets.UTF_8);

            requestBody.put("name", "Dhivas Dharma");
            requestBody.put("email", this.email);
            requestBody.put("password", this.password);
            requestBody.put("phone", "08785858555");

            SerenityRest.given().header("Content-Type", "application/json")
                    .body(requestBody.toJSONString()).post(setAnEndpointForRegister());

        } else if (input.equals("InputInvalidEmail")) { //? INPUT INVALID EMAIL
            JSONObject requestBody = new JSONObject();
            requestBody.put("name", "Dhivas Dharma");
            requestBody.put("email", "dhivas");
            requestBody.put("password", "passwordrahasia");
            requestBody.put("phone", "08785858555");

            SerenityRest.given().header("Content-Type", "application/json")
                    .body(requestBody.toJSONString()).post(setAnEndpointForRegister());

        } else if (input.equals("InputPasswordLessCharacters")) { //? INPUT PASSWORD LESS THAN 8 CHARACTERS
            JSONObject requestBody = new JSONObject();

            requestBody.put("name", "Dhivas Dharma");
            requestBody.put("email", general.randomEmail(input));
            requestBody.put("password", "rahasia");
            requestBody.put("phone", "08785858555");

            SerenityRest.given().header("Content-Type", "application/json")
                    .body(requestBody.toJSONString()).post(setAnEndpointForRegister());

        } else if (input.equals("InputPhoneLessNumbers")) { //? INPUT NUMBER LESS THAN 10 NUMBERS
            JSONObject requestBody = new JSONObject();

            requestBody.put("name", "Dhivas Dharma");
            requestBody.put("email", general.randomEmail(input));
            requestBody.put("password", "passwordrahasia");
            requestBody.put("phone", "08785");

            SerenityRest.given().header("Content-Type", "application/json")
                    .body(requestBody.toJSONString()).post(setAnEndpointForRegister());

        } else if (input.equals("InputNullName")) { //? INPUT NULL NAME
            JSONObject requestBody = new JSONObject();

            requestBody.put("name", null);
            requestBody.put("email", general.randomEmail(input));
            requestBody.put("password", "passwordrahasia");
            requestBody.put("phone", "08785858555");

            SerenityRest.given().header("Content-Type", "application/json")
                    .body(requestBody.toJSONString()).post(setAnEndpointForRegister());

        } else if (input.equals("InputNullEmail")) { //? INPUT NULL EMAIL
            JSONObject requestBody = new JSONObject();

            requestBody.put("name", "Dhivas Dharma");
            requestBody.put("email", null);
            requestBody.put("password", "passwordrahasia");
            requestBody.put("phone", "08785858555");

            SerenityRest.given().header("Content-Type", "application/json")
                    .body(requestBody.toJSONString()).post(setAnEndpointForRegister());

        } else if (input.equals("InputNullPassword")) { //? INPUT NULL PASSWORD
            JSONObject requestBody = new JSONObject();

            requestBody.put("name", "Dhivas Dharma");
            requestBody.put("email", general.randomEmail(input));
            requestBody.put("password", null);
            requestBody.put("phone", "08785858555");

            SerenityRest.given().header("Content-Type", "application/json")
                    .body(requestBody.toJSONString()).post(setAnEndpointForRegister());

        } else if (input.equals("InputNullPhone")){ //? INPUT NULL PHONE
            JSONObject requestBody = new JSONObject();

            requestBody.put("name", "Dhivas Dharma");
            requestBody.put("email", general.randomEmail(input));
            requestBody.put("password", "passwordrahasia");
            requestBody.put("phone", null);

            SerenityRest.given().header("Content-Type", "application/json")
                    .body(requestBody.toJSONString()).post(setAnEndpointForRegister());

        } else { //? INPUT PHONE WITH CHARACTERS
            JSONObject requestBody = new JSONObject();

            requestBody.put("name", "Dhivas Dharma");
            requestBody.put("email", general.randomEmail(input));
            requestBody.put("password", "passwordrahasia");
            requestBody.put("phone", "IniPhoneNumbers");

            SerenityRest.given().header("Content-Type", "application/json")
                    .body(requestBody.toJSONString()).post(setAnEndpointForRegister());

        }
    }

    @Step("I validate the status code is {string}")
    public void setValidateTheStatusCodeIs(String sCode) {
        if (sCode.equals("201")) {
            restAssuredThat(response -> response.statusCode(201));
        } else if (sCode.equals("200")) {
            restAssuredThat(response -> response.statusCode(200));
        } else if (sCode.equals("401")) {
            restAssuredThat(response -> response.statusCode(401));
        }else {
            restAssuredThat(response -> response.statusCode(400));
        }
    }

    @Step("validate the data detail {string} after register")
    public void setValidateTheDataDetailAfterRegister(String message) throws IOException {
        if (message.equals("AccountRegister")) {
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Add User success")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("201")));

        } else if (message.equals("UserExists")) {
            this.email = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/email.json"), StandardCharsets.UTF_8);
            restAssuredThat(response -> response.body("message", Matchers.equalTo("User with email " + this.email + " exist")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("400")));

        } else if (message.equals("EmailInvalid")) {
            restAssuredThat(response -> response.body("errors[0]", Matchers.equalTo("The email address is invalid.")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("400")));

        } else if (message.equals("PasswordInvalid")) {
            restAssuredThat(response -> response.body("errors[0]", Matchers.equalTo("The length of password must be at least 8 characters.")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("400")));

        } else if (message.equals("PhoneInvalid")) {
            restAssuredThat(response -> response.body("errors[0]", Matchers.equalTo("The length of phone must be between 10 and 18 characters.")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("400")));

        } else if (message.equals("NameRequired")) {
            restAssuredThat(response -> response.body("errors[0]", Matchers.equalTo("Name is required!")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("400")));

        } else if (message.equals("EmailRequired")) {
            restAssuredThat(response -> response.body("errors[0]", Matchers.equalTo("Email is required!")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("400")));

        } else if (message.equals("PasswordRequired")) {
            restAssuredThat(response -> response.body("errors[0]", Matchers.equalTo("Password is required!")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("400")));

        } else if (message.equals("PhoneRequired")){
            restAssuredThat(response -> response.body("errors[0]", Matchers.equalTo("Phone is required!")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("400")));

        } else {
            restAssuredThat(response -> response.body("errors[0]", Matchers.equalTo("Phone value must be number")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("400")));
        }
    }
}