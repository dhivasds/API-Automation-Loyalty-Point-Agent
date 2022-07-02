package starter.stepDefinitions.User;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.UpdatePassword;

import java.io.IOException;

public class updatePasswordSteps {

    @Steps
    UpdatePassword updatePassword;

    @Given("I set an endpoint for update password")
    public void iSetAnEndpointForUpdatePassword() { updatePassword.setAnEndpointForUpdatePassword();}

    @When("I request {string} POST update password")
    public void iRequestPOSTUpdatePassword(String input) throws IOException { updatePassword.setRequestPOSTUpdatePassword(input);}

    @And("validate the data detail {string} after update password")
    public void validateTheDataDetailAfterUpdatePassword(String message) { updatePassword.setValidateTheDataDetailAfterUpdatePassword(message);}
}
