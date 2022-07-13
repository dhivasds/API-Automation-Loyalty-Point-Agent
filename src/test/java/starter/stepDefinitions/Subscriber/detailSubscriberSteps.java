package starter.stepDefinitions.Subscriber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.subscriber.DetailSubscriber;

import java.io.IOException;

public class detailSubscriberSteps {

    @Steps
    DetailSubscriber detailSubscriber;

    @Given("I set an endpoint for subscribers")
    public void iSetAnEndpointForSubscribers() { detailSubscriber.setAnEndpointForSubscribers();}

    @When("I request {string} GET subscribers")
    public void iRequestGETSubscribers(String input) throws IOException { detailSubscriber.setRequestGETSubscribers(input);}

    @And("validate the data detail {string} after get detail subscribers")
    public void validateTheDataDetailAfterGetDetailSubscribers(String message) { detailSubscriber.setValidateTheDataDetailAfterGetDetailSubscribers(message);}
}
