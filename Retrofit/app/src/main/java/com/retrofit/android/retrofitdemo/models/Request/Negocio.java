
package com.retrofit.android.retrofitdemo.models.Request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Negocio {

    private SolicitudEvaluacionNegocio solicitudEvaluacionNegocio;
    private List<Venta> ventas = null;
    private List<CuentasCobrar> cuentasCobrar = null;
    private List<AnalisisCostoVenta> analisisCostoVentas = null;
    private List<EvaluacionNegocio> evaluacionNegocio = null;
    private HojaTrabajo hojaTrabajo;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public SolicitudEvaluacionNegocio getSolicitudEvaluacionNegocio() {
        return solicitudEvaluacionNegocio;
    }

    public void setSolicitudEvaluacionNegocio(SolicitudEvaluacionNegocio solicitudEvaluacionNegocio) {
        this.solicitudEvaluacionNegocio = solicitudEvaluacionNegocio;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public List<CuentasCobrar> getCuentasCobrar() {
        return cuentasCobrar;
    }

    public void setCuentasCobrar(List<CuentasCobrar> cuentasCobrar) {
        this.cuentasCobrar = cuentasCobrar;
    }

    public List<AnalisisCostoVenta> getAnalisisCostoVentas() {
        return analisisCostoVentas;
    }

    public void setAnalisisCostoVentas(List<AnalisisCostoVenta> analisisCostoVentas) {
        this.analisisCostoVentas = analisisCostoVentas;
    }

    public List<EvaluacionNegocio> getEvaluacionNegocio() {
        return evaluacionNegocio;
    }

    public void setEvaluacionNegocio(List<EvaluacionNegocio> evaluacionNegocio) {
        this.evaluacionNegocio = evaluacionNegocio;
    }

    public HojaTrabajo getHojaTrabajo() {
        return hojaTrabajo;
    }

    public void setHojaTrabajo(HojaTrabajo hojaTrabajo) {
        this.hojaTrabajo = hojaTrabajo;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
