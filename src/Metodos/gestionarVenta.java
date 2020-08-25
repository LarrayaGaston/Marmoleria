/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Clases.DetalleFactura;
import Clases.ventaFactura;
import Componentes.conectar;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaston
 */
public class gestionarVenta {
    
    private Connection connection=new conectar().conexion();
       public void GuardarVentaF(ventaFactura miVenta) {
        try {
            Conectar miconexion= new Conectar();
            String sentenciaInsert= "Insert into ventafactura (idVFactura,numeroFac,idCliente,nombre,apellido,"
                    + "cli_razonsocial,cli_cuit,TotalVenta,Descuento,SubTotal,IVA,TotalPagar,"
                    + "FechaEmision,FechaVencimiento,Estado) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            miconexion.psPrepararSentencias = miconexion.miconexion.prepareStatement(sentenciaInsert);
            miconexion.psPrepararSentencias.setString(1, "" + miVenta.getIdVFactura());
//            miconexion.psPrepararSentencias.setString(2, "" + miVenta.getIdDetalleFactura());
            miconexion.psPrepararSentencias.setString(2, "" + miVenta.getNumeroFac());
            miconexion.psPrepararSentencias.setString(3, "" + miVenta.getIdCliente());
//            miconexion.psPrepararSentencias.setString(5, ""+ new java.sql.Date(miVenta.getStrFechaVenta().getTime()));
            miconexion.psPrepararSentencias.setString(4, "" + miVenta.getNombre());
            miconexion.psPrepararSentencias.setString(5, "" + miVenta.getApellido());

            miconexion.psPrepararSentencias.setString(6, "" + miVenta.getCli_razonsocial());
            miconexion.psPrepararSentencias.setString(7, "" + miVenta.getCli_cuit());
            miconexion.psPrepararSentencias.setString(8, "" + miVenta.getTotalVenta());
            miconexion.psPrepararSentencias.setString(9, "" + miVenta.getDescuento());
            miconexion.psPrepararSentencias.setString(10, "" + miVenta.getSubTotal());
            miconexion.psPrepararSentencias.setString(11, "" + miVenta.getIVA());
            miconexion.psPrepararSentencias.setString(12, "" + miVenta.getTotalPagar());
            miconexion.psPrepararSentencias.setString(13, "" + new java.sql.Date(miVenta.getFechaEmision().getTime()));
            miconexion.psPrepararSentencias.setString(14, "" + new java.sql.Date(miVenta.getFechaVencimiento().getTime()));

            miconexion.psPrepararSentencias.setString(15, "" + miVenta.getEstado());
         
            
            miconexion.psPrepararSentencias.executeUpdate();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.toString()); //joptionpane para que aparezca un cartel con el error.
        }        
    }
    
     public void GuardarDetalleFctura(DetalleFactura miDetVenta) {
        try {
            Conectar miconexion= new Conectar();
            String sentenciaInsert= "Insert into detalleFactura (IdDetalleFactura,IdVFactura,Precio,largoP,altoP,"
                    + "M2,Cantidad,PrecioM2,codArticulo,idProducto) values (?,?,?,?,?,?,?,?,?,?)";
           
            miconexion.psPrepararSentencias = miconexion.miconexion.prepareStatement(sentenciaInsert);
            miconexion.psPrepararSentencias.setString(1, "" + miDetVenta.getIdDetalleFactura());
            miconexion.psPrepararSentencias.setString(2, "" + miDetVenta.getIdVFactura());
            miconexion.psPrepararSentencias.setString(3, "" + miDetVenta.getPrecio());
            miconexion.psPrepararSentencias.setString(4, "" + miDetVenta.getLargoP());
            miconexion.psPrepararSentencias.setString(5, "" + miDetVenta.getAltoP());
            miconexion.psPrepararSentencias.setString(6, "" + miDetVenta.getM2());
            miconexion.psPrepararSentencias.setString(7, "" + miDetVenta.getCantidad());
            miconexion.psPrepararSentencias.setString(8, "" + miDetVenta.getPrecioM2());
            miconexion.psPrepararSentencias.setString(9, "" + miDetVenta.getCodArticulo());
            miconexion.psPrepararSentencias.setString(10, "" + miDetVenta.getIdProducto());
            
            miconexion.psPrepararSentencias.executeUpdate();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.toString()); //joptionpane para que aparezca un cartel con el error.
        }        
    }
     
   public ResultSet listarVentaPorFecha(String criterio,Date fechaini, Date fechafin) throws Exception{
        ResultSet rs = null;
        try{
            CallableStatement statement = connection.prepareCall("{call SP_S_VentaPorFecha(?,?,?)}");
            statement.setString ("pcriterio", criterio);
            statement.setDate ("pfechaini", new java.sql.Date(fechaini.getTime()));
            statement.setDate ("pfechafin", new java.sql.Date(fechafin.getTime()));
            rs = statement.executeQuery();
            return rs;
        }catch(SQLException SQLex){
            throw SQLex;            
        }        
    }   
}
