
package logica;


public class VentaProductos {
   private int venta;
   private String producto;
   private double cantidadVendida;

    public VentaProductos() {
    }

    public VentaProductos(int venta, String producto, double cantidadVendida) {
        this.venta = venta;
        this.producto = producto;
        this.cantidadVendida = cantidadVendida;
    }

    public int getVenta() {
        return venta;
    }

    public void setVenta(int venta) {
        this.venta = venta;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(double cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

}
