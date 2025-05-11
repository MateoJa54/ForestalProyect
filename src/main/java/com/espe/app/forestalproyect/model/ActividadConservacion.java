package com.espe.app.forestalproyect.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Actividade_Conservacion")
public class ActividadConservacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actividad_id")
    private Long actividadId;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Lob
    private String descripcion;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_fin")
    private Date fechaFin;

    @Column(precision = 12, scale = 2)
    private BigDecimal presupuesto;

    @Enumerated(EnumType.STRING)
    private EstadoActividad estado;

    @ManyToOne
    @JoinColumn(name = "zona_id", nullable = false)
    private ZonaForestal zonaId;

    // ENUM para estado de actividad
    public enum EstadoActividad {
        PLANEADA, EN_PROGRESO, COMPLETADA, CANCELADA
    }

    // Getters y Setters
}