package gui;

import datos.BaseDatos;
import enums.CmbToLoad;
import enums.UnidadDeMedida;
import interfaces.CategoriaAddedListener;
import interfaces.ProveedorAddedListener;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import logica.Categoria;
import logica.Producto;
import logica.Proveedor;

public class ProductosDialog extends javax.swing.JDialog {

    public static Frame FRAMEPADRE;
    ImageIcon iconAddImageNoFocus, iconAddImageFocus;
    File imgArticleFile;
    DefaultComboBoxModel<Categoria> modeloCategorias;
    DefaultComboBoxModel<Proveedor> modeloProveedores;
    BaseDatos baseDatos;

    public ProductosDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        baseDatos = new BaseDatos();
        try {
            imgArticleFile = new File(getClass().getResource("/sinImagen.png").toURI());
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        }
        modeloCategorias = new DefaultComboBoxModel<>();
        modeloProveedores = new DefaultComboBoxModel<>();
        initComponents();
        cargarModelos(CmbToLoad.CATEGORIAYPROVEEDOR);
        cargarIconos();
    }

    private static void createAndDisplayDialog() {
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProductosDialog dialog = new ProductosDialog(new javax.swing.JFrame(), true);
                /*dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });*/
                dialog.setAlwaysOnTop(true);
                dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblImagenArticulo = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        txtStockRequerido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbUnidadMedida = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPrecioCompra = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        txtPrecioVenta = new javax.swing.JTextField();
        btnGestionarCategorias = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        cmbProveedor = new javax.swing.JComboBox<>();
        btnGestionarProveedores = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Articulos");

        lblImagenArticulo.setToolTipText("Añadir una imagen");
        lblImagenArticulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblImagenArticuloMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblImagenArticuloMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblImagenArticuloMousePressed(evt);
            }
        });

        jLabel1.setText("Clave");

        jLabel2.setText("Descripción");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        jLabel3.setText("Stock requerido");

        jLabel4.setText("Categoria");

        jLabel5.setText("Nombre");

        cmbUnidadMedida.setModel(new javax.swing.DefaultComboBoxModel<>(UnidadDeMedida.values()));
        cmbUnidadMedida.setSelectedIndex(-1);

        jLabel6.setText("Unidad de medida");

        jLabel7.setText("Precio de compra");

        jLabel8.setText("Precio de Venta");

        btnGestionarCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionarCategoriasActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnGestionarProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionarProveedoresActionPerformed(evt);
            }
        });

        jLabel10.setText("Proveedor");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImagenArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtClave)
                                .addComponent(txtNombre)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtStockRequerido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnGestionarCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnGestionarProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagenArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGestionarCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtStockRequerido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGestionarProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGestionarCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionarCategoriasActionPerformed
        this.setAlwaysOnTop(false);
        CategoriasDialog modalCategorias = new CategoriasDialog(FRAMEPADRE, true);
        modalCategorias.addCategoriaListener(new CategoriaAddedListener() {
            @Override
            public void CategoriaAdded(Categoria categoriaAdded) {
                cargarModelos(CmbToLoad.CATEGORIA);
                cmbCategoria.setSelectedItem(categoriaAdded);
            }
        });
        modalCategorias.setAlwaysOnTop(true);
        modalCategorias.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        modalCategorias.setLocationRelativeTo(null);
        modalCategorias.setVisible(true);
    }//GEN-LAST:event_btnGestionarCategoriasActionPerformed

    private void btnGestionarProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionarProveedoresActionPerformed
        this.setAlwaysOnTop(false);
        ProveedoresDialog modalProveedores = new ProveedoresDialog(FRAMEPADRE, true);
        modalProveedores.addProveedorListener(new ProveedorAddedListener() {
            @Override
            public void ProveedorAdded(Proveedor proveedorAdded) {
                cargarModelos(CmbToLoad.PROVEEDOR);
                cmbProveedor.setSelectedItem(proveedorAdded);
            }
        });
        modalProveedores.setAlwaysOnTop(true);
        modalProveedores.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        modalProveedores.setLocationRelativeTo(null);
        modalProveedores.setVisible(true);
    }//GEN-LAST:event_btnGestionarProveedoresActionPerformed

    private void lblImagenArticuloMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenArticuloMouseEntered
        lblImagenArticulo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        try {
            File file = new File(getClass().getResource("/sinImagen.png").toURI());
            String path = file.getCanonicalPath();
            if (imgArticleFile.getCanonicalPath().equals(path)) {
                lblImagenArticulo.setIcon(new ImageIcon(iconAddImageFocus.getImage().getScaledInstance(lblImagenArticulo.getWidth(), lblImagenArticulo.getHeight(), Image.SCALE_DEFAULT)));
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(ProductosDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductosDialog.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_lblImagenArticuloMouseEntered

    private void lblImagenArticuloMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenArticuloMouseExited
        lblImagenArticulo.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        try {
            File file = new File(getClass().getResource("/sinImagen.png").toURI());
            String path = file.getCanonicalPath();
            if (imgArticleFile.getCanonicalPath().equals(path)) {
                lblImagenArticulo.setIcon(new ImageIcon(iconAddImageNoFocus.getImage().getScaledInstance(lblImagenArticulo.getWidth(), lblImagenArticulo.getHeight(), Image.SCALE_DEFAULT)));
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(ProductosDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProductosDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblImagenArticuloMouseExited

    private void lblImagenArticuloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagenArticuloMousePressed
        //Seleccionador de archivos (imagenes)
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de imagen jpg, jpeg, gif o png", "jpg", "jpeg", "gif", "png");
        chooser.setFileFilter(filter);

        int returnVal = chooser.showOpenDialog(jPanel1);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            imgArticleFile = chooser.getSelectedFile();
            ImageIcon selectedImage = new ImageIcon(imgArticleFile.getAbsolutePath());
            lblImagenArticulo.setIcon(new ImageIcon(selectedImage.getImage().getScaledInstance(lblImagenArticulo.getWidth(), lblImagenArticulo.getHeight(), Image.SCALE_DEFAULT)));
        }
    }//GEN-LAST:event_lblImagenArticuloMousePressed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (!isCamposVacios()) {
            try {
                String idProducto = txtClave.getText();
                String nombreProducto = txtNombre.getText();
                String descripcionProducto = txtDescripcion.getText();
                double stockProducto = Double.parseDouble(txtStockRequerido.getText());
                //foto
                String unidadMedida = cmbUnidadMedida.getSelectedItem().toString();
                double precioCompraProducto = Double.parseDouble(txtPrecioCompra.getText());
                double precioVentaProducto = Double.parseDouble(txtPrecioVenta.getText());
                double existenciasproducto = 0.0;
                int idCategoria = ((Categoria) cmbCategoria.getSelectedItem()).getIdCategoria();
                int idProveedor = ((Proveedor) cmbProveedor.getSelectedItem()).getIdProveedor();
                Producto producto = new Producto(idProducto, nombreProducto, descripcionProducto,
                        stockProducto, imgArticleFile, unidadMedida, precioCompraProducto,
                        precioVentaProducto, existenciasproducto, idCategoria, idProveedor);

                baseDatos.insertarProducto(producto);

                JOptionPane.showMessageDialog(this, "Guardado exitoso", "", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Los datos introducidos no son validos", "Error en tipos de datos", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No pueden haber campos vacios", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (isCamposRellenos()) {//si hay al menos un campo vacio camposVacios   =  true;
            int opcion = JOptionPane.showOptionDialog(this, "¿Realmente desea cancelar?"
                    + "\nSe perderan los datos", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, new Object[]{"Si", "No"}, "Si");
            if (opcion == JOptionPane.YES_OPTION) {
                this.dispose();
            }
        } else {
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProductosDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductosDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductosDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductosDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        createAndDisplayDialog();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGestionarCategorias;
    private javax.swing.JButton btnGestionarProveedores;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Categoria> cmbCategoria;
    private javax.swing.JComboBox<Proveedor> cmbProveedor;
    private javax.swing.JComboBox<UnidadDeMedida> cmbUnidadMedida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImagenArticulo;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioCompra;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtStockRequerido;
    // End of variables declaration//GEN-END:variables

    private void cargarIconos() {
        iconAddImageNoFocus = new ImageIcon(getClass().getResource("/iconAddImageNoFocus.png"));
        iconAddImageFocus = new ImageIcon(getClass().getResource("/iconAddImageFocus.png"));
        lblImagenArticulo.setIcon(new ImageIcon(iconAddImageNoFocus.getImage().getScaledInstance(lblImagenArticulo.getWidth(), lblImagenArticulo.getHeight(), Image.SCALE_DEFAULT)));
    }

    private void cargarModelos(CmbToLoad tipo) {
        if (tipo == CmbToLoad.CATEGORIA) {
            modeloCategorias.removeAllElements();
            modeloCategorias.addAll(baseDatos.obtenerCategoria());

            cmbCategoria.setModel(modeloCategorias);
        }

        if (tipo == CmbToLoad.PROVEEDOR) {
            modeloProveedores.removeAllElements();
            modeloProveedores.addAll(baseDatos.obtenerProveedores());

            cmbProveedor.setModel(modeloProveedores);
        }

        if (tipo == CmbToLoad.CATEGORIAYPROVEEDOR) {
            modeloCategorias.removeAllElements();
            modeloCategorias.addAll(baseDatos.obtenerCategoria());
            cmbCategoria.setModel(modeloCategorias);

            modeloProveedores.removeAllElements();
            modeloProveedores.addAll(baseDatos.obtenerProveedores());
            cmbProveedor.setModel(modeloProveedores);
        }
    }

    private boolean isCamposVacios() {

        if (txtClave.getText().isEmpty() || txtNombre.getText().isEmpty() || txtDescripcion.getText().isEmpty()
                || txtStockRequerido.getText().isEmpty() || (cmbUnidadMedida.getSelectedIndex() == -1)
                || txtPrecioCompra.getText().isEmpty() || txtPrecioVenta.getText().isEmpty()
                || (cmbCategoria.getSelectedIndex() == -1) || (cmbProveedor.getSelectedIndex() == -1)) {
            return true;//si al menos un campo es vacio
        } else {
            return false;//todos los campos estan rellenos
        }

    }

    private boolean isCamposRellenos() {
        if (txtClave.getText().length() > 0 || txtNombre.getText().length() > 0
                || txtDescripcion.getText().length() > 0 || txtStockRequerido.getText().length() > 0
                || (cmbUnidadMedida.getSelectedIndex() != -1) || txtPrecioCompra.getText().length() > 0
                || txtPrecioVenta.getText().length() > 0 || (cmbCategoria.getSelectedIndex() != -1)
                || (cmbProveedor.getSelectedIndex() != -1)) {

            return true;//hay al menos un campo relleno

        } else {
            return false;//todos los campos estan vacios
        }
    }

}
