/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios.Gestionar_Ventas;

import Componentes.conectar;
import Gestiona_articulo.JDlg_GestinarArticulos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gaston
 */
public class JDlg_BuscarArticuloVentas extends javax.swing.JDialog {
    
     DefaultTableModel model;
    /**
     * Creates new form JDlg_BuscarArticuloVentas
     */
    public JDlg_BuscarArticuloVentas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Cargar("");
        tablaArticulo();
        grupo();
        this.setLocationRelativeTo(null);
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
         grillaArticulo.getColumnModel().getColumn(0).setPreferredWidth(120);
         grillaArticulo.getColumnModel().getColumn(1).setPreferredWidth(400);
         grillaArticulo.getColumnModel().getColumn(2).setPreferredWidth(400);
         grillaArticulo.getColumnModel().getColumn(3).setPreferredWidth(300);
         grillaArticulo.getColumnModel().getColumn(4).setPreferredWidth(400);
         grillaArticulo.getColumnModel().getColumn(5).setPreferredWidth(400);
         grillaArticulo.getColumnModel().getColumn(6).setPreferredWidth(350);
         grillaArticulo.getColumnModel().getColumn(7).setPreferredWidth(350);
         grillaArticulo.getColumnModel().getColumn(8).setPreferredWidth(400);
         grillaArticulo.getColumnModel().getColumn(9).setPreferredWidth(400);
         grillaArticulo.getColumnModel().getColumn(10).setPreferredWidth(350);
         grillaArticulo.getColumnModel().getColumn(11).setPreferredWidth(400);
         grillaArticulo.getColumnModel().getColumn(12).setPreferredWidth(300);
         grillaArticulo.getColumnModel().getColumn(13).setPreferredWidth(350); 
         grillaArticulo.getColumnModel().getColumn(14).setPreferredWidth(300);
                 
        
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

        grupoBotones = new javax.swing.ButtonGroup();
        txt_buscarArticulo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        grillaArticulo = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        rbtnCodigo = new javax.swing.JRadioButton();
        rbtDescrip = new javax.swing.JRadioButton();
        bto_FiltraRubro = new javax.swing.JRadioButton();
        bto_FiltraMarca = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txt_buscarArticulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarArticuloKeyReleased(evt);
            }
        });

        jLabel5.setText("Articulo:");

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
        grillaArticulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grillaArticuloMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                grillaArticuloMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(grillaArticulo);

        rbtnCodigo.setText("Codigo Producto");
        rbtnCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnCodigoActionPerformed(evt);
            }
        });

        rbtDescrip.setText("Descripcion Producto");
        rbtDescrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtDescripActionPerformed(evt);
            }
        });

        bto_FiltraRubro.setText("Rubro");
        bto_FiltraRubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_FiltraRubroActionPerformed(evt);
            }
        });

        bto_FiltraMarca.setText("Marca");
        bto_FiltraMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_FiltraMarcaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(rbtnCodigo)
                .addGap(13, 13, 13)
                .addComponent(rbtDescrip)
                .addGap(10, 10, 10)
                .addComponent(bto_FiltraRubro, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bto_FiltraMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtDescrip, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bto_FiltraRubro)
                    .addComponent(bto_FiltraMarca)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1174, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(txt_buscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_buscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
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

    private void grillaArticuloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grillaArticuloMouseClicked

        if(evt.getClickCount()==2)
        {
            int fila;
            DefaultTableModel defaultTableModel = new DefaultTableModel();
            fila = grillaArticulo.getSelectedRow();
            defaultTableModel = (DefaultTableModel)grillaArticulo.getModel();
            
            Formularios.Gestionar_Ventas.IF_FacturaVenta.txt_idArticulo.setText((String)defaultTableModel.getValueAt(fila, 0));
            Formularios.Gestionar_Ventas.IF_FacturaVenta.txtCodigP.setText((String)defaultTableModel.getValueAt(fila, 1));
            Formularios.Gestionar_Ventas.IF_FacturaVenta.txt_nombrePro.setText((String)defaultTableModel.getValueAt(fila, 2));
            Formularios.Gestionar_Ventas.IF_FacturaVenta.txt_Rubro.setText((String)defaultTableModel.getValueAt(fila, 3));
            Formularios.Gestionar_Ventas.IF_FacturaVenta.txt_Precio.setText((String)defaultTableModel.getValueAt(fila, 8));
            
            Formularios.Gestionar_Ventas.IF_FacturaVenta.txt_stockProd.setText((String)defaultTableModel.getValueAt(fila, 14));
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
        /*if(evt.getClickCount()==2)
        {
            Point p = evt.getPoint();
            int number = grillaCliente.rowAtPoint(p);
            ListSelectionModel modelos = grillaCliente.getSelectionModel();
            modelos.setSelectionInterval(number, number);
        }*/

        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();

            int fila;
            DefaultTableModel defaultTableModel = new DefaultTableModel();
            fila = grillaArticulo.getSelectedRow();
            defaultTableModel = (DefaultTableModel)grillaArticulo.getModel();
            Formularios.Gestionar_Ventas.IF_FacturaVenta.txt_idArticulo.setText((String)defaultTableModel.getValueAt(fila, 0));
            Formularios.Gestionar_Ventas.IF_FacturaVenta.txtCodigP.setText((String)defaultTableModel.getValueAt(fila, 1));
            Formularios.Gestionar_Ventas.IF_FacturaVenta.txt_nombrePro.setText((String)defaultTableModel.getValueAt(fila, 2));
            Formularios.Gestionar_Ventas.IF_FacturaVenta.txt_Rubro.setText((String)defaultTableModel.getValueAt(fila, 3));
            Formularios.Gestionar_Ventas.IF_FacturaVenta.txt_Precio.setText((String)defaultTableModel.getValueAt(fila, 8));
            
            Formularios.Gestionar_Ventas.IF_FacturaVenta.txt_stockProd.setText((String)defaultTableModel.getValueAt(fila, 14));
            this.dispose();

        }
    }//GEN-LAST:event_grillaArticuloMousePressed

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
            java.util.logging.Logger.getLogger(JDlg_BuscarArticuloVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlg_BuscarArticuloVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlg_BuscarArticuloVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlg_BuscarArticuloVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlg_BuscarArticuloVentas dialog = new JDlg_BuscarArticuloVentas(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable grillaArticulo;
    private javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbtDescrip;
    private javax.swing.JRadioButton rbtnCodigo;
    private javax.swing.JTextField txt_buscarArticulo;
    // End of variables declaration//GEN-END:variables
}
