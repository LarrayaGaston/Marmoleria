/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestionar_Cliente;

import Clases.Cliente;
import Metodos.Conectar;
import javax.swing.JOptionPane;

/**
 *
 * @author luca
 */
public class gestionarCliente {
    
    
        
       public void GuardarCliente(Cliente miCliente) {
        try {
            Conectar miconexion= new Conectar();
            String sentenciaInsert= "Insert into Clientes (idCliente, cli_razonsocial,cli_cuit "
                    + ",cli_condiva,  cli_celular, cli_telefono, cli_fax, cli_email,"
                    + "cli_provincia, cli_ciudad, cli_direccion, cli_codpostal, idPersona,cli_CBU)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
            
            miconexion.psPrepararSentencias= miconexion.miconexion.prepareStatement(sentenciaInsert);
            
            miconexion.psPrepararSentencias.setInt(1, miCliente.getIdCliente());
            miconexion.psPrepararSentencias.setString(2,  miCliente.getCli_razonSocial());
            miconexion.psPrepararSentencias.setString(3, miCliente.getCli_cuit());
            
            miconexion.psPrepararSentencias.setInt(4,  miCliente.getCli_condiva());
            miconexion.psPrepararSentencias.setString(5,  miCliente.getCli_celular());
            miconexion.psPrepararSentencias.setString(6,  miCliente.getCli_telefono());
            miconexion.psPrepararSentencias.setString(7,  miCliente.getCli_fax());
            miconexion.psPrepararSentencias.setString(8,  miCliente.getCli_email());
            
            miconexion.psPrepararSentencias.setInt(9,  miCliente.getCli_Provincia());
            miconexion.psPrepararSentencias.setInt(10,  miCliente.getCli_Ciudad());
            miconexion.psPrepararSentencias.setString(11,  miCliente.getCli_direccion());
            miconexion.psPrepararSentencias.setInt(12,  miCliente.getCli_codPostal());
            miconexion.psPrepararSentencias.setInt(13,  miCliente.getIdPersona());
            miconexion.psPrepararSentencias.setString(14, miCliente.getCli_CBU());
            
           
           // miconexion.psPrepararSentencias.setString(15,  ""+new java.sql.Date(miCliente.getCli_fecha_nacimiento().getTime()));
         
          
            miconexion.psPrepararSentencias.executeUpdate();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.toString()); //joptionpane para que aparezca un cartel con el error.
        }        
    }
    
    

     

    public void modCliente(Cliente modCliente) {
        try {
            Conectar miconexion = new Conectar();
            String sentenciaModificar = "UPDATE clientes SET cli_razonsocial='" + modCliente.getCli_razonSocial()
                    + "'," + "cli_direccion='" + modCliente.getCli_direccion()
                    + "'," + "cli_email='" + modCliente.getCli_email()
                    + "',cli_cuit=" + modCliente.getCli_cuit()
                    + ",cli_condiva=" + modCliente.getCli_condiva()
                    + ",cli_telefono=" + modCliente.getCli_telefono()
                    + ",cli_celular=" + modCliente.getCli_celular()
                    + ",cli_fax=" + modCliente.getCli_fax()
                    + ",cli_provincia=" + modCliente.getCli_Provincia()
                    + ",cli_ciudad=" + modCliente.getCli_Ciudad()
                    + ",idpersona=" + modCliente.getIdPersona()
                    + ",cli_codpostal=" + modCliente.getCli_codPostal()
                    +",cli_CBU="+ modCliente.getCli_CBU()
                    + " WHERE idCliente=" + modCliente.getIdCliente() + "";
             miconexion.psPrepararSentencias = miconexion.miconexion.prepareStatement(sentenciaModificar);
             miconexion.psPrepararSentencias.executeUpdate();
        }
  catch (Exception e){
            JOptionPane.showMessageDialog(null, e.toString());    
            System.out.print(e.getMessage());
        }
 
    }
       
       

}

