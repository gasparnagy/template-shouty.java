package shouty;

import io.cucumber.java.PendingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyMap;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;


public class ShoutSteps {
    private static final String ARBITRARY_MESSAGE = "Hello, world";
    @Autowired
    private Shouty shouty;

    @When("{word} shouts")
    public void user_shouts(String name) {
        shouty.shout(name, ARBITRARY_MESSAGE);
    }

    @Then("Lucy should not hear Oscar")
    public void lucy_should_not_hear_oscar() {
        assertFalse(shouty.getShoutsHeardBy("Lucy").containsKey("Oscar"));
    }

    @Then("Lucy should hear Sean")
    public void lucy_should_hear_sean() {
        assertEquals(1, shouty.getShoutsHeardBy("Lucy").size());
    }

    @Then("Lucy should hear nothing")
    public void lucy_should_hear_nothing() {
        assertEquals(emptyMap(), shouty.getShoutsHeardBy("Lucy"));
    }

    @Then("Lucy should hear {int} shouts from Sean")
    public void lucyShouldHearShoutsFromSean(int expectedNumberOfShouts) {
        Map<String, List<String>> shoutsHeard = shouty.getShoutsHeardBy("Lucy");
        List<String> shoutsByShouter = shoutsHeard.get("Sean");
        assertEquals(expectedNumberOfShouts, shoutsByShouter.size());
    }
}
