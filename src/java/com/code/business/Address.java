package com.code.business;

public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;

    Address(){
        street = "";
        city = "";
        state = "";
        zip = "";
    }
    
    public Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void display() {
        System.out.println("Street = " + getStreet());
        System.out.println("City = " + getCity());
        System.out.println("State = " + getState());
        System.out.println("ZIP = " + getZip());
    }
}
