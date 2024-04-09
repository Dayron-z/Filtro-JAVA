package entity;

import java.math.BigDecimal;

public class Contratacion {
    private int id;
    private String fecha_aplicacion;
    private Estado estado;
    private BigDecimal salario;
    private int id_vacante;
    private int id_coder;

    private Vacante objVacante;
    private Coder objCoder;
}
