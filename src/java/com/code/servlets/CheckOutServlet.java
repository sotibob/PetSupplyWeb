
package com.code.servlets;

import com.code.business.Customer;
import com.code.business.Order;
import com.code.business.OrderDetail;
import com.code.business.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author josia
 */
@WebServlet(name = "CheckOutServlet", urlPatterns = {"/CheckOutServlet"})
public class CheckOutServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Get the customer's address info from the previous jsp
            String street = request.getParameter("cust-street");
            String city = request.getParameter("cust-city");
            String zip = request.getParameter("cust-zip");
            String state = request.getParameter("cust-state");
            String email = request.getParameter("cust-email");
            //Get the session object from the request object
            HttpSession sesh = request.getSession();
            
            //Get the customer object from the sesh object
            Customer customer = (Customer)sesh.getAttribute("customer");
            
            // Set all the neccessary customer properties
            customer.setEmail(email);
            customer.getAddress().setStreet(street);
            customer.getAddress().setCity(city);
            customer.getAddress().setState(state);
            customer.getAddress().setZip(zip);
            
            // Upload the customer's order to the database
            // If uploadOrder returns true, then redirect user to the thank you page
            if(customer.uploadOrder())
                // Forward control to the next jsp page
                response.sendRedirect("Catalog.jsp");
            else
                request.getRequestDispatcher("OrderError.html").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
