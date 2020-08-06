package com.universidad.bl.dao;

import com.universidad.bl.Carrera.ICarreraDAO;
import com.universidad.bl.Carrera.MySqlCarreraImp;
import com.universidad.bl.Curso.ICursoDAO;
import com.universidad.bl.Curso.MySqlCursoImp;
import com.universidad.bl.Estudiante.IEstudianteDAO;
import com.universidad.bl.Estudiante.MySqlEstudianteImp;

public class MySqlDaoFactory extends DaoFactory{

    public IEstudianteDAO getEstudianteImp() {
        return new MySqlEstudianteImp();
    }

    public ICursoDAO getCursoImp() {
        return new MySqlCursoImp();
    }

    public ICarreraDAO getCarreraImp(){
        return new MySqlCarreraImp();
    }
}
