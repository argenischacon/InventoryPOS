
package enums;

public enum UnidadDeMedida {
    
    KILOGRAMO("Kilogramo"),
    PIEZA("Pieza"),
    LITRO("Litro");
    
    private String nombreUnidadDeMedida;
   
    private UnidadDeMedida(String nombreUnidadDeMedida){
        this.nombreUnidadDeMedida = nombreUnidadDeMedida;
    }

    @Override
    public String toString() {
        return nombreUnidadDeMedida;
    }

}
