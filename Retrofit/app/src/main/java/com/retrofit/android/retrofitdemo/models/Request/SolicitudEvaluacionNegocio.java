
package com.retrofit.android.retrofitdemo.models.Request;

import java.util.HashMap;
import java.util.Map;

public class SolicitudEvaluacionNegocio {

    private String idSolicitante;
    private String idStatusAprobacion;
    private String observaciones;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(String idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    public String getIdStatusAprobacion() {
        return idStatusAprobacion;
    }

    public void setIdStatusAprobacion(String idStatusAprobacion) {
        this.idStatusAprobacion = idStatusAprobacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
