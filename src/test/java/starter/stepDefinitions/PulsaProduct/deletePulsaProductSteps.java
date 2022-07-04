package starter.stepDefinitions.PulsaProduct;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pulsaProduct.DeletePulsaProduct;

import java.io.IOException;

public class deletePulsaProductSteps {

    @Steps
    DeletePulsaProduct deletePulsaProduct;

    @Given("I set an endpoint for delete pulsa product")
    public void iSetAnEndpointForDeletePulsaProduct() throws IOException { deletePulsaProduct.setAnEndpointForDeletePulsaProduct();}

    @When("I request {string} DELETE pulsa product")
    public void iRequestDELETEPulsaProduct(String input) throws IOException { deletePulsaProduct.setRequestDELETEPulsaProduct(input);}

    @And("validate the data detail {string} after delete pulsa product")
    public void validateTheDataDetailAfterDeletePulsaProduct(String message) { deletePulsaProduct.setValidateTheDataDetailAfterDeletePulsaProduct(message);}
}
