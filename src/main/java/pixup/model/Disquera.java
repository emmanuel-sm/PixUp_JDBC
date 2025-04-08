package pixup.model;

public class Disquera extends Catalogo {
    private String nombre;

    public Disquera() {
        super();
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Disquera{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                '}';
    }
}
