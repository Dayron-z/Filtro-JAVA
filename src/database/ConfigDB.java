package database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    public static Connection objConnection = null;
    public static Connection openConnection(){
        try {
            String url = "jdbc:mysql://buxu1hraboxyrqfsrlts-mysql.services.clever-cloud.com/buxu1hraboxyrqfsrlts";
            String user = "uvg6ojrtpn9hrffb";
            String password = "pVXAnU6JPnebZusu55M8";

            objConnection = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado perfectamente");
        } catch (SQLException e) {
            System.out.println("Error:" + e.getMessage());
        }

        return objConnection;
    }
    public static void closeConnection(){
        try {
            objConnection.close();
            System.out.println("Conexión cerrada correctamente");
        }catch (SQLException e){
            System.out.println("Error:" + e.getMessage());
        }
    }


}
