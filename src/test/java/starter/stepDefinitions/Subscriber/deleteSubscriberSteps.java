package starter.stepDefinitions.Subscriber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.subscriber.DeleteSubscriber;

import java.io.IOException;

public class deleteSubscriberSteps {


    @Steps
    DeleteSubscriber deleteSubscriber;

    @Given("I set an endpoint for delete subscriber")
    public void iSetAnEndpointForDeleteSubscriber() throws IOException { deleteSubscriber.setAnEndpointForDeleteSubscriber();}

    @When("I request {string} DELETE subscriber")
    public void iRequestDELETESubscriber(String input) throws IOException { deleteSubscriber.setRequestDELETESubscriber(input);}

    @And("validate the data detail {string} after delete subscriber")
    public void validateTheDataDetailAfterDeleteSubscriber(String message) { deleteSubscriber.setValidateTheDataDetailAfterDeleteSubscriber(message);}
}
