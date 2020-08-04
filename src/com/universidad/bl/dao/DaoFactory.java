package com.universidad.bl.dao;

import com.universidad.bl.Curso.ICursoDAO;
import com.universidad.bl.Estudiante.IEstudianteDAO;
import com.universidad.util.Utils;

public abstract class DaoFactory {


    public static DaoFactory getDaoFactory(){
        try {
            String[] infoBD = Utils.getProperties();
            switch(infoBD[5])
            {
                case "ORACLE":
                    return new OracleDaoFactory();
                case "MYSQL":
                    return new MySqlDaoFactory();
                case "TXT":
                    //return new TxtDaoFactory();
                    return null;
                case "MEMORY":
                    //return new MemoryDaoFactory();
                    return null;
                default:
                    return null;
            }
        } catch (Exception e) {
            return new MySqlDaoFactory();
        }
    }

    public abstract IEstudianteDAO getEstudianteImp();
    public abstract ICursoDAO getCursoImp();
}
