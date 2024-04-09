package model;

import database.ConfigDB;
import entity.Coder;
import entity.Empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelEmpresa {
    public ArrayList<Object> listar() {
        ArrayList<Object> listaDeEmpresas = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM empresa";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                Empresa objEmpresa = new Empresa();
                objEmpresa.setId(objResult.getInt("id_empresa"));
                objEmpresa.setNombre(objResult.getString("nombre_empresa"));
                objEmpresa.setSector(objResult.getString("sector"));
                objEmpresa.setUbicacion(objResult.getString("ubicacion"));
                objEmpresa.setContacto(objResult.getString("contacto"));



                listaDeEmpresas.add(objEmpresa);
            }
        } catch (SQLException e) {
            System.out.println("Error en Model Empresa listar: " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return listaDeEmpresas;

    }

}
