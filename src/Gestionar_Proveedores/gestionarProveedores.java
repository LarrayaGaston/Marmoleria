/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestionar_Proveedores;

import Clases.Cliente;
import Clases.Persona;
import Clases.Proveedor;
import Metodos.Conectar;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author luca
 */
public class gestionarProveedores {
    
    
        
       public void GuardarProveedor(Proveedor miProveedor) {
        try {
            Conectar miconexion= new Conectar();
            String sentenciaInsert= "Insert into proveedores (idProveedor, prov_razonSocial, prov_cuit, prov_condiva, "
                    + "prov_celular, prov_telefono, prov_fax, prov_email,"
                    + "prov_provincia, prov_ciudad, prov_direccion, prov_codPostal, idPersona,prov_CBU) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            miconexion.psPrepararSentencias= miconexion.miconexion.prepareStatement(sentenciaInsert);
            
            miconexion.psPrepararSentencias.setInt(1, miProveedor.getIdProveedor());
            miconexion.psPrepararSentencias.setString(2, miProveedor.getProv_razonSocial());
            miconexion.psPrepararSentencias.setString(3, miProveedor.getProv_cuit());
            miconexion.psPrepararSentencias.setInt(4,  miProveedor.getProv_condiva());
            
            miconexion.psPrepararSentencias.setString(5, miProveedor.getProv_celular());
            miconexion.psPrepararSentencias.setString(6, miProveedor.getProv_telefono());
            miconexion.psPrepararSentencias.setString(7, miProveedor.getProv_fax());
            miconexion.psPrepararSentencias.setString(8, miProveedor.getProv_email());
            
            miconexion.psPrepararSentencias.setInt(9, miProveedor.getProv_Provincia());
            miconexion.psPrepararSentencias.setInt(10, miProveedor.getProv_Ciudad());
            miconexion.psPrepararSentencias.setString(11, miProveedor.getProv_direccion());
            miconexion.psPrepararSentencias.setInt(12, miProveedor.getProv_codPostal());
            miconexion.psPrepararSentencias.setInt(13, miProveedor.getIdPersona());
            miconexion.psPrepararSentencias.setString(14, miProveedor.getProv_CBU());
   
          
            miconexion.psPrepararSentencias.executeUpdate();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.toString()); //joptionpane para que aparezca un cartel con el error.
        }        
    }
    
       
       public void modificarProveedor(Proveedor modProv) {
        try {
            Conectar miconexion = new Conectar();
            String sentenciamodificar = "UPDATE proveedores SET `prov_razonSocial`=?, "
                    + "`prov_condiva`=?, `prov_telefono`=?, `prov_celular`=?, `prov_fax`=?, `prov_cuit`=?, `prov_email`=?, "
                    + "`prov_provincia`=?, `prov_ciudad`=?, `prov_direccion`=?, `prov_codpostal`=?,`prov_CBU`=? "
                    + "WHERE idProveedor=?";
                    
                    
            miconexion.psPrepararSentencias= miconexion.miconexion.prepareStatement(sentenciamodificar);
            miconexion.psPrepararSentencias.setInt(1, modProv.getIdProveedor());
            miconexion.psPrepararSentencias.setString(5,  modProv.getProv_razonSocial());
            miconexion.psPrepararSentencias.setString(10, modProv.getProv_cuit());
            
            miconexion.psPrepararSentencias.setInt(6,  modProv.getProv_condiva());
            miconexion.psPrepararSentencias.setString(8,  modProv.getProv_celular());
            miconexion.psPrepararSentencias.setString(7,  modProv.getProv_telefono());
            miconexion.psPrepararSentencias.setString(9,  modProv.getProv_fax());
            miconexion.psPrepararSentencias.setString(11,  modProv.getProv_email());
            
            miconexion.psPrepararSentencias.setInt(12,  modProv.getProv_Provincia());
            miconexion.psPrepararSentencias.setInt(13,  modProv.getProv_Ciudad());
            miconexion.psPrepararSentencias.setString(14,  modProv.getProv_direccion());
            miconexion.psPrepararSentencias.setInt(16,  modProv.getProv_codPostal());
            miconexion.psPrepararSentencias.setString(17,  modProv.getProv_CBU());
         /**   
            miconexion.psPrepararSentencias.setString(2,  modCliente.getCli_nombre());
            miconexion.psPrepararSentencias.setString(3,  modCliente.getCli_apellido());
           // miconexion.psPrepararSentencias.setString(15,  ""+new java.sql.Date(miCliente.getCli_fecha_nacimiento().getTime()));
            miconexion.psPrepararSentencias.setString(15,  modCliente.getCli_fecha_nacimiento());
            miconexion.psPrepararSentencias.setInt(4,  modCliente.getCli_dni());
        */

            miconexion.psPrepararSentencias.executeUpdate();
        
              
            
       
       
     } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            System.out.print(e.getMessage());
        }

    }
    
    
       
    
}
