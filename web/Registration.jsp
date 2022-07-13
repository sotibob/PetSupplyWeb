<%-- 
    Document   : Registration
    Created on : Mar 11, 2022, 1:45:21 PM
    Author     : josia
--%>

<%@page import="com.code.business.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header/Header.jsp" %>
    <%
        String message = request.getParameter("isCustomer");
        if(message != null){
            message = "That username already exists. Please try again.";
        }else{
            message = "Let's get started";
        }
    %>
    <body>
        <style>
        *{
            box-sizing: border-box;
        }

        .login-section{
            margin-top: 2rem;
            display: flex;
            justify-content: center;
            align-content: center;
            align-self: center;
        }

        .login-form{
            display: grid;
            grid-template-columns: auto;
            grid-template-rows: auto auto auto auto auto;
        }
        h1{
            margin-top: 5rem;
            display: flex;
            justify-content: center;
            align-content: center;
            align-self: center;
        }
    </style>
    <h1>Register Your Account</h1>
    <section class="login-section">
        <form class="login-form" novalidate="false" method="get" action="http://localhost:8084/PetSupplyWeb/RegistrationServlet">
            <!-- First name input -->
            <input type="text" id="first-name" name="first-name">
            <label for="first-name">Your First Name</label>

            <!-- Last name input -->
            <input type="text" id="last-name" name="last-name">
            <label for="last-name">Your Last Name</label>

            <!-- Username input -->
            <input type="text" id="username" name="username">
            <label for="username">Your Username</label>

            <!-- Email input -->
            <input type="email" id="email" name="email">
            <label for="email">Your Email</label>

            <!-- First password entry input -->
            <input type="password" id="password" name="password">
            <label class="form-label" for="password">Password</label>

            <!-- Retype password input -->
            <input type="password" id="password-repeat" name="password-repeat" class="form-control form-control-lg" />
            <label for="password-repeat">Repeat your password</label>

            <!-- Phone field -->
            <input type="tel" id="phone" name="phone">
            <label for="phone">Enter your phone number</label>

            <!-- Submit button -->
            <input type="submit" id="submit" value="Register Account">

            <p>Already have an account? <a href="Login.jsp">Login here.</a></p>

        </form>
    </section>
    <script src="js/registrationvalidation.js"></script>
    </body>
</html>
