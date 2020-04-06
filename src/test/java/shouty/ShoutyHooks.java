package shouty;

import io.cucumber.java.Before;
import io.cucumber.java.After;

public class ShoutyHooks {

    @Before
    public void beforeScenario(){
        System.out.println("this is before");
    }

    @After
    public void afterScenario(){
        System.out.println("this is after");
    }
}
