
import controller.ControllerCoder;
import controller.ControllerVacante;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int opcion = 0, opcionCoder = 0, opcionVacante = 0, opcionContratacion = 0 , opcionEmpresa = 0;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                    Ingrese una opción
                    1 - CRUD CODER
                    2 - CRUD VACANTE
                    3 - CRUD CONTRATACION
                    4 - Empresa
                    """));

            switch (opcion){
                case 1:
                    do {
                        opcionCoder = Integer.parseInt(JOptionPane.showInputDialog("""
                                1 - Crear Coder
                                2 - Eliminar Coder 
                                3 - Actualizar Coder
                                4 - Listar Coder
                                5 - Salir 
                                """));

                        switch (opcionCoder){
                            case 1:
                                ControllerCoder.crear();
                                break;
                            case 2:
                                ControllerCoder.delete();
                                break;
                            case 3:
                                ControllerCoder.update();
                                break;
                            case 4:
                                ControllerCoder.listar();
                                break;
                        }
                    }while (opcionCoder != 5);

                    break;

                case 2:
                    do {
                        opcionVacante = Integer.parseInt(JOptionPane.showInputDialog("""
                                1 - Crear vacante
                                2 - Eliminar vacante 
                                3 - Actualizar vacante
                                4 - Listar vacante
                                5 - Salir 
                                """));

                        switch (opcionVacante){
                            case 1:
                                ControllerVacante.crear();
                                break;
                            case 2:
                                ControllerVacante.delete();
                                break;
                            case 3:
                                ControllerVacante.update();
                                break;
                            case 4:
                                ControllerVacante.listar();
                                break;
                        }
                    }while (opcionVacante != 5);
                    break;

                case 3:
                    do {
                        opcionContratacion = Integer.parseInt(JOptionPane.showInputDialog("""
                                1 - Crear producto
                                2 - Eliminar producto 
                                3 - Actualizar producto
                                4 - Listar producto
                                5 - Salir 
                                 """));

                        switch (opcionContratacion){
                            case 1:

                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                        }

                    }while (opcionContratacion != 5);
                    break;

                case 4:
                    do {
                        opcionEmpresa = Integer.parseInt(JOptionPane.showInputDialog("""
                                1 - Crear compra
                                2 - Eliminar compra 
                                3 - Actualizar compra 
                                4 - Listar compra 
                                5 - Salir
                                
                                """));

                        switch (opcionEmpresa){
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                        }
                    }while (opcionEmpresa != 5);
                    break;
            }


        }while (opcion != 5);


    }
}