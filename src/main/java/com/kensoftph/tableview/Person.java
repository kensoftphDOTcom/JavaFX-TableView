package com.kensoftph.tableview;

public class Person {
    private String firstName;
    private String lastName;
    private String origin;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
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
