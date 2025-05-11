package com.espe.app.forestalproyect.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "Zona_Especie")
public class ZonaEspecie {

    @EmbeddedId
    private ZonaEspecieId id;

    @ManyToOne
    @MapsId("zonaId")
    @JoinColumn(name = "zona_id")
    private ZonaForestal zonaId;

    @ManyToOne
    @MapsId("especieId")
    @JoinColumn(name = "especie_id")
    private EspecieArbol especie;

    @Column(precision = 10, scale = 2)
    private BigDecimal densidad;

    // Clave primaria compuesta
    @Embeddable
    public static class ZonaEspecieId implements Serializable {
        @Column(name = "zona_id")
        private Long zonaId;
        
        @Column(name = "especie_id")
        private Long especieId;

        // equals() y hashCode()
    }

    // Getters y Setters
}