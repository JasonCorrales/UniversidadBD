package com.universidad.bl.Carrera;

import com.universidad.bl.Curso.Curso;
import com.universidad.dl.Conector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MySqlCarreraImp implements ICarreraDAO{

    private String sentenciaSQL="";

    public String registraCarrera(Carrera carrera) throws Exception {
        sentenciaSQL = "INSERT INTO CARRERA(CODIGO, NOMBRE) VALUES('"+carrera.getCodigo()+"','"+carrera.getNombre()+"')";
        Conector.getConnector().ejecutarSQL(sentenciaSQL);
        return "La carrera fue registrada de manera correcta!";
    }

    public Carrera buscarCarrera(String codigo) throws Exception {

        // sentencia para obtener la información de la Carrera
        sentenciaSQL = "SELECT * FROM CARRERA WHERE CODIGO='"+codigo+"'";
        ResultSet rsCarrera = Conector.getConnector().ejecutarQuery(sentenciaSQL);

        // valida que exista la carrera
        // si existe devuelve el objeto carrera, si no devuelve null
        if(rsCarrera.next()){

            Carrera carrera = new Carrera(rsCarrera.getString("CODIGO"),rsCarrera.getString("NOMBRE"));

            // Ahora hacemos un select de todos los cursos de esa carrera
            sentenciaSQL = "SELECT C.CODIGO, C.NOMBRE, C.CREDITOS " +
                           "FROM CARRERA_CURSOS CA, CURSO C "+
                           "WHERE CA.CODCARRERA='"+carrera.getCodigo()+"' "+
                             "AND CA.CODCURSO = C.CODIGO";
            ResultSet rsCursos = Conector.getConnector().ejecutarQuery(sentenciaSQL);

            while(rsCursos.next()){
                //Se crea el objeto para cada curso
                Curso curso = new Curso(rsCursos.getString("CODIGO"),
                                        rsCursos.getString("NOMBRE"),
                                        rsCursos.getInt("CREDITOS"));

                // Se agrega el objeto curso al arreglo de cursos de la carrera
                carrera.agregarCurso(curso);
            }
            return carrera;
        }
        return null;
    }

    public ArrayList<Carrera> listarCarreras() throws Exception {
        ArrayList<Carrera> listaCarreras = new ArrayList<>();
        sentenciaSQL = "SELECT * FROM CARRERA";
        ResultSet rsCarrera = Conector.getConnector().ejecutarQuery(sentenciaSQL);

        //Recorre todas las carreras
        while(rsCarrera.next()){
            Carrera carrera = new Carrera(rsCarrera.getString("CODIGO"),rsCarrera.getString("NOMBRE"));

            // Ahora hacemos un select de todos los cursos de esa carrera
            sentenciaSQL = "SELECT C.CODIGO, C.NOMBRE, C.CREDITOS " +
                    "FROM CARRERA_CURSOS CA, CURSO C "+
                    "WHERE CA.CODCARRERA='"+carrera.getCodigo()+"' "+
                    "AND CA.CODCURSO = C.CODIGO";
            ResultSet rsCursos = Conector.getConnector().ejecutarQuery(sentenciaSQL);

            while(rsCursos.next()){
                //Se crea el objeto para cada curso
                Curso curso = new Curso(rsCursos.getString("CODIGO"),
                        rsCursos.getString("NOMBRE"),
                        rsCursos.getInt("CREDITOS"));

                // Se agrega el objeto curso al arreglo de cursos de la carrera
                carrera.agregarCurso(curso);
            }

            listaCarreras.add(carrera);
        }

        return listaCarreras;
    }


    public String asociarCursoCarrera(String codCarrera, String codCurso) throws Exception {
        sentenciaSQL = "INSERT INTO CARRERA_CURSOS (CODCARRERA,CODCURSO) VALUES('"+codCarrera+"','"+codCurso+"')";
        Conector.getConnector().ejecutarSQL(sentenciaSQL);

        return "El curso " + codCurso + " fue agregado de manera correcta a la carrera " + codCarrera;
    }
}
