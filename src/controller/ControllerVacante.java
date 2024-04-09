package controller;

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
                3 - PENDIENTE 
                """);
        switch (estado){
            case "1":
                estadoUsuario = (Estado.ACTIVA);
                break;
            case "2":
                estadoUsuario = (Estado.INACTIVA);
                break;
            case "3":
                estadoUsuario = (Estado.PENDIENTE);
                break;
        }

        instanceModel().create(new Vacante(titulo, descripcion, duracion, estadoUsuario, id_empresa));
        JOptionPane.showMessageDialog(null, "El producto fue creado con éxito");
    }

    public static ModelVacante instanceModel(){
        return new ModelVacante();
    }
}
