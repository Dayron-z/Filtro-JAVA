package model;

import database.ConfigDB;
import entity.*;
import interfaces.CRUD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModelContratacion implements CRUD {
    @Override
    public ArrayList<Object> listar() {
        ArrayList<Object>  listaDeContrataciones = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT *, contratacion.estado AS contratacion_estado FROM contratacion INNER JOIN vacante ON vacante.id_vacante = contratacion.id_vacante INNER JOIN coder ON coder.id_coder = contratacion.id_coder ";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult =  objPrepare.executeQuery();

            while (objResult.next()){
                Contratacion objContratacion = new Contratacion();
                objContratacion.setId(objResult.getInt("id_contratacion"));
                objContratacion.setFecha_aplicacion(objResult.getString("fecha_aplicacion"));
                objContratacion.setEstado(Estado.valueOf(objResult.getString("contratacion_estado")));
                objContratacion.setSalario(objResult.getBigDecimal("salario"));
                objContratacion.setId_vacante(objResult.getInt("id_vacante"));
                objContratacion.setId_coder(objResult.getInt("id_coder"));



                Vacante objVacante = new Vacante();
                objVacante.setId(objResult.getInt("id_vacante"));
                objVacante.setTitutlo(objResult.getString("titutlo"));
                objVacante.setDescripcion(objResult.getString("descripcion"));
                objVacante.setDuracion(objResult.getString("duracion"));
                objVacante.setEstado(Estado.valueOf(objResult.getString("estado")));


                objContratacion.setObjVacante(objVacante);


                Coder objCoder  = new Coder();
                objCoder.setId(objResult.getInt("id_coder"));
                objCoder.setNombre(objResult.getString("nombre_coder"));
                objCoder.setApellido(objResult.getString("apellidos"));
                objCoder.setDocumento(objResult.getString("documento"));
                objCoder.setCohorte(objResult.getInt("contacto"));
                objCoder.setCv(objResult.getString("cv"));

                objContratacion.setObjCoder(objCoder);

                listaDeContrataciones.add(objContratacion);
            }
        } catch (SQLException e) {
            System.out.println("Error en model vacante listar" + e.getMessage());
        }


        ConfigDB.closeConnection();
        return listaDeContrataciones;


    }

    @Override
    public Object create(Object obj) {
        Contratacion objContratacion  = (Contratacion) obj;
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "INSERT INTO vacante (fecha_aplicacion, estado, salario, id_vacante, id_coder) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objContratacion.getFecha_aplicacion());
            objPrepare.setString(2, String.valueOf(objContratacion.getEstado()));
            objPrepare.setBigDecimal(3, objContratacion.getSalario());
            objPrepare.setInt(4, objContratacion.getId_vacante());
            objPrepare.setInt(5, objContratacion.getId_coder());



            objPrepare.execute();

            ResultSet generatedKeys = objPrepare.getGeneratedKeys();

            while (generatedKeys.next()){
                objContratacion.setId(generatedKeys.getInt(1));
            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en modelo contratacion crear"
                    + e.getMessage());
        }

        ConfigDB.closeConnection();
        return objContratacion;

    }

    @Override
    public boolean update(Object obj) {
        Contratacion objContratacion = (Contratacion) obj;
        Connection objConnection = ConfigDB.openConnection();

        Boolean isUpdate = false;

        try {
            String sql = "UPDATE contratacion SET fecha_aplicacion = ?, estado = ?, salario = ? , id_vacante = ?, id_coder = ? WHERE id_contratacion = ?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1, objContratacion.getFecha_aplicacion());
            objPrepare.setString(2, String.valueOf(objContratacion.getEstado()));
            objPrepare.setBigDecimal(3, objContratacion.getSalario());
            objPrepare.setInt(4, objContratacion.getId_vacante());
            objPrepare.setInt(5, objContratacion.getId_coder());
            objPrepare.setInt(6, objContratacion.getId());


            int filasAfectadas =  objPrepare.executeUpdate();

            if (filasAfectadas >0){
                JOptionPane.showMessageDialog(null, "La contratacion fue actualizada exitosamente");
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
            String sql = "DELETE FROM contratacion WHERE id_contratacion = ?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1, (Integer) obj);

            int filasAfectadas =  objPrepare.executeUpdate();

            if (filasAfectadas >0){
                JOptionPane.showMessageDialog(null, "La contratacion fue eliminada exitosamente");
                isDelete = true;
            }

        } catch (SQLException e) {
            System.out.println("Error en model producto" + e.getMessage());
        }
        ConfigDB.closeConnection();
        return isDelete;


    }

    public Object findByID(int id){
        Contratacion objContratacion = new Contratacion();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM contratacion WHERE id_contratacion = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1, id);

            ResultSet objResult =  objPrepare.executeQuery();

            while (objResult.next()){
                objContratacion.setId(objResult.getInt("id_contratacion"));
                objContratacion.setFecha_aplicacion(objResult.getString("fecha_aplicacion"));
                objContratacion.setEstado(Estado.valueOf(objResult.getString("contratacion_estado")));
                objContratacion.setSalario(objResult.getBigDecimal("salario"));
                objContratacion.setId_vacante(objResult.getInt("id_vacante"));
                objContratacion.setId_coder(objResult.getInt("id_coder"));
            }
        } catch (SQLException e) {
            System.out.println("Error en model cliente findById: " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return objContratacion;
    }
}
