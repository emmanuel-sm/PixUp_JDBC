package pixup.model;

public class Domicilio extends Catalogo {
    private String calle;
    private String numExterior;
    private String numInterior;
    private Integer coloniaId;
    private Integer usuarioId;

    public Domicilio() {
        super();
    }
    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public String getNumExterior() {
        return numExterior;
    }
    public void setNumExterior(String numExterior) {
        this.numExterior = numExterior;
    }
    public String getNumInterior() {
        return numInterior;
    }
    public void setNumInterior(String numInterior) {
        this.numInterior = numInterior;
    }
    public Integer getColoniaId() {
        return coloniaId;
    }
    public void setColoniaId(Integer coloniaId) {
        this.coloniaId = coloniaId;
    }
    public Integer getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public String toString() {
        return "Domicilio{" +
                "calle='" + calle + '\'' +
                ", numExterior='" + numExterior + '\'' +
                ", numInterior='" + numInterior + '\'' +
                ", coloniaId=" + coloniaId +
                ", usuarioId=" + usuarioId +
                ", id=" + id +
                '}';
    }
}
