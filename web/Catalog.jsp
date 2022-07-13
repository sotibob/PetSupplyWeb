<%-- 
    Document   : Catalog
    Created on : Mar 10, 2022, 2:38:17 PM
    Author     : josia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@page import="java.util.ArrayList, com.code.business.Product, com.code.business.Customer" %>
    <%@include file="header/Header.jsp"%>
    <%@include file="header/Nav.jsp"%>
    <%
        int pageNum = 1;
        if(request.getParameter("page") != null)
            pageNum = Integer.parseInt(request.getParameter("page"));
        int total = 6;
        if(pageNum==1){}  
        else{  
            pageNum=pageNum - 1;  
            pageNum=pageNum * total + 1;  
        }  
        ArrayList<Product> catalog = new Product().getProducts(pageNum, total);
    %>
    <body>
        <div class ="container">
        <div class ="card-header my-3" style="background-color: navy;"> All Products</div>
        <div class="row">
            <%
                if(!catalog.isEmpty()){
                    for(Product prod : catalog){%>
                        
                        <div class="col-md-4 my-4">
                <div class="card w-100" style="width: 18rem;">
                    <div style="min-height: 350px; background: url(<%=prod.getPicture()%>); background-size:cover;" >
                        </div>
                     <div class="card-body">
                      
                         <h6 class="name">Name : <%=prod.getProdName()%> <h6>
                          <h6 class="description">Description : <%=prod.getProdDesc()%> <h6>
                      <h6 class="price">Price : <%=prod.getPrice()%> <h6>
                       <h6 class="brand">Brand : <%=prod.getBrand()%><h6>
                       <h6 class="breed">Breed : <%=prod.getBreed()%> <h6>
                       
                               <div class="mt-3 d-flex justify-content-between ">
                            <a href="AddItemServlet?page=Catalog.jsp&product-id=<%=prod.getProdId()%>" class="btn btn-dark">Add to Cart</a>
                         </div>
                     </div>
                </div>
          </div>
                      <%}
                }%>
        </div>
        <footer style="display: flex; justify-content: center; margin: 1rem;">
            <a class="mx-1 btn btn-primary" href="Catalog.jsp?page=1">Page 1</a>
            <a class="mx-1 btn btn-primary" href="Catalog.jsp?page=2">Page 2</a>
            <a class="mx-1 btn btn-primary" href="Catalog.jsp?page=3">Page 3</a>
            <a class="mx-1 btn btn-primary" href="Catalog.jsp?page=4">Page 4</a>
            <a class="mx-1 btn btn-primary" href="Catalog.jsp?page=5">Page 5</a>
        </footer>
    </body>
</html>
