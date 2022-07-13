<%-- 
    Document   : MyOrders
    Created on : Mar 16, 2022, 1:04:34 PM
    Author     : josia
--%>

<%@page import="com.code.business.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header/Header.jsp" %>
    <%@include file="header/Nav.jsp" %>
    <%
        //Customer is already defined in Nav.jsp
       ArrayList<Order> customerOrders = customer.getOrdersByCustId();
       String message = "Your Orders";
     %>
    <body>
            <div style="width: 50%; margin: auto; padding: 4rem;"><h1 style="text-align: center;">Your Orders: <%=customer.getFirstName() + " " + customer.getLastName()%></h1></div>
        
        <table class="table table-bordered table-hover table-danger">
  <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Order ID</th>
      <th scope="col">Order Status</th>
      <th scope="col">Order Date</th>
    </tr>
  </thead>
  <tbody>
         <%
             int count = 1;
             //Get all the orders from the database
             for(Order o : customerOrders){
         %>
    <tr>
        <th scope="row"><%=count++%></th>
      <td><%=o.getOrderId()%></td>
      <td><%=(o.getStatus()? "Shipped" : "Open")%></td>
      <td><%=o.getDate()%></td>
    </tr>
    <%}%>
  </tbody>
</table>
    </body>
</html>
