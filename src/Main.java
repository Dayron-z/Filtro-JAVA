
import controller.ControllerCoder;
import controller.ControllerContratacion;
import controller.ControllerEmpresa;
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
                                5 - Buscar vacantes por titulo
                                6 - Buscar vacante por tecnologia
                                7 - Salir 
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
                            case 5:
                                ControllerVacante.listarPorTitulo();
                                break;
                            case 6:
                                ControllerVacante.listarPorTecnologia();
                                break;
                        }
                    }while (opcionVacante != 7);
                    break;

                case 3:
                    do {
                        opcionContratacion = Integer.parseInt(JOptionPane.showInputDialog("""
                                1 - Crear contratacion
                                2 - Eliminar contratacion 
                                3 - Actualizar contratacion
                                4 - Listar contratacion
                                5 - Salir 
                                 """));

                        switch (opcionContratacion){
                            case 1:
                                ControllerContratacion.crear();
                                break;
                            case 2:
                                ControllerContratacion.delete();
                                break;
                            case 3:
                                ControllerContratacion.update();
                                break;
                            case 4:
                                ControllerContratacion.listar();
                                break;
                        }

                    }while (opcionContratacion != 5);
                    break;

                case 4:
                    do {
                        opcionEmpresa = Integer.parseInt(JOptionPane.showInputDialog("""
                                1 - Listar empresas 
                                2 - Salir
                                """));

                        switch (opcionEmpresa){
                            case 1:
                                ControllerEmpresa.listar();
                                break;
                        }
                    }while (opcionEmpresa != 2);
                    break;
            }


        }while (opcion != 5);


    }
}