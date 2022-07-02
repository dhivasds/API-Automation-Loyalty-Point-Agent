package starter.stepDefinitions.User;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.user.DetailProfile;

import java.io.IOException;

public class detailProfileSteps {

    @Steps
    DetailProfile detailProfile;

    @Given("I set an endpoint for user")
    public void iSetAnEndpointForUser() { detailProfile.setAnEndpointForUser();}

    @When("I request {string} GET user")
    public void iRequestGETUser(String input) throws IOException { detailProfile.setRequestGETUser(input);}

    @And("validate the data detail {string} after get detail account")
    public void validateTheDataDetailAfterGetDetailAccount(String message) { detailProfile.setValidateTheDataDetailAfterGetDetailAccount(message);}
}
