package com.universidad.bl.Curso;

import java.util.ArrayList;

public interface ICursoDAO {
    public String registrarCurso(Curso curso) throws Exception;
    public String modificarCurso(Curso curso) throws Exception;
    public Curso buscarCurso (String codigo) throws Exception;
    public ArrayList<String> listarCursos() throws Exception;
}
