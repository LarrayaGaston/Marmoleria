/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestionar_Stock;

import Componentes.Mensajes; 
import Componentes.conectar;
import java.awt.Frame; 
import java.awt.event.ActionEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.MouseEvent; 
import javax.swing.ButtonGroup; 
import javax.swing.JButton; 
import javax.swing.JDialog; 
import javax.swing.JLabel; 
import javax.swing.JMenuBar; 
import javax.swing.JRadioButton; 
import javax.swing.JScrollPane; 
import javax.swing.JTable; 
import javax.swing.JTextField;
import java.awt.Point;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luca
 */
public class dlgListarStock extends javax.swing.JDialog {
 DefaultTableModel model;

    /**
     * Creates new form dlgAjusteStock
     */
    public dlgListarStock(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargar("");
        tablaarticulo();
        grupo();
    }
 
    // GRUPO DE BOTONES OPCIONALES
             public void grupo() {
        grupoBotones.add(rbtnCodigo);
        grupoBotones.add(rbtnDesc);
        
       
    }
    
    
    void cargar(String valor){
    String mostrar="Select * FROM articulo ORDER BY(idarticulo)";
    String titulos[] = {"Código","Codigo de Fabrica" ,"Descripción","Stock "};
    String []Registros=new String[20];
    model = new DefaultTableModel(null,titulos);
  
        try {
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery(mostrar);
              while(rs.next())
              {
                  Registros[0]= rs.getString("idarticulo");
                  Registros[1]= rs.getString("codArticulo");
                  Registros[2]= rs.getString("detalle_articulo");
                  Registros[3]= rs.getString("Stock");

                  
                  model.addRow(Registros);
              }
              grillaAjusteStock.setModel(model);

        } catch (SQLException ex) {
            Logger.getLogger(dlgListarStock.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                 
  }
     void filtrarCodigo(String valor){
    String mostrar="Select * FROM articulo WHERE (idarticulo) like '%"+valor+"%'";
    String titulos[] = {"Código","Codigo de Fabrica" ,"Descripción","Stock "};
    String []Registros=new String[20];
    model = new DefaultTableModel(null,titulos);
  
        try {
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery(mostrar);
              while(rs.next())
              {
                Registros[0]= rs.getString("idarticulo");
                  Registros[1]= rs.getString("codArticulo");
                  Registros[2]= rs.getString("detalle_articulo");
                  Registros[3]= rs.getString("Stock");

                  
                  model.addRow(Registros);
              }
              grillaAjusteStock.setModel(model);

        } catch (SQLException ex) {
            Logger.getLogger(dlgListarStock.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                 
  }
      void filtrarDescripcion(String valor){
    String mostrar="Select * FROM articulo WHERE (detalle_articulo) like '%"+valor+"%'";;
     String titulos[] = {"Código","Codigo de Fabrica" ,"Descripción","Stock "};
    String []Registros=new String[20];
    model = new DefaultTableModel(null,titulos);
  
        try {
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery(mostrar);
              while(rs.next())
              {
                  Registros[0]= rs.getString("idarticulo");
                  Registros[1]= rs.getString("codArticulo");
                  Registros[2]= rs.getString("detalle_articulo");
                  Registros[3]= rs.getString("Stock");
                  
                  model.addRow(Registros);
              }
              grillaAjusteStock.setModel(model);

        } catch (SQLException ex) {
            Logger.getLogger(dlgListarStock.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                 
  
       
                
                 
  }
     void tablaarticulo(){
        // Genera espacion entre las columnas 
         grillaAjusteStock.getColumnModel().getColumn(0).setPreferredWidth(75);
         grillaAjusteStock.getColumnModel().getColumn(1).setPreferredWidth(75);
         grillaAjusteStock.getColumnModel().getColumn(2).setPreferredWidth(300);
         grillaAjusteStock.getColumnModel().getColumn(2).setPreferredWidth(50);
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        grillaAjusteStock = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        rbtnCodigo = new javax.swing.JRadioButton();
        rbtnDesc = new javax.swing.JRadioButton();
        bto_Salir = new javax.swing.JButton();
        bto_reporte = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        grillaAjusteStock.setModel(new javax.swing.table.DefaultTableModel(
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
        grillaAjusteStock.setSelectionBackground(new java.awt.Color(255, 0, 0));
        grillaAjusteStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grillaAjusteStockMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                grillaAjusteStockMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(grillaAjusteStock);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buscar por :");

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        rbtnCodigo.setBackground(new java.awt.Color(153, 153, 153));
        rbtnCodigo.setText("Codigo");
        rbtnCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnCodigoActionPerformed(evt);
            }
        });

        rbtnDesc.setBackground(new java.awt.Color(153, 153, 153));
        rbtnDesc.setText("Descripcion");
        rbtnDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnDescActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                .addComponent(rbtnCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtnDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(100, 100, 100)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(110, 110, 110)
                                    .addComponent(bto_reporte))
                                .addComponent(bto_Salir)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(70, 70, 70)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(423, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(14, 14, 14)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bto_reporte)
                        .addComponent(bto_Salir))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void grillaAjusteStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grillaAjusteStockMouseClicked
  
            
    }//GEN-LAST:event_grillaAjusteStockMouseClicked

    private void grillaAjusteStockMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grillaAjusteStockMousePressed

    }//GEN-LAST:event_grillaAjusteStockMousePressed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        String cadena = (txtBuscar.getText()).toUpperCase();
        txtBuscar.setText(cadena);
      if(txtBuscar.getText().length()==0){
            cargar("");
            tablaarticulo();
        }
        if(rbtnCodigo.isSelected()) {
            filtrarCodigo(txtBuscar.getText());
            tablaarticulo();
        }

        if(rbtnDesc.isSelected()) {
            filtrarDescripcion(txtBuscar.getText());
            tablaarticulo();
        }
      

    }//GEN-LAST:event_txtBuscarKeyReleased

    private void rbtnCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnCodigoActionPerformed

    }//GEN-LAST:event_rbtnCodigoActionPerformed

    private void rbtnDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnDescActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_rbtnDescActionPerformed

    private void bto_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_SalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_bto_SalirActionPerformed

    private void bto_reporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_reporteActionPerformed

      

    }//GEN-LAST:event_bto_reporteActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(dlgListarStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgListarStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgListarStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgListarStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgListarStock dialog = new dlgListarStock(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bto_Salir;
    private javax.swing.JButton bto_reporte;
    public static javax.swing.JTable grillaAjusteStock;
    private javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtnCodigo;
    private javax.swing.JRadioButton rbtnDesc;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
conectar cc= new conectar();
Connection cn= cc.conexion();
}
