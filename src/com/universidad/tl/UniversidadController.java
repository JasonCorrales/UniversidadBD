package com.universidad.tl;

import com.universidad.bl.Estudiante.*;
import com.universidad.bl.dao.DaoFactory;

import java.util.ArrayList;

public class UniversidadController {

    //IEstudianteDAO logica = new MySqlEstudianteImp();
    private DaoFactory factory;
    private IEstudianteDAO dao;

    public UniversidadController(){
        factory = DaoFactory.getDaoFactory();
        dao = factory.getEstudianteImp();
    }

    public String guardarEstudiante(String cedula, String nombre, String apellido, int edad) throws Exception{
        Estudiante estudiante = new Estudiante(cedula,nombre,apellido,edad);
        return dao.guardarEstudiante(estudiante);
    }

    public String modificarEstudiante(String cedula, String nombre, String apellido, int edad) throws Exception{
        Estudiante estudiante = new Estudiante(cedula,nombre,apellido,edad);
        return dao.modificarEstudiante(estudiante);
    }

    public String eliminarEstudiante(String cedula) throws Exception{
        return dao.eliminarEstudiante(cedula);
    }

    public ArrayList<String> listarEstudiantes() throws Exception{
        return dao.obtenerEstudiantes();
    }
}
