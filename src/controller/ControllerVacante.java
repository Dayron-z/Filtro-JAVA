package controller;

import entity.Coder;
import entity.Estado;
import entity.Vacante;
import model.ModelVacante;

import javax.swing.*;
import java.math.BigDecimal;

public class ControllerVacante {
    public static String listarString(){
        String listaDeVacantes  = "LISTA DE VACANTES\n";
        for (Object producto : instanceModel().listar()){
            listaDeVacantes += (Vacante) producto + "\n";
        }
        return  listaDeVacantes;
    }
    public static void listar(){
        JOptionPane.showMessageDialog(null, listarString());
    }
    public static void crear(){

        Estado estadoUsuario = null;
        String titulo = JOptionPane.showInputDialog( "Ingrese el titulo de la vacante ");
        String descripcion  = JOptionPane.showInputDialog( "Ingrese la descripcion de la vacante");
        String duracion  = JOptionPane.showInputDialog("Ingrese la duracion de la vacante");
        int id_empresa = Integer.parseInt(JOptionPane.showInputDialog(ControllerEmpresa.listarString()  + "Ingrese el id de la empresa dueña de la vacante"));

        String estado = JOptionPane.showInputDialog("""
                Que tipo de estado tiene la vacante
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

        instanceModel().create(new Vacante(titulo, descripcion, duracion, estadoUsuario, id_empresa));
        JOptionPane.showMessageDialog(null, "La vacante fue creada con éxito");
    }
    public static void update(){
        int id = Integer.parseInt(JOptionPane.showInputDialog(listarString() + "\nIngrese el id de la vacante  que desea actualizar"));
        Vacante objVacante = (Vacante) instanceModel().findByID(id);

        Estado estadoUsuario = null;
        String titulo = JOptionPane.showInputDialog( "Ingrese el titulo de la vacante", objVacante.getTitutlo());
        String descripcion  = JOptionPane.showInputDialog( "Ingrese la descripcion de la vacante", objVacante.getDescripcion());
        String duracion  = JOptionPane.showInputDialog("Ingrese la duracion de la vacante", objVacante.getDuracion());
        int id_empresa = Integer.parseInt(JOptionPane.showInputDialog(ControllerEmpresa.listarString()  + "Ingrese el id de la empresa dueña de la vacante" , objVacante.getId_Empresa()));

        String estado = JOptionPane.showInputDialog("""
                Que tipo de estado tiene la vacante
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
            default: JOptionPane.showMessageDialog(null, "Numero no aceptado");
        }


        instanceModel().update(new Vacante(id, titulo, descripcion, duracion, estadoUsuario ,id_empresa));
    }
    public  static void delete(){
        int id = Integer.parseInt(JOptionPane.showInputDialog(listarString() + "\nIngrese el id de la vacante  que desea eliminar"));
        instanceModel().delete(id);
    }
    public static ModelVacante instanceModel(){
        return new ModelVacante();
    }
}
