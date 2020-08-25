package Gestiona_articulo;

import Gestionar_Proveedores.*;
import Gestionar_Cliente.*;
import Clases.Cliente;
import Componentes.GenerarReporte;

import Componentes.Mensajes;
import Componentes.conectar;

import Gestionar_Cientes.jDlg_CargarCliente;
import Gestionar_Empleado.jDlg_CargarEmpleado25;
import Gestionar_Stock.dlgListarStock;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luca
 */
public class iFDescripcionArticulos extends javax.swing.JInternalFrame {
 DefaultTableModel model;
    /**
     * Creates new form iFDescripcionClientes
     */
    public iFDescripcionArticulos() {
        initComponents();   
        Cargar("");
        tablaarticulo();
       grupo();
    
   
    }
        
       /// INSTACIA DE CLASES
    Cliente mClientes = new Cliente();
  
     void grupo()
    {
        GrupoBotones.add(rbtnCodigo);
        GrupoBotones.add(rbtnDetalleA);
        GrupoBotones.add(rbtnMarca);
        GrupoBotones.add(rbtnRubro);
    }
        
            void tablaarticulo(){
        // Genera espacion entre las columnas 
         grillaArticulo.getColumnModel().getColumn(0).setPreferredWidth(80);
         grillaArticulo.getColumnModel().getColumn(1).setPreferredWidth(150);
         grillaArticulo.getColumnModel().getColumn(2).setPreferredWidth(150);
         grillaArticulo.getColumnModel().getColumn(3).setPreferredWidth(150);
         grillaArticulo.getColumnModel().getColumn(4).setPreferredWidth(150);
         grillaArticulo.getColumnModel().getColumn(5).setPreferredWidth(150);
         grillaArticulo.getColumnModel().getColumn(6).setPreferredWidth(150);
         grillaArticulo.getColumnModel().getColumn(7).setPreferredWidth(150);
         grillaArticulo.getColumnModel().getColumn(8).setPreferredWidth(150);
         grillaArticulo.getColumnModel().getColumn(9).setPreferredWidth(150);
         grillaArticulo.getColumnModel().getColumn(10).setPreferredWidth(150);
         grillaArticulo.getColumnModel().getColumn(11).setPreferredWidth(150);
         grillaArticulo.getColumnModel().getColumn(12).setPreferredWidth(150);
         grillaArticulo.getColumnModel().getColumn(13).setPreferredWidth(150); 
         grillaArticulo.getColumnModel().getColumn(14).setPreferredWidth(150);
                 
        
     } 

    // CARGA LA TABLA Articulo   
   void Cargar(String valor){
                
             String mostrar = "Select * FROM (articulo JOIN rubro ON ((articulo.idRubro = rubro.idRubro)))"
                + "  JOIN marca ON ((articulo.idMarca = marca.idMarca)) "
                + "JOIN tipo ON ((articulo.idTipo = tipo.idTipo))"
//                +"  JOIN proveedores ON(( persona.idPersona=proveedores.idPersona))"     
//                + " JOIN proveedores ON ((articulo.idProveedor = proveedores.idProveedor)) "
//                + "JOIN stock ON ((stock.sto_articulo = articulo.art_codigo)) "
                + "ORDER BY(idArticulo)";   // escribo la consulta SQL   
                
           String titulos[]={"Id","Codigo Art ","Descripcion","Rubro","Marca","Tipo",
                "Largo Piedra","Alto Piedra","Precio venta","Precio Tarjeta","Largo Bacha","Ancho Bacha","Alto Bacha","Art Impuesto","Stock"}; 
            
           String []Registros=new String[15];
  
                model = new DefaultTableModel(null,titulos);
  
        try {
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery(mostrar);
              while(rs.next())
              {
                  Registros[0]= rs.getString("idArticulo");
                  Registros[1]= rs.getString("codArticulo");
                  Registros[2]= rs.getString("detalle_articulo");
                  Registros[3]= rs.getString("rubro.nombreRubro");
                  Registros[4]= rs.getString("marca.detalleMarca");
                  Registros[5]= rs.getString("tipo.detalle_tipo");
                  
                  Registros[6]= rs.getString("dimensionLargo");
                  Registros[7]= rs.getString("dimensionAlto");
                  Registros[8]= rs.getString("PrecioVta");
                  Registros[9]= rs.getString("PrecioTarjeta");
                  Registros[10]= rs.getString("LargoBacha");
                  Registros[11]= rs.getString("AnchoBacha");
                  Registros[12]= rs.getString("AltoBacha");
                  Registros[13]= rs.getString("art_impuesto");
                  Registros[14]= rs.getString("StockMin");
                 
                
                  model.addRow(Registros);
              }
              grillaArticulo.setModel(model);

        } catch (SQLException ex) {
            Logger.getLogger(JDlg_GestinarArticulos.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                 
  }

  void filtrarPorCodArt(String valordeBusqueda){
                
//            String mostrar="SELECT * FROM  (persona JOIN clientes ON(( persona.idPersona=clientes.idPersona)))"
//                + " where nombre like '%" + valordeBusqueda + "%'  ";   // escribo la consulta SQL   
            
             String mostrar="Select * FROM (articulo JOIN rubro ON ((articulo.idRubro = rubro.idRubro)) "
//                     + " JOIN proveedor ON ((articulo.idProveedor = proveedores.idProveedor)) "
                     + "JOIN marca ON ((articulo.idMarca = marca.idMarca)) "
                     + "JOIN tipo ON ((articulo.idTipo = tipo.idTipo)))"
                     + " where CodArticulo like '%" + valordeBusqueda + "%'  ";
                
           String titulos[]={"Id","Codigo Art ","Descripcion","Rubro","Marca","Tipo",
                "Largo Piedra","Alto Piedra","Precio venta","Precio Tarjeta","Largo Bacha","Ancho Bacha","Alto Bacha","Art Impuesto","Stock"}; 
          
           String []Registros=new String[15];
  
                model = new DefaultTableModel(null,titulos);
  
        try {
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery(mostrar);
              while(rs.next())
              {
                 
                  Registros[0]= rs.getString("idArticulo");
                  Registros[1]= rs.getString("codArticulo");
                  Registros[2]= rs.getString("detalle_articulo");
                  Registros[3]= rs.getString("rubro.nombreRubro");
                  Registros[4]= rs.getString("marca.detalleMarca");
                  Registros[5]= rs.getString("tipo.detalle_tipo");
                  
                  Registros[6]= rs.getString("dimensionLargo");
                  Registros[7]= rs.getString("dimensionAlto");
                  Registros[8]= rs.getString("PrecioVta");
                  Registros[9]= rs.getString("PrecioTarjeta");
                  Registros[10]= rs.getString("LargoBacha");
                  Registros[11]= rs.getString("AnchoBacha");
                  Registros[12]= rs.getString("AltoBacha");
                  Registros[13]= rs.getString("art_impuesto");
                  Registros[14]= rs.getString("StockMin");
                  
                  
                
                  model.addRow(Registros);
              }
            grillaArticulo.setModel(model);
  
        } catch (SQLException ex) {
            Logger.getLogger(JDlg_GestinarArticulos.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                 
  }
    
    void filtrarPorDetalleArt(String valordeBusqueda){
             String mostrar="Select * FROM (articulo JOIN rubro ON ((articulo.idRubro = rubro.idRubro)) "
                     + "JOIN marca ON ((articulo.idMarca = marca.idMarca)) "
                     + "JOIN tipo ON ((articulo.idTipo = tipo.idTipo)))"
                       + " where detalle_articulo like '%" + valordeBusqueda + "%'  ";
                
           String titulos[]={"Id","Codigo Art ","Descripcion","Rubro","Marca","Tipo",
                "Largo Piedra","Alto Piedra","Precio venta","Precio Tarjeta","Largo Bacha","Ancho Bacha","Alto Bacha","Art Impuesto","Stock"}; 
            
           String []Registros=new String[15];
  
                model = new DefaultTableModel(null,titulos);
  
        try {
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery(mostrar);
              while(rs.next())
              {
                  
                 Registros[0]= rs.getString("idArticulo");
                  Registros[1]= rs.getString("codArticulo");
                  Registros[2]= rs.getString("detalle_articulo");
                  Registros[3]= rs.getString("rubro.nombreRubro");
                  Registros[4]= rs.getString("marca.detalleMarca");
                  Registros[5]= rs.getString("tipo.detalle_tipo");
                  
                  Registros[6]= rs.getString("dimensionLargo");
                  Registros[7]= rs.getString("dimensionAlto");
                  Registros[8]= rs.getString("PrecioVta");
                  Registros[9]= rs.getString("PrecioTarjeta");
                  Registros[10]= rs.getString("LargoBacha");
                  Registros[11]= rs.getString("AnchoBacha");
                  Registros[12]= rs.getString("AltoBacha");
                  Registros[13]= rs.getString("art_impuesto");
                  Registros[14]= rs.getString("StockMin");
                  
                
                  model.addRow(Registros);
              }
              grillaArticulo.setModel(model);
                
        } catch (SQLException ex) {
            Logger.getLogger(JDlg_GestinarArticulos.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                 
  }
    
    
    void filtrarPorRubro(String valordeBusqueda){
                
             String mostrar="Select * FROM (articulo JOIN rubro ON ((articulo.idRubro = rubro.idRubro)) "
                     + "JOIN marca ON ((articulo.idMarca = marca.idMarca)) "
                     + "JOIN tipo ON ((articulo.idTipo = tipo.idTipo)))"
                       + " where nombreRubro like '%" + valordeBusqueda + "%'  ";
                
           String titulos[]={"Id","Codigo Art ","Descripcion","Rubro","Marca","Tipo",
                "Largo Piedra","Alto Piedra","Precio venta","Precio Tarjeta","Largo Bacha","Ancho Bacha","Alto Bacha","Art Impuesto","Stock"}; 
            
           String []Registros=new String[15];
  
                model = new DefaultTableModel(null,titulos);
  
        try {
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery(mostrar);
              while(rs.next())
              {
                 
                  Registros[0]= rs.getString("idArticulo");
                  Registros[1]= rs.getString("codArticulo");
                  Registros[2]= rs.getString("detalle_articulo");
                  Registros[3]= rs.getString("rubro.nombreRubro");
                  Registros[4]= rs.getString("marca.detalleMarca");
                  Registros[5]= rs.getString("tipo.detalle_tipo");
                  
                  Registros[6]= rs.getString("dimensionLargo");
                  Registros[7]= rs.getString("dimensionAlto");
                  Registros[8]= rs.getString("PrecioVta");
                  Registros[9]= rs.getString("PrecioTarjeta");
                  Registros[10]= rs.getString("LargoBacha");
                  Registros[11]= rs.getString("AnchoBacha");
                  Registros[12]= rs.getString("AltoBacha");
                  Registros[13]= rs.getString("art_impuesto");
                  Registros[14]= rs.getString("StockMin");
                  
                   model.addRow(Registros);
              }
            grillaArticulo.setModel(model);
  
        } catch (SQLException ex) {
            Logger.getLogger(JDlg_GestinarArticulos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
                
                 
  }
    
    void filtrarPorMarca(String valordeBusqueda){
                
             String mostrar="Select * FROM (articulo JOIN rubro ON ((articulo.idRubro = rubro.idRubro)) "
                     + "JOIN marca ON ((articulo.idMarca = marca.idMarca)) "
                     + "JOIN tipo ON ((articulo.idTipo = tipo.idTipo)))"
                       + " where detalleMarca like '%" + valordeBusqueda + "%'  ";
                
           String titulos[]={"Id","Codigo Art ","Descripcion","Rubro","Marca","Tipo",
                "Largo Piedra","Alto Piedra","Precio venta","Precio Tarjeta","Largo Bacha","Ancho Bacha","Alto Bacha","Art Impuesto","Stock"};  
                
            String []Registros=new String[15];
  
                model = new DefaultTableModel(null,titulos);
  
        try {
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery(mostrar);
              while(rs.next())
              {
                 
                  Registros[0]= rs.getString("idArticulo");
                  Registros[1]= rs.getString("codArticulo");
                  Registros[2]= rs.getString("detalle_articulo");
                  Registros[3]= rs.getString("rubro.nombreRubro");
                  Registros[4]= rs.getString("marca.detalleMarca");
                  Registros[5]= rs.getString("tipo.detalle_tipo");
                  
                  Registros[6]= rs.getString("dimensionLargo");
                  Registros[7]= rs.getString("dimensionAlto");
                  Registros[8]= rs.getString("PrecioVta");
                  Registros[9]= rs.getString("PrecioTarjeta");
                  Registros[10]= rs.getString("LargoBacha");
                  Registros[11]= rs.getString("AnchoBacha");
                  Registros[12]= rs.getString("AltoBacha");
                  Registros[13]= rs.getString("art_impuesto");
                  Registros[14]= rs.getString("StockMin");
                  
                   model.addRow(Registros);
              }
             grillaArticulo.setModel(model);
  
        } catch (SQLException ex) {
            Logger.getLogger(JDlg_GestinarArticulos.class.getName()).log(Level.SEVERE, null, ex);
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

        GrupoBotones = new javax.swing.ButtonGroup();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jModificar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        grillaArticulo = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        bto_reporte = new javax.swing.JButton();
        bto_Modificar = new javax.swing.JButton();
        bto_nuevo = new javax.swing.JButton();
        bto_Salir = new javax.swing.JButton();
        rbtnCodigo = new javax.swing.JRadioButton();
        rbtnRubro = new javax.swing.JRadioButton();
        rbtnDetalleA = new javax.swing.JRadioButton();
        rbtnMarca = new javax.swing.JRadioButton();
        bto_Stock = new javax.swing.JButton();

        jModificar.setText("Modificar");
        jModificar.setComponentPopupMenu(jPopupMenu2);
        jModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jModificarActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jModificar);

        setBackground(new java.awt.Color(102, 102, 102));
        setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(51, 51, 51), null));
        setForeground(new java.awt.Color(102, 102, 102));
        setMaximizable(true);
        setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jLabel3.setText("Buscar por :");

        grillaArticulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        grillaArticulo.setModel(new javax.swing.table.DefaultTableModel(
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
        grillaArticulo.setToolTipText("");
        grillaArticulo.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        grillaArticulo.setComponentPopupMenu(jPopupMenu2);
        grillaArticulo.setSelectionBackground(new java.awt.Color(255, 0, 0));
        jScrollPane1.setViewportView(grillaArticulo);

        bto_reporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-reporte_opt.png"))); // NOI18N
        bto_reporte.setToolTipText("Reporte");
        bto_reporte.setBorderPainted(false);
        bto_reporte.setContentAreaFilled(false);
        bto_reporte.setFocusPainted(false);
        bto_reporte.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bto_reporte.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-reporte_opt (1).png"))); // NOI18N
        bto_reporte.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bto_reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_reporteActionPerformed(evt);
            }
        });

        bto_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-actualizar_opt.png"))); // NOI18N
        bto_Modificar.setToolTipText("Modificar Articulo");
        bto_Modificar.setBorderPainted(false);
        bto_Modificar.setContentAreaFilled(false);
        bto_Modificar.setFocusPainted(false);
        bto_Modificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bto_Modificar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-actualizar_opt (1).png"))); // NOI18N
        bto_Modificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bto_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_ModificarActionPerformed(evt);
            }
        });

        bto_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-editar_opt.png"))); // NOI18N
        bto_nuevo.setToolTipText("Nuevo Articulo");
        bto_nuevo.setBorderPainted(false);
        bto_nuevo.setContentAreaFilled(false);
        bto_nuevo.setFocusPainted(false);
        bto_nuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bto_nuevo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-editar_opt (1).png"))); // NOI18N
        bto_nuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bto_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_nuevoActionPerformed(evt);
            }
        });

        bto_Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-atras_opt.png"))); // NOI18N
        bto_Salir.setToolTipText("Salir");
        bto_Salir.setBorderPainted(false);
        bto_Salir.setContentAreaFilled(false);
        bto_Salir.setFocusPainted(false);
        bto_Salir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bto_Salir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-atras_opt (1).png"))); // NOI18N
        bto_Salir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bto_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_SalirActionPerformed(evt);
            }
        });

        rbtnCodigo.setText("Codigo");
        rbtnCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnCodigoActionPerformed(evt);
            }
        });

        rbtnRubro.setText("Rubro");
        rbtnRubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnRubroActionPerformed(evt);
            }
        });

        rbtnDetalleA.setText("Detalle Articulo");
        rbtnDetalleA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnDetalleAActionPerformed(evt);
            }
        });

        rbtnMarca.setText("Marca");
        rbtnMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnMarcaActionPerformed(evt);
            }
        });

        bto_Stock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-lista2_opt (1).png"))); // NOI18N
        bto_Stock.setToolTipText("Stock");
        bto_Stock.setBorderPainted(false);
        bto_Stock.setContentAreaFilled(false);
        bto_Stock.setFocusPainted(false);
        bto_Stock.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bto_Stock.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-lista2_opt.png"))); // NOI18N
        bto_Stock.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bto_Stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_StockActionPerformed(evt);
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
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(bto_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, Short.MAX_VALUE)
                                .addGap(73, 73, 73)
                                .addComponent(bto_Stock, javax.swing.GroupLayout.PREFERRED_SIZE, 98, Short.MAX_VALUE)
                                .addGap(73, 73, 73)
                                .addComponent(bto_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, Short.MAX_VALUE)
                                .addGap(71, 71, 71)
                                .addComponent(bto_reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 91, Short.MAX_VALUE)
                                .addGap(71, 71, 71)
                                .addComponent(bto_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 89, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnCodigo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtnDetalleA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtnRubro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtnMarca)))
                        .addGap(112, 112, 112)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rbtnDetalleA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbtnCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rbtnRubro)
                                .addComponent(rbtnMarca)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(bto_nuevo)
                    .addComponent(bto_Modificar)
                    .addComponent(bto_reporte)
                    .addComponent(bto_Salir)
                    .addComponent(bto_Stock))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jModificarActionPerformed
            
     
      
    }//GEN-LAST:event_jModificarActionPerformed

    private void bto_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_SalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_bto_SalirActionPerformed

    private void bto_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_nuevoActionPerformed

        JDlg_NuevoArt articulo = new JDlg_NuevoArt(null, true);
        articulo.setLocationRelativeTo(null);
//        articulo.setTitle("Nuevo Articulo");
        articulo.setVisible(true);
        Cargar("");
        tablaarticulo();
    }//GEN-LAST:event_bto_nuevoActionPerformed

    private void bto_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_ModificarActionPerformed
          
    }//GEN-LAST:event_bto_ModificarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased

       String cadena = (txtBuscar.getText()).toUpperCase();
        txtBuscar.setText(cadena);

        if(rbtnCodigo.isSelected()) {
            filtrarPorCodArt(txtBuscar.getText());
            tablaarticulo();
        }
        if(rbtnDetalleA.isSelected()) {
            filtrarPorDetalleArt(txtBuscar.getText());
            tablaarticulo();
        }
        if(rbtnMarca.isSelected()) {
            filtrarPorMarca(txtBuscar.getText());
            tablaarticulo();
        }
          if(rbtnRubro.isSelected()) {
            filtrarPorRubro(txtBuscar.getText());
            tablaarticulo();
        }
               if(txtBuscar.getText().length()==0){
            Cargar("");
            tablaarticulo();
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void rbtnCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnCodigoActionPerformed

    private void rbtnRubroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnRubroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnRubroActionPerformed

    private void rbtnDetalleAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnDetalleAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnDetalleAActionPerformed

    private void rbtnMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnMarcaActionPerformed

    private void bto_StockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_StockActionPerformed
                
          dlgListarStock stock = new dlgListarStock(null, true);
        stock.setLocationRelativeTo(null);
//        articulo.setTitle("Nuevo Articulo");
        stock.setVisible(true);
        
       
    }//GEN-LAST:event_bto_StockActionPerformed
         public void llamarReporteArt() {
        GenerarReporte gr;
        gr = new GenerarReporte();
//        int codF = Integer.parseInt(dlgVentaRecibo.txtDocumentoVenta.getText());
        gr.MostrarReporte("src/Reportes/Articulos/Artiulos.jasper", "Reporte Articulos");
        
    }
    private void bto_reporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_reporteActionPerformed
        llamarReporteArt();
        // TODO add your handling code here:
    }//GEN-LAST:event_bto_reporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoBotones;
    private javax.swing.JButton bto_Modificar;
    private javax.swing.JButton bto_Salir;
    private javax.swing.JButton bto_Stock;
    private javax.swing.JButton bto_nuevo;
    private javax.swing.JButton bto_reporte;
    public static javax.swing.JTable grillaArticulo;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jModificar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtnCodigo;
    private javax.swing.JRadioButton rbtnDetalleA;
    private javax.swing.JRadioButton rbtnMarca;
    private javax.swing.JRadioButton rbtnRubro;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
conectar cc= new conectar();
Connection cn= cc.conexion();
}
