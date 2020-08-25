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
public class JDlg_BuscarClientesVta extends javax.swing.JDialog {

        DefaultTableModel model;
    /**
     * Creates new form JDlg_BuscarClienteVentas
     */
    public JDlg_BuscarClientesVta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
         Cargar("");
        tablaClientes();
        grupo();
    }
    
   conectar cc= new conectar();
    Connection cn = cc.conexion();
    
     void grupo()
    {
        grupoBotones.add(rbtnNombre);
        grupoBotones.add(rbtnDni);
        grupoBotones.add(rbtnRazonS);
        
    }
     void tablaClientes(){
        // Genera espacion entre las columnas 
         grillaCliente.getColumnModel().getColumn(0).setPreferredWidth(50);
         grillaCliente.getColumnModel().getColumn(1).setPreferredWidth(200);
         grillaCliente.getColumnModel().getColumn(2).setPreferredWidth(120);
         grillaCliente.getColumnModel().getColumn(3).setPreferredWidth(120);
         grillaCliente.getColumnModel().getColumn(4).setPreferredWidth(120);
         grillaCliente.getColumnModel().getColumn(5).setPreferredWidth(120);
         grillaCliente.getColumnModel().getColumn(6).setPreferredWidth(170);
         grillaCliente.getColumnModel().getColumn(7).setPreferredWidth(170);
         grillaCliente.getColumnModel().getColumn(8).setPreferredWidth(170);
         grillaCliente.getColumnModel().getColumn(9).setPreferredWidth(170);
         grillaCliente.getColumnModel().getColumn(10).setPreferredWidth(170);
         
     } 
    
   
    
   void Cargar(String valor){
                
            String mostrar="SELECT * FROM  (persona JOIN clientes ON(( persona.idPersona=clientes.idPersona)))"
                    + "JOIN ciudades ON ((clientes.cli_ciudad = ciudades.idciudad)) "
                    + "JOIN provincias ON ((clientes.cli_provincia = provincias.idprovincia))"
                    + "JOIN cond_iva ON ((clientes.cli_condiva = cond_iva.idcond))";
                  // escribo la consulta SQL   
                
            String titulos[]={"Id","razon Social","Nombre","apellido","DNI","CUIT","Domicilio","Cod Postal","Ciudad","Provincia","cond IVA"}; 
                
            String []Registros=new String[11];
  
                model = new DefaultTableModel(null,titulos);
  
        try {
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery(mostrar);
              while(rs.next())
              {
                  Registros[0]= rs.getString("idPersona");
                  Registros[1]= rs.getString("cli_razonsocial");
                  Registros[2]= rs.getString("nombre");
                  Registros[3]= rs.getString("apellido");
                  Registros[4]= rs.getString("dni");
                  Registros[5]= rs.getString("cli_cuit");
                  Registros[6]= rs.getString("cli_direccion");
                  Registros[7]= rs.getString("cli_codpostal");
                  Registros[8]= rs.getString("ciudades.descciudad");
                  Registros[9]= rs.getString("provincias.descprovincia");
                  Registros[10]= rs.getString("cond_iva.desccond");
                  
                  
                
                  model.addRow(Registros);
              }
              grillaCliente.setModel(model);

        } catch (SQLException ex) {
            Logger.getLogger(jDlg_CargarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                 
  }
    
    
    
    void filtrarPorNombre(String valordeBusqueda){
                
            String mostrar="SELECT * FROM  (persona JOIN clientes ON(( persona.idPersona=clientes.idPersona)))"
                     + "JOIN ciudades ON ((clientes.cli_ciudad = ciudades.idciudad)) "
                    + "JOIN provincias ON ((clientes.cli_provincia = provincias.idprovincia))"
                    + "JOIN cond_iva ON ((clientes.cli_condiva = cond_iva.idcond))"
                + " where nombre like '%" + valordeBusqueda + "%'  ";   // escribo la consulta SQL   
                
             String titulos[]={"Id","razon Social","Nombre","apellido","DNI","CUIT","Domicilio","Cod Postal","Ciudad","Provincia","cond IVA"}; 
                
            String []Registros=new String[11];
  
                model = new DefaultTableModel(null,titulos);
  
        try {
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery(mostrar);
              while(rs.next())
              {
                  Registros[0]= rs.getString("idPersona");
                  Registros[1]= rs.getString("cli_razonsocial");
                  Registros[2]= rs.getString("nombre");
                  Registros[3]= rs.getString("apellido");
                  Registros[4]= rs.getString("dni");
                  Registros[5]= rs.getString("cli_cuit");
                  Registros[6]= rs.getString("cli_direccion");
                  Registros[7]= rs.getString("cli_codpostal");
                  Registros[8]= rs.getString("ciudades.descciudad");
                  Registros[9]= rs.getString("provincias.descprovincia");
                  Registros[10]= rs.getString("cond_iva.desccond");
                  
                  
                
                  model.addRow(Registros);
              }
              grillaCliente.setModel(model);

        } catch (SQLException ex) {
            Logger.getLogger(jDlg_CargarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                 
  }
    
    void filtrarPorDNI(String valordeBusqueda){
                
            String mostrar="SELECT * FROM  (persona JOIN clientes ON(( persona.idPersona=clientes.idPersona)))"
                      + "JOIN ciudades ON ((clientes.cli_ciudad = ciudades.idciudad)) "
                    + "JOIN provincias ON ((clientes.cli_provincia = provincias.idprovincia))"
                    + "JOIN cond_iva ON ((clientes.cli_condiva = cond_iva.idcond))"
                + " where dni like '%" + valordeBusqueda + "%'  ";   // escribo la consulta SQL   
                
           String titulos[]={"Id","razon Social","Nombre","apellido","DNI","CUIT","Domicilio","Cod Postal","Ciudad","Provincia","cond IVA"}; 
                
            String []Registros=new String[11];
  
                model = new DefaultTableModel(null,titulos);
  
        try {
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery(mostrar);
              while(rs.next())
              {
                  Registros[0]= rs.getString("idPersona");
                  Registros[1]= rs.getString("cli_razonsocial");
                  Registros[2]= rs.getString("nombre");
                  Registros[3]= rs.getString("apellido");
                  Registros[4]= rs.getString("dni");
                  Registros[5]= rs.getString("cli_cuit");
                  Registros[6]= rs.getString("cli_direccion");
                  Registros[7]= rs.getString("cli_codpostal");
                  Registros[8]= rs.getString("ciudades.descciudad");
                  Registros[9]= rs.getString("provincias.descprovincia");
                  Registros[10]= rs.getString("cond_iva.desccond");
                  
                  
                
                  model.addRow(Registros);
              }
              grillaCliente.setModel(model);

        } catch (SQLException ex) {
            Logger.getLogger(jDlg_CargarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                 
  }
    
    
    void filtrarPorRazonS(String valordeBusqueda){
                
            String mostrar="SELECT * FROM  (persona JOIN clientes ON(( persona.idPersona=clientes.idPersona)))"
                      + "JOIN ciudades ON ((clientes.cli_ciudad = ciudades.idciudad)) "
                    + "JOIN provincias ON ((clientes.cli_provincia = provincias.idprovincia))"
                    + "JOIN cond_iva ON ((clientes.cli_condiva = cond_iva.idcond))"
                + " where cli_razonsocial like '%" + valordeBusqueda + "%'  ";  // escribo la consulta SQL   
                
            String titulos[]={"Id","razon Social","Nombre","apellido","DNI","CUIT","Domicilio","Cod Postal","Ciudad","Provincia","cond IVA"}; 
                
            String []Registros=new String[11];
  
                model = new DefaultTableModel(null,titulos);
  
        try {
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery(mostrar);
              while(rs.next())
              {
                  Registros[0]= rs.getString("idPersona");
                  Registros[1]= rs.getString("cli_razonsocial");
                  Registros[2]= rs.getString("nombre");
                  Registros[3]= rs.getString("apellido");
                  Registros[4]= rs.getString("dni");
                  Registros[5]= rs.getString("cli_cuit");
                  Registros[6]= rs.getString("cli_direccion");
                  Registros[7]= rs.getString("cli_codpostal");
                  Registros[8]= rs.getString("ciudades.descciudad");
                  Registros[9]= rs.getString("provincias.descprovincia");
                  Registros[10]= rs.getString("cond_iva.desccond");
                  
                  
                
                  model.addRow(Registros);
              }
              grillaCliente.setModel(model);

        } catch (SQLException ex) {
            Logger.getLogger(jDlg_CargarCliente.class.getName()).log(Level.SEVERE, null, ex);
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
        txt_buscarCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        grillaCliente = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        rbtnNombre = new javax.swing.JRadioButton();
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

        txt_buscarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarClienteKeyReleased(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cliente:");

        grillaCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        grillaCliente.setModel(new javax.swing.table.DefaultTableModel(
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
        grillaCliente.setToolTipText("");
        grillaCliente.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        grillaCliente.setSelectionBackground(new java.awt.Color(255, 51, 51));
        grillaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grillaClienteMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                grillaClienteMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(grillaCliente);

        rbtnNombre.setForeground(new java.awt.Color(255, 255, 255));
        rbtnNombre.setText("Nombre");
        rbtnNombre.setOpaque(false);
        rbtnNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnNombreActionPerformed(evt);
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
                        .addComponent(txt_buscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(rbtnNombre)
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
                        .addComponent(rbtnNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rbtnDni, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rbtnRazonS))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txt_buscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void txt_buscarClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarClienteKeyReleased

       String cadena = (txt_buscarCliente.getText()).toUpperCase();
        txt_buscarCliente.setText(cadena);

        if(rbtnNombre.isSelected()) {
            filtrarPorNombre(txt_buscarCliente.getText());
            tablaClientes();
        }
        if(rbtnDni.isSelected()) {
            filtrarPorDNI(txt_buscarCliente.getText());
            tablaClientes();
        }
        if(rbtnRazonS.isSelected()) {
            filtrarPorRazonS(txt_buscarCliente.getText());
            tablaClientes();
        }
        /* if(txt_buscarProvedores.getText().length()==0){
            Cargar("");

        }*/
    }//GEN-LAST:event_txt_buscarClienteKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tablaClientes();
    }//GEN-LAST:event_formWindowOpened

    private void rbtnNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnNombreActionPerformed

    }//GEN-LAST:event_rbtnNombreActionPerformed

    private void rbtnDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnDniActionPerformed

    private void rbtnRazonSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnRazonSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnRazonSActionPerformed

    private void grillaClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grillaClienteMousePressed

        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();

            int fila;
            DefaultTableModel defaultTableModel = new DefaultTableModel();
            fila = grillaCliente.getSelectedRow();
            defaultTableModel = (DefaultTableModel)grillaCliente.getModel();

              Formularios.Gestionar_Ventas.If_Factura.Lb_IdCliente.setText((String)defaultTableModel.getValueAt(fila, 0));
            Formularios.Gestionar_Ventas.If_Factura.txtRazonS.setText((String)defaultTableModel.getValueAt(fila, 1));
            Formularios.Gestionar_Ventas.If_Factura.txt_nombre_cli.setText((String)defaultTableModel.getValueAt(fila, 2));
            Formularios.Gestionar_Ventas.If_Factura.txt_apellido_cli.setText((String)defaultTableModel.getValueAt(fila, 3));
            Formularios.Gestionar_Ventas.If_Factura.txtDni.setText((String)defaultTableModel.getValueAt(fila, 4));
            Formularios.Gestionar_Ventas.If_Factura.txtCUIL.setText((String)defaultTableModel.getValueAt(fila, 5));
            Formularios.Gestionar_Ventas.If_Factura.txtDomicilios.setText((String)defaultTableModel.getValueAt(fila, 6));
            Formularios.Gestionar_Ventas.If_Factura.txtCodp.setText((String)defaultTableModel.getValueAt(fila, 7));
            Formularios.Gestionar_Ventas.If_Factura.txtCiudad.setText((String)defaultTableModel.getValueAt(fila, 8));
            Formularios.Gestionar_Ventas.If_Factura.txt_prov.setText((String)defaultTableModel.getValueAt(fila, 9));
            Formularios.Gestionar_Ventas.If_Factura.txtcondIva.setText((String)defaultTableModel.getValueAt(fila, 10));

            this.dispose();

        }
    }//GEN-LAST:event_grillaClienteMousePressed

    private void grillaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grillaClienteMouseClicked

       if(evt.getClickCount()==2)
        {
            int fila;
            DefaultTableModel defaultTableModel = new DefaultTableModel();
            fila = grillaCliente.getSelectedRow();
            defaultTableModel = (DefaultTableModel)grillaCliente.getModel();

            Formularios.Gestionar_Ventas.If_Factura.Lb_IdCliente.setText((String)defaultTableModel.getValueAt(fila, 0));
            Formularios.Gestionar_Ventas.If_Factura.txtRazonS.setText((String)defaultTableModel.getValueAt(fila, 1));
            Formularios.Gestionar_Ventas.If_Factura.txt_nombre_cli.setText((String)defaultTableModel.getValueAt(fila, 2));
            Formularios.Gestionar_Ventas.If_Factura.txt_apellido_cli.setText((String)defaultTableModel.getValueAt(fila, 3));
            Formularios.Gestionar_Ventas.If_Factura.txtDni.setText((String)defaultTableModel.getValueAt(fila, 4));
            Formularios.Gestionar_Ventas.If_Factura.txtCUIL.setText((String)defaultTableModel.getValueAt(fila, 5));
            Formularios.Gestionar_Ventas.If_Factura.txtDomicilios.setText((String)defaultTableModel.getValueAt(fila, 6));
            Formularios.Gestionar_Ventas.If_Factura.txtCodp.setText((String)defaultTableModel.getValueAt(fila, 7));
            Formularios.Gestionar_Ventas.If_Factura.txtCiudad.setText((String)defaultTableModel.getValueAt(fila, 8));
            Formularios.Gestionar_Ventas.If_Factura.txt_prov.setText((String)defaultTableModel.getValueAt(fila, 9));
            Formularios.Gestionar_Ventas.If_Factura.txtcondIva.setText((String)defaultTableModel.getValueAt(fila, 10));

            this.dispose();

            if (fila == -1){
                JOptionPane.showMessageDialog(null, "Se debe seleccionar un registro");
            }
        }
    }//GEN-LAST:event_grillaClienteMouseClicked

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
            java.util.logging.Logger.getLogger(JDlg_BuscarClientesVta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlg_BuscarClientesVta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlg_BuscarClientesVta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlg_BuscarClientesVta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlg_BuscarClientesVta dialog = new JDlg_BuscarClientesVta(new javax.swing.JFrame(), true);
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
    public static javax.swing.JTable grillaCliente;
    private javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtnDni;
    private javax.swing.JRadioButton rbtnNombre;
    private javax.swing.JRadioButton rbtnRazonS;
    private javax.swing.JTextField txt_buscarCliente;
    // End of variables declaration//GEN-END:variables
}
