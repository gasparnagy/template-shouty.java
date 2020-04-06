package shouty;

import io.cucumber.java.ParameterType;

public class ParameterTypes {

    @ParameterType("(\\d+), (\\d+)")
    public Coordinate coordinate(String x, String y) {
        return new Coordinate(Integer.parseInt(x), Integer.parseInt(y));
    }
}
