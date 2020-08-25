/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios.Gestionar_Ventas;

import Componentes.GenerarReporte;
import Componentes.conectar;
import static Formularios.Gestionar_Ventas.dlgVentaRecibo.txtDocumentoVenta;
import Metodos.Conectar;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gaston
 */
public class VerFactura extends javax.swing.JFrame {

    /**
     * Creates new form VerFactura
     */
    private Connection connection=new conectar().conexion();
    static ResultSet rs=null;
    static ResultSet rsTotal=null;
    DefaultTableModel dtm=new DefaultTableModel();
    String criterio,busqueda;
    String Total;
    String idventa;
    String id[]=new String[50];
    static int intContador;
   
    public VerFactura() {
        initComponents();
        obtenerUltimoIdVenta();
        txtDocumentoVenta.setVisible(true);
        
        //---------------------ANCHO Y ALTO DEL FORM----------------------
        this.setSize(400, 205);
    }
    
    void obtenerUltimoIdVenta(){
                  try{
            String dato [] = new String [1];
            Conectar miconexion = new Conectar();
            String consultasql = "select max(idVFactura) from ventafactura";
//            String consultasql = "SELECT * FROM `ventafactura` WHERE `idVFactura`=5";
            ResultSet rs = miconexion.consulta(consultasql);  
            
            while(rs.next()){       //recorre el resultset mientras tenga algun dato
                for (int j=0; j<dato.length; j++){  //RECORRE HORINZONTALMENTE
                    dato[j]= rs.getString(j+1);
                }
                txtDocumentoVenta.setText(rs.getString(1));
                
                           }   
        }
         catch(Exception e){
           //e.toString() es para que te mustre el error si lo tenes 
           JOptionPane.showMessageDialog(null, e.toString()); 
        }
        
    }
    
    

        public void llamarReporteFactura() {
        GenerarReporte gr;
        gr = new GenerarReporte();
        int codF = Integer.parseInt(txtDocumentoVenta.getText());
        gr.MostrarReporteConParametro("src/Reporte_Ventas/Ventas.jasper", "Factura de Venta", codF);
        gr.cerrar();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVerRecibo = new javax.swing.JButton();
        txtDocumentoVenta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnVerRecibo.setText("Ver Comprobante");
        btnVerRecibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerReciboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtDocumentoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVerRecibo)
                .addContainerGap(212, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDocumentoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 184, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerReciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerReciboActionPerformed
        llamarReporteFactura();
        
        //        this.dispose();
        /*       if(txtDocumentoVenta.getText().equals("FACTURA")){
            Map p=new HashMap();
            p.put("busqueda", idventa);
            //            String imagen="C:/Users/Edgar/Desktop/Proyecto_Casita/Sistema_Casita/src/Iconos/casita.png";
            //            p.put("imagen", this.getClass().getResourceAsStream(imagen));

            JasperReport report;
            JasperPrint print;

            try{
                report=JasperCompileManager.compileReport(new File("").getAbsolutePath()+ "/src/Reportes/RptVentaFactura.jrxml");
                print=JasperFillManager.fillReport(report, p,connection);
                JasperViewer view=new JasperViewer(print,false);
                view.setTitle("Reporte de Venta");
                view.setVisible(true);
            }catch(JRException e){
                e.printStackTrace();
            }
        }else if(txtDocumentoVenta.getText().equals("BOLETA")){
            Map p=new HashMap();
            p.put("busqueda", idventa);
            JasperReport report;
            JasperPrint print;
            try{
                report=JasperCompileManager.compileReport(new File("").getAbsolutePath()+ "/src/Reportes/RptVentaBoleta.jrxml");
                print=JasperFillManager.fillReport(report, p,connection);
                JasperViewer view=new JasperViewer(print,false);
                view.setTitle("Reporte de Venta");
                view.setVisible(true);
            }catch(JRException e){
                e.printStackTrace();
            }
        }else if(txtDocumentoVenta.getText().equals("TICKET")){
            Map p=new HashMap();
            p.put("busqueda", idventa);
            JasperReport report;
            JasperPrint print;
            try{
                report=JasperCompileManager.compileReport(new File("").getAbsolutePath()+ "/src/Reportes/RptVentaTicket.jrxml");
                print=JasperFillManager.fillReport(report, p,connection);
                JasperViewer view=new JasperViewer(print,false);
                view.setTitle("Reporte de Venta");
                view.setVisible(true);
            }catch(JRException e){
                e.printStackTrace();
            }
        }
        */

    }//GEN-LAST:event_btnVerReciboActionPerformed

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
            java.util.logging.Logger.getLogger(VerFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerFactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVerRecibo;
    public static javax.swing.JTextField txtDocumentoVenta;
    // End of variables declaration//GEN-END:variables
}