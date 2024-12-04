
package logica;


public class Categoria {
   private int idCategoria;
   private String nombreCategoria;
   private String descuentoCategoria;

    public Categoria() {
    }
   
    public Categoria(int idCategoria, String nombreCategoria, String descuentoCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.descuentoCategoria = descuentoCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescuentoCategoria() {
        return descuentoCategoria;
    }

    public void setDescuentoCategoria(String descuentoCategoria) {
        this.descuentoCategoria = descuentoCategoria;
    }
   
   
}
