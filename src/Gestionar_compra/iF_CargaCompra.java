/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestionar_compra;

import Clases.Articulo;
import Clases.Compra;
import Clases.DetalleCompra;
import Componentes.InternalFrameImag;
import Componentes.Mensajes;
import Gestionar_Proveedores.JDlg_BuscarProveedor;

import Metodos.Actualizar;
import Metodos.CargarCombo;
import Metodos.Conectar;
import Metodos.buscarid;
import Metodos.llamarArticulo;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luca
 */
public class iF_CargaCompra extends InternalFrameImag {
DefaultTableModel objtabla = new DefaultTableModel();
    /**
     * Creates new form iF_CargaCompra
     */
    public iF_CargaCompra() {
        initComponents();
         String detalleSalida[] = {"Cod.","Descripcion" ,"Cant.","Precio Unitario", "Precio Total"};
                 objtabla.setColumnIdentifiers(detalleSalida);
                 
        grillaDetalleCompra.setModel(objtabla);
        tablaarticulo();
        idcompras();
        comboCondicionPago();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        Date date=new Date();
        String format=new String("dd/MM/yyyy");
        SimpleDateFormat formato=new SimpleDateFormat(format);
        txtFecha.setDate(date);
        setImage("/imagenes_ABM/arabescato.jpg");
       
    }
    
    void limpiarcampos(){
        
        txtArti.setText("");
//        txtCodCompra.setText("");
        txtCodProv.setText("");
        txtDirec.setText("");
        txtRazonSocial.setText("");
        txtcuit.setText("");
        txtfacproveedor.setText("");
        txtTotal.setText("0.0");

    }
    
        void limpiarTabla(){
        try{      
	int filas=grillaDetalleCompra.getRowCount();
            for (int i = 0;filas>i; i++) {
                objtabla.removeRow(0);
            }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }
    
    
          void tablaarticulo(){
        // Genera espacion entre las columnas 
        grillaDetalleCompra.getColumnModel().getColumn(0).setPreferredWidth(50);
        grillaDetalleCompra.getColumnModel().getColumn(1).setPreferredWidth(450);
        grillaDetalleCompra.getColumnModel().getColumn(2).setPreferredWidth(70);
        grillaDetalleCompra.getColumnModel().getColumn(3).setPreferredWidth(100);
        grillaDetalleCompra.getColumnModel().getColumn(4).setPreferredWidth(100);

        

        
     } 
    
     void calcular()
    {
        String prec;
        String cant;
        double igv=0;
        double total=0.0;
        double subtotal=0;
        double precio=0.0;
        double cantidad=0.0;
        double calcula=0.0;
        
            /*can=Integer.parseInt(cant);
            imp=pre*can;
            dato[4]=Float.toString(imp);*/
        
        for(int i=0;i<grillaDetalleCompra.getRowCount();i++)
        {
            prec=grillaDetalleCompra.getValueAt(i, 3).toString();
            cant=grillaDetalleCompra.getValueAt(i, 2).toString();
            precio=Double.parseDouble(prec);
            cantidad=Double.parseDouble(cant);
            calcula=precio*cantidad;
            total = total + calcula;
 

            // txtcod.setText(""+Math.rint(c*100)/100)
          //  grillaSalidaMerc.setValueAt(Math.rint(importe*100)/100, i, 4);
            
        }
        txtTotal.setText(""+total);
        
            
    }
    
    
        // CLASES
    CargarCombo cargarcmb=new CargarCombo();
    
          void comboCondicionPago(){
         String cons="Select detallepago from cond_pago";
         cargarcmb.cargacombo(cmbCondpago, cons);
         cmbCondpago.setSelectedIndex(-1);
       }
    
       void idcompras(){
                   try{
            String dato [] = new String [1];
                       Conectar miconexion = new Conectar();
            String consultasql = "select max(idcompra)+1 from compras";
                       ResultSet rs = miconexion.consulta(consultasql);  
            
            
            while(rs.next()){       //recorre el resultset mientras tenga algun dato
                for (int j=0; j<dato.length; j++){  //RECORRE HORINZONTALMENTE
                    dato[j]= rs.getString(j+1);
                }
                txtCodCompra.setText(rs.getString(1));
                
                     
       // en caso de ser el primer articulo que vamos a cargar, se fija que la table este vacia y genera el 1
       //como id principal, en el caso contrario busca el ultimo y le suma 1
             if(rs.getString(1)==null){
             txtCodCompra.setText("1");
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

        jPanel3 = new javax.swing.JPanel();
        lb_Titulo = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        grillaDetalleCompra = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowInddex, int celIndex)
            {
                return false;
            }
        };
        txtArti = new javax.swing.JTextField();
        bto_buscarArticulo = new javax.swing.JButton();
        bto_QuitardeLaLista1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodCompra = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        txtfacproveedor = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        txtRazonSocial = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDirec = new javax.swing.JTextField();
        bto_buscarCliente = new javax.swing.JButton();
        txtCodProv = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtcuit = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cmbCondpago = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        Guardar = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();

        setBackground(new java.awt.Color(153, 153, 153));
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });

        lb_Titulo.setFont(new java.awt.Font("Trajan Pro", 1, 14)); // NOI18N
        lb_Titulo.setForeground(new java.awt.Color(255, 255, 255));
        lb_Titulo.setText("Orden de Compra");

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_ABM/textura-en-negro_1366x768_1550.jpg"))); // NOI18N
        jLabel24.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel24MouseDragged(evt);
            }
        });
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel24MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addComponent(lb_Titulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(lb_Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel5.setOpaque(false);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Artículo :");

        grillaDetalleCompra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        grillaDetalleCompra.setModel(new javax.swing.table.DefaultTableModel(
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
        grillaDetalleCompra.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        grillaDetalleCompra.setSelectionBackground(new java.awt.Color(255, 51, 51));
        jScrollPane1.setViewportView(grillaDetalleCompra);

        bto_buscarArticulo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bto_buscarArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/icons8_Search_25px.png"))); // NOI18N
        bto_buscarArticulo.setText("Buscar Articulo");
        bto_buscarArticulo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bto_buscarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_buscarArticuloActionPerformed(evt);
            }
        });

        bto_QuitardeLaLista1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/icons8_Cancel_30px.png"))); // NOI18N
        bto_QuitardeLaLista1.setToolTipText("Quitar de la Lista");
        bto_QuitardeLaLista1.setBorderPainted(false);
        bto_QuitardeLaLista1.setContentAreaFilled(false);
        bto_QuitardeLaLista1.setFocusPainted(false);
        bto_QuitardeLaLista1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/icons8_Cancel_35px.png"))); // NOI18N
        bto_QuitardeLaLista1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_QuitardeLaLista1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtArti, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bto_buscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bto_QuitardeLaLista1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel10)
                    .addComponent(txtArti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bto_buscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bto_QuitardeLaLista1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Datos  Compra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setText("Nro ");

        txtCodCompra.setEditable(false);
        txtCodCompra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel4.setText("Fecha");

        jLabel3.setText("Nro FAC Proveedor ");

        txtfacproveedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtfacproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCodCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3)
                        .addComponent(txtfacproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Datos del Proveeor\n\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        txtRazonSocial.setEditable(false);

        jLabel6.setText("Razón Social:");

        jLabel7.setText("Dirección:");

        txtDirec.setEditable(false);

        bto_buscarCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bto_buscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/icons8_Search_25px.png"))); // NOI18N
        bto_buscarCliente.setText("Buscar Proveedor");
        bto_buscarCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bto_buscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bto_buscarClienteActionPerformed(evt);
            }
        });

        txtCodProv.setEditable(false);

        jLabel5.setText("Cód Prov:");

        jLabel8.setText("CUIT :");

        txtcuit.setEditable(false);

        jLabel9.setText("Cond. Pago");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtCodProv, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bto_buscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtDirec, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcuit, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbCondpago, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDirec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bto_buscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCondpago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addGap(14, 14, 14))
        );

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("TOTAL:");

        Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-guardar_opt (1).png"))); // NOI18N
        Guardar.setToolTipText("Guardar Compra");
        Guardar.setBorderPainted(false);
        Guardar.setContentAreaFilled(false);
        Guardar.setFocusPainted(false);
        Guardar.setOpaque(false);
        Guardar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos_Botones/x128-guardar_opt.png"))); // NOI18N
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

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

        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64))
                    .addComponent(Guardar, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(Salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Datos de Compra");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        gestionarCompra guardCompra = new gestionarCompra();
        gestionarCompra detCompra = new gestionarCompra();
        Actualizar actualizarStock =new Actualizar();
        llamarArticulo llamArt= new llamarArticulo();
        Compra miCompra = new Compra();
        DetalleCompra detCom = new DetalleCompra();
        buscarid id = new buscarid();
        Articulo art =new Articulo();
          
        if(txtFecha.getDate().equals(evt) )                                                                                                   //VALIDACIONES
       { 
           JOptionPane.showMessageDialog(null,"Igrese FECHA DE LA OPERACION ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
       else if(cmbCondpago.getSelectedIndex()==-1)
        {
            JOptionPane.showMessageDialog(null,"Igrese CONDICION DE PAGO ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
        }
       
       else if(txtCodProv.getText().isEmpty() ) 
       { 
           JOptionPane.showMessageDialog(null,"Igrese DATOS DEL PROVEEDOR ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
       else if(txtArti.getText().isEmpty() ) 
       { 
           JOptionPane.showMessageDialog(null,"Selecciona un ARTICULO ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
       else if(txtTotal.getText().isEmpty() ) 
       { 
           JOptionPane.showMessageDialog(null,"Selecciona CALCULAR para completar la Opercion ","Error: Datos Incompletos",JOptionPane.ERROR_MESSAGE);
      
       }
       else{
           
       miCompra.setIdcompra(Integer.parseInt(txtCodCompra.getText()));
       miCompra.setNumfacproveedor(Integer.parseInt(txtfacproveedor.getText()));
       miCompra.setFecha(txtFecha.getDate());
       miCompra.setIdproveedor(Integer.parseInt(txtCodProv.getText()));
       int idcondpago = id.buscarid("idcondpago", "cond_pago", "detallepago", String.valueOf(cmbCondpago.getSelectedItem()));
       miCompra.setCondpago(idcondpago);

       miCompra.setTotalcompra(Double.parseDouble(txtTotal.getText()));

       
       guardCompra.GuardarCompra(miCompra);
       
      
      
       
               ///////////////////DETALLE COMPRA////////////////////
        for (int i=0; i < objtabla.getRowCount(); i++){
            
            detCom.setIdarticulo(Integer.parseInt(grillaDetalleCompra.getValueAt(i, 0).toString()));
            detCom.setIdcompra(Integer.parseInt(txtCodCompra.getText()));
            detCom.setCantidad(Integer.parseInt(grillaDetalleCompra.getValueAt(i, 2).toString()));
            detCom.setPrecioUnitario(Double.parseDouble(grillaDetalleCompra.getValueAt(i, 3).toString()));
            detCom.setTotalArticulo(Double.parseDouble(grillaDetalleCompra.getValueAt(i, 4).toString()));
            //Actualizar Stock
            art=llamArt.llamarArt("idarticulo", grillaDetalleCompra.getValueAt(i, 0).toString()); //llama al articulo
            actualizarStock.actualizarproducto(art,Integer.parseInt(grillaDetalleCompra.getValueAt(i, 2).toString()) );// Manda articulo y cantidad
            
            detCompra.GuardarDetalleCompra(detCom);
        }
        
        // VER COMO VOLVER A ABRIR UN INTERNALFRAME DE VUELTA // CON LOS JDIALOG SE PUEDE.
        int seleccion= JOptionPane.showOptionDialog(this, "Operacion Guardada con exito! ¿REALIZAR OTRA OPERACION?", "Atecion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"SI","NO, SALIR"},"SI");
        if(seleccion!=-1)
        {
            if((seleccion +1)==1){
                this.dispose();
        iF_CargaCompra compras = new iF_CargaCompra();
        
        //compras.setLocationRelativeTo(null);
        compras.setTitle("Ingreso de Mercaderias");
        compras.setVisible(true);
       
        
            }
            else{
            
            this.dispose(); 
            }
        }
        
       
      
                }      
    }//GEN-LAST:event_GuardarActionPerformed

    private void bto_buscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_buscarClienteActionPerformed
        try {
            JDlg_BuscarProvCompra dbp = new JDlg_BuscarProvCompra(null, true);
            dbp.setLocationRelativeTo(null);
            dbp.setTitle("Buscar Proveedor");
            dbp.setVisible(true);
            
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        }     
                              
    }//GEN-LAST:event_bto_buscarClienteActionPerformed

    private void bto_buscarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_buscarArticuloActionPerformed
        try {
            JDlg_BuscarArticuloCompra dbp = new JDlg_BuscarArticuloCompra(null, true);
            dbp.setLocationRelativeTo(null);
            dbp.setTitle("Buscar Articulo");
            dbp.setVisible(true);
            calcular();
        } catch (Exception e) {
            Mensajes.informacion("No hay conexión con el servidor");
        } 
    }//GEN-LAST:event_bto_buscarArticuloActionPerformed

    private void jLabel24MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseDragged

    }//GEN-LAST:event_jLabel24MouseDragged

    private void jLabel24MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MousePressed

    }//GEN-LAST:event_jLabel24MousePressed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged

    }//GEN-LAST:event_jPanel3MouseDragged

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked

    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed

    }//GEN-LAST:event_jPanel3MousePressed

    private void bto_QuitardeLaLista1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bto_QuitardeLaLista1ActionPerformed
       int fila = grillaDetalleCompra.getSelectedRow();
        if(fila>0)
        {
            int seleccion= JOptionPane.showOptionDialog(this, "¿ESTA SEGURO?", "CONFIRMAR BAJA", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"ACEPTAR","CANCELAR"},"ACEPTAR");
            objtabla.removeRow(fila);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No Selecciono ninguna fila");
        }
        calcular();     
    }//GEN-LAST:event_bto_QuitardeLaLista1ActionPerformed

    private void SalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseEntered

    }//GEN-LAST:event_SalirMouseEntered

    private void SalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseExited

    }//GEN-LAST:event_SalirMouseExited

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        this.dispose();
        limpiarcampos();
        limpiarTabla();
    }//GEN-LAST:event_SalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Guardar;
    private javax.swing.JButton Salir;
    private javax.swing.JButton bto_QuitardeLaLista1;
    private javax.swing.JButton bto_buscarArticulo;
    private javax.swing.JButton bto_buscarCliente;
    public static javax.swing.JComboBox cmbCondpago;
    public static javax.swing.JTable grillaDetalleCompra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_Titulo;
    public static javax.swing.JTextField txtArti;
    public static javax.swing.JTextField txtCodCompra;
    public static javax.swing.JTextField txtCodProv;
    public static javax.swing.JTextField txtDirec;
    private com.toedter.calendar.JDateChooser txtFecha;
    public static javax.swing.JTextField txtRazonSocial;
    public static javax.swing.JTextField txtTotal;
    public static javax.swing.JTextField txtcuit;
    public static javax.swing.JTextField txtfacproveedor;
    // End of variables declaration//GEN-END:variables
}
