/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestionar_compra;


import Formularios.Gestionar_Ventas.*;
import Componentes.conectar;
import Gestiona_articulo.JDlg_GestinarArticulos;
import Gestionar_Cientes.jDlg_CargarCliente;
import Gestionar_Proveedores.jDlg_CargarProveedor;
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
public class JDlg_BuscarProvCompra extends javax.swing.JDialog {

        DefaultTableModel model;
    /**
     * Creates new form JDlg_BuscarClienteVentas
     */
    public JDlg_BuscarProvCompra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
         grupo();
        Cargar(" ");
        tablaproveedor();
    }
    
    
    conectar cc= new conectar();
    Connection cn = cc.conexion();
    
     void grupo()
    {
        grupoBotones.add(rbtnDni);
        grupoBotones.add(rbtnApeliido);
        grupoBotones.add(rbtnRazonS);
        
    }
     void tablaproveedor(){
        // Genera espacion entre las columnas 
         grillaProveedor.getColumnModel().getColumn(0).setPreferredWidth(100);
         grillaProveedor.getColumnModel().getColumn(1).setPreferredWidth(200);
         grillaProveedor.getColumnModel().getColumn(2).setPreferredWidth(200);
         grillaProveedor.getColumnModel().getColumn(3).setPreferredWidth(100);
         grillaProveedor.getColumnModel().getColumn(4).setPreferredWidth(150);
         grillaProveedor.getColumnModel().getColumn(5).setPreferredWidth(150);
  
     } 
    
   
    
   void Cargar(String valor){
                
            String mostrar="SELECT * FROM  (persona JOIN proveedores ON(( persona.idPersona=proveedores.idPersona)))";   // escribo la consulta SQL   
                
            String titulos[]={"IdPersona","Nombre","apellido","razon Social","CUIT","Direccion"}; 
                
            String []Registros=new String[6];
  
                model = new DefaultTableModel(null,titulos);
  
        try {
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery(mostrar);
              while(rs.next())
              {
                  Registros[0]= rs.getString("idPersona");
                  Registros[1]= rs.getString("nombre");
                  Registros[2]= rs.getString("apellido");
                  Registros[3]= rs.getString("prov_razonSocial");
                  Registros[4]= rs.getString("prov_cuit");
                  Registros[5]= rs.getString("prov_direccion");
                
                  model.addRow(Registros);
              }
              grillaProveedor.setModel(model);

        } catch (SQLException ex) {
            Logger.getLogger(jDlg_CargarProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                 
  }
    
    
    
    void filtrarPorNombre(String valordeBusqueda){
                
            String mostrar="SELECT * FROM  (persona JOIN proveedores ON(( persona.idPersona=proveedores.idPersona)))"
                + " where nombre like '%" + valordeBusqueda + "%'  ";   // escribo la consulta SQL   
                
           String titulos[]={"IdPersona","Nombre","apellido","razon Social","CUIT","Direccion"}; 
                
            String []Registros=new String[6];
  
                model = new DefaultTableModel(null,titulos);
  
        try {
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery(mostrar);
              while(rs.next())
              {
                 
                  Registros[0]= rs.getString("idPersona");
                  Registros[1]= rs.getString("nombre");
                  Registros[2]= rs.getString("apellido");
                  Registros[3]= rs.getString("prov_razonSocial");
                  Registros[4]= rs.getString("prov_cuit");
                  Registros[5]= rs.getString("prov_direccion");
                
                  model.addRow(Registros);
              }
              grillaProveedor.setModel(model);
  
        } catch (SQLException ex) {
            Logger.getLogger(jDlg_CargarProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                 
  }
    
    void filtrarPorApellido(String valordeBusqueda){
                
            String mostrar="SELECT * FROM  (persona JOIN proveedores ON(( persona.idPersona=proveedores.idPersona)))"
                + " where apellido like '%" + valordeBusqueda + "%'  ";   // escribo la consulta SQL   
                
             String titulos[]={"IdPersona","Nombre","apellido","razon Social","CUIT","Direccion"}; 
                
            String []Registros=new String[6];
  
                model = new DefaultTableModel(null,titulos);
  
        try {
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery(mostrar);
              while(rs.next())
              {
                  
                  Registros[0]= rs.getString("idPersona");
                  Registros[1]= rs.getString("nombre");
                  Registros[2]= rs.getString("apellido");
                  Registros[3]= rs.getString("prov_razonSocial");
                  Registros[4]= rs.getString("prov_cuit");
                  Registros[5]= rs.getString("prov_direccion");
                  model.addRow(Registros);
              }
              grillaProveedor.setModel(model);
                
        } catch (SQLException ex) {
            Logger.getLogger(jDlg_CargarProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                 
  }
    
    
    void filtrarPorRazonS(String valordeBusqueda){
                
            String mostrar="SELECT * FROM  (persona JOIN proveedores ON(( persona.idPersona=proveedores.idPersona)))"
                + " where prov_razonSocial like '%" + valordeBusqueda + "%'  ";   // escribo la consulta SQL   
                
             String titulos[]={"IdPersona","Nombre","apellido","razon Social","CUIT","Direccion"}; 
                
            String []Registros=new String[6];
  
                model = new DefaultTableModel(null,titulos);
  
        try {
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery(mostrar);
              while(rs.next())
              {
                 
                  Registros[0]= rs.getString("idPersona");
                  Registros[1]= rs.getString("nombre");
                  Registros[2]= rs.getString("apellido");
                  Registros[3]= rs.getString("prov_razonSocial");
                  Registros[4]= rs.getString("prov_cuit");
                  Registros[5]= rs.getString("prov_direccion");
                
                  model.addRow(Registros);
              }
              grillaProveedor.setModel(model);
  
        } catch (SQLException ex) {
            Logger.getLogger(jDlg_CargarProveedor.class.getName()).log(Level.SEVERE, null, ex);
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
        txt_buscarProvedores = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        grillaProveedor = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        rbtnApeliido = new javax.swing.JRadioButton();
        rbtnDni = new javax.swing.JRadioButton();
        rbtnRazonS = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        txt_buscarProvedores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarProvedoresKeyReleased(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Proveedor:");

        grillaProveedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        grillaProveedor.setModel(new javax.swing.table.DefaultTableModel(
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
        grillaProveedor.setToolTipText("");
        grillaProveedor.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        grillaProveedor.setSelectionBackground(new java.awt.Color(255, 51, 51));
        grillaProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grillaProveedorMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                grillaProveedorMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(grillaProveedor);

        rbtnApeliido.setForeground(new java.awt.Color(255, 255, 255));
        rbtnApeliido.setText("Nombre");
        rbtnApeliido.setOpaque(false);
        rbtnApeliido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnApeliidoActionPerformed(evt);
            }
        });

        rbtnDni.setForeground(new java.awt.Color(255, 255, 255));
        rbtnDni.setText("DNI");
        rbtnDni.setOpaque(false);
        rbtnDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnDniActionPerformed(evt);
            }
        });

        rbtnRazonS.setForeground(new java.awt.Color(255, 255, 255));
        rbtnRazonS.setText("Razon Social");
        rbtnRazonS.setOpaque(false);
        rbtnRazonS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnRazonSActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_ABM/orig_60533_1.jpg"))); // NOI18N

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
                        .addComponent(txt_buscarProvedores, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(rbtnApeliido)
                        .addGap(27, 27, 27)
                        .addComponent(rbtnDni, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(rbtnRazonS, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbtnApeliido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rbtnDni, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rbtnRazonS))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txt_buscarProvedores, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void txt_buscarProvedoresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarProvedoresKeyReleased

        String cadena = (txt_buscarProvedores.getText()).toUpperCase();
        txt_buscarProvedores.setText(cadena);

        if(rbtnApeliido.isSelected()) {
            filtrarPorNombre(txt_buscarProvedores.getText());
            tablaproveedor();
        }
        if(rbtnDni.isSelected()) {
            filtrarPorApellido(txt_buscarProvedores.getText());
            tablaproveedor();
        }
        if(rbtnRazonS.isSelected()) {
            filtrarPorRazonS(txt_buscarProvedores.getText());
            tablaproveedor();
        }
        /* if(txt_buscarProvedores.getText().length()==0){
            Cargar("");

        }*/
    }//GEN-LAST:event_txt_buscarProvedoresKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void rbtnApeliidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnApeliidoActionPerformed

    }//GEN-LAST:event_rbtnApeliidoActionPerformed

    private void rbtnDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnDniActionPerformed

    private void rbtnRazonSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnRazonSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnRazonSActionPerformed

    private void grillaProveedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grillaProveedorMousePressed

//        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
//            evt.consume();
//
//            int fila;
//            DefaultTableModel defaultTableModel = new DefaultTableModel();
//            fila = grillaProveedor.getSelectedRow();
//            defaultTableModel = (DefaultTableModel)grillaProveedor.getModel();
//
//              Formularios.Gestionar_Ventas.If_Factura.Lb_IdCliente.setText((String)defaultTableModel.getValueAt(fila, 0));
//            Formularios.Gestionar_Ventas.If_Factura.txtRazonS.setText((String)defaultTableModel.getValueAt(fila, 1));
//            Formularios.Gestionar_Ventas.If_Factura.txt_nombre_cli.setText((String)defaultTableModel.getValueAt(fila, 2));
//            Formularios.Gestionar_Ventas.If_Factura.txt_apellido_cli.setText((String)defaultTableModel.getValueAt(fila, 3));
//            Formularios.Gestionar_Ventas.If_Factura.txtDni.setText((String)defaultTableModel.getValueAt(fila, 4));
//            Formularios.Gestionar_Ventas.If_Factura.txtCUIL.setText((String)defaultTableModel.getValueAt(fila, 5));
//            Formularios.Gestionar_Ventas.If_Factura.txtDomicilios.setText((String)defaultTableModel.getValueAt(fila, 6));
//            Formularios.Gestionar_Ventas.If_Factura.txtCodp.setText((String)defaultTableModel.getValueAt(fila, 7));
//            Formularios.Gestionar_Ventas.If_Factura.txtCiudad.setText((String)defaultTableModel.getValueAt(fila, 8));
//            Formularios.Gestionar_Ventas.If_Factura.txt_prov.setText((String)defaultTableModel.getValueAt(fila, 9));
//            Formularios.Gestionar_Ventas.If_Factura.txtcondIva.setText((String)defaultTableModel.getValueAt(fila, 10));
//
//            this.dispose();
//
//        }
    }//GEN-LAST:event_grillaProveedorMousePressed

    private void grillaProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grillaProveedorMouseClicked

         if(evt.getClickCount()==2)
        {
        int fila;
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        fila = grillaProveedor.getSelectedRow();

        if (fila == -1){
            JOptionPane.showMessageDialog(null, "Se debe seleccionar un registro");
        }else{
            defaultTableModel = (DefaultTableModel)grillaProveedor.getModel();

         
            Gestionar_compra.iF_CargaCompra.txtCodProv.setText((String) defaultTableModel.getValueAt(fila, 0));
            Gestionar_compra.iF_CargaCompra.txtRazonSocial.setText((String) defaultTableModel.getValueAt(fila, 2));
            Gestionar_compra.iF_CargaCompra.txtDirec.setText((String) defaultTableModel.getValueAt(fila, 5));
            Gestionar_compra.iF_CargaCompra.txtcuit.setText((String) defaultTableModel.getValueAt(fila, 4));
       
            this.dispose();
        }}
    }//GEN-LAST:event_grillaProveedorMouseClicked

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
            java.util.logging.Logger.getLogger(JDlg_BuscarProvCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlg_BuscarProvCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlg_BuscarProvCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlg_BuscarProvCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlg_BuscarProvCompra dialog = new JDlg_BuscarProvCompra(new javax.swing.JFrame(), true);
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
    public static javax.swing.JTable grillaProveedor;
    private javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtnApeliido;
    private javax.swing.JRadioButton rbtnDni;
    private javax.swing.JRadioButton rbtnRazonS;
    private javax.swing.JTextField txt_buscarProvedores;
    // End of variables declaration//GEN-END:variables
}
