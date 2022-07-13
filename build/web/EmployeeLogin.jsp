<%-- 
    Document   : EmployeeLogin
    Created on : Mar 10, 2022, 2:56:14 PM
    Author     : josia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="header/EmployeeHeader.jsp"%>
    <body>
        <section class="vh-100 gradient-custom">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card bg-dark text-white" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">
              <form id="emp-login-form" name="emp-login-form" action="http://localhost:8084/PetSupplyWeb/EmployeeLoginServlet" method="post">
            <div class="mb-md-5 mt-md-4 pb-5">

              <h2 class="fw-bold mb-2 text-uppercase">Login</h2>
              <p class="text-white-50 mb-5">Please enter your Employee ID and password.</p>

              <div class="form-outline form-white mb-4">
                <input type="text" id="typeEmpIdX" name="emp-username" class="form-control form-control-lg" />
                <label class="form-label" for="typeEmpIdX">Employee Username</label>
              </div>

              <div class="form-outline form-white mb-4">
                <input type="password" id="typePasswordX" name="emp-password" class="form-control form-control-lg" />
                <label class="form-label" for="typePasswordX">Password</label>
              </div>

              <button class="btn btn-outline-light btn-lg px-5" type="submit">Login</button>

            </div>
          </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
    </body>
</html>
