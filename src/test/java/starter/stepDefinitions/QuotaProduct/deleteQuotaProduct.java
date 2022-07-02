package starter.stepDefinitions.QuotaProduct;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.quotaProduct.DeleteQuotaProduct;

import java.io.IOException;

public class deleteQuotaProduct {

    @Steps
    DeleteQuotaProduct deleteQuotaProduct;

    @Given("I set an endpoint for delete quota product")
    public void iSetAnEndpointForDeleteQuotaProduct() throws IOException { deleteQuotaProduct.setAnEndpointForDeleteQuotaProduct();}

    @When("I request {string} DELETE quota product")
    public void iRequestDELETEQuotaProduct(String input) throws IOException { deleteQuotaProduct.seRequestDELETEQuotaProduct(input);}

    @And("validate the data detail {string} after delete quota product")
    public void validateTheDataDetailAfterDeleteQuotaProduct(String message) { deleteQuotaProduct.setValidateTheDataDetailAfterDeleteQuotaProduct(message);}
}
