<%-- 
    Document   : MyProfile
    Created on : Mar 19, 2022, 8:02:08 PM
    Author     : josia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header/Header.jsp" %>
    <%@include file="header/Nav.jsp" %>
    <body>
        <style>
            .wrapper{
                width: 50%;
                margin: auto;
            }
            #submit{
            width: 100%;
        }
        #submit:hover{
            cursor: pointer;
        }
        </style>
        <div style="width: 50%; margin: auto; padding: 4rem;"><h1 style="text-align: center;">Edit Profile: <%=customer.getFirstName() + " " + customer.getLastName()%></h1></div>
        <div class="wrapper">
        <form action="UpdateCustomerServlet" method="post">
            
            <div class="form-group"><label for="first-name">First Name </label><input id="first-name" class="form-control" name="first-name" type="text" value="<%=customer.getFirstName()%>"></div>
            <div class="form-group"><label for="last-name">Last Name </label><input id="last-name" class="form-control" name="last-name" type="text" value="<%=customer.getLastName()%>"></div>
            <div class="form-group"><label for="email">Email </label><input id="email" class="form-control" name="email" type="text" value="<%=customer.getEmail()%>"></div>
            <div class="form-group"><label for="username">Username </label><input id="username" class="form-control" name="username" type="text" value="<%=customer.getUsername()%>"></div>
            <div class="form-group"><label for="password">Password </label><input id="password" class="form-control" name="password" type="text" value="<%=customer.getPassword()%>"></div>
            <div class="form-group"><label for="phone">Phone # </label><input id="phone" class="form-control" name="phone" type="text" value="<%=customer.getPhoneNo()%>"></div>
            <div class="form-group"><input id="submit" class="btn-danger" type="submit" value="Confirm Changes"></div>
        </form>
        </div>
    </body>
</html>
