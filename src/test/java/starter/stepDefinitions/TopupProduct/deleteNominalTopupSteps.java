package starter.stepDefinitions.TopupProduct;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.topupProduct.DeleteNominalTopup;

import java.io.IOException;

public class deleteNominalTopupSteps {

    @Steps
    DeleteNominalTopup deleteNominalTopup;

    @Given("I set an endpoint for delete nominal top up")
    public void iSetAnEndpointForDeleteNominalTopUp() throws IOException { deleteNominalTopup.setAnEndpointForDeleteNominalTopUp();}

    @When("I request {string} DELETE nominal top up")
    public void iRequestDELETENominalTopUp(String input) throws IOException { deleteNominalTopup.setRequestDELETENominalTopUp(input);}

    @And("validate the data detail {string} after delete nominal top up")
    public void validateTheDataDetailAfterDeleteNominalTopUp(String message) { deleteNominalTopup.setValidateTheDataDetailAfterDeleteNominalTopUp(message);}
}
