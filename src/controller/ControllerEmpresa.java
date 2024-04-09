package controller;

import entity.Coder;
import entity.Empresa;
import model.ModelCoder;
import model.ModelEmpresa;

import javax.swing.*;

public class ControllerEmpresa {
    public static String listarString(){
        String listaEmpresas = "LISTA DE EMPRESAS \n";
        for (Object empresa  : instanceModel().listar()){
            listaEmpresas += (Empresa) empresa + "\n";
        }
        return  listaEmpresas;
    }
    public static void listar(){
        JOptionPane.showMessageDialog(null, listarString());
    }
    public static ModelEmpresa instanceModel(){
        return new ModelEmpresa();
    }
}
