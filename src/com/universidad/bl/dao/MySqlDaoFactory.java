package com.universidad.bl.dao;

import com.universidad.bl.Estudiante.IEstudianteDAO;
import com.universidad.bl.Estudiante.MySqlEstudianteImp;

public class MySqlDaoFactory extends DaoFactory{

    public IEstudianteDAO getEstudianteImp() {
        return new MySqlEstudianteImp();
    }
}
