
package logica;


public class Venta_Productos {
   private Venta venta;
   private Producto producto;
   private double cantidadVendida;

    public Venta_Productos() {
    }

    public Venta_Productos(Venta id_venta, Producto idProducto, double cantidadVendida) {
        this.venta = id_venta;
        this.producto = idProducto;
        this.cantidadVendida = cantidadVendida;
    }

    public Venta getId_venta() {
        return venta;
    }

    public void setId_venta(Venta id_venta) {
        this.venta = id_venta;
    }

    public Producto getIdProducto() {
        return producto;
    }

    public void setIdProducto(Producto idProducto) {
        this.producto = idProducto;
    }

    public double getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(double cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }
   
   
   
}
