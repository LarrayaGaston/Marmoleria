/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * //* @author Fernando,Estaban y Lucas
 */
public class buscarid {
          
    
    public int buscarid(String nombreindice, String nombretabla, String CondicionBusqueda, String NombreaBuscar)
    
          {
        try
            {
                Conectar miconexion = new Conectar();
            String consultasql = "Select " + nombreindice + " from " + nombretabla + " where " +
         CondicionBusqueda + " like '" + NombreaBuscar + "'";
             ResultSet rs =miconexion.consulta(consultasql);
            int id=0;
            while (rs.next())
                    {
                id=Integer.parseInt(rs.getString(1));
                    }
            return id;
            
            }
               catch (Exception e)
               {
                   JOptionPane.showMessageDialog(null, e.getMessage());
               return 0;
                }
    }
    
   public int BuscarID (String campo, String tabla, String nombreWhere, String datoCombo){
        try{
            Conectar miconexion = new Conectar();
            String sentenciaID = "Select "+campo+" from "+tabla+" where "+nombreWhere+" like '"+datoCombo+"'";
            ResultSet rs = miconexion.consulta(sentenciaID); 
            rs.next();
            return Integer.parseInt(rs.getString(1));            
        }
        catch(Exception e){
           //e.toString() es para que te mustre el error si lo tenes 
           JOptionPane.showMessageDialog(null, e.toString()); 
           return 0;
        }
    }
    
        public int BuscarULTIMOID (String campo, String tabla){
        try{
            Conectar miconexion = new Conectar();
            String sentenciaID = "Select MAX("+campo+")+1 from "+tabla+"";// where "+nombreWhere+" like '"+datoCombo+"'";
            ResultSet rs = miconexion.consulta(sentenciaID); 
            rs.next();
            return Integer.parseInt(rs.getString(1));
            
            
            
            
        }
        catch(Exception e){
           //e.toString() es para que te mustre el error si lo tenes 
         //  JOptionPane.showMessageDialog(null, e.toString()); 
          return 1;
        }
    }
   
    
}
