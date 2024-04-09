package model;

import database.ConfigDB;
import entity.Coder;
import interfaces.CRUD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelCoder implements CRUD {
    @Override
    public ArrayList<Object> listar() {
        ArrayList<Object> listaDeCoders = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM coder";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                Coder objCoder = new Coder();
                objCoder.setId(objResult.getInt("id_coder"));
                objCoder.setNombre(objResult.getString("nombre_coder"));
                objCoder.setApellido(objResult.getString("apellidos"));
                objCoder.setDocumento(objResult.getString("documento"));
                objCoder.setCohorte(objResult.getInt("cohorte"));
                objCoder.setCv(objResult.getString("cv"));
                objCoder.setClan(objResult.getString("clan"));



                listaDeCoders.add(objCoder);
            }
        } catch (SQLException e) {
            System.out.println("Error en ModelCoder listar: " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return listaDeCoders;

    }
    @Override
    public Object create(Object obj) {
        Coder objCoder = (Coder) obj;
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "INSERT INTO coder (nombre_coder, apellidos, documento, cohorte, cv, clan) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objCoder.getNombre());
            objPrepare.setString(2, objCoder.getApellido());
            objPrepare.setString(3, objCoder.getDocumento());
            objPrepare.setInt(4, objCoder.getCohorte());
            objPrepare.setString(5, objCoder.getCv());
            objPrepare.setString(6, objCoder.getClan());


            objPrepare.execute();

            ResultSet generatedKeys = objPrepare.getGeneratedKeys();

            while (generatedKeys.next()) {
                objCoder.setId(generatedKeys.getInt(1));
            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en Model Coder crear: "
                    + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objCoder;
    }
    @Override
    public boolean update(Object obj) {
        Coder objCoder = (Coder) obj;
        Connection objConnection = ConfigDB.openConnection();

        boolean isUpdate = false;

        try {
            String sql = "UPDATE coder SET nombre_coder = ?, apellidos = ?, documento = ?, cohorte = ? , cv = ?, clan = ? WHERE id_coder = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1, objCoder.getNombre());
            objPrepare.setString(2, objCoder.getApellido());
            objPrepare.setString(3, objCoder.getDocumento());
            objPrepare.setInt(4, objCoder.getCohorte());
            objPrepare.setString(5, objCoder.getCv());
            objPrepare.setString(6, objCoder.getClan());
            objPrepare.setInt(7, objCoder.getId());



            int filasAfectadas =   objPrepare.executeUpdate();

            if (filasAfectadas > 0){
                isUpdate = true;
                JOptionPane.showMessageDialog(null,  "El coder fue actualizado exitosamente");
            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en Model Coder update: "
                    + e.getMessage());
        }
        ConfigDB.closeConnection();
        return isUpdate;


    }
    @Override
    public boolean delete(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Boolean isDelete = false;


        try {
            String sql = "DELETE FROM coder WHERE id_coder = ?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1, (Integer) obj);

            int filasAfectadas =  objPrepare.executeUpdate();

            if (filasAfectadas >0){
                JOptionPane.showMessageDialog(null, "El coder fue eliminado exitosamente");
                isDelete = true;
            }

        } catch (SQLException e) {
            System.out.println("Error en model coder eliminar: " + e.getMessage());
        }
        ConfigDB.closeConnection();
        return isDelete;

    }
    public Object findByID(int id){
        Coder objCoder = new Coder();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM coder WHERE id_coder = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, id);

            ResultSet objResult =  objPrepare.executeQuery();

            while (objResult.next()){
                objCoder.setId(objResult.getInt("id_coder"));
                objCoder.setNombre(objResult.getString("nombre_coder"));
                objCoder.setApellido(objResult.getString("apellidos"));
                objCoder.setDocumento(objResult.getString("documento"));
                objCoder.setCohorte(objResult.getInt("cohorte"));
                objCoder.setCv(objResult.getString("cv"));
                objCoder.setClan(objResult.getString("clan"));
            }
        } catch (SQLException e) {
            System.out.println("Error en model cliente findById: " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return objCoder;
    }
}
