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
@Table(name = "TBL_DOMICILIO")
public class Domicilio extends Catalogo {

    @Column(name = "CALLE", nullable = false)
    private String calle;

    @Column(name = "NUM_EXTERIOR", nullable = false)
    private String numExterior;

    @Column(name = "NUM_INTERIOR")
    private String numInterior;

    @Column(name = "TBL_COLONIA_ID", nullable = false)
    private Integer coloniaId;

    @Column(name = "TBL_USUARIO_ID", nullable = false)
    private Integer usuarioId;
}
