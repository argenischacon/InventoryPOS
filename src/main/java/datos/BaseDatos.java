package datos;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import dto.ReporteVentaProductoDTO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import logica.Categoria;
import logica.Producto;
import logica.Proveedor;
import logica.Venta;
import logica.VentaProductos;

public class BaseDatos {

    //Connection conn = null;
    //PreparedStatement st = null;
    //ResultSet rs = null;
    private static final HikariDataSource dataSource;

    public BaseDatos() {
        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    static{
       HikariConfig config = new HikariConfig();
       config.setJdbcUrl("jdbc:postgresql://turntable.proxy.rlwy.net:33514/sistema");
       config.setUsername("postgres");
       config.setPassword("YvgaagmRtyLoigkFmdEvoeuSMjDwIyjX");
       config.setMaximumPoolSize(10);
       config.setMinimumIdle(2);
       config.setIdleTimeout(30000);
       config.setConnectionTimeout(30000);
       config.setLeakDetectionThreshold(60000);
       
        dataSource = new HikariDataSource(config);
    }
    
    public static Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }
    
    public static void cerrarPool(){
        dataSource.close();
    }

    public void insertarProducto(Producto producto) {

        try(Connection conn = BaseDatos.getConnection()) {
            FileInputStream fis = new FileInputStream(producto.getFotoProducto());

            PreparedStatement st = conn.prepareStatement("INSERT INTO productos (id_prod, nom_prod, desc_prod, stock_prod, "
                    + "foto_prod, unidad_prod, precio_compra_prod, precio_venta_prod, existencias_prod, "
                    + "id_categoria_prod, id_proveedor) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            st.setString(1, producto.getIdProducto());
            st.setString(2, producto.getNombreProducto());
            st.setString(3, producto.getDescripcionProducto());
            st.setDouble(4, producto.getStock());
            st.setBinaryStream(5, fis, (int) producto.getFotoProducto().length());
            st.setString(6, producto.getUnidadMedida());
            st.setDouble(7, producto.getPrecioCompraProducto());
            st.setDouble(8, producto.getPrecioVentaProducto());
            st.setDouble(9, producto.getExistenciasProducto());
            st.setInt(10, producto.getCategoria());
            st.setInt(11, producto.getProveedor());

            st.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } 

    }

    public void insertarCategoriaProducto(Categoria categoria) {

        try (Connection conn = BaseDatos.getConnection()) {
            String sql = "INSERT INTO categorias (nom_categoria_prod, desc_categoria_prod)"
                    + "VALUES (?,?)";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, categoria.getNombreCategoria());
            st.setString(2, categoria.getDescripcionCategoria());

            st.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } 

    }

    public void insertarProveedor(Proveedor proveedor) {

        try (Connection conn = BaseDatos.getConnection()) {

            String sql = "INSERT INTO proveedores (nom_proveedor, dir_proveedor, "
                    + "telefono_proveedor, email_proveedor, contacto_proveedor)"
                    + "VALUES (?,?,?,?,?)";

            PreparedStatement st = conn.prepareStatement(sql);

            st.setString(1, proveedor.getNombreProveedor());
            st.setString(2, proveedor.getDireccionProveedor());
            st.setString(3, proveedor.getTelefonoProveedor());
            st.setString(4, proveedor.getEmailProveedor());
            st.setString(5, proveedor.getContactoProveedor());

            st.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } 

    }

    public void insertarVenta(Venta venta) {
        try (Connection conn = BaseDatos.getConnection()) {

            String sql = "INSERT INTO ventas (monto_venta, fecha_venta) "
                    + "VALUES (?,?)";

            PreparedStatement st = conn.prepareStatement(sql);

            st.setDouble(1, venta.getMontoVenta());
            st.setDate(2, venta.getFechaVenta());

            st.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }

    public void insertarVentaProductos(VentaProductos ventaProductos) {

        try (Connection conn = BaseDatos.getConnection()) {

            String sql = "INSERT INTO ventas_productos (id_venta, id_prod, cantidad_vendida) "
                    + "VALUES (?,?,?)";

            PreparedStatement st = conn.prepareStatement(sql);

            st.setInt(1, ventaProductos.getVenta());
            st.setString(2, ventaProductos.getProducto());
            st.setDouble(3, ventaProductos.getCantidadVendida());

            st.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }

    public ArrayList<Producto> obtenerProductos() {

        ArrayList<Producto> productos = new ArrayList<>();
        try (Connection conn = BaseDatos.getConnection()) {
            
            String sql = "SELECT * FROM productos ORDER BY id_prod ASC";

            PreparedStatement st = conn.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getString(1));
                producto.setNombreProducto(rs.getString(2));
                producto.setDescripcionProducto(rs.getString(3));
                producto.setStock(rs.getDouble(4));
                //falta foto
                producto.setUnidadMedida(rs.getString(6));
                producto.setPrecioCompraProducto(rs.getDouble(7));
                producto.setPrecioVentaProducto(rs.getDouble(8));
                producto.setExistenciasProducto(rs.getDouble(9));
                producto.setCategoria(rs.getInt(10));
                producto.setProveedor(rs.getInt(11));

                productos.add(producto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return productos;
    }

    public ArrayList<Categoria> obtenerCategoria() {

        ArrayList<Categoria> categorias = new ArrayList<>();

        try (Connection conn = BaseDatos.getConnection()) {

            String sql = "SELECT * FROM categorias";

            PreparedStatement st = conn.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt(1));
                categoria.setNombreCategoria(rs.getString(2));
                categoria.setDescripcionCategoria(rs.getString(3));
                categorias.add(categoria);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } 

        return categorias;
    }

    public ArrayList<Proveedor> obtenerProveedores() {

        ArrayList<Proveedor> proveedores = new ArrayList<>();
        try (Connection conn = BaseDatos.getConnection()) {

            String sql = "SELECT * FROM proveedores";

            PreparedStatement st = conn.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt(1));
                proveedor.setNombreProveedor(rs.getString(2));
                proveedor.setDireccionProveedor(rs.getString(3));
                proveedor.setTelefonoProveedor(rs.getString(4));
                proveedor.setEmailProveedor(rs.getString(5));
                proveedor.setContactoProveedor(rs.getString(6));
                proveedores.add(proveedor);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return proveedores;
    }

    public Producto obtenerProducto(String selectedId) {
        Producto producto = new Producto();
        try (Connection conn = BaseDatos.getConnection()) {
            
            String sql = "SELECT * FROM productos WHERE id_prod = ?";

            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, selectedId);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                producto.setIdProducto(rs.getString(1));
                producto.setNombreProducto(rs.getString(2));
                producto.setDescripcionProducto(rs.getString(3));
                producto.setStock(rs.getDouble(4));

                producto.setUnidadMedida(rs.getString(6));
                producto.setPrecioCompraProducto(rs.getDouble(7));
                producto.setPrecioVentaProducto(rs.getDouble(8));
                producto.setExistenciasProducto(rs.getDouble(9));
                producto.setCategoria(rs.getInt(10));
                producto.setProveedor(rs.getInt(11));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        
        return producto;
    }

    public void actualizarInventario(String selectedId, double nuevaCantidad) {
        try (Connection conn = BaseDatos.getConnection()) {

            String sql = "UPDATE productos SET existencias_prod = ? WHERE id_prod = ?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setDouble(1, nuevaCantidad);
            st.setString(2, selectedId);

            st.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }

    public ArrayList<Producto> obtenerProductosPorCriterio(String criterio) {
        ArrayList<Producto> productos = new ArrayList<>();
        try (Connection conn = BaseDatos.getConnection()) {

            String sql = "SELECT * FROM productos WHERE id_prod ILIKE '%" + criterio + "%'"
                    + " OR nom_prod ILIKE '%" + criterio + "%' ORDER BY id_prod ASC";

            PreparedStatement st = conn.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getString(1));
                producto.setNombreProducto(rs.getString(2));
                producto.setDescripcionProducto(rs.getString(3));
                producto.setStock(rs.getDouble(4));
                //falta foto
                producto.setUnidadMedida(rs.getString(6));
                producto.setPrecioCompraProducto(rs.getDouble(7));
                producto.setPrecioVentaProducto(rs.getDouble(8));
                producto.setExistenciasProducto(rs.getDouble(9));
                producto.setCategoria(rs.getInt(10));
                producto.setProveedor(rs.getInt(11));

                productos.add(producto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } 

        return productos;
    }

    public void eliminarProducto(String selectedId) {
        try (Connection conn = BaseDatos.getConnection()) {
            

            String sql = "DELETE FROM productos WHERE id_prod = '" + selectedId + "'";
            PreparedStatement st = conn.prepareStatement(sql);

            st.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } 

    }

    public InputStream buscarFoto(Producto selectedProduct) {
        InputStream is = null;
        try (Connection conn = BaseDatos.getConnection()) {
            

            String sql = "SELECT foto_prod FROM productos WHERE id_prod = '" + selectedProduct.getIdProducto() + "'";
            PreparedStatement st = conn.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                is = rs.getBinaryStream("foto_prod");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return is;
    }

    public void actualizarProducto(Producto producto) {
        try (Connection conn = BaseDatos.getConnection()) {
            
            String sql = "";
            PreparedStatement st;
            if (producto.getFotoProducto() != null) { //Si se selecciono una imagen para el producto
                sql = "UPDATE productos "
                        + "SET id_prod = ?, "
                        + "nom_prod = ?, "
                        + "desc_prod = ?, "
                        + "stock_prod = ?, "
                        + "foto_prod = ?, "
                        + "unidad_prod = ?, "
                        + "precio_compra_prod = ?, "
                        + "precio_venta_prod = ?, "
                        + "existencias_prod = ?, "
                        + "id_categoria_prod = ?, "
                        + "id_proveedor = ? "
                        + "WHERE id_prod = ?";
                st = conn.prepareStatement(sql);
                st.setString(1, producto.getIdProducto());
                st.setString(2, producto.getNombreProducto());
                st.setString(3, producto.getDescripcionProducto());
                st.setDouble(4, producto.getStock());
                st.setBinaryStream(5, new FileInputStream(producto.getFotoProducto()), producto.getFotoProducto().length());
                st.setString(6, producto.getUnidadMedida());
                st.setDouble(7, producto.getPrecioCompraProducto());
                st.setDouble(8, producto.getPrecioVentaProducto());
                st.setDouble(9, producto.getExistenciasProducto());
                st.setInt(10, producto.getCategoria());
                st.setInt(11, producto.getProveedor());
                st.setString(12, producto.getIdProducto());

            } else { //Si NO se seleccion una imagen para el producto
                sql = "UPDATE productos "
                        + "SET id_prod = ?, "
                        + "nom_prod = ?, "
                        + "desc_prod = ?, "
                        + "stock_prod = ?, "
                        + "unidad_prod = ?, "
                        + "precio_compra_prod = ?, "
                        + "precio_venta_prod = ?, "
                        + "existencias_prod = ?, "
                        + "id_categoria_prod = ?, "
                        + "id_proveedor = ? "
                        + "WHERE id_prod = ?";
                st = conn.prepareStatement(sql);
                st.setString(1, producto.getIdProducto());
                st.setString(2, producto.getNombreProducto());
                st.setString(3, producto.getDescripcionProducto());
                st.setDouble(4, producto.getStock());
                st.setString(5, producto.getUnidadMedida());
                st.setDouble(6, producto.getPrecioCompraProducto());
                st.setDouble(7, producto.getPrecioVentaProducto());
                st.setDouble(8, producto.getExistenciasProducto());
                st.setInt(9, producto.getCategoria());
                st.setInt(10, producto.getProveedor());
                st.setString(11, producto.getIdProducto());
            }

            st.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch(FileNotFoundException ex){
            ex.printStackTrace();
        } 
        
    }

    public int obtenerUltimaVenta() {
        int ultimaVenta = 0;
        try (Connection conn = BaseDatos.getConnection()) {

            String sql = "SELECT id_venta FROM ventas ORDER BY id_venta DESC LIMIT 1";
            PreparedStatement st = conn.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                ultimaVenta = rs.getInt("id_venta");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        
        return ultimaVenta;
    }

    public List<ReporteVentaProductoDTO> obtenerReporteVentaProducto(String fechaInicial, String fechaFinal) {
        
        List<ReporteVentaProductoDTO> reporteVentaProducto = new ArrayList<>();
        try (Connection conn = BaseDatos.getConnection()) {
            
            String sql = "SELECT v.id_venta, p.nom_prod, vp.cantidad_vendida, p.precio_venta_prod, v.monto_venta, v.fecha_venta "
                    + "FROM ventas v "
                    + "INNER JOIN ventas_productos vp "
                    + "ON v.id_venta = vp.id_venta "
                    + "INNER JOIN productos p "
                    + "ON p.id_prod = vp.id_prod "
                    + "WHERE v.fecha_venta >= ? "
                    + "AND v.fecha_venta <= ? "
                    + "ORDER BY v.id_venta";
            
            PreparedStatement st = conn.prepareStatement(sql);
            
            LocalDate fechaI = LocalDate.parse(fechaInicial);
            LocalDate fechaF = LocalDate.parse(fechaFinal);
            
            
            st.setDate(1, Date.valueOf(fechaI));
            st.setDate(2, Date.valueOf(fechaF));
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                ReporteVentaProductoDTO dto = new ReporteVentaProductoDTO();
                dto.setId_venta(rs.getInt(1));
                dto.setNombreProducto(rs.getString(2));
                dto.setCantidadVendida(rs.getDouble(3));
                dto.setPrecioVentaProducto(rs.getDouble(4));
                dto.setMontoVenta(rs.getDouble(5));
                dto.setFechaVenta(rs.getDate(6));
                reporteVentaProducto.add(dto);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return reporteVentaProducto;
    }



}
