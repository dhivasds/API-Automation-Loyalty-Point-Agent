package starter.stepDefinitions.User;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.DeleteAccount;

import java.io.IOException;

public class deleteAccountSteps {

    @Steps
    DeleteAccount deleteAccount;

    @Given("I set an endpoint for delete user")
    public void iSetAnEndpointForDeleteUser() { deleteAccount.setAnEndpointForDeleteUser();}

    @When("I request {string} DELETE user")
    public void iRequestDELETEUser(String input) throws IOException { deleteAccount.setRequestDELETEUser(input);}

    @And("validate the data detail {string} after delete account")
    public void validateTheDataDetailAfterDeleteAccount(String message) { deleteAccount.setValidateTheDataDetailAfterDeleteAccount(message);}
}
