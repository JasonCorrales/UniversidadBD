package com.universidad.bl.Estudiante;

import java.util.ArrayList;

public class OracleEstudianteImp implements IEstudianteDAO{
    @Override
    public String guardarEstudiante(Estudiante estudiante) throws Exception {
        return "El estudiante se guardo en Oracle!";
    }

    @Override
    public String modificarEstudiante(Estudiante estudiante) throws Exception {
        return "El estudiante se modifico en Oracle!";
    }

    @Override
    public String eliminarEstudiante(String cedula) throws Exception {
        return "El estudiante se elimino en Oracle!";
    }

    @Override
    public ArrayList<String> obtenerEstudiantes() throws Exception {
        return null;
    }
}
