package controller;

import entity.Coder;
import entity.Vacante;
import model.ModelCoder;

import javax.swing.*;

public class ControllerCoder {
    public static String listarString(){
        String listaDeCoders = "LISTA DE CODERS \n";
        for (Object coder : instanceModel().listar()){
            listaDeCoders += (Coder) coder + "\n";
        }
        return  listaDeCoders;
    }
    public static void listar(){
        JOptionPane.showMessageDialog(null, listarString());
    }
    public static void crear(){
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del coder");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del coder");
        String documento   = JOptionPane.showInputDialog("Ingrese el documento del coder");
        String clan = JOptionPane.showInputDialog("Ingrese el clan del coder");
        int cohorte = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de cohorte del coder"));
        String cv = JOptionPane.showInputDialog("Ingrese el cv del coder");


        instanceModel().create(new Coder(nombre, apellido, documento, cohorte, cv, clan));
        JOptionPane.showMessageDialog(null, "El coder fue creado con éxito");
    }
    public  static void delete(){
        int id = Integer.parseInt(JOptionPane.showInputDialog(listarString() + "\nIngrese el id del coder que desea eliminar"));
        instanceModel().delete(id);
    }
    public static void update(){
        int id = Integer.parseInt(JOptionPane.showInputDialog(listarString() + "\nIngrese el id del coder que desea actualizar"));
        Coder objCliente = (Coder) instanceModel().findByID(id);

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del coder",  objCliente.getNombre());
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del coder", objCliente.getApellido());
        String documento   = JOptionPane.showInputDialog("Ingrese el documento del coder", objCliente.getDocumento());
        String clan = JOptionPane.showInputDialog("Ingrese el clan del coder", objCliente.getClan());
        int cohorte = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de cohorte del coder", objCliente.getCohorte()));
        String cv = JOptionPane.showInputDialog("Ingrese el cv del coder", objCliente.getCv());

        instanceModel().update(new Coder(id, nombre, apellido, documento, cohorte ,cv, clan));
    }
    public static void listarPorCohorte(){
        int cohorte = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de cohorte por el que deseas filtrar"));

        String listaDeClientes = "LISTA DE CODERS POR COHORTE\n";
        for (Object coder :  instanceModel().buscarPorCohorteCoder(cohorte)){
            listaDeClientes += (Coder) coder + "\n";
        }
        JOptionPane.showMessageDialog(null, listaDeClientes);
    }
    public static void listarPorClan(){
        String clan = JOptionPane.showInputDialog("Ingrese el clan por el que deseas filtrar");

        String listaDeClientes = "LISTA DE CODERS POR CLAN\n";
        for (Object coder :  instanceModel().buscarCoderPorClan(clan)){
            listaDeClientes += (Coder) coder + "\n";
        }
        JOptionPane.showMessageDialog(null, listaDeClientes);
    }
    public static ModelCoder instanceModel(){
        return new ModelCoder();
    }
}
