package com.universidad.dl;

import java.sql.*;

public class AccesoBD {

    private Connection conn = null;
    private Statement stmt = null;

    public AccesoBD(String URL, String user, String password) throws Exception {
        conn = DriverManager.getConnection(URL,user,password);
    }

    //Se usa para todos los INSERT, UPDATE O DELETE
    public void ejecutarSQL(String query) throws Exception{
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
    }

    //Se usa para todas las consultas (SELECT)
    public ResultSet ejecutarQuery(String query) throws Exception{
        ResultSet rs = null;
        stmt = conn.createStatement();
        rs = stmt.executeQuery(query);

        return rs;
    }
}
