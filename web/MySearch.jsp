<%-- 
    Document   : MySearch
    Created on : Mar 16, 2022, 12:04:56 PM
    Author     : josia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header/Header.jsp" %>
    <%@include file="header/Nav.jsp" %>
    <body>
        <%
        ArrayList<Product> searchResults = (ArrayList<Product>)session.getAttribute("searchResults");
    %>
    <body>
        <div class ="container">
        <div class ="card-header my-3"> All Products</div>
        <div class="row">
            <%
                if(!searchResults.isEmpty()){
                    for(Product prod : searchResults){%>
                        
                        <div class="col-md-3 my-3">
                <div class="card w-100" style="width: 18rem;">
                    <div style="min-height:200px; background: url(<%=prod.getPicture()%>); background-size:cover;" >
                        </div>
                     <div class="card-body">
                      
                         <h6 class="name">Name : <%=prod.getProdName()%> <h6>
                          <h6 class="description">Description : <%=prod.getProdDesc()%> <h6>
                      <h6 class="price">Price : <%=prod.getPrice()%> <h6>
                       <h6 class="brand">Brand : <%=prod.getBrand()%><h6>
                       <h6 class="breed">Breed : <%=prod.getBreed()%> <h6>
                       
                               <div class="mt-3 d-flex justify-content-between ">
                            <a href="AddItemServlet?product-id=<%=prod.getProdId()%>" class="btn btn-dark">Add to Cart</a>
                         </div>
                     </div>
                </div>
          </div>
                      <%}
                }%>
                </div
    </body>
</html>
