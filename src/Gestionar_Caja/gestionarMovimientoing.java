/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestionar_Caja;

import Clases.MovimientoCaja;
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
 * @author fernando, lucas y esteban
 */
public class gestionarMovimientoing {
    private Connection connection=new conectar().conexion();

    public void GuardarMovimientoCajaing(MovimientoCaja micaja) {
        try {
            Conectar miconexion= new Conectar();
            String sentenciaInsert= "Insert into movimiento_cajaing (idingreso,detalle,monto,fecha) values (?,?,?,?)";
            
            miconexion.psPrepararSentencias= miconexion.miconexion.prepareStatement(sentenciaInsert);
            miconexion.psPrepararSentencias.setString(1, ""+micaja.getcodingreso());
            miconexion.psPrepararSentencias.setString(2, ""+micaja.getdetalle());
            miconexion.psPrepararSentencias.setString(3, ""+micaja.getmonto());
            miconexion.psPrepararSentencias.setString(4, ""+ new java.sql.Date(micaja.getfecha().getTime()));
            miconexion.psPrepararSentencias.executeUpdate();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.toString()); //joptionpane para que aparezca un cartel con el error.
        }        
    }
    
     
    
}
