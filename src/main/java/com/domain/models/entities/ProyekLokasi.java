package com.domain.models.entities;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "proyek_lokasi")
@IdClass(ProyekLokasiId.class)
public class ProyekLokasi implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "proyek_id", nullable = false)
    private Integer proyekId;

    @Id
    @Column(name = "lokasi_id", nullable = false)
    private Integer lokasiId;

    // Default constructor
    public ProyekLokasi() {}

    

    public ProyekLokasi(Integer proyekId, Integer lokasiId) {
        this.proyekId = proyekId;
        this.lokasiId = lokasiId;
    }



    // Getters and Setters
    public Integer getProyekId() {
        return proyekId;
    }

    public void setProyekId(Integer proyekId) {
        this.proyekId = proyekId;
    }

    public Integer getLokasiId() {
        return lokasiId;
    }

    public void setLokasiId(Integer lokasiId) {
        this.lokasiId = lokasiId;
    }
}
