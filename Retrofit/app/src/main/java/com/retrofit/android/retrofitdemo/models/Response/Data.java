
package com.retrofit.android.retrofitdemo.models.Response;

import java.util.HashMap;
import java.util.Map;

public class Data {

    private Long idStatusSincronizacion;
    private String idSincronizacion;
    private String idSolicitante;
    private String createdAt;
    private String updatedAt;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Long getIdStatusSincronizacion() {
        return idStatusSincronizacion;
    }

    public void setIdStatusSincronizacion(Long idStatusSincronizacion) {
        this.idStatusSincronizacion = idStatusSincronizacion;
    }

    public String getIdSincronizacion() {
        return idSincronizacion;
    }

    public void setIdSincronizacion(String idSincronizacion) {
        this.idSincronizacion = idSincronizacion;
    }

    public String getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(String idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}