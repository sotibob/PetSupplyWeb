<%-- 
    Document   : header
    Created on : Mar 10, 2022, 2:35:24 PM
    Author     : josia
--%>

<%@page import="com.code.business.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Employee employee = (Employee)session.getAttribute("employee");
    
%>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                
      <div class="nav collapse navbar-collapse" id="navbarSupportedContent">
                <a class="navbar-brand" href="#">The Pet Kiosk (Employee)</a>

        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="EmployeeHome.jsp">Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="OpenOrders.jsp">Open Orders</a>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="LogOutServlet?">Log Out</a>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="EmployeeProfile.jsp?">Profile</a>
          </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" action="http://localhost:8084/PetSupplyWeb/OrderSearchServlet" method="post">
          <input class="form-control mr-sm-2" type="search" name="query" placeholder="Search orders" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search Orders</button>
        </form>
      </div>
      
    </nav>
