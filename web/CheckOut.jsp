<%-- 
    Document   : CheckOut
    Created on : Mar 22, 2022, 5:09:42 AM
    Author     : josia
--%>
<%@page import="com.code.business.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <%@include file="header/Header.jsp" %>
    <%
        
        //When the customer object is created, this means a new customer has started a new session
        Customer customer = (Customer)session.getAttribute("customer");
        
        int cartCount = 0;
        if(customer != null){
            System.out.println("Subtotal " + customer.getSubtotal());
            cartCount = customer.getCartProdCount();
        }
%>
    <body>
        <div>
            <style>
                .navigation{
                    background-color: #F4B8B7;
                    padding: 10px;
                }
                
                .nav-list{
                }
                
                .nav-item{
                    display: inline-block;
                    text-decoration: none;
                }
                
                .nav-link{
                    
                }
            </style>
            <nav class="navigation">
                <ul class="nav-list">
                    <li class="nav-item"><a class="nav-link" href="Catalog.jsp">Catalog</a></li>
                    <li class="nav-item"><a class="nav-link" href="MyCart.jsp">Cart <span class="badge badge-danger"><%=cartCount%><span></a></li>
                    <li class="nav-item"><a class="nav-link" href="LogOutServlet?">Logout</a></li>
                </ul>
            </nav>
                <style>
                    .form{
                        display: grid;
                        grid-template-columns: 100%;
                        grid-template-rows: auto auto auto auto auto auto;
                        width: 50%;
                        margin: auto;
                    }
                    
                    .header{
                        padding: 10px;
                        font-size: 2rem;
                        width: 50%;
                        margin: auto;
                        text-align: center;
                    }
                </style>
            <section>
            <h1 class="header">Input your address information</h1>
            <form class="form" method="get" novalidate="false" action="ConfirmPurchase.jsp">
                    <!-- customer street input field -->
                    <label for="cust-street">Street Address: </label>
                    <input id="street" name="cust-street" type="text">

                    <!-- customer zip code input field -->
                    <label for="cust-zip">Zip Code: </label>
                    <input id="zip" name="cust-zip" type="text">

                    <!-- customer city input field -->
                    <label for="cust-city" >City: </label>
                    <input id="city" name="cust-city" type="text">

                    <!-- state input field -->
                    <label for="cust-state">State</label>
                    <select id="cust-state" name="state">
                        <option value="">please select a state</option>
                        <option value="AL">Alabama</option>
                        <option value="AK">Alaska</option>
                        <option value="AZ">Arizona</option>
                        <option value="AR">Arkansas</option>
                        <option value="CA">California</option>
                        <option value="CO">Colorado</option>
                        <option value="CT">Connecticut</option>
                        <option value="DE">Delaware</option>
                        <option value="DC">District Of Columbia</option>
                        <option value="FL">Florida</option>
                        <option value="GA">Georgia</option>
                        <option value="HI">Hawaii</option>
                        <option value="ID">Idaho</option>
                        <option value="IL">Illinois</option>
                        <option value="IN">Indiana</option>
                        <option value="IA">Iowa</option>
                        <option value="KS">Kansas</option>
                        <option value="KY">Kentucky</option>
                        <option value="LA">Louisiana</option>
                        <option value="ME">Maine</option>
                        <option value="MD">Maryland</option>
                        <option value="MA">Massachusetts</option>
                        <option value="MI">Michigan</option>
                        <option value="MN">Minnesota</option>
                        <option value="MS">Mississippi</option>
                        <option value="MO">Missouri</option>
                        <option value="MT">Montana</option>
                        <option value="NE">Nebraska</option>
                        <option value="NV">Nevada</option>
                        <option value="NH">New Hampshire</option>
                        <option value="NJ">New Jersey</option>
                        <option value="NM">New Mexico</option>
                        <option value="NY">New York</option>
                        <option value="NC">North Carolina</option>
                        <option value="ND">North Dakota</option>
                        <option value="OH">Ohio</option>
                        <option value="OK">Oklahoma</option>
                        <option value="OR">Oregon</option>
                        <option value="PA">Pennsylvania</option>
                        <option value="RI">Rhode Island</option>
                        <option value="SC">South Carolina</option>
                        <option value="SD">South Dakota</option>
                        <option value="TN">Tennessee</option>
                        <option value="TX">Texas</option>
                        <option value="UT">Utah</option>
                        <option value="VT">Vermont</option>
                        <option value="VA">Virginia</option>
                        <option value="WA">Washington</option>
                        <option value="WV">West Virginia</option>
                        <option value="WI">Wisconsin</option>
                        <option value="WY">Wyoming</option>
                    </select>

                    <!-- customer email field -->
                    <label for="cust-email">Email</label>
                    <input id="cust-email" name="cust-email" type="email">

                <!-- Submit button -->
                    <input id="submit" type="submit" value="Submit">
            </form>
        </section>
        </div>
       <script src="js/checkoutvalidation.js"></script>
    </body>
</html>
