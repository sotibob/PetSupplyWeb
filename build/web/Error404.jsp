<%-- 
    Document   : Error404
    Created on : Mar 28, 2022, 7:02:30 PM
    Author     : sotic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>404 Error!</title>
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
                <h1>404</h1>
                <h4>Page Not Found!</h2>
                <p>We're sorry, but we can't find the page you're looking for. It's probably something we've done wrong, but now we know about it, and we'll try to fix it.</p>
                <form>
                    <input type="button" value="Click on this link to go back!" onclick="history.back()">
                </form>
            </div>
            <hr>
        </center>
    </body>
</html>
