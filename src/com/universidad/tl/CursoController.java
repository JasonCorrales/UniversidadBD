package com.universidad.tl;

import com.universidad.bl.Curso.Curso;
import com.universidad.bl.Curso.ICursoDAO;
import com.universidad.bl.dao.DaoFactory;

import java.util.ArrayList;

public class CursoController {

    private DaoFactory factory;
    private ICursoDAO cursoDao;

    public CursoController(){
        factory = DaoFactory.getDaoFactory();
        cursoDao = factory.getCursoImp();
    }

    public String registrarCurso(String codigo, String nombre, int creditos) throws Exception{
        Curso curso = new Curso(codigo,nombre,creditos);
        return cursoDao.registrarCurso(curso);
    }

    public String modificarCurso(String codigo, String nombre, int creditos) throws Exception{
        Curso curso = new Curso(codigo,nombre,creditos);
        return cursoDao.modificarCurso(curso);
    }

    public String buscarCurso(String codigo) throws Exception{
        Curso curso = cursoDao.buscarCurso(codigo);
        if (curso != null) {
           return curso.toString();
        }
        return "El código del curso indicado no existe!";
    }

    public ArrayList<String> listarCursos() throws Exception{
        return cursoDao.listarCursos();
    }

}
