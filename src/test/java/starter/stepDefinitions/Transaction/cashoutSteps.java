package starter.stepDefinitions.Transaction;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.transaction.Cashout;

import java.io.IOException;

public class cashoutSteps {

    @Steps
    Cashout cashout;

    @Given("I set an endpoint for cashout")
    public void iSetAnEndpointForCashout() { cashout.setAnEndpointForCashout();}

    @When("I request {string} POST cashout")
    public void iRequestPOSTCashout(String input) throws IOException { cashout.setRequestPOSTCashout(input);}

    @And("validate the data detail {string} after cashout")
    public void validateTheDataDetailAfterCashout(String message) { cashout.setValidateTheDataDetailAfterCashout(message);}
}
