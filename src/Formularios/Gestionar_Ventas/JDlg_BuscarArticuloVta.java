/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios.Gestionar_Ventas;


import Componentes.conectar;
import Gestiona_articulo.JDlg_GestinarArticulos;
import Gestionar_Cientes.jDlg_CargarCliente;
import java.awt.Point;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gaston
 */
public class JDlg_BuscarArticuloVta extends javax.swing.JDialog {

        DefaultTableModel model;
    /**
     * Creates new form JDlg_BuscarClienteVentas
     */
    public JDlg_BuscarArticuloVta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
         Cargar("");
        tablaArticulo();
        grupo();
    }
    
   conectar cc= new conectar();
    Connection cn = cc.conexion();
    
     void grupo()
    {
        grupoBotones.add(rbtnCodigo);
        grupoBotones.add(rbtDescrip);
        grupoBotones.add(bto_FiltraRubro);
        grupoBotones.add(bto_FiltraMarca);
        
    }
     void tablaArticulo(){
        // Genera espacion entre las columnas 
         grillaArticulo.getColumnModel().getColumn(0).setPreferredWidth(80);
         grillaArticulo.getColumnModel().getColumn(1).setPreferredWidth(120);
         grillaArticulo.getColumnModel().getColumn(2).setPreferredWidth(120);
         grillaArticulo.getColumnModel().getColumn(3).setPreferredWidth(120);
         grillaArticulo.getColumnModel().getColumn(4).setPreferredWidth(120);
         grillaArticulo.getColumnModel().getColumn(5).setPreferredWidth(120);
         grillaArticulo.getColumnModel().getColumn(6).setPreferredWidth(120);
         grillaArticulo.getColumnModel().getColumn(7).setPreferredWidth(120);
         grillaArticulo.getColumnModel().getColumn(8).setPreferredWidth(120);
         grillaArticulo.getColumnModel().getColumn(9).setPreferredWidth(120);
         grillaArticulo.getColumnModel().getColumn(10).setPreferredWidth(120);
         grillaArticulo.getColumnModel().getColumn(11).setPreferredWidth(120);
         grillaArticulo.getColumnModel().getColumn(12).setPreferredWidth(120);
         grillaArticulo.getColumnModel().getColumn(13).setPreferredWidth(120); 
         grillaArticulo.getColumnModel().getColumn(14).setPreferredWidth(120);
         grillaArticulo.getColumnModel().getColumn(15).setPreferredWidth(120);
         
                 
        
     } 
    
   
    
   void Cargar(String valor){
                
             String mostrar = "Select * FROM (articulo JOIN rubro ON ((articulo.idRubro = rubro.idRubro)))"
                + "  JOIN marca ON ((articulo.idMarca = marca.idMarca)) "
                + "JOIN tipo ON ((articulo.idTipo = tipo.idTipo))"
//                +"  JOIN proveedores ON(( persona.idPersona=proveedores.idPersona))"     
//                + " JOIN proveedores ON ((articulo.idProveedor = proveedores.idProveedor)) "
//                + "JOIN stock ON ((stock.sto_articulo = articulo.art_codigo)) "
                + "ORDER BY(idArticulo)";   // escribo la consulta SQL   
                
           String titulos[]={"Id","Codigo Art ","Descripcion","Rubro","Marca","Tipo",
                "Largo Piedra","Alto Piedra","Precio venta","Precio Tarjeta","Largo Bacha","Ancho Bacha","Alto Bacha","Art Impuesto","Stock Min","Stock"}; 
            
           String []Registros=new String[16];
  
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
                  Registros[15]= rs.getString("Stock");
                 
                
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
                "Largo Piedra","Alto Piedra","Precio venta","Precio Tarjeta","Largo Bacha","Ancho Bacha","Alto Bacha","Art Impuesto","Stock Min","Stock"}; 
            
           String []Registros=new String[16];
  
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
                  Registros[15]= rs.getString("Stock");
                  
                  
                
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
                "Largo Piedra","Alto Piedra","Precio venta","Precio Tarjeta","Largo Bacha","Ancho Bacha","Alto Bacha","Art Impuesto","Stock Min","Stock"}; 
            
           String []Registros=new String[16];
  
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
                  Registros[15]= rs.getString("Stock");
                  
                
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
                "Largo Piedra","Alto Piedra","Precio venta","Precio Tarjeta","Largo Bacha","Ancho Bacha","Alto Bacha","Art Impuesto","Stock Min","Stock"}; 
            
           String []Registros=new String[16];
  
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
                  Registros[15]= rs.getString("Stock");
                  
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
                "Largo Piedra","Alto Piedra","Precio venta","Precio Tarjeta","Largo Bacha","Ancho Bacha","Alto Bacha","Art Impuesto","Stock Min","Stock"}; 
            
           String []Registros=new String[16];
  
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
                  Registros[15]= rs.getString("Stock");
                  
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

        grupoBotones = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        txt_buscarArticulo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        rbtnCodigo = new javax.swing.JRadioButton();
        rbtDescrip = new javax.swing.JRadioButton();
        bto_FiltraRubro = new javax.swing.JRadioButton();
        bto_FiltraMarca = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        grillaArticulo = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        txt_buscarArticulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarArticuloKeyReleased(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Articulo:");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_ABM/orig_60533_1.jpg"))); // NOI18N

        rbtnCodigo.setForeground(new java.awt.Color(255, 255, 255));
        rbtnCodigo.setText("Codigo Producto");
        rbtnCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnCodigoActionPerformed(evt);
            }
        });

        rbtDescrip.setForeground(new java.awt.Color(255, 255, 255));
        rbtDescrip.setText("Descripcion Producto");
        rbtDescrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtDescripActionPerformed(evt);
            }
        });

        bto_FiltraRubro.setForeground(new java.awt.Color(255, 255, 255));
        bto_FiltraRubro.setText("Rubro");
        bto_FiltraRubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_FiltraRubroActionPerformed(evt);
            }
        });

        bto_FiltraMarca.setForeground(new java.awt.Color(255, 255, 255));
        bto_FiltraMarca.setText("Marca");
        bto_FiltraMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_FiltraMarcaActionPerformed(evt);
            }
        });

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
        grillaArticulo.setSelectionBackground(new java.awt.Color(255, 51, 51));
        grillaArticulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grillaArticuloMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                grillaArticuloMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(grillaArticulo);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_buscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnCodigo)
                        .addGap(13, 13, 13)
                        .addComponent(rbtDescrip)
                        .addGap(10, 10, 10)
                        .addComponent(bto_FiltraRubro, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bto_FiltraMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 803, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_buscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtDescrip, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bto_FiltraRubro)
                    .addComponent(bto_FiltraMarca))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addGap(31, 31, 31))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 371, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_buscarArticuloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarArticuloKeyReleased

        String cadena = (txt_buscarArticulo.getText()).toUpperCase();
        txt_buscarArticulo.setText(cadena);

        if(rbtnCodigo.isSelected()) {
            filtrarPorCodArt(txt_buscarArticulo.getText());
            tablaArticulo();
        }
        if(rbtDescrip.isSelected()) {
            filtrarPorDetalleArt(txt_buscarArticulo.getText());
            tablaArticulo();
        }
        if(bto_FiltraRubro.isSelected()) {
            filtrarPorRubro(txt_buscarArticulo.getText());
           tablaArticulo();
        }
        if(bto_FiltraMarca.isSelected()) {
            filtrarPorMarca(txt_buscarArticulo.getText());
           tablaArticulo();
        }
        /* if(txt_buscarProvedores.getText().length()==0){
            Cargar("");

        }*/
    }//GEN-LAST:event_txt_buscarArticuloKeyReleased

    private void rbtnCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnCodigoActionPerformed

    }//GEN-LAST:event_rbtnCodigoActionPerformed

    private void rbtDescripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtDescripActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtDescripActionPerformed

    private void bto_FiltraRubroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_FiltraRubroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bto_FiltraRubroActionPerformed

    private void bto_FiltraMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_FiltraMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bto_FiltraMarcaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tablaArticulo();
    }//GEN-LAST:event_formWindowOpened

    private void grillaArticuloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grillaArticuloMouseClicked
         if(evt.getClickCount()==2)
        {
            int fila;
            DefaultTableModel defaultTableModel = new DefaultTableModel();
            fila = grillaArticulo.getSelectedRow();
            defaultTableModel = (DefaultTableModel)grillaArticulo.getModel();
            
           Formularios.Gestionar_Ventas.If_Factura.txt_idArticulo.setText((String)defaultTableModel.getValueAt(fila, 0));
            Formularios.Gestionar_Ventas.If_Factura.txtCodigP.setText((String)defaultTableModel.getValueAt(fila, 1));
            Formularios.Gestionar_Ventas.If_Factura.txt_nombrePro.setText((String)defaultTableModel.getValueAt(fila, 2));
            Formularios.Gestionar_Ventas.If_Factura.txt_Rubro.setText((String)defaultTableModel.getValueAt(fila, 3));
            Formularios.Gestionar_Ventas.If_Factura.txt_Precio.setText((String)defaultTableModel.getValueAt(fila, 8));
            
            Formularios.Gestionar_Ventas.If_Factura.txt_stockProd.setText((String)defaultTableModel.getValueAt(fila, 14));
//            Formularios.IF_FacturaVenta.txtCUIL.setText((String)defaultTableModel.getValueAt(fila, 5));
//            Formularios.IF_FacturaVenta.txtDomicilios.setText((String)defaultTableModel.getValueAt(fila, 6));
//            Formularios.IF_FacturaVenta.txtCiudad.setText((String)defaultTableModel.getValueAt(fila, 7));

            this.dispose();

            if (fila == -1){
                JOptionPane.showMessageDialog(null, "Se debe seleccionar un registro");
            }
        }
    }//GEN-LAST:event_grillaArticuloMouseClicked

    private void grillaArticuloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grillaArticuloMousePressed

        
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();

            int fila;
            DefaultTableModel defaultTableModel = new DefaultTableModel();
            fila = grillaArticulo.getSelectedRow();
            defaultTableModel = (DefaultTableModel)grillaArticulo.getModel();
            Formularios.Gestionar_Ventas.If_Factura.txt_idArticulo.setText((String)defaultTableModel.getValueAt(fila, 0));
            Formularios.Gestionar_Ventas.If_Factura.txtCodigP.setText((String)defaultTableModel.getValueAt(fila, 1));
            Formularios.Gestionar_Ventas.If_Factura.txt_nombrePro.setText((String)defaultTableModel.getValueAt(fila, 2));
            Formularios.Gestionar_Ventas.If_Factura.txt_Rubro.setText((String)defaultTableModel.getValueAt(fila, 3));
            Formularios.Gestionar_Ventas.If_Factura.txt_Precio.setText((String)defaultTableModel.getValueAt(fila, 8));
            
            Formularios.Gestionar_Ventas.If_Factura.txt_stockProd.setText((String)defaultTableModel.getValueAt(fila, 14));
            this.dispose();

        }
    }//GEN-LAST:event_grillaArticuloMousePressed

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
            java.util.logging.Logger.getLogger(JDlg_BuscarArticuloVta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlg_BuscarArticuloVta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlg_BuscarArticuloVta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlg_BuscarArticuloVta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlg_BuscarArticuloVta dialog = new JDlg_BuscarArticuloVta(new javax.swing.JFrame(), true);
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
    private javax.swing.JRadioButton bto_FiltraMarca;
    private javax.swing.JRadioButton bto_FiltraRubro;
    public static javax.swing.JTable grillaArticulo;
    private javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtDescrip;
    private javax.swing.JRadioButton rbtnCodigo;
    private javax.swing.JTextField txt_buscarArticulo;
    // End of variables declaration//GEN-END:variables
}
