package com.kensoftph.tableview;

public class Person {
    private String firstName;
    private String lastName;
    private String origin;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getOrigin() {
        return origin;
    }

    public Person(String firstName, String lastName, String origin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.origin = origin;
    }
}
