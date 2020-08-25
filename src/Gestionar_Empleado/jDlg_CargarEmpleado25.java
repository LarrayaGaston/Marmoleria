/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestionar_Empleado;


import Clases.Empleado;
import Clases.Persona;
import Componentes.Fecha;
import Componentes.Mensajes;

import Metodos.CargarCombo;
import Metodos.Conectar;
import Metodos.buscarid;

import Gestionar_Empleado.gestionarEmpleado;

import Metodos.gestionarPersona;
import Metodos.validarCampos;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author luca
 */
public class jDlg_CargarEmpleado25 extends javax.swing.JDialog{

    /**
     * Creates new form jDlgGestionarCliente
     */
    
    
    
    public jDlg_CargarEmpleado25(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        idPersona();
        idEmpleado();
        comboprovincia();
        LookAndFeel();
        
    }
     Empleado mEmpleado = new Empleado();
     buscarid id = new buscarid();
     CargarCombo cargarcmb=new CargarCombo(); 
     validarCampos miValidar = new validarCampos();
     
           void limpiarCampos()
    {
        
        
        txt_Nombre_empleado.setText("");
        txt_apellido_empleado.setText("");
        txtTelefono.setText("");
        txtCelular.setText("");
        txtEmail.setText("");
        txtDni.setText("");
        txtCodigopostal.setText("");  
        txtfechaingreso.setText("");
        txtfechanacimiento1.setText("");
    }
        
        
    void bloquear() {
        // txtcod.setEnabled(false);
        dcFechaIngresi.setEnabled(false);
        txtfechaingreso.setEnabled(false);
        txtfechanacimiento1.setEnabled(false);
        txt_Nombre_empleado.setEnabled(false);
        txt_apellido_empleado.setEnabled(false);
        txtCelular.setEnabled(false);       
        txtDireccion.setEnabled(false);
        txtDni.setEnabled(false);
        cmbProvincia.setEnabled(false);
        cmbCiudad.setEnabled(false);
        Guardar_empleado.setEnabled(false);
        Modificar.setEnabled(false);
        Nuevo.setEnabled(true);
        Salir.setEnabled(true);
        txtTelefono.setEnabled(false);
        txtCodigopostal.setEnabled(false);
        txtEmail.setEnabled(false);

    }
    
    void desbloquear() {
        dcFechaIngresi.setEnabled(true);
        txtfechaingreso.setEnabled(true);
        txtfechanacimiento1.setEnabled(true);
        txt_Nombre_empleado.setEnabled(true);
        txt_apellido_empleado.setEnabled(true);
        txtDireccion.setEnabled(true);
               txtDni.setEnabled(true);
        cmbProvincia.setEnabled(true);
        cmbCiudad.setEnabled(true);
        Guardar_empleado.setEnabled(true);
        Nuevo.setEnabled(true);
        Salir.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtEmail.setEnabled(true);
        txtCodigopostal.setEnabled(true);
        Modificar.setEnabled(false);
    }
      

    String tema = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
    
     public void LookAndFeel() {
        //Look And Feel
        System.setProperty(
                "Quaqua.tabLayoutPolicy", "wrap"
        );
        try {
            UIManager.setLookAndFeel(tema);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception erro) {
            Mensajes.informacion("Error al cargar el tema");
        }
    }
      
            void comboprovincia(){
                           // carga provincia
         String cons="Select descprovincia from provincias";
         cargarcmb.cargacombo(cmbProvincia, cons);
         cmbProvincia.setSelectedIndex(-1);
         // carga condicion de iva
                }
       
    void idPersona(){
                   try{
            String dato [] = new String [1];
            Conectar miconexion = new Conectar();
            String consultasql = "select max(idPersona)+1 from persona";
            ResultSet rs = miconexion.consulta(consultasql);  
            
            while(rs.next()){       //recorre el resultset mientras tenga algun dato
                for (int j=0; j<dato.length; j++){  //RECORRE HORINZONTALMENTE
                    dato[j]= rs.getString(j+1);
                }
                lb_codPer.setText(rs.getString(1));
                
                     
       // en caso de ser el primer articulo que vamos a cargar, se fija que la table este vacia y genera el 1
       //como id principal, en el caso contrario busca el ultimo y le suma 1
             if(rs.getString(1)==null){
             lb_codPer.setText("1");
            }
            else{
             /*
                 j=Integer.parseInt(c);
                 GenerarNumero gen= new GenerarNumero();
                 gen.generar(j);
                 txtid.setText(gen.serie());
                
            */
            }
                
                           }   
        }
         catch(Exception e){
           //e.toString() es para que te mustre el error si lo tenes 
           JOptionPane.showMessageDialog(null, e.toString()); 
        }
       }
    void idEmpleado(){
                   try{
            String dato [] = new String [1];
            Conectar miconexion = new Conectar();
            String consultasql = "select max(idEmpleado)+1 from Empleados";
            ResultSet rs = miconexion.consulta(consultasql);  
            
            while(rs.next()){       //recorre el resultset mientras tenga algun dato
                for (int j=0; j<dato.length; j++){  //RECORRE HORINZONTALMENTE
                    dato[j]= rs.getString(j+1);
                }
                lblCodigoEmpleado.setText(rs.getString(1));
                
                     
       // en caso de ser el primer articulo que vamos a cargar, se fija que la table este vacia y genera el 1
       //como id principal, en el caso contrario busca el ultimo y le suma 1
             if(rs.getString(1)==null){
             lblCodigoEmpleado.setText("1");
            }
            else{
             /*
                 j=Integer.parseInt(c);
                 GenerarNumero gen= new GenerarNumero();
                 gen.generar(j);
                 txtid.setText(gen.serie());
                
            */
            }
                
                           }   
        }
         catch(Exception e){
           //e.toString() es para que te mustre el error si lo tenes 
           JOptionPane.showMessageDialog(null, e.toString()); 
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        cmbProvincia = new javax.swing.JComboBox();
        cmbCiudad = new javax.swing.JComboBox();
        txtTelefono = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        txt_apellido_empleado = new javax.swing.JTextField();
        txtCodigopostal = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtfechaingreso = new javax.swing.JTextField();
        dcFechaIngresi = new datechooser.beans.DateChooserCombo();
        EnviarEmail = new javax.swing.JButton();
        lblCodigoEmpleado = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        txt_empCBU = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_Nombre_empleado = new javax.swing.JTextField();
        txtfechanacimiento1 = new javax.swing.JTextField();
        dcFechanacimiento = new datechooser.beans.DateChooserCombo();
        jLabel21 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lb_codPer = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Modificar = new javax.swing.JButton();
        Nuevo = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        Guardar_empleado = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Código :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Apellido :");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Dirección :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("DNI :");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Provincia :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Teléfono :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Ciudad:");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, 20));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Celular :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, -1, 20));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("E- Mail :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        txtDireccion.setText("jujuy 456");
        jPanel2.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 305, -1));

        txtDni.setText("3562145");
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDniKeyPressed(evt);
            }
        });
        jPanel2.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 128, -1));

        cmbProvincia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProvincia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbProvinciaItemStateChanged(evt);
            }
        });
        jPanel2.add(cmbProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 150, -1));

        cmbCiudad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cmbCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 150, -1));

        txtTelefono.setText("65652323");
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyPressed(evt);
            }
        });
        jPanel2.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 157, -1));

        txtCelular.setText("322365659");
        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCelularKeyPressed(evt);
            }
        });
        jPanel2.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 180, -1));

        txt_apellido_empleado.setText("larraya");
        txt_apellido_empleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_apellido_empleadoKeyPressed(evt);
            }
        });
        jPanel2.add(txt_apellido_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, 180, -1));

        txtCodigopostal.setText("5641");
        txtCodigopostal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigopostalKeyPressed(evt);
            }
        });
        jPanel2.add(txtCodigopostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 120, -1));

        txtEmail.setText("asdfasfdasdfasd@adfsadfasd.com");
        jPanel2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 313, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("C.P:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, -1, 20));

        txtfechaingreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechaingresoActionPerformed(evt);
            }
        });
        jPanel2.add(txtfechaingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 110, -1));

        dcFechaIngresi.setCalendarPreferredSize(new java.awt.Dimension(257, 187));
        dcFechaIngresi.setWeekStyle(datechooser.view.WeekDaysStyle.SHORT);
        dcFechaIngresi.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dcFechaIngresiOnCommit(evt);
            }
        });
        jPanel2.add(dcFechaIngresi, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 20, 20));

        EnviarEmail.setText("jButton2");
        jPanel2.add(EnviarEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, 30, 20));

        lblCodigoEmpleado.setBackground(new java.awt.Color(255, 102, 204));
        lblCodigoEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lblCodigoEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 54, 20));

        Nombre.setForeground(new java.awt.Color(255, 255, 255));
        Nombre.setText("Nombre :");
        jPanel2.add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        txt_empCBU.setText("2850590940090418135201");
        txt_empCBU.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_empCBUKeyPressed(evt);
            }
        });
        jPanel2.add(txt_empCBU, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 160, 20));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("CBU:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, -1, 20));

        txt_Nombre_empleado.setText("matias");
        txt_Nombre_empleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_Nombre_empleadoKeyPressed(evt);
            }
        });
        jPanel2.add(txt_Nombre_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 157, -1));

        txtfechanacimiento1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfechanacimiento1ActionPerformed(evt);
            }
        });
        jPanel2.add(txtfechanacimiento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 110, -1));

        dcFechanacimiento.setCalendarPreferredSize(new java.awt.Dimension(257, 187));
        dcFechanacimiento.setWeekStyle(datechooser.view.WeekDaysStyle.SHORT);
        dcFechanacimiento.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dcFechanacimientoOnCommit(evt);
            }
        });
        jPanel2.add(dcFechanacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, 20, 20));

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Fecha de  Ingreso:");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 110, 20));

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Fecha de \nNacimiento:");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 110, 20));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_ABM/orig_60533_1.jpg"))); // NOI18N
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 310));

        lb_codPer.setText("jLabel1");
        jPanel2.add(lb_codPer, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 20, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 710, 310));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imag_inicio/IMG-20180911-WA0027 - copia_opt_1.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, -1, -1));

        Modificar.setText("Modificar");
        Modificar.setEnabled(false);
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });
        getContentPane().add(Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 520, -1, 40));

        Nuevo.setText("Nuevo");
        Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoActionPerformed(evt);
            }
        });
        getContentPane().add(Nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 520, 100, 40));

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        getContentPane().add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 520, 100, 40));

        Guardar_empleado.setText("Guardar");
        Guardar_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guardar_empleadoActionPerformed(evt);
            }
        });
        getContentPane().add(Guardar_empleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 520, 100, 40));

        jLabel10.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel10.setText("Empleado:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_ABM/arabescato.jpg"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, 730, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbProvinciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbProvinciaItemStateChanged
        int idprov = id.buscarid("idprovincia", "provincias", "descprovincia", String.valueOf(cmbProvincia.getSelectedItem()));
        String consp = "Select descciudad from ciudades where idprovincia like '" + idprov + "'";
        cargarcmb.cargacombo(cmbCiudad, consp);
        cmbCiudad.setSelectedIndex(-1);
    }//GEN-LAST:event_cmbProvinciaItemStateChanged

    private void Guardar_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guardar_empleadoActionPerformed
     // METODO GUARDAR
       gestionarEmpleado guardar = new gestionarEmpleado();
        gestionarPersona guardarP = new gestionarPersona();
      
      if(txtDni.getText().isEmpty() )                                                                                                   //VALIDACIONES
       { 
           JOptionPane.showMessageDialog(null,"Igrese DNI ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
        if(txt_Nombre_empleado.getText().isEmpty() )                                                                                                   //VALIDACIONES
       { 
           JOptionPane.showMessageDialog(null,"Igrese NOMBRE ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
        
            if(txt_apellido_empleado.getText().isEmpty() )                                                                                                   //VALIDACIONES
       { 
           JOptionPane.showMessageDialog(null,"Igrese APELLIDO ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
       else if(cmbProvincia.getSelectedIndex()==-1)
        {
            JOptionPane.showMessageDialog(null," SELECCIONE PROVINCIA ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
        }
       
       else  if(cmbCiudad.getSelectedIndex()==-1)
        {
            JOptionPane.showMessageDialog(null,"SELECCIONE CIUDAD ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
        }
      
          
       else if(txtCelular.getText().isEmpty() ) 
       { 
           JOptionPane.showMessageDialog(null,"Igrese CELULAR ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
       else if(txtTelefono.getText().isEmpty() ) 
       { 
           JOptionPane.showMessageDialog(null,"Igrese TELEFONO ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
             else if(txtCodigopostal.getText().isEmpty() ) 
       { 
           JOptionPane.showMessageDialog(null,"Igrese CODIGO POSTAL ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
       
        else if(txtDireccion.getText().isEmpty() ) 
       { 
           JOptionPane.showMessageDialog(null,"Ingrese DIRECCION ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
            else if(txtEmail.getText().isEmpty() ) 
       { 
           JOptionPane.showMessageDialog(null,"Igrese EMAIL ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
       }
       
   {
       
     Persona mPersona = new Persona();
      
      mEmpleado.setIdEmpleado(Integer.parseInt(lblCodigoEmpleado.getText()));
      mPersona.setNombre((txt_Nombre_empleado.getText().toUpperCase()));
      mPersona.setApellido((txt_apellido_empleado.getText().toUpperCase()));
      mEmpleado.setEmp_codPostal(Integer.parseInt(txtCodigopostal.getText()));
      mPersona.setDni(Integer.parseInt(txtDni.getText()));
     
      mEmpleado.setEmp_direccion(txtDireccion.getText().toUpperCase());
      mEmpleado.setEmp_email(txtEmail.getText().toUpperCase());
      mEmpleado.setEmp_celular((txtCelular.getText()));
    
      mEmpleado.setEmp_telefono((txtTelefono.getText()));
     
       mEmpleado.setIdPersona(Integer.parseInt(lb_codPer.getText()));
       
        mPersona.setFechaNacimiento(txtfechanacimiento1.getText());
       mEmpleado.setEmp_fecha_ingreso(txtfechaingreso.getText());
       mEmpleado.setEmp_CBU(txt_empCBU.getText());
    
      
    /**  int año = fecha_calendario.getCalendar().get(Calendar.YEAR);
      int mes = fecha_calendario.getCalendar().get(Calendar.MONTH);
      int dias = fecha_calendario.getCalendar().get(Calendar.DAY_OF_MONTH);
     
      //int horas = fecha_calendario.getCalendar().get(Calendar.HOUR_OF_DAY);
      //int min = fecha_calendario.getCalendar().get(Calendar.MINUTE);
     // int seg = fecha_calendario.getCalendar().get(Calendar.SECOND);
     
      String fecha;
      fecha = dias+"/"+mes+"/"+año; //+" - "+horas+";"+min+";"+seg;
      JOptionPane.showMessageDialog(null,(fecha));
      mEmpleado.setEmp_fecha_nacimiento(fecha);
      
      int año1 = fecha_calendario_ingreso.getCalendar().get(Calendar.YEAR);
      int mes1 = fecha_calendario_ingreso.getCalendar().get(Calendar.MONTH);
      int dias1 = fecha_calendario_ingreso.getCalendar().get(Calendar.DAY_OF_MONTH);
     // int horas1= fecha_calendario_ingreso.getCalendar().get(Calendar.HOUR_OF_DAY);
     // int min1 = fecha_calendario_ingreso.getCalendar().get(Calendar.MINUTE);
    //  int seg1 = fecha_calendario_ingreso.getCalendar().get(Calendar.SECOND);
     
      String fecha2;
      fecha2 = dias1+"/"+mes1+"/"+año1; //" - "+horas+";"+min+";"+seg;
      JOptionPane.showMessageDialog(null,(fecha2));
      mEmpleado.setEmp_fecha_ingreso(fecha2);
      /**
       String fecha = dF.format(fecha_calendario.getDate());
        */
      /**
      Date fecha= fecha_calendario.getDate();
       long tiempo = fecha.getTime();
       Date fechaFinal = new Date(tiempo);
       miPersona.setFechaNacimiento(fechaFinal.toString());
       */
      
      
     
      
       int idprovincia = id.buscarid("idprovincia", "provincias", "descprovincia", String.valueOf(cmbProvincia.getSelectedItem()));
       mEmpleado.setEmp_Provincia(idprovincia);
     
       int idciudad = id.buscarid("idciudad", "ciudades", "descciudad", String.valueOf(cmbCiudad.getSelectedItem()));
       mEmpleado.setEmp_Ciudad(idciudad);
     
   
     
     //  int idrubro = id.buscarid("rub_codigo", "rubro", "rub_nombre", String.valueOf(cmbrubro.getSelectedItem()));
     //  mCliente.setCodRubro(idrubro);
       
       guardar.GuardarEmpleado(mEmpleado);
       guardarP.GuardarPersona(mPersona);
     
 

      
       Mensajes.informacion("Empleado Registrado");
        
          bloquear(); 
        limpiarCampos();
        
       
    }
       
     
    }//GEN-LAST:event_Guardar_empleadoActionPerformed

    private void txt_Nombre_empleadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Nombre_empleadoKeyPressed
       validarCampos.soloLetras(txt_Nombre_empleado);
    }//GEN-LAST:event_txt_Nombre_empleadoKeyPressed

    private void txt_apellido_empleadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellido_empleadoKeyPressed

        validarCampos.soloLetras(txt_apellido_empleado);
    }//GEN-LAST:event_txt_apellido_empleadoKeyPressed

    private void txtDniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyPressed

       validarCampos.soloNumeros(txtDni);
    }//GEN-LAST:event_txtDniKeyPressed

    private void txtTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyPressed

        validarCampos.soloNumeros(txtTelefono);
    }//GEN-LAST:event_txtTelefonoKeyPressed

    private void txtCelularKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyPressed

      validarCampos.soloNumeros(txtCelular);
    }//GEN-LAST:event_txtCelularKeyPressed

    private void txtCodigopostalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigopostalKeyPressed
       validarCampos.soloNumeros(txtCodigopostal);

    }//GEN-LAST:event_txtCodigopostalKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

       
    }//GEN-LAST:event_formWindowOpened

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        // METODO GUARDAR
        gestionarEmpleado modEmpleado = new gestionarEmpleado();
        gestionarPersona modificaPersona = new gestionarPersona();
        Persona mipersona = new Persona();

        if(txtDni.getText().isEmpty() )                                                                                                   //VALIDACIONES
        {
            JOptionPane.showMessageDialog(null,"Igrese DNI ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);

        }
        if(txt_Nombre_empleado.getText().isEmpty() )                                                                                                   //VALIDACIONES
        {
            JOptionPane.showMessageDialog(null,"Igrese NOMBRE ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);

        }

        if(txt_apellido_empleado.getText().isEmpty() )                                                                                                   //VALIDACIONES
        {
            JOptionPane.showMessageDialog(null,"Igrese APELLIDO ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);

        }
        else if(cmbProvincia.getSelectedIndex()==-1)
        {
            JOptionPane.showMessageDialog(null," SELECCIONE PROVINCIA ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
        }

        else  if(cmbCiudad.getSelectedIndex()==-1)
        {
            JOptionPane.showMessageDialog(null,"SELECCIONE CIUDAD ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
        }

      
        else if(txtCelular.getText().isEmpty() )
        {
            JOptionPane.showMessageDialog(null,"Igrese CELULAR ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);

        }
        else if(txtTelefono.getText().isEmpty() )
        {
            JOptionPane.showMessageDialog(null,"Igrese TELEFONO ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);

        }
        else if(txtCodigopostal.getText().isEmpty() )
        {
            JOptionPane.showMessageDialog(null,"Igrese CODIGO POSTAL ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);

        }
     
        else if(txtDireccion.getText().isEmpty() )
        {
            JOptionPane.showMessageDialog(null,"Ingrese DIRECCION ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);

        }
        else if(txtEmail.getText().isEmpty() )
        {
            JOptionPane.showMessageDialog(null,"Igrese EMAIL ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);

        }
    
        
     
     
        

            mEmpleado.setIdEmpleado(Integer.parseInt(lblCodigoEmpleado.getText()));
            mipersona.setNombre((txt_Nombre_empleado.getText().toUpperCase()));
            mipersona.setApellido((txt_apellido_empleado.getText().toUpperCase()));
            mipersona.setDni(Integer.parseInt(txtDni.getText()));
            mEmpleado.setEmp_telefono((txtTelefono.getText()));
            mEmpleado.setEmp_celular((txtCelular.getText()));
            mEmpleado.setEmp_email(txtEmail.getText().toUpperCase());
            mEmpleado.setEmp_direccion(txtDireccion.getText().toUpperCase());
            mEmpleado.setEmp_codPostal(Integer.parseInt(txtCodigopostal.getText()));
            mEmpleado.setEmp_fecha_ingreso(txtfechaingreso.getText());
            mipersona.setFechaNacimiento(txtfechanacimiento1.getText());
            mEmpleado.setEmp_CBU(txt_empCBU.getText());

           
            

            mEmpleado.setIdPersona(Integer.parseInt(lb_codPer.getText()));
            mipersona.setIdPersona(Integer.parseInt(lb_codPer.getText()));

            int idprovincia = id.buscarid("idprovincia", "provincias", "descprovincia", String.valueOf(cmbProvincia.getSelectedItem()));
            mEmpleado.setEmp_Provincia(idprovincia);

            int idciudad = id.buscarid("idciudad", "ciudades", "descciudad", String.valueOf(cmbCiudad.getSelectedItem()));
            mEmpleado.setEmp_Ciudad(idciudad);

        

            // modCliente.modificarCliente(mCliente);
            modificaPersona.modificarPersona(mipersona);
            modEmpleado.modEmpleado(mEmpleado);

            Mensajes.informacion("Empleado Modificado");
            this.dispose();
          bloquear();
        limpiarCampos();

        



    }//GEN-LAST:event_ModificarActionPerformed

    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoActionPerformed
        idPersona();
        desbloquear();
        limpiarCampos();
    }//GEN-LAST:event_NuevoActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_SalirActionPerformed

    private void dcFechaIngresiOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dcFechaIngresiOnCommit
        // TODO add your handling code here:
        String fecha = dcFechaIngresi.getText();
        String fechas = Fecha.formatoFecha(fecha);
        txtfechaingreso.setText(fechas);
    }//GEN-LAST:event_dcFechaIngresiOnCommit

    private void txtfechanacimiento1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechanacimiento1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfechanacimiento1ActionPerformed

    private void dcFechanacimientoOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dcFechanacimientoOnCommit
                String fecha = dcFechanacimiento.getText();
        String fechas = Fecha.formatoFecha(fecha);
        txtfechanacimiento1.setText(fechas);
    }//GEN-LAST:event_dcFechanacimientoOnCommit

    private void txtfechaingresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfechaingresoActionPerformed

            String fecha = dcFechaIngresi.getText();
        String fechas = Fecha.formatoFecha(fecha);
       txtfechaingreso.setText(fechas);
    }//GEN-LAST:event_txtfechaingresoActionPerformed

    private void txt_empCBUKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_empCBUKeyPressed
        validarCampos.soloNumeros(txt_empCBU);
    }//GEN-LAST:event_txt_empCBUKeyPressed
    

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
            java.util.logging.Logger.getLogger(jDlg_CargarEmpleado25.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jDlg_CargarEmpleado25.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jDlg_CargarEmpleado25.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jDlg_CargarEmpleado25.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jDlg_CargarEmpleado25 dialog = new jDlg_CargarEmpleado25(new javax.swing.JFrame(), true);
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
    public static javax.swing.JButton EnviarEmail;
    public static javax.swing.JButton Guardar_empleado;
    public static javax.swing.JButton Modificar;
    public static javax.swing.JLabel Nombre;
    public static javax.swing.JButton Nuevo;
    public static javax.swing.JButton Salir;
    public static javax.swing.JComboBox cmbCiudad;
    public static javax.swing.JComboBox cmbProvincia;
    public static datechooser.beans.DateChooserCombo dcFechaIngresi;
    public static datechooser.beans.DateChooserCombo dcFechanacimiento;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel11;
    public static javax.swing.JLabel jLabel12;
    public static javax.swing.JLabel jLabel13;
    public static javax.swing.JLabel jLabel17;
    public static javax.swing.JLabel jLabel18;
    public static javax.swing.JLabel jLabel19;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel20;
    public static javax.swing.JLabel jLabel21;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabel9;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JLabel lb_codPer;
    public static javax.swing.JLabel lblCodigoEmpleado;
    public static javax.swing.JTextField txtCelular;
    public static javax.swing.JTextField txtCodigopostal;
    public static javax.swing.JTextField txtDireccion;
    public static javax.swing.JTextField txtDni;
    public static javax.swing.JTextField txtEmail;
    public static javax.swing.JTextField txtTelefono;
    public static javax.swing.JTextField txt_Nombre_empleado;
    public static javax.swing.JTextField txt_apellido_empleado;
    public static javax.swing.JTextField txt_empCBU;
    public static javax.swing.JTextField txtfechaingreso;
    public static javax.swing.JTextField txtfechanacimiento1;
    // End of variables declaration//GEN-END:variables
}
