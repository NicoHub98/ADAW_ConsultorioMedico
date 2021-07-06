package com.modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    private final String bd = "AO2_medicos";
    private final String username = "root";
    private final String password = "root";
    private final String url = "jdbc:mysql://localhost:3306/" + bd;
    private Connection con = null;
    
    public Connection getConexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
    
}
