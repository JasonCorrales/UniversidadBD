package com.universidad.tl;

import com.universidad.bl.Estudiante.*;
import com.universidad.bl.dao.DaoFactory;

import java.util.ArrayList;

public class EstudianteController {

    private DaoFactory factory;
    private IEstudianteDAO estudianteDao;

    public EstudianteController(){
        factory = DaoFactory.getDaoFactory();
        estudianteDao = factory.getEstudianteImp();
    }

    public String guardarEstudiante(String cedula, String nombre, String apellido, int edad) throws Exception{
        Estudiante estudiante = new Estudiante(cedula,nombre,apellido,edad);
        return estudianteDao.guardarEstudiante(estudiante);
    }

    public String modificarEstudiante(String cedula, String nombre, String apellido, int edad) throws Exception{
        Estudiante estudiante = new Estudiante(cedula,nombre,apellido,edad);
        return estudianteDao.modificarEstudiante(estudiante);
    }

    public String eliminarEstudiante(String cedula) throws Exception{
        return estudianteDao.eliminarEstudiante(cedula);
    }

    public ArrayList<String> listarEstudiantes() throws Exception{
        return estudianteDao.obtenerEstudiantes();
    }
}
