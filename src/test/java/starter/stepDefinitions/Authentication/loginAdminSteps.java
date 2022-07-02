package starter.stepDefinitions.Authentication;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.loginAdmin.LoginAdmin;

import java.io.IOException;

public class loginAdminSteps {

    @Steps
    LoginAdmin loginAdmin;

    @Given("I set an endpoint for login admin")
    public void iSetAnEndpointForLoginAdmin() {
        loginAdmin.setAnEndpointForLoginAdmin();
    }

    @When("I request {string} POST login admin")
    public void iRequestPOSTLoginAdmin(String input) throws IOException {
        loginAdmin.setRequestPOSTLoginAdmin(input);
    }
}
