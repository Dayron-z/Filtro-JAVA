package model;

import database.ConfigDB;
import entity.Coder;
import entity.Empresa;
import entity.Estado;
import entity.Vacante;
import interfaces.CRUD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelVacante implements CRUD {
    @Override
    public ArrayList<Object> listar() {
        ArrayList<Object> listaDeVacantes = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM vacante INNER JOIN empresa ON empresa.id_empresa = vacante.id_empresa";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult =  objPrepare.executeQuery();

            while (objResult.next()){
                Vacante objVacante = new Vacante();
                objVacante.setId(objResult.getInt("id_vacante"));
                objVacante.setTitutlo(objResult.getString("titutlo"));
                objVacante.setDescripcion(objResult.getString("descripcion"));
                objVacante.setDuracion(objResult.getString("duracion"));
                objVacante.setEstado(Estado.valueOf(objResult.getString("estado")));


                Empresa objEmpresa = new Empresa();
                objEmpresa.setId(objResult.getInt("id_empresa"));
                objEmpresa.setNombre(objResult.getString("nombre_empresa"));
                objEmpresa.setSector(objResult.getString("sector"));
                objEmpresa.setUbicacion(objResult.getString("ubicacion"));
                objEmpresa.setContacto(objResult.getString("contacto"));

                objVacante.setObjEmpresa(objEmpresa);
                listaDeVacantes.add(objVacante);
            }
        } catch (SQLException e) {
            System.out.println("Error en model vacante listar" + e.getMessage());
        }


        ConfigDB.closeConnection();
        return listaDeVacantes;
    }
    @Override
    public Object create(Object obj) {
        Vacante objVacante = (Vacante) obj;
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "INSERT INTO producto (titutlo, descripcion, duracion, estado, id_empresa) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objVacante.getTitutlo());
            objPrepare.setString(2, objVacante.getDescripcion());
            objPrepare.setString(3, objVacante.getDuracion());
            objPrepare.setString(4, String.valueOf(objVacante.getEstado()));
            objPrepare.setInt(5, objVacante.getId_Empresa());



            objPrepare.execute();

            ResultSet generatedKeys = objPrepare.getGeneratedKeys();

            while (generatedKeys.next()){
                objVacante.setId(generatedKeys.getInt(1));
            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en modelo vacante crear "
                    + e.getMessage());
        }

        ConfigDB.closeConnection();
        return objVacante;

    }
    @Override
    public boolean update(Object obj) {
        Vacante objVacante = (Vacante) obj;
        Connection objConnection = ConfigDB.openConnection();

        Boolean isUpdate = false;

        try {
            String sql = "UPDATE producto SET titutlo = ?, descripcion = ?, duracion = ?, estado = ?,  id_empresa = ? WHERE id_vacante = ?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1, objVacante.getTitutlo());
            objPrepare.setString(2, objVacante.getDescripcion());
            objPrepare.setString(3, objVacante.getDuracion());
            objPrepare.setString(4, String.valueOf(objVacante.getEstado()));
            objPrepare.setInt(5, objVacante.getId_Empresa());
            objPrepare.setInt(6, objVacante.getId());


            int filasAfectadas =  objPrepare.executeUpdate();

            if (filasAfectadas >0){
                JOptionPane.showMessageDialog(null, "La vacante fue actualizada exitosamente");
                isUpdate = true;
            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error"
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
            String sql = "DELETE FROM vacante WHERE id_vacante = ?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1, (Integer) obj);

            int filasAfectadas =  objPrepare.executeUpdate();

            if (filasAfectadas >0){
                JOptionPane.showMessageDialog(null, "La vacante fue eliminada exitosamente");
                isDelete = true;
            }

        } catch (SQLException e) {
            System.out.println("Error en model producto" + e.getMessage());
        }
        ConfigDB.closeConnection();
        return isDelete;

    }
    public Object findByID(int id){
        Vacante objVacante = new Vacante();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM vacante WHERE id_vacante = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1, id);

            ResultSet objResult =  objPrepare.executeQuery();

            while (objResult.next()){
                objVacante.setId(objResult.getInt("id_vacante"));
                objVacante.setTitutlo(objResult.getString("titutlo"));
                objVacante.setDescripcion(objResult.getString("descripcion"));
                objVacante.setDuracion(objResult.getString("duracion"));
                objVacante.setEstado(Estado.valueOf(objResult.getString("estado")));
            }
        } catch (SQLException e) {
            System.out.println("Error en model cliente findById: " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return objVacante;
    }
}
