/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios.Gestionar_Ventas;

import Componentes.Mensajes; 
import Componentes.conectar;
import Gestiona_articulo.iFDescripcionArticulos;
import com.toedter.calendar.JDateChooser; 
import java.awt.Frame; 
import java.awt.event.ActionEvent; 
import java.awt.event.MouseEvent; 
import javax.swing.JButton; 
import javax.swing.JDialog; 
import javax.swing.JLabel; 
import javax.swing.JPanel; 
import javax.swing.JScrollPane; 
import javax.swing.JTable; 
import javax.swing.JTextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fernando
 */
public class dlgConsultarVentas extends javax.swing.JDialog {
DefaultTableModel model;
conectar cc= new conectar();
Connection cn= cc.conexion();
Date fecha_ini,fecha_fin;
static ResultSet rs=null;
    /**
     * Creates new form dlgConsultarVentas
     */
    public dlgConsultarVentas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargar();
        tablaventa();
        titulosdetVen();
        grupo();
        tablaDetalleVenta();
         this.setLocationRelativeTo(null);
       
    }
    
     void grupo()
    {
        grupoBotones.add(rbtnApellidoCliente);
        grupoBotones.add(rbtnRazon);
        grupoBotones.add(rbtnCuit);
        
    }
//    void limpiarTabla(){
//        try{    
//            txtCliente.setText("");
//            txtCodVenta.setText("");
//            txtFechaVenta.setText("");
//            txtTotalVenta.setText("");
//	int filas=grillaDetVentas.getRowCount();
//            for (int i = 0;filas>i; i++) {
//                model.removeRow(0);
//                tablaventa();
//                tablaDetalleVenta();
//               cargar("");
//            }
//        } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
//        }
//    }
     void tablaventa(){
        // Genera espacion entre las columnas 
         grillaVentas.getColumnModel().getColumn(0).setPreferredWidth(60);
         grillaVentas.getColumnModel().getColumn(1).setPreferredWidth(100);
         grillaVentas.getColumnModel().getColumn(2).setPreferredWidth(150);
        
         grillaVentas.getColumnModel().getColumn(3).setPreferredWidth(75);
         grillaVentas.getColumnModel().getColumn(4).setPreferredWidth(100);
         grillaVentas.getColumnModel().getColumn(5).setPreferredWidth(100);
         grillaVentas.getColumnModel().getColumn(6).setPreferredWidth(150);
         grillaVentas.getColumnModel().getColumn(7).setPreferredWidth(100);
         grillaVentas.getColumnModel().getColumn(8).setPreferredWidth(100);
     }
     
          void tablaDetalleVenta(){
        // Genera espacion entre las columnas 
         grillaDetVentas.getColumnModel().getColumn(0).setPreferredWidth(60);
         grillaDetVentas.getColumnModel().getColumn(1).setPreferredWidth(100);
         grillaDetVentas.getColumnModel().getColumn(2).setPreferredWidth(400);
         grillaDetVentas.getColumnModel().getColumn(3).setPreferredWidth(100);
         grillaDetVentas.getColumnModel().getColumn(4).setPreferredWidth(100);
     }
    
    void cargar(){
    String mostrar="Select * FROM ventafactura"; 
//            + "JOIN clientes ON ((ventafactura.idCliente = clientes.idCliente)))";
            
          
    String titulos[] = {"Nro","FechaEmiison","FechaVencimiento","Cod Cliente","Nombre",
                            "Apellido","Razon Social","CUIT","Total"};
    String []Registros=new String[9];
    model = new DefaultTableModel(null,titulos);
  
        try {
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery(mostrar);
              while(rs.next())
              {
                  Registros[0]= rs.getString("idVFactura");
                  Registros[1]= rs.getString("FechaEmision");
                  Registros[2]= rs.getString("FechaVencimiento");
                  Registros[3]= rs.getString("idCliente");
                  Registros[4]= rs.getString("nombre");
                  Registros[5]= rs.getString("apellido");
                  Registros[6]= rs.getString("cli_razonsocial");
                 
                  Registros[7]= rs.getString("cli_cuit");
                  Registros[8]= rs.getString("TotalPagar");
                       model.addRow(Registros);
              }
              grillaVentas.setModel(model);
              
        } catch (SQLException ex) {
            Logger.getLogger(iFDescripcionArticulos.class.getName()).log(Level.SEVERE, null, ex);
        }
    
  }  
    
     void FiltrarPorRazon(String valordeBusqueda){
    String mostrar="Select * FROM ventafactura where cli_razonsocial like '%" + valordeBusqueda + "%'";
//            + "JOIN clientes ON ((ventafactura.idCliente = clientes.idCliente)))";
            
          
    String titulos[] = {"Nro","FechaEmiison","FechaVencimiento","Cod Cliente","Nombre",
                            "Apellido","Razon Social","CUIT","Total"};
    String []Registros=new String[9];
    model = new DefaultTableModel(null,titulos);
  
        try {
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery(mostrar);
              while(rs.next())
              {
                  Registros[0]= rs.getString("idVFactura");
                  Registros[1]= rs.getString("FechaEmision");
                  Registros[2]= rs.getString("FechaVencimiento");
                  Registros[3]= rs.getString("idCliente");
                  Registros[4]= rs.getString("nombre");
                  Registros[5]= rs.getString("apellido");
                  Registros[6]= rs.getString("cli_razonsocial");
                 
                  Registros[7]= rs.getString("cli_cuit");
                  Registros[8]= rs.getString("TotalPagar");
                       model.addRow(Registros);
              }
              grillaVentas.setModel(model);
              
        } catch (SQLException ex) {
            Logger.getLogger(iFDescripcionArticulos.class.getName()).log(Level.SEVERE, null, ex);
        }
    
  }  
     
      void FiltrarPorApellido(String valordeBusqueda){
    String mostrar="Select * FROM ventafactura where apellido like '%" + valordeBusqueda + "%'"; 
//            + "JOIN clientes ON ((ventafactura.idCliente = clientes.idCliente)))";
            
          
    String titulos[] = {"Nro","FechaEmiison","FechaVencimiento","Cod Cliente","Nombre",
                            "Apellido","Razon Social","CUIT","Total"};
    String []Registros=new String[9];
    model = new DefaultTableModel(null,titulos);
  
        try {
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery(mostrar);
              while(rs.next())
              {
                  Registros[0]= rs.getString("idVFactura");
                  Registros[1]= rs.getString("FechaEmision");
                  Registros[2]= rs.getString("FechaVencimiento");
                  Registros[3]= rs.getString("idCliente");
                  Registros[4]= rs.getString("nombre");
                  Registros[5]= rs.getString("apellido");
                  Registros[6]= rs.getString("cli_razonsocial");
                 
                  Registros[7]= rs.getString("cli_cuit");
                  Registros[8]= rs.getString("TotalPagar");
                       model.addRow(Registros);
              }
              grillaVentas.setModel(model);
              
        } catch (SQLException ex) {
            Logger.getLogger(iFDescripcionArticulos.class.getName()).log(Level.SEVERE, null, ex);
        }
    
  }  
      
       void FiltrarPorCuit(String valordeBusqueda){
    String mostrar="Select * FROM ventafactura where cli_cuit like '%" + valordeBusqueda + "%'";
//            + "JOIN clientes ON ((ventafactura.idCliente = clientes.idCliente)))";
            
          
    String titulos[] = {"Nro","FechaEmiison","FechaVencimiento","Cod Cliente","Nombre",
                            "Apellido","Razon Social","CUIT","Total"};
    String []Registros=new String[9];
    model = new DefaultTableModel(null,titulos);
  
        try {
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery(mostrar);
              while(rs.next())
              {
                  Registros[0]= rs.getString("idVFactura");
                  Registros[1]= rs.getString("FechaEmision");
                  Registros[2]= rs.getString("FechaVencimiento");
                  Registros[3]= rs.getString("idCliente");
                  Registros[4]= rs.getString("nombre");
                  Registros[5]= rs.getString("apellido");
                  Registros[6]= rs.getString("cli_razonsocial");
                 
                  Registros[7]= rs.getString("cli_cuit");
                  Registros[8]= rs.getString("TotalPagar");
                       model.addRow(Registros);
              }
              grillaVentas.setModel(model);
              
        } catch (SQLException ex) {
            Logger.getLogger(iFDescripcionArticulos.class.getName()).log(Level.SEVERE, null, ex);
        }
    
  }  
     
     void titulosdetVen (){
         String titulosdet[] =  {"Cantidad","Cód.Articulo","Descripción","Precio/u","Total"};
         model = new DefaultTableModel(null,titulosdet);
         grillaDetVentas.setModel(model);
     }
    void cargarDetalleVenta(String valor){
    String mos="Select * FROM (detallefactura JOIN articulo ON ((detallefactura.idProducto = articulo.idArticulo)))  "
            + " JOIN ventafactura ON ((detallefactura.idVFactura = ventafactura.idVFactura))  WHERE (ventafactura.idVFactura) like '%"+valor+"%'";
    String titulosdet[] =  {"Cantidad","Cód.Articulo","Descripción","Precio/u","Total"};
    String []Registros=new String[20];
    model = new DefaultTableModel(null,titulosdet);
  
        try {
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery(mos);
              while(rs.next())
              {
                  Registros[0]= rs.getString("detallefactura.cantidad");
                  Registros[1]= rs.getString("articulo.idArticulo");
                  Registros[2]= rs.getString("articulo.detalle_articulo");
                  Registros[3]= rs.getString("detallefactura.Precio");                  
                  Registros[4]= rs.getString("detallefactura.PrecioM2");
                 
               
                  model.addRow(Registros);
              }
              grillaDetVentas.setModel(model);

        } catch (SQLException ex) {
            Logger.getLogger(dlgConsultarVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                 
  }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotones = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        grillaVentas = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodVenta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFechaVenta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        grillaDetVentas = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        jLabel6 = new javax.swing.JLabel();
        txtTotalVenta = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtBuscar = new javax.swing.JTextField();
        rbtnApellidoCliente = new javax.swing.JRadioButton();
        rbtnRazon = new javax.swing.JRadioButton();
        rbtnCuit = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        grillaVentas.setModel(new javax.swing.table.DefaultTableModel(
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
        grillaVentas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        grillaVentas.setSelectionBackground(new java.awt.Color(255, 51, 51));
        grillaVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grillaVentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(grillaVentas);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Factura de Venta");

        txtCodVenta.setEditable(false);
        txtCodVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodVentaActionPerformed(evt);
            }
        });

        jLabel2.setText("Fecha Emision :");

        txtFechaVenta.setEditable(false);

        jLabel3.setText("Cliente");

        txtCliente.setEditable(false);

        grillaDetVentas.setModel(new javax.swing.table.DefaultTableModel(
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
        grillaDetVentas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(grillaDetVentas);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("TOTAL :");

        txtTotalVenta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTotalVenta.setText("S/.");

        txtApellido.setEditable(false);

        jLabel4.setText("Nombre:");

        jLabel5.setText("Apellido:");

        txtNombre.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCodVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 285, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCodVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
        );

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        rbtnApellidoCliente.setForeground(new java.awt.Color(255, 255, 255));
        rbtnApellidoCliente.setText("Apellido");
        rbtnApellidoCliente.setContentAreaFilled(false);

        rbtnRazon.setForeground(new java.awt.Color(255, 255, 255));
        rbtnRazon.setText("Razon Social");
        rbtnRazon.setContentAreaFilled(false);

        rbtnCuit.setForeground(new java.awt.Color(255, 255, 255));
        rbtnCuit.setText("CUIT");
        rbtnCuit.setContentAreaFilled(false);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_ABM/orig_60533_1.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnApellidoCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtnRazon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnCuit)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 786, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnApellidoCliente)
                    .addComponent(rbtnRazon)
                    .addComponent(rbtnCuit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 642, Short.MAX_VALUE)
                    .addGap(10, 10, 10)))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-atras_opt.png"))); // NOI18N
        jButton1.setToolTipText("Salir");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-atras_opt (1).png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_ABM/orig_60533_1.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(351, 351, 351)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 786, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 645, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void grillaVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grillaVentasMouseClicked

        int fila= grillaVentas.getSelectedRow();
        try {
            if(fila>=0){
                String numero = grillaVentas.getValueAt(fila, 0).toString();
                String fecha = grillaVentas.getValueAt(fila, 1).toString();
                String cli = grillaVentas.getValueAt(fila, 3).toString();
                String total = grillaVentas.getValueAt(fila, 8).toString();
                String nombre = grillaVentas.getValueAt(fila, 4).toString();
                String apellido = grillaVentas.getValueAt(fila, 5).toString();
                txtFechaVenta.setText(fecha);
                txtCodVenta.setText(numero);
                txtCliente.setText(cli);
                txtTotalVenta.setText(total);
                txtNombre.setText(nombre);
                 txtApellido.setText(apellido);

                cargarDetalleVenta(numero);
                tablaDetalleVenta();
            }

        }
        catch (Exception e) {

        }

    }//GEN-LAST:event_grillaVentasMouseClicked

    private void txtCodVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodVentaActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased

        String cadena = (txtBuscar.getText()).toUpperCase();
        txtBuscar.setText(cadena);

        if(rbtnApellidoCliente.isSelected()) {
            FiltrarPorApellido(txtBuscar.getText());
            tablaventa();
        }
        if(rbtnCuit.isSelected()) {
            FiltrarPorCuit(txtBuscar.getText());
            tablaventa();
        }
        if(rbtnRazon.isSelected()) {
            FiltrarPorRazon(txtBuscar.getText());
            tablaventa();
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
//void BuscarVenta(){
//        String titulos[] = {"Nro","Fecha","Cliente","Empleado","Estado","Total"};
//        model.setColumnIdentifiers(titulos);
//        
//        gestionarVenta venta=new gestionarVenta();
//
//        fecha_ini=dcFechaini.getDate();
//        fecha_fin=dcFechafin.getDate();
//            try{
//            rs=venta.listarVentaPorFecha("anular",fecha_ini,fecha_fin);
//            boolean encuentra=false;
//            String Datos[]=new String[9];
//            int f,i;
//            f=model.getRowCount();
//            if(f>0){
//                for(i=0;i<f;i++){
//                    model.removeRow(0);
//                }
//            }
//            while(rs.next()){
//                Datos[0]=(String) rs.getString(1);
//                Datos[1]=(String) rs.getString(2);
//                Datos[2]=(String) rs.getString(3);
//                Datos[3]=(String) rs.getString(4);
//                Datos[4]=(String) rs.getString(5);
//                Datos[5]=(String) rs.getString(6);
//                model.addRow(Datos);
//                encuentra=true;
//
//            }
//            if(encuentra=false){
//                JOptionPane.showMessageDialog(null, "¡No se encuentra!");
//            }
//
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        grillaVentas.setModel(model);
//        
//    }
  
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
            java.util.logging.Logger.getLogger(dlgConsultarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgConsultarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgConsultarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgConsultarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgConsultarVentas dialog = new dlgConsultarVentas(new javax.swing.JFrame(), true);
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
    public static javax.swing.JTable grillaDetVentas;
    public static javax.swing.JTable grillaVentas;
    private javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbtnApellidoCliente;
    private javax.swing.JRadioButton rbtnCuit;
    private javax.swing.JRadioButton rbtnRazon;
    public static javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscar;
    public static javax.swing.JTextField txtCliente;
    public static javax.swing.JTextField txtCodVenta;
    public static javax.swing.JTextField txtFechaVenta;
    public static javax.swing.JTextField txtNombre;
    public static javax.swing.JTextField txtTotalVenta;
    // End of variables declaration//GEN-END:variables
}
