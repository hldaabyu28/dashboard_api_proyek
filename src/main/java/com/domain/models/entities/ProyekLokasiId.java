package com.domain.models.entities;

import java.io.Serializable;
import java.util.Objects;

public class ProyekLokasiId implements Serializable {

    private Integer proyekId;
    private Integer lokasiId;

    // Default constructor
    public ProyekLokasiId() {}

    // Parameterized constructor
    public ProyekLokasiId(Integer proyekId, Integer lokasiId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProyekLokasiId that = (ProyekLokasiId) o;
        return Objects.equals(proyekId, that.proyekId) && Objects.equals(lokasiId, that.lokasiId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(proyekId, lokasiId);
    }
}
