package com.universidad.bl.dao;

import com.universidad.bl.Carrera.ICarreraDAO;
import com.universidad.bl.Carrera.OracleCarreraImp;
import com.universidad.bl.Curso.ICursoDAO;
import com.universidad.bl.Curso.OracleCursoImp;
import com.universidad.bl.Estudiante.IEstudianteDAO;
import com.universidad.bl.Estudiante.OracleEstudianteImp;

public class OracleDaoFactory extends DaoFactory {

    public IEstudianteDAO getEstudianteImp() {
        return new OracleEstudianteImp();
    }


    public ICursoDAO getCursoImp() {
        return new OracleCursoImp();
    }

    public ICarreraDAO getCarreraImp(){
        return new OracleCarreraImp();
    }
}
