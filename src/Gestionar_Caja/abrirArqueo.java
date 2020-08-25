/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestionar_Caja;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 *
 * @author Gaston
 */
public class abrirArqueo extends javax.swing.JFrame {

    /**
     * Creates new form abrirArqueo
     */
    public abrirArqueo() {
        initComponents();
        CargarTablas();
    }

    public  void CargarTablas(){
        
        String[] cabecera = new String[] {"Valor", "Cantidad", "Importe"};

	    String[][] datosBilletes = new String[][] {{"500", "", "0"}, {"200", "", "0"},
	         {"100", "", "0"}, {"50", "", "0"}, {"20", "", "0"},
                 {"10", "", "0"}, {"5", "", "0"}};

            String[][] datosMonedas = new String[][] {{"2", "", "0"}, {"1", "", "0"},
					{"0.5", "", "0"}, {"0.2", "", "0"}, 
                                        {"0.1", "", "0"}, {"0.05", "", "0"},
                                        {"0.02", "", "0"},{"0.01", "", "0"}};
        
            tablaBilletes = new MiTabla(datosBilletes, cabecera);
            tablaBilletes.getModel().addTableModelListener(new CambiosBilletes());
            JScrollPane spBilletes = new JScrollPane(tablaBilletes);
            spBilletes.setPreferredSize(new Dimension(200, 135));
            tablaMonedas = new MiTabla(datosMonedas, cabecera);
            tablaMonedas.getModel().addTableModelListener(new CambiosMonedas());
            JScrollPane spMonedas = new JScrollPane(tablaMonedas);
            spMonedas.setPreferredSize(new Dimension(200, 153));
            
    }
    
    private class MiTabla extends JTable {
		
		int filas;

		public MiTabla(String[][] datos, String[] cabecera) {
			super(datos, cabecera);
			filas = datos.length; //La tabla billetes y la tabla monedas tienen distinto numero de filas
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
        tablaBilletes = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaMonedas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaBilletes.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaBilletes.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tablaBilletesAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(tablaBilletes);

        tablaMonedas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaMonedas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(218, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaBilletesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tablaBilletesAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaBilletesAncestorAdded

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
            java.util.logging.Logger.getLogger(abrirArqueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(abrirArqueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(abrirArqueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(abrirArqueo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new abrirArqueo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaBilletes;
    private javax.swing.JTable tablaMonedas;
    // End of variables declaration//GEN-END:variables


 private class CambiosBilletes implements TableModelListener {
		@Override
		public void tableChanged(TableModelEvent evento) {
			if (evento.getType() == TableModelEvent.UPDATE) {
				int fila = evento.getFirstRow();
				int columna = evento.getColumn();
				if (columna == 1) { //Solo actuamos cuando "escuchamos" cambios en columna 1
					try {
						int cantidad = Integer.parseInt((String)tablaBilletes.getValueAt(fila, 1));
						int valor = Integer.parseInt((String)tablaBilletes.getValueAt(fila, 0));
						tablaBilletes.setValueAt(Integer.toString(cantidad * valor), fila, 2);
//						panelSur.actualizar(tablaBilletes.conteoTabla() + tablaMonedas.conteoTabla());
					}catch (Exception e){
						System.out.println(e.getLocalizedMessage());
						JOptionPane.showMessageDialog(null, "Introduzca solo valores numéricos enteros",
								"Tabla Billetes", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		}
	}

	private class CambiosMonedas implements TableModelListener {
		@Override
		public void tableChanged(TableModelEvent evento) {
			if (evento.getType() == TableModelEvent.UPDATE) {
				int fila = evento.getFirstRow();
				int columna = evento.getColumn();
				if (columna == 1) {
					try {
						int cantidad = Integer.parseInt((String)tablaMonedas.getValueAt(fila, 1));
						Double valor = Double.parseDouble((String)tablaMonedas.getValueAt(fila, 0));
						if (fila < 2) //En estas filas, no son monedas fraccionarias con decimales
							tablaMonedas.setValueAt(Integer.toString(cantidad * valor.intValue()), fila, 2);
						else
							tablaMonedas.setValueAt(Double.toString(redondearDecimales(cantidad * valor, 2)), fila, 2);
//						panelSur.actualizar(tablaBilletes.conteoTabla() + tablaMonedas.conteoTabla());
					}catch (Exception e){
						JOptionPane.showMessageDialog(null, "Introduzca solo valores numéricos enteros",
								"Tabla Monedas", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		}
	}

		private double redondearDecimales(double valorInicial, int numeroDecimales) {
			double parteEntera, resultado;
			resultado = valorInicial;
			parteEntera = Math.floor(resultado);
			resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
			resultado=Math.round(resultado);
			resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
			return resultado;
		}






}
