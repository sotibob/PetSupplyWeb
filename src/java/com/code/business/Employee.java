package com.code.business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;
import com.code.database.*;

public class Employee extends Person implements IDatabasePerson{
    
    //Used for executed sql commands and closing connections to the database
    private DatabaseManager database = new DatabaseManager();

    public Employee() {
        this(0, "", "", "", "", "", new Address( "", "", "", ""), "");
    }

    public Employee(int id, String username, String password, String firstName, String lastName, String email, Address address, String phone) {
        super(id, username, password, firstName, lastName, address, phone, email);
    }

    public ArrayList<Employee> getEmployees() {
        //Create a new array list to hold all the employee objects in the database
       ArrayList<Employee> employees = new ArrayList<Employee>();
        try {
            String sql = "SELECT * FROM Employees";
            ResultSet rs = database.executeSQLSelect(sql);

            Employee e1;
            while (rs.next()) {
                e1 = new Employee();
                setId(rs.getInt(1));
                setFirstName(rs.getString(2));
                setLastName(rs.getString(3));
                setEmail(rs.getString(4));
                setUsername(rs.getString(5));
                setPassword(rs.getString(6));
                setAddress(new Address(rs.getString(7), rs.getString(8), rs.getString(11), rs.getString(9)));
                setPhoneNo(rs.getString(10));
                employees.add(e1);
            }

            //Close Connection - Step #6
            database.closeConnection();
        }
        catch(SQLException e) {
            System.out.println("PP: " + e);
        }
        return employees;
    }

    @Override
    public void select(int empId) {
        try {
            String sql = "SELECT * FROM employees WHERE employee_id = " + getId() + "";
            ResultSet rs = database.executeSQLSelect(sql);


            //Process Data - Step #5
            rs.next();
            setId(rs.getInt(1));
            setFirstName(rs.getString(2));
            setLastName(rs.getString(3));
            setEmail(rs.getString(4));
            setUsername(rs.getString(5));
            setPassword(rs.getString(6));
            setAddress(new Address(rs.getString(7), rs.getString(9), rs.getString(10), rs.getString(8)));
            setPhoneNo(rs.getString(11));


            //Close Connection - Step #6
            database.closeConnection();
        }
        catch(SQLException e) {
            System.out.println("PP: " + e);
        }
    }
    
    public boolean selectByUsername(String username){
        boolean match = false;
        try{
            String sql = "SELECT * FROM employees where username = '" + username + "'";
            ResultSet rs = database.executeSQLSelect(sql);

            //Process Data - Step #5
            //Sets the match variable to true or false and moves the cursor to the next position
            match = rs.next();
            setId(rs.getInt(1));
            setFirstName(rs.getString(2));
            setLastName(rs.getString(3));
            setEmail(rs.getString(4));
            setUsername(rs.getString(5));
            setPassword(rs.getString(6));
           // Address(String street, String city, String state, int zip) 
            setAddress(new Address(rs.getString(7), rs.getString(9), rs.getString(10), rs.getString(8)));
            setPhoneNo(rs.getString(11));


            //Close Connection - Step #6
            database.closeConnection();
        }
        catch(SQLException e) {
            System.out.println("PP: " + e);
        }
        return match;
    }

    /**
     *
     * @param empId
     * @param firstName
     * @param lastName
     * @param email
     * @param username
     * @param password
     * @param phoneNo
     * @param address
     */
    public void insert(String username, String password, String firstName, String lastName, String email, Address address, String phone) {
        setUsername(username);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setAddress(address);
        setPhoneNo(phone);
       

        try {
            String sql = "Insert into employee values('" + getId() + "', '" + getFirstName() + "', '" + getLastName() + "', '"
                    + getEmail() + "', '" + getUsername() + "', '" + getPassword() + "', '" + getAddress().getStreet() + "', '"
                    + getAddress().getCity() + "', " + getAddress().getZip() + ", '" + getPhoneNo() + "', '" + getAddress().getState() + "')";
            int rs = database.executeSQLUpdate(sql);

            if (rs ==1){System.out.println("Insert Successful!");}
            else{System.out.println("Insert Failed!!!");}

            //Close Connection - Step #6
            database.closeConnection();
        }
        catch(SQLException e) {
            System.out.println("PP: " + e);
        }
    }

    @Override
    public void update() {
        try {
            String sql = "update employees set username = '" + getUsername()
                    + "', password = '" + getPassword() + "', first_name = '" + getFirstName()
                    + "', last_name =  '" + getLastName() + "', street =  '" + getAddress().getStreet()
                    + "', city =  '" + getAddress().getCity() + "', state =  '" + getAddress().getState()
                    + "', zipcode =  " + getAddress().getZip() + ", phone =  " + getPhoneNo()
                    + ", email = '" + getEmail() + "' where employee_id = '" + getId() + "'";
            System.out.println(sql);
            int rs = database.executeSQLUpdate(sql);

            if (rs ==1){System.out.println("Update Successful!");}
            else{System.out.println("Update Failed!!!");}

            //Close Connection - Step #6
            database.closeConnection();
        }
        catch(SQLException e) {
            System.out.println("PP: " + e);
        }
    }

    @Override
    public void delete()
    {
        try {
            String sql = "delete from employee where employeeID = '" + getId() + "'";
            System.out.println(sql);
            int rs = database.executeSQLUpdate(sql);

            if (rs ==1){System.out.println("Delete Successful!");}
            else{System.out.println("Delete Failed!!!");}

            //Close Connection - Step #6
            database.closeConnection();
        }
        catch(SQLException e) {
            System.out.println("PP: " + e);
        }
    }
    
    public static void main(String[] args){
       
        //SelectDB()
        /*
        String custId = "1001";
        Employee e1 = new Employee();
        e1.selectDB(custId);
        e1.display();
        */
        
        //String empId, String firstName, String lastName, String email, String username, String password, String phoneNo, Address address
        //insertDB()
        /*
        String[] emp = {"1011", "John", "Beth", "BethJohn@yahoo.com", "jonyboy", "1234", "4432342567"};
        Address a = new Address("john street", "john city", "Ga", 42232);
        Employee e = new Employee();
        e.insertDB(emp[0], emp[1], emp[2], emp[3], emp[4], emp[5], emp[6], a);
        e.display();
        */
        
        //DeleteDB()
        /*
        String id = "1011";
        Employee e = new Employee();
        e.selectDB(id);
        e.display();
        e.deleteDB();
        */
        
        //UpdateDB()
        /*
        String id = "1011";
        Employee e = new Employee();
        e.selectDB(id);
        e.setUsername("johnc00l");
        e.setPassword("newpassword");
        e.updateDB();
        */
        
        //getEmployees
        /*
        Employee e = new Employee();
        ArrayList<Employee> emps = e.getEmployees();
        for(Employee emp : emps){
            e.display();
        }
        System.out.println(emps.size());
        */
    }
}
