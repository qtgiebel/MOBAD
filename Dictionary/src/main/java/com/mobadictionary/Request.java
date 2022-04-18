package com.mobadictionary;

/**
 * Handles the Resource and Values being passed in through the API.
 */
public class Request {

    private String resource;

    private String value;

    /**
     * Instantiates a new Request.
     */
    public Request() {}

    /**
     * Gets resource.
     *
     * @return the resource
     */
    public String getResource() {
        return resource;
    }

    /**
     * Sets resource.
     *
     * @param resource the resource
     */
    public void setResource(String resource) {
        this.resource = resource;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValue(String value) {
        this.value = value;
    }
}
