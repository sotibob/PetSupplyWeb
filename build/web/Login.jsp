<%-- 
    Document   : Login.jsp
    Created on : Mar 10, 2022, 2:34:51 PM
    Author     : josia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <%@include file="header/Header.jsp" %>
<!--<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="styles.css">
</head>-->
<body>
    <style>
        .header{
            width: 50%;
            margin: auto;
            margin-top: 5rem;
            text-align: center;
            color: #f86773;
        }
        
        .login-section{
            margin-top: 2rem;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        table{
            border-spacing: 1rem;
        }

        .submit-button{
            display: flex;
            justify-content: center;
            margin: 10px 0 10px 0;
        }
    </style>
    <h1 class="header">Login</h1>
    <section class="login-section">
        
        <form class="login-form" novalidate="false" method="post" action="http://localhost:8084/PetSupplyWeb/LoginServlet">
            <!-- Username input -->
            <table>
                <tr>
                    <td>
                        <label class="form-label" for="username">Username:</label>
                    </td>
                    <td>
                        <input type="text" id="username" name="cust-username" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="form-label" for="pasword">Password:</label>
                    </td>
                    <td>
                        <input type="password" id="password" name="cust-password" />
                    </td>
                </tr>
                <tr class="submit-button">
                    
                </tr>
            </table>
            <div class="submit-button">
                <input class="button" id="submit" type="submit" value="Login">
            </div>
            
            <!-- Password input -->
            

            <!-- Submit button -->
        </form>
    </section>
    <script src="js/loginvalidation.js"></script>
</body>
</html>
