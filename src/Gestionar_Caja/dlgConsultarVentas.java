/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestionar_Caja;

import Componentes.Mensajes; 
import Componentes.conectar;
import Gestiona_articulo.iFDescripcionArticulos;

import static Gestionar_Caja.dlgConsultarVentasCaja.grillaVentas;
import Metodos.gestionarVenta;
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
        cargar("");
        tablaventa();
        titulosdetVen();
        this.setSize(730, 550);
    }
    void limpiarTabla(){
        try{    
            txtCliente.setText("");
            txtCodVenta.setText("");
            txtFechaVenta.setText("");
            txtTotalVenta.setText("");
	int filas=grillaDetVentas.getRowCount();
            for (int i = 0;filas>i; i++) {
                model.removeRow(0);
                tablaventa();
                tablaDetalleVenta();
               cargar("");
            }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }
   void tablaventa(){
        // Genera espacion entre las columnas 
         grillaVentas.getColumnModel().getColumn(0).setPreferredWidth(60);
         grillaVentas.getColumnModel().getColumn(1).setPreferredWidth(100);
         grillaVentas.getColumnModel().getColumn(2).setPreferredWidth(150);
         grillaVentas.getColumnModel().getColumn(3).setPreferredWidth(230);
         grillaVentas.getColumnModel().getColumn(4).setPreferredWidth(75);
         grillaVentas.getColumnModel().getColumn(5).setPreferredWidth(100);
          grillaVentas.getColumnModel().getColumn(6).setPreferredWidth(100);
     }
     
          void tablaDetalleVenta(){
        // Genera espacion entre las columnas 
         grillaDetVentas.getColumnModel().getColumn(0).setPreferredWidth(60);
         grillaDetVentas.getColumnModel().getColumn(1).setPreferredWidth(60);
         grillaDetVentas.getColumnModel().getColumn(2).setPreferredWidth(320);
         grillaDetVentas.getColumnModel().getColumn(3).setPreferredWidth(60);
         grillaDetVentas.getColumnModel().getColumn(4).setPreferredWidth(100);
     }
    
    void cargar(String valor){
    String mostrar="Select * FROM (venta JOIN clientes ON ((venta.IdCliente = clientes.cli_codigo)) JOIN empleado ON ((venta.IdEmpleado = empleado.IdEmpleado))) ORDER BY(venta.IdVenta)";
    String titulos[] = {"Nro","Fecha","Cliente","Empleado","Cod Cliente","Total"};
    String []Registros=new String[6];
    model = new DefaultTableModel(null,titulos);
  
        try {
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery(mostrar);
              while(rs.next())
              {
                  Registros[0]= rs.getString("IdVenta");
                  Registros[1]= rs.getString("Fecha");
                  Registros[2]= rs.getString("clientes.cli_razonsocial");
                  Registros[3]= rs.getString("empleado.Nombre");
                  Registros[4]= rs.getString("IdCliente");
                  Registros[5]= rs.getString("TotalPagar");
                       model.addRow(Registros);
              }
              grillaVentas.setModel(model);
              
        } catch (SQLException ex) {
            Logger.getLogger(iFDescripcionArticulos.class.getName()).log(Level.SEVERE, null, ex);
        }
    
  }  
     
     void titulosdetVen (){
         String titulosdet[] =  {"Cantidad","Cód.","Descripción","Precio","Total"};
         model = new DefaultTableModel(null,titulosdet);
         grillaDetVentas.setModel(model);
     }
    void cargarDetalleVenta(String valor){
    String mos="Select * FROM (detalleventa JOIN articulo ON ((detalleventa.IdProducto = articulo.art_codigo)))  "
            + " JOIN venta ON ((detalleventa.IdVenta = venta.IdVenta))  WHERE (venta.IdVenta) like '%"+valor+"%'";
    String titulosdet[] =  {"Cantidad","Cód.","Descripción","Precio","Total"};
    String []Registros=new String[20];
    model = new DefaultTableModel(null,titulosdet);
  
        try {
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery(mos);
              while(rs.next())
              {
                  Registros[0]= rs.getString("detalleventa.Cantidad");
                  Registros[1]= rs.getString("articulo.art_codigo");
                  Registros[2]= rs.getString("articulo.art_descripcion");
                  Registros[3]= rs.getString("detalleventa.Precio");                  
                  Registros[4]= rs.getString("detalleventa.Total");
                 
               
                  model.addRow(Registros);
              }
              grillaDetVentas.setModel(model);

        } catch (SQLException ex) {
            Logger.getLogger(dlgConSalida.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        grillaVentas = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        jPanel1 = new javax.swing.JPanel();
        grillaDetVentas = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        jLabel1 = new javax.swing.JLabel();
        txtCodVenta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFechaVenta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel6 = new javax.swing.JLabel();
        txtTotalVenta = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        dcFechaini = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        dcFechafin = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblIdVenta = new javax.swing.JLabel();
        Salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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
        grillaDetVentas.setSelectionBackground(new java.awt.Color(255, 51, 51));

        jLabel1.setText("Factura de Venta");

        txtCodVenta.setEditable(false);
        txtCodVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodVentaActionPerformed(evt);
            }
        });

        jLabel2.setText("Fecha :");

        txtFechaVenta.setEditable(false);

        jLabel3.setText("Cliente");

        txtCliente.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("TOTAL :");

        txtTotalVenta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTotalVenta.setText("S/.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(grillaDetVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(grillaDetVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones de busqueda"));
        jPanel2.setLayout(null);

        dcFechaini.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel2.add(dcFechaini);
        dcFechaini.setBounds(20, 40, 170, 25);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("DESDE:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(20, 20, 70, 20);

        dcFechafin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel2.add(dcFechafin);
        dcFechafin.setBounds(230, 40, 160, 25);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("HASTA:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(230, 20, 70, 20);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(450, 20, 110, 50);
        jPanel2.add(lblIdVenta);
        lblIdVenta.setBounds(320, 20, 40, 20);

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        jPanel2.add(Salir);
        Salir.setBounds(590, 20, 110, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void grillaVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grillaVentasMouseClicked

        int fila= grillaVentas.getSelectedRow();
        try {
            if(fila>=0){
                String numero = grillaVentas.getValueAt(fila, 0).toString();
                String fecha = grillaVentas.getValueAt(fila, 1).toString();
                String cli = grillaVentas.getValueAt(fila, 2).toString();
                String total = grillaVentas.getValueAt(fila, 5).toString();
                txtFechaVenta.setText(fecha);
                txtCodVenta.setText(numero);
                txtCliente.setText(cli);
                txtTotalVenta.setText(total);

                cargarDetalleVenta(numero);
                tablaDetalleVenta();
            }

        }
        catch (Exception e) {

        }

    }//GEN-LAST:event_grillaVentasMouseClicked

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_SalirActionPerformed

    private void txtCodVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodVentaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        BuscarVenta();
        tablaventa();
        txtCliente.setText("");
        txtCodVenta.setText("");
        txtFechaVenta.setText("");
        txtTotalVenta.setText("");
        
    }//GEN-LAST:event_jButton1ActionPerformed
void BuscarVenta(){
        String titulos[] = {"Nro","Fecha","Cliente","Empleado","Estado","Total"};
        model.setColumnIdentifiers(titulos);
        
        gestionarVenta venta=new gestionarVenta();

        fecha_ini=dcFechaini.getDate();
        fecha_fin=dcFechafin.getDate();
            try{
            rs=venta.listarVentaPorFecha("anular",fecha_ini,fecha_fin);
            boolean encuentra=false;
            String Datos[]=new String[9];
            int f,i;
            f=model.getRowCount();
            if(f>0){
                for(i=0;i<f;i++){
                    model.removeRow(0);
                }
            }
            while(rs.next()){
                Datos[0]=(String) rs.getString(1);
                Datos[1]=(String) rs.getString(2);
                Datos[2]=(String) rs.getString(3);
                Datos[3]=(String) rs.getString(4);
                Datos[4]=(String) rs.getString(5);
                Datos[5]=(String) rs.getString(6);
                model.addRow(Datos);
                encuentra=true;

            }
            if(encuentra=false){
                JOptionPane.showMessageDialog(null, "¡No se encuentra!");
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
        grillaVentas.setModel(model);
        
    }
  
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
    private javax.swing.JButton Salir;
    private com.toedter.calendar.JDateChooser dcFechafin;
    private com.toedter.calendar.JDateChooser dcFechaini;
    public static javax.swing.JTable grillaDetVentas;
    public static javax.swing.JTable grillaVentas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblIdVenta;
    public static javax.swing.JTextField txtCliente;
    public static javax.swing.JTextField txtCodVenta;
    public static javax.swing.JTextField txtFechaVenta;
    public static javax.swing.JTextField txtTotalVenta;
    // End of variables declaration//GEN-END:variables
}
