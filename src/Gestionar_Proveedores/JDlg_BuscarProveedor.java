/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestionar_Proveedores;

import Componentes.conectar;
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
public class JDlg_BuscarProveedor extends javax.swing.JDialog {
    DefaultTableModel model;
    /**
     * Creates new form JDlg_BuscarProveedor
     */
    public JDlg_BuscarProveedor(java.awt.Frame parent, boolean modal) {
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
        grupoBotones.add(rbtnNombre);
        grupoBotones.add(rbtnApeliido);
        grupoBotones.add(rbtnRazonS);
        
    }
     void tablaproveedor(){
        // Genera espacion entre las columnas 
         grillaProveedor.getColumnModel().getColumn(0).setPreferredWidth(50);
         grillaProveedor.getColumnModel().getColumn(1).setPreferredWidth(200);
         grillaProveedor.getColumnModel().getColumn(2).setPreferredWidth(100);
         grillaProveedor.getColumnModel().getColumn(3).setPreferredWidth(80);
         grillaProveedor.getColumnModel().getColumn(4).setPreferredWidth(120);
  
     } 
    
   
    
   void Cargar(String valor){
                
            String mostrar="SELECT * FROM  (persona JOIN proveedores ON(( persona.idPersona=proveedores.idPersona)))";   // escribo la consulta SQL   
                
            String titulos[]={"IdPersona","Nombre","apellido","razon Social","CUIT"}; 
                
            String []Registros=new String[5];
  
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
                
            String titulos[]={"IdPersona","Nombre","apellido","razon Social","CUIT"}; 
                
            String []Registros=new String[5];
  
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
                
            String titulos[]={"IdPersona","Nombre","apellido","razon Social","CUIT"};  
                
            String []Registros=new String[5];
  
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
                
            String titulos[]={"IdPersona","Nombre","apellido","razon Social","CUIT"}; 
                
            String []Registros=new String[5];
  
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
        txt_buscarProvedores = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        grillaProveedor = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        rbtnNombre = new javax.swing.JRadioButton();
        rbtnApeliido = new javax.swing.JRadioButton();
        rbtnRazonS = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txt_buscarProvedores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarProvedoresKeyReleased(evt);
            }
        });

        jLabel5.setText("Proveedor:");

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
        grillaProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grillaProveedorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(grillaProveedor);

        rbtnNombre.setText("Nombre");
        rbtnNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnNombreActionPerformed(evt);
            }
        });

        rbtnApeliido.setText("Apellido");
        rbtnApeliido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnApeliidoActionPerformed(evt);
            }
        });

        rbtnRazonS.setText("Razon Social");
        rbtnRazonS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnRazonSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(rbtnNombre)
                .addGap(18, 18, 18)
                .addComponent(rbtnApeliido, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnRazonS)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnApeliido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnRazonS)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(txt_buscarProvedores, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_buscarProvedores, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(88, 88, 88)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_buscarProvedoresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarProvedoresKeyReleased

        String cadena = (txt_buscarProvedores.getText()).toUpperCase();
        txt_buscarProvedores.setText(cadena);

        if(rbtnNombre.isSelected()) {
            filtrarPorNombre(txt_buscarProvedores.getText());
            tablaproveedor();
        }
        if(rbtnApeliido.isSelected()) {
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

    private void rbtnNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnNombreActionPerformed

    }//GEN-LAST:event_rbtnNombreActionPerformed

    private void rbtnApeliidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnApeliidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnApeliidoActionPerformed

    private void rbtnRazonSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnRazonSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnRazonSActionPerformed

    private void grillaProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grillaProveedorMouseClicked
       
//             if(evt.getClickCount()==2)
//        {
//        int fila;
//        DefaultTableModel defaultTableModel = new DefaultTableModel();
//        fila = grillaProveedor.getSelectedRow();
//
//        if (fila == -1){
//            JOptionPane.showMessageDialog(null, "Se debe seleccionar un registro");
//        }else{
//            defaultTableModel = (DefaultTableModel)grillaProveedor.getModel();
//            jDlg_CargarProveedor miProv = new jDlg_CargarProveedor(this, rootPaneCheckingEnabled);
//           
//            
//            
//            
//            this.dispose();
//        }
//        }
        
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
            java.util.logging.Logger.getLogger(JDlg_BuscarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlg_BuscarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlg_BuscarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlg_BuscarProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlg_BuscarProveedor dialog = new JDlg_BuscarProveedor(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable grillaProveedor;
    private javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbtnApeliido;
    private javax.swing.JRadioButton rbtnNombre;
    private javax.swing.JRadioButton rbtnRazonS;
    private javax.swing.JTextField txt_buscarProvedores;
    // End of variables declaration//GEN-END:variables
}
