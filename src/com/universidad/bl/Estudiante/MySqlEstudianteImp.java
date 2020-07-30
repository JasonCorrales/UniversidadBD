package com.universidad.bl.Estudiante;

import com.universidad.dl.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlEstudianteImp implements IEstudianteDAO{

    private String sentenciaSQL="";

    public String guardarEstudiante(Estudiante estudiante) throws Exception {
        sentenciaSQL = "INSERT INTO ESTUDIANTES VALUES('"+ estudiante.getCedula() +"','"+estudiante.getNombre()+
                "','"+estudiante.getApellido()+"',"+estudiante.getEdad()+")";
        Conector.getConnector().ejecutarSQL(sentenciaSQL);

        return "Estudiante registrado de manera correcta!";
    }

    public String modificarEstudiante(Estudiante estudiante) throws Exception {
        sentenciaSQL = "UPDATE ESTUDIANTES SET NOMBRE='"+ estudiante.getNombre() +"', APELLIDO='"+ estudiante.getApellido() +
                "', EDAD="+ estudiante.getEdad() +" WHERE CEDULA = '"+ estudiante.getCedula() +"'";

        Conector.getConnector().ejecutarSQL(sentenciaSQL);
        return "Estudiante modificado de manera correcta!";
    }

    public String eliminarEstudiante(String cedula) throws Exception {
        sentenciaSQL = "DELETE FROM ESTUDIANTES WHERE CEDULA ='"+ cedula +"'";

        Conector.getConnector().ejecutarSQL(sentenciaSQL);
        return "Estudiante eliminado de manera correcta!";
    }

    public ArrayList<String> obtenerEstudiantes() throws Exception {
        ArrayList<String> listaEstudiantes = new ArrayList<>();
        ResultSet rs = null;
        sentenciaSQL = "SELECT * FROM ESTUDIANTES";

        rs = Conector.getConnector().ejecutarQuery(sentenciaSQL);
        while(rs.next()){
            Estudiante estudiante = new Estudiante();
            estudiante.setCedula(rs.getString("cedula"));
            estudiante.setNombre(rs.getString("nombre"));
            estudiante.setApellido(rs.getString("apellido"));
            estudiante.setEdad(rs.getInt("edad"));

            listaEstudiantes.add(estudiante.toString());
        }
        return listaEstudiantes;
    }
}
