package com.lab.aw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lab.exception.GlobalcodeException;



public class ConnectionManager {

	private static final String DRIVER = "jdbc";
	private static final String DB = "mysql";
	private static final String HOST = "localhost";
	private static final String IP = "3306";
	private static final String DATABASE = "trainee";
	private static final String TIMEZONE = "?useTimezone=true&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "";

    public static Connection getConexao() throws GlobalcodeException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
					ConnectionManager.DRIVER + ":" +
					ConnectionManager.DB + "://" +
					ConnectionManager.HOST + ":" +
					ConnectionManager.IP + "/" +
					ConnectionManager.DATABASE + 
					ConnectionManager.TIMEZONE,
					ConnectionManager.USER,
					ConnectionManager.PASSWORD);
            
            System.out.println("[ConnectionManager]: Obtendo conexao");
            return conn;
        } catch (ClassNotFoundException e) {
            String errorMsg = "Driver nao encontrado";
            throw new GlobalcodeException(errorMsg, e);
        } catch (SQLException e) {
            String errorMsg = "Erro ao obter a conexao";
            throw new GlobalcodeException(errorMsg, e);
        }
    }

    public static void closeAll(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (conn != null || stmt != null) {
                closeAll(conn, stmt);
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeAll(Connection conn, Statement stmt) {
        try {
            if (conn != null) {
                closeAll(conn);
            }
            if (stmt != null) {
                stmt.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
