package shouty;

import io.cucumber.java.en.Given;
import io.cucumber.java.DataTableType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class LocationSteps {
    @Autowired
    private Shouty shouty;

    @DataTableType
    public PersonLocation definePersonLocation(Map<String, String> entry) {
        return new PersonLocation(
                entry.get("name"),
                Integer.parseInt(entry.get("x")),
                Integer.parseInt(entry.get("y"))
        );
    }

    @Given("{word} is at {coordinate}")
    public void user_is_at(String name, Coordinate coordinate) {
        shouty.setLocation(name, coordinate);
    }

    @Given("people are located at")
    public void peopleAreLocatedAt(List<PersonLocation> personLocations) {

        for (PersonLocation personLocation: personLocations){
            shouty.setLocation(personLocation.name,
                    new Coordinate(personLocation.x, personLocation.y));
        }
    }
}
