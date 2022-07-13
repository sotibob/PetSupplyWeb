<%-- 
    Document   : CloseOrder
    Created on : Mar 19, 2022, 8:06:02 PM
    Author     : josia
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.code.business.OrderDetail"%>
<%@page import="com.code.business.Order"%>
<%@page import="com.code.business.Product"%>
<%@page import="com.code.business.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header/EmployeeHeader.jsp"%>
    <%@include file="header/EmployeeNav.jsp"%>
    <%
      String orderId = request.getParameter("order-id");
      String custId = request.getParameter("cust-id");
      OrderDetail orderDetail = new OrderDetail();
      orderDetail.setOrderId(Integer.parseInt(orderId));
      ArrayList<OrderDetail> details = (ArrayList)orderDetail.selectByOrderId();
      Customer customer = new Customer();
      customer.select(Integer.parseInt(custId));
      Order order = new Order();
      order.select(Integer.parseInt(orderId));
      Product product;
    %>
    <body>
        <form action="CloseOrderServlet" method="post">
            <label>Order ID: </label><input name="order-id" type="text" value="<%=order.getOrderId()%>" readonly="true">
            <label>Customer Name: </label><input name="cust-name" type="text" value="<%=customer.getFirstName() + " " + customer.getLastName()%>" readonly="true">
            <label>Street: </label><input name="street" type="text" value="<%=order.getStreet()%>" readonly="true">
            <label>City: </label><input name="city" type="text" value="<%=order.getCity()%>" readonly="true">
            <label>Zip Code: </label><input name="zip" type="text" value="<%=order.getZip()%>" readonly="true">
            <label>State: </label><input name="state" type="text" value="<%=order.getState()%>" readonly="true">

            <label>Order Date: </label><input name="order-date" type="text" value="<%=order.getDate()%>" readonly="true">
            <label>Order Status: </label><input name="order-status" type="text" value="<%=(order.getStatus())?"Shipped":"Closed"%>" readonly="true">
            <%for(OrderDetail od : details){
                product = new Product();
                product.select("" + od.getProdId());
            %>
                <label>Product ID: </label><input name="prod-id" type="text" value="<%=product.getProdId()%>" readonly="true">
                <label>Product Name: </label><input name="prod-name" type="text" value="<%=product.getProdName()%>" readonly="true">
                <label>Product Description: </label><input name="prod-desc" type="text" value="<%=product.getProdDesc()%>" readonly="true">
                <label>Quantity: </label><input name="order-quantity" type="text" value="<%=od.getQuantity()%>" readonly="true">
            <%}%>
            
            <input name="submit" type="submit" value="Close Order">
        </form>
    </body>
</html>
