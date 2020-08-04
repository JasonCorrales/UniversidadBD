package com.universidad.bl.Curso;

import java.util.ArrayList;

public class OracleCursoImp implements ICursoDAO{

    @Override
    public String registrarCurso(Curso curso) throws Exception {
        return "curso registrado en Oracle correctamente!";
    }

    @Override
    public String modificarCurso(Curso curso) throws Exception {
        return "curso modificado en Oracle correctamente!";
    }

    @Override
    public Curso buscarCurso(String codigo) throws Exception {
        return new Curso("C-00","default",0);
    }

    @Override
    public ArrayList<String> listarCursos() throws Exception {
        return new ArrayList<>();
    }
}
