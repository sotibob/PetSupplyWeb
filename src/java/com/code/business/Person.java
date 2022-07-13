package com.code.business;

public class Person {
    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String email;
    private Address address;

    public Person() {
        this(0, "", "", "", "",new Address("", "", "", ""), "", "");
    }

    public Person(int id, String username, String password, String firstName, String lastName, Address address, String phoneNo, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNo = phoneNo;
        this.email = email;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   public void display() {
       System.out.println("ID = " + getId());
       System.out.println("Username = " + getUsername());
       System.out.println("Password = " + getPassword());
       System.out.println("FirstName = " + getFirstName());
       System.out.println("LastName = " + getLastName());
       address.display();
       System.out.println("Phone = " + getPhoneNo());
       System.out.println("Email = " + getEmail());
   }
}
