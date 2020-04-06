package shouty;

import io.cucumber.java.PendingException;
import io.cucumber.java.DataTableType;
import io.cucumber.java.DocStringType;
import io.cucumber.java.ParameterType;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyMap;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;


public class ShoutSteps {
    private static final String ARBITRARY_MESSAGE = "Hello, world";
    private final Shouty shouty = new Shouty();

    @Given("{word} is at {int}, {int}")
    public void user_is_at(String name, int xCoord, int yCoord) {
        shouty.setLocation(name, new Coordinate(xCoord, yCoord));
    }

    @DataTableType
    public PersonLocation definePersonLocation(Map<String, String> entry) {
        return new PersonLocation(
                entry.get("name"),
                Integer.parseInt(entry.get("x")),
                Integer.parseInt(entry.get("y"))
        );
    }

    @Given("people are located at")
    public void peopleAreLocatedAt(List<PersonLocation> personLocations) {

        for (PersonLocation personLocation: personLocations){
            shouty.setLocation(personLocation.name,
                    new Coordinate(personLocation.x, personLocation.y));
        }
    }

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
}
