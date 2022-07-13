<%-- 
    Document   : LoginError
    Created on : Mar 29, 2022, 12:09:31 AM
    Author     : sotic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Error!</title>
        <style>
            body{font-family: cursive;
                color: dimgray;}
            h1  {font-size: 6em;
                 color: black;
                font-weight: bold;}
            h4  {color: purple;
                font-size: 2em;}
            div {margin: 10px;
                background-color: #E5E5E5;
                border-radius: 7px;
                padding-top: 5%;
                padding-bottom: 7%;
                padding-left: 10px;
                padding-right: 10px;}
            hr  {border-style: none;
                border-top-style: dotted;
                border-color: black;
                border-width: 5px;
                width: 30%;}
            input {font-family: cursive;
                    color: purple;
                    border-top-style: none;
                    border-left-style: none;
                    border-right-style: none;
                    border-bottom-color: purple;
                    border-width: 1px;
                    background-color: #E5E5E5;
                    cursor: pointer;}
            input:hover {color: blue;
                        border-bottom-color: blue;}
            input:active{color: black;
                        border-bottom-color: black;}
        </style>
    </head>
    <body>
        <center>
            <div>
                <h1>Login Error!</h1>
                <h4>There was an error trying to Login to your account.</h4>
                <p>The log in details entered does not match any in our records. Please return to the Login page and try again!</p>
                <form>
                    <input type="button" value="Click on this link to go back!" onclick="history.back()">
                </form>
            </div>
            <hr>
        </center>
    </body>
</html>