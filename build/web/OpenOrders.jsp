<%-- 
    Document   : OpenOrders
    Created on : Mar 19, 2022, 7:41:34 PM
    Author     : josia
--%>

<%@page import="com.code.business.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@include file="header/EmployeeHeader.jsp"%>
<%@include file="header/EmployeeNav.jsp"%>
<body>
<div class="grid"
     <div style="width: 50%; margin: auto; padding: 4rem;"><h1 style="text-align: center;">All Open Orders</h1></div>
    
    <table class="table table-bordered table-hover table-danger">
  <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Order ID</th>
      <th scope="col">Customer ID</th>
      <th scope="col">Order Status</th>
      <th scope="col">Order Date</th>
      <th scope="col">Street</th>
      <th scope="col">City</th>
      <th scope="col">State</th>
      <th scope="col">Zip Code</th>
      <th scope="col">Email</th>
      <th scope="col">Close Order</th>
    </tr>
  </thead>
  <tbody>
         <%
             int count = 1;
             //Get all the orders from the database
             //Get all the orders from the database
             ArrayList<Order> orders = null;
             Order order = new Order();
             orders = order.selectOpenOrders();
             for(Order o : orders){ //Display all orders with the following code
             
         %>
    <tr>
        <th scope="row"><%=count++%></th>
      <td><%=o.getOrderId()%></td>
      <td><%=o.getCustId()%></td>
      <td><%=(o.getStatus()? "Shipped" : "Open")%></td>
      <td><%=o.getDate()%></td>
      <td><%=o.getStreet()%></td>
      <td><%=o.getCity()%></td>
      <td><%=o.getState()%></td>
      <td><%=o.getZip()%></td>
      <td><%=o.getEmail()%></td>
      <td><button class="btn"><a href="CloseOrderServlet?order-id=<%=o.getOrderId()%>">Close Order</a></button>
    </tr>
    <%}%>
  </tbody>
</table>
    </body>
</html>
