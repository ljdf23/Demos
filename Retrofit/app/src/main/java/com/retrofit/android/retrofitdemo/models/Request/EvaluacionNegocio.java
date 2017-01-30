
package com.retrofit.android.retrofitdemo.models.Request;

import java.util.HashMap;
import java.util.Map;

public class EvaluacionNegocio {

    private Long monto;
    private Long idCuenta;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }

    public Long getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Long idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
