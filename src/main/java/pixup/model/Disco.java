package pixup.model;

public class Disco extends Catalogo {
    private String titulo;
    private Float precio;
    private Integer existencia;
    private Float descuento;
    private String fechaLanzamiento;
    private String imagen;
    private Integer artistaId;
    private Integer disqueraId;

    public Disco() {
        super();
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Float getPrecio() {
        return precio;
    }
    public void setPrecio(Float precio) {
        this.precio = precio;
    }
    public Integer getExistencia() {
        return existencia;
    }
    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
    }
    public Float getDescuento() {
        return descuento;
    }
    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }
    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }
    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }
    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public Integer getArtistaId() {
        return artistaId;
    }
    public void setArtistaId(Integer artistaId) {
        this.artistaId = artistaId;
    }
    public Integer getDisqueraId() {
        return disqueraId;
    }
    public void setDisqueraId(Integer disqueraId) {
        this.disqueraId = disqueraId;
    }

    @Override
    public String toString() {
        return "Disco{" +
                "titulo='" + titulo + '\'' +
                ", precio=" + precio +
                ", existencia=" + existencia +
                ", descuento=" + descuento +
                ", fechaLanzamiento='" + fechaLanzamiento + '\'' +
                ", imagen='" + imagen + '\'' +
                ", artistaId=" + artistaId +
                ", disqueraId=" + disqueraId +
                ", id=" + id +
                '}';
    }
}
