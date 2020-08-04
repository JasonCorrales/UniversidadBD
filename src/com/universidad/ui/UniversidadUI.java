package com.universidad.ui;

import com.universidad.tl.CursoController;
import com.universidad.tl.EstudianteController;

import java.io.*;
import java.util.ArrayList;

public class UniversidadUI {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream   out = System.out;
    static EstudianteController gEstudiante = new EstudianteController();
    static CursoController gCurso = new CursoController();

    public static void main(String[] args) {
        try{
            mostrarMenu();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void mostrarMenu() throws Exception {
        int opcion;
        do{
            out.println("1. Listar Estudiantes");
            out.println("2. Registrar Estudiante");
            out.println("3. Modificar Estudiante");
            out.println("4. Eliminar Estudiante");
            out.println("5. Registar un curso");
            out.println("6. Modificar curso");
            out.println("7. Buscar un curso por código");
            out.println("8. Listar Cursos");
            out.println("0. Salir");
            out.print("Digite la opción que desee: ");
            opcion = Integer.parseInt(in.readLine());
            procesarOpcion(opcion);
        }while(opcion != 0);
    }
    //Rutina para procesar la opción seleccionada por el usuario
    public static void procesarOpcion(int pOpcion) throws Exception{
        switch(pOpcion){
            case 1:
                listar();
                break;
            case 2:
                registrar();
                break;
            case 3:
                modificar();
                break;
            case 4:
                eliminar();
                break;
            case 5:
                registrarCurso();
                break;
            case 6:
                modificarCurso();
                break;
            case 7:
                buscarCurso();
                break;
            case 8:
                listarCursos();
                break;
            case 0:
                out.println("Adiós");
                break;
            default:
                out.println("Opción inválida");
        }
    }

    public static void registrar()throws Exception{

        out.println("Indique la cedula:");
        String cedula = in.readLine();
        out.println("Indique el nombre:");
        String nombre = in.readLine();
        out.println("Indique el apellido:");
        String apellido = in.readLine();
        out.println("Indique la edad:");
        int edad = Integer.parseInt(in.readLine());

        try {
            String resultado = gEstudiante.guardarEstudiante(cedula,nombre,apellido,edad);
            out.println(resultado);
        }catch(Exception ex){
            out.println(ex);
        }
    }


    public static void modificar() throws Exception{
        out.println("Indique la cedula:");
        String cedula = in.readLine();
        out.println("Indique el nombre:");
        String nombre = in.readLine();
        out.println("Indique el apellido:");
        String apellido = in.readLine();
        out.println("Indique la edad:");
        int edad = Integer.parseInt(in.readLine());

        try {
            String resultado = gEstudiante.modificarEstudiante(cedula,nombre,apellido,edad);
            out.println(resultado);
        }catch(Exception ex){
            out.println(ex);
        }
    }

    public static void eliminar() throws Exception{
        out.println("Indique la cedula:");
        String cedula = in.readLine();

        try {
            String resultado = gEstudiante.eliminarEstudiante(cedula);
            out.println(resultado);
        }catch(Exception ex){
            out.println(ex);
        }
    }

    public static void listar(){
        ArrayList<String> lista;
        try
        {
           lista = gEstudiante.listarEstudiantes();
            for (String infoEstudiante :lista) {
                out.println(infoEstudiante);
            }
        }catch(Exception ex){
            out.println(ex);
        }
    }

    public static void registrarCurso() throws Exception{
        out.println("Indique el código del curso:");
        String codigo = in.readLine();
        out.println("Indique el nombre del curso:");
        String nombre = in.readLine();
        out.println("Indique la cantidad de créditos:");
        int creditos = Integer.parseInt(in.readLine());

        try {
            String resultado = gCurso.registrarCurso(codigo,nombre,creditos);
            out.println(resultado);
        }catch(Exception ex){
            out.println(ex);
        }
    }

    public static void modificarCurso() throws Exception{
        out.println("Indique el código del curso:");
        String codigo = in.readLine();
        out.println("Indique el nuevo nombre del curso:");
        String nombre = in.readLine();
        out.println("Indique la nueva cantidad de créditos:");
        int creditos = Integer.parseInt(in.readLine());

        try {
            String resultado = gCurso.modificarCurso(codigo,nombre,creditos);
            out.println(resultado);
        }catch(Exception ex){
            out.println(ex);
        }
    }

    public static void buscarCurso() throws Exception{
        out.println("Indique el código del curso:");
        String codigo = in.readLine();

        try {
            String resultado = gCurso.buscarCurso(codigo);
            out.println(resultado);
        }catch(Exception ex){
            out.println(ex);
        }
    }

    public static void listarCursos(){
        ArrayList<String> lista;
        try
        {
            lista = gCurso.listarCursos();
            for (String infoCurso :lista) {
                out.println(infoCurso);
            }
        }catch(Exception ex){
            out.println(ex);
        }
    }
}
