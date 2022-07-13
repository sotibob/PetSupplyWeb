
package com.code.business;

import com.code.database.DatabaseManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josia
 */
public class OrderDetail {
    private int detailId;
    private int orderId;
    private int prodId;
    private double prodCost;
    private int quantity;
    
    private DatabaseManager database = new DatabaseManager();
    
    
    
    // Constructor with arguments
    public OrderDetail(int orderId, int prodId, double prodCost, int quantity){
        this.detailId = 0;
        this.orderId = orderId;
        this.prodId = prodId;
        this.prodCost = prodCost;
        this.quantity = quantity;
    }
    
    // No-arg constructor
    public OrderDetail(){
        orderId = 0;
        prodId = 0;
        prodCost = 0.0;
        quantity = 0;
    }
    
    // All the getter
    public int getDetailId(){return this.detailId;}
    public int getOrderId(){return this.orderId;}
    public int getProdId(){return this.prodId;}
    public double getProdCost(){return this.prodCost;}
    public int getQuantity(){return this.quantity;}
    
    // All the setter methods
    public void setDetailId(int detailId){this.detailId = detailId;}
    public void setOrderId(int orderId){this.orderId = orderId;}
    public void setProdId(int prodId){this.prodId = prodId;}
    public void setProdCost(double prodCost){this.prodCost = prodCost;}
    public void setQuantity(int quantity){this.quantity = quantity;}
    
    public void innerJoin(){
    }
    
    // Select method that selects an order detail entry with the current order detail id value
    public void select(){
        try{
            // Execute the select statement
            String sql = "SELECT * FROM orderdetails WHERE detail_id = '" + detailId + "';";
            System.out.println(sql);
            ResultSet rs = database.executeSQLSelect(sql);
            
            //Process the result set object
            rs.next();
            detailId = rs.getInt(1);
            orderId = rs.getInt(2);
            prodId = rs.getInt(3);
            quantity = rs.getInt(4);
            prodCost = rs.getDouble(5);
            
        } catch(SQLException e){
            System.out.println("Error with select... " + e);
        }
    }
    
    // Method to select all order detail entries with specified order id
    public List<OrderDetail> selectByOrderId(){
        List<OrderDetail> details = new ArrayList<>();
        try{
            String sql = "SELECT * FROM orderdetails WHERE order_id = " + orderId;
            ResultSet rs = database.executeSQLSelect(sql);
            
            OrderDetail od;
            while(rs.next()){
                od = new OrderDetail();
                od.setDetailId(rs.getInt(1));
                od.setOrderId(rs.getInt(2));
                od.setProdId(rs.getInt(3));
                od.setQuantity(rs.getInt(4));
                od.setProdCost(rs.getDouble(5));
                details.add(od);
            }
            
            // Close the connection
            database.closeConnection();
            
        } catch(SQLException e){
            System.out.println("Error with select... " + e);
        }
        return details;
    }
    
    public void update(){
        try{
            // Execute the sql statement
            String sql = "UPDATE orderdetails"
                    + " SET order_id = " + orderId + ","
                    + " product_id = " + prodId + ","
                    + " quantity = " + quantity + ","
                    + " prod_cost = " + prodCost
                    + " WHERE detail_id = " + detailId + ";";
            System.out.println(sql);
            int rs = database.executeSQLUpdate(sql);
            
            System.out.println((rs == 1)? "Insert successful" : "Insert unsuccessful");
        } catch(SQLException e){
            System.out.println("Error with update... " + e);
        }
    }
    
    public void insert(){
        try{
            // Execute the insert statement
            String sql = "INSERT INTO orderdetails(order_id, product_id, quantity, prod_cost) VALUES(" + orderId + ", " + prodId + ", " + quantity + ", " + prodCost + ");";
            System.out.println(sql);
            int rs = database.executeSQLUpdate(sql);
            
            System.out.println((rs == 1)? "Insert successful" : "Insert unsuccessful");
        } catch(SQLException e){
            System.out.println("Error with insert... " + e);
        }
    }
    
    public void delete(){
        try{
            // Execute the delete statement
            String sql = "DELETE FROM orderdetails WHERE detail_id = " + detailId + ";";
            System.out.println(sql);
            int rs = database.executeSQLUpdate(sql);
            
            System.out.println((rs == 1)? "Insert successful" : "Insert unsuccessful");
        } catch(SQLException e){
            System.out.println("Error with delete... " + e);
        }
    }
        
    public void display(){
        System.out.println(toString());
    }
    
    @Override
    public String toString(){
        return "Order Detail ID: " + detailId +
                "\nOrder ID: " + orderId +
                "\nProduct ID: " + prodId +
                "\nProduct Quantity: " + quantity +
                "\nProduct Cost: " + prodCost;
    }
    
    public static void main(String[] args){
        OrderDetail o = new OrderDetail();
        o.setOrderId(1);
        ArrayList<OrderDetail> details = (ArrayList)o.selectByOrderId();
        
        for(OrderDetail od : details){
            od.display();
        }
//        o.setOrderId(1);
//        o.setCustId(1);
//        o.setProdId(1);
//        o.setQuantity(3);
//        o.setProdCost(10.20);
//        o.insert();
//        o.display();
        
        // Delete the tuple from the database
//        o.setDetailId(2);
//        o.delete();

        // Select the order detail from the database
//        o.setDetailId(1);
//        o.select();
//        o.display();

        // Update the order details table
//        o.setDetailId(1);
//        o.select();
//        o.setProdId(3);
//        o.update();
//        o.display();

        
    }
}
