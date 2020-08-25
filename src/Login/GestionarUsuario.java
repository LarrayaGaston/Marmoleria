/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Clases.Usuario;
import Componentes.conectar;
import Metodos.Conectar;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaston
 */
public class GestionarUsuario {
    
    private Connection connection=new conectar().conexion();
    
     
     public void GuardarUsuario(Usuario miUsuario) {
        try {
            Conectar miconexion= new Conectar();
            String sentenciaInsert= "Insert into usuario (idUsuario,nombre,apellido,"
                    + " nombreUsuario,tipoRespSecre,respuesta,contraseña) "
             
                    + "values (?,?,?,?,?,?,?)"; 
            
            miconexion.psPrepararSentencias= miconexion.miconexion.prepareStatement(sentenciaInsert);
            
            miconexion.psPrepararSentencias.setInt(1, miUsuario.getIdUsuario());
            miconexion.psPrepararSentencias.setString(2, miUsuario.getNombre());
            miconexion.psPrepararSentencias.setString(3, miUsuario.getApellido());
            miconexion.psPrepararSentencias.setString(4, miUsuario.getNombreUsuario());
            miconexion.psPrepararSentencias.setString(5, miUsuario.getTipoRespSecre());
            miconexion.psPrepararSentencias.setString(6, miUsuario.getRespuesta());
            miconexion.psPrepararSentencias.setString(7, miUsuario.getContraseña());
            
           
         
            
           
           // miconexion.psPrepararSentencias.setString(15,  ""+new java.sql.Date(miCliente.getCli_fecha_nacimiento().getTime()));
         
          
            miconexion.psPrepararSentencias.executeUpdate();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.toString()); //joptionpane para que aparezca un cartel con el error.
        }        
    }
    
    public ResultSet Login(String usu, String contra) throws Exception{
    
        ResultSet rs=null;
        try{
            CallableStatement statement=connection.prepareCall("{call SP_S_Login(?,?)}");
            statement.setString("pusuario", usu);
            statement.setString("pcontraseña", contra);
            
            rs=statement.executeQuery();
            return rs;
        }catch(SQLException SQLex){
            throw SQLex;
        }    
    }
      
         public void cambiarContraseña(String codigo,Usuario Usuario){
        try{
            CallableStatement statement=connection.prepareCall("{call SP_U_CambiarPass(?,?)}");
            statement.setString("pidempleado",codigo);
            statement.setString("pcontraseña",Usuario.getContraseña());
            statement.executeUpdate();
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        JOptionPane.showMessageDialog(null,"¡Se cambio contraseña satisfactoriamente!","Mensaje del Sistema",1);
    }     
    
}
