package io.federecio.dropwizard.swagger.sample;

/**
 * Created by adarsh.sharma on 27/02/18.
 */
public class SampleRequest {

    private final String name;
    private final int value;

    public SampleRequest(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
