package pixup.model;

public class Municipio extends Catalogo {
    private String nombre;
    private Integer estadoId;

    public Municipio() {
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getEstadoId() {
        return estadoId;
    }
    public void setEstadoId(Integer estadoId) {
        this.estadoId = estadoId;
    }

    @Override
    public String toString() {
        return "Municipio{" +
                "nombre='" + nombre + '\'' +
                ", estadoId=" + estadoId +
                ", id=" + id +
                '}';
    }
}
