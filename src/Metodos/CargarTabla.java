/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Clases.Articulo;
import Clases.Marca;
import Clases.Persona;
import Clases.Rubro;
import Clases.Tipo;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gaston
 */
public class CargarTabla {
    
      public JTable cargar_tabla_Proveedores(JTable miTabla, Persona[] miPersona, String titulos[]){
        
        DefaultTableModel ObjTabla = new DefaultTableModel(); // Creamos el obj tabla
        
        ObjTabla.setColumnCount(0);  // ponemos las columnas en cero
        ObjTabla.setRowCount(0);    // ponemos las filas en 0
        ObjTabla.setColumnIdentifiers(titulos);  // se le asignan los titulos a la tabla 
        
        miTabla.setModel(ObjTabla);  //seteo el modelo en la tabla
        
        String datos [] = new String[titulos.length];
        
        for(int i=0; i<miPersona.length; i++ ){
            
            datos[0]= String.valueOf(miPersona[i].getIdPersona());
            datos[1]= (miPersona[i].getNombre());
            datos[2]= (miPersona[i].getApellido());
          
            ObjTabla.addRow(datos);
        
        }
                              
       
       return miTabla;
    }
      
    public JTable cargar_tabla_Marca(JTable miTabla, Marca[] miMarca, String titulos[]){
        
        DefaultTableModel ObjTabla = new DefaultTableModel(); // Creamos el obj tabla
        
        ObjTabla.setColumnCount(0);  // ponemos las columnas en cero
        ObjTabla.setRowCount(0);    // ponemos las filas en 0
        ObjTabla.setColumnIdentifiers(titulos);  // se le asignan los titulos a la tabla 
        
        miTabla.setModel(ObjTabla);  //seteo el modelo en la tabla
        
        String datos [] = new String[titulos.length];
        
        for(int i=0; i<miMarca.length; i++ ){
            
            datos[0]= String.valueOf(miMarca[i].getIdMarca());
            datos[1]= (miMarca[i].getDetalleMarca());
            
          
            ObjTabla.addRow(datos);
        
        }
                              
       
       return miTabla;
    }
    
    public JTable cargar_tabla_Tipo(JTable miTabla, Tipo[] miTipo, String titulos[]){
        
        DefaultTableModel ObjTabla = new DefaultTableModel(); // Creamos el obj tabla
        
        ObjTabla.setColumnCount(0);  // ponemos las columnas en cero
        ObjTabla.setRowCount(0);    // ponemos las filas en 0
        ObjTabla.setColumnIdentifiers(titulos);  // se le asignan los titulos a la tabla 
        
        miTabla.setModel(ObjTabla);  //seteo el modelo en la tabla
        
        String datos [] = new String[titulos.length];
        
        for(int i=0; i<miTipo.length; i++ ){
            
            datos[0]= String.valueOf(miTipo[i].getIdTipo());
            datos[1]= (miTipo[i].getDetalle_tipo());
          
          
            ObjTabla.addRow(datos);
        
        }
                              
       
       return miTabla;
    }
     
    public JTable cargar_tabla_Rubro(JTable miTabla, Rubro[] miRubro, String titulos[]){
        
        DefaultTableModel ObjTabla = new DefaultTableModel(); // Creamos el obj tabla
        
        ObjTabla.setColumnCount(0);  // ponemos las columnas en cero
        ObjTabla.setRowCount(0);    // ponemos las filas en 0
        ObjTabla.setColumnIdentifiers(titulos);  // se le asignan los titulos a la tabla 
        
        miTabla.setModel(ObjTabla);  //seteo el modelo en la tabla
        
        String datos [] = new String[titulos.length];
        
        for(int i=0; i<miRubro.length; i++ ){
            
            datos[0]= String.valueOf(miRubro[i].getIdRubro());
            datos[1]= (miRubro[i].getNombreRubro());
            
          
            ObjTabla.addRow(datos);
        
        }
                              
       
       return miTabla;
    }
    
    
}
