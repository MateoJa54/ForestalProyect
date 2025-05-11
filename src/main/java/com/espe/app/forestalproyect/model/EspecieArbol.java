package com.espe.app.forestalproyect.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Especie_Arbol")
public class EspecieArbol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "especie_id")
    private Long especieId;

    @Column(name = "nombre_cientifico", nullable = false, unique = true, length = 100)
    private String nombreCientifico;

    @Column(name = "nombre_comun", nullable = false, length = 100)
    private String nombreComun;

    @Column(length = 50)
    private String familia;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_conservacion", nullable = false)
    private EstadoConservacion estadoConservacion;

    @Lob
    private String descripcion;

    @Column(name = "imagen_url", length = 255)
    private String imagenUrl;

    @OneToMany(mappedBy = "especie")
    private List<ZonaEspecie> zonas;

    // ENUM para estado de conservación
    public enum EstadoConservacion {
        EN_PELIGRO, VULNERABLE, ESTABLE, CASI_AMENAZADA, EXTINTA
    }

}