/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestionar_compra;

import Clases.Compra;
import Clases.DetalleCompra;
import Componentes.conectar;
import Metodos.Conectar;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author luca
 */
public class gestionarCompra {
     private Connection connection=new conectar().conexion();
    public void GuardarCompra(Compra miCompra) {
        try {
    
             Conectar miconexion= new Conectar();
            String sentenciaInsert= "Insert into compras (idcompra,Numfacproveedor,idproveedor,idcondicionpago,totalcompra,fecha) values (?,?,?,?,?,?)";
            
                        miconexion.psPrepararSentencias= miconexion.miconexion.prepareStatement(sentenciaInsert);
            miconexion.psPrepararSentencias.setString(1, "" +miCompra.getIdcompra());
            miconexion.psPrepararSentencias.setString(2, ""+miCompra.getNumfacproveedor());
            miconexion.psPrepararSentencias.setString(3, ""+miCompra.getIdproveedor());
            miconexion.psPrepararSentencias.setString(4, ""+miCompra.getCondpago());
            miconexion.psPrepararSentencias.setString(5,  ""+miCompra.getTotalcompra());
            miconexion.psPrepararSentencias.setString(6, ""+new java.sql.Date(miCompra.getFecha().getTime()));
            miconexion.psPrepararSentencias.executeUpdate();
            
            
      }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.toString()); //joptionpane para que aparezca un cartel con el error.
        }        
    }
    
      public void GuardarDetalleCompra(DetalleCompra miDetCompra) {
        try {
            Conectar miconexion= new Conectar();
            String sentenciaInsert= "Insert into detalle_compras (iddetallecompras,idcompras,idarticulo,cantidad,precioU,Totalarticulo) values (?,?,?,?,?,?)";
            
            miconexion.psPrepararSentencias= miconexion.miconexion.prepareStatement(sentenciaInsert);
            miconexion.psPrepararSentencias.setString(1, "" +miDetCompra.getIddetallecompra());
            miconexion.psPrepararSentencias.setString(2, ""+miDetCompra.getIdcompra());
            miconexion.psPrepararSentencias.setString(3, ""+miDetCompra.getIdarticulo());
            miconexion.psPrepararSentencias.setString(4,  ""+miDetCompra.getCantidad());
            miconexion.psPrepararSentencias.setString(5, ""+miDetCompra.getPrecioUnitario());
            miconexion.psPrepararSentencias.setString(6, ""+miDetCompra.getTotalArticulo());
            

            miconexion.psPrepararSentencias.executeUpdate();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.toString()); //joptionpane para que aparezca un cartel con el error.
        }        
    }
      
      public ResultSet listarCompraPorFecha(String criterio,Date fechaini, Date fechafin) throws Exception{
        ResultSet rs = null;
        try{
            CallableStatement statement = connection.prepareCall("{call SP_S_CompraPorFecha(?,?,?)}");
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