/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Clases.Articulo;
import Clases.Marca;
import Clases.Rubro;
import Clases.Tipo;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaston
 */
public class gestionarArticulo {
    
     public void GuardarArticulo(Articulo miArticulo) {
        try {
            Conectar miconexion= new Conectar();
            String sentenciaInsert= "Insert into articulo (idArticulo, detalle_articulo,codArticulo "
                    + ",idRubro,  idMarca, idTipo, dimensionLargo,dimensionAlto,"
                    + "PrecioVta,precioCosto,precioTarjeta,StockMin,"
                    + "largoBacha, altoBacha, anchoBacha, art_impuesto,Stock, FechaAlta)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
            
            miconexion.psPrepararSentencias= miconexion.miconexion.prepareStatement(sentenciaInsert);
            
            miconexion.psPrepararSentencias.setInt(1, miArticulo.getIdArticulo());
            miconexion.psPrepararSentencias.setString(2,  miArticulo.getDetalle_articulo());
            miconexion.psPrepararSentencias.setInt(3, miArticulo.getCodArticulo());
            
            miconexion.psPrepararSentencias.setInt(4,  miArticulo.getIdRubro());
            miconexion.psPrepararSentencias.setInt(5,  miArticulo.getIdMarca());
            miconexion.psPrepararSentencias.setInt(6,  miArticulo.getIdTipo());
            miconexion.psPrepararSentencias.setDouble(7,  miArticulo.getDimensionLargo());
            miconexion.psPrepararSentencias.setDouble(8,  miArticulo.getDimensionAlto());
            
            miconexion.psPrepararSentencias.setDouble(9,  miArticulo.getPrecioVta());
            miconexion.psPrepararSentencias.setDouble(10,  miArticulo.getPrecioCosto());
            miconexion.psPrepararSentencias.setDouble(11,  miArticulo.getPrecioTarjeta());
            miconexion.psPrepararSentencias.setInt(12,  miArticulo.getStockMin());
            
            miconexion.psPrepararSentencias.setString(13,  miArticulo.getLargoBacha());
            miconexion.psPrepararSentencias.setString(14,  miArticulo.getAltoBacha());
            miconexion.psPrepararSentencias.setString(15,  miArticulo.getAnchoBacha());
            miconexion.psPrepararSentencias.setString(16,  miArticulo.getImpuesto());
            miconexion.psPrepararSentencias.setInt(17,  miArticulo.getStock());
            miconexion.psPrepararSentencias.setString(18,  miArticulo.getFechaAlta());
            
            
           
           // miconexion.psPrepararSentencias.setString(15,  ""+new java.sql.Date(miCliente.getCli_fecha_nacimiento().getTime()));
         
          
            miconexion.psPrepararSentencias.executeUpdate();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.toString()); //joptionpane para que aparezca un cartel con el error.
        }        
    }
    
     
      public void GuardarRubro(Rubro miRubro) {
        try {
            Conectar miconexion= new Conectar();
            String sentenciaInsert= "Insert into rubro (idRubro, nombreRubro)"
                    + "values (?,?)"; 
            
            miconexion.psPrepararSentencias= miconexion.miconexion.prepareStatement(sentenciaInsert);
            
            miconexion.psPrepararSentencias.setInt(1, miRubro.getIdRubro());
            miconexion.psPrepararSentencias.setString(2,  miRubro.getNombreRubro());
            
            
            
           
           // miconexion.psPrepararSentencias.setString(15,  ""+new java.sql.Date(miCliente.getCli_fecha_nacimiento().getTime()));
         
          
            miconexion.psPrepararSentencias.executeUpdate();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.toString()); //joptionpane para que aparezca un cartel con el error.
        }        
    }
    
       public void GuardarMarca(Marca miMarca) {
        try {
            Conectar miconexion= new Conectar();
            String sentenciaInsert= "Insert into marca (idMarca, detalleMarca, idRubro)"
                    + "values (?,?,?)"; 
            
            miconexion.psPrepararSentencias= miconexion.miconexion.prepareStatement(sentenciaInsert);
            
            miconexion.psPrepararSentencias.setInt(1, miMarca.getIdMarca());
            miconexion.psPrepararSentencias.setString(2,  miMarca.getDetalleMarca());
            miconexion.psPrepararSentencias.setInt(3, miMarca.getIdRubro());

            
            
            
           
           // miconexion.psPrepararSentencias.setString(15,  ""+new java.sql.Date(miCliente.getCli_fecha_nacimiento().getTime()));
         
          
            miconexion.psPrepararSentencias.executeUpdate();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.toString()); //joptionpane para que aparezca un cartel con el error.
        }        
    }
       
       public void GuardarTipo(Tipo miTipo) {
        try {
            Conectar miconexion= new Conectar();
            String sentenciaInsert= "Insert into tipo (idTipo, detalle_tipo, idMarca)"
                    + "values (?,?,?)"; 
            
            miconexion.psPrepararSentencias= miconexion.miconexion.prepareStatement(sentenciaInsert);
            
            miconexion.psPrepararSentencias.setInt(1, miTipo.getIdTipo());
            miconexion.psPrepararSentencias.setString(2,  miTipo.getDetalle_tipo());
            miconexion.psPrepararSentencias.setInt(3, miTipo.getIdMarca());

            
            
            
           
           // miconexion.psPrepararSentencias.setString(15,  ""+new java.sql.Date(miCliente.getCli_fecha_nacimiento().getTime()));
         
          
            miconexion.psPrepararSentencias.executeUpdate();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.toString()); //joptionpane para que aparezca un cartel con el error.
        }        
    }
       
        public void modificarMarca(Marca modMarca){
        try {
             Conectar miconexion = new Conectar();
              String sentenciadelete ="UPDATE marca SET detalleMarca = '"+modMarca.getDetalleMarca()+"' WHERE idMarca = '"+modMarca.getIdMarca()+"'";;
             miconexion.psPrepararSentencias = miconexion.miconexion.prepareStatement(sentenciadelete);
             miconexion.psPrepararSentencias.executeUpdate();
        }
  catch (Exception e){
            JOptionPane.showMessageDialog(null, e.toString());             
        }


      }
         public void modificarTipo(Tipo modTipo){
        try {
             Conectar miconexion = new Conectar();
              String sentenciadelete ="UPDATE tipo SET detalle_tipo = '"+modTipo.getDetalle_tipo()+"' WHERE idTipo = '"+modTipo.getIdTipo()+"'";;
             miconexion.psPrepararSentencias = miconexion.miconexion.prepareStatement(sentenciadelete);
             miconexion.psPrepararSentencias.executeUpdate();
        }
  catch (Exception e){
            JOptionPane.showMessageDialog(null, e.toString());             
        }


      } 
         
          public void modificarRubro(Rubro modRubro){
        try {
             Conectar miconexion = new Conectar();
              String sentenciadelete ="UPDATE rubro SET nombreRubro = '"+modRubro.getNombreRubro()+"' WHERE idRubro= '"+modRubro.getIdRubro()+"'";;
             miconexion.psPrepararSentencias = miconexion.miconexion.prepareStatement(sentenciadelete);
             miconexion.psPrepararSentencias.executeUpdate();
        }
  catch (Exception e){
            JOptionPane.showMessageDialog(null, e.toString());             
        }


      } 
         
}
