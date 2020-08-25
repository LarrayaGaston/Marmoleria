/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestionar_Caja;



import com.toedter.calendar.JDateChooser; 
import java.awt.event.ActionEvent; 
import javax.swing.JButton; 
import javax.swing.JInternalFrame; 
import javax.swing.JLabel; 
import javax.swing.JSeparator; 
import javax.swing.JTextField;
import Clases.CajaFinal;
import Clases.CajaInicial;
import Componentes.Mensajes;
import Componentes.validarCampos;
import Metodos.Conectar;

import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author FERNANDO
 */
public class iFCaja extends javax.swing.JInternalFrame {
    static ResultSet rs=null;
       
    public iFCaja() {
        initComponents();
        codcaja.setVisible(false);
        codcajafin.setVisible(false);
        this.setSize(706, 566);
        //---------------------FECHA ACTUAL-------------------------------
        Date date=new Date();
        String format=new String("dd/MM/yyyy");
        SimpleDateFormat formato=new SimpleDateFormat(format);
        dcFecha.setDate(date);
      idcajafin();
      id();
      mirar();
    }
    void id(){
                   try{
            String dato [] = new String [1];
            Conectar miconexion = new Conectar();
            String consultasql = "select max(idcaja)+1 from caja_inicial";
            ResultSet rs = miconexion.consulta(consultasql);  
            
            while(rs.next()){       //recorre el resultset mientras tenga algun dato
                for (int j=0; j<dato.length; j++){  //RECORRE HORINZONTALMENTE
                    dato[j]= rs.getString(j+1);
                }
                codcaja.setText(rs.getString(1));
                
                           }   
        }
         catch(Exception e){
           //e.toString() es para que te mustre el error si lo tenes 
           JOptionPane.showMessageDialog(null, e.toString()); 
        }
       }
    
    void idcajafin(){
                   try{
            String dato [] = new String [1];
            Conectar miconexion = new Conectar();
            String consultasql = "select max(idcajafin)+1 from caja_final";
            ResultSet rs = miconexion.consulta(consultasql);  
            
            while(rs.next()){       //recorre el resultset mientras tenga algun dato
                for (int j=0; j<dato.length; j++){  //RECORRE HORINZONTALMENTE
                    dato[j]= rs.getString(j+1);
                }
                codcajafin.setText(rs.getString(1));
                
                           }   
        }
         catch(Exception e){
           //e.toString() es para que te mustre el error si lo tenes 
           JOptionPane.showMessageDialog(null, e.toString()); 
        }
       }
    
    
    void CajaFinal(){
        
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        DecimalFormat formateador = new DecimalFormat("####.##",simbolos);
        double precio_venta,precio_ingreso=0,total_prod=0;
        precio_venta=Double.parseDouble(txtefectivo.getText());
        precio_ingreso=Double.parseDouble(txttotal.getText());
        total_prod=precio_venta+precio_ingreso;
        txtcajafin.setText(String.valueOf(formateador.format(total_prod)));
    }
    
    void Diferencia(){
        
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        DecimalFormat formateador = new DecimalFormat("####.##",simbolos);
        double precio_venta=0,precio_ingreso=0,total_prod=0;
        precio_venta=Double.parseDouble(txttotalefec.getText());
        precio_ingreso=Double.parseDouble(txtcajafin.getText());
        total_prod=precio_venta-precio_ingreso;
        txtdiferencia.setText(String.valueOf(formateador.format(total_prod)));
    }
    
    void EfvoFinal(){
        
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        DecimalFormat formateador = new DecimalFormat("####.##",simbolos);
        double precio_venta=0,precio_ingreso=0,total_prod=0;
        
        
        
    }
    
    
    void limpiarCampos()
    {
       
        btningreso.setEnabled(true);
        btnventa.setEnabled(true);
        btntotal.setEnabled(true);
        btnegreso.setEnabled(true);
        btnguardar.setEnabled(false);
        dcFecha.setEnabled(false);
        btnguardarfinal.setEnabled(true);
    }
      void mirar(){
       btningreso.setEnabled(false);
       btnventa.setEnabled(false);
       btnguardar.setEnabled(true);
       btntotal.setEnabled(false);
     //  btnsalir.setEnabled(true);
       btnegreso.setEnabled(false);
       btnguardarfinal.setEnabled(false);
       
      }

//-----------------------------------------------------------------------------------------------
//--------------------------------------METODOS--------------------------------------------------
//-----------------------------------------------------------------------------------------------

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        dcFecha = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtefectivo = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        codcaja = new javax.swing.JTextField();
        btnguardarfinal = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnegreso = new javax.swing.JButton();
        txtventa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtdiferencia = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        codcajafin = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txttotalefec = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtcajafin = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtingreso = new javax.swing.JTextField();
        txtegreso = new javax.swing.JTextField();
        btntotal = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btningreso = new javax.swing.JButton();
        btnventa = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setTitle("Caja Inicial");
        setMinimumSize(new java.awt.Dimension(150, 100));
        setPreferredSize(new java.awt.Dimension(150, 100));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("FECHA:");

        dcFecha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("EFECTIVO: ");

        txtefectivo.setText(" ");

        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        codcaja.setBorder(null);
        codcaja.setSelectionColor(new java.awt.Color(204, 204, 204));

        btnguardarfinal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnguardarfinal.setText("Guardar");
        btnguardarfinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarfinalActionPerformed(evt);
            }
        });

        btnegreso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnegreso.setText("Buscar Egreso");
        btnegreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnegresoActionPerformed(evt);
            }
        });

        txtventa.setText(" ");
        txtventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtventaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("VENTA: ");

        txtdiferencia.setText(" ");
        txtdiferencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtdiferenciaMouseClicked(evt);
            }
        });
        txtdiferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiferenciaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("EFECTIVO FINAL:");

        codcajafin.setText(" ");
        codcajafin.setBorder(null);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("DIFERENCIA: ");

        txttotalefec.setText(" ");
        txttotalefec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalefecActionPerformed(evt);
            }
        });

        txttotal.setText(" ");
        txttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("TOTAL: ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("CAJA FINAL: ");

        txtcajafin.setText(" ");
        txtcajafin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtcajafinMouseClicked(evt);
            }
        });
        txtcajafin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcajafinActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("INGRESO+: ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("EGRESO-: ");

        txtingreso.setText(" ");

        txtegreso.setText(" ");

        btntotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btntotal.setText("Total");
        btntotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntotalActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("CAJA FINAL");

        btningreso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btningreso.setText("Buscar Ingreso");
        btningreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btningresoActionPerformed(evt);
            }
        });

        btnventa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnventa.setText("Buscar Venta");
        btnventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnventaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txtventa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnventa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtcajafin, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btningreso, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txttotalefec, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtegreso, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnegreso, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtdiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btntotal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(185, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(260, 260, 260)
                    .addComponent(codcajafin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(359, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnventa)
                    .addComponent(jLabel4)
                    .addComponent(txtcajafin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btningreso)
                    .addComponent(jLabel10)
                    .addComponent(txttotalefec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtegreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnegreso)
                    .addComponent(jLabel11)
                    .addComponent(txtdiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntotal))
                .addGap(28, 28, 28))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(codcajafin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(184, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dcFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(txtefectivo))
                        .addGap(110, 110, 110)
                        .addComponent(codcaja, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(626, 626, 626)
                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(btnguardarfinal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(338, 338, 338))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codcaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1))
                    .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtefectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(145, 145, 145)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardarfinal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
       
        // Instancia de Clase
        CajaInicial caja= new CajaInicial();
        // Instancia de Metodo 
        gestionarCajaInicial guardarcaja= new gestionarCajaInicial();
        int result = JOptionPane.showConfirmDialog(this, "¿Desea Generar el Cierre de Caja Inicial?", "Mensaje del Sistema", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
             
             if(txtefectivo.getText().isEmpty() )                                                                                                   //VALIDACIONES
             {
           JOptionPane.showMessageDialog(null,"CARGUE UNA VALOR ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
             }
             else if (txtefectivo.getText().isEmpty() )                                                                                                   //VALIDACIONES
             {
           JOptionPane.showMessageDialog(null,"CARGUE UNA VALOR ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
             }
             
        caja.setcodcaja(codcaja.getText());
        caja.setefectivo(txtefectivo.getText());
        caja.setfecha(dcFecha.getDate());
        guardarcaja.GuardarCajaInicial(caja);
        limpiarCampos();
        Mensajes.informacion("Caja Registrada");
        }
          
        
        
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btntotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntotalActionPerformed
        // TODO add your handling code here:
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        DecimalFormat formateador = new DecimalFormat("####.##",simbolos);
        double precio_venta=0,precio_ingreso=0,precio_egreso=0,total_prod=0;
        precio_venta=Double.parseDouble(txtventa.getText());
        precio_ingreso=Double.parseDouble(txtingreso.getText());
        precio_egreso=Double.parseDouble(txtegreso.getText());
        total_prod=(precio_venta+precio_ingreso)-precio_egreso;
        txttotal.setText(String.valueOf(formateador.format(total_prod)));
        
        
        CajaFinal();
        Diferencia();
    }//GEN-LAST:event_btntotalActionPerformed

    private void btningresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btningresoActionPerformed

        // TODO add your handling code here:
        dlgConsultarIngresos ingresos = new dlgConsultarIngresos(null, true);
        ingresos.setLocationRelativeTo(null);
        ingresos.setTitle("Consulta de Ingresos");
        ingresos.setVisible(true);
    }//GEN-LAST:event_btningresoActionPerformed

    private void btnventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnventaActionPerformed

        
        // TODO add your handling code here:
        dlgConsultarVentasCaja ventas = new dlgConsultarVentasCaja(null, true);
        ventas.setLocationRelativeTo(null);
        ventas.setTitle("Consulta de Ventas");
        ventas.setVisible(true);
    }//GEN-LAST:event_btnventaActionPerformed

    private void txttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_txttotalActionPerformed

    private void btnegresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnegresoActionPerformed
        // TODO add your handling code here:
        dlgConsultarEgresos ingresos = new dlgConsultarEgresos(null, true);
        ingresos.setLocationRelativeTo(null);
        ingresos.setTitle("Consulta de Egresos");
        ingresos.setVisible(true);
    }//GEN-LAST:event_btnegresoActionPerformed

    private void btnguardarfinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarfinalActionPerformed
        // TODO add your handling code here:
        // Instancia de Clase
        CajaFinal caja= new CajaFinal();
        // Instancia de Metodo 
        gestionarCajaFinal guardarcaja= new gestionarCajaFinal();
        int result = JOptionPane.showConfirmDialog(this, "¿Desea Generar el Cierre de Caja Final?", "Mensaje del Sistema", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
             if(txtventa.getText().isEmpty() )                                                                                                   //VALIDACIONES
       { 
           JOptionPane.showMessageDialog(null,"CARGUE UNA VENTA ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
  
       else if(txtingreso.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"CARGUE UN INGRESO  ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
        }
               
        else if(txtegreso.getText().isEmpty() ) 
       { 
           JOptionPane.showMessageDialog(null,"CARGUE UN EGRESO ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
       else if(txttotal.getText().isEmpty() ) 
       { 
           JOptionPane.showMessageDialog(null,"CARGUE EL TOTAL","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
        else if(txtcajafin.getText().isEmpty() ) 
       { 
           JOptionPane.showMessageDialog(null,"CLICKEAR EL CASILLERO CAJA FINAL","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
         else if(txttotalefec.getText().isEmpty() ) 
       { 
           JOptionPane.showMessageDialog(null,"CLICKEAR EL CASILLERO EFECTIVO TOTAL","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
          else if(txtdiferencia.getText().isEmpty() ) 
       { 
           JOptionPane.showMessageDialog(null,"CLICKEAR EL CASILLERO DIFERENCIA","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
             
       else{
        
        // GUARDAR
        caja.setcodcajafin(codcajafin.getText()); 
        caja.setcodcajaini(codcaja.getText());
        caja.setventa(txtventa.getText());
        caja.setingreso(txtingreso.getText());
        caja.setegreso(txtegreso.getText());
        caja.settotal(txttotal.getText());
        caja.settotalcaja(txtcajafin.getText());
        caja.settotalefectivo(txttotalefec.getText());
        caja.setdiferencia(txtdiferencia.getText());
        guardarcaja.GuardarCajaFinal(caja);
        
        Mensajes.informacion("Caja Final Registrada");
        
    }
    }
        this.dispose();
    }//GEN-LAST:event_btnguardarfinalActionPerformed

    private void txtcajafinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcajafinActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_txtcajafinActionPerformed

    private void txtventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtventaActionPerformed

    private void txtdiferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiferenciaActionPerformed
        // TODO add your handling code here:
                
    }//GEN-LAST:event_txtdiferenciaActionPerformed

    private void txtcajafinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcajafinMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtcajafinMouseClicked

    private void txtdiferenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtdiferenciaMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtdiferenciaMouseClicked

    private void txttotalefecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalefecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalefecActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnegreso;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnguardarfinal;
    private javax.swing.JButton btningreso;
    private javax.swing.JButton btntotal;
    private javax.swing.JButton btnventa;
    private javax.swing.JTextField codcaja;
    private javax.swing.JTextField codcajafin;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JTextField txtcajafin;
    public static javax.swing.JTextField txtdiferencia;
    private javax.swing.JTextField txtefectivo;
    public static javax.swing.JTextField txtegreso;
    public static javax.swing.JTextField txtingreso;
    private javax.swing.JTextField txttotal;
    private javax.swing.JTextField txttotalefec;
    public static javax.swing.JTextField txtventa;
    // End of variables declaration//GEN-END:variables
}
