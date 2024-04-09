package controller;

import entity.Contratacion;
import entity.Empresa;
import entity.Estado;
import entity.Vacante;
import model.ModelContratacion;
import model.ModelVacante;

import javax.swing.*;
import java.math.BigDecimal;

public class ControllerContratacion {
    public static String listarString(){
        String listaDeContrataciones  = "LISTA DE CONTRATACIONES \n";
        for (Object producto : instanceModel().listar()){
            listaDeContrataciones += (Contratacion) producto + "\n";
        }
        return  listaDeContrataciones;
    }
    public static void listar(){
        JOptionPane.showMessageDialog(null, listarString());
    }
    public static void crear(){


        Estado estadoUsuario = null;

        int salario = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el salario de la contratación"));
        BigDecimal salario_contratacion = new BigDecimal(salario);
        int id_vacante = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la vacante"));
        int id_coder = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la vacante"));


        String estado = JOptionPane.showInputDialog("""
                Que tipo de estado tiene la contratcion
                1 - ACTIVA
                2 - INACTIVA
                """);
        switch (estado){
            case "1":
                estadoUsuario = (Estado.ACTIVA);
                break;
            case "2":
                estadoUsuario = (Estado.INACTIVA);
                break;
        }


        instanceModel().create(new Contratacion(estadoUsuario, salario_contratacion, id_vacante, id_coder));
        JOptionPane.showMessageDialog(null, "La contratacion fue creada con éxito");
    }
    public static void update(){
        Estado estadoUsuario = null;
        int id = Integer.parseInt(JOptionPane.showInputDialog(listarString() + "\nIngrese el id de la contratacion que desea actualizar"));
        Contratacion objContratacion = (Contratacion) instanceModel().findByID(id);

        int salario = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el salario de la contratación", objContratacion.getSalario()));
        BigDecimal salario_contratacion = new BigDecimal(salario);
        int id_vacante = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la vacante", objContratacion.getId_vacante()));
        int id_coder = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la vacante", objContratacion.getId_coder()));


        String estado = JOptionPane.showInputDialog("""
                Que tipo de estado tiene la contratcion
                1 - ACTIVA
                2 - INACTIVA
                """,  objContratacion.getEstado());
        switch (estado){
            case "1":
                estadoUsuario = (Estado.ACTIVA);
                break;
            case "2":
                estadoUsuario = (Estado.INACTIVA);
                break;
        }


        instanceModel().update(new Contratacion(id, estadoUsuario, salario_contratacion, id_vacante, id_coder));
    }
    public  static void delete(){
        int id = Integer.parseInt(JOptionPane.showInputDialog(listarString() + "\nIngrese el id de la contratacion que desea eliminar"));
        instanceModel().delete(id);
    }


    public static ModelContratacion instanceModel(){
        return new ModelContratacion();
    }
}
