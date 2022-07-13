
package com.code.servlets;

import com.code.business.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josia
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            //Get parameters
            String username = request.getParameter("cust-username");
            String password = request.getParameter("cust-password");
            Customer c = new Customer();
            if(c.selectByUsername(username) && c.getPassword().equals(password)){
                c.setLogin(true);
                request.getSession().setAttribute("customer", c);
                response.sendRedirect("Catalog.jsp");
            } else{
                response.sendRedirect("LoginError.jsp");
            }
            
            
        }
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        processRequest(request, response);
    }

}
