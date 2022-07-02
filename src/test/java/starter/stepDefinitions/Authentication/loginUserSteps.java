package starter.stepDefinitions.Authentication;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.loginUser.LoginUser;

import java.io.IOException;

public class loginUserSteps {

    @Steps
    LoginUser loginUser;

    @Given("I set an endpoint for login user")
    public void iSetAnEndpointForLoginUser() {
        loginUser.setAnEndpointForLoginUser();
    }

    @When("I request {string} POST login user")
    public void iRequestPOSTLoginUser(String input) throws IOException {
        loginUser.setRequestPOSTLoginUser(input);
    }

    @And("validate the data detail {string} after login")
    public void validateTheDataDetailAfterLogin(String message) {
        loginUser.setValidateTheDataDetailAfterLogin(message);
    }
}
