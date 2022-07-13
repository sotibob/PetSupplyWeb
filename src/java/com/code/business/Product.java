package com.code.business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.code.database.*;

public class Product {
    //Global variables
    private int prodId;
    private String prodName;
    private String prodDesc;
    private String prodBrand;
    private String breed;
    private int custQuantity;
    private int quantity;
    private double price;
    private String picture;
    private DatabaseManager database = new DatabaseManager();

    public Product() {
        this(0, "", "", "", "", 0, 0.0, "");
    }

    public Product(int prodId, String prodName, String prodDesc,String prodBrand, String breed, int quantity, double price, String picture) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.prodDesc = prodDesc;
        this.prodBrand = prodBrand;
        this.breed = breed;
        this.quantity = quantity;
        this.price = price;
        this.picture = picture;
    }

    //Set and get methods
    public String getBrand() {
        return prodBrand;
    }

    public void setBrand(String prodBrand) {
        this.prodBrand = prodBrand;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    
    public void setCustQuantity(int quantity){
        this.custQuantity = quantity;
    }

    //Method to get the amount of products if needed
    public ArrayList<Product> getProducts(int pageNum, int total) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            

            //Execute Statement - Step #3
            String sql;
            sql = "SELECT * FROM products LIMIT " + (pageNum - 1) + ", " + total + ";";
            System.out.println(sql);
            ResultSet rs = database.executeSQLSelect(sql);

            Product p1;
            while (rs.next()) {
                p1 = new Product();
                p1.prodId = rs.getInt(1);
                p1.prodName = rs.getString(2);
                p1.prodDesc =rs.getString(3);
                p1.quantity = rs.getInt(4);
                p1.price = rs.getDouble(5);
                p1.picture = rs.getString(6);
                p1.prodBrand = rs.getString(7);
                p1.breed =rs.getString(8);
                
                products.add(p1);
            }

            //Close Connection - Step #5
            database.closeConnection();
        }
        catch(SQLException e) {
            System.out.println("PP: " + e);
        }
        return products;
    }

    //Display method
    public void display() {
        System.out.println("Product ID = " + getProdId());
        System.out.println("Product Name = " + getProdName());
        System.out.println("Product Description = " + getProdDesc());
        System.out.println("Product Brand = " + getBrand());
        System.out.println("Breed = " + getBreed());
        System.out.println("Quantity = " + getQuantity());
        System.out.println("Price = " + getPrice());
        System.out.println("Picture = " + getPicture());
    }

    //Select Method
    public void select(String prodId) {
        try {
            
            String sql;
            sql = "select * from products where product_id = " + prodId + "" ;
            System.out.println(sql);
            
            ResultSet rs = database.executeSQLSelect(sql);

            rs.next();
            this.prodId = rs.getInt(1);
            this.prodName = rs.getString(2);
            this.prodDesc =rs.getString(3);
            this.quantity = rs.getInt(4);
            this.price = rs.getDouble(5);
            this.picture = rs.getString(6);
            this.prodBrand = rs.getString(7);
            this.breed =rs.getString(8);

            database.closeConnection();
        }
        catch(SQLException e) {
            System.out.println("PP: " + e);
        }
    }

    //Insert method
    public void insert(int prodId, String prodName, String prodDesc, String prodBrand, String breed, int quantity, double price, String picture) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.prodDesc = prodDesc;
        this.prodBrand = prodBrand;
        this.breed = breed;
        this.quantity = quantity;
        this.price = price;
        this.picture = picture;

        try {
            
            String sql;
            sql = "Insert into product values('" + getProdId() + "', '" + getProdName() + "', '" + getProdDesc() + "', " + getQuantity() + ", "
                    + getPrice() + ", '" + getPicture() + "', '" + getBrand() + "', '" + getBreed() + "')";
            System.out.println(sql);
            int rs = database.executeSQLUpdate(sql);
            if (rs ==1){System.out.println("Insert Successful!");}
            else{System.out.println("Insert Failed!!!");}

            //Close Connection - Step #5
            database.closeConnection();
        }
        catch(SQLException e) {
            System.out.println("PP: " + e);
        }
    }

    //Update method
    public void update() {
        try {
            
            String sql;
            sql = "update products set product_name = '" + getProdName()
                    + "', product_desc = '" + getProdDesc()
                    + "', brand = '" + getBrand()
                    + "', breed = '" + getBreed()
                    + "', quantity = " + getQuantity()
                    + ", price =  " + getPrice()
                    + ", picture = '" + getPicture() + "' where product_id = '" + getProdId() + "'";
            System.out.println(sql);
            int rs = database.executeSQLUpdate(sql);
            if (rs ==1){System.out.println("Update Successful!");}
            else{System.out.println("Update Failed!!!");}

            //Close Connection - Step #5
            database.closeConnection();
        }
        catch(SQLException e) {
            System.out.println("PP: " + e);
        }
    }

    //Delete method
    public void delete()
    {
        try {
            String sql;
            sql = "delete from product where productID = '" + getProdId() + "'";
            System.out.println(sql);
            int rs = database.executeSQLUpdate(sql);
            if (rs ==1){System.out.println("Delete Successful!");}
            else{System.out.println("Delete Failed!!!");}

            //Close Connection - Step #5
            database.closeConnection();
        }
        catch(SQLException e) {
            System.out.println("PP: " + e);
        }
    }
    public static void main(String[] args){

        Product p = new Product();
        ArrayList<Product> products = p.getProducts(1, 3);
        for(Product prod: products){
            prod.display();
        }
        
        //insertDB(String prodId, String prodName, String prodDesc, String prodBrand, String breed, int quantity, double price, String picture)
        /*
        Product p = new Product();
        String[] prodInfo = {"2000", "New Brand description", "New product", "New Brand TM", "Dog", "name.jpeg"};
        p.insertDB(prodInfo[0], prodInfo[1], prodInfo[2], prodInfo[3], prodInfo[4], 10, 4.50, prodInfo[5]);
        */
        
        //UdateDB()
        /*
        Product p = new Product();
        p.selectDB("2000");
        p.setBreed("Cat");
        p.setProdName("Another name");
        p.setQuantity(9);
        p.setPrice(2.5);
        p.updateDB();
        */
        
        //DeleteDB()
        /*
        Product p = new Product();
        p.selectDB("2000");
        p.deleteDB();
        */
        
        //getProducts();
        /*Product p = new Product();
        ArrayList<Product> products = p.getProducts();
        for(Product prod : products){
            prod.display();
        }
        System.out.println(products.size());
        */
        
        //searchProducts()
        /*
        Product p = new Product();
        ArrayList<Product> products = p.searchProducts("n");
        for(Product prod : products){
            prod.display();
        }
        System.out.println(products.size());
        */
        
        //getBreed();
        /*
        Product p = new Product();
        ArrayList<Product> products = p.getBreed("Cat");
        for(Product prod : products){
            prod.display();
        }
        System.out.println(products.size());
        */
        
        //getBrand()
        /*
        Product p = new Product();
        ArrayList<Product> products = p.getBrand("Purina");
        for(Product prod : products){
            prod.display();
        }
        System.out.println(products.size());
        */
    }
}