package com.code.business;

import java.util.ArrayList;


public class ShoppingCart {
    //These are all my global variables and an ArrayList to hold products in a cart
    
    // OuterArray = {Product1 = {product_id, customer_quantity}, Product2 = {product_id, customer_quantity}, Product3 = {product_id, customer_quantity}}
    private ArrayList<int[]> cart;
    private int prodCount = 0;
    private double subtotal = 0.0;
    private double total = 0.0;

    public ShoppingCart() {
        this.cart = new ArrayList<>();
    }

    //This method is used to add products to the arrayList
    public void addProduct(Product p) {
        boolean match = false;
        for(int[] i : cart){
            if(i[0] == p.getProdId()){
                match = true; //Found a match in our array
                i[1]++; //Increment the quantity of that item
            }
        }
        //If there was no match, then we need to create a new int[] for the product
        if(!match){
            cart.add(new int[]{p.getProdId(), 1});
        }
        prodCount++;
        subtotal += p.getPrice();
    }

    //This method is used to remove products from the ArrayList
    public int removeProduct(Product p) {
        int k = -1;
        for(int[] i : cart){
            if(i[0] == p.getProdId() && i[1] > 1){
                i[1]--; //This test determines if the current product has more than one quantity
                subtotal -= p.getPrice();
                k = 1;
                break;
            }else if(i[0] == p.getProdId()){ //This means that the current product has a 0 amount
                cart.remove(i);
                subtotal -= p.getPrice();
                k = 1;
                break;
            }
        }
        if(prodCount > 0) prodCount--;
        return k; //Return -1 if there were no matches found
    }
    
    public boolean removeWholeProduct(Product p){
        for(int[] i : cart){
            if(i[0] == p.getProdId()){
                for(int j = 0; j < i[1]; j++){
                    subtotal -= p.getPrice();
                }
                cart.remove(i);
                prodCount -= i[1];
                return true;
            }
        }
        return false;
    }

    //My set and get methods
    public int getProdId(int index) {
        if(index < 100 && index > -1){
            return cart.get(index)[0];
        }
        return -1;
    }
    
    public int getProdCount(){
        return prodCount;
    }
    
    public int getProdCount(int id){
        for(int[] i : cart){
            if(i[0] == id) return i[1];
        }
        return -1; //Return -1 if no product was found
    }

    public ArrayList<int[]> getCart() {
        return cart;
    }

    public int getSize() {
        return cart.size();
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTax() {
        return subtotal * 0.0731;
    }

    public double getTotal() {
        return getSubtotal() + getTax();
    }

    //Display method to display all information stored
    public void display() {
        for(int[] i : cart){
            String message = "Product ID: " + i[0] + " Customer quantity " + i[1];
            System.out.println(message);
        }
        System.out.println("Subtotal = " + getSubtotal() + " Tax = " + getTax() + " Total = " + getTotal());
    }
    
    public static void main(String[] args){
        ShoppingCart cart = new ShoppingCart();
        Product p = new Product();
        p.select("1");
        Product p1 = new Product();
        p1.select("2");
        for(int i = 0; i < 3; i++){
            cart.addProduct(p);
        cart.addProduct(p1);
        }
        
        cart.display();
    }
}
