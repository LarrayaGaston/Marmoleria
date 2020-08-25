package Gestionar_Proveedores;

import Gestionar_Cliente.*;
import Clases.Cliente;
import Componentes.GenerarReporte;

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luca
 */
public class iFDescripcionProveedor extends javax.swing.JInternalFrame {
 DefaultTableModel model;
    /**
     * Creates new form iFDescripcionClientes
     */
    public iFDescripcionProveedor() {
        initComponents();   
        cargar("");
        tablaproveedor();
       
   
    }
        
     void grupo()
    {
        GrupoBotones.add(rbtnCodigo);
        GrupoBotones.add(rbtnApellido);
        GrupoBotones.add(rbtnDni);
    }
               
      void tablaproveedor(){
        // Genera espacion entre las columnas  // Oculta las columnas
         grillaProveedor.getColumnModel().getColumn(16).setMaxWidth(0);
         grillaProveedor.getColumnModel().getColumn(16).setMinWidth(0);    
         grillaProveedor.getColumnModel().getColumn(16).setPreferredWidth(0);
         grillaProveedor.getColumnModel().getColumn(0).setPreferredWidth(60);
         grillaProveedor.getColumnModel().getColumn(1).setPreferredWidth(100);
         grillaProveedor.getColumnModel().getColumn(2).setPreferredWidth(100);
         grillaProveedor.getColumnModel().getColumn(3).setPreferredWidth(100);
         grillaProveedor.getColumnModel().getColumn(4).setPreferredWidth(100);
         grillaProveedor.getColumnModel().getColumn(5).setPreferredWidth(100);
         grillaProveedor.getColumnModel().getColumn(6).setPreferredWidth(100);
         grillaProveedor.getColumnModel().getColumn(7).setPreferredWidth(100);
         grillaProveedor.getColumnModel().getColumn(8).setPreferredWidth(100);
         grillaProveedor.getColumnModel().getColumn(9).setPreferredWidth(100);
         grillaProveedor.getColumnModel().getColumn(10).setPreferredWidth(100);
         grillaProveedor.getColumnModel().getColumn(11).setPreferredWidth(100);
         grillaProveedor.getColumnModel().getColumn(12).setPreferredWidth(100);
         grillaProveedor.getColumnModel().getColumn(13).setPreferredWidth(100);
         grillaProveedor.getColumnModel().getColumn(14).setPreferredWidth(60);
         grillaProveedor.getColumnModel().getColumn(15).setPreferredWidth(100);
         grillaProveedor.getColumnModel().getColumn(17).setPreferredWidth(250);
        
     }          
    
 // CARGA LA TABLA Clientes     
    void cargar(String valor) {
       // String mostrar = "Select * FROM (Clientes JOIN provincias ON ((clientes.cli_provincia = provincias.idprovincia))) JOIN ciudades ON ((clientes.cli_ciudad = ciudades.idciudad)) JOIN cond_iva ON ((clientes.cli_condiva = cond_iva.idcond)) ORDER BY (idCliente)";
        String mostrar = "Select * FROM (Proveedores JOIN cond_iva ON ((Proveedores.prov_condiva = cond_iva.idcond)))"
                + "JOIN provincias ON ((proveedores.prov_provincia = provincias.idprovincia)) "
                + "JOIN ciudades ON ((proveedores.prov_ciudad = ciudades.idciudad)) "
                + "JOIN persona ON ((persona.idpersona = proveedores.idpersona)) ORDER BY (idproveedor)";
       
        String clientes[] = {"CÓDIGO", "NOMBRE", "APELLIDO", "DNI", "RAZÓN SOCIAL", "IVA", "TELEFONO", "CELULAR", 
            "FAX", "CUIT","EMAIL","PROVINCIA","CIUDAD","DOMICILIO","CODIGO.P","FECHA DE NACIMIENTO","idPersona","CBU"};
        String[] Registros = new String[20];
        model = new DefaultTableModel(null, clientes);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
              

                
                
                
                
                Registros[0] = rs.getString("idProveedor");

                Registros[1] = rs.getString("persona.nombre");
                Registros[2] = rs.getString("persona.apellido");
                Registros[3] = rs.getString("persona.dni");

                Registros[4] = rs.getString("prov_razonsocial");
                Registros[5] = rs.getString("cond_iva.desccond");
                Registros[6] = rs.getString("prov_telefono");

                Registros[7] = rs.getString("prov_celular");
                Registros[8] = rs.getString("prov_fax");
                Registros[9] = rs.getString("prov_cuit");
                Registros[10] = rs.getString("prov_email");
                Registros[11] = rs.getString("provincias.descprovincia");
                Registros[12] = rs.getString("ciudades.descciudad");
                Registros[13] = rs.getString("prov_direccion");
                Registros[14] = rs.getString("prov_codpostal");

                Registros[15] = rs.getString("persona.fechanacimiento");
                Registros[16] = rs.getString("idPersona");
                Registros[17] = rs.getString("prov_CBU");


                //      
                model.addRow(Registros);
            }
            grillaProveedor.setModel(model);

        } catch (SQLException ex) {
            Logger.getLogger(iFDescripcionProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
       
    void filtrarCodigo(String valor) {
       // String mostrar = "Select * FROM (Clientes JOIN provincias ON ((clientes.cli_provincia = provincias.idprovincia))) JOIN ciudades ON ((clientes.cli_ciudad = ciudades.idciudad)) JOIN cond_iva ON ((clientes.cli_condiva = cond_iva.idcond)) ORDER BY (idCliente)";
        String mostrar = "Select * FROM (Proveedores JOIN cond_iva ON ((Proveedores.prov_condiva = cond_iva.idcond)))JOIN provincias ON ((proveedores.prov_provincia = provincias.idprovincia)) JOIN ciudades ON ((proveedores.prov_ciudad = ciudades.idciudad)) JOIN persona ON ((persona.idpersona = proveedores.idpersona)) WHERE (idproveedor) like '%"+valor+"%'";
       
         String clientes[] = {"CÓDIGO", "NOMBRE", "APELLIDO", "DNI", "RAZÓN SOCIAL", "IVA", "TELEFONO", "CELULAR", 
            "FAX", "CUIT","EMAIL","PROVINCIA","CIUDAD","DOMICILIO","CODIGO.P","FECHA DE NACIMIENTO","idPersona","CBU"};
        String[] Registros = new String[20];
        model = new DefaultTableModel(null, clientes);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
              

                
                
                
                
                Registros[0] = rs.getString("idProveedor");

                Registros[1] = rs.getString("persona.nombre");
                Registros[2] = rs.getString("persona.apellido");
                Registros[3] = rs.getString("persona.dni");

                Registros[4] = rs.getString("prov_razonsocial");
                Registros[5] = rs.getString("cond_iva.desccond");
                Registros[6] = rs.getString("prov_telefono");

                Registros[7] = rs.getString("prov_celular");
                Registros[8] = rs.getString("prov_fax");
                Registros[9] = rs.getString("prov_cuit");
                Registros[10] = rs.getString("prov_email");
                Registros[11] = rs.getString("provincias.descprovincia");
                Registros[12] = rs.getString("ciudades.descciudad");
                Registros[13] = rs.getString("prov_direccion");
                Registros[14] = rs.getString("prov_codpostal");

                Registros[15] = rs.getString("persona.fechanacimiento");
                Registros[16] = rs.getString("idPersona");
                Registros[17] = rs.getString("prov_CBU");


                //      
                model.addRow(Registros);
            }
           grillaProveedor.setModel(model);

        } catch (SQLException ex) {
            Logger.getLogger(iFDescripcionProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
       
    void filtrarDni(String valor) {
       // String mostrar = "Select * FROM (Clientes JOIN provincias ON ((clientes.cli_provincia = provincias.idprovincia))) JOIN ciudades ON ((clientes.cli_ciudad = ciudades.idciudad)) JOIN cond_iva ON ((clientes.cli_condiva = cond_iva.idcond)) ORDER BY (idCliente)";
        String mostrar = "Select * FROM (Proveedores JOIN cond_iva ON ((Proveedores.prov_condiva = cond_iva.idcond)))JOIN provincias ON ((proveedores.prov_provincia = provincias.idprovincia)) JOIN ciudades ON ((proveedores.prov_ciudad = ciudades.idciudad)) JOIN persona ON ((persona.idpersona = proveedores.idpersona)) WHERE (persona.dni) like '%"+valor+"%'";
       
        String clientes[] = {"CÓDIGO", "NOMBRE", "APELLIDO", "DNI", "RAZÓN SOCIAL", "IVA", "TELEFONO", "CELULAR", 
            "FAX", "CUIT","EMAIL","PROVINCIA","CIUDAD","DOMICILIO","CODIGO.P","FECHA DE NACIMIENTO","idPersona","CBU"};
        String[] Registros = new String[20];
        model = new DefaultTableModel(null, clientes);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
              

                
                
                
                
                Registros[0] = rs.getString("idProveedor");

                Registros[1] = rs.getString("persona.nombre");
                Registros[2] = rs.getString("persona.apellido");
                Registros[3] = rs.getString("persona.dni");

                Registros[4] = rs.getString("prov_razonsocial");
                Registros[5] = rs.getString("cond_iva.desccond");
                Registros[6] = rs.getString("prov_telefono");

                Registros[7] = rs.getString("prov_celular");
                Registros[8] = rs.getString("prov_fax");
                Registros[9] = rs.getString("prov_cuit");
                Registros[10] = rs.getString("prov_email");
                Registros[11] = rs.getString("provincias.descprovincia");
                Registros[12] = rs.getString("ciudades.descciudad");
                Registros[13] = rs.getString("prov_direccion");
                Registros[14] = rs.getString("prov_codpostal");

                Registros[15] = rs.getString("persona.fechanacimiento");
                Registros[16] = rs.getString("idPersona");
                Registros[17] = rs.getString("prov_CBU");


                //      
                model.addRow(Registros);
            }
            grillaProveedor.setModel(model);

        } catch (SQLException ex) {
            Logger.getLogger(iFDescripcionProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    // CARGA LA TABLA Clientes     
    void filtrarApellido(String valor) {
       // String mostrar = "Select * FROM (Clientes JOIN provincias ON ((clientes.cli_provincia = provincias.idprovincia))) JOIN ciudades ON ((clientes.cli_ciudad = ciudades.idciudad)) JOIN cond_iva ON ((clientes.cli_condiva = cond_iva.idcond)) ORDER BY (idCliente)";
        String mostrar = "Select * FROM (Proveedores JOIN cond_iva ON ((Proveedores.prov_condiva = cond_iva.idcond)))JOIN provincias ON ((proveedores.prov_provincia = provincias.idprovincia)) JOIN ciudades ON ((proveedores.prov_ciudad = ciudades.idciudad)) JOIN persona ON ((persona.idpersona = proveedores.idpersona)) WHERE (persona.apellido) like '%"+valor+"%'";
       
        String clientes[] = {"CÓDIGO", "NOMBRE", "APELLIDO", "DNI", "RAZÓN SOCIAL", "IVA", "TELEFONO", "CELULAR", 
            "FAX", "CUIT","EMAIL","PROVINCIA","CIUDAD","DOMICILIO","CODIGO.P","FECHA DE NACIMIENTO","idPersona","CBU"};
        String[] Registros = new String[20];
        model = new DefaultTableModel(null, clientes);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
              

                
                
                
                
                Registros[0] = rs.getString("idProveedor");

                Registros[1] = rs.getString("persona.nombre");
                Registros[2] = rs.getString("persona.apellido");
                Registros[3] = rs.getString("persona.dni");

                Registros[4] = rs.getString("prov_razonsocial");
                Registros[5] = rs.getString("cond_iva.desccond");
                Registros[6] = rs.getString("prov_telefono");

                Registros[7] = rs.getString("prov_celular");
                Registros[8] = rs.getString("prov_fax");
                Registros[9] = rs.getString("prov_cuit");
                Registros[10] = rs.getString("prov_email");
                Registros[11] = rs.getString("provincias.descprovincia");
                Registros[12] = rs.getString("ciudades.descciudad");
                Registros[13] = rs.getString("prov_direccion");
                Registros[14] = rs.getString("prov_codpostal");

                Registros[15] = rs.getString("persona.fechanacimiento");
                Registros[16] = rs.getString("idPersona");
                Registros[17] = rs.getString("prov_CBU");


                //      
                model.addRow(Registros);
            }
            grillaProveedor.setModel(model);

        } catch (SQLException ex) {
            Logger.getLogger(iFDescripcionProveedor.class.getName()).log(Level.SEVERE, null, ex);
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
        grillaProveedor = new javax.swing.JTable()
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
        grillaProveedor.setComponentPopupMenu(jPopupMenu2);
        grillaProveedor.setSelectionBackground(new java.awt.Color(255, 0, 0));
        jScrollPane1.setViewportView(grillaProveedor);

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
        bto_Modificar.setToolTipText("Modificar Proveedores");
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
        bto_nuevo.setToolTipText("Nuevo Proveedores");
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
                                .addComponent(bto_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, Short.MAX_VALUE)
                                .addGap(72, 72, 72)
                                .addComponent(bto_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, Short.MAX_VALUE)
                                .addGap(71, 71, 71)
                                .addComponent(bto_reporte, javax.swing.GroupLayout.PREFERRED_SIZE, 91, Short.MAX_VALUE)
                                .addGap(71, 71, 71)
                                .addComponent(bto_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 89, Short.MAX_VALUE))
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
              try {

             jDlg_CargarProveedor dlg = new jDlg_CargarProveedor(null, true);
          
            

            int fila= grillaProveedor.getSelectedRow();
            
            if(fila>=0)

            {
                
                jDlg_CargarProveedor.lblCodigoProveedor.setText(grillaProveedor.getValueAt(fila, 0).toString());
                jDlg_CargarProveedor.txt_Nombre_proveedor.setText(grillaProveedor.getValueAt(fila, 1).toString());
                jDlg_CargarProveedor.txt_apellido_proveedor.setText(grillaProveedor.getValueAt(fila, 2).toString()) ;
                jDlg_CargarProveedor.txtDni.setText(grillaProveedor.getValueAt(fila, 3).toString()) ;
                jDlg_CargarProveedor.txtRazonSocial.setText(grillaProveedor.getValueAt(fila, 4).toString()) ;
                jDlg_CargarProveedor.cmbIva.setSelectedItem(grillaProveedor.getValueAt(fila, 5).toString());
                
                jDlg_CargarProveedor.txtTelefono.setText(grillaProveedor.getValueAt(fila, 6).toString());
                jDlg_CargarProveedor.txtCelular.setText(grillaProveedor.getValueAt(fila, 7).toString());
                
                jDlg_CargarProveedor.txtFax.setText(grillaProveedor.getValueAt(fila, 8).toString());
                jDlg_CargarProveedor.txtcuit.setText(grillaProveedor.getValueAt(fila, 9).toString());
                jDlg_CargarProveedor.txtEmail.setText(grillaProveedor.getValueAt(fila, 10).toString());
                jDlg_CargarProveedor.cmbProvincia.setSelectedItem(grillaProveedor.getValueAt(fila, 11).toString());
                jDlg_CargarProveedor.cmbCiudad.setSelectedItem(grillaProveedor.getValueAt(fila, 12).toString());
                jDlg_CargarProveedor.txtDireccion.setText(grillaProveedor.getValueAt(fila, 13).toString());
                jDlg_CargarProveedor.txtCodigopostal.setText(grillaProveedor.getValueAt(fila, 14).toString());
//                jDlg_CargarProveedor.txtfechaprueba.setText(grillaProveedor.getValueAt(fila, 15).toString());
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(grillaProveedor.getValueAt(fila, 15).toString());
                jDlg_CargarProveedor.jdc_fechaNac.setDate(date);
                jDlg_CargarProveedor.lb_codPer.setText(grillaProveedor.getValueAt(fila, 16).toString());
                 jDlg_CargarProveedor.txt_provCBU.setText(grillaProveedor.getValueAt(fila, 17).toString());
               
               
               
                
                
                dlg.setTitle("Modificación de Proveedor");
                jDlg_CargarProveedor.Modificar.setEnabled(true);
                jDlg_CargarProveedor.Guardar_proveedor.setEnabled(false);
                jDlg_CargarProveedor.Nuevo.setEnabled(false);
                dlg.setVisible(true);
            }
            else {
                Mensajes.error("Seleccione una fila de la tabla");
            }

        }

        catch (Exception e) {
            Mensajes.error("");
        }
        
        cargar("");
        tablaproveedor();
     
      
    }//GEN-LAST:event_jModificarActionPerformed

    private void bto_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_SalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_bto_SalirActionPerformed

    private void bto_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_nuevoActionPerformed

        jDlg_CargarProveedor proveedor = new jDlg_CargarProveedor(null, true);
        proveedor.setLocationRelativeTo(null);
        proveedor.setTitle("Nuevo Proveedor");
        proveedor.setVisible(true);
        cargar("");
        tablaproveedor();
    }//GEN-LAST:event_bto_nuevoActionPerformed

    private void bto_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_ModificarActionPerformed

        try {

             jDlg_CargarProveedor dlg = new jDlg_CargarProveedor(null, true);
          
            

            int fila= grillaProveedor.getSelectedRow();
            
            if(fila>=0)

            {
                
                jDlg_CargarProveedor.lblCodigoProveedor.setText(grillaProveedor.getValueAt(fila, 0).toString());
                jDlg_CargarProveedor.txt_Nombre_proveedor.setText(grillaProveedor.getValueAt(fila, 1).toString());
                jDlg_CargarProveedor.txt_apellido_proveedor.setText(grillaProveedor.getValueAt(fila, 2).toString()) ;
                jDlg_CargarProveedor.txtDni.setText(grillaProveedor.getValueAt(fila, 3).toString()) ;
                jDlg_CargarProveedor.txtRazonSocial.setText(grillaProveedor.getValueAt(fila, 4).toString()) ;
                jDlg_CargarProveedor.cmbIva.setSelectedItem(grillaProveedor.getValueAt(fila, 5).toString());
                
                jDlg_CargarProveedor.txtTelefono.setText(grillaProveedor.getValueAt(fila, 6).toString());
                jDlg_CargarProveedor.txtCelular.setText(grillaProveedor.getValueAt(fila, 7).toString());
                
                jDlg_CargarProveedor.txtFax.setText(grillaProveedor.getValueAt(fila, 8).toString());
                jDlg_CargarProveedor.txtcuit.setText(grillaProveedor.getValueAt(fila, 9).toString());
                jDlg_CargarProveedor.txtEmail.setText(grillaProveedor.getValueAt(fila, 10).toString());
                jDlg_CargarProveedor.cmbProvincia.setSelectedItem(grillaProveedor.getValueAt(fila, 11).toString());
                jDlg_CargarProveedor.cmbCiudad.setSelectedItem(grillaProveedor.getValueAt(fila, 12).toString());
                jDlg_CargarProveedor.txtDireccion.setText(grillaProveedor.getValueAt(fila, 13).toString());
                jDlg_CargarProveedor.txtCodigopostal.setText(grillaProveedor.getValueAt(fila, 14).toString());
//                jDlg_CargarProveedor.txtfechaprueba.setText(grillaProveedor.getValueAt(fila, 15).toString());
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(grillaProveedor.getValueAt(fila, 15).toString());
                jDlg_CargarProveedor.jdc_fechaNac.setDate(date);
                jDlg_CargarProveedor.lb_codPer.setText(grillaProveedor.getValueAt(fila, 16).toString());
                 jDlg_CargarProveedor.txt_provCBU.setText(grillaProveedor.getValueAt(fila, 17).toString());
               
               
               
                
                
                dlg.setTitle("Modificación de Proveedor");
                jDlg_CargarProveedor.Modificar.setEnabled(true);
                jDlg_CargarProveedor.Guardar_proveedor.setEnabled(false);
                jDlg_CargarProveedor.Nuevo.setEnabled(false);
                dlg.setVisible(true);
            }
            else {
                Mensajes.error("Seleccione una fila de la tabla");
            }

        }

        catch (Exception e) {
            Mensajes.error("");
        }
        
        cargar("");
        tablaproveedor();
    }//GEN-LAST:event_bto_ModificarActionPerformed

    private void rbtnCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnCodigoActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased

        String cadena = (txtBuscar.getText()).toUpperCase();
        txtBuscar.setText(cadena);

        if(rbtnCodigo.isSelected()) {
            filtrarCodigo(txtBuscar.getText());
            tablaproveedor();
        }
        if(rbtnApellido.isSelected()) {
            filtrarApellido(txtBuscar.getText());
            tablaproveedor();
        }
        if(rbtnDni.isSelected()) {
            filtrarDni(txtBuscar.getText());
            tablaproveedor();
        }
               if(txtBuscar.getText().length()==0){
            cargar("");
            tablaproveedor();
        }  
    }//GEN-LAST:event_txtBuscarKeyReleased
    public void llamarReporteProve() {
        GenerarReporte gr;
        gr = new GenerarReporte();
//        int codF = Integer.parseInt(dlgVentaRecibo.txtDocumentoVenta.getText());
        gr.MostrarReporte("src/Reportes/Proveedores/Proveedores.jasper", "Reporte Proveedores");
        
    }
    private void bto_reporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_reporteActionPerformed
        llamarReporteProve();
        // TODO add your handling code here:
    }//GEN-LAST:event_bto_reporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoBotones;
    private javax.swing.JButton bto_Modificar;
    private javax.swing.JButton bto_Salir;
    private javax.swing.JButton bto_nuevo;
    private javax.swing.JButton bto_reporte;
    public static javax.swing.JTable grillaProveedor;
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
