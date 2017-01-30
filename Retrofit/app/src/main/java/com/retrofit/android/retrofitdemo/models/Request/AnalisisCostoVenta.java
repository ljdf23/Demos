
package com.retrofit.android.retrofitdemo.models.Request;

import java.util.HashMap;
import java.util.Map;

public class AnalisisCostoVenta {

    private String producto;
    private String unidadMedida;
    private Long cantidadVendidaMes;
    private Long precioUnitario;
    private Long costoUnitario;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Long getCantidadVendidaMes() {
        return cantidadVendidaMes;
    }

    public void setCantidadVendidaMes(Long cantidadVendidaMes) {
        this.cantidadVendidaMes = cantidadVendidaMes;
    }

    public Long getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Long precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Long getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(Long costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
