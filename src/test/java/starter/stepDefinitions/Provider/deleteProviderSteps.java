package starter.stepDefinitions.Provider;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.provider.DeleteProvider;

import java.io.IOException;

public class deleteProviderSteps {

    @Steps
    DeleteProvider deleteProvider;

    @Given("I set an endpoint for delete provider")
    public void iSetAnEndpointForDeleteProvider() throws IOException { deleteProvider.setAnEndpointForDeleteProvider();}

    @When("I request {string} DELETE provider")
    public void iRequestDELETEProvider(String input) throws IOException { deleteProvider.setRequestDELETEProvider(input);}

    @And("validate the data detail {string} after delete provider")
    public void validateTheDataDetailAfterDeleteProvider(String message) { deleteProvider.setValidateTheDataDetailAfterDeleteProvider(message);}
}
