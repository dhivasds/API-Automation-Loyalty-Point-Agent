package starter.stepDefinitions.PulsaProduct;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pulsaProduct.DetailPulsaProduct;

import java.io.IOException;

public class detailPulsaProductSteps {

    @Steps
    DetailPulsaProduct detailPulsaProduct;

    @Given("I set an endpoint for pulsa product")
    public void iSetAnEndpointForPulsaProduct() { detailPulsaProduct.setAnEndpointForPulsaProduct();}

    @When("I request {string} GET pulsa product")
    public void iRequestGETPulsaProduct(String input) throws IOException { detailPulsaProduct.setRequestGETPulsaProduct(input);}

    @And("validate the data detail {string} after get detail pulsa product")
    public void validateTheDataDetailAfterGetDetailPulsaProduct(String message) { detailPulsaProduct.setValidateTheDataDetailAfterGetDetailPulsaProduct(message);}
}
