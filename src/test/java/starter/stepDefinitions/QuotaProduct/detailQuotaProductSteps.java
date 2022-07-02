package starter.stepDefinitions.QuotaProduct;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.quotaProduct.DetailQuotaProduct;

import java.io.IOException;

public class detailQuotaProductSteps {

    @Steps
    DetailQuotaProduct detailQuotaProduct;

    @Given("I set an endpoint for quota product")
    public void iSetAnEndpointForQuotaProduct() { detailQuotaProduct.setAnEndpointForQuotaProduct();}

    @When("I request {string} GET quota product")
    public void iRequestGETQuotaProduct(String input) throws IOException { detailQuotaProduct.setRequestGETQuotaProduct(input);}

    @And("validate the data detail {string} after get detail quota product")
    public void validateTheDataDetailAfterGetDetailQuotaProduct(String message) { detailQuotaProduct.setValidateTheDataDetailAfterGetDetailQuotaProduct(message);}
}
