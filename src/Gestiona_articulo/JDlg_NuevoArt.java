/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestiona_articulo;

import Clases.Articulo;
import Clases.Marca;
import Clases.Rubro;
import Clases.Tipo;
import Componentes.Fecha;
import Componentes.Mensajes;
import Componentes.Redondeo;
import static Gestiona_articulo.JDlg_GestinarArticulos.cbo_rubro;

import Metodos.CargarCombo;
import Metodos.Conectar;
import Metodos.Leer;
import Metodos.buscarid;
import Metodos.gestionarArticulo;
import Metodos.validarCampos;
import java.awt.MouseInfo;
import java.awt.Point;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


/**
 *
 * @author Gaston
 */
public class JDlg_NuevoArt extends javax.swing.JDialog {

    /**
     * Creates new form NewJDialog
     */
    public JDlg_NuevoArt(java.awt.Frame parent, boolean modal) {
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
        this.setLocationRelativeTo(null);
    }
    
     private int x;
    private int y;
    
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

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        Guardar = new javax.swing.JButton();
        Modificar = new javax.swing.JButton();
        Nuevo = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
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
        stock = new javax.swing.JLabel();
        txtStockMin = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        costo = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTarjeta = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtventa = new javax.swing.JTextField();
        txtfechaAlta = new javax.swing.JTextField();
        dcFecha = new datechooser.beans.DateChooserCombo();
        jLabel7 = new javax.swing.JLabel();
        largo = new javax.swing.JLabel();
        txt_largoBacha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_AnchoBacha = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txt_AltoBacha = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txt_Impuesto = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_CodArt = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtPrecioProveedor = new javax.swing.JTextField();
        txtDescarticulo = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtCostoCalc = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtPorcentajeVenta = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtCostoCalc1 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-guardar_opt (1).png"))); // NOI18N
        Guardar.setToolTipText("Guardar Articulo");
        Guardar.setBorderPainted(false);
        Guardar.setContentAreaFilled(false);
        Guardar.setFocusPainted(false);
        Guardar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-guardar_opt.png"))); // NOI18N
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
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

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_ABM/arabescato.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(88, 88, 88)
                    .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(48, 48, 48)
                    .addComponent(Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(47, 47, 47)
                    .addComponent(Nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(50, 50, 50)
                    .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(105, Short.MAX_VALUE)))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Guardar)
                        .addComponent(Salir, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Modificar, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Nuevo))
                    .addContainerGap(20, Short.MAX_VALUE)))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 109, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jTabbedPane2.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseDragged(evt);
            }
        });
        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTabbedPane2MousePressed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(102, 102, 102));

        jPanel8.setBackground(new java.awt.Color(102, 102, 102));
        jPanel8.setOpaque(false);

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

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Código :");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("* Descripcion :");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("* Rubro :");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
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

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
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
        lblCodArt.setForeground(new java.awt.Color(255, 255, 255));
        lblCodArt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Rubro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/icons8_Plus_25px.png"))); // NOI18N
        Rubro.setToolTipText("Agregar");
        Rubro.setBorderPainted(false);
        Rubro.setContentAreaFilled(false);
        Rubro.setFocusPainted(false);
        Rubro.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/icons8_Plus_30px.png"))); // NOI18N
        Rubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RubroActionPerformed(evt);
            }
        });

        Marca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/icons8_Plus_25px.png"))); // NOI18N
        Marca.setToolTipText("Agregar");
        Marca.setBorderPainted(false);
        Marca.setContentAreaFilled(false);
        Marca.setFocusPainted(false);
        Marca.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/icons8_Plus_30px.png"))); // NOI18N
        Marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MarcaActionPerformed(evt);
            }
        });

        tipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/icons8_Plus_25px.png"))); // NOI18N
        tipo.setToolTipText("Agregar");
        tipo.setBorderPainted(false);
        tipo.setContentAreaFilled(false);
        tipo.setFocusPainted(false);
        tipo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/icons8_Plus_30px.png"))); // NOI18N
        tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoActionPerformed(evt);
            }
        });

        stock.setForeground(new java.awt.Color(255, 255, 255));
        stock.setText("Stock Min:");

        txtStockMin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtStockMinKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStockMinKeyReleased(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("F. Alta :");

        costo.setForeground(new java.awt.Color(255, 255, 255));
        costo.setText("Costo :");

        txtCosto.setEditable(false);
        txtCosto.setText("0");
        txtCosto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCostoMouseClicked(evt);
            }
        });

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
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

        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
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

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Bachas Dimensiones:");

        largo.setForeground(new java.awt.Color(255, 255, 255));
        largo.setText("Largo:");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ancho:");

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Alto:");

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Impuesto al que esta ligado:");

        txt_Impuesto.setText("21%");

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("* Codigo de Articulo:");

        txt_CodArt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_CodArtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_CodArtKeyReleased(evt);
            }
        });

        jLabel27.setBackground(new java.awt.Color(102, 102, 102));
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel25))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7)))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_largoBacha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCosto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStockMin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Impuesto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfechaAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_AnchoBacha, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_AltoBacha, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtventa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(txt_CodArt, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCodArt, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdescripcionarticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(cbo_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                    .addComponent(cbo_Marca, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Marca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(cbo_rubro, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(6, 6, 6)
                                    .addComponent(Rubro))))))
                .addGap(0, 214, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(costo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(stock)
                            .addComponent(largo))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblCodArt, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(txt_CodArt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel2))
                            .addComponent(txtdescripcionarticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)))
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(Rubro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbo_rubro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(Marca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbo_Marca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbo_tipo)
                    .addComponent(jLabel5)
                    .addComponent(tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_largoBacha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_AnchoBacha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_AltoBacha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(largo)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel24))))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(37, 37, 37)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(txt_Impuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtStockMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfechaAlta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(costo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jTabbedPane2.addTab("Datos", jPanel7);

        jPanel10.setBackground(new java.awt.Color(102, 102, 102));

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Precio del Proveedor :");

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Descuentos Aplicados:");

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("El costo calculado es :");

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

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("%");

        txtCostoCalc.setEditable(false);
        txtCostoCalc.setBackground(new java.awt.Color(0, 0, 0));
        txtCostoCalc.setForeground(new java.awt.Color(255, 255, 255));
        txtCostoCalc.setText("0");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Calcular Valor Producto Venta");

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Porcentaje al Valor :");

        txtPorcentajeVenta.setText(" ");
        txtPorcentajeVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPorcentajeVentaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPorcentajeVentaKeyReleased(evt);
            }
        });

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Precio Venta :");

        txtCostoCalc1.setEditable(false);
        txtCostoCalc1.setBackground(new java.awt.Color(0, 0, 0));
        txtCostoCalc1.setForeground(new java.awt.Color(255, 255, 255));
        txtCostoCalc1.setText("0");

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("%");

        jLabel29.setBackground(new java.awt.Color(102, 102, 102));
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel16)
                        .addGap(44, 44, 44)
                        .addComponent(txtPrecioProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(44, 44, 44)
                        .addComponent(txtDescarticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel19))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(47, 47, 47)
                        .addComponent(txtCostoCalc, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel20)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(55, 55, 55)
                        .addComponent(txtPorcentajeVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel26))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(85, 85, 85)
                        .addComponent(txtCostoCalc1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(451, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel16))
                    .addComponent(txtPrecioProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescarticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel19))))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel18))
                    .addComponent(txtCostoCalc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addGap(20, 20, 20)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel21))
                    .addComponent(txtPorcentajeVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel26)))
                .addGap(20, 20, 20)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel22))
                    .addComponent(txtCostoCalc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(173, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jTabbedPane2.addTab("Costo Calculado", jPanel9);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_ABM/textura-en-negro_1366x768_1550.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_ABM/textura-en-negro_1366x768_1550.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 57, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

            int idRubro = id.buscarid("idRubro", "rubro", "nombreRubro", String.valueOf(cbo_rubro.getSelectedItem()));
            miArticulo.setIdRubro(idRubro);

            //       int pos = cbo_rubro.getSelectedIndex();
            //            if (pos >= 0) {
                //                Object obj = cbo_rubro.getItemAt(pos);
                //                JItem item = new JItem(obj);
                //
                //                miArticulo.setIdRubro((Integer) item.getItemData());
                //
                //            }
            int idMarca = id.buscarid("idMarca", "marca", "detalleMarca", String.valueOf(cbo_Marca.getSelectedItem()));
            miArticulo.setIdMarca(idMarca);

            int idTipo = id.buscarid("idTipo", "tipo", "detalle_tipo", String.valueOf(cbo_tipo.getSelectedItem()));
            miArticulo.setIdTipo(idTipo);

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

    private void cbo_rubroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_rubroItemStateChanged

        int idRub = id.buscarid("idRubro", "rubro", "nombreRubro", String.valueOf(cbo_rubro.getSelectedItem()));
        String consp = "Select detalleMarca from marca where idRubro like '" + idRub + "'";
        miComb.cargacombo(cbo_Marca, consp);
        //        cbo_Marca.setSelectedIndex(-1);
    }//GEN-LAST:event_cbo_rubroItemStateChanged

    private void cbo_rubroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_rubroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_rubroActionPerformed

    private void cbo_MarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_MarcaItemStateChanged

        int idMar = id.buscarid("idMarca", "marca", "detalleMarca", String.valueOf(cbo_Marca.getSelectedItem()));
        String consp = "Select detalle_tipo from tipo where idMarca like '" + idMar + "'";
        miComb.cargacombo(cbo_tipo, consp);
        //        cbo_tipo.setSelectedIndex(-1);
    }//GEN-LAST:event_cbo_MarcaItemStateChanged

    private void cbo_MarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_MarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_MarcaActionPerformed

    private void cbo_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_tipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_tipoActionPerformed

    private void txtdescripcionarticuloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescripcionarticuloKeyPressed
        validarCampos.cantCaracteres(txtDescarticulo, 50);
    }//GEN-LAST:event_txtdescripcionarticuloKeyPressed

    private void txtdescripcionarticuloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescripcionarticuloKeyReleased

    }//GEN-LAST:event_txtdescripcionarticuloKeyReleased

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

    private void txtStockMinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockMinKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockMinKeyReleased

    private void txtCostoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCostoMouseClicked
        Mensajes.informacion("El Costo se calcula desde la pestaña Costo Calculado");
    }//GEN-LAST:event_txtCostoMouseClicked

    private void txtTarjetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTarjetaMouseClicked

    }//GEN-LAST:event_txtTarjetaMouseClicked

    private void txtTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTarjetaActionPerformed
        // TODO add your handling code here:
        txtTarjeta.setText(String.valueOf(tarjeta()));
    }//GEN-LAST:event_txtTarjetaActionPerformed

    private void txtTarjetaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTarjetaKeyPressed

    }//GEN-LAST:event_txtTarjetaKeyPressed

    private void txtventaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtventaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtventaMouseClicked

    private void txtfechaAltaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfechaAltaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechaAltaKeyPressed

    private void txtfechaAltaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfechaAltaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechaAltaKeyReleased

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

    private void jTabbedPane2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseDragged

        Point ubicacion = MouseInfo.getPointerInfo().getLocation();//1
        System.out.println("Coordenadas: ("+ubicacion.x+","+ubicacion.y+")");//2
        setLocation(ubicacion.x - x, ubicacion.y - y);//3
    }//GEN-LAST:event_jTabbedPane2MouseDragged

    private void jTabbedPane2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MousePressed

        // TODO add your handling code here:
           x = evt.getX();

        y = evt.getY();
    }//GEN-LAST:event_jTabbedPane2MousePressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        // TODO add your handling code here:
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
        cbo_rubro.setSelectedIndex(-1);
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(JDlg_NuevoArt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlg_NuevoArt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlg_NuevoArt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlg_NuevoArt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlg_NuevoArt dialog = new JDlg_NuevoArt(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton Marca;
    public static javax.swing.JButton Modificar;
    public static javax.swing.JButton Nuevo;
    private javax.swing.JButton Rubro;
    public static javax.swing.JButton Salir;
    public static javax.swing.JComboBox cbo_Marca;
    public static javax.swing.JComboBox cbo_rubro;
    public static javax.swing.JComboBox cbo_tipo;
    private javax.swing.JLabel costo;
    private datechooser.beans.DateChooserCombo dcFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    public static javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    public static javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel largo;
    public static javax.swing.JLabel lblCodArt;
    private javax.swing.JLabel stock;
    private javax.swing.JButton tipo;
    public static javax.swing.JTextField txtCosto;
    public static javax.swing.JTextField txtCostoCalc;
    public static javax.swing.JTextField txtCostoCalc1;
    public static javax.swing.JTextField txtDescarticulo;
    private javax.swing.JTextField txtPorcentajeVenta;
    public static javax.swing.JTextField txtPrecioProveedor;
    public static javax.swing.JTextField txtStockMin;
    public static javax.swing.JTextField txtTarjeta;
    private javax.swing.JTextField txt_AltoBacha;
    private javax.swing.JTextField txt_AnchoBacha;
    public static javax.swing.JTextField txt_CodArt;
    private javax.swing.JTextField txt_Impuesto;
    private javax.swing.JTextField txt_largoBacha;
    public static javax.swing.JTextField txtdescripcionarticulo;
    public static javax.swing.JTextField txtfechaAlta;
    public static javax.swing.JTextField txtventa;
    // End of variables declaration//GEN-END:variables
}
