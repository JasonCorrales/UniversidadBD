package com.universidad.tl;

import com.universidad.bl.Carrera.Carrera;
import com.universidad.bl.Carrera.ICarreraDAO;
import com.universidad.bl.dao.DaoFactory;

import java.util.ArrayList;

public class CarreraController {

    private DaoFactory factory;
    private ICarreraDAO carreraDao;

    public CarreraController(){
        factory = DaoFactory.getDaoFactory();
        carreraDao = factory.getCarreraImp();
    }

    public String registrarCarrera(String codigo, String nombre) throws Exception{
        Carrera carrera = new Carrera(codigo,nombre);
        return carreraDao.registraCarrera(carrera);
    }

    public String buscarCarrera(String codigo) throws Exception{
       Carrera carrera = carreraDao.buscarCarrera(codigo);
       if(carrera != null){
           return  carrera.toString();
       }
       return "El código de la carrera no existe!";
    }

    public String asociarCursoCarrera(String codCarrera,String codCurso) throws Exception{
       return carreraDao.asociarCursoCarrera(codCarrera,codCurso);
    }

    public ArrayList<String> listarCarreras() throws Exception{
        ArrayList<String> listaCarreras = new ArrayList<>();

        for (Carrera carrera :carreraDao.listarCarreras()) {
            listaCarreras.add(carrera.toString());
        }

        return listaCarreras;
    }
}
