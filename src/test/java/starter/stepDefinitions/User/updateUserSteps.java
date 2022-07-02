package starter.stepDefinitions.User;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.UpdateUser;

import java.io.IOException;

public class updateUserSteps {

    @Steps
    UpdateUser updateUser;

    @Given("I set an endpoint for user update")
    public void iSetAnEndpointForUserUpdate() { updateUser.setAnEndpointForUserUpdate();}

    @When("I request {string} POST user")
    public void iRequestPOSTUser(String input) throws IOException { updateUser.setRequestPOSTUser(input);}

    @And("validate the data detail {string} after update user")
    public void validateTheDataDetailAfterUpdateUser(String message) { updateUser.setValidateTheDataDetailAfterUpdateUser(message);}


}
