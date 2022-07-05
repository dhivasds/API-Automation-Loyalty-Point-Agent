package starter.stepDefinitions.DailyLogin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.dailyLogin.DetailDailyLogin;

import java.io.IOException;

public class detailDailyLoginSteps {

    @Steps
    DetailDailyLogin detailDailyLogin;

    @Given("I set an endpoint for detail daily login")
    public void iSetAnEndpointForDetailDailyLogin() { detailDailyLogin.setAnEndpointForDetailDailyLogin();}

    @When("I request {string} GET daily login")
    public void iRequestGETDailyLogin(String input) throws IOException { detailDailyLogin.setRequestGETDailyLogin(input);}

    @And("validate the data detail {string} after get detail daily login")
    public void validateTheDataDetailAfterGetDetailDailyLogin(String message) { detailDailyLogin.setValidateTheDataDetailAfterGetDetailDailyLogin(message);}
}
