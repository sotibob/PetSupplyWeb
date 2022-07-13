
package com.code.servlets;

import com.code.business.Order;
import com.code.database.DatabaseManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josia
 */
@WebServlet(name = "OrderSearchServlet", urlPatterns = {"/OrderSearchServlet"})
public class OrderSearchServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String query = request.getParameter("query");
            // Create a new database connection
            DatabaseManager database = new DatabaseManager();
            String sql = "SELECT * FROM orders WHERE order_id LIKE '%" + query + "%' OR customer_id LIKE '%" + query + "%' OR order_date LIKE '%" + query + "%' OR street LIKE '%" + query + "%' OR city LIKE '%" + query + "%' OR state LIKE '%" + query + "%' OR zipcode LIKE '%" + query + "%' OR email LIKE '%" + query + "%';";
            System.out.println(sql);
            
            // Create a new Order object
            ArrayList<Order> searchResults = new ArrayList<>();
            
            // Execute the query
            ResultSet rs = database.executeSQLSelect(sql);
            
            // Process the results
            Order o;
            while(rs.next()){
                o = new Order();
                o.setOrderId(rs.getInt(1));
                o.setCustId(rs.getInt(2));
                o.setStatus(rs.getBoolean(3));
                o.setDate(rs.getString(4));
                o.setStreet(rs.getString(5));
                o.setCity(rs.getString(6));
                o.setState(rs.getString(7));
                o.setZip(rs.getString(8));
                o.setEmail(rs.getString(9));
                searchResults.add(o);
            }
            
            // Put the search results into the session
            request.getSession().setAttribute("searchResults", searchResults);
            
            // Forward control to the order search page
            request.getRequestDispatcher("SearchOrders.jsp").forward(request, response);
        } catch(SQLException e){
            System.out.println("Error with search servlet... " + e);
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
