package org.sanchez.pixup.model;

public class Colonia extends Catalogo {
    private String nombre;
    private String codigoPostal;
    private Integer municipioId;

    public Colonia() {
        super();
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCodigoPostal() {
        return codigoPostal;
    }
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    public Integer getMunicipioId() {
        return municipioId;
    }
    public void setMunicipioId(Integer municipioId) {
        this.municipioId = municipioId;
    }

    @Override
    public String toString() {
        return "Colonia{" +
                "nombre='" + nombre + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", municipioId=" + municipioId +
                ", id=" + id +
                '}';
    }
}
