package com.universidad.bl.Estudiante;

import java.util.ArrayList;

public interface IEstudianteDAO {

    public String guardarEstudiante(Estudiante estudiante) throws Exception;
    public String modificarEstudiante(Estudiante estudiante) throws Exception;
    public String eliminarEstudiante(String cedula) throws Exception;
    public ArrayList<String> obtenerEstudiantes() throws Exception;
}
