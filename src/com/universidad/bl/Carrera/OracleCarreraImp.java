package com.universidad.bl.Carrera;

import java.util.ArrayList;

public class OracleCarreraImp implements ICarreraDAO{

    public String registraCarrera(Carrera carrera) throws Exception {
        return "Carrera registrada en Oracle de manera correcta!";
    }


    public Carrera buscarCarrera(String codigo) throws Exception {
        return new Carrera("001","default");
    }

    public ArrayList<Carrera> listarCarreras() throws Exception {
        return new ArrayList<>();
    }
}
