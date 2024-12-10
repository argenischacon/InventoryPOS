package datos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Categoria;
import logica.Producto;
import logica.Proveedor;
import logica.Venta;
import logica.VentaProductos;

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

            st = conn.prepareStatement("INSERT INTO productos (id_prod, nom_prod, desc_prod, stock_prod, "
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
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    public void insertarProveedor(Proveedor proveedor) {

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
        } finally {
            try {
                conn.close();
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    public void insertarVenta(Venta venta) {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistema", "postgres", "123");

            String sql = "INSERT INTO ventas (monto_venta, fecha_venta) "
                    + "VALUES (?,?)";

            st = conn.prepareStatement(sql);

            st.setDouble(1, venta.getMontoVenta());
            st.setDate(2, venta.getFechaVenta());

            st.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                conn.close();
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void insertarVentaProductos(VentaProductos ventaProductos) {

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistema", "postgres", "123");

            String sql = "INSERT INTO venta_productos (id_venta, id_prod, cantidad_vendida) "
                    + "VALUES (?,?,?)";

            st = conn.prepareStatement(sql);

            st.setInt(1, ventaProductos.getVenta());
            st.setString(2, ventaProductos.getProducto());
            st.setDouble(3, ventaProductos.getCantidadVendida());

            st.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                conn.close();
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    public ArrayList<Producto> obtenerProductos() {

        ArrayList<Producto> productos = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistema", "postgres", "123");

            String sql = "SELECT * FROM productos ORDER BY id_prod ASC";

            st = conn.prepareStatement(sql);

            rs = st.executeQuery();

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
        } finally {
            try {
                conn.close();
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return productos;
    }

    public ArrayList<Categoria> obtenerCategoria() {

        ArrayList<Categoria> categorias = new ArrayList<>();

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistema", "postgres", "123");

            String sql = "SELECT * FROM categorias";

            st = conn.prepareStatement(sql);

            rs = st.executeQuery();

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt(1));
                categoria.setNombreCategoria(rs.getString(2));
                categoria.setDescripcionCategoria(rs.getString(3));
                categorias.add(categoria);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                conn.close();
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return categorias;
    }

    public ArrayList<Proveedor> obtenerProveedores() {

        ArrayList<Proveedor> proveedores = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistema", "postgres", "123");

            String sql = "SELECT * FROM proveedores";

            st = conn.prepareStatement(sql);

            rs = st.executeQuery();

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
        } finally {
            try {
                conn.close();
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return proveedores;
    }

    public Producto obtenerProducto(String selectedId) {
        Producto producto = new Producto();
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistema", "postgres", "123");
            String sql = "SELECT * FROM productos WHERE id_prod = ?";

            st = conn.prepareStatement(sql);
            st.setString(1, selectedId);

            rs = st.executeQuery();

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
        } finally {
            try {
                conn.close();
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return producto;
    }

    public void actualizarInventario(String selectedId, double nuevaCantidad) {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistema", "postgres", "123");

            String sql = "UPDATE productos SET existencias_prod = ? WHERE id_prod = ?";
            st = conn.prepareStatement(sql);
            st.setDouble(1, nuevaCantidad);
            st.setString(2, selectedId);

            st.executeUpdate();

        } catch (SQLException ex) {
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

    public ArrayList<Producto> obtenerProductosPorCriterio(String criterio) {
        ArrayList<Producto> productos = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistema", "postgres", "123");

            String sql = "SELECT * FROM productos WHERE id_prod ILIKE '%" + criterio + "%'"
                    + " OR nom_prod ILIKE '%" + criterio + "%' ORDER BY id_prod ASC";

            st = conn.prepareStatement(sql);

            rs = st.executeQuery();

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
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return productos;
    }

    public void eliminarProducto(String selectedId) {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistema", "postgres", "123");

            String sql = "DELETE FROM productos WHERE id_prod = '" + selectedId + "'";
            st = conn.prepareStatement(sql);

            st.executeUpdate();

        } catch (SQLException ex) {
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

    public InputStream buscarFoto(Producto selectedProduct) {
        InputStream is = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistema", "postgres", "123");

            String sql = "SELECT foto_prod FROM productos WHERE id_prod = '" + selectedProduct.getIdProducto() + "'";
            st = conn.prepareStatement(sql);

            rs = st.executeQuery();

            while (rs.next()) {
                is = rs.getBinaryStream("foto_prod");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return is;
    }

    public void actualizarProducto(Producto producto) {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistema", "postgres", "123");
            String sql = "";
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

}
