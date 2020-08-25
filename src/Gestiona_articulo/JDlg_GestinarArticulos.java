/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestiona_articulo;

import Clases.Articulo; 
import Clases.Marca;
import Clases.Proveedor;
import Clases.Rubro;
import Clases.Tipo;
import Componentes.Fecha;
import Componentes.Mensajes;
import Componentes.Redondeo;
import Componentes.conectar;


import Metodos.CargarCombo;
import Metodos.Conectar;
import Metodos.JItem;
import Metodos.Leer;
import Metodos.buscarid;
import Metodos.gestionarArticulo;
import Metodos.validarCampos;
import datechooser.beans.DateChooserCombo; 
import datechooser.events.CommitEvent; 
import java.awt.Frame; 
import java.awt.event.ActionEvent; 
import java.awt.event.ItemEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.MouseEvent; 
import java.awt.event.WindowEvent; 
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton; 
import javax.swing.JComboBox; 
import javax.swing.JDialog; 
import javax.swing.JLabel; 
import javax.swing.JOptionPane;
import javax.swing.JPanel; 
import javax.swing.JTabbedPane; 
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;



/**
 *
 * @author luca
 */
public class JDlg_GestinarArticulos extends javax.swing.JDialog {

    /**
     * Creates new form dlgGestArticulos
     */
    public JDlg_GestinarArticulos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
      
     //   String cod = GestionarArticulo.getCodigo();
      //  lblCodArt.setText(cod);
    // bloquear();
//        comboproveedor();
//        combomarca();
        comborubro();
//        comboTipo();
        id();
        LookAndFeel();
        
    }
    String tema = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";

    public void LookAndFeel() {
        //Look And Feel
        System.setProperty(
                "Quaqua.tabLayoutPolicy", "wrap"
        );
        try {
            UIManager.setLookAndFeel(tema);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception erro) {
            Mensajes.informacion("Error al cargar el tema");
        }
    }
    buscarid id = new buscarid();
    CargarCombo miComb = new CargarCombo();

//    void comboproveedor() {
//
//        DefaultComboBoxModel miDefaultCombo3 = new DefaultComboBoxModel();
//        Metodos.CargarCombo miCargar = new Metodos.CargarCombo();
//        Leer miLeer = new Leer();
//
//        Proveedor[] miProveedor = miLeer.leer_Proveedor();
//
//        // Proveedor[] miProv = miLeer.leer_proveedor2();
//        miDefaultCombo3 = miCargar.cargar_combo_proveedor(miDefaultCombo3, miProveedor);
//
////        cbo_proveedor.setModel(miDefaultCombo3);
//
//    }

    void combomarca() {
        DefaultComboBoxModel miDefaultCombo1 = new DefaultComboBoxModel();

        Metodos.CargarCombo miCargar = new Metodos.CargarCombo();
        Leer miLeer = new Leer();

        Marca[] miMarca = miLeer.leer_marca();

        // Proveedor[] miProv = miLeer.leer_proveedor2();
        miDefaultCombo1 = miCargar.cargar_combo_marca(miDefaultCombo1, miMarca);

        cbo_Marca.setModel(miDefaultCombo1);
        cbo_Marca.setSelectedIndex(-1);

    }

    void comborubro() {

        DefaultComboBoxModel miDefaultCombo2 = new DefaultComboBoxModel();
        Metodos.CargarCombo miCargar = new Metodos.CargarCombo();
        Leer miLeer = new Leer();

        Tipo[] miTipo = miLeer.leer_tipo();

        // Proveedor[] miProv = miLeer.leer_proveedor2();
        miDefaultCombo2 = miCargar.cargar_combo_tipo(miDefaultCombo2, miTipo);

        cbo_tipo.setModel(miDefaultCombo2);
        cbo_tipo.setSelectedIndex(-1);

    }

    void comboTipo() {
        DefaultComboBoxModel miDefaultCombo = new DefaultComboBoxModel();

        Metodos.CargarCombo miCargar = new Metodos.CargarCombo();
        Leer miLeer = new Leer();
        Rubro[] miRubro = miLeer.leer_rubros();

        // Proveedor[] miProv = miLeer.leer_proveedor2();
        miDefaultCombo = miCargar.cargar_combo_rubro(miDefaultCombo, miRubro);

        cbo_rubro.setModel(miDefaultCombo);
         cbo_rubro.setSelectedIndex(-1);

    }

    void limpiarCampos() {
        txtdescripcionarticulo.setText("");
        
        txtStockMin.setText("");
        txtTarjeta.setText("");
//        txtStock.setText("");
        txtCosto.setText("");
        txtCostoCalc.setText("");
        txtDescarticulo.setText("0");
        txtPrecioProveedor.setText("");
    }

    void bloquear() {
        // txtcod.setEnabled(false);
        txtdescripcionarticulo.setEnabled(false);
        txtCostoCalc.setEnabled(false);
        txtCosto.setEnabled(false);
        txtfechaAlta.setEnabled(false);
        txtDescarticulo.setEnabled(false);
       
        txtTarjeta.setEnabled(false);
        txtPrecioProveedor.setEnabled(false);
//        cbo_proveedor.setEnabled(false);
        cbo_Marca.setEnabled(false);
        cbo_rubro.setEnabled(false);
        cbo_tipo.setEnabled(false);
        Guardar.setEnabled(false);
        Nuevo.setEnabled(true);
        Salir.setEnabled(true);
//     txtStock.setEnabled(false);
        txtStockMin.setEnabled(false);

    }

    void desbloquear() {
        txtdescripcionarticulo.setEnabled(true);
        cbo_rubro.setEnabled(true);
        cbo_Marca.setEnabled(true);
        cbo_tipo.setEnabled(true);
//        cbo_proveedor.setEnabled(true);
//     txtStock.setEnabled(true);
        txtStockMin.setEnabled(true);
        txtCosto.setEnabled(true);
        txtfechaAlta.setEnabled(true);

      
        txtTarjeta.setEnabled(true);
        Guardar.setEnabled(true);
        Nuevo.setEnabled(true);
        Salir.setEnabled(true);
        txtPrecioProveedor.setEnabled(true);
        txtDescarticulo.setEnabled(true);
        txtCostoCalc.setEnabled(true);
    }

    void id() {
        try {
            String dato[] = new String[1];
            Conectar miconexion = new Conectar();
            String consultasql = "select max(idArticulo)+1 from articulo";
            ResultSet rs = miconexion.consulta(consultasql);

            while (rs.next()) {       //recorre el resultset mientras tenga algun dato
                for (int j = 0; j < dato.length; j++) {  //RECORRE HORINZONTALMENTE
                    dato[j] = rs.getString(j + 1);
                }
                lblCodArt.setText(rs.getString(1));

            }
        } catch (Exception e) {
            //e.toString() es para que te mustre el error si lo tenes 
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public double efectivo() {
        double c = descuentoarticulo() + 0.20;
        return c;
    }

    public double tarjeta() {
        double c = descuentoarticulo() + 0.80;
        return c;
    }

    public double precioProveedor() {
        double p = Double.parseDouble(txtPrecioProveedor.getText());
        return p;
    }

    public double descuentoarticulo() {
        double p = Double.parseDouble(txtDescarticulo.getText());
        double res = (precioProveedor()) - ((precioProveedor() / 100) * p);
        return Redondeo.redondear(res);
    }

    public double recargoventa() {
        double p = Double.parseDouble(txtPorcentajeVenta.getText());
        double res = (precioProveedor()) + ((precioProveedor() / 100) * p);
        return Redondeo.redondear(res);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        Nuevo = new javax.swing.JButton();
        Modificar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        cbo_rubro = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbo_Marca = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cbo_tipo = new javax.swing.JComboBox();
        txtdescripcionarticulo = new javax.swing.JTextField();
        lblCodArt = new javax.swing.JLabel();
        Rubro = new javax.swing.JButton();
        Marca = new javax.swing.JButton();
        tipo = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtStockMin = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTarjeta = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtventa = new javax.swing.JTextField();
        txtfechaAlta = new javax.swing.JTextField();
        dcFecha = new datechooser.beans.DateChooserCombo();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_largoBacha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_AnchoBacha = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txt_AltoBacha = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txt_Impuesto = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_CodArt = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtPrecioProveedor = new javax.swing.JTextField();
        txtDescarticulo = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtCostoCalc = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtPorcentajeVenta = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtCostoCalc1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        Salir = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();

        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 204));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-editar_opt.png"))); // NOI18N
        Nuevo.setToolTipText("Nuevo Artículo");
        Nuevo.setBorderPainted(false);
        Nuevo.setContentAreaFilled(false);
        Nuevo.setFocusPainted(false);
        Nuevo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-editar_opt (1).png"))); // NOI18N
        Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoActionPerformed(evt);
            }
        });

        Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-actualizar_opt.png"))); // NOI18N
        Modificar.setToolTipText("Modificar");
        Modificar.setBorderPainted(false);
        Modificar.setContentAreaFilled(false);
        Modificar.setEnabled(false);
        Modificar.setFocusPainted(false);
        Modificar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-actualizar_opt (1).png"))); // NOI18N
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        cbo_rubro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_rubroItemStateChanged(evt);
            }
        });
        cbo_rubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_rubroActionPerformed(evt);
            }
        });

        jLabel1.setText("Código :");

        jLabel2.setText("* Descripcion :");

        jLabel3.setText("* Rubro :");

        jLabel4.setText("* Marca :");

        cbo_Marca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_MarcaItemStateChanged(evt);
            }
        });
        cbo_Marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_MarcaActionPerformed(evt);
            }
        });

        jLabel5.setText("* Tipo :");

        cbo_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_tipoActionPerformed(evt);
            }
        });

        txtdescripcionarticulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdescripcionarticuloKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtdescripcionarticuloKeyReleased(evt);
            }
        });

        lblCodArt.setBackground(new java.awt.Color(255, 255, 255));
        lblCodArt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCodArt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Rubro.setToolTipText("Agregar");
        Rubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RubroActionPerformed(evt);
            }
        });

        Marca.setToolTipText("Agregar");
        Marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MarcaActionPerformed(evt);
            }
        });

        tipo.setToolTipText("Agregar");
        tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoActionPerformed(evt);
            }
        });

        jLabel11.setText("Stock Min.");

        txtStockMin.setText("12");
        txtStockMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtStockMinKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStockMinKeyReleased(evt);
            }
        });

        jLabel12.setText("F. Alta :");

        jLabel13.setText("Costo :");

        txtCosto.setEditable(false);
        txtCosto.setText("0");
        txtCosto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCostoMouseClicked(evt);
            }
        });

        jLabel15.setText("Tarjeta :");

        txtTarjeta.setEditable(false);
        txtTarjeta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTarjetaMouseClicked(evt);
            }
        });
        txtTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTarjetaActionPerformed(evt);
            }
        });
        txtTarjeta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTarjetaKeyPressed(evt);
            }
        });

        jLabel23.setText("Venta :");

        txtventa.setEditable(false);
        txtventa.setText("0");
        txtventa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtventaMouseClicked(evt);
            }
        });

        txtfechaAlta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfechaAltaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfechaAltaKeyReleased(evt);
            }
        });

        dcFecha.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dcFechaOnCommit(evt);
            }
        });

        jLabel7.setText("Bachas Dimensiones:");

        jLabel10.setText("Largo:");

        txt_largoBacha.setText("25.4");

        jLabel6.setText("Ancho:");

        txt_AnchoBacha.setText("56.2");

        jLabel24.setText("Alto:");

        txt_AltoBacha.setText("25.2");

        jLabel25.setText("Impuesto al que esta ligado:");

        txt_Impuesto.setText("21%");

        jLabel14.setText("* Codigo de Articulo:");

        txt_CodArt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_CodArtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_CodArtKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_Impuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel14)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbo_tipo, 0, 152, Short.MAX_VALUE)
                                    .addComponent(cbo_Marca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbo_rubro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Marca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Rubro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(txtdescripcionarticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCodArt, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_CodArt, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtventa, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtStockMin, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtfechaAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(79, 79, 79))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_largoBacha, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_AnchoBacha, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel24)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_AltoBacha, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)))
                .addContainerGap(259, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(lblCodArt, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txt_CodArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtdescripcionarticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Rubro, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbo_rubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Marca, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbo_Marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbo_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_AnchoBacha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(txt_AltoBacha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_largoBacha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txt_Impuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtStockMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txtfechaAlta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(txtTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(txtventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Datos", jPanel1);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jLabel9.setText("Precio del Proveedor :");

        jLabel16.setText("Descuentos Aplicados:");

        jLabel17.setText("El costo calculado es :");

        txtPrecioProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioProveedorKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioProveedorKeyReleased(evt);
            }
        });

        txtDescarticulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescarticuloKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescarticuloKeyReleased(evt);
            }
        });

        jLabel18.setText("%");

        txtCostoCalc.setEditable(false);
        txtCostoCalc.setText("0");

        jLabel19.setText("Calcular Valor Producto Venta");

        jLabel20.setText("Porcentaje al Valor :");

        txtPorcentajeVenta.setText(" ");
        txtPorcentajeVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPorcentajeVentaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPorcentajeVentaKeyReleased(evt);
            }
        });

        jLabel21.setText("Precio Venta :");

        txtCostoCalc1.setEditable(false);
        txtCostoCalc1.setText("0");

        jLabel22.setText("%");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jLabel17)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel16)
                        .addComponent(jLabel9))
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPrecioProveedor)
                    .addComponent(txtDescarticulo)
                    .addComponent(txtCostoCalc, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                    .addComponent(txtPorcentajeVenta)
                    .addComponent(txtCostoCalc1, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel22))
                .addContainerGap(453, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtPrecioProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtDescarticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtCostoCalc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel20))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPorcentajeVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel22)))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21)
                    .addComponent(txtCostoCalc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(178, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Costo Calculado", jPanel2);

        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-atras_opt.png"))); // NOI18N
        Salir.setToolTipText("Salir");
        Salir.setBorderPainted(false);
        Salir.setContentAreaFilled(false);
        Salir.setFocusPainted(false);
        Salir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-atras_opt (1).png"))); // NOI18N
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-guardar_opt (1).png"))); // NOI18N
        Guardar.setToolTipText("Guardar Articulo");
        Guardar.setBorderPainted(false);
        Guardar.setContentAreaFilled(false);
        Guardar.setFocusPainted(false);
        Guardar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-guardar.png"))); // NOI18N
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(Nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Guardar)
                    .addComponent(Salir, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Modificar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Nuevo))
                .addContainerGap(560, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbo_rubroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_rubroActionPerformed
        // TODO add your handling code here:
   
    }//GEN-LAST:event_cbo_rubroActionPerformed

    private void cbo_MarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_MarcaActionPerformed
        // TODO add your handling code here:
  
    }//GEN-LAST:event_cbo_MarcaActionPerformed

    private void cbo_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_tipoActionPerformed
        // TODO add your handling code here:
  
    }//GEN-LAST:event_cbo_tipoActionPerformed

    private void txtdescripcionarticuloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescripcionarticuloKeyPressed
       validarCampos.cantCaracteres(txtDescarticulo, 50);
       
     
    }//GEN-LAST:event_txtdescripcionarticuloKeyPressed

    private void RubroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RubroActionPerformed
       
        JDlg_AgregarRubro rubro = new JDlg_AgregarRubro(null, true);
        rubro.setLocationRelativeTo(null);
        rubro.setTitle("Nuevo Rubro");
        rubro.setVisible(true);
        comborubro();
    }//GEN-LAST:event_RubroActionPerformed

    private void MarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MarcaActionPerformed
        JDlg_AgregarMarca marca = new JDlg_AgregarMarca(null, true);
        marca.setLocationRelativeTo(null);
        marca.setTitle("Nuevo Marca");
        marca.setVisible(true);
        combomarca();
    }//GEN-LAST:event_MarcaActionPerformed

    private void tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoActionPerformed
        JDlg_AgregarTipo tipo= new JDlg_AgregarTipo(null, true);
        tipo.setLocationRelativeTo(null);
        tipo.setTitle("Nuevo Tipo");
        tipo.setVisible(true);
        comboTipo();
    }//GEN-LAST:event_tipoActionPerformed

    private void txtStockMinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockMinKeyPressed
        // TODO add your handling code here:
     validarCampos.soloNumeros(txtStockMin);
    }//GEN-LAST:event_txtStockMinKeyPressed

    private void txtCostoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCostoMouseClicked
   Mensajes.informacion("El Costo se calcula desde la pestaña Costo Calculado");
    }//GEN-LAST:event_txtCostoMouseClicked

    private void txtTarjetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTarjetaMouseClicked
       
    }//GEN-LAST:event_txtTarjetaMouseClicked

    private void txtTarjetaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTarjetaKeyPressed
       
  
    }//GEN-LAST:event_txtTarjetaKeyPressed

    private void txtPrecioProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioProveedorKeyPressed
         validarCampos.soloDecimales(txtPrecioProveedor);
    
    }//GEN-LAST:event_txtPrecioProveedorKeyPressed

    private void txtPrecioProveedorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioProveedorKeyReleased
              try
        {
            txtCostoCalc.setText(String.valueOf(precioProveedor()));
        }catch(Exception e)
        {
            txtCostoCalc.setText("0");
        }
    }//GEN-LAST:event_txtPrecioProveedorKeyReleased

    private void txtDescarticuloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescarticuloKeyPressed
       validarCampos.soloNumeros(txtDescarticulo);

    }//GEN-LAST:event_txtDescarticuloKeyPressed

    private void txtDescarticuloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescarticuloKeyReleased
            try
        {
            txtCostoCalc.setText(String.valueOf(descuentoarticulo()));
            txtCosto.setText(String.valueOf(descuentoarticulo()));
//            txtEfectivo.setText(String.valueOf(efectivo()));
            txtTarjeta.setText(String.valueOf(tarjeta()));
        }catch(Exception e)
        {
            txtCostoCalc.setText(String.valueOf(precioProveedor()));
            txtCosto.setText(String.valueOf(precioProveedor()));
            txtDescarticulo.setText("0");
        }
    
    }//GEN-LAST:event_txtDescarticuloKeyReleased

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
//          Instancia de Clase 
        Articulo miArticulo = new Articulo();
        
        // METODO GUARDAR
        gestionarArticulo guardar = new gestionarArticulo();
//       gestionarStock guarStock = new gestionarStock();

        // GUARDAR
        if (validarCampos.estaVacio(txtdescripcionarticulo) && validarCampos.estaVacio(txtStockMin)) {
            miArticulo.setCodArticulo(Integer.parseInt(txt_CodArt.getText()));
            miArticulo.setDetalle_articulo(txtdescripcionarticulo.getText().toUpperCase());

//            int pos = cbo_rubro.getSelectedIndex();
//            if (pos >= 0) {
//                Object obj = cbo_rubro.getItemAt(pos);
//                JItem item = new JItem(obj);
//
//                miArticulo.setIdRubro((Integer) item.getItemData());
//
//            }
//
//            int pos1 = cbo_Marca.getSelectedIndex();
//            if (pos1 >= 0) {
//                Object obj = cbo_Marca.getItemAt(pos1);
//
//                JItem item2 = new JItem(obj);
//
//                miArticulo.setIdMarca((Integer) item2.getItemData());
//            }
//
//            int pos2 = cbo_tipo.getSelectedIndex();
//            if (pos >= 0) {
//                Object obj = cbo_tipo.getItemAt(pos2);
//                JItem item3 = new JItem(obj);
//
//                miArticulo.setIdTipo((Integer) item3.getItemData());
//            }
//          

        int idrubro = id.buscarid("idRubro", "rubro", "nombreRubro", String.valueOf(cbo_rubro.getSelectedItem()));
        miArticulo.setIdRubro(idrubro);
        
        int idmarca = id.buscarid("idMarca", "marca", "detalleMarca", String.valueOf(cbo_Marca.getSelectedItem()));
        miArticulo.setIdMarca(idmarca);
        
        int idtipo = id.buscarid("idTipo", "tipo", "detalle_tipo", String.valueOf(cbo_tipo.getSelectedItem()));
        miArticulo.setIdTipo(idtipo);
        
            
            miArticulo.setAltoBacha(txt_AltoBacha.getText());
            miArticulo.setAnchoBacha(txt_AnchoBacha.getText());
            miArticulo.setLargoBacha(txt_largoBacha.getText());
            
            miArticulo.setStockMin(Integer.parseInt(txtStockMin.getText()));
            miArticulo.setPrecioCosto(Double.parseDouble(txtCosto.getText()));
            miArticulo.setPrecioVta(Double.parseDouble(txtventa.getText()));
//            miArticulo.setMontoCalculado(Double.parseDouble(txtCostoCalc.getText()));
//            miArticulo.setEfectivo(Double.parseDouble(txtEfectivo.getText()));
            miArticulo.setPrecioTarjeta(Double.parseDouble(txtTarjeta.getText()));
            miArticulo.setFechaAlta(txtfechaAlta.getText());
            miArticulo.setImpuesto(txt_Impuesto.getText());
            miArticulo.setStock(Integer.parseInt(txtStockMin.getText()));
            //  STOCK
//        miStock.setCod(Integer.parseInt(lblCodArt.getText()));
//        miStock.setStock(Double.parseDouble(txtStockMin.getText()));
            guardar.GuardarArticulo(miArticulo);
//        guarStock.Guardarstock(miStock);
            limpiarCampos();
            Mensajes.informacion("Artículo Registrado");
            bloquear();
        } else {

            Mensajes.informacion("Debe llenar obligatoriamente los campos en *");
        }

    }//GEN-LAST:event_GuardarActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed

        Articulo miArticulo = new Articulo();
       
        // METODO GUARDAR
        gestionarArticulo guardar = new gestionarArticulo();
//       gestionarStock guarStock = new gestionarStock();

        // GUARDAR
        if (validarCampos.estaVacio(txtdescripcionarticulo) && validarCampos.estaVacio(txtStockMin)) {
            miArticulo.setCodArticulo(Integer.parseInt(txt_CodArt.getText()));
            miArticulo.setDetalle_articulo(txtdescripcionarticulo.getText().toUpperCase());

            int pos = cbo_rubro.getSelectedIndex();
            if (pos >= 0) {
                Object obj = cbo_rubro.getItemAt(pos);
                JItem item = new JItem(obj);

                miArticulo.setIdRubro((Integer) item.getItemData());

            }

            int pos1 = cbo_Marca.getSelectedIndex();
            if (pos1 >= 0) {
                Object obj = cbo_Marca.getItemAt(pos1);
                JItem item = new JItem(obj);

                miArticulo.setIdMarca((Integer) item.getItemData());
            }

            int pos2 = cbo_tipo.getSelectedIndex();
            if (pos >= 0) {
                Object obj = cbo_tipo.getItemAt(pos2);
                JItem item = new JItem(obj);

                miArticulo.setIdTipo((Integer) item.getItemData());
            }

            miArticulo.setAltoBacha(txt_AltoBacha.getText());
            miArticulo.setAnchoBacha(txt_AnchoBacha.getText());
            miArticulo.setLargoBacha(txt_largoBacha.getText());

            miArticulo.setStockMin(Integer.parseInt(txtStockMin.getText()));
            miArticulo.setPrecioCosto(Double.parseDouble(txtCosto.getText()));
            miArticulo.setPrecioVta(Double.parseDouble(txtventa.getText()));
//            miArticulo.setMontoCalculado(Double.parseDouble(txtCostoCalc.getText()));
//            miArticulo.setEfectivo(Double.parseDouble(txtEfectivo.getText()));
            miArticulo.setPrecioTarjeta(Double.parseDouble(txtTarjeta.getText()));
            miArticulo.setFechaAlta(txtfechaAlta.getText());
            miArticulo.setImpuesto(txt_Impuesto.getText());
            //  STOCK
//        miStock.setCod(Integer.parseInt(lblCodArt.getText()));
//        miStock.setStock(Double.parseDouble(txtStockMin.getText()));
            guardar.GuardarArticulo(miArticulo);
//        guarStock.Guardarstock(miStock);
            limpiarCampos();
            Mensajes.informacion("Artículo Modificado");
            bloquear();
        } else {

            Mensajes.informacion("Debe llenar obligatoriamente los campos en *");
        }

//       // Instancia de Clase 
//       Articulo miArticulo = new Articulo();
//
//        
//     GestionarArticulo modArt = new GestionarArticulo();
//
//     
//     ////////////////////////////
//      
//        
//          // Modificar
//         if(validarCampos.estaVacio(txtdescripcionarticulo) && validarCampos.estaVacio(txtStock) && validarCampos.estaVacio(txtStockMin) && validarCampos.estaVacio(txtEfectivo))
//        {
//        miArticulo.setCodArticulo(Integer.parseInt(lblCodArt.getText()));
//      miArticulo.setDescripcion(txtdescripcionarticulo.getText().toUpperCase());
//       
//       
//       int idrubro = id.buscarid("rub_codigo", "rubro", "rub_nombre", String.valueOf(cbo_rubro.getSelectedItem()));
//       miArticulo.setCodRubro(idrubro);
//     
//       int idmarca = id.buscarid("mar_codigo", "marca", "mar_nombre", String.valueOf(cbo_Marca.getSelectedItem()));
//       miArticulo.setCodMarca(idmarca);
//     
//      int idunidad = id.buscarid("uni_codigo", "unidad", "uni_nombre", String.valueOf(cbo_tipo.getSelectedItem()));
//      miArticulo.setCodUnidad(idunidad);
//     
//      int idproveedor = id.buscarid("pro_codigo", "proveedor", "pro_razonsocial", String.valueOf(cbo_proveedor.getSelectedItem()));
//      miArticulo.setCodProveedor(idproveedor);
//      
//       miArticulo.setStock(Double.parseDouble(txtStock.getText()));
//       miArticulo.setCosto(Double.parseDouble(txtCosto.getText()));
//       miArticulo.setMontoCalculado(Double.parseDouble(txtCostoCalc.getText()));
//       miArticulo.setEfectivo(Double.parseDouble(txtEfectivo.getText()));
//       miArticulo.setTarjeta(Double.parseDouble(txtTarjeta.getText()));
//       miArticulo.setFech(txtfecha.getText());
//       miArticulo.setVenta(Double.parseDouble(txtventa.getText()));
//        modArt.modificarArticulo(miArticulo);
//        Mensajes.informacion("Artículo Modificado");
//        this.dispose();
//        }
//        else{
//        
//           //Mensajes.informacion("Debe llenar obligatoriamente los campos en *");
//       }
//        

    }//GEN-LAST:event_ModificarActionPerformed

    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoActionPerformed
//        Mensajes.informacion("Debe llenar obligatoriamente los campos en *");    
        id();
        desbloquear();
        limpiarCampos();
     
    }//GEN-LAST:event_NuevoActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        this.dispose();
    
    }//GEN-LAST:event_SalirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        DefaultComboBoxModel miDefaultCombo = new DefaultComboBoxModel();
//        DefaultComboBoxModel miDefaultCombo1 = new DefaultComboBoxModel();
//        DefaultComboBoxModel miDefaultCombo2 = new DefaultComboBoxModel();
////        DefaultComboBoxModel miDefaultCombo3 = new DefaultComboBoxModel();
        Metodos.CargarCombo miCargar = new Metodos.CargarCombo();
        Leer miLeer = new Leer();
        Rubro[] miRubro = miLeer.leer_rubros();
//        Marca[] miMarca = miLeer.leer_marca();
//        Tipo[] miTipo = miLeer.leer_tipo();
//        Proveedor[] miProveedor = miLeer.leer_Proveedor();
        
      // Proveedor[] miProv = miLeer.leer_proveedor2();

        miDefaultCombo = miCargar.cargar_combo_rubro(miDefaultCombo, miRubro);
//        miDefaultCombo1 = miCargar.cargar_combo_marca(miDefaultCombo1, miMarca);
//        miDefaultCombo2 = miCargar.cargar_combo_tipo(miDefaultCombo2, miTipo);
////        miDefaultCombo3 = miCargar.cargar_combo_proveedor(miDefaultCombo3, miProveedor);

        cbo_rubro.setModel(miDefaultCombo);
//        cbo_Marca.setModel(miDefaultCombo1);
//        cbo_tipo.setModel(miDefaultCombo2);
        
        
//        cbo_proveedor.setModel(miDefaultCombo3);
    }//GEN-LAST:event_formWindowOpened
 
    private void txtdescripcionarticuloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescripcionarticuloKeyReleased
      
    }//GEN-LAST:event_txtdescripcionarticuloKeyReleased

    private void txtStockMinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockMinKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockMinKeyReleased

    private void txtTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTarjetaActionPerformed
        // TODO add your handling code here:
        txtTarjeta.setText(String.valueOf(tarjeta()));
    }//GEN-LAST:event_txtTarjetaActionPerformed

    private void txtPorcentajeVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcentajeVentaKeyPressed
        // TODO add your handling code here:
        validarCampos.soloNumeros(txtPorcentajeVenta);
    }//GEN-LAST:event_txtPorcentajeVentaKeyPressed

    private void txtPorcentajeVentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPorcentajeVentaKeyReleased
        // TODO add your handling code here:
        try
        {
            txtCostoCalc1.setText(String.valueOf(recargoventa()));
            txtventa.setText(String.valueOf(recargoventa()));
        }catch(Exception e)
        {
            txtCostoCalc1.setText(String.valueOf(precioProveedor()));
            txtventa.setText(String.valueOf(precioProveedor()));
            txtPorcentajeVenta.setText("0");
        }
    }//GEN-LAST:event_txtPorcentajeVentaKeyReleased

    private void txtventaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtventaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtventaMouseClicked

    private void txtfechaAltaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfechaAltaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechaAltaKeyReleased

    private void txtfechaAltaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfechaAltaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechaAltaKeyPressed

    private void dcFechaOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dcFechaOnCommit
        // TODO add your handling code here:
        String fecha = dcFecha.getText();
        String fechas = Fecha.formatoFecha(fecha);
        txtfechaAlta.setText(fechas);
    }//GEN-LAST:event_dcFechaOnCommit

    private void txt_CodArtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CodArtKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CodArtKeyPressed

    private void txt_CodArtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CodArtKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CodArtKeyReleased

    private void cbo_rubroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_rubroItemStateChanged

        int idRub = id.buscarid("idRubro", "rubro", "nombreRubro", String.valueOf(cbo_rubro.getSelectedItem()));
        String consp = "Select detalleMarca from marca where idRubro like '" + idRub + "'";
        miComb.cargacombo(cbo_Marca, consp);
//        cbo_Marca.setSelectedIndex(-1);
    }//GEN-LAST:event_cbo_rubroItemStateChanged

    private void cbo_MarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_MarcaItemStateChanged

         int idMar = id.buscarid("idMarca", "marca", "detalleMarca", String.valueOf(cbo_Marca.getSelectedItem()));
        String consp = "Select detalle_tipo from tipo where idMarca like '" + idMar + "'";
        miComb.cargacombo(cbo_tipo, consp);
//        cbo_tipo.setSelectedIndex(-1);
    }//GEN-LAST:event_cbo_MarcaItemStateChanged
    
   
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(JDlg_GestinarArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlg_GestinarArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlg_GestinarArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlg_GestinarArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlg_GestinarArticulos dialog = new JDlg_GestinarArticulos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton Guardar;
    public javax.swing.JButton Marca;
    public static javax.swing.JButton Modificar;
    public static javax.swing.JButton Nuevo;
    public javax.swing.JButton Rubro;
    public static javax.swing.JButton Salir;
    public static javax.swing.JComboBox cbo_Marca;
    public static javax.swing.JComboBox cbo_rubro;
    public static javax.swing.JComboBox cbo_tipo;
    public datechooser.beans.DateChooserCombo dcFecha;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel14;
    public static javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel16;
    public javax.swing.JLabel jLabel17;
    public javax.swing.JLabel jLabel18;
    public javax.swing.JLabel jLabel19;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel20;
    public javax.swing.JLabel jLabel21;
    public javax.swing.JLabel jLabel22;
    public static javax.swing.JLabel jLabel23;
    public javax.swing.JLabel jLabel24;
    public javax.swing.JLabel jLabel25;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JLabel lblCodArt;
    public javax.swing.JButton tipo;
    public static javax.swing.JTextField txtCosto;
    public static javax.swing.JTextField txtCostoCalc;
    public static javax.swing.JTextField txtCostoCalc1;
    public static javax.swing.JTextField txtDescarticulo;
    public javax.swing.JTextField txtPorcentajeVenta;
    public static javax.swing.JTextField txtPrecioProveedor;
    public static javax.swing.JTextField txtStockMin;
    public static javax.swing.JTextField txtTarjeta;
    public javax.swing.JTextField txt_AltoBacha;
    public javax.swing.JTextField txt_AnchoBacha;
    public static javax.swing.JTextField txt_CodArt;
    public javax.swing.JTextField txt_Impuesto;
    public javax.swing.JTextField txt_largoBacha;
    public static javax.swing.JTextField txtdescripcionarticulo;
    public static javax.swing.JTextField txtfechaAlta;
    public static javax.swing.JTextField txtventa;
    // End of variables declaration//GEN-END:variables
conectar cc= new conectar();
Connection cn= cc.conexion();
}
