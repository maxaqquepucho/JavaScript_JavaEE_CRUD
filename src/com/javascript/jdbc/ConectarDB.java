package com.javascript.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConectarDB {
	
	 private Connection connection;
	    private String url = "jdbc:mysql://localhost/javascript_CRUD";
	    private String usuario = "root";
	    private String contraseņa = "";
	    
	    public Connection getConnection(){
	        return connection;
	    }
	    
	    public void setConnection(Connection connection){
	        this.connection = connection;
	    }
	    	
	    public void establecerConexion(){
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            connection =  (Connection) DriverManager.getConnection(url, usuario, contraseņa);
	            System.out.println("Conexion Exitosa");
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(ConectarDB.class.getName()).log(Level.SEVERE, null, ex);
	            ex.printStackTrace();
	        } catch (SQLException ex) {
	            Logger.getLogger(ConectarDB.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	    
	    public void cerrarConexion(){
	        try {
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("Conexion cerrarda");
	        }
	    }
	    
}
