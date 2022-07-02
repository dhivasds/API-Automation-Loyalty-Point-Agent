package starter.stepDefinitions.Transaction;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.transaction.TopupBank;

import java.io.IOException;

public class topupBankSteps {

    @Steps
    TopupBank topupBank;

    @Given("I set an endpoint for add Top up Bank Transfer")
    public void iSetAnEndpointForAddTopUpBankTransfer() { topupBank.setAnEndpointForAddTopUpBankTransfer();}

    @When("I request {string} POST add top up Bank Transfer")
    public void iRequestPOSTAddTopUpBankTransfer(String input) throws IOException { topupBank.setRequestPOSTAddTopUpBankTransfer(input);}

    @And("validate the data detail {string} after add top up Bank Transfer")
    public void validateTheDataDetailAfterAddTopUpBankTransfer(String message) { topupBank.validateTheDataDetailAfterAddTopUpBankTransfer(message);}
}
