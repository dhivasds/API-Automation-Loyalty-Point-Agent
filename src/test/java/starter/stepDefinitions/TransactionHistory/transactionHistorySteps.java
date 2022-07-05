package starter.stepDefinitions.TransactionHistory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.transactionHistory.TransactionHistory;

import java.io.IOException;

public class transactionHistorySteps {

    @Steps
    TransactionHistory transactionHistory;

    @Given("I set an endpoint for detail transaction history")
    public void iSetAnEndpointForDetailTransactionHistory() { transactionHistory.setAnEndpointForDetailTransactionHistory();}

    @When("I request {string} GET transaction history")
    public void iRequestGETTransactionHistory(String input) throws IOException { transactionHistory.setRequestGETTransactionHistory(input);}

    @And("validate the data detail {string} after get detail transaction history")
    public void validateTheDataDetailAfterGetDetailTransactionHistory(String message) { transactionHistory.setValidateTheDataDetailAfterGetDetailTransactionHistory(message);}
}
