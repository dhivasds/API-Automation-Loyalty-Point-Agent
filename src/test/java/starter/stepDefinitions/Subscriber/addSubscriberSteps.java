package starter.stepDefinitions.Subscriber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.subscriber.AddSubscriber;

import java.io.IOException;

public class addSubscriberSteps {

    @Steps
    AddSubscriber addSubscriber;

    @Given("I set an endpoint for add subscriber")
    public void iSetAnEndpointForAddSubscriber() { addSubscriber.setAnEndpointForAddSubscriber();}

    @When("I request {string} POST subscriber")
    public void iRequestPOSTSubscriber(String input) throws IOException { addSubscriber.setRequestPOSTSubscriber(input);}

    @And("validate the data detail {string} after add subscriber")
    public void validateTheDataDetailAfterAddSubscriber(String message) { addSubscriber.setValidateTheDataDetailAfterAddSubscriber(message);}
}
