
package com.retrofit.android.retrofitdemo.models.Request;

import java.util.HashMap;
import java.util.Map;

public class HojaTrabajo {

    private String cajaBancos;
    private String cuentasCobrar;
    private String inventarios;
    private String activoFijo;
    private String actividad;
    private Long otrosIngresos;
    private Long otrosGastos;
    private String comprasMensuales;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getCajaBancos() {
        return cajaBancos;
    }

    public void setCajaBancos(String cajaBancos) {
        this.cajaBancos = cajaBancos;
    }

    public String getCuentasCobrar() {
        return cuentasCobrar;
    }

    public void setCuentasCobrar(String cuentasCobrar) {
        this.cuentasCobrar = cuentasCobrar;
    }

    public String getInventarios() {
        return inventarios;
    }

    public void setInventarios(String inventarios) {
        this.inventarios = inventarios;
    }

    public String getActivoFijo() {
        return activoFijo;
    }

    public void setActivoFijo(String activoFijo) {
        this.activoFijo = activoFijo;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public Long getOtrosIngresos() {
        return otrosIngresos;
    }

    public void setOtrosIngresos(Long otrosIngresos) {
        this.otrosIngresos = otrosIngresos;
    }

    public Long getOtrosGastos() {
        return otrosGastos;
    }

    public void setOtrosGastos(Long otrosGastos) {
        this.otrosGastos = otrosGastos;
    }

    public String getComprasMensuales() {
        return comprasMensuales;
    }

    public void setComprasMensuales(String comprasMensuales) {
        this.comprasMensuales = comprasMensuales;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
