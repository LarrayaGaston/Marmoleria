/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Clases.Articulo;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Fernando,Estaban y Lucas
 */
public class Actualizar {
       
        public void actualizarproducto (Articulo miproducto, double cant){
             try 
                    {
                     Conectar miconexion = new Conectar ();      
                     String cons = "Select stock from articulo where idarticulo like '" + miproducto.getCodArticulo() + "'";
                     ResultSet rs = miconexion.consulta(cons);
                     while (rs.next())
                            {   
                               
                             double cantidad = Integer.parseInt(rs.getString("stock"));
                             double nuevacantidad =  cant;
                             double total = cantidad+nuevacantidad;
                             String sentenciaUpdate = "UPDATE articulo SET stock = " + total + " where idarticulo = " + miproducto.getCodArticulo();
                             
                             miconexion.psPrepararSentencias = miconexion.miconexion.prepareStatement(sentenciaUpdate);
                             miconexion.psPrepararSentencias.executeUpdate();
                            }         
                    }

       catch (Exception e)
             {
              JOptionPane.showMessageDialog(null, "Error Actualizar "+e.getCause());
             }
         
        }
        public void actualizarproductoventa (Articulo miproducto, double cant){
             try 
                    {
                     Conectar miconexion = new Conectar ();      
                     String cons = "Select stock from articulo where idarticulo like '" + miproducto.getCodArticulo() + "'";
                     ResultSet rs = miconexion.consulta(cons);
                     while (rs.next())
                            {   
                               
                             double cantidad = Integer.parseInt(rs.getString("stock"));
                             double nuevacantidad =  cant;
                             double total = cantidad-nuevacantidad;
                             String sentenciaUpdate = "UPDATE articulo SET stock = " + total + " where idarticulo = " + miproducto.getCodArticulo();
                             
                             miconexion.psPrepararSentencias = miconexion.miconexion.prepareStatement(sentenciaUpdate);
                             miconexion.psPrepararSentencias.executeUpdate();
                            }         
                    }

       catch (Exception e)
             {
              JOptionPane.showMessageDialog(null, "Error Actualizar "+e.getCause());
             }
         
        }
}
