package com.universidad.bl.Carrera;

import java.util.ArrayList;

public interface ICarreraDAO {
    public String registraCarrera(Carrera carrera) throws Exception;
    public Carrera buscarCarrera(String codigo) throws Exception;
    public ArrayList<Carrera> listarCarreras() throws Exception;
    public String asociarCursoCarrera(String codCarrera, String codCurso) throws Exception;
}
