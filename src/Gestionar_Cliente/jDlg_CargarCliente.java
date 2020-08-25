/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestionar_Cientes;

import Clases.Cliente;
import Clases.Persona;
import Componentes.Fecha;
import Componentes.Mensajes;
import Gestionar_Cliente.gestionarCliente;


import Metodos.CargarCombo;
import Metodos.Conectar;
import Metodos.buscarid;

import Metodos.gestionarPersona;
import Metodos.validarCampos;
import datechooser.beans.DateChooserCombo; 
import java.awt.Desktop;
import java.awt.MouseInfo;
import java.awt.Point;
import java.net.URI;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


/**
 *
 * @author luca
 */
public class jDlg_CargarCliente extends javax.swing.JDialog{

    /**
     * Creates new form jDlgGestionarCliente
     */
    
    
    
    public jDlg_CargarCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
       
        idP();
        idcli();
        combocondIva();
        comboprovincia();
        
        setTitle("Nuevo Cliente");//1
         this.setLocationRelativeTo(null);
        LookAndFeel();
        
    }
   
    private int x;
    private int y;
    
     Cliente mCliente = new Cliente();
     Persona miPersona = new Persona();
     buscarid id = new buscarid();
     CargarCombo cargarcmb=new CargarCombo(); 
     validarCampos miValidar = new validarCampos();
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
    
    @Override
        public void setTitle(String title) {
             super.setTitle(title);
                lb_titulo.setText(title);
    }
        void limpiarCampos()
    {
        txtRazonSocial.setText("");
        txtcuit.setText("");
        txt_Nombre_cliente.setText("");
        txt_apellido_cliente.setText("");
        txtTelefono.setText("");
        txtFax.setText("");
        txtCelular.setText("");
        txtEmail.setText("");
        txtDni.setText("");
        txtCodigopostal.setText("");  
        
    }
        
        
    void bloquear() {
        // txtcod.setEnabled(false);
        jd_fechaNac.setEnabled(false);
//        txtfechaprueba.setEnabled(false);
        txt_Nombre_cliente.setEnabled(false);
        txt_apellido_cliente.setEnabled(false);
        txtCelular.setEnabled(false);
        txtcuit.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtRazonSocial.setEnabled(false);
        txtFax.setEnabled(false);
        txtDni.setEnabled(false);
        cmbProvincia.setEnabled(false);
        cmbCiudad.setEnabled(false);
        Guardar_cliente.setEnabled(false);
        Modificar.setEnabled(false);
        Nuevo.setEnabled(true);
        Salir.setEnabled(true);
        txtTelefono.setEnabled(false);
        txtCodigopostal.setEnabled(false);
        txtEmail.setEnabled(false);

    }
    
    void desbloquear() {
        jd_fechaNac.setEnabled(true);
//        txtfechaprueba.setEnabled(true);
        txt_Nombre_cliente.setEnabled(true);
        txt_apellido_cliente.setEnabled(true);
        txtcuit.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtRazonSocial.setEnabled(true);
        txtFax.setEnabled(true);
        txtDni.setEnabled(true);
        cmbProvincia.setEnabled(true);
        cmbCiudad.setEnabled(true);
        Guardar_cliente.setEnabled(true);
        Nuevo.setEnabled(true);
        Salir.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtEmail.setEnabled(true);
        txtCodigopostal.setEnabled(true);
        Modificar.setEnabled(false);
    }
     
                void combocondIva(){

         String cons="Select desccond from cond_iva";
         cargarcmb.cargacombo(cmbIva, cons);
         //cmbrubro.setSelectedIndex(-1);
       }
                
                void comboprovincia(){
                           // carga provincia
         String cons="Select descprovincia from provincias";
         cargarcmb.cargacombo(cmbProvincia, cons);
         cmbProvincia.setSelectedIndex(-1);
         // carga condicion de iva
                }
      

    void idP(){
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
               
              void idcli(){
                   try{
            String dato [] = new String [1];
            Conectar miconexion = new Conectar();
            String consultasql = "select max(idcliente)+1 from clientes";
            ResultSet rs = miconexion.consulta(consultasql);  
            
            while(rs.next()){       //recorre el resultset mientras tenga algun dato
                for (int j=0; j<dato.length; j++){  //RECORRE HORINZONTALMENTE
                    dato[j]= rs.getString(j+1);
                }
                lblCodigoCliente.setText(rs.getString(1));
                
                     
       // en caso de ser el primer articulo que vamos a cargar, se fija que la table este vacia y genera el 1
       //como id principal, en el caso contrario busca el ultimo y le suma 1
             if(rs.getString(1)==null){
             lblCodigoCliente.setText("1");
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
        lblcodigocliente = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtRazonSocial = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        cmbIva = new javax.swing.JComboBox();
        txtDni = new javax.swing.JTextField();
        cmbProvincia = new javax.swing.JComboBox();
        cmbCiudad = new javax.swing.JComboBox();
        txtTelefono = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        txt_apellido_cliente = new javax.swing.JTextField();
        txtCodigopostal = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtFax = new javax.swing.JTextField();
        EnviarEmail = new javax.swing.JButton();
        lblCodigoCliente = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        txt_Nombre_cliente = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtcuit = new javax.swing.JTextField();
        jd_fechaNac = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        txt_cliCBU = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lb_codPer = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        Guardar_cliente = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        Modificar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Salir = new javax.swing.JButton();
        Nuevo = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lb_titulo = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblcodigocliente.setForeground(new java.awt.Color(255, 255, 255));
        lblcodigocliente.setText("Código :");
        jPanel2.add(lblcodigocliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Apellido :");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("R. Social :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Dirección :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Cond IVA:");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("DNI :");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Provincia :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Teléfono :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Ciudad:");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, 20));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Celular :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, -1, 20));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fax :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("E- Mail :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        txtRazonSocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRazonSocialKeyPressed(evt);
            }
        });
        jPanel2.add(txtRazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 305, -1));
        jPanel2.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 305, -1));

        cmbIva.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cmbIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 305, -1));

        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDniKeyPressed(evt);
            }
        });
        jPanel2.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 128, -1));

        cmbProvincia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProvincia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbProvinciaItemStateChanged(evt);
            }
        });
        jPanel2.add(cmbProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 160, -1));

        cmbCiudad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cmbCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 160, -1));

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyPressed(evt);
            }
        });
        jPanel2.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 157, -1));

        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCelularKeyPressed(evt);
            }
        });
        jPanel2.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, 160, -1));

        txt_apellido_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_apellido_clienteKeyPressed(evt);
            }
        });
        jPanel2.add(txt_apellido_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, 160, -1));

        txtCodigopostal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigopostalKeyPressed(evt);
            }
        });
        jPanel2.add(txtCodigopostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 280, 75, -1));
        jPanel2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 313, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("C.P:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, -1, 20));

        txtFax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFaxKeyPressed(evt);
            }
        });
        jPanel2.add(txtFax, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 157, -1));

        EnviarEmail.setAlignmentY(0.0F);
        EnviarEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarEmailActionPerformed(evt);
            }
        });
        jPanel2.add(EnviarEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 30, 20));

        lblCodigoCliente.setBackground(new java.awt.Color(255, 102, 204));
        lblCodigoCliente.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lblCodigoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 54, 20));

        Nombre.setForeground(new java.awt.Color(255, 255, 255));
        Nombre.setText("Nombre :");
        jPanel2.add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        txt_Nombre_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Nombre_clienteActionPerformed(evt);
            }
        });
        txt_Nombre_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_Nombre_clienteKeyPressed(evt);
            }
        });
        jPanel2.add(txt_Nombre_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 157, -1));

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("CUIT/CUIL:");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, -1, 20));

        txtcuit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcuitKeyPressed(evt);
            }
        });
        jPanel2.add(txtcuit, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 220, 160, -1));

        jd_fechaNac.setDateFormatString("yyyy/MM/dd");
        jd_fechaNac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jd_fechaNacMouseClicked(evt);
            }
        });
        jPanel2.add(jd_fechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 160, 30));

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Fecha de Nacimiento:");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, -1, -1));

        txt_cliCBU.setText("2850590940090418135201");
        txt_cliCBU.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cliCBUKeyPressed(evt);
            }
        });
        jPanel2.add(txt_cliCBU, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, 160, -1));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("CBU:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, -1, 20));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_ABM/orig_60533_1.jpg"))); // NOI18N
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 360));

        lb_codPer.setForeground(new java.awt.Color(255, 255, 255));
        lb_codPer.setText("jLabel1");
        jPanel2.add(lb_codPer, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 50, -1));

        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Fecha:");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 810, 360));

        Guardar_cliente.setBackground(new java.awt.Color(255, 255, 255));
        Guardar_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-guardar_opt (1).png"))); // NOI18N
        Guardar_cliente.setToolTipText("Guardar Cliente");
        Guardar_cliente.setBorderPainted(false);
        Guardar_cliente.setContentAreaFilled(false);
        Guardar_cliente.setFocusable(false);
        Guardar_cliente.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-guardar_opt.png"))); // NOI18N
        Guardar_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Guardar_clienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Guardar_clienteMouseExited(evt);
            }
        });
        Guardar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guardar_clienteActionPerformed(evt);
            }
        });
        getContentPane().add(Guardar_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 560, 110, 90));

        jLabel10.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        jLabel10.setText("Clientes:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-actualizar_opt.png"))); // NOI18N
        Modificar.setToolTipText("Modificar Cliente");
        Modificar.setBorderPainted(false);
        Modificar.setContentAreaFilled(false);
        Modificar.setEnabled(false);
        Modificar.setFocusPainted(false);
        Modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ModificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ModificarMouseExited(evt);
            }
        });
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });
        getContentPane().add(Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 560, -1, 90));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imag_inicio/IMG-20180911-WA0027 - copia_opt_1.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, 120));

        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-atras_opt.png"))); // NOI18N
        Salir.setToolTipText("Salir");
        Salir.setBorderPainted(false);
        Salir.setContentAreaFilled(false);
        Salir.setFocusPainted(false);
        Salir.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-atras_opt (1).png"))); // NOI18N
        Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SalirMouseExited(evt);
            }
        });
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        getContentPane().add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 560, 100, 90));

        Nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-editar_opt.png"))); // NOI18N
        Nuevo.setToolTipText("Nuevo");
        Nuevo.setBorderPainted(false);
        Nuevo.setContentAreaFilled(false);
        Nuevo.setFocusPainted(false);
        Nuevo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-editar_opt (1).png"))); // NOI18N
        Nuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NuevoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NuevoMouseExited(evt);
            }
        });
        Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoActionPerformed(evt);
            }
        });
        getContentPane().add(Nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 560, 100, 90));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_ABM/arabescato.jpg"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 910, 610));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_titulo.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        lb_titulo.setForeground(new java.awt.Color(255, 255, 255));
        lb_titulo.setText("jLabel14");
        jPanel1.add(lb_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_ABM/textura-en-negro_1366x768_1550.jpg"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 30));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_ABM/orig_60533_1.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 976, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 950, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Guardar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guardar_clienteActionPerformed
     // METODO GUARDAR
       gestionarCliente guardar = new gestionarCliente();
       gestionarPersona guardarPer = new gestionarPersona();
   
       
      if(txtDni.getText().isEmpty() )                                                                                                   //VALIDACIONES
       { 
           JOptionPane.showMessageDialog(null,"Igrese DNI ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
        if(txt_Nombre_cliente.getText().isEmpty() )                                                                                                   //VALIDACIONES
       { 
           JOptionPane.showMessageDialog(null,"Igrese NOMBRE ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
        
            if(txt_apellido_cliente.getText().isEmpty() )                                                                                                   //VALIDACIONES
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
      
           else  if(cmbIva.getSelectedIndex()==-1)
        {
            JOptionPane.showMessageDialog(null,"SELECCIONE IVA ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
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
       else if(txtcuit.getText().isEmpty() ) 
       { 
           JOptionPane.showMessageDialog(null,"Igrese CUIT ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
        else if(txtDireccion.getText().isEmpty() ) 
       { 
           JOptionPane.showMessageDialog(null,"Ingrese DIRECCION ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
            else if(txtEmail.getText().isEmpty() ) 
       { 
           JOptionPane.showMessageDialog(null,"Igrese EMAIL ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
          else if(txtFax.getText().isEmpty() ) 
       { 
           JOptionPane.showMessageDialog(null,"Igrese FAX ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
             else if(txtRazonSocial.getText().isEmpty() ) 
       { 
           JOptionPane.showMessageDialog(null,"Igrese RAZON SOCIAL ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
       else{
       
     
      
     
      
      mCliente.setCli_codPostal(Integer.parseInt(txtCodigopostal.getText()));
      
     
      mCliente.setCli_razonSocial(txtRazonSocial.getText().toUpperCase());
      mCliente.setCli_direccion(txtDireccion.getText().toUpperCase());
      mCliente.setCli_email(txtEmail.getText().toUpperCase());
      mCliente.setCli_celular((txtCelular.getText()));
    
      mCliente.setCli_telefono((txtTelefono.getText()));
      mCliente.setCli_fax((txtFax.getText()));
      mCliente.setCli_cuit((txtcuit.getText()));
      
     miPersona.setFechaNacimiento(((JTextField)jd_fechaNac.getDateEditor().getUiComponent()).getText());

      miPersona.setNombre((txt_Nombre_cliente.getText().toUpperCase()));
      miPersona.setApellido((txt_apellido_cliente.getText().toUpperCase()));
      miPersona.setDni(Integer.parseInt(txtDni.getText()));
      mCliente.setIdPersona(Integer.parseInt(lb_codPer.getText()));
      mCliente.setCli_CBU(txt_cliCBU.getText());
      
       int idprovincia = id.buscarid("idprovincia", "provincias", "descprovincia", String.valueOf(cmbProvincia.getSelectedItem()));
       mCliente.setCli_Provincia(idprovincia);
     
       int idciudad = id.buscarid("idciudad", "ciudades", "descciudad", String.valueOf(cmbCiudad.getSelectedItem()));
       mCliente.setCli_Ciudad(idciudad);
     
      int idcondiva = id.buscarid("idcond", "cond_iva", "desccond", String.valueOf(cmbIva.getSelectedItem()));
      mCliente.setCli_condiva(idcondiva);
     
 
       
       guardar.GuardarCliente(mCliente);
       guardarPer.GuardarPersona(miPersona);
       
       
       Mensajes.informacion("Cliente Registrado");
       bloquear(); 
       limpiarCampos();

       
             }
     
    }//GEN-LAST:event_Guardar_clienteActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
    // METODO GUARDAR
             gestionarCliente ModificarCli = new gestionarCliente();
             gestionarPersona ModPersona = new gestionarPersona();
       
      if(txtDni.getText().isEmpty() )                                                                                                   //VALIDACIONES
       { 
           JOptionPane.showMessageDialog(null,"Igrese DNI ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
        if(txt_Nombre_cliente.getText().isEmpty() )                                                                                                   //VALIDACIONES
       { 
           JOptionPane.showMessageDialog(null,"Igrese NOMBRE ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
        
            if(txt_apellido_cliente.getText().isEmpty() )                                                                                                   //VALIDACIONES
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
      
           else  if(cmbIva.getSelectedIndex()==-1)
        {
            JOptionPane.showMessageDialog(null,"SELECCIONE IVA ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
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
       else if(txtcuit.getText().isEmpty() ) 
       { 
           JOptionPane.showMessageDialog(null,"Igrese CUIT ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
        else if(txtDireccion.getText().isEmpty() ) 
       { 
           JOptionPane.showMessageDialog(null,"Ingrese DIRECCION ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
            else if(txtEmail.getText().isEmpty() ) 
       { 
           JOptionPane.showMessageDialog(null,"Igrese EMAIL ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
          else if(txtFax.getText().isEmpty() ) 
       { 
           JOptionPane.showMessageDialog(null,"Igrese FAX ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
             else if(txtRazonSocial.getText().isEmpty() ) 
       { 
           JOptionPane.showMessageDialog(null,"Igrese RAZON SOCIAL ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
       else{
       
     
      // MODIFICA TABLA CLIENTE
                mCliente.setIdCliente(Integer.parseInt(lblCodigoCliente.getText()));
                mCliente.setIdPersona(Integer.parseInt(lb_codPer.getText()));
                mCliente.setCli_razonSocial(txtRazonSocial.getText().toUpperCase());

                int idcondiva = id.buscarid("idcond", "cond_iva", "desccond", String.valueOf(cmbIva.getSelectedItem()));
                mCliente.setCli_condiva(idcondiva);
                mCliente.setCli_telefono((txtTelefono.getText()));
                mCliente.setCli_celular((txtCelular.getText()));
                mCliente.setCli_fax((txtFax.getText()));
                mCliente.setCli_cuit((txtcuit.getText()));
                mCliente.setCli_email(txtEmail.getText().toUpperCase());
                int idprovincia = id.buscarid("idprovincia", "provincias", "descprovincia", String.valueOf(cmbProvincia.getSelectedItem()));
                mCliente.setCli_Provincia(idprovincia);
                int idciudad = id.buscarid("idciudad", "ciudades", "descciudad", String.valueOf(cmbCiudad.getSelectedItem()));
                mCliente.setCli_Ciudad(idciudad);
                mCliente.setCli_direccion(txtDireccion.getText().toUpperCase());
                mCliente.setCli_codPostal(Integer.parseInt(txtCodigopostal.getText()));
                mCliente.setCli_CBU(txt_cliCBU.getText());
      
      
    
      // modifica tabla Persona
      miPersona.setNombre((txt_Nombre_cliente.getText().toUpperCase()));
      miPersona.setApellido((txt_apellido_cliente.getText().toUpperCase()));
      miPersona.setDni(Integer.parseInt(txtDni.getText()));
      miPersona.setFechaNacimiento(((JTextField)jd_fechaNac.getDateEditor().getUiComponent()).getText());
      miPersona.setIdPersona(Integer.parseInt(lb_codPer.getText()));
      
            
       

      
      
     
      
       
     
      
     

       
     
       ModificarCli.modCliente(mCliente);
       ModPersona.modificarPersona(miPersona);
       
       Mensajes.informacion("Cliente Modificado");
         this.dispose();
        bloquear(); 
        limpiarCampos();
        
             }
     
    }//GEN-LAST:event_ModificarActionPerformed

    private void txtcuitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcuitKeyPressed
        validarCampos.soloNumeros(txtcuit);
    }//GEN-LAST:event_txtcuitKeyPressed

    private void txt_Nombre_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Nombre_clienteKeyPressed

        validarCampos.soloLetras(txt_Nombre_cliente);
    }//GEN-LAST:event_txt_Nombre_clienteKeyPressed

    private void txt_Nombre_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Nombre_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Nombre_clienteActionPerformed

    private void txtFaxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFaxKeyPressed
        validarCampos.soloNumeros(txtFax);
    }//GEN-LAST:event_txtFaxKeyPressed

    private void txtCodigopostalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigopostalKeyPressed
        validarCampos.soloNumeros(txtCodigopostal);
    }//GEN-LAST:event_txtCodigopostalKeyPressed

    private void txt_apellido_clienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellido_clienteKeyPressed
        validarCampos.soloLetras(txt_apellido_cliente);
    }//GEN-LAST:event_txt_apellido_clienteKeyPressed

    private void txtCelularKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyPressed
        validarCampos.soloNumeros(txtCelular);
    }//GEN-LAST:event_txtCelularKeyPressed

    private void txtTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyPressed
        validarCampos.soloNumeros(txtTelefono);
    }//GEN-LAST:event_txtTelefonoKeyPressed

    private void cmbProvinciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbProvinciaItemStateChanged
        int idprov = id.buscarid("idprovincia", "provincias", "descprovincia", String.valueOf(cmbProvincia.getSelectedItem()));
        String consp = "Select descciudad from ciudades where idprovincia like '" + idprov + "'";
        cargarcmb.cargacombo(cmbCiudad, consp);
        cmbCiudad.setSelectedIndex(-1);
    }//GEN-LAST:event_cmbProvinciaItemStateChanged

    private void txtDniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyPressed
        validarCampos.soloNumeros(txtDni);
    }//GEN-LAST:event_txtDniKeyPressed

    private void txtRazonSocialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSocialKeyPressed
        validarCampos.soloLetras(txtRazonSocial);
    }//GEN-LAST:event_txtRazonSocialKeyPressed

    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoActionPerformed
        idcli();
        desbloquear();
        limpiarCampos();
    }//GEN-LAST:event_NuevoActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_SalirActionPerformed

    private void EnviarEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarEmailActionPerformed
         try {
            Desktop.getDesktop().browse(new URI("http://www.outlook.com"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido cargar la página");
        }
    }//GEN-LAST:event_EnviarEmailActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened


     
         
       // trae ultimo id 
        /*
       buscarid buscarUltimo = new buscarid();
       int idCliente = buscarUltimo.BuscarULTIMOID("idCliente","clientes"+lblCodigoCliente.getText());
       lblCodigoCliente.setText(String.valueOf(idCliente));
       */
    }//GEN-LAST:event_formWindowOpened

    private void txt_cliCBUKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cliCBUKeyPressed
        validarCampos.soloNumeros(txt_cliCBU);
    }//GEN-LAST:event_txt_cliCBUKeyPressed

    private void Guardar_clienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Guardar_clienteMouseEntered

    }//GEN-LAST:event_Guardar_clienteMouseEntered

    private void Guardar_clienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Guardar_clienteMouseExited

       
    }//GEN-LAST:event_Guardar_clienteMouseExited

    private void ModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModificarMouseEntered

    
    }//GEN-LAST:event_ModificarMouseEntered

    private void ModificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModificarMouseExited

        
    }//GEN-LAST:event_ModificarMouseExited

    private void NuevoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NuevoMouseEntered

        
    }//GEN-LAST:event_NuevoMouseEntered

    private void NuevoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NuevoMouseExited

      
    }//GEN-LAST:event_NuevoMouseExited

    private void SalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseEntered

        
    }//GEN-LAST:event_SalirMouseEntered

    private void SalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseExited

        
    }//GEN-LAST:event_SalirMouseExited

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed

        // TODO add your handling code here:
        x = evt.getX();

        y = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
         Point ubicacion = MouseInfo.getPointerInfo().getLocation();//1
        System.out.println("Coordenadas: ("+ubicacion.x+","+ubicacion.y+")");//2
        setLocation(ubicacion.x - x, ubicacion.y - y);//3
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jd_fechaNacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jd_fechaNacMouseClicked

     
    }//GEN-LAST:event_jd_fechaNacMouseClicked

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
            java.util.logging.Logger.getLogger(jDlg_CargarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jDlg_CargarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jDlg_CargarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jDlg_CargarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                jDlg_CargarCliente dialog = new jDlg_CargarCliente(new javax.swing.JFrame(), true);
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
    public static javax.swing.JButton Guardar_cliente;
    public static javax.swing.JButton Modificar;
    public static javax.swing.JLabel Nombre;
    public static javax.swing.JButton Nuevo;
    public static javax.swing.JButton Salir;
    public static javax.swing.JComboBox cmbCiudad;
    public static javax.swing.JComboBox cmbIva;
    public static javax.swing.JComboBox cmbProvincia;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel11;
    public static javax.swing.JLabel jLabel12;
    public static javax.swing.JLabel jLabel13;
    public static javax.swing.JLabel jLabel14;
    public static javax.swing.JLabel jLabel15;
    public static javax.swing.JLabel jLabel17;
    public static javax.swing.JLabel jLabel18;
    public static javax.swing.JLabel jLabel19;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel20;
    public static javax.swing.JLabel jLabel21;
    public static javax.swing.JLabel jLabel22;
    public static javax.swing.JLabel jLabel23;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabel9;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel3;
    public static com.toedter.calendar.JDateChooser jd_fechaNac;
    public static javax.swing.JLabel lb_codPer;
    public static javax.swing.JLabel lb_titulo;
    public static javax.swing.JLabel lblCodigoCliente;
    public javax.swing.JLabel lblcodigocliente;
    public static javax.swing.JTextField txtCelular;
    public static javax.swing.JTextField txtCodigopostal;
    public static javax.swing.JTextField txtDireccion;
    public static javax.swing.JTextField txtDni;
    public static javax.swing.JTextField txtEmail;
    public static javax.swing.JTextField txtFax;
    public static javax.swing.JTextField txtRazonSocial;
    public static javax.swing.JTextField txtTelefono;
    public static javax.swing.JTextField txt_Nombre_cliente;
    public static javax.swing.JTextField txt_apellido_cliente;
    public static javax.swing.JTextField txt_cliCBU;
    public static javax.swing.JTextField txtcuit;
    // End of variables declaration//GEN-END:variables
}
