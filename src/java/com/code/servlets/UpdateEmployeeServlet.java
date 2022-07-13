
package com.code.servlets;

import com.code.business.Address;
import com.code.business.Employee;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "UpdateEmployeeServlet", urlPatterns = {"/UpdateEmployeeServlet"})
public class UpdateEmployeeServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String fName = request.getParameter("first-name");
            String lName = request.getParameter("last-name");
            String email = request.getParameter("email");
            String uName = request.getParameter("username");
            String password = request.getParameter("password");
            String street = request.getParameter("street");
            String city = request.getParameter("city");
            String zip = request.getParameter("zip");
            String state = request.getParameter("state");
            String phone = request.getParameter("phone");
            HttpSession sesh = request.getSession();
            Employee employee = (Employee)sesh.getAttribute("employee");
            employee.setFirstName(fName);
            employee.setLastName(lName);
            employee.setEmail(email);
            employee.setUsername(uName);
            employee.setPassword(password);
            employee.setAddress(new Address(street, city, state, zip));
            employee.setPhoneNo(phone);
            employee.update();
            sesh.setAttribute("employee", employee);
            request.getRequestDispatcher("EmployeeProfile.jsp").forward(request, response);
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
