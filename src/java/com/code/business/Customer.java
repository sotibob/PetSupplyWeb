package com.code.business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.code.database.*;

public class Customer extends Person implements IDatabasePerson{
    private ShoppingCart cart;
    private boolean login;
    private DatabaseManager database = new DatabaseManager();

    public Customer() {
        this(0,"", "", "", "", "", "", false);
        cart = new ShoppingCart();
    }

    //Constructor taking information and inputing into its super class and variables
    private Customer(String firstName, String lastName, String phoneNo, String email, Address address, boolean login) {
        super.setFirstName(firstName);
        super.setLastName(lastName);
        super.setPhoneNo(phoneNo);
        super.setEmail(email);
        super.setId(0);
        super.setAddress(address);
        this.login = login;
        cart = new ShoppingCart();
    }

    public Customer(int id, String username, String password, String firstName, String lastName, String phoneNo, String email, boolean login) {
        super.setFirstName(firstName);
        super.setLastName(lastName);
        super.setPhoneNo(phoneNo);
        super.setEmail(email);
        super.setId(id);
        super.setUsername(username);
        super.setPassword(password);
        this.login = login;
        cart = new ShoppingCart();
    }

    //Method to get the total price of all the products
    public double getSubtotal() {
        return cart.getSubtotal();
    }

    //Method to get the tax of the total price of all the products
    public double getTax() {
        return cart.getTax();
    }

    //Method to get the total of the price of all the products plus the tax
    //Method to add a product to cart
    public void addToCart(Product p) {
        cart.addProduct(p);
    }

    //Method to remove product from cart
    public void removeFromCart(Product p) {
        cart.removeProduct(p);
    }
    
    public boolean removeWholeProduct(Product p ){
        return cart.removeWholeProduct(p);
    }
    
    public int getCartProdCount(){
        return cart.getProdCount();
    }
    
    public ArrayList<int[]> getCartProducts(){
        return cart.getCart();
    }
    
    public void newCart(){
        cart = new ShoppingCart();
    }
    
    public int getCartCount(){
        return this.cart.getSize();
    }
    
    public double getCartTotal(){
        return cart.getTotal();
    }
    
    public double getCartSubtotal(){
        return cart.getSubtotal();
    }
    
    public double getCartTax(){
        return cart.getTax();
    }
    
    public boolean isLogin(){
        return login;
    }
    
    public void setLogin(boolean login){
        this.login = login;
    }

    //Method to upload all our products to the order table while assigning a new orderID to the products being uploaded
     public boolean uploadOrder() {
        // Create a new order object
        Order newOrder = new Order();
        
        // If the email is already in the database, then return false
        newOrder.setEmail(this.getEmail());
        if(newOrder.testEmail()) return false;
        
        // Set all the properties of the new order object
        newOrder.setCustId(getId());
        newOrder.setStreet(this.getAddress().getStreet());
        newOrder.setCity(this.getAddress().getCity());
        newOrder.setState(this.getAddress().getState());
        newOrder.setZip(this.getAddress().getZip());
        
        
        // Insert an order tuple into the database
        newOrder.insert();
        
        // Get the customer's cart
        ArrayList<int[]> custCart = cart.getCart();
        
        // Create an order detail variable
        OrderDetail orderDetail;
        
        // Create a product variable
        Product prod;
        
        /*
            For each product in the customer cart, we need to add a record to the
            orderdetails table in the database.
        */
        for(int[] i : custCart){
            // Create a new Product object
            prod = new Product();
            
            // Select the product from the database
            prod.select("" + i[0]);
            
            // Create a new order detail object
            orderDetail = new OrderDetail();
            
            // Set all the order detail properties
            orderDetail.setOrderId(newOrder.getOrderId());
            orderDetail.setProdId(prod.getProdId());
            orderDetail.setQuantity(i[1]);
            orderDetail.setProdCost(prod.getPrice());
            
            // Insert the order detail record into the database
            orderDetail.insert();
        }
        
        // The customer's object is given a new customer shopping cart object
        // In case the customer wants to continue browsing the selection
        cart = new ShoppingCart();
        
        // No problem occured while uploading the customer's order
        return true;
    }

    //Select method
    @Override
    public void select(int id) {
        try {
            //Execute Statement - Step #3
            String sql;
            sql = "select * from customers where customer_id = '" + id + "'" ;
            System.out.println(sql);
            ResultSet rs = database.executeSQLSelect(sql);

            rs.next();
            setFirstName(rs.getString(2));
            setLastName(rs.getString(3));
            setUsername(rs.getString(4));
            setEmail(rs.getString(5));
            setPassword(rs.getString(6));
            setPhoneNo(rs.getString(7));

            //Close Connection - Step #5
            database.closeConnection();
        }
        catch(SQLException e) {
            System.out.println("PP: " + e);
        }finally{
            database.closeConnection();
        }
    }
    
    public boolean selectByUsername(String username) {
        boolean isCustomer = false;
        try {
            //Execute Statement - Step #3
            String sql;
            sql = "select * from customers where username = '" + username + "';" ;
            System.out.println(sql);
            ResultSet rs = database.executeSQLSelect(sql);
            if(rs.next()){
                setId(rs.getInt(1));
                setFirstName(rs.getString(2));
                setLastName(rs.getString(3));
                setUsername(rs.getString(4));
                setEmail(rs.getString(5));
                setPassword(rs.getString(6));
                setPhoneNo(rs.getString(7));
                isCustomer = true;
            }
            //Close Connection - Step #5
            database.closeConnection();
        }
        catch(SQLException e) {
            System.out.println("PP: " + e);
        }finally{
            database.closeConnection();
        }
        return isCustomer;
    }

    //Insert method
    public void insert(String username, String password, String firstName, String lastName, String email, Address address, String phone) {
        setUsername(username);
        setPassword(password);
        setEmail(email);
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNo(phone);

        try {
            //Execute Statement - Step #3
            String sql = "Insert into customers(first_name, last_name, username, email, password, phone) values('" + getFirstName() + "', '" + getLastName() + "', '"
                    + getUsername() + "', '" + getEmail() + "','" + getPassword() + "', '" + getPhoneNo() + "')";
            int rs = database.executeSQLUpdate(sql);
            System.out.println(sql);
            /*It is important to remember that the variable rs is set to the
              number of rows effected by the insert statement.
            */
            if (rs ==1){System.out.println("Insert Successful!");}
            else{System.out.println("Insert Failed!!!");}

            //Close Connection - Step #5
            database.closeConnection();
        }
        catch(SQLException e) {
            System.out.println("PP: " + e);
        }finally{
            database.closeConnection();
        }
    }

    //Update method
    @Override
    public void update() {
        try {
            //Execute Statement - Step #3
            String sql;
            sql = "update customers set username = '" + getUsername()
                    + "', password = '" + getPassword() + "', first_name = '" + getFirstName()
                    + "', last_name =  '" + getLastName() + "'"
                    + ", phone =  '" + getPhoneNo() + "'"
                    + ", email = '" + getEmail() + "' where customer_id = '" + getId() + "'";
            System.out.println(sql);
            int rs = database.executeSQLUpdate(sql);
            
            if (rs ==1){System.out.println("Update Successful!");}
            else{System.out.println("Update Failed!!!");}

            //Close Connection - Step #5
            database.closeConnection();
        }
        catch(SQLException e) {
            System.out.println("PP: " + e);
        }finally{
            database.closeConnection();
        }
    }

    //Delete method
    public void delete()
    {
        try {
            //Execute Statement - Step #3
            String sql;
            sql = "delete from customer where customerID = '" + getId() + "'";
            System.out.println(sql);
            int rs = database.executeSQLUpdate(sql);

            if (rs ==1){System.out.println("Delete Successful!");}
            else{System.out.println("Delete Failed!!!");}

            //Close Connection - Step #5
            database.closeConnection();
        }
        catch(SQLException e) {
            System.out.println("PP: " + e);
        }finally{
            database.closeConnection();
        }
        
        
    }
    
    public ArrayList<Order> getOrdersByCustId(){
        return new Order().selectOrderByCustId(getId());
    }
        public static void main(String[] args){
            //Select
            
            Customer c = new Customer();
            int custId = 1;
            c.select(custId);
            c.display();
            
            
            //insert
            /*
            Customer c = new Customer();
            String[] cInfo = {"107", "goodGuy", "password", "Billy", "Bob", "7702342342", "billybob123@yahoo.com"};
            c.insertDB(cInfo[0], cInfo[1], cInfo[2], cInfo[3], cInfo[4], cInfo[5], cInfo[6]);
            */
            
            //Delete
            /*
            Customer c = new Customer();
            c.selectDB("107");
            c.deleteDB();
            */
            
            //Update
            /*
            Customer c = new Customer();
            String[] cInfo = {"107", "goodGuy", "123", "Billy", "Bob", "7702342342", "goodguy12@yahoo.com"};
            c.selectDB(cInfo[0]);
            c.setEmail(cInfo[6]);
            c.setPassword(cInfo[2]);
            c.updateDB();
            */
        }
}