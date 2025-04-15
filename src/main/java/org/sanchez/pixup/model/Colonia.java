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
@Table(name = "TBL_COLONIA")
public class Colonia extends Catalogo {

    @Column(name = "COLONIA", nullable = false)
    private String nombre;

    @Column(name = "CP", nullable = false)
    private String codigoPostal;

    @Column(name = "TBL_MUNICIPIO_ID", nullable = false)
    private Integer municipioId;
}
