package starter.stepDefinitions.Transaction;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.transaction.Pulsa;

import java.io.IOException;

public class pulsaSteps {

    @Steps
    Pulsa pulsa;

    @Given("I set an endpoint for buy pulsa")
    public void iSetAnEndpointForBuyPulsa() { pulsa.setAnEndpointForBuyPulsa();}

    @When("I request {string} POST pulsa")
    public void iRequestPOSTPulsa(String input) throws IOException { pulsa.setRequestPOSTPulsa(input);}

    @And("validate the data detail {string} after buy pulsa")
    public void validateTheDataDetailAfterBuyPulsa(String message) { pulsa.setValidateTheDataDetailAfterBuyPulsa(message);}
}
