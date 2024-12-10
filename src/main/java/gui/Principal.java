package gui;

import datos.BaseDatos;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import logica.Producto;

public class Principal extends javax.swing.JFrame {

    private ImageIcon inventario, ventas;
    private DefaultTableModel modeloTablaInventario;
    private DefaultTableModel modeloTablaVentas;
    private DefaultListModel<Producto> modeloLista;
    private BaseDatos base;
    private String selectedId;

    public Principal() {
        base = new BaseDatos();
        modeloTablaVentas = new DefaultTableModel();
        modeloTablaInventario = new DefaultTableModel();
        modeloLista = new DefaultListModel<>();

        modeloTablaVentas.setColumnIdentifiers(new Object[]{"clave", "nombre", "precio", "cantidad", "importe"});
        modeloTablaInventario.setColumnIdentifiers(new Object[]{"clave", "nombre", "descripcion", "unidad",
            "precio_compra", "precio_venta", "existencias"});

        cargarModeloTablaInventario();
        //cargarModeloTablaVentas();
        initComponents();
        addListSelectionListener();
        setLocationRelativeTo(null);
        cargarIconos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelInventario = new javax.swing.JPanel();
        btnArticulos = new javax.swing.JButton();
        btnCategorias = new javax.swing.JButton();
        btnProveedores = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        txtClaveProducto = new javax.swing.JTextField();
        txtNombreProducto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtExistencia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtIngresarAlInventario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnAgregarExistencia = new javax.swing.JButton();
        btnEditarArticulo = new javax.swing.JButton();
        btnEliminarArticulo = new javax.swing.JButton();
        txtBuscarProductoInventario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        panelVentas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        txtBuscarProductoVenta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblMontoTotal = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        lblFotoProducto = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListProductos = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de ventas e inventario");

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N

        panelInventario.setPreferredSize(new java.awt.Dimension(1000, 500));

        btnArticulos.setToolTipText("Agregar articulos");
        btnArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArticulosActionPerformed(evt);
            }
        });

        btnCategorias.setToolTipText("Agregar o eliminar categorias");
        btnCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriasActionPerformed(evt);
            }
        });

        btnProveedores.setToolTipText("Agregar o eliminar proveedores");
        btnProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedoresActionPerformed(evt);
            }
        });

        tblProductos.setModel(modeloTablaInventario);
        tblProductos.getColumn("descripcion").setPreferredWidth(200);
        jScrollPane1.setViewportView(tblProductos);

        jLabel1.setText("Clave");

        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Busqueda");

        jLabel5.setText("Existencia");

        jLabel6.setText("Ingresar al inventario");

        btnAgregarExistencia.setText("Agregar");
        btnAgregarExistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarExistenciaActionPerformed(evt);
            }
        });

        btnEditarArticulo.setToolTipText("Editar articulo");
        btnEditarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarArticuloActionPerformed(evt);
            }
        });

        btnEliminarArticulo.setToolTipText("Eliminar articulo");
        btnEliminarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarArticuloActionPerformed(evt);
            }
        });

        txtBuscarProductoInventario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProductoInventarioKeyReleased(evt);
            }
        });

        jLabel7.setText("Buscar");

        javax.swing.GroupLayout panelInventarioLayout = new javax.swing.GroupLayout(panelInventario);
        panelInventario.setLayout(panelInventarioLayout);
        panelInventarioLayout.setHorizontalGroup(
            panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInventarioLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscarProductoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelInventarioLayout.createSequentialGroup()
                        .addGroup(panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnArticulos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInventarioLayout.createSequentialGroup()
                        .addGroup(panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtClaveProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelInventarioLayout.createSequentialGroup()
                        .addComponent(txtIngresarAlInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelInventarioLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEditarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        panelInventarioLayout.setVerticalGroup(
            panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInventarioLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClaveProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregarExistencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIngresarAlInventario, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarProductoInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(panelInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInventarioLayout.createSequentialGroup()
                        .addComponent(btnEditarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Inventario", panelInventario);

        tblVentas.setModel(modeloTablaVentas);
        jScrollPane2.setViewportView(tblVentas);

        txtBuscarProductoVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProductoVentaKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Buscar producto");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblMontoTotal.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblMontoTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMontoTotal.setText("0.00");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Venta Total");

        jButton4.setBackground(new java.awt.Color(255, 51, 51));
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton4.setText("Realizar Venta");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Pago con: ");

        jTextField7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jTextField8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Recibe:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField7)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                        .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(55, 55, 55))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMontoTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(7, 7, 7)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        lblFotoProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ListProductos.setModel(modeloLista);
        ListProductos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListProductosValueChanged(evt);
            }
        });
        ListProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(ListProductos);

        javax.swing.GroupLayout panelVentasLayout = new javax.swing.GroupLayout(panelVentas);
        panelVentas.setLayout(panelVentasLayout);
        panelVentasLayout.setHorizontalGroup(
            panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVentasLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelVentasLayout.createSequentialGroup()
                        .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelVentasLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVentasLayout.createSequentialGroup()
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(251, 251, 251)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panelVentasLayout.createSequentialGroup()
                        .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3)
                            .addComponent(txtBuscarProductoVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblFotoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))))
        );
        panelVentasLayout.setVerticalGroup(
            panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVentasLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFotoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelVentasLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelVentasLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVentasLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );

        jTabbedPane1.addTab("Ventas", null, panelVentas, "");

        jTabbedPane1.setToolTipTextAt(0, "Gestionar el inventario de productos");
        jTabbedPane1.setToolTipTextAt(1, "Realizar ventas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedoresActionPerformed
        ProveedoresDialog modalProveedores = new ProveedoresDialog(this, true);
        modalProveedores.setLocationRelativeTo(null);
        modalProveedores.setDefaultCloseOperation(2);
        modalProveedores.setAlwaysOnTop(true);
        modalProveedores.setVisible(true);
    }//GEN-LAST:event_btnProveedoresActionPerformed

    private void btnCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriasActionPerformed
        CategoriasDialog modalCategorias = new CategoriasDialog(this, true);
        modalCategorias.setAlwaysOnTop(true);
        modalCategorias.setDefaultCloseOperation(2);
        modalCategorias.setLocationRelativeTo(null);
        modalCategorias.setVisible(true);
    }//GEN-LAST:event_btnCategoriasActionPerformed

    private void btnArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArticulosActionPerformed
        ProductosDialog modalArticulos = new ProductosDialog(this, true);
        modalArticulos.setAlwaysOnTop(true);
        modalArticulos.setDefaultCloseOperation(2);
        modalArticulos.setLocationRelativeTo(null);
        modalArticulos.setVisible(true);
        modalArticulos.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                cargarModeloTablaInventario();
            }

        });
    }//GEN-LAST:event_btnArticulosActionPerformed

    private void btnEditarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarArticuloActionPerformed
        if (tblProductos.getSelectedRow() > -1) {
            EditarProductosDialog modalEditarArticulos = new EditarProductosDialog(this, true, base.obtenerProducto(selectedId));
            modalEditarArticulos.setLocationRelativeTo(null);
            modalEditarArticulos.setDefaultCloseOperation(2);
            modalEditarArticulos.setAlwaysOnTop(true);
            modalEditarArticulos.setVisible(true);
            modalEditarArticulos.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    cargarModeloTablaInventario();
                    limpiarCampos();
                }

            });

        } else {
            JOptionPane.showMessageDialog(this, "No hay ninguna fila seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarArticuloActionPerformed

    private void btnEliminarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarArticuloActionPerformed
        int opcion = JOptionPane.showOptionDialog(this.getContentPane(), "¿Desea eliminar este articulo?", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Si", "No"}, "No");
        if (opcion == JOptionPane.YES_OPTION) {
            if (tblProductos.getSelectedRow() > -1) {

                base.eliminarProducto(selectedId);
                JOptionPane.showMessageDialog(this, "Eliminacion exitosa", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
                cargarModeloTablaInventario();

            } else {
                JOptionPane.showMessageDialog(this, "No hay ninguna fila seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEliminarArticuloActionPerformed

    private void btnAgregarExistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarExistenciaActionPerformed
        if (tblProductos.getSelectedRow() != -1) {

            if (!txtIngresarAlInventario.getText().isBlank()) {
                try {
                    double existencia = Double.parseDouble(txtIngresarAlInventario.getText());
                    double cantidadActual = base.obtenerProducto(selectedId).getExistenciasProducto();
                    double nuevaCantidad = existencia + cantidadActual;
                    //actualizar en la base de datos la existencia del producto seleccionado
                    base.actualizarInventario(selectedId, nuevaCantidad);

                    JOptionPane.showMessageDialog(this, "Existencias actualizadas", "Exitoso", JOptionPane.INFORMATION_MESSAGE);
                    mostrarInfoProducto(selectedId);
                    limpiarCampos();
                    cargarModeloTablaInventario();

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Error en tipo de datos introducidos", "Error", JOptionPane.ERROR_MESSAGE);

                }
            } else {
                JOptionPane.showMessageDialog(this, "Cantidad a ingresar no puede estar en blanco", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay ninguna fila seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarExistenciaActionPerformed

    private void txtBuscarProductoInventarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProductoInventarioKeyReleased
        String criterio = txtBuscarProductoInventario.getText();

        //consulta en la base de datos
        base.obtenerProductosPorCriterio(criterio);
        modeloTablaInventario.setRowCount(0);
        for (Producto p : base.obtenerProductosPorCriterio(criterio)) {
            Object[] filaInserccion = {p.getIdProducto(), p.getNombreProducto(), p.getDescripcionProducto(),
                p.getUnidadMedida(), p.getPrecioCompraProducto(), p.getPrecioVentaProducto(), p.getExistenciasProducto()};
            modeloTablaInventario.addRow(filaInserccion);
        }
    }//GEN-LAST:event_txtBuscarProductoInventarioKeyReleased

    private void txtBuscarProductoVentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProductoVentaKeyReleased
        String criterio = txtBuscarProductoVenta.getText();

        ArrayList<Producto> prodCoincidenCriterio = base.obtenerProductosPorCriterio(criterio);
        modeloLista.removeAllElements();
        modeloLista.addAll(prodCoincidenCriterio);

    }//GEN-LAST:event_txtBuscarProductoVentaKeyReleased

    private void ListProductosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListProductosValueChanged

        double cant = 0D;
        double precioVenta = 0D;
        if (!(evt.getValueIsAdjusting()) && ListProductos.getSelectedIndex() != -1) {
            //Obtenemos el indice que corresponde al objeto seleccionado en la lista
            int indexRow = tableContainsProduct(ListProductos.getSelectedValue().getIdProducto());
            System.out.println(indexRow);

            if (indexRow != -1) {//Si el producto ya esta agregado en la tabla
                cant = (Double) modeloTablaVentas.getValueAt(indexRow, 3);
                modeloTablaVentas.setValueAt(cant + 1.0, indexRow, 3);
                System.out.println("cantidad actualizada : " + (cant + 1.0));

                cant = (Double) modeloTablaVentas.getValueAt(indexRow, 3);
                precioVenta = (Double) modeloTablaVentas.getValueAt(indexRow, 2);
                modeloTablaVentas.setValueAt((cant * precioVenta), indexRow, 4);
                System.out.println("importe actualizado: " + cant * precioVenta);

                ListProductos.clearSelection();
            } else {
                try {
                    String canti = JOptionPane.showInputDialog(this, "Introduzca la cantidad");
                    double cantidad = Double.parseDouble(canti);
                    if(cantidad < 1){
                        throw new NumberFormatException();
                    }
                    cargarModeloTablaVentas(ListProductos.getSelectedValue(), cantidad);
                    ListProductos.clearSelection();

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "La cantidad no es valida", "Error", JOptionPane.ERROR_MESSAGE);
                    ListProductos.clearSelection();
                }catch (NullPointerException e){
                    ListProductos.clearSelection();
                }
            }
        }
        
        actualizarMonto();

    }//GEN-LAST:event_ListProductosValueChanged

    public static void main(String args[]) {

        try {

            //javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
            javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            //javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Principal principal = new Principal();
                principal.setVisible(true);
                ProductosDialog.FRAMEPADRE = principal;
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<Producto> ListProductos;
    private javax.swing.JButton btnAgregarExistencia;
    private javax.swing.JButton btnArticulos;
    private javax.swing.JButton btnCategorias;
    private javax.swing.JButton btnEditarArticulo;
    private javax.swing.JButton btnEliminarArticulo;
    private javax.swing.JButton btnProveedores;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JLabel lblFotoProducto;
    private javax.swing.JLabel lblMontoTotal;
    private javax.swing.JPanel panelInventario;
    private javax.swing.JPanel panelVentas;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTable tblVentas;
    private javax.swing.JTextField txtBuscarProductoInventario;
    private javax.swing.JTextField txtBuscarProductoVenta;
    private javax.swing.JTextField txtClaveProducto;
    private javax.swing.JTextField txtExistencia;
    private javax.swing.JTextField txtIngresarAlInventario;
    private javax.swing.JTextField txtNombreProducto;
    // End of variables declaration//GEN-END:variables

    private void cargarIconos() {
        ventas = new ImageIcon(getClass().getResource("/ventas.png"));
        inventario = new ImageIcon(getClass().getResource("/inventario.png"));
        jTabbedPane1.setIconAt(1, ventas);
        jTabbedPane1.setIconAt(0, inventario);
    }

    private void cargarModeloTablaInventario() {
        modeloTablaInventario.setRowCount(0);

        for (Producto p : base.obtenerProductos()) {
            Object[] filaInserccion = {p.getIdProducto(), p.getNombreProducto(), p.getDescripcionProducto(),
                p.getUnidadMedida(), p.getPrecioCompraProducto(), p.getPrecioVentaProducto(), p.getExistenciasProducto()};
            modeloTablaInventario.addRow(filaInserccion);
        }

    }

    private void addListSelectionListener() {
        tblProductos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && (tblProductos.getSelectedRow() > -1)) {
                    int selectedRow = tblProductos.getSelectedRow();
                    //Obtener la clave de selectedRow
                    selectedId = (tblProductos.getValueAt(selectedRow, 0)).toString();
                    //mostrar informacion del producto obtenido por su id
                    mostrarInfoProducto(selectedId);
                }
            }
        });
    }

    private void mostrarInfoProducto(String selectedId) {
        Producto producto = base.obtenerProducto(selectedId);
        txtClaveProducto.setText(producto.getIdProducto());
        txtNombreProducto.setText(producto.getNombreProducto());
        txtExistencia.setText(String.valueOf(producto.getExistenciasProducto()));
    }

    private void limpiarCampos() {
        txtClaveProducto.setText("");
        txtNombreProducto.setText("");
        txtExistencia.setText("");
        txtIngresarAlInventario.setText("");
        txtBuscarProductoInventario.setText("");
    }

    private void cargarModeloTablaVentas(Producto p, double cantidad) {
        //Posible validacion de si el objeto ya esta presente el la lista
        //implica sobreescribir equals y hashCode
        //Solo aumenta la cantidad
        modeloTablaVentas.addRow(new Object[]{p.getIdProducto(), p.getNombreProducto(),
            p.getPrecioVentaProducto(), cantidad, p.getPrecioVentaProducto() * cantidad});
    }

    private int tableContainsProduct(String id) {

        for (int indexRow = 0; indexRow < modeloTablaVentas.getRowCount(); indexRow++) {
            //Si el id del producto seleccionado en la lista aparece en la tabla
            if (id.equals(tblVentas.getValueAt(indexRow, 0).toString())) {
                return indexRow;
            }
        }
        return -1;
    }

    private void actualizarMonto() {
        if(tblVentas.getRowCount() > 0){
        double sumaImportes = 0D;
        
            for (int i = 0; i < tblVentas.getRowCount(); i++) {
                sumaImportes += (Double) modeloTablaVentas.getValueAt(i, 4);
            }
            
            //Actualizo el monto
            lblMontoTotal.setText(String.valueOf(sumaImportes));
        }
    }

}
