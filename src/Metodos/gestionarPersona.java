/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Clases.Cliente;
import Clases.Persona;

import java.sql.Date;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Gaston
 */
public class gestionarPersona {
    
      public void GuardarPersona(Persona miPersona) {
        try {
            Conectar miconexion= new Conectar();
            String sentenciaInsert= "Insert into persona (idPersona, nombre, apellido, dni, fechaNacimiento)"
                     + "values (?,?,?,?,?)";
            
            miconexion.psPrepararSentencias= miconexion.miconexion.prepareStatement(sentenciaInsert);
            
            miconexion.psPrepararSentencias.setInt(1, miPersona.getIdPersona());
            miconexion.psPrepararSentencias.setString(2, miPersona.getNombre());
            miconexion.psPrepararSentencias.setString(3, miPersona.getApellido());
            miconexion.psPrepararSentencias.setInt(4, miPersona.getDni());
            miconexion.psPrepararSentencias.setString(5,miPersona.getFechaNacimiento());
            
            
           
          
            miconexion.psPrepararSentencias.executeUpdate();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.toString()); //joptionpane para que aparezca un cartel con el error.
        }        
    }
     
      
            public void modificarPersona(Persona modPersona){
        try {
             Conectar miconexion = new Conectar();
             String sentenciadelete = "UPDATE persona SET nombre='" + modPersona.getNombre()
                  +"'," + "apellido='" + modPersona.getApellido()
                  +"'," + "fechanacimiento='" + modPersona.getFechaNacimiento()
            
                  + "',dni=" + modPersona.getDni() 
                  +" WHERE idpersona=" + modPersona.getIdPersona()+ "";
             miconexion.psPrepararSentencias = miconexion.miconexion.prepareStatement(sentenciadelete);
             miconexion.psPrepararSentencias.executeUpdate();
        }
  catch (Exception e){
            JOptionPane.showMessageDialog(null, e.toString());    
            System.out.print(e.getMessage());
        }
 
    }
      
       
    
       
}


