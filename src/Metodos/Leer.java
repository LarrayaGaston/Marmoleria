/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Clases.Marca;
import Clases.Persona;
import Clases.Proveedor;
import Clases.Rubro;
import Clases.Tipo;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaston
 */
public class Leer {
    
    public Rubro[] leer_rubros(){
        
          try{
              Conectar miConec = new Conectar();   // Instancia el conector
              
              String consultaSQL = "Select * From rubro order by idRubro ";   // escribo la consulta SQL
              
              ResultSet rs = miConec.consulta(consultaSQL);      // rs crea un Resulset de datos (creamos un contenedor de datos)
              
              rs.last(); // se va al ultimo registro
              
              Rubro miRubro[] = new Rubro[rs.getRow()];   // trae la fila en la q esta parado el puntero
              
              rs.beforeFirst(); // se vuelve arriba 
              while(rs.next()){
                  
                  miRubro[rs.getRow()-1]= new Rubro();
                  
                  miRubro[rs.getRow()-1].setIdRubro(rs.getInt("idRubro"));
                  miRubro[rs.getRow()-1].setNombreRubro(rs.getString("nombreRubro"));
                
              
              }
             
              
              rs.close();
              
              return miRubro;
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e);
            return null;
        }
    }
    
     public Marca[] leer_marca(){
        
          try{
              Conectar miConec = new Conectar();   // Instancia el conector
              
              String consultaSQL = "Select * From marca order by idMarca ";   // escribo la consulta SQL
              
              ResultSet rs = miConec.consulta(consultaSQL);      // rs crea un Resulset de datos (creamos un contenedor de datos)
              
              rs.last(); // se va al ultimo registro
              
              Marca miMarca[] = new Marca[rs.getRow()];   // trae la fila en la q esta parado el puntero
              
              rs.beforeFirst(); // se vuelve arriba 
              while(rs.next()){
                  
                  miMarca[rs.getRow()-1]= new Marca();
                  
                  miMarca[rs.getRow()-1].setIdMarca(rs.getInt("idMarca"));
                  miMarca[rs.getRow()-1].setDetalleMarca(rs.getString("detalleMarca"));
                  
                
              
              }
             
              
              rs.close();
              
              return miMarca;
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e);
            return null;
        }
    }
    
       
        public Tipo[] leer_tipo(){
        
          try{
              Conectar miConec = new Conectar();   // Instancia el conector
              
              String consultaSQL = "Select * From tipo order by idTipo";   // escribo la consulta SQL
              
              ResultSet rs = miConec.consulta(consultaSQL);      // rs crea un Resulset de datos (creamos un contenedor de datos)
              
              rs.last(); // se va al ultimo registro
              
              Tipo miTipo[] = new Tipo[rs.getRow()];   // trae la fila en la q esta parado el puntero
              
              rs.beforeFirst(); // se vuelve arriba 
              while(rs.next()){
                  
                  miTipo[rs.getRow()-1]= new Tipo();
                  
                  miTipo[rs.getRow()-1].setIdTipo(rs.getInt("idTipo"));
                  miTipo[rs.getRow()-1].setDetalle_tipo(rs.getString("detalle_tipo"));
                
              
              }
             
              
              rs.close();
              
              return miTipo;
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e);
            return null;
        }
    }
        
         public Proveedor[] leer_Proveedor(){
        
          try{
              Conectar miConec = new Conectar();   // Instancia el conector
              
              String consultaSQL = "Select * From proveedores ";   // escribo la consulta SQL
              
              ResultSet rs = miConec.consulta(consultaSQL);      // rs crea un Resulset de datos (creamos un contenedor de datos)
              
              rs.last(); // se va al ultimo registro
              
              Proveedor miProveedor[] = new Proveedor[rs.getRow()];   // trae la fila en la q esta parado el puntero
              
              rs.beforeFirst(); // se vuelve arriba 
              while(rs.next()){
                  
                  miProveedor[rs.getRow()-1]= new Proveedor();
                  
                  miProveedor[rs.getRow()-1].setIdProveedor(rs.getInt("idProveedor"));
                  miProveedor[rs.getRow()-1].setProv_razonSocial(rs.getString("prov_razonSocial"));
                
              
              }
             
              
              rs.close();
              
              return miProveedor;
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e);
            return null;
        }
    }
       
       public int leerUltimaFac() {

        try {

            Conectar miconexion = new Conectar();

            String id = "SELECT idVFactura FROM ventafactura where idVFactura=(SELECT max(idVFactura) FROM ventafactura)";

            ResultSet rs = miconexion.consulta(id);
            rs.next();

            return Integer.parseInt(rs.getString(1));

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.toString());

        }

        return 0;
    }
     
        
}
