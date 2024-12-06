package datos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Categoria;
import logica.Producto;
import logica.Proveedor;

public class BaseDatos {

    Connection conn = null;
    PreparedStatement st = null;
    ResultSet rs = null;

    public BaseDatos() {
        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void insertarProducto(Producto producto) {

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistema", "postgres", "123");
            FileInputStream fis = new FileInputStream(producto.getFotoProducto());

            st = conn.prepareStatement("INSERT INTO productos (id_prod, nom_prod, desc_prod, stock_prod"
                    + "foto_prod, unidad_prod, precio_compra_prod, precio_venta_prod, existencias_prod"
                    + "id_categoria_prod, id_proveedor) VALUES(?,?,?,?,?,?,?,?,?,?,?)");

            st.setString(1, producto.getIdProducto());
            st.setString(2, producto.getNombreProducto());
            st.setString(3, producto.getDescripcionProducto());
            st.setDouble(4, producto.getStock());
            st.setBinaryStream(5, fis, (int) producto.getFotoProducto().length());
            st.setString(6, producto.getUnidadMedida());
            st.setDouble(7, producto.getPrecioCompraProducto());
            st.setDouble(8, producto.getPrecioVentaProducto());
            st.setDouble(9, producto.getExistenciasProducto());
            st.setInt(10, producto.getCategoria().getIdCategoria());
            st.setInt(11, producto.getProveedor().getIdProveedor());

            st.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    public void insertarCategoriaProducto(Categoria categoria) {

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistema", "postgres", "123");
            
            String sql = "INSERT INTO categorias (nom_categoria_prod, desc_categoria_prod)"
                    + "VALUES (?,?)";
            st = conn.prepareStatement(sql);
            st.setString(1, categoria.getNombreCategoria());
            st.setString(2, categoria.getDescripcionCategoria());          
            
            st.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                st.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }
    
    public void insertarProveedor(Proveedor proveedor){
        
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistema", "postgres", "123");
            
            String sql = "INSERT INTO proveedores (nom_proveedor, dir_proveedor, "
                    + "telefono_proveedor, email_proveedor, contacto_proveedor)"
                    + "VALUES (?,?,?,?,?)";
            
            st = conn.prepareStatement(sql);
            
            st.setString(1, proveedor.getNombreProveedor());
            st.setString(2, proveedor.getDireccionProveedor());
            st.setString(3, proveedor.getTelefonoProveedor());
            st.setString(4, proveedor.getEmailProveedor());
            st.setString(5, proveedor.getContactoProveedor());
            
            st.executeUpdate();          
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                conn.close();
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        
        
        
    }

}
