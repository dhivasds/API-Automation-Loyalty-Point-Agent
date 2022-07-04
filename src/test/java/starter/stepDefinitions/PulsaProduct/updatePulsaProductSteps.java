package starter.stepDefinitions.PulsaProduct;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pulsaProduct.UpdatePulsaProduct;

import java.io.IOException;

public class updatePulsaProductSteps {

    @Steps
    UpdatePulsaProduct updatePulsaProduct;

    @Given("I set an endpoint for update pulsa product")
    public void iSetAnEndpointForUpdatePulsaProduct() throws IOException { updatePulsaProduct.iSetAnEndpointForUpdatePulsaProduct();}

    @When("I request {string} PUT pulsa product")
    public void iRequestPUTPulsaProduct(String input) throws IOException { updatePulsaProduct.iRequestPUTPulsaProduct(input);}

    @And("validate the data detail {string} after update pulsa product")
    public void validateTheDataDetailAfterUpdatePulsaProduct(String message) { updatePulsaProduct.validateTheDataDetailAfterUpdatePulsaProduct(message);}
}
