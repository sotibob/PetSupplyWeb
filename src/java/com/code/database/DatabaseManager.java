
package com.code.database;
import java.sql.*;
public class DatabaseManager {
    private final String user = "root";
    private final String pass = "56871157015forever!?";
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String path = "jdbc:mysql://localhost:3306/petsupplyschema?useSSL=false&allowPublicKeyRetrieval=true";
    
    private Connection conn = null;
    
    public DatabaseManager(){}
    
    private boolean establishConnection() throws SQLException, ClassNotFoundException {
        //Load the driver
        Class.forName(driver);
        //Get the connection
        conn = DriverManager.getConnection(path, user, pass);
        return true;
    }
    
    public ResultSet executeSQLSelect(String sql) throws SQLException{
        //Try to establish a connection to the database
        boolean isConnected = false;
        try{
           isConnected = establishConnection(); 
        }catch(ClassNotFoundException e){
            System.out.println(e + " Database connection failed...");
        }
        
        return conn.createStatement().executeQuery(sql);
    }
    
    public int executeSQLUpdate(String sql) throws SQLException{
        //Try to establish a connection to the database
        boolean isConnected = false;
        try{
           isConnected = establishConnection(); 
        }catch(ClassNotFoundException e){
            System.out.println(e + " Database connection failed...");
        }
        
        return conn.createStatement().executeUpdate(sql);
    }
    
    public boolean closeConnection(){
        boolean isClosed = false;
        if(conn != null)
            try{
                conn.close();
                isClosed = true;
            } catch(SQLException e){
                System.out.println("Cannot close the connection... " + e);
            }
        return isClosed;
    }
}
