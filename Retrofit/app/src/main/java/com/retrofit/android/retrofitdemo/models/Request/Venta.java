
package com.retrofit.android.retrofitdemo.models.Request;

import java.util.HashMap;
import java.util.Map;

public class Venta {

    private Long monto;
    private String idPeriodo;
    private String idCalificacion;
    private String idTipoVenta;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }

    public String getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(String idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public String getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(String idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public String getIdTipoVenta() {
        return idTipoVenta;
    }

    public void setIdTipoVenta(String idTipoVenta) {
        this.idTipoVenta = idTipoVenta;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
