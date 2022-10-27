package com.ifgoiano.bank.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Connect {
    public static final String SERVIDOR = "jdbc:mysql://localhost:cadastro_banco?useTimezone=true&serverTimezone=UTC";
    public static final String USUARIO = "root";
    public static final String SENHA = "";
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static final String URL = "jdbc:mysql://localhost:3306/cadastro_banco?useTimezone=true&serverTimezone=UTC";

    private static final String USER = "root";

    private static final String PASSWORD = "";

    /*public Connection getConexao() {
        try {
                return DriverManager.getConnection(SERVIDOR, USUARIO, SENHA);
        } catch (SQLException e) {
                throw new RuntimeException(e);
        }
    }*/
    public static Connection getConexao() {

    	try{
    		Class.forName(DRIVER);
    		return DriverManager.getConnection(URL, USER, PASSWORD);
    	}catch(ClassNotFoundException | SQLException ex){
    		System.out.println(ex);
    		return null;
    	}

    }


    public PreparedStatement prepareStatement(String sql, int RETURN_GENERATED_KEYS) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
