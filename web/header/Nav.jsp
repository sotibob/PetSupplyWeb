<%-- 
    Document   : header
    Created on : Mar 10, 2022, 2:35:24 PM
    Author     : josia
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.code.business.Product"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.code.business.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.code.database.*"%>
<style>
          .nav{
              background-color: #F4B8B7;
          }
      </style>
<%
        //When the customer object is created, this means a new customer has started a new session
        Customer customer = (Customer)session.getAttribute("customer");
        
        int cartCount = 0;
        if(customer != null){
            System.out.println("Subtotal " + customer.getSubtotal());
            cartCount = customer.getCartProdCount();
            if(customer.isLogin()){%>
            
                <nav class="nav navbar navbar-expand-lg navbar-light bg-light" style="background-color: ">
      

      
      <div class="nav collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
            <a class="nav-link" href="index.html">Pet Kiosk <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="index.html">Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
              <a class="nav-link" href="MyCart.jsp">Cart <span id="cart-count" class="badge badge-danger"><%=cartCount%><span></a>
          </li>
          <li class="nav-item">
              <a class="nav-link" href="Catalog.jsp">Catalog</a>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="MyOrders.jsp">Orders</a>
          </li>
<!--          <li class="nav-item">
            <a class="nav-link disabled" href="Login.jsp">Login</a>
          </li>-->
          <li class="nav-item">
            <a class="nav-link disabled" href="LogOutServlet?">Log Out</a>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="MyProfile.jsp">Profile</a>
          </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" action="http://localhost:8084/PetSupplyWeb/SearchServlet">
          <input class="form-control mr-sm-2" name="query" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
      </div>
    </nav>
        <%} else{%>
        <nav class=" navbar navbar-expand-lg navbar-light bg-light">

      <div class=" nav collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
            <a class="nav-link" href="index.html">Pet Kiosk <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="index.html">Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
              <a class="nav-link" href="MyCart.jsp">Cart <span id="cart-count" class="badge badge-danger"><%=cartCount%><span></a>
          </li>
          <li class="nav-item">
              <a class="nav-link" href="Catalog.jsp">Catalog</a>
          </li>
<!--          <li class="nav-item">
            <a class="nav-link disabled" href="MyOrders.jsp">Orders</a>
          </li>-->
          <li class="nav-item">
            <a class="nav-link disabled" href="Login.jsp">Login</a>
          </li>
<!--          <li class="nav-item">
            <a class="nav-link disabled" href="LogOutServlet?">Log Out</a>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="MyProfile.jsp">Profile</a>
          </li>-->
        </ul>
        <form class="form-inline my-2 my-lg-0" action="http://localhost:8084/PetSupplyWeb/SearchServlet">
          <input class="form-control mr-sm-2" name="query" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
      </div>
    </nav><%}%>
        <%}else{
            Customer c = new Customer();
            //Put the customer in the session
            //The customer can add items to the cart, or the customer could login
            session.setAttribute("customer", c);%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
      

      <div class="nav collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
            <a class="nav-link" href="index.html">Pet Kiosk <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item active">
            <a class="nav-link" href="index.html">Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
              <a class="nav-link" href="MyCart.jsp">Cart <span id="cart-count" class="badge badge-danger"><%=cartCount%><span></a>
          </li>
          <li class="nav-item">
              <a class="nav-link" href="Catalog.jsp">Catalog</a>
          </li>
<!--          <li class="nav-item">
            <a class="nav-link disabled" href="MyOrders.jsp">Orders</a>
          </li>-->
          <li class="nav-item">
            <a class="nav-link disabled" href="Login.jsp">Login</a>
          </li>
<!--          <li class="nav-item">
            <a class="nav-link disabled" href="LogOutServlet?">Log Out</a>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="MyProfile.jsp">Profile</a>
          </li>-->
        </ul>
        <form class="form-inline my-2 my-lg-0" action="http://localhost:8084/PetSupplyWeb/SearchServlet">
          <input class="form-control mr-sm-2" name="query" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
      </div>
    </nav><%}%>