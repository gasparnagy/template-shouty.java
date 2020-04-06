package shouty;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static java.util.Collections.emptyMap;
import static org.junit.Assert.assertEquals;


public class ShoutSteps {
    private static final String ARBITRARY_MESSAGE = "Hello, world";
    private final Shouty shouty = new Shouty();

    @Given("{word} is at {int}, {int}")
    public void user_is_at(String name, int xCoord, int yCoord) {
        shouty.setLocation(name, new Coordinate(xCoord, yCoord));
    }

    @When("Sean shouts")
    public void sean_shouts() {
        shouty.shout("Sean", ARBITRARY_MESSAGE);
    }

    @When("Oscar shouts")
    public void oscarShouts() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("Lucy should not hear Oscar")
    public void lucyShouldNotHearOscar() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("Lucy should hear Sean")
    public void lucy_should_hear_sean() {
        assertEquals(1, shouty.getShoutsHeardBy("Lucy").size());
    }

    @Then("Lucy should hear nothing")
    public void lucy_should_hear_nothing() {
        assertEquals(emptyMap(), shouty.getShoutsHeardBy("Lucy"));
    }
}
