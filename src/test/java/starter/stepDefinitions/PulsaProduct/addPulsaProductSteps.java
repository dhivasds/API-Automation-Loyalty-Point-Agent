package starter.stepDefinitions.PulsaProduct;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pulsaProduct.AddPulsaProduct;

import java.io.IOException;

public class addPulsaProductSteps {

    @Steps
    AddPulsaProduct addPulsaProduct;

    @Given("I set an endpoint for add pulsa product")
    public void iSetAnEndpointForAddPulsaProduct() { addPulsaProduct.setAnEndpointForAddPulsaProduct();}

    @When("I request {string} POST pulsa product")
    public void iRequestPOSTPulsaProduct(String input) throws IOException { addPulsaProduct.setRquestPOSTPulsaProduct(input);}

    @And("validate the data detail {string} after add pulsa product")
    public void validateTheDataDetailAfterAddPulsaProduct(String message) { addPulsaProduct.setValidateTheDataDetailAfterAddPulsaProduct(message);}
}
