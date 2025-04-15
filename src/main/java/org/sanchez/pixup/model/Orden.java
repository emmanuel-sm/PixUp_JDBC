package org.sanchez.pixup.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "TBL_ORDEN")
public class Orden extends Catalogo {

    @Column(name = "COSTO_TOTAL", nullable = false)
    private Float costoTotal;

    @Column(name = "FECHA", nullable = false)
    private String fecha;

    @Column(name = "CANTIDAD_TOTAL", nullable = false)
    private Integer cantidadTotal;

    @Column(name = "ESTATUS_ENVIO", nullable = false)
    private Boolean estatusEnvio;

    @Column(name = "COSTO_MAX")
    private Float costoMax;

    @Column(name = "TBL_USUARIO_ID", nullable = false)
    private Integer usuarioId;

    @Column(name = "TBL_DISCO_ID", nullable = false)
    private Integer discoId;
}
