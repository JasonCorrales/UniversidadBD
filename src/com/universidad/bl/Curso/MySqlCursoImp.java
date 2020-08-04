package com.universidad.bl.Curso;

import com.universidad.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlCursoImp implements ICursoDAO{

    private String sentenciaSQL="";

    public String registrarCurso(Curso curso) throws Exception {
        sentenciaSQL="INSERT INTO CURSO(CODIGO, NOMBRE,CREDITOS) VALUES('"+curso.getCodigo()+"','"+
                      curso.getNombre()+"',"+curso.getCreditos()+")";
        Conector.getConnector().ejecutarSQL(sentenciaSQL);
        return "Curso registrado correctamente!";
    }


    public String modificarCurso(Curso curso) throws Exception {
        sentenciaSQL="UPDATE CURSO SET NOMBRE ='"+curso.getNombre()+"', CREDITOS="+curso.getCreditos()+
                     " WHERE CODIGO='"+ curso.getCodigo() +"'";
        Conector.getConnector().ejecutarSQL(sentenciaSQL);
        return "Curso actualizado de manera correcta!";
    }


    public Curso buscarCurso(String codigo) throws Exception {
        sentenciaSQL = "SELECT * FROM CURSO WHERE CODIGO = '"+codigo+"'";
        ResultSet rs = Conector.getConnector().ejecutarQuery(sentenciaSQL);

        if(rs.next()){
            Curso cursito = new Curso(rs.getString("CODIGO"),
                                      rs.getString("NOMBRE"),
                                      rs.getInt("CREDITOS"));

            return cursito;
        }

        return null;
    }


    public ArrayList<String> listarCursos() throws Exception {

        ArrayList<String> lista = new ArrayList<>();
        sentenciaSQL = "SELECT * FROM CURSO";
        ResultSet rs =Conector.getConnector().ejecutarQuery(sentenciaSQL);

        while(rs.next()){
            Curso cursito = new Curso(rs.getString("CODIGO"),
                    rs.getString("NOMBRE"),
                    rs.getInt("CREDITOS"));

            lista.add(cursito.toString());
        }
        return lista;
    }
}
