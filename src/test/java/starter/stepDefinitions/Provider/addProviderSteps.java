package starter.stepDefinitions.Provider;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.provider.AddProvider;

import java.io.IOException;

public class addProviderSteps {

    @Steps
    AddProvider addProvider;

    @Given("I set an endpoint for add provider")
    public void iSetAnEndpointForAddProvider() { addProvider.setAnEndpointForAddProvider();}

    @When("I request {string} POST provider")
    public void iRequestPOSTProvider(String input) throws IOException { addProvider.seRequestPOSTProvider(input);}

    @And("validate the data detail {string} after add provider")
    public void validateTheDataDetailAfterAddProvider(String message) { addProvider.setValidateTheDataDetailAfterAddProvider(message);}
}
