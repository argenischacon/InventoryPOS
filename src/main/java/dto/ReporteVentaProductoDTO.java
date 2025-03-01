
package dto;

import java.sql.Date;


public class ReporteVentaProductoDTO {
    
    private int id_venta;
    private String nombreProducto;
    private double cantidadVendida;
    private double precioVentaProducto;
    private double montoVenta;
    private Date fechaVenta;

    public ReporteVentaProductoDTO() {
    }

    public ReporteVentaProductoDTO(int id_venta, String nombreProducto, double cantidadVendida, double precioVentaProducto, double montoVenta, Date fechaVenta) {
        this.id_venta = id_venta;
        this.nombreProducto = nombreProducto;
        this.cantidadVendida = cantidadVendida;
        this.precioVentaProducto = precioVentaProducto;
        this.montoVenta = montoVenta;
        this.fechaVenta = fechaVenta;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(double cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public double getPrecioVentaProducto() {
        return precioVentaProducto;
    }

    public void setPrecioVentaProducto(double precioVentaProducto) {
        this.precioVentaProducto = precioVentaProducto;
    }

    public double getMontoVenta() {
        return montoVenta;
    }

    public void setMontoVenta(double montoVenta) {
        this.montoVenta = montoVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    
    
    
}
