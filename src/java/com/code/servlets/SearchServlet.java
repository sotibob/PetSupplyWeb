package com.code.servlets;

import com.code.business.Product;
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


@WebServlet(name = "SearchServlet", urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //Connect to the database
              DatabaseManager database = new DatabaseManager();
              //Create a result set variable
              ResultSet rs;
              //Get the search string from the from
              String query = request.getParameter("query");
              //Create list of products to hold
              ArrayList<Product> searchResults = new ArrayList<>();
              try{
                  //Create the database search string using the query from the user
                  String sql = "SELECT * FROM products WHERE breed LIKE '%" + query + "%' OR brand LIKE '%" + query + "%' OR product_name LIKE '%" + query + "%' OR price LIKE '%" + query + "%'";
                  rs = database.executeSQLSelect(sql); //Execute the query
                  Product p1; //Create a product variable
                  while(rs.next()){ //Process the search results from the user's query
                      p1 = new Product();
                        p1.setProdId(rs.getInt(1));
                        p1.setProdName(rs.getString(2));
                        p1.setProdDesc(rs.getString(3));
                        p1.setQuantity(rs.getInt(4));
                        p1.setPrice(rs.getDouble(5));
                        p1.setPicture(rs.getString(6));
                        p1.setBrand(rs.getString(7));
                        p1.setBreed(rs.getString(8));
                        searchResults.add(p1);
                  }
                  database.closeConnection(); //Close the database connection
              }catch(SQLException e){
                  System.out.println(e + " Error with database...");
              }
              //Add the list of products to the session
              request.getSession().setAttribute("searchResults", searchResults);
              request.getRequestDispatcher("MySearch.jsp").forward(request, response);
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
