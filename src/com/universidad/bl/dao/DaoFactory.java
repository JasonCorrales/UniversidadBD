package com.universidad.bl.dao;

import com.universidad.bl.Estudiante.IEstudianteDAO;

public abstract class DaoFactory {

    public static DaoFactory getDaoFactory(){
        return new MySqlDaoFactory();
    }

    public abstract IEstudianteDAO getEstudianteImp();
}
