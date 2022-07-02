package starter.stepDefinitions.Transaction;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.transaction.TopupGopay;

import java.io.IOException;

public class topupGopaySteps {

    @Steps
    TopupGopay topupGopay;

    @Given("I set an endpoint for add Top up Gopay")
    public void iSetAnEndpointForAddTopUpGopay() { topupGopay.setAnEndpointForAddTopUpGopay();}

    @When("I request {string} POST add top up Gopay")
    public void iRequestPOSTAddTopUpGopay(String input) throws IOException { topupGopay.setRequestPOSTAddTopUpGopay(input);}

    @And("validate the data detail {string} after add top up Gopay")
    public void validateTheDataDetailAfterAddTopUpGopay(String message) { topupGopay.validateTheDataDetailAfterAddTopUpGopay(message);}


}
