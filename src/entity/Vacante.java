package entity;

public class Vacante {

    private int id;
    private String titutlo;
    private String descripcion;
    private String duracion;
    private Estado estado;
    private int id_Empresa;
    private Empresa objEmpresa;

    public Vacante(int id, String titutlo, String descripcion, String duracion, Estado estado, int id_Empresa, Empresa objEmpresa) {
        this.id = id;
        this.titutlo = titutlo;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.estado = estado;
        this.id_Empresa = id_Empresa;
        this.objEmpresa = objEmpresa;
    }

    public Vacante(String titutlo, String descripcion, String duracion, Estado estado, int id_Empresa) {
        this.titutlo = titutlo;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.estado = estado;
        this.id_Empresa = id_Empresa;
    }

    public Vacante() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitutlo() {
        return titutlo;
    }

    public void setTitutlo(String titutlo) {
        this.titutlo = titutlo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getId_Empresa() {
        return id_Empresa;
    }

    public void setId_Empresa(int id_Empresa) {
        this.id_Empresa = id_Empresa;
    }

    public Empresa getObjEmpresa() {
        return objEmpresa;
    }

    public void setObjEmpresa(Empresa objEmpresa) {
        this.objEmpresa = objEmpresa;
    }

    @Override
    public String toString() {
        return "Vacante{" +
                "id=" + id +
                ", titutlo='" + titutlo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", duracion='" + duracion + '\'' +
                ", estado=" + estado +
                ", id_Empresa=" + id_Empresa +
                ", objEmpresa=" + objEmpresa +
                '}';
    }
}
