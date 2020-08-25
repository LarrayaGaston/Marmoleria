/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios.Gestionar_Ventas;

import Clases.DetalleFactura;
import Clases.ventaFactura;
import Componentes.Mensajes;
import static Formularios.Gestionar_Ventas.IF_FacturaVenta.Lb_idCliente;
import static Formularios.Gestionar_Ventas.IF_FacturaVenta.txtCUIL;
import static Formularios.Gestionar_Ventas.IF_FacturaVenta.txtRazonS;
import static Formularios.Gestionar_Ventas.IF_FacturaVenta.txt_M2;
import static Formularios.Gestionar_Ventas.IF_FacturaVenta.txt_Precio;
import static Formularios.Gestionar_Ventas.IF_FacturaVenta.txt_alto;
import static Formularios.Gestionar_Ventas.IF_FacturaVenta.txt_apellido_cli;
import static Formularios.Gestionar_Ventas.IF_FacturaVenta.txt_largo;
import static Formularios.Gestionar_Ventas.IF_FacturaVenta.txt_nombre_cli;
import static Formularios.Gestionar_Ventas.IF_FacturaVenta.txt_precioM2;
import static Gestionar_Cientes.jDlg_CargarCliente.lb_titulo;
import Metodos.Leer;
import Metodos.gestionarVenta;
import java.awt.MouseInfo;
import java.awt.Point;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gaston
 */
public class JDlg_Factura extends javax.swing.JDialog {

    /**
     * Creates new form JDlg_Factura
     */
    DefaultTableModel dtmDetalle= new DefaultTableModel();
    public JDlg_Factura(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        //---------------------FECHA ACTUAL-------------------------------
        Date date=new Date();
        String format=new String("dd/MM/yyyy");
        SimpleDateFormat formato=new SimpleDateFormat(format);
        txtFechaEmision.setDate(date);
        
        String titulos[] = {"id","CÓDIGO", "ARTICULO", "DESCRIPCIÓN", "CANT", "Largo", "Alto", "M2", "P.Unitario", "SUBTOTAL"};
       setTitle("Venta Factura");//1
        dtmDetalle.setColumnIdentifiers(titulos);
        
        tabla_factura.setModel(dtmDetalle);
        this.setLocationRelativeTo(null);
        inicio();
    }
     String tipoDocumento,accion;
    ventaFactura miVenta = new ventaFactura();
    DetalleFactura detVen = new DetalleFactura();
   
 
    void limpiarTabla() {
        try {
            int filas = tabla_factura.getRowCount();
            for (int i = 0; filas > i; i++) {
                dtmDetalle.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }
     
       @Override
        public void setTitle(String title) {
             super.setTitle(title);
                lb_Titulo.setText(title);
    }
     void CalcularPrecioM2() {
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        DecimalFormat formateador = new DecimalFormat("####.##", simbolos);
        double precio, largo, alto, res = 0, dimension, m2;
        int  cant;
        precio = Double.parseDouble(txt_Precio.getText());
        cant = Integer.parseInt(txt_cant.getText());
        largo = Double.parseDouble(txt_largo.getText());
        alto = Double.parseDouble(txt_alto.getText());

        dimension = largo * alto;
        m2 = dimension * cant;
        txt_M2.setText(String.valueOf(formateador.format(m2)));

        res = precio * m2;
        txt_precioM2.setText(String.valueOf(formateador.format(res)));

    }

    void CalcularValor_Venta() {
        int fila = 0;
        double valorVenta = 0;
        fila = dtmDetalle.getRowCount();
        for (int f = 0; f < fila; f++) {
            valorVenta += Double.parseDouble(String.valueOf(tabla_factura.getModel().getValueAt(f, 9)));
        }
        txt_ValorVenta.setText(String.valueOf(valorVenta));
    }

    void CalcularSubTotal() {
        double subtotal = 0;
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        DecimalFormat formateador = new DecimalFormat("####.##", simbolos);
        subtotal = Double.parseDouble(txtTotalPagar.getText()) / 1.21;
        txtSubTotal.setText(String.valueOf(formateador.format(subtotal)));
    }

    void CalcularIVA() {
        double iva = 0;
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        DecimalFormat formateador = new DecimalFormat("####.##", simbolos);
        iva = Double.parseDouble(txtSubTotal.getText()) * 0.21;
        txtIVA.setText(String.valueOf(formateador.format(iva)));
    }

    void CalcularTotal_Pagar() {
        double totalpagar;
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        DecimalFormat formateador = new DecimalFormat("####.##", simbolos);
        totalpagar = Double.parseDouble(txt_ValorVenta.getText()) - Double.parseDouble(txtDescuento.getText());

        txtTotalPagar.setText(String.valueOf(formateador.format(totalpagar)));
    }
    
       void limpiarCampos(){

       txt_ValorVenta.setText("0.0");
       txtDescuento.setText("0.0");
       txtSubTotal.setText("0.0");
       txtIVA.setText("0.0");
       txtTotalPagar.setText("0.0");
       
       
       txtCodigP.setText("");
       txt_nombrePro.setText("");
       txt_stockProd.setText("");
       txt_Precio.setText("");
       txt_cant.setText("");
       txt_precioM2.setText("");
       txtCodigP.requestFocus();
       
       txt_alto.setText("");
       txt_largo.setText("");
       txt_M2.setText("");
       txt_Rubro.setText("");
   }
       void modificar(){

       bto_limpiart.setEnabled(false);
       Nuevo.setEnabled(true);
//       btnCancelar.setEnabled(true);
       Salir.setEnabled(true);
       txtCodigP.setEnabled(true);
       txt_cant.setEnabled(true);
       txtFechaEmision.setEnabled(true);
       bto_buscarCliente.setEnabled(true);
       bto_buscarArticulo.setEnabled(true);
       bto_AgregarAlaLista.setEnabled(true);
       bto_limpiart.setEnabled(true);
//       bt.setEnabled(true);
       txtCodigP.requestFocus();
       Guardar_cliente.setEnabled(true);
       verVentas.setEnabled(true);
       Imprime_recibo.setEnabled(true);
       Importe.setEnabled(true);
   }
       void inicio(){
       bto_limpiart.setEnabled(true);
       Nuevo.setEnabled(true);
//       btnCancelar.setEnabled(true);
       Salir.setEnabled(true);
       txtCodigP.setEnabled(true);
       txt_cant.setEnabled(true);
       txtFechaEmision.setEnabled(true);
       bto_buscarCliente.setEnabled(true);
       bto_buscarArticulo.setEnabled(true);
       bto_AgregarAlaLista.setEnabled(true);
       bto_limpiart.setEnabled(true);
//       bt.setEnabled(true);
       txtCodigP.requestFocus();
       Guardar_cliente.setEnabled(true);
       verVentas.setEnabled(true);
       Imprime_recibo.setEnabled(true);
       Importe.setEnabled(true);
       
       }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private int x;
    private int y;
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_idArticulo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lb_Titulo = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Salir = new javax.swing.JButton();
        verVentas = new javax.swing.JButton();
        Guardar_cliente = new javax.swing.JButton();
        Imprime_recibo = new javax.swing.JButton();
        Nuevo = new javax.swing.JButton();
        Importe = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtFechaEmision = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtFechaVencimiento = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtCodigP = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_nombrePro = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txt_Precio = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_largo = new javax.swing.JTextField();
        txt_alto = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txt_cant = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txt_precioM2 = new javax.swing.JTextField();
        txt_M2 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txt_stockProd = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txt_Rubro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_factura = new javax.swing.JTable();
        bto_buscarArticulo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cbo_tipoFac = new javax.swing.JComboBox<>();
        txt_numFactura = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        cbo_formadePago = new javax.swing.JComboBox<>();
        cbo_condIVA = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        txtIVA = new javax.swing.JTextField();
        txtTotalPagar = new javax.swing.JTextField();
        txt_ValorVenta = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        txtImporte = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtCambio = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        txt_nombre_cli = new javax.swing.JTextField();
        txtCUIL = new javax.swing.JTextField();
        txtDomicilios = new javax.swing.JTextField();
        txtCiudad = new javax.swing.JTextField();
        txtCodp = new javax.swing.JTextField();
        txtcondIva = new javax.swing.JTextField();
        txt_prov = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        txtRazonS = new javax.swing.JTextField();
        txt_apellido_cli = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        bto_buscarCliente = new javax.swing.JButton();
        bto_AgregarAlaLista = new javax.swing.JButton();
        bto_limpiart = new javax.swing.JButton();
        bto_QuitardeLaLista1 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        Lb_IdCliente = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();

        txt_idArticulo.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_Titulo.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        lb_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        lb_Titulo.setText("Factura Venta");
        jPanel3.add(lb_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 5, -1, -1));

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_ABM/textura-en-negro_1366x768_1550.jpg"))); // NOI18N
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1029, 26));

        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-atras_opt.png"))); // NOI18N
        Salir.setToolTipText("Salir");
        Salir.setBorderPainted(false);
        Salir.setContentAreaFilled(false);
        Salir.setFocusPainted(false);
        Salir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-atras_opt (1).png"))); // NOI18N
        Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SalirMouseExited(evt);
            }
        });
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        verVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-reporte_opt.png"))); // NOI18N
        verVentas.setToolTipText("Ver Ventas");
        verVentas.setBorderPainted(false);
        verVentas.setContentAreaFilled(false);
        verVentas.setFocusPainted(false);
        verVentas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-reporte_opt (1)_1.png"))); // NOI18N
        verVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                verVentasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                verVentasMouseExited(evt);
            }
        });
        verVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verVentasActionPerformed(evt);
            }
        });

        Guardar_cliente.setBackground(new java.awt.Color(255, 255, 255));
        Guardar_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-guardar_opt (1).png"))); // NOI18N
        Guardar_cliente.setToolTipText("Guardar Cliente");
        Guardar_cliente.setBorderPainted(false);
        Guardar_cliente.setContentAreaFilled(false);
        Guardar_cliente.setFocusable(false);
        Guardar_cliente.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-guardar_opt.png"))); // NOI18N
        Guardar_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Guardar_clienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Guardar_clienteMouseExited(evt);
            }
        });
        Guardar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guardar_clienteActionPerformed(evt);
            }
        });

        Imprime_recibo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-imprimir_opt (1).png"))); // NOI18N
        Imprime_recibo.setToolTipText("Nuevo");
        Imprime_recibo.setBorderPainted(false);
        Imprime_recibo.setContentAreaFilled(false);
        Imprime_recibo.setFocusPainted(false);
        Imprime_recibo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-imprimir_opt.png"))); // NOI18N
        Imprime_recibo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Imprime_reciboMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Imprime_reciboMouseExited(evt);
            }
        });
        Imprime_recibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Imprime_reciboActionPerformed(evt);
            }
        });

        Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-editar_opt.png"))); // NOI18N
        Nuevo.setToolTipText("Nuevo");
        Nuevo.setBorderPainted(false);
        Nuevo.setContentAreaFilled(false);
        Nuevo.setFocusPainted(false);
        Nuevo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-editar_opt (1).png"))); // NOI18N
        Nuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NuevoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NuevoMouseExited(evt);
            }
        });
        Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoActionPerformed(evt);
            }
        });

        Importe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-dinero2_opt.png"))); // NOI18N
        Importe.setToolTipText("Nuevo");
        Importe.setBorderPainted(false);
        Importe.setContentAreaFilled(false);
        Importe.setFocusPainted(false);
        Importe.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-dinero2_opt (1).png"))); // NOI18N
        Importe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ImporteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ImporteMouseExited(evt);
            }
        });
        Importe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImporteActionPerformed(evt);
            }
        });

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_ABM/textura-en-negro_1366x768_1550.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Importe, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Imprime_recibo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(verVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Guardar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(Nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Importe, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Imprime_recibo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(verVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Guardar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 3, Short.MAX_VALUE)))
        );

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(txtFechaEmision, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 142, 30));

        jLabel13.setText("Emision: ");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        jLabel14.setText("Vencimiento:");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, -1, 30));

        txtFechaVencimiento.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtFechaVencimientoAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel5.add(txtFechaVencimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 142, 30));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Datos del Articulo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel15.setText("Codig Producto: ");

        txtCodigP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel16.setText("Nombre Producto: ");

        txt_nombrePro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel17.setText("Precio:");

        txt_Precio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel18.setText("Largo:");

        jLabel19.setText("Alto:");

        txt_largo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txt_alto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel20.setText("Cantidad:");

        txt_cant.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_cant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cantKeyReleased(evt);
            }
        });

        jLabel21.setText("Precio x M2:");

        txt_precioM2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txt_M2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel22.setText("M2:");

        jLabel37.setText("Stock:");

        txt_stockProd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel38.setText("Articulo");

        txt_Rubro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtCodigP, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nombrePro, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(jLabel37))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txt_Rubro, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_stockProd, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18))
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_alto, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(txt_largo, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(txt_cant))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_precioM2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(45, 45, 45)
                        .addComponent(txt_M2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtCodigP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_nombrePro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel21)
                                .addComponent(txt_precioM2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20)
                                .addComponent(txt_cant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_M2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel22))
                            .addComponent(txt_largo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel38)
                                .addComponent(txt_Rubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel15)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_alto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_stockProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel37)
                                .addComponent(jLabel16)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)))
                .addContainerGap())
        );

        jPanel5.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 770, -1));

        tabla_factura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_factura.setSelectionBackground(new java.awt.Color(255, 51, 51));
        jScrollPane1.setViewportView(tabla_factura);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 409, 858, 180));

        bto_buscarArticulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bto_buscarArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/icons8_Search_25px.png"))); // NOI18N
        bto_buscarArticulo.setText("Buscar Articulo");
        bto_buscarArticulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bto_buscarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_buscarArticuloActionPerformed(evt);
            }
        });
        jPanel5.add(bto_buscarArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 240, 130, 38));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Datos Factura", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Tipo de Comprobante:");
        jLabel4.setOpaque(true);
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 30, 110, -1));

        cbo_tipoFac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", " " }));
        jPanel2.add(cbo_tipoFac, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 27, 41, -1));

        txt_numFactura.setText("000000-100");
        jPanel2.add(txt_numFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 27, 142, -1));

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Nº");
        jLabel31.setOpaque(true);
        jPanel2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        cbo_formadePago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Forma de Pago" }));
        jPanel2.add(cbo_formadePago, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 81, 161, -1));

        cbo_condIVA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cond. IVA" }));
        jPanel2.add(cbo_condIVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 81, 142, -1));

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 360, 140));

        jPanel6.setBackground(new java.awt.Color(255, 246, 227));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("SUB TOTAL");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("I.V.A.");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("TOTAL A PAGAR");
        jLabel34.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtSubTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSubTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSubTotal.setEnabled(false);

        txtIVA.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtIVA.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtIVA.setEnabled(false);

        txtTotalPagar.setBackground(new java.awt.Color(0, 0, 0));
        txtTotalPagar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTotalPagar.setForeground(new java.awt.Color(0, 255, 102));
        txtTotalPagar.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalPagar.setDisabledTextColor(new java.awt.Color(0, 255, 102));
        txtTotalPagar.setEnabled(false);

        txt_ValorVenta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_ValorVenta.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_ValorVenta.setEnabled(false);

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("VALOR VENTA");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("DESCUENTO");

        txtDescuento.setBackground(new java.awt.Color(255, 255, 204));
        txtDescuento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDescuento.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDescuento.setText("0");
        txtDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescuentoActionPerformed(evt);
            }
        });
        txtDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyReleased(evt);
            }
        });

        txtImporte.setBackground(new java.awt.Color(0, 0, 0));
        txtImporte.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtImporte.setForeground(new java.awt.Color(255, 255, 255));
        txtImporte.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtImporte.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtImporte.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("IMPORTE");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("CAMBIO");

        txtCambio.setBackground(new java.awt.Color(0, 0, 0));
        txtCambio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCambio.setForeground(new java.awt.Color(255, 255, 0));
        txtCambio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCambio.setDisabledTextColor(new java.awt.Color(255, 255, 0));
        txtCambio.setEnabled(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txt_ValorVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(txtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_ValorVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIVA, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36))
        );

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 610, 800, 70));

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Datos Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        txt_nombre_cli.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtCUIL.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtDomicilios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtCiudad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtCodp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtCodp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodpActionPerformed(evt);
            }
        });

        txtcondIva.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtcondIva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcondIvaActionPerformed(evt);
            }
        });

        txt_prov.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_prov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_provActionPerformed(evt);
            }
        });

        txtDni.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });

        txtRazonS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txt_apellido_cli.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CUIT/CUIL:");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Domicilio:");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ciudad:");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Cod.P:");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Apellido:");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Razon social:");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("DNI:");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Provincia:");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("IVA:");

        bto_buscarCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bto_buscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/icons8_Search_25px.png"))); // NOI18N
        bto_buscarCliente.setText("Buscar Cliente");
        bto_buscarCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bto_buscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_buscarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txt_nombre_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCUIL, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDomicilios, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodp, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txt_apellido_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRazonS, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_prov, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcondIva, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(bto_buscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(243, 243, 243))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_nombre_cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_apellido_cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))))
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCUIL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRazonS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))))
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtDomicilios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_prov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10))))
                .addGap(11, 11, 11)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCodp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12))
                    .addComponent(txtcondIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bto_buscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 480, 220));

        bto_AgregarAlaLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/icons8_Plus_30px.png"))); // NOI18N
        bto_AgregarAlaLista.setToolTipText("Agregar a la lista");
        bto_AgregarAlaLista.setBorderPainted(false);
        bto_AgregarAlaLista.setContentAreaFilled(false);
        bto_AgregarAlaLista.setFocusPainted(false);
        bto_AgregarAlaLista.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/icons8_Plus_35px.png"))); // NOI18N
        bto_AgregarAlaLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_AgregarAlaListaActionPerformed(evt);
            }
        });
        jPanel5.add(bto_AgregarAlaLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, 50, -1));

        bto_limpiart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/icons8_Cancel_30px.png"))); // NOI18N
        bto_limpiart.setToolTipText("Limpiar Tabla");
        bto_limpiart.setBorderPainted(false);
        bto_limpiart.setContentAreaFilled(false);
        bto_limpiart.setFocusPainted(false);
        bto_limpiart.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/icons8_Cancel_35px.png"))); // NOI18N
        bto_limpiart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_limpiartActionPerformed(evt);
            }
        });
        jPanel5.add(bto_limpiart, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 240, 50, -1));

        bto_QuitardeLaLista1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/icons8_Cancel_30px.png"))); // NOI18N
        bto_QuitardeLaLista1.setToolTipText("Quitar de la Lista");
        bto_QuitardeLaLista1.setBorderPainted(false);
        bto_QuitardeLaLista1.setContentAreaFilled(false);
        bto_QuitardeLaLista1.setFocusPainted(false);
        bto_QuitardeLaLista1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/icons8_Cancel_35px.png"))); // NOI18N
        bto_QuitardeLaLista1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_QuitardeLaLista1ActionPerformed(evt);
            }
        });
        jPanel5.add(bto_QuitardeLaLista1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 240, 50, -1));

        jLabel25.setText("Cliente ID:");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 4, -1, 40));
        jPanel5.add(Lb_IdCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 4, 50, 40));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_ABM/arabescato.jpg"))); // NOI18N
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 0, 920, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 914, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaVencimientoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtFechaVencimientoAncestorAdded
        //---------------------FECHA ACTUAL-------------------------------
        Date date=new Date();
        String format=new String("dd/MM/yyyy");
        SimpleDateFormat formato=new SimpleDateFormat(format);
        txtFechaVencimiento.setDate(date);
    }//GEN-LAST:event_txtFechaVencimientoAncestorAdded

    private void txt_cantKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantKeyReleased

        CalcularPrecioM2();

    }//GEN-LAST:event_txt_cantKeyReleased

    private void bto_buscarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_buscarArticuloActionPerformed
        try {
            JDlg_BuscarArticuloVta miArt = new JDlg_BuscarArticuloVta(null, true);
            miArt.setLocationRelativeTo(null);
            miArt.setTitle("Buscar Cliente");
            miArt.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");

        }
    }//GEN-LAST:event_bto_buscarArticuloActionPerformed

    private void txtDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescuentoActionPerformed

    private void txtDescuentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyReleased
        CalcularTotal_Pagar();
        CalcularSubTotal();
        CalcularIVA();
    }//GEN-LAST:event_txtDescuentoKeyReleased

    private void ImporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImporteActionPerformed

        String ingreso = JOptionPane.showInputDialog(null, "Ingrese Importe a Cancelar", "0.0");
        Double importe,cambio;
        if (ingreso.compareTo("") != 0) {
            importe = Double.parseDouble(ingreso);
            txtImporte.setText(String.valueOf(importe));
            cambio = Double.parseDouble(txtImporte.getText()) - Double.parseDouble(txtTotalPagar.getText());
            txtCambio.setText(String.valueOf(cambio));
        } else {
            txtImporte.setText("0.0");
        }
    }//GEN-LAST:event_ImporteActionPerformed

    private void ImporteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImporteMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ImporteMouseExited

    private void ImporteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImporteMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ImporteMouseEntered

    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoActionPerformed
          accion="Nuevo";
        limpiarCampos();
        modificar();
    }//GEN-LAST:event_NuevoActionPerformed

    private void NuevoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NuevoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_NuevoMouseExited

    private void NuevoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NuevoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_NuevoMouseEntered

    private void Imprime_reciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Imprime_reciboActionPerformed

        Formularios.Gestionar_Ventas.dlgVentaRecibo VentaRecibo= new dlgVentaRecibo(null, rootPaneCheckingEnabled);
        VentaRecibo.setVisible(true);
        VentaRecibo.setTitle("VER");
    }//GEN-LAST:event_Imprime_reciboActionPerformed

    private void Imprime_reciboMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Imprime_reciboMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_Imprime_reciboMouseExited

    private void Imprime_reciboMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Imprime_reciboMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Imprime_reciboMouseEntered

    private void Guardar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guardar_clienteActionPerformed

        
        // METODO GUARDAR

        int cant = 0,ncant=0,stock=0;

        Leer miLeerF = new Leer();
        gestionarVenta guardVenta= new gestionarVenta();
        gestionarVenta detVenta= new gestionarVenta();

        //        Actualizar actualizarStock =new Actualizar();
        //
        //        llamarArticulo llamArt= new llamarArticulo();

        int result = JOptionPane.showConfirmDialog(this, "¿Desea Generar la Venta?", "Mensaje del Sistema", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            if(txt_nombre_cli.getText().isEmpty() )                                                                                                   //VALIDACIONES
            {
                JOptionPane.showMessageDialog(null,"SELECCIONA CLIENTE ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);

            }

            //
            //        else if(txt_cant.getText().isEmpty() )
            //       {
                //           JOptionPane.showMessageDialog(null,"SELECCIONE CANTIDAD ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
                //
                //       }
            //       else if(txtImporte.getText().isEmpty() )
            //       {
                //           JOptionPane.showMessageDialog(null,"SELECCIONE IMPORTE ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
                //
                //       }
            //                double importe =Double.parseDouble(txtImporte.getText());
            //                double totalapagar =Double.parseDouble(txtTotalPagar.getText());

            //             if( importe < totalapagar  )
            //                {
                //                    JOptionPane.showMessageDialog(null,"INGRESE OTRO VALOR ","Error: Importe Insuficiente",JOptionPane.ERROR_MESSAGE);
                //                }
            //
            //       else{

                miVenta.setFechaEmision(txtFechaEmision.getDate());
                miVenta.setIdCliente(Integer.parseInt(Lb_IdCliente.getText()));
                miVenta.setNumeroFac(txt_numFactura.getText());
                miVenta.setNombre(txt_nombre_cli.getText());
                miVenta.setApellido(txt_apellido_cli.getText());
                miVenta.setCli_razonsocial(txtRazonS.getText());
                miVenta.setCli_cuit(Integer.parseInt(txtCUIL.getText()));

                //                miVenta.setStrIdEmpleado(Formulario.frmPrincipal.txtide.getText());
                //                int idcondpago = id.buscarid("condp_codigo", "cond_pago", "condp_nombre", String.valueOf(cmbCondPago.getSelectedItem()));
                //                miVenta.setCondPago(idcondpago);
                miVenta.setTotalVenta(Double.parseDouble(txt_ValorVenta.getText()));
                miVenta.setDescuento(Double.parseDouble(txtDescuento.getText()));
                miVenta.setSubTotal(Double.parseDouble(txtSubTotal.getText()));
                miVenta.setIVA(Double.parseDouble(txtIVA.getText()));
                miVenta.setTotalPagar(Double.parseDouble(txtTotalPagar.getText()));
                miVenta.setEstado("EMITIDO");
                miVenta.setFechaVencimiento(txtFechaVencimiento.getDate());

                guardVenta.GuardarVentaF(miVenta);

                ///////////////////DETALLE VENTA////////////////////

                int UltimaFac = miLeerF.leerUltimaFac();

                for (int i=0; i < dtmDetalle.getRowCount(); i++){
                    detVen.setIdVFactura(UltimaFac);
                    detVen.setIdProducto(Integer.parseInt(tabla_factura.getValueAt(i, 0).toString()));
                    detVen.setCodArticulo(tabla_factura.getValueAt(i, 1).toString());

                    detVen.setCantidad(Integer.parseInt(tabla_factura.getValueAt(i, 4).toString()));
                    detVen.setLargoP(Double.parseDouble(tabla_factura.getValueAt(i, 5).toString()));
                    detVen.setAltoP(Double.parseDouble(tabla_factura.getValueAt(i, 6).toString()));
                    detVen.setM2(Double.parseDouble(tabla_factura.getValueAt(i, 7).toString()));
                    detVen.setPrecio(Double.parseDouble(tabla_factura.getValueAt(i, 8).toString()));
                    detVen.setPrecioM2(Double.parseDouble(tabla_factura.getValueAt(i, 9).toString()));
                    detVenta.GuardarDetalleFctura(detVen);
                    //                    art=llamArt.llamarArt("art_codigo", tblDetalleProducto.getValueAt(i, 1).toString()); //llama al articulo
                    //                actualizarStock.actualizarproductoventa(art,Double.parseDouble(txtCantidadProducto.getText()));// Manda articulo y cantidad
                }

                Mensajes.informacion("Venta y Detalle Guardados");

                //            mirar();
                limpiarTabla();
                //            id();

                if (result == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Venta Anulada!");
                }

                //             }
        }

    }//GEN-LAST:event_Guardar_clienteActionPerformed

    private void Guardar_clienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Guardar_clienteMouseExited

    }//GEN-LAST:event_Guardar_clienteMouseExited

    private void Guardar_clienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Guardar_clienteMouseEntered

    }//GEN-LAST:event_Guardar_clienteMouseEntered

    private void verVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verVentasActionPerformed
        //        idcli();
        //        desbloquear();
        //        limpiarCampos();
    }//GEN-LAST:event_verVentasActionPerformed

    private void verVentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verVentasMouseExited

    }//GEN-LAST:event_verVentasMouseExited

    private void verVentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verVentasMouseEntered

    }//GEN-LAST:event_verVentasMouseEntered

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_SalirActionPerformed

    private void SalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseExited

    }//GEN-LAST:event_SalirMouseExited

    private void SalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseEntered

    }//GEN-LAST:event_SalirMouseEntered

    private void txtCodpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodpActionPerformed

    private void txt_provActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_provActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_provActionPerformed

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void bto_buscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_buscarClienteActionPerformed
        try {
            JDlg_BuscarClientesVta miCliente = new JDlg_BuscarClientesVta(null, true);
            miCliente.setLocationRelativeTo(null);
            miCliente.setTitle("Buscar Cliente");
            miCliente.setVisible(true);
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");

        }

    }//GEN-LAST:event_bto_buscarClienteActionPerformed

    private void bto_AgregarAlaListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_AgregarAlaListaActionPerformed

        int stock,cant;

        if (!txt_cant.getText().equals("")){
            if(txt_cant.getText().equals("")){
                txt_cant.setText("0");
                cant=Integer.parseInt(txt_cant.getText());
            }else{
                cant=Integer.parseInt(txt_cant.getText());
            }

            if(cant>0){
                stock=Integer.parseInt(txt_stockProd.getText());
                cant=Integer.parseInt(txt_cant.getText());
                if(cant<=stock){

                    String Datos[] = new String[10];

                    Datos[0]=txt_idArticulo.getText();
                    Datos[1]=txtCodigP.getText();
                    Datos[2]=txt_Rubro.getText();
                    Datos[3]=txt_nombrePro.getText();
                    Datos[4]=txt_cant.getText();
                    Datos[5]=txt_largo.getText();
                    Datos[6]=txt_alto.getText();
                    Datos[7]=txt_M2.getText();
                    Datos[8]=txt_Precio.getText();
                    Datos[9]=txt_precioM2.getText();

                    dtmDetalle.addRow(Datos);

                    CalcularValor_Venta();
                    CalcularTotal_Pagar();
                    CalcularSubTotal();
                    CalcularIVA();

                    txt_cant.setText("");
                    txt_precioM2.setText("");

                    txtCodigP.setText("");
                    txt_nombrePro.setText("");
                    txt_stockProd.setText("");
                    txt_Precio.setText("");
                    txtCodigP.requestFocus();
                }else{
                    JOptionPane.showMessageDialog(null, "Stock Insuficiente");
                    txt_cant.requestFocus();
                }

            }else{
                JOptionPane.showMessageDialog(null, "Ingrese Cantidad mayor a 0");
                txt_cant.requestFocus();
            }

        }else{
            JOptionPane.showMessageDialog(null, "Ingrese cantidad");
            txt_cant.requestFocus();
        }
    }//GEN-LAST:event_bto_AgregarAlaListaActionPerformed

    private void txtcondIvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcondIvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcondIvaActionPerformed

    private void bto_limpiartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_limpiartActionPerformed

        
         limpiarTabla();
        txt_ValorVenta.setText("0.0");
        txtDescuento.setText("0.0");
        txtSubTotal.setText("0.0");
        txtIVA.setText("0.0");
        txtTotalPagar.setText("0.0");
        txtCodigP.requestFocus();
    }//GEN-LAST:event_bto_limpiartActionPerformed

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked

    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged

        Point ubicacion = MouseInfo.getPointerInfo().getLocation();//1
        System.out.println("Coordenadas: ("+ubicacion.x+","+ubicacion.y+")");//2
        setLocation(ubicacion.x - x, ubicacion.y - y);//3
    }//GEN-LAST:event_jPanel3MouseDragged

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed

       
        x = evt.getX();

        y = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void bto_QuitardeLaLista1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_QuitardeLaLista1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bto_QuitardeLaLista1ActionPerformed

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
            java.util.logging.Logger.getLogger(JDlg_Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlg_Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlg_Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlg_Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlg_Factura dialog = new JDlg_Factura(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton Guardar_cliente;
    private javax.swing.JButton Importe;
    private javax.swing.JButton Imprime_recibo;
    public static javax.swing.JLabel Lb_IdCliente;
    private javax.swing.JButton Nuevo;
    private javax.swing.JButton Salir;
    private javax.swing.JButton bto_AgregarAlaLista;
    private javax.swing.JButton bto_QuitardeLaLista1;
    private javax.swing.JButton bto_buscarArticulo;
    private javax.swing.JButton bto_buscarCliente;
    private javax.swing.JButton bto_limpiart;
    private javax.swing.JComboBox<String> cbo_condIVA;
    private javax.swing.JComboBox<String> cbo_formadePago;
    private javax.swing.JComboBox<String> cbo_tipoFac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_Titulo;
    private javax.swing.JTable tabla_factura;
    public static javax.swing.JTextField txtCUIL;
    private javax.swing.JTextField txtCambio;
    public static javax.swing.JTextField txtCiudad;
    public static javax.swing.JTextField txtCodigP;
    public static javax.swing.JTextField txtCodp;
    private javax.swing.JTextField txtDescuento;
    public static javax.swing.JTextField txtDni;
    public static javax.swing.JTextField txtDomicilios;
    private com.toedter.calendar.JDateChooser txtFechaEmision;
    private com.toedter.calendar.JDateChooser txtFechaVencimiento;
    private javax.swing.JTextField txtIVA;
    private javax.swing.JTextField txtImporte;
    public static javax.swing.JTextField txtRazonS;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotalPagar;
    public static javax.swing.JTextField txt_M2;
    public static javax.swing.JTextField txt_Precio;
    public static javax.swing.JTextField txt_Rubro;
    private javax.swing.JTextField txt_ValorVenta;
    public static javax.swing.JTextField txt_alto;
    public static javax.swing.JTextField txt_apellido_cli;
    private javax.swing.JTextField txt_cant;
    public static javax.swing.JTextField txt_idArticulo;
    public static javax.swing.JTextField txt_largo;
    public static javax.swing.JTextField txt_nombrePro;
    public static javax.swing.JTextField txt_nombre_cli;
    private javax.swing.JTextField txt_numFactura;
    public static javax.swing.JTextField txt_precioM2;
    public static javax.swing.JTextField txt_prov;
    public static javax.swing.JTextField txt_stockProd;
    public static javax.swing.JTextField txtcondIva;
    private javax.swing.JButton verVentas;
    // End of variables declaration//GEN-END:variables
}
