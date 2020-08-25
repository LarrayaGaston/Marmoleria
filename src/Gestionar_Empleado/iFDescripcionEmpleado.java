package Gestionar_Empleado;

import Gestionar_Cliente.*;
import Clases.Cliente;
import Componentes.GenerarReporte;

import Componentes.Mensajes;
import Componentes.conectar;
import Gestionar_Cientes.jDlg_CargarCliente;
import static Gestionar_Empleado.iFDescripcionEmpleado26.grillaEmpleado;
import Gestionar_Empleado.jDlg_CargarEmpleado25;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luca
 */
public class iFDescripcionEmpleado extends javax.swing.JInternalFrame {
 DefaultTableModel model;
    /**
     * Creates new form iFDescripcionClientes
     */
    public iFDescripcionEmpleado() {
        initComponents();   
       cargar("");
        tabla();
       
   
    }
    
        
       void grupo()
    {
        GrupoBotones.add(rbtnCodigo);
        GrupoBotones.add(rbtnApellido);
        GrupoBotones.add(rbtnDni);
    }
    
         void tabla(){
        // Genera espacion entre las columnas  // Oculta las columnas
        
         grillaEmpleado.getColumnModel().getColumn(0).setPreferredWidth(60);
         grillaEmpleado.getColumnModel().getColumn(1).setPreferredWidth(100);
         grillaEmpleado.getColumnModel().getColumn(2).setPreferredWidth(100);
         grillaEmpleado.getColumnModel().getColumn(3).setPreferredWidth(100);
         grillaEmpleado.getColumnModel().getColumn(4).setPreferredWidth(100);
         grillaEmpleado.getColumnModel().getColumn(5).setPreferredWidth(100);
         grillaEmpleado.getColumnModel().getColumn(6).setPreferredWidth(100);
         grillaEmpleado.getColumnModel().getColumn(7).setPreferredWidth(100);
         grillaEmpleado.getColumnModel().getColumn(8).setPreferredWidth(100);
         grillaEmpleado.getColumnModel().getColumn(9).setPreferredWidth(100);
         grillaEmpleado.getColumnModel().getColumn(10).setPreferredWidth(100);
         grillaEmpleado.getColumnModel().getColumn(11).setPreferredWidth(100);
         grillaEmpleado.getColumnModel().getColumn(12).setPreferredWidth(100);
         grillaEmpleado.getColumnModel().getColumn(13).setMaxWidth(0);
         grillaEmpleado.getColumnModel().getColumn(13).setMinWidth(0);    
         grillaEmpleado.getColumnModel().getColumn(13).setPreferredWidth(0);
         grillaEmpleado.getColumnModel().getColumn(14).setPreferredWidth(250);
         


        
     } 
    
    // CARGA LA TABLA Clientes     
    void cargar(String valor) {
       // String mostrar = "Select * FROM (Clientes JOIN provincias ON ((clientes.cli_provincia = provincias.idprovincia))) JOIN ciudades ON ((clientes.cli_ciudad = ciudades.idciudad)) JOIN cond_iva ON ((clientes.cli_condiva = cond_iva.idcond)) ORDER BY (idCliente)";
        String mostrar = "Select * FROM (Empleados JOIN provincias ON ((empleados.emp_provincia = provincias.idprovincia))) JOIN ciudades ON ((empleados.emp_ciudad = ciudades.idciudad)) JOIN persona ON ((persona.idpersona = empleados.idpersona)) ORDER BY (idempleado)";
       
        String clientes[] = {"CÓDIGO", "NOMBRE", "APELLIDO", "DNI" , "TELEFONO", "CELULAR" ,"EMAIL" ,"PROVINCIA","CIUDAD",
            "DOMICILIO","CODIGO.P","F.INGRESO","F.NACIMIENTO","idPersona","CBU"};
        String[] Registros = new String[20];
        model = new DefaultTableModel(null, clientes);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
              

                
                
                
                
                Registros[0] = rs.getString("idEmpleado");

                Registros[1] = rs.getString("persona.nombre");
                Registros[2] = rs.getString("persona.apellido");
                Registros[3] = rs.getString("persona.dni");

                Registros[4] = rs.getString("emp_telefono");

                Registros[5] = rs.getString("emp_celular");

                Registros[6] = rs.getString("emp_email");
                Registros[7] = rs.getString("provincias.descprovincia");
                Registros[8] = rs.getString("ciudades.descciudad");
                Registros[9] = rs.getString("emp_direccion");
                Registros[10] = rs.getString("emp_codpostal");
                Registros[11] = rs.getString("emp_fecha_ingreso");
                
                Registros[12] = rs.getString("persona.fechanacimiento");
                Registros[13] = rs.getString("idPersona");
                Registros[14] = rs.getString("emp_CBU"); 


                //      
                model.addRow(Registros);
            }
           grillaEmpleado.setModel(model);

        } catch (SQLException ex) {
            Logger.getLogger(iFDescripcionEmpleado26.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    void filtrarCodigo(String valor) {
       // String mostrar = "Select * FROM (Clientes JOIN provincias ON ((clientes.cli_provincia = provincias.idprovincia))) JOIN ciudades ON ((clientes.cli_ciudad = ciudades.idciudad)) JOIN cond_iva ON ((clientes.cli_condiva = cond_iva.idcond)) ORDER BY (idCliente)";
        String mostrar = "Select * FROM (Empleados JOIN provincias ON ((empleados.emp_provincia = provincias.idprovincia))) JOIN ciudades ON ((empleados.emp_ciudad = ciudades.idciudad)) JOIN persona ON ((persona.idpersona = empleados.idpersona)) WHERE (idempleado) like '%"+valor+"%'";
       
        String clientes[] = {"CÓDIGO", "NOMBRE", "APELLIDO", "DNI" , "TELEFONO", "CELULAR" ,"EMAIL" ,"PROVINCIA","CIUDAD",
            "DOMICILIO","CODIGO.P","F.INGRESO","F.NACIMIENTO","idPersona","CBU"};
        String[] Registros = new String[20];
        model = new DefaultTableModel(null, clientes);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
              

                
                
                
                
                Registros[0] = rs.getString("idEmpleado");

                Registros[1] = rs.getString("persona.nombre");
                Registros[2] = rs.getString("persona.apellido");
                Registros[3] = rs.getString("persona.dni");

                Registros[4] = rs.getString("emp_telefono");

                Registros[5] = rs.getString("emp_celular");

                Registros[6] = rs.getString("emp_email");
                Registros[7] = rs.getString("provincias.descprovincia");
                Registros[8] = rs.getString("ciudades.descciudad");
                Registros[9] = rs.getString("emp_direccion");
                Registros[10] = rs.getString("emp_codpostal");
                Registros[11] = rs.getString("emp_fecha_ingreso");
                
                Registros[12] = rs.getString("persona.fechanacimiento");
                Registros[13] = rs.getString("idPersona");
                Registros[14] = rs.getString("emp_CBU"); 


                //      
                model.addRow(Registros);
            }
            grillaEmpleado.setModel(model);

        } catch (SQLException ex) {
            Logger.getLogger(iFDescripcionEmpleado26.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    void filtrarApellido(String valor) {
       // String mostrar = "Select * FROM (Clientes JOIN provincias ON ((clientes.cli_provincia = provincias.idprovincia))) JOIN ciudades ON ((clientes.cli_ciudad = ciudades.idciudad)) JOIN cond_iva ON ((clientes.cli_condiva = cond_iva.idcond)) ORDER BY (idCliente)";
        String mostrar = "Select * FROM (Empleados JOIN provincias ON ((empleados.emp_provincia = provincias.idprovincia))) JOIN ciudades ON ((empleados.emp_ciudad = ciudades.idciudad)) JOIN persona ON ((persona.idpersona = empleados.idpersona)) WHERE (persona.apellido) like '%"+valor+"%'";
       
         String clientes[] = {"CÓDIGO", "NOMBRE", "APELLIDO", "DNI" , "TELEFONO", "CELULAR" ,"EMAIL" ,"PROVINCIA","CIUDAD",
            "DOMICILIO","CODIGO.P","F.INGRESO","F.NACIMIENTO","idPersona","CBU"};
        String[] Registros = new String[20];
        model = new DefaultTableModel(null, clientes);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
              

                
                
                
                
                Registros[0] = rs.getString("idEmpleado");

                Registros[1] = rs.getString("persona.nombre");
                Registros[2] = rs.getString("persona.apellido");
                Registros[3] = rs.getString("persona.dni");

                Registros[4] = rs.getString("emp_telefono");

                Registros[5] = rs.getString("emp_celular");

                Registros[6] = rs.getString("emp_email");
                Registros[7] = rs.getString("provincias.descprovincia");
                Registros[8] = rs.getString("ciudades.descciudad");
                Registros[9] = rs.getString("emp_direccion");
                Registros[10] = rs.getString("emp_codpostal");
                Registros[11] = rs.getString("emp_fecha_ingreso");
                
                Registros[12] = rs.getString("persona.fechanacimiento");
                Registros[13] = rs.getString("idPersona");
                Registros[14] = rs.getString("emp_CBU"); 


                //      
                model.addRow(Registros);
            }
            grillaEmpleado.setModel(model);

        } catch (SQLException ex) {
            Logger.getLogger(iFDescripcionEmpleado26.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    void filtrarDni(String valor) {
       // String mostrar = "Select * FROM (Clientes JOIN provincias ON ((clientes.cli_provincia = provincias.idprovincia))) JOIN ciudades ON ((clientes.cli_ciudad = ciudades.idciudad)) JOIN cond_iva ON ((clientes.cli_condiva = cond_iva.idcond)) ORDER BY (idCliente)";
        String mostrar = "Select * FROM (Empleados JOIN provincias ON ((empleados.emp_provincia = provincias.idprovincia))) JOIN ciudades ON ((empleados.emp_ciudad = ciudades.idciudad)) JOIN persona ON ((persona.idpersona = empleados.idpersona)) WHERE (persona.dni) like '%"+valor+"%'";
       
        String clientes[] = {"CÓDIGO", "NOMBRE", "APELLIDO", "DNI" , "TELEFONO", "CELULAR" ,"EMAIL" ,"PROVINCIA","CIUDAD",
            "DOMICILIO","CODIGO.P","F.INGRESO","F.NACIMIENTO","idPersona","CBU"};
        String[] Registros = new String[20];
        model = new DefaultTableModel(null, clientes);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
              

                
                
                
                
                Registros[0] = rs.getString("idEmpleado");

                Registros[1] = rs.getString("persona.nombre");
                Registros[2] = rs.getString("persona.apellido");
                Registros[3] = rs.getString("persona.dni");

                Registros[4] = rs.getString("emp_telefono");

                Registros[5] = rs.getString("emp_celular");

                Registros[6] = rs.getString("emp_email");
                Registros[7] = rs.getString("provincias.descprovincia");
                Registros[8] = rs.getString("ciudades.descciudad");
                Registros[9] = rs.getString("emp_direccion");
                Registros[10] = rs.getString("emp_codpostal");
                Registros[11] = rs.getString("emp_fecha_ingreso");
                
                Registros[12] = rs.getString("persona.fechanacimiento");
                Registros[13] = rs.getString("idPersona");
                Registros[14] = rs.getString("emp_CBU"); 


                //      
                model.addRow(Registros);
            }
            grillaEmpleado.setModel(model);

        } catch (SQLException ex) {
            Logger.getLogger(iFDescripcionEmpleado26.class.getName()).log(Level.SEVERE, null, ex);
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

        GrupoBotones = new javax.swing.ButtonGroup();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jModificar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        rbtnCodigo = new javax.swing.JRadioButton();
        rbtnDni = new javax.swing.JRadioButton();
        rbtnApellido = new javax.swing.JRadioButton();
        txtBuscar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        grillaEmpleado = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        bto_reporte = new javax.swing.JButton();
        bto_Modificar = new javax.swing.JButton();
        bto_nuevo = new javax.swing.JButton();
        bto_Salir = new javax.swing.JButton();

        jModificar.setText("Modificar");
        jModificar.setComponentPopupMenu(jPopupMenu2);
        jModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jModificarActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jModificar);

        setBackground(new java.awt.Color(102, 102, 102));
        setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(51, 51, 51), null));
        setForeground(new java.awt.Color(102, 102, 102));
        setMaximizable(true);
        setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        GrupoBotones.add(rbtnCodigo);
        rbtnCodigo.setText("Codigo");
        rbtnCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnCodigoActionPerformed(evt);
            }
        });

        GrupoBotones.add(rbtnDni);
        rbtnDni.setText("Dni");

        GrupoBotones.add(rbtnApellido);
        rbtnApellido.setText("Apellido");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jLabel3.setText("Buscar por :");

        grillaEmpleado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        grillaEmpleado.setModel(new javax.swing.table.DefaultTableModel(
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
        grillaEmpleado.setToolTipText("");
        grillaEmpleado.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        grillaEmpleado.setComponentPopupMenu(jPopupMenu2);
        grillaEmpleado.setSelectionBackground(new java.awt.Color(255, 0, 0));
        jScrollPane1.setViewportView(grillaEmpleado);

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

        bto_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-actualizar_opt.png"))); // NOI18N
        bto_Modificar.setToolTipText("Modificar Empleado");
        bto_Modificar.setBorderPainted(false);
        bto_Modificar.setContentAreaFilled(false);
        bto_Modificar.setFocusPainted(false);
        bto_Modificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bto_Modificar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-actualizar_opt (1).png"))); // NOI18N
        bto_Modificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bto_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_ModificarActionPerformed(evt);
            }
        });

        bto_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-editar_opt.png"))); // NOI18N
        bto_nuevo.setToolTipText("Nuevo Empleado");
        bto_nuevo.setBorderPainted(false);
        bto_nuevo.setContentAreaFilled(false);
        bto_nuevo.setFocusPainted(false);
        bto_nuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bto_nuevo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-editar_opt (1).png"))); // NOI18N
        bto_nuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bto_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_nuevoActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(184, 184, 184)
                                .addComponent(bto_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, Short.MAX_VALUE)
                                .addGap(85, 85, 85)
                                .addComponent(bto_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, Short.MAX_VALUE)
                                .addGap(81, 81, 81)
                                .addComponent(bto_reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 93, Short.MAX_VALUE)
                                .addGap(82, 82, 82)
                                .addComponent(bto_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 91, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnCodigo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtnApellido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtnDni)))
                        .addGap(184, 184, 184)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtnCodigo)
                            .addComponent(rbtnApellido)
                            .addComponent(rbtnDni)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(bto_nuevo)
                    .addComponent(bto_Modificar)
                    .addComponent(bto_reporte)
                    .addComponent(bto_Salir))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jModificarActionPerformed
            
     try 
           {
        
        jDlg_CargarEmpleado dlg = new jDlg_CargarEmpleado(null, true);
        
              int fila= grillaEmpleado.getSelectedRow();
            
            if(fila>=0)

            {
            jDlg_CargarEmpleado.lblCodigoEmpleado.setText(grillaEmpleado.getValueAt(fila, 0).toString());
                jDlg_CargarEmpleado.txt_Nombre_empleado.setText(grillaEmpleado.getValueAt(fila, 1).toString());
                jDlg_CargarEmpleado.txt_apellido_empleado.setText(grillaEmpleado.getValueAt(fila, 2).toString()) ;
                jDlg_CargarEmpleado.txtDni.setText(grillaEmpleado.getValueAt(fila, 3).toString()) ;
               
                
                jDlg_CargarEmpleado.txtTelefono.setText(grillaEmpleado.getValueAt(fila, 4).toString());
                jDlg_CargarEmpleado.txtCelular.setText(grillaEmpleado.getValueAt(fila, 5).toString());
                

                jDlg_CargarEmpleado.txtEmail.setText(grillaEmpleado.getValueAt(fila, 6).toString());
                jDlg_CargarEmpleado.cmbProvincia.setSelectedItem(grillaEmpleado.getValueAt(fila, 7).toString());
                jDlg_CargarEmpleado.cmbCiudad.setSelectedItem(grillaEmpleado.getValueAt(fila, 8).toString());
                jDlg_CargarEmpleado.txtDireccion.setText(grillaEmpleado.getValueAt(fila, 9).toString());
                jDlg_CargarEmpleado.txtCodigopostal.setText(grillaEmpleado.getValueAt(fila, 10).toString());
               
//                jDlg_CargarEmpleado.txtfechaingreso.setText(grillaEmpleado.getValueAt(fila, 11).toString());
                
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(grillaEmpleado.getValueAt(fila, 11).toString());
                jDlg_CargarEmpleado.jdc_fechaingreso.setDate(date);
              
//                jDlg_CargarEmpleado.txtfechanacimiento1.setText(grillaEmpleado.getValueAt(fila, 12).toString());
                
                Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(grillaEmpleado.getValueAt(fila, 12).toString());
                jDlg_CargarEmpleado.jdc_fechanacimiento.setDate(date1);
                
                jDlg_CargarEmpleado.lb_codPer.setText(grillaEmpleado.getValueAt(fila, 13).toString());
                jDlg_CargarEmpleado.txt_empCBU.setText(grillaEmpleado.getValueAt(fila, 14).toString());
               
               
               
                
                
                dlg.setTitle("Modificación de Empleado");
                jDlg_CargarEmpleado.Modificar.setEnabled(true);
                jDlg_CargarEmpleado.Guardar_empleado.setEnabled(false);
                jDlg_CargarEmpleado.Nuevo.setEnabled(false);
                dlg.setVisible(true);
            }
            else {
                Mensajes.error("Seleccione una fila de la tabla");
            }

        }

        catch (Exception e) {
            Mensajes.error("");
        }
        
        cargar("error extraño");
        tabla();    
    }//GEN-LAST:event_jModificarActionPerformed

    private void bto_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_SalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_bto_SalirActionPerformed

    private void bto_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_nuevoActionPerformed

        jDlg_CargarEmpleado proveedor = new jDlg_CargarEmpleado(null, true);
        proveedor.setLocationRelativeTo(null);
        proveedor.setTitle("Nuevo Empleado");
        proveedor.setVisible(true);
        cargar("");
        tabla();
    }//GEN-LAST:event_bto_nuevoActionPerformed

    private void bto_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_ModificarActionPerformed

              try 
           {
        
        jDlg_CargarEmpleado dlg = new jDlg_CargarEmpleado(null, true);
        
              int fila= grillaEmpleado.getSelectedRow();
            
            if(fila>=0)

            {
                jDlg_CargarEmpleado.lblCodigoEmpleado.setText(grillaEmpleado.getValueAt(fila, 0).toString());
                jDlg_CargarEmpleado.txt_Nombre_empleado.setText(grillaEmpleado.getValueAt(fila, 1).toString());
                jDlg_CargarEmpleado.txt_apellido_empleado.setText(grillaEmpleado.getValueAt(fila, 2).toString()) ;
                jDlg_CargarEmpleado.txtDni.setText(grillaEmpleado.getValueAt(fila, 3).toString()) ;
               
                
                jDlg_CargarEmpleado.txtTelefono.setText(grillaEmpleado.getValueAt(fila, 4).toString());
                jDlg_CargarEmpleado.txtCelular.setText(grillaEmpleado.getValueAt(fila, 5).toString());
                

                jDlg_CargarEmpleado.txtEmail.setText(grillaEmpleado.getValueAt(fila, 6).toString());
                jDlg_CargarEmpleado.cmbProvincia.setSelectedItem(grillaEmpleado.getValueAt(fila, 7).toString());
                jDlg_CargarEmpleado.cmbCiudad.setSelectedItem(grillaEmpleado.getValueAt(fila, 8).toString());
                jDlg_CargarEmpleado.txtDireccion.setText(grillaEmpleado.getValueAt(fila, 9).toString());
                jDlg_CargarEmpleado.txtCodigopostal.setText(grillaEmpleado.getValueAt(fila, 10).toString());
//                jDlg_CargarEmpleado25.txtfechaingreso.setText(grillaEmpleado.getValueAt(fila, 11).toString());
//                jDlg_CargarEmpleado25.txtfechanacimiento1.setText(grillaEmpleado.getValueAt(fila, 12).toString());
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(grillaEmpleado.getValueAt(fila, 11).toString());
                jDlg_CargarEmpleado.jdc_fechaingreso.setDate(date);
              

                
                Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(grillaEmpleado.getValueAt(fila, 12).toString());
                jDlg_CargarEmpleado.jdc_fechanacimiento.setDate(date1);
                
                jDlg_CargarEmpleado.lb_codPer.setText(grillaEmpleado.getValueAt(fila, 13).toString());
                jDlg_CargarEmpleado.txt_empCBU.setText(grillaEmpleado.getValueAt(fila, 14).toString());
               
               
               
                
                
                dlg.setTitle("Modificar  Empleado");
                jDlg_CargarEmpleado.Modificar.setEnabled(true);
                jDlg_CargarEmpleado.Guardar_empleado.setEnabled(false);
                jDlg_CargarEmpleado.Nuevo.setEnabled(false);
                dlg.setVisible(true);
            }
            else {
                Mensajes.error("Seleccione una fila de la tabla");
            }

        }

        catch (Exception e) {
            Mensajes.error("");
        }
        
        cargar("error extraño");
        tabla(); 
    }//GEN-LAST:event_bto_ModificarActionPerformed

    private void rbtnCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnCodigoActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
              String cadena = (txtBuscar.getText()).toUpperCase();
        txtBuscar.setText(cadena);

        if(rbtnCodigo.isSelected()) {
            filtrarCodigo(txtBuscar.getText());
            tabla();
        }
        if(rbtnApellido.isSelected()) {
            filtrarApellido(txtBuscar.getText());
            tabla();
        }
        if(rbtnDni.isSelected()) {
            filtrarDni(txtBuscar.getText());
            tabla();
        }
               if(txtBuscar.getText().length()==0){
            cargar("");
            tabla();
        }  
    }//GEN-LAST:event_txtBuscarKeyReleased
       public void llamarReporteEmpleados() {
        GenerarReporte gr;
        gr = new GenerarReporte();
//        int codF = Integer.parseInt(dlgVentaRecibo.txtDocumentoVenta.getText());
        gr.MostrarReporte("src/Reportes/Empleados/Empleados.jasper", "Reporte Empleados");
        
    }
    private void bto_reporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_reporteActionPerformed
        llamarReporteEmpleados();
        
    }//GEN-LAST:event_bto_reporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoBotones;
    private javax.swing.JButton bto_Modificar;
    private javax.swing.JButton bto_Salir;
    private javax.swing.JButton bto_nuevo;
    private javax.swing.JButton bto_reporte;
    public static javax.swing.JTable grillaEmpleado;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jModificar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtnApellido;
    private javax.swing.JRadioButton rbtnCodigo;
    private javax.swing.JRadioButton rbtnDni;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
conectar cc= new conectar();
Connection cn= cc.conexion();
}
