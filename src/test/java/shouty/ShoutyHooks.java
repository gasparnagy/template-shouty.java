package shouty;

import io.cucumber.java.Before;
import io.cucumber.java.After;

public class ShoutyHooks {

    @Before(value = "@SpecialTest", order = 0)
    public void beforeSpecialScenario(){
        System.out.println("this is special");
    }

    @Before(order = 1)
    public void beforeScenario(){
        System.out.println("this is before");
    }

    @After(order = 1)
    public void afterScenario(){
        System.out.println("this is after");
    }

    @Before(order = 2)
    public void otherBeforeScenario(){
        System.out.println("this is other before");
    }

    @After(order = 2)
    public void otherAfterScenario(){
        System.out.println("this is other after");
    }
}
