/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestionar_Caja;

import Clases.CajaInicial;
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
public class gestionarCajaInicial {
  
   private Connection connection=new conectar().conexion();

    public void GuardarCajaInicial(CajaInicial micaja) {
        try {
            Conectar miconexion= new Conectar();
            String sentenciaInsert= "Insert into caja_inicial (idcaja,efectivo,fecha) values (?,?,?)";
            
            miconexion.psPrepararSentencias= miconexion.miconexion.prepareStatement(sentenciaInsert);
            miconexion.psPrepararSentencias.setString(1, ""+micaja.getcodcaja());
            miconexion.psPrepararSentencias.setString(2, ""+micaja.getefectivo());
            miconexion.psPrepararSentencias.setString(3, ""+ new java.sql.Date(micaja.getfecha().getTime()));
            miconexion.psPrepararSentencias.executeUpdate();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.toString()); //joptionpane para que aparezca un cartel con el error.
        }        
    }
    
    public ResultSet listarCajaPorFecha(String criterio,Date fechaini, Date fechafin) throws Exception{
        ResultSet rs = null;
        try{
            
            CallableStatement statement = connection.prepareCall("{call SP_S_CajaPorFecha(?,?,?)}");
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
