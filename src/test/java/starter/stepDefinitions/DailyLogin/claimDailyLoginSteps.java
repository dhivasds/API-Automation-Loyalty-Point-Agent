package starter.stepDefinitions.DailyLogin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.dailyLogin.ClaimDailyLogin;

import java.io.IOException;

public class claimDailyLoginSteps {

    @Steps
    ClaimDailyLogin claimDailyLogin;

    @Given("I set an endpoint for daily login")
    public void iSetAnEndpointForDailyLogin() { claimDailyLogin.setAnEndpointForDailyLogin();}

    @When("I request {string} POST daily login")
    public void iRequestPOSTDailyLogin(String input) throws IOException { claimDailyLogin.setRequestPOSTDailyLogin(input);}

    @And("validate the data detail {string} after claim daily login")
    public void validateTheDataDetailAfterClaimDailyLogin(String message) { claimDailyLogin.setValidateTheDataDetailAfterClaimDailyLogin(message);}
}
