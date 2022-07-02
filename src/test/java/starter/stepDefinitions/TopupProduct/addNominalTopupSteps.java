package starter.stepDefinitions.TopupProduct;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.topupProduct.AddNominalTopup;

import java.io.IOException;

public class addNominalTopupSteps {

    @Steps
    AddNominalTopup addNominalTopup;

    @Given("I set an endpoint for add Top up")
    public void iSetAnEndpointForAddTopUp() { addNominalTopup.setAnEndpointForAddTopUp();}

    @When("I request {string} POST add top up")
    public void iRequestPOSTAddTopUp(String input) throws IOException { addNominalTopup.setRequestPOSTAddTopUp(input);}

    @And("validate the data detail {string} after add top up")
    public void validateTheDataDetailAfterAddTopUp(String message) { addNominalTopup.setValidateTheDataDetailAfterAddTopUp(message);}
}
