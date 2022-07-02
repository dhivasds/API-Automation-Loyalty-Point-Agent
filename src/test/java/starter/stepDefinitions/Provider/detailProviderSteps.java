package starter.stepDefinitions.Provider;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.provider.DetailProvider;

import java.io.IOException;

public class detailProviderSteps {

    @Steps
    DetailProvider detailProvider;

    @Given("I set an endpoint for provider")
    public void iSetAnEndpointForProvider() { detailProvider.setAnEndpointForProvider();}

    @When("I request {string} GET provider")
    public void iRequestGETProvider(String input) throws IOException { detailProvider.setRequestGETProvider(input);}

    @And("validate the data detail {string} after get detail provider")
    public void validateTheDataDetailAfterGetDetailProvider(String message) { detailProvider.setValidateTheDataDetailAfterGetDetailProvider(message);}

}
