package starter.stepDefinitions.QuotaProduct;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.quotaProduct.AddQuotaProduct;

import java.io.IOException;

public class addQuotaProductSteps {

    @Steps
    AddQuotaProduct addQuotaProduct;

    @Given("I set an endpoint for add quota product")
    public void iSetAnEndpointForAddQuotaProduct() { addQuotaProduct.setAnEndpointForAddQuotaProduct();}

    @When("I request {string} POST quota product")
    public void iRequestPOSTQuotaProduct(String input) throws IOException { addQuotaProduct.seRequestPOSTQuotaProduct(input);}

    @And("validate the data detail {string} after add quota product")
    public void validateTheDataDetailAfterAddQuotaProduct(String message) { addQuotaProduct.setValidateTheDataDetailAfterAddQuotaProduct(message);}
}
