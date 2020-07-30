package com.universidad.ui;

import com.universidad.tl.UniversidadController;

import java.io.*;
import java.util.ArrayList;

public class UniversidadUI {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintStream   out = System.out;
    static UniversidadController gestor = new UniversidadController();

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
            out.println("1. Listar Estudiante");
            out.println("2. Registrar Estudiante");
            out.println("3. Modificar Estudiante ");
            out.println("4. Eliminar Estudiante ");
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
            String resultado = gestor.guardarEstudiante(cedula,nombre,apellido,edad);
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
            String resultado = gestor.modificarEstudiante(cedula,nombre,apellido,edad);
            out.println(resultado);
        }catch(Exception ex){
            out.println(ex);
        }
    }

    public static void eliminar() throws Exception{
        out.println("Indique la cedula:");
        String cedula = in.readLine();

        try {
            String resultado = gestor.eliminarEstudiante(cedula);
            out.println(resultado);
        }catch(Exception ex){
            out.println(ex);
        }
    }

    public static void listar(){
        ArrayList<String> lista;

        try
        {
           lista = gestor.listarEstudiantes();
            for (String infoEstudiante :lista) {
                out.println(infoEstudiante);
            }
        }catch(Exception ex){
            out.println(ex);
        }
    }
}
