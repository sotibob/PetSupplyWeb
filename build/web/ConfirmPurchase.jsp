<%-- 
    Document   : ConfirmPurchase
    Created on : Mar 22, 2022, 6:01:49 PM
    Author     : josia
--%>

<%@page import="com.code.business.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
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
                .wrapper{
                    display: grid;
                    grid-template-columns: auto auto;
                    padding: 1rem;
                    border: 1px solid black;
                }
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
                
                .header{
                    width: 50%;
                    margin: auto;
                    text-align: center;
                    border: 1px solid black;
                    color: blue;
                    background-color: lightblue;
                    font-size: 1.5rem;
                }
                
                .float-left{
                    border: 1px solid black;
                    padding: 1rem;
                }
                
                .float-right{
                    border: 1px solid black;
                    padding: 1rem;
                }
                
                .item{
                    border: 1px solid black;
                    margin-top: 5px;
                    padding: 3px;
                }
                
                h3{
                    font-size: 1.33rem;
                }
            </style>
            <nav class="navigation">
                <ul class="nav-list">
                    <li class="nav-item"><a class="nav-link" href="MyCart.jsp">Cart <span class="badge badge-danger"><%=cartCount%><span></a></li>
                    <li class="nav-item"><a class="nav-link" href="LogOutServlet?">Logout</a></li>
                </ul>
            </nav>
                    <div class="wrapper">
                    <div class="float-left">
                        <h3 class="header">Order Summary</h3>
                    <%
        DecimalFormat dcf = new DecimalFormat();
        ArrayList<int[]> customerCart = null;
        int total = 0;
        if(customer != null && customer.getCartCount() != 0){
           customerCart = customer.getCartProducts();
    %>
            <%
                Product p = null;
                
              for(int[] i : customerCart){
                  p = new Product();
                  p.select("" + i[0]);
            %>
            <div class="item">
            <h3>Name : <%=p.getProdName()%></h3>
            <h3>Breed : <%=p.getBreed()%></h3>
            <h3>Price : <%=p.getPrice()%>$</h3>
            <h3>Quantity : <%=i[1]%></h3>
            </div>
                               <% }
                            }
                            
                            %>
                            <h3>Subtotal :$<%=(customer.getCartSubtotal() > 0) ? dcf.format(customer.getCartSubtotal()) : 0%></h3>
                            <h3>Tax amount :$<%=(customer.getCartTax() > 0) ? dcf.format(customer.getCartTax()) : 0%></h3>
                            <h3>Total price :$<%=(customer.getCartTotal() > 0) ? dcf.format(customer.getCartTotal()) : 0%></h3>
                    </div>
            <style>
                .user-data{
                    display: grid;
                    grid-template-columns: auto auto;
                    grid-template-rows: auto auto auto auto auto;
                    row-gap: .66rem;
                    width: 50%;
                    margin: auto;
                }
                
                #submit{
                }
                
                
            </style>
            <section class="float-right">
                <h3 class="header">Confirm Your Info</h3>
                <form id="form" class="user-data" action="http://localhost:8084/PetSupplyWeb/CheckOutServlet">
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
                <select id="cust-state" name="cust-state">
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
                <input id="email" name="cust-email" type="email">
                <input id="submit" type="submit" value="Confirm Purchase">
                </form>
            </section>
            <script>
                const form = document.getElementById("form");
                
                form.addEventListener("click", ()=>{alert("Thank you for shopping with us! Come again soon!")}, false);
            </script>
                    </div>
        <script src="js/getuserdata.js"></script>
    </body>
</html>
