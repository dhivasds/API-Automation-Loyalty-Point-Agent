package starter.stepDefinitions.Transaction;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.transaction.Quota;

import java.io.IOException;

public class QuotaSteps {

    @Steps
    Quota quota;

    @Given("I set an endpoint for buy quota")
    public void iSetAnEndpointForBuyQuota() { quota.setAnEndpointForBuyQuota();}

    @When("I request {string} POST quota")
    public void iRequestPOSTQuota(String input) throws IOException { quota.setRequestPOSTQuota(input);}

    @And("validate the data detail {string} after buy quota")
    public void validateTheDataDetailAfterBuyQuota(String message) { quota.setValidateTheDataDetailAfterBuyQuota(message);}
}
