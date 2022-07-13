package starter.dailyLogin;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class ClaimDailyLogin {
    String base_url = "http://44.201.153.46:8081/api/v1/";
    String token;

    @Step("I set an endpoint for daily login")
    public String setAnEndpointForDailyLogin() { return base_url + "daily";}

    @Step("I request {string} POST daily login")
    public void setRequestPOSTDailyLogin(String input) throws IOException {
        if (input.equals("validToken")){
            JSONObject requestBody = new JSONObject();
//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenUser.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).post(setAnEndpointForDailyLogin());

        }else {
            JSONObject requestBody = new JSONObject();
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + "invalidToken")
                    .body(requestBody.toJSONString()).post(setAnEndpointForDailyLogin());
        }
    }

    @Step("validate the data detail {string} after claim daily login")
    public void setValidateTheDataDetailAfterClaimDailyLogin(String message) {
        if (message.equals("ClaimDailyLogin")){
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Claim daily login success")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("201")));
        }else {
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Full authentication is required to access this resource")));
            restAssuredThat(response -> response.body("'status'", Matchers.equalTo(401)));
        }
    }
}
