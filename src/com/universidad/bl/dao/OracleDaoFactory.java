package com.universidad.bl.dao;

import com.universidad.bl.Curso.ICursoDAO;
import com.universidad.bl.Curso.OracleCursoImp;
import com.universidad.bl.Estudiante.IEstudianteDAO;
import com.universidad.bl.Estudiante.OracleEstudianteImp;

public class OracleDaoFactory extends DaoFactory {

    @Override
    public IEstudianteDAO getEstudianteImp() {
        return new OracleEstudianteImp();
    }

    @Override
    public ICursoDAO getCursoImp() {
        return new OracleCursoImp();
    }
}
