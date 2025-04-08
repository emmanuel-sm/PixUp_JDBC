package pixup.model;

public class Orden extends Catalogo {
    private Float costoTotal;
    private String fecha;
    private Integer cantidadTotal;
    private Boolean estatusEnvio;
    private Float costoMax;
    private Integer usuarioId;
    private Integer discoId;

    public Orden() {
        super();
    }
    public Float getCostoTotal() {
        return costoTotal;
    }
    public void setCostoTotal(Float costoTotal) {
        this.costoTotal = costoTotal;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public Integer getCantidadTotal() {
        return cantidadTotal;
    }
    public void setCantidadTotal(Integer cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }
    public Boolean getEstatusEnvio() {
        return estatusEnvio;
    }
    public void setEstatusEnvio(Boolean estatusEnvio) {
        this.estatusEnvio = estatusEnvio;
    }
    public Float getCostoMax() {
        return costoMax;
    }
    public void setCostoMax(Float costoMax) {
        this.costoMax = costoMax;
    }
    public Integer getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
    public Integer getDiscoId() {
        return discoId;
    }
    public void setDiscoId(Integer discoId) {
        this.discoId = discoId;
    }
    @Override
    public String toString() {
        return "Orden{" +
                "costoTotal=" + costoTotal +
                ", fecha='" + fecha + '\'' +
                ", cantidadTotal=" + cantidadTotal +
                ", estatusEnvio=" + estatusEnvio +
                ", costoMax=" + costoMax +
                ", usuarioId=" + usuarioId +
                ", discoId=" + discoId +
                ", id=" + id +
                '}';
    }
}
