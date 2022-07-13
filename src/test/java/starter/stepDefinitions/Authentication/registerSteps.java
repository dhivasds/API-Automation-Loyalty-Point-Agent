package starter.stepDefinitions.Authentication;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.authentication.Register;

import java.io.IOException;

public class registerSteps {

    @Steps
    Register register;

    @Given("I set an endpoint for register")
    public void iSetAnEndpointForRegister() {
        register.setAnEndpointForRegister();
    }

    @When("I request {string} POST register")
    public void iRequestPOSTRegister(String input) throws IOException {
        register.setRequestPOSTRegister(input);
    }

    @Then("I validate the status code is {string}")
    public void iValidateTheStatusCodeIs(String sCode) {
        register.setValidateTheStatusCodeIs(sCode);
    }

    @And("validate the data detail {string} after register")
    public void validateTheDataDetailAfterRegister(String message) throws IOException {
        register.setValidateTheDataDetailAfterRegister(message);
    }
}
