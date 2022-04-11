package com.mobadictionary;

public class Request {

    private String resource;

    private String value;

    public Request(){
    }

    public Request(String resource, String value) {
        this.resource = resource;
        this.value = value;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
