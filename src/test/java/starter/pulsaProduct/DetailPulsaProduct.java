package starter.pulsaProduct;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.apache.commons.io.FileUtils;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DetailPulsaProduct {

    String base_url = "http://44.201.153.46:8081/api/v1/products/";
    String token;

    @Step("I set an endpoint for pulsa product")
    public String setAnEndpointForPulsaProduct() { return base_url + "pulsa";}

    @Step("I request {string} GET pulsa product")
    public void setRequestGETPulsaProduct(String input) throws IOException {
        if (input.equals("inputValidToken")){
            JSONObject requestBody = new JSONObject();
//           * Catch Token
            this.token = FileUtils.readFileToString(new File(System.getProperty("user.dir") +
                    "/src/test/resources/filejson/tokenUser.json"), StandardCharsets.UTF_8);
            System.out.println(this.token);
//           * Put Token in header
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + this.token)
                    .body(requestBody.toJSONString()).get(setAnEndpointForPulsaProduct());

        }else {
            JSONObject requestBody = new JSONObject();
            SerenityRest.given().header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + "invalidToken")
                    .body(requestBody.toJSONString()).get(setAnEndpointForPulsaProduct());
        }
    }

    @Step("validate the data detail {string} after get detail pulsa product")
    public void setValidateTheDataDetailAfterGetDetailPulsaProduct(String message) {
        if (message.equals("DetailPulsaProduct")){
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Get pulsa product success")));
            restAssuredThat(response -> response.body("code", Matchers.equalTo("200")));
        }else {
            restAssuredThat(response -> response.body("message", Matchers.equalTo("Full authentication is required to access this resource")));
            restAssuredThat(response -> response.body("'status'", Matchers.equalTo(401)));
        }
    }
}
