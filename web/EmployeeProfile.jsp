<%-- 
    Document   : EmployeeProfile
    Created on : Mar 19, 2022, 8:01:55 PM
    Author     : josia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <style>
        form{
            margin: 2rem;
        }
        .wrapper{
            width: 50%;
            margin: auto;
        }
        
        #submit{
            width: 100%;
        }
        #submit:hover{
            cursor: pointer;
        }
    </style>
    <%@include file="header/EmployeeHeader.jsp" %>
    <%@include file="header/EmployeeNav.jsp" %>
    <body>
        <div style="width: 50%; margin: auto; padding: 4rem;"><h1 style="text-align: center;">Edit Profile: <%=employee.getFirstName() + " " + employee.getLastName()%></h1></div>
        <form action="UpdateEmployeeServlet" method="post">
            <div class="wrapper">
                <div class="form-group">
                <label for="first-name">First Name </label><input id="first-name" class="form-control" name="first-name" type="text" value="<%=employee.getFirstName()%>">
              </div>
              <div class="form-group"><label for="last-name">Last Name </label><input id="last-name" class="form-control" name="last-name" type="text" value="<%=employee.getLastName()%>"></div>
            
              <div class="form-group"><label for="email">Email </label><input id="email" class="form-control" name="email" type="text" value="<%=employee.getEmail()%>"></div>
              <div class="form-group"><label for="username">Username </label><input id="username" class="form-control" name="username" type="text" value="<%=employee.getUsername()%>"></div>
              <div class="form-group"><label for="password">Password </label><input id="password" class="form-control" name="password" type="text" value="<%=employee.getPassword()%>"></div>
            
              <div class="form-group"><label for="street">Street </label><input id="street" class="form-control" name="street" type="text" value="<%=employee.getAddress().getStreet()%>"></div>
              <div class="form-group"><label for="zip">Zip code </label><input id="zip" class="form-control" name="zip" type="text" value="<%=employee.getAddress().getZip()%>"></div>
              <div class="form-group"><label for="city">City </label><input id="city" class="form-control" name="city" type="text" value="<%=employee.getAddress().getCity()%>"></div>
            <div class="form-group"><label for="state">State </label><select id="state" class="form-control" name="state">
                        <option value="<%=employee.getAddress().getState()%>"><%=employee.getAddress().getState()%></option>
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
                </select>	</div>	
              <div class="form-group"><label for="phone">Phone </label><input id="phone" class="form-control" name="phone" type="text" value="<%=employee.getPhoneNo()%>"></div>
              <div style="width: 50%; margin: auto;"><input id="submit" class="btn-primary" type="submit" value="Confirm Changes"><div>
            </div>
        </form>
    </body>
</html>
