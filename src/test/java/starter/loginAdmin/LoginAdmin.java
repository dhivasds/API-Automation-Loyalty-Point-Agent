package starter.loginAdmin;


import Utils.General;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class LoginAdmin {
    String base_url = "http://44.201.153.46:8081/api-dev/v1/auth/login/";

    @Steps
    General general;

    @Step("I set an endpoint for login admin")
    public String setAnEndpointForLoginAdmin() {
        return base_url + "admin";
    }

    @Step("I request {string} POST login admin")
    public void setRequestPOSTLoginAdmin(String input) throws IOException {
        if (input.equals("InputValidData")){ //? INPUT VALID DATA
            JSONObject requestBody = new JSONObject();

            requestBody.put("email", "admin@gmail.com");
            requestBody.put("password", "password");

            SerenityRest.given().header("Content-Type", "application/json")
                    .body(requestBody.toJSONString()).post(setAnEndpointForLoginAdmin());


        }else if (input.equals("InputNotRegisteredAccount")){ //? LOGIN WITH NOT REGISTERED ACCOUNT
            JSONObject requestBody = new JSONObject();
            requestBody.put("email", general.randomEmail(input));
            requestBody.put("password", general.randomPassword(input));

            SerenityRest.given().header("Content-Type", "application/json")
                    .body(requestBody.toJSONString()).post(setAnEndpointForLoginAdmin());

        }else if (input.equals("InputInvalidPassword")){ //? LOGIN WITH INVALID PASSWORD
            JSONObject requestBody = new JSONObject();

            requestBody.put("email", "admin@gmail.com");
            requestBody.put("password", "wrongPassword");

            SerenityRest.given().header("Content-Type", "application/json")
                    .body(requestBody.toJSONString()).post(setAnEndpointForLoginAdmin());

        }else if (input.equals("InputPasswordLessCharacters")){ //? INPUT PASSWORD LESS THAN 8 CHARACTERS
            JSONObject requestBody = new JSONObject();

            requestBody.put("email", "admin@gmail.com");
            requestBody.put("password", "rahasia");

            SerenityRest.given().header("Content-Type", "application/json")
                    .body(requestBody.toJSONString()).post(setAnEndpointForLoginAdmin());

        }else if (input.equals("InputInvalidEmail")){ //? LOGIN WITH INVALID EMAIL
            JSONObject requestBody = new JSONObject();

            requestBody.put("email", "admin");
            requestBody.put("password", "adminadmin");

            SerenityRest.given().header("Content-Type", "application/json")
                    .body(requestBody.toJSONString()).post(setAnEndpointForLoginAdmin());

        }else if (input.equals("InputNullEmail")){ //? INPUT NULL EMAIL
            JSONObject requestBody = new JSONObject();

            requestBody.put("email", null);
            requestBody.put("password", "adminadmin");

            SerenityRest.given().header("Content-Type", "application/json")
                    .body(requestBody.toJSONString()).post(setAnEndpointForLoginAdmin());

        }else { //? INPUT NULL PASSWORD
            JSONObject requestBody = new JSONObject();

            requestBody.put("email", "admin@gmail.com");
            requestBody.put("password", null);

            SerenityRest.given().header("Content-Type", "application/json")
                    .body(requestBody.toJSONString()).post(setAnEndpointForLoginAdmin());
        }
    }
}
