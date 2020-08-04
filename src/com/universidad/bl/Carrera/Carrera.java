package com.universidad.bl.Carrera;

import com.universidad.bl.Curso.Curso;

import java.util.ArrayList;
import java.util.Objects;

public class Carrera {

    private String codigo;
    private String nombre;
    ArrayList<Curso> listCursos;

    public Carrera(){
        this.codigo="";
        this.nombre="";
        this.listCursos = new ArrayList<>();
    }

    public Carrera(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.listCursos = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Curso> getListCursos() {
        return listCursos;
    }

    public void setListCursos(ArrayList<Curso> listCursos) {
        this.listCursos = listCursos;
    }

    private String getInfoCurso(){
        String infoCursos = "--- Listado de Cursos ---";
        for (Curso curso:listCursos) {
            infoCursos+= curso.toString()+"\n";
        }
        return infoCursos;
    }

    public String toString() {
        String info = "---- Carrera -----\n" +
                "codigo="+codigo+ "\n" +
                "nombre="+nombre+ "\n" +
                 getInfoCurso();
        return info;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrera carrera = (Carrera) o;
        return Objects.equals(codigo, carrera.codigo);
    }
}
