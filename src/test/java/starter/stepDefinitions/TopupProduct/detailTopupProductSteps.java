package starter.stepDefinitions.TopupProduct;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.topupProduct.DetailTopupProduct;

import java.io.IOException;

public class detailTopupProductSteps {

    @Steps
    DetailTopupProduct detailTopupProduct;

    @Given("I set an endpoint for detail Top up")
    public void iSetAnEndpointForDetailTopUp() { detailTopupProduct.setAnEndpointForDetailTopUp();}

    @When("I request {string} GET detail top up")
    public void iRequestGETDetailTopUp(String input) throws IOException { detailTopupProduct.setRequestGETDetailTopUp(input);}

    @And("validate the data detail {string} after get detail top up")
    public void validateTheDataDetailAfterGetDetailTopUp(String message) { detailTopupProduct.setValidateTheDataDetailAfterGetDetailTopUp(message
    );}
}
