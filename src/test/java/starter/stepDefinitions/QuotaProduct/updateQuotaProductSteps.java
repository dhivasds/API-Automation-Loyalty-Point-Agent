package starter.stepDefinitions.QuotaProduct;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.quotaProduct.UpdateQuotaProduct;

import java.io.IOException;

public class updateQuotaProductSteps {

    @Steps
    UpdateQuotaProduct updateQuotaProduct;

    @Given("I set an endpoint for update quota product")
    public void iSetAnEndpointForUpdateQuotaProduct() throws IOException { updateQuotaProduct.setAnEndpointForUpdateQuotaProduct();}

    @When("I request {string} PUT quota product")
    public void iRequestPUTQuotaProduct(String input) throws IOException { updateQuotaProduct.seRequestPUTQuotaProduct(input);}

    @And("validate the data detail {string} after update quota product")
    public void validateTheDataDetailAfterUpdateQuotaProduct(String message) { updateQuotaProduct.setValidateTheDataDetailAfterUpdateQuotaProduct(message);}
}
