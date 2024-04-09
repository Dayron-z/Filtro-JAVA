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


    public Contratacion() {
    }

    public Contratacion(int id, String fecha_aplicacion, Estado estado, BigDecimal salario, int id_vacante, int id_coder, Vacante objVacante, Coder objCoder) {
        this.id = id;
        this.fecha_aplicacion = fecha_aplicacion;
        this.estado = estado;
        this.salario = salario;
        this.id_vacante = id_vacante;
        this.id_coder = id_coder;
        this.objVacante = objVacante;
        this.objCoder = objCoder;
    }

    public Contratacion(int id, String fecha_aplicacion, Estado estado, BigDecimal salario, int id_vacante, int id_coder) {
        this.id = id;
        this.fecha_aplicacion = fecha_aplicacion;
        this.estado = estado;
        this.salario = salario;
        this.id_vacante = id_vacante;
        this.id_coder = id_coder;
    }


    public Contratacion(int id, Estado estado, BigDecimal salario, int id_vacante, int id_coder) {
        this.id = id;
        this.estado = estado;
        this.salario = salario;
        this.id_vacante = id_vacante;
        this.id_coder = id_coder;
    }

    public Contratacion(Estado estado, BigDecimal salario, int id_vacante, int id_coder) {
        this.estado = estado;
        this.salario = salario;
        this.id_vacante = id_vacante;
        this.id_coder = id_coder;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha_aplicacion() {
        return fecha_aplicacion;
    }

    public void setFecha_aplicacion(String fecha_aplicacion) {
        this.fecha_aplicacion = fecha_aplicacion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public int getId_vacante() {
        return id_vacante;
    }

    public void setId_vacante(int id_vacante) {
        this.id_vacante = id_vacante;
    }

    public int getId_coder() {
        return id_coder;
    }

    public void setId_coder(int id_coder) {
        this.id_coder = id_coder;
    }

    public Vacante getObjVacante() {
        return objVacante;
    }

    public void setObjVacante(Vacante objVacante) {
        this.objVacante = objVacante;
    }

    public Coder getObjCoder() {
        return objCoder;
    }

    public void setObjCoder(Coder objCoder) {
        this.objCoder = objCoder;
    }

    @Override
    public String toString() {
        return " Info Contrato{" +
                "id=" + id +
                ", fecha_aplicacion='" + fecha_aplicacion + '\'' +
                ", estado=" + estado +
                ", salario=" + salario +
                ", Vacante = " + id_vacante +
                ", id_coder=" + id_coder +
                ", objVacante=" + objVacante +
                ", objCoder=" + objCoder +
                '}';
    }
}
