/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestionar_Stock;

import Clases.DetalleSalidaStock;
import Clases.SalidaStock;
import Metodos.Conectar;
import javax.swing.JOptionPane;

/**
 *
 //* @author Fernando,Estaban y Lucas
 */
public class gestionarSalida {
    
    public void guardarSalida ( SalidaStock nueSalida){
     try 
            {
                        Conectar miconexion= new Conectar();
            String sentenciaInsert= "Insert into salida_stock (idsalida,idmotivo,fecha) values (?,?,?)";
            miconexion.psPrepararSentencias= miconexion.miconexion.prepareStatement(sentenciaInsert);
            miconexion.psPrepararSentencias.setString(1,  ""+nueSalida.getIdsalida());
            miconexion.psPrepararSentencias.setString(3,  ""+new java.sql.Date(nueSalida.getFecha().getTime()));
            miconexion.psPrepararSentencias.setString(2,  ""+nueSalida.getIdmotivo());
             miconexion.psPrepararSentencias.executeUpdate();
        }
     catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.toString()); //joptionpane para que aparezca un cartel con el error.
        } 
    
    }

     public void detalleSalida ( DetalleSalidaStock detalleSal){
     try 
            {
                        Conectar miconexion= new Conectar();
            String sentenciaInsert= "Insert into detalle_salida_stock (iddetallesalida,idsalida,idarticulo,cantidad) values (?,?,?,?)";
            miconexion.psPrepararSentencias= miconexion.miconexion.prepareStatement(sentenciaInsert);
            miconexion.psPrepararSentencias.setString(1,  ""+detalleSal.getIddetallesalida());
            miconexion.psPrepararSentencias.setString(2,  ""+detalleSal.getIdsalida());
            miconexion.psPrepararSentencias.setString(3, ""+detalleSal.getIdarticulo());
            miconexion.psPrepararSentencias.setString(4, ""+detalleSal.getCantidad());
             miconexion.psPrepararSentencias.executeUpdate();
        }
     catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.toString()); //joptionpane para que aparezca un cartel con el error.
        } 
    
    }

     
               public void anularSalida (String valor) {
        try {
            Conectar miconexion= new Conectar();
           String sentenciadelete = "Delete from Salidas where sal_codigo like '"+valor+"'";
             miconexion.psPrepararSentencias = miconexion.miconexion.prepareStatement(sentenciadelete);
             miconexion.psPrepararSentencias.executeUpdate();
        }
  catch (Exception e){
            JOptionPane.showMessageDialog(null, e.toString());   
            
            
        }
}
                              public void anularDetalleSalida (String valor) {
        try {
            Conectar miconexion= new Conectar();
           String sentenciadelete = "Delete from detalle_salida where ds_salida like '"+valor+"'";
             miconexion.psPrepararSentencias = miconexion.miconexion.prepareStatement(sentenciadelete);
             miconexion.psPrepararSentencias.executeUpdate();
        }
  catch (Exception e){
            JOptionPane.showMessageDialog(null, e.toString());             
        }
}
}