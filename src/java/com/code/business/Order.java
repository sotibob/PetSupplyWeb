package com.code.business;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.sql.SQLException;
import com.code.database.*;

public class Order {
    private int orderId;
    private int custId;
    private boolean status = false;
    private String date;
    private Address address;
    private String email;
    
    
    private final DatabaseManager database = new DatabaseManager();

    public Order() {
        this(0, 0, 0, new Address());
    }

    public Order(int orderId, int empId, int custId, Address address) {
        this.orderId = orderId;
        this.custId = custId;
        this.date = getDateTime();
        this.address = address;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }
    
    public String getStreet(){
        return this.address.getStreet();
    }
    
    public String getCity(){
        return this.address.getCity();
    }

    public String getZip(){
        return this.address.getZip();
    }
    
    public String getState(){
        return this.address.getState();
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setStreet(String street){
        this.address.setStreet(street);
    }
    
    public void setCity(String city){
        this.address.setCity(city);
    }
    
    public void setState(String state){
        this.address.setState(state);
    }
    
    public void setZip(String zip){
        this.address.setZip(zip);
    }
    
    public String getDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String isStatus() {
         return (status ? "Shipped" : "Open");
    }

    public boolean getStatus(){
        return this.status;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }
    

    public ArrayList<Order> getOrders() {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            String sql = "SELECT * FROM orders";
            System.out.println(sql);
            ResultSet rs = database.executeSQLSelect(sql);

            Order o1;
            while (rs.next()) {
                o1 = new Order();
                o1.setOrderId(rs.getInt(1));
                o1.setCustId(rs.getInt(2));
                o1.setStatus(rs.getBoolean(3));
                o1.setDate(rs.getString(4));
                o1.setStreet(rs.getString(5));
                o1.setCity(rs.getString(6));
                o1.setState(rs.getString(7));
                o1.setZip(rs.getString(8));
                o1.setEmail(rs.getString(9));
                orders.add(o1);
            }

            //Close Connection - Step #6
            database.closeConnection();
        } catch (SQLException e) {
            System.out.println("PP: " + e);
        }
        return orders;
    }

    public void select(int orderId) {
        this.orderId = orderId;
        try {
            //sql = "select * from orders where orderID = '" + orderId + "' AND productID = '" + prodId + "'";
            String sql = "select * from orders where order_id = " + this.orderId + "";
            System.out.println(sql);
            ResultSet rs = database.executeSQLSelect(sql);
            //Process Data - Step #5
                rs.next();
                this.custId = rs.getInt(2);
                this.status = rs.getBoolean(3);
                this.date = rs.getString(4);
                this.address.setStreet(rs.getString(5));
                this.address.setCity(rs.getString(6));
                this.address.setState(rs.getString(7));
                this.address.setZip(rs.getString(8));

            //Close Connection - Step #6
            database.closeConnection();
        } catch (SQLException e) {
            System.out.println("PP: " + e);
        }
    }
    
    public ArrayList<Order> selectOpenOrders() {
        ArrayList<Order> orders = new ArrayList<>(); //Create an array list of orders to return
        try {
            String sql = "SELECT * FROM orders WHERE order_status = 0";
            System.out.println(sql);
            ResultSet rs = database.executeSQLSelect(sql);
            //Process Data - Step #5
                Order o;
                while(rs.next()){
                    o = new Order();
                    o.orderId = rs.getInt(1);
                    o.custId = rs.getInt(2);
                    o.status = rs.getBoolean(3);
                    o.date = rs.getString(4);
                    o.setStreet(rs.getString(5));
                    o.setCity(rs.getString(6));
                    o.setState(rs.getString(7));
                    o.setZip(rs.getString(8));
                    o.setEmail(rs.getString(9));
                    orders.add(o);
                }
                

            //Close Connection - Step #6
            database.closeConnection();
        } catch (SQLException e) {
            System.out.println("PP: " + e);
        }
        return orders;
    }

    public void insert() {
        this.date = getDateTime();

        try {
            // query to make insert to the database
            String insert = "INSERT INTO orders(customer_id, order_status, order_date, street, city, state, zipcode, email)"
                    + "VALUES(" + custId + ", " + false + ", '" + date + "', '" + getStreet() + "', '" + getCity() + "', '" + getState() + "', '" + getZip() + "', '" + getEmail() + "')";
            System.out.println(insert);
            
            // query to get the order id from the database on the previously inserted order
            String select = "SELECT order_id FROM orders WHERE customer_id = " + custId + " AND order_status = " + 0 + " AND order_date = '" + date + "' AND street = '" + getStreet() + "' AND city = '" + getCity() + "' AND state = '" + getState() + "' AND zipcode = '" + getZip() + "' AND email = '" + email + "';";
            System.out.println(select);
            
            // Execute the select and update statements
            int rowsEffected = database.executeSQLUpdate(insert);
            ResultSet rs = database.executeSQLSelect(select);
            
            // Get the order_id generated by the database
            rs.next();
            this.orderId = rs.getInt(1);
            
            System.out.println((rowsEffected == 1)? "Sucess" : "Unsuccessful");
            
            //Close Connection - Step #6
            database.closeConnection();
            
        } catch (SQLException e) {
            System.out.println("PP: " + e);
        }
    }

    public void update() {
        try {
            
            String sql = "update orders set customer_id = " + this.custId + ", order_status = " + this.status + " where order_id = " + this.orderId + ";";
            System.out.println(sql);

            int rs = database.executeSQLUpdate(sql);
            System.out.println("This is the result of the update: " + rs);
            if (rs == 1) {
                System.out.println("Update Successful!");
            } else {
                System.out.println("Update Failed!!!");
            }

            //Close Connection - Step #6
            database.closeConnection();
        } catch (SQLException e) {
            System.out.println("PP: " + e);
        }
    }
    
    public void updateStatus(boolean status) {
        this.status = status;
        try {
            
            String sql = "update orders set order_status = " + status + " where order_id = " + orderId + ";";
            System.out.println(sql);

            int rs = database.executeSQLUpdate(sql);
            System.out.println("This is the result of the update: " + rs);
            if (rs == 1) {
                System.out.println("Update Successful!");
            } else {
                System.out.println("Update Failed!!!");
            }

            //Close Connection - Step #6
            database.closeConnection();
        } catch (SQLException e) {
            System.out.println("PP: " + e);
        }
    }

    public void delete() {
        try {
            
            String sql;
            sql = "delete from orders where order_id = " + this.orderId + ";";
            System.out.println(sql);

            int rs = database.executeSQLUpdate(sql);
            System.out.println("This is the result of the update: " + rs);
            if (rs == 1) {
                System.out.println("Delete Successful!");
            } else {
                System.out.println("Delete Failed!!!");
            }
            database.closeConnection();
        } catch (SQLException e) {
            System.out.println("PP: " + e);
        }
    }
    
    public ArrayList<Order> selectOrderByCustId(int custId){
        ArrayList<Order> orders = new ArrayList<>();
        try {
            //sql = "select * from orders where orderID = '" + orderId + "' AND productID = '" + prodId + "'";
            String sql = "select * from orders where customer_id = '" + custId + "';";
            System.out.println(sql);
            ResultSet rs = database.executeSQLSelect(sql);
            //Process Data - Step #5
            Order o1;
                while(rs.next()){
                    o1 = new Order();
                    o1.orderId = rs.getInt(1);
                    o1.status = rs.getBoolean(3);
                    o1.date = rs.getString(4);
                    orders.add(o1);
                }

            //Close Connection - Step #6
            database.closeConnection();
        } catch (SQLException e) {
            System.out.println("PP: " + e);
        }
        return orders;
    }
    
    public boolean testEmail(){
        try{
            String sql = "SELECT email FROM orders WHERE email = '" + email + "';";
            ResultSet rs = database.executeSQLSelect(sql);
            
            while(rs.next()){
                if(email.equals(rs.getString(1)))
                    // returns true if the database already contains this email
                    return true;
            }
            
        } catch(SQLException e){
            System.out.println("Error with select on email column... " + e);
        }
        // If no email was match against the database
        return false;
    }
    
    public void display(){
        System.out.println("Order ID = " + getOrderId());
        System.out.println("Customer ID = " + getCustId());
        System.out.println("Order date = " + getDate());
        System.out.println("Order Status = " + getStatus());
        System.out.println("Street = " + getStreet());
        System.out.println("City = " + getCity());
        System.out.println("State = " + getState());
        System.out.println("Zip code = " + getZip());
    }
    
    public static void main(String[] args){
        //SelectDB()
//        Order order = new Order();
//        System.out.println(order.getDateTime());
        
//        String orderId = "1";
//        Order o1 = new Order();
//        o1.select(orderId);
//        o1.display();

        //Testing selectOrderByCustId(int custId);
        
//        ArrayList<Order> orders = new Order().selectOrderByCustId(1);
//        for(Order o : orders){
//            o.display();
//        }
        
        
       
        
        //getOrders()
        
//        Order order = new Order();
//        ArrayList<Order> orders = order.getOrders();
//        for(Order o : orders){
//            o.display();
//        }
//        System.out.println(orders.size());
       
        
        //insert(custID, empId, prodId, quantity)
//        int[] orderInfo = {1, 1, 1, 3};
//        Order o = new Order();
//        o.insert(orderInfo[0], orderInfo[1], orderInfo[2], orderInfo[3]);
        
        
        //UpdateDB()
//        
//        Order o = new Order();
//        o.select(1);
//        o.setStatus(true);
//        o.update();

//        Order o = new Order();
//        o.updateOrderStatus(1, false);
        
        
        //DeleteDB()
        /*
        Orders o = new Orders();
        o.selectDB("Ord01");
        o.deleteDB();
        */
    }
}