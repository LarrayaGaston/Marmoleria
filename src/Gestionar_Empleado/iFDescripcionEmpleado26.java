/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestionar_Empleado;

import Gestionar_Empleado.jDlg_CargarEmpleado25;
import Componentes.Mensajes;
import Componentes.conectar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luca
 */
public class iFDescripcionEmpleado26 extends javax.swing.JInternalFrame {
 DefaultTableModel model;

    /**
     * Creates new form iFDescripcionEmpleado
     */
    public iFDescripcionEmpleado26() {
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
        jPopupMenu1 = new javax.swing.JPopupMenu();
        Jmodificar = new javax.swing.JMenuItem();
        Nuevo = new javax.swing.JButton();
        Modificar = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        Salir1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        rbtnCodigo = new javax.swing.JRadioButton();
        rbtnDni = new javax.swing.JRadioButton();
        rbtnApellido = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        grillaEmpleado = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };

        Jmodificar.setText("MODIFICAR");
        Jmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmodificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Jmodificar);

        setBackground(new java.awt.Color(153, 153, 153));
        setForeground(new java.awt.Color(102, 102, 102));
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(868, 563));

        Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-editar_opt.png"))); // NOI18N
        Nuevo.setToolTipText("Registrar Nuevo Cliente");
        Nuevo.setBorderPainted(false);
        Nuevo.setContentAreaFilled(false);
        Nuevo.setFocusPainted(false);
        Nuevo.setFocusable(false);
        Nuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Nuevo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-editar_opt (1).png"))); // NOI18N
        Nuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoActionPerformed(evt);
            }
        });

        Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-actualizar_opt.png"))); // NOI18N
        Modificar.setToolTipText("Modificar Cliente");
        Modificar.setBorderPainted(false);
        Modificar.setContentAreaFilled(false);
        Modificar.setFocusPainted(false);
        Modificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Modificar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-actualizar_opt (1).png"))); // NOI18N
        Modificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });

        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-reporte_opt.png"))); // NOI18N
        Salir.setToolTipText("Reporte Clientes");
        Salir.setBorderPainted(false);
        Salir.setContentAreaFilled(false);
        Salir.setFocusPainted(false);
        Salir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Salir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-reporte_opt (1).png"))); // NOI18N
        Salir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        Salir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-atras_opt.png"))); // NOI18N
        Salir1.setToolTipText("Salir");
        Salir1.setBorderPainted(false);
        Salir1.setContentAreaFilled(false);
        Salir1.setFocusPainted(false);
        Salir1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Salir1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-atras_opt (1).png"))); // NOI18N
        Salir1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Salir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Salir1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Buscar por :");

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

        GrupoBotones.add(rbtnCodigo);
        rbtnCodigo.setText("Codigo");
        rbtnCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnCodigoActionPerformed(evt);
            }
        });

        GrupoBotones.add(rbtnDni);
        rbtnDni.setText("Dni");
        rbtnDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnDniActionPerformed(evt);
            }
        });

        GrupoBotones.add(rbtnApellido);
        rbtnApellido.setText("Apellido");
        rbtnApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnApellidoActionPerformed(evt);
            }
        });

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
        grillaEmpleado.setComponentPopupMenu(jPopupMenu1);
        grillaEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grillaEmpleadoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                grillaEmpleadoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(grillaEmpleado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(rbtnCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnDni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnApellido)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(Nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Modificar, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Salir, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Salir1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtnCodigo)
                            .addComponent(rbtnDni)
                            .addComponent(rbtnApellido)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Salir1, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(Salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoActionPerformed
        jDlg_CargarEmpleado proveedor = new jDlg_CargarEmpleado(null, true);
        proveedor.setLocationRelativeTo(null);
        proveedor.setTitle("Nuevo Empleado");
        proveedor.setVisible(true);
        cargar("");
        tabla();
    }//GEN-LAST:event_NuevoActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
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
      
    }//GEN-LAST:event_ModificarActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed

    }//GEN-LAST:event_SalirActionPerformed

    private void Salir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Salir1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_Salir1ActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

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

    private void rbtnCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnCodigoActionPerformed

    private void rbtnDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnDniActionPerformed

    private void rbtnApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnApellidoActionPerformed

    private void grillaEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grillaEmpleadoMouseClicked

    }//GEN-LAST:event_grillaEmpleadoMouseClicked

    private void grillaEmpleadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grillaEmpleadoMousePressed

    }//GEN-LAST:event_grillaEmpleadoMousePressed

    private void JmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmodificarActionPerformed
        try 
           {
        
        jDlg_CargarEmpleado dlg = new jDlg_CargarEmpleado(null, true);
        
              int fila= grillaEmpleado.getSelectedRow();
            
            if(fila>=0)

            {
            jDlg_CargarEmpleado25.lblCodigoEmpleado.setText(grillaEmpleado.getValueAt(fila, 0).toString());
                jDlg_CargarEmpleado25.txt_Nombre_empleado.setText(grillaEmpleado.getValueAt(fila, 1).toString());
                jDlg_CargarEmpleado25.txt_apellido_empleado.setText(grillaEmpleado.getValueAt(fila, 2).toString()) ;
                jDlg_CargarEmpleado25.txtDni.setText(grillaEmpleado.getValueAt(fila, 3).toString()) ;
               
                
                jDlg_CargarEmpleado25.txtTelefono.setText(grillaEmpleado.getValueAt(fila, 4).toString());
                jDlg_CargarEmpleado25.txtCelular.setText(grillaEmpleado.getValueAt(fila, 5).toString());
                

                jDlg_CargarEmpleado25.txtEmail.setText(grillaEmpleado.getValueAt(fila, 6).toString());
                jDlg_CargarEmpleado25.cmbProvincia.setSelectedItem(grillaEmpleado.getValueAt(fila, 7).toString());
                jDlg_CargarEmpleado25.cmbCiudad.setSelectedItem(grillaEmpleado.getValueAt(fila, 8).toString());
                jDlg_CargarEmpleado25.txtDireccion.setText(grillaEmpleado.getValueAt(fila, 9).toString());
                jDlg_CargarEmpleado25.txtCodigopostal.setText(grillaEmpleado.getValueAt(fila, 10).toString());
//                jDlg_CargarEmpleado25.txtfechaingreso.setText(grillaEmpleado.getValueAt(fila, 11).toString());
//                jDlg_CargarEmpleado25.txtfechanacimiento1.setText(grillaEmpleado.getValueAt(fila, 12).toString());
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(grillaEmpleado.getValueAt(fila, 11).toString());
                jDlg_CargarEmpleado.jdc_fechaingreso.setDate(date);
              

                
                Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(grillaEmpleado.getValueAt(fila, 12).toString());
                jDlg_CargarEmpleado.jdc_fechanacimiento.setDate(date1);
                
                jDlg_CargarEmpleado25.lb_codPer.setText(grillaEmpleado.getValueAt(fila, 13).toString());
                jDlg_CargarEmpleado25.txt_empCBU.setText(grillaEmpleado.getValueAt(fila, 14).toString());
               
               
               
                
                
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
        tabla();        // TODO add your handling code here:
    }//GEN-LAST:event_JmodificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoBotones;
    private javax.swing.JMenuItem Jmodificar;
    private javax.swing.JButton Modificar;
    private javax.swing.JButton Nuevo;
    private javax.swing.JButton Salir;
    private javax.swing.JButton Salir1;
    public static javax.swing.JTable grillaEmpleado;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtnApellido;
    private javax.swing.JRadioButton rbtnCodigo;
    private javax.swing.JRadioButton rbtnDni;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
conectar cc= new conectar();
Connection cn= cc.conexion();
}
