package com.espe.app.forestalproyect.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Zona_Forestal", 
       indexes = @Index(name = "idx_nombre", columnList = "nombre"))
public class ZonaForestal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zona_id")
    private Long zonaId;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(name = "ubicacion", nullable = false, length = 200)
    private String ubicacion;

    @Column(name = "area_hectareas", precision = 10, scale = 2)
    private BigDecimal areaHectareas;

    @Column(name = "tipo_vegetacion", length = 50)
    private String tipoVegetacion;

    @Column(length = 100)
    private String coordenadas;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_registro", columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date fechaRegistro;

    // Relación 1:N con Actividades
    @OneToMany(mappedBy = "zona", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ActividadConservacion> actividades = new ArrayList<>();

    // Relación M:N con Especies a través de tabla intermedia
    @OneToMany(mappedBy = "zona", cascade = CascadeType.ALL)
    private List<ZonaEspecie> especies = new ArrayList<>();

    // Constructor para inicializar fecha_registro
    public ZonaForestal() {
        this.fechaRegistro = new Date(); // Valor por defecto
    }

    // Getters y Setters
    public Long getZonaId() { return zonaId; }
    public void setZonaId(Long zonaId) { this.zonaId = zonaId; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public BigDecimal getAreaHectareas() { return areaHectareas; }
    public void setAreaHectareas(BigDecimal areaHectareas) { 
        this.areaHectareas = areaHectareas; 
    }

    public String getTipoVegetacion() { return tipoVegetacion; }
    public void setTipoVegetacion(String tipoVegetacion) { 
        this.tipoVegetacion = tipoVegetacion; 
    }

    public String getCoordenadas() { return coordenadas; }
    public void setCoordenadas(String coordenadas) { 
        this.coordenadas = coordenadas; 
    }

    public Date getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(Date fechaRegistro) { 
        this.fechaRegistro = fechaRegistro; 
    }

    public List<ActividadConservacion> getActividades() { return actividades; }
    public void setActividades(List<ActividadConservacion> actividades) { 
        this.actividades = actividades; 
    }

    public List<ZonaEspecie> getEspecies() { return especies; }
    public void setEspecies(List<ZonaEspecie> especies) { 
        this.especies = especies; 
    }
}