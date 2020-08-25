/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Clases.Marca;
import Clases.Proveedor;
import Clases.Rubro;
import Clases.Tipo;

import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

//* @author Fernando,Estaban y Lucas

public class CargarCombo {
 
    public JComboBox cargacombo(JComboBox micombo,String consultaMCQL)
{
    try{   
            DefaultComboBoxModel modelocombo = new DefaultComboBoxModel();
            Conectar miconexion= new Conectar();
            ResultSet consulta=miconexion.consulta(consultaMCQL);
                while(consulta.next())
              {
               modelocombo.addElement(consulta.getString(1));
           //    modelocombo.addElement(new Combo(Integer.parseInt(consulta.getString(1))));
              }
            micombo.setModel(modelocombo);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    return(micombo);
    
    
}
    
     public DefaultComboBoxModel cargar_combo_rubro (DefaultComboBoxModel MiObjCombo, Rubro [] miRubro){
        
         for(int i=0; i<miRubro.length; i++)
            {
                JItem miJItem = new JItem(); 
               
                miJItem.setItemData( miRubro[i].getIdRubro());
                miJItem.setItem( miRubro[i].getNombreRubro());
                
                MiObjCombo.addElement(miJItem);
                
              
            }
         
         return MiObjCombo;
    }
     
     
    public DefaultComboBoxModel cargar_combo_marca (DefaultComboBoxModel MiObjCombo, Marca[] miMarca){
        
         for(int i=0; i<miMarca.length; i++)
            {
                JItem miJItem = new JItem(); 
               
                miJItem.setItemData( miMarca[i].getIdMarca());
                miJItem.setItem( miMarca[i].getDetalleMarca());
                
                MiObjCombo.addElement(miJItem);
                
              
            }
         
         return MiObjCombo;
    }
    
     public DefaultComboBoxModel cargar_combo_proveedor (DefaultComboBoxModel MiObjCombo, Proveedor [] miProv){
        
         for(int i=0; i<miProv.length; i++)
            {
                JItem miJItem = new JItem(); 
               
                miJItem.setItemData( miProv[i].getIdProveedor());
                miJItem.setItem( miProv[i].getProv_razonSocial());
                
                MiObjCombo.addElement(miJItem);
                
              
            }
         
         return MiObjCombo;
    }
     
     public DefaultComboBoxModel cargar_combo_tipo (DefaultComboBoxModel MiObjCombo, Tipo[] miTipo){
        
         for(int i=0; i<miTipo.length; i++)
            {
                JItem miJItem = new JItem(); 
               
                miJItem.setItemData( miTipo[i].getIdTipo());
                miJItem.setItem( miTipo[i].getDetalle_tipo());
                
                MiObjCombo.addElement(miJItem);
                
              
            }
         
         return MiObjCombo;
    }
    
}
