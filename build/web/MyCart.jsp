<%-- 
    Document   : Cart.jsp
    Created on : Mar 11, 2022, 9:55:18 AM
    Author     : josia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@page import="java.text.DecimalFormat"%>
    <%@page import="java.util.ArrayList, com.code.business.Customer, com.code.business.Product"%>
    <%@include file="header/Header.jsp"%>
    <%@include file="header/Nav.jsp"%>
    <style>
        *{
            color:black;
        }
    </style>
    <body>
        <div class="container">
            
            
            
            
            <div class="d-flex py-3"> 
                
                <a id="check-out-btn" class="mx-3 btn btn-primary" href="CheckOut.jsp?">Check out</a>
                <a class="mx-3 btn btn-primary" href="CancelCartServlet?">Cancel</a>

            </div>
                <%
        DecimalFormat dcf = new DecimalFormat();
        ArrayList<int[]> customerCart = null;
        int total = 0;
        if(customer != null && customer.getCartCount() != 0){
           customerCart = customer.getCartProducts();
    %>
    <div style="float: left; width: 75%;">
            	<table class="table table-loght">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Breed</th>
					<th scope="col">Price</th>
                                        <th scope="col"></th>
                                        <th scope="col"></th>
                                        <th scope="col"></th>
				</tr>
			</thead>
                <tbody>
                    <%
                Product p = null;
                
              for(int[] i : customerCart){
                  p = new Product();
                  p.select("" + i[0]);
            %>
                    
                                    <tr>  
                              <td><%=p.getProdName()%></td>
                              <td><%=p.getBreed()%></td>
                               <td><%=p.getPrice()%>$</td>
                               <td>

                                       <input type="hidden" name="productId" value="<%=p.getProdId()%>" class="form-input">
                                       <div class="form-group d-flex justify-content-between">

                                             <a class="btn btn-sm btn-decre" href="RemoveItemServlet?product-id=<%=p.getProdId()%>"><i class="fas fa-minus-square"></i></a>

                                       <input type="text" name="quntity"  class="form-control product-count" value ="<%=i[1]%>">
                                             <a class="btn btn-sm btn-decre" href="AddItemServlet?product-id=<%=p.getProdId()%>"><i class="fas fa-plus-square"></i></a>
                                       </div>


                               </td>
                               <td><a class="btn btn-sm btn-outline-danger" href = "RemoveFromCartServlet?product-id=<%=p.getProdId()%>">Remove</a></td>
                               
                          

                               <% }
                            }
                            
                            %>
                            
                            <td>
                                <p>Subtotal : $<%=(customer.getCartSubtotal() > 0) ? dcf.format(customer.getCartSubtotal()) : 0%></p></td>
                            <td><p>Tax : $<%=(customer.getCartTax() > 0) ? dcf.format(customer.getCartTax()) : 0%></p></td>
                            <td><p>Total : $<%=(customer.getCartTotal() > 0) ? dcf.format(customer.getCartTotal()) : 0%></p></td>

                            </tr>
                      
                </tbody>
               
            </table>
    </div>
                            
        </div>
    </body>
   
</html>
