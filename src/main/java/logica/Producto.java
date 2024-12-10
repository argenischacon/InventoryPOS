
package logica;

import java.io.File;

public class Producto {
    private String idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private double stock;
    private File fotoProducto;
    private String unidadMedida;
    private double precioCompraProducto;
    private double precioVentaProducto;
    private double existenciasProducto;
    
    private int categoria;
    private int proveedor;

    public Producto() {
    }

    public Producto(String idProducto, String nombreProducto, String descripcionProducto, double stock, File fotoProducto, String unidadMedida, double precioCompraProducto, double precioVentaProducto, double existenciasProducto, int categoria, int proveedor) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.stock = stock;
        this.fotoProducto = fotoProducto;
        this.unidadMedida = unidadMedida;
        this.precioCompraProducto = precioCompraProducto;
        this.precioVentaProducto = precioVentaProducto;
        this.existenciasProducto = existenciasProducto;
        this.categoria = categoria;
        this.proveedor = proveedor;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public File getFotoProducto() {
        return fotoProducto;
    }

    public void setFotoProducto(File fotoProducto) {
        this.fotoProducto = fotoProducto;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public double getPrecioCompraProducto() {
        return precioCompraProducto;
    }

    public void setPrecioCompraProducto(double precioCompraProducto) {
        this.precioCompraProducto = precioCompraProducto;
    }

    public double getPrecioVentaProducto() {
        return precioVentaProducto;
    }

    public void setPrecioVentaProducto(double precioVentaProducto) {
        this.precioVentaProducto = precioVentaProducto;
    }

    public double getExistenciasProducto() {
        return existenciasProducto;
    }

    public void setExistenciasProducto(double existenciasProducto) {
        this.existenciasProducto = existenciasProducto;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return nombreProducto;
    }

    


    
}
