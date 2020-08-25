/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Clases.Articulo;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 //* @author Fernando,Estaban y Lucas
 */
public class llamarArticulo {
    public Articulo llamarArt(String columna,String valor){
        Articulo miArticulo=new Articulo();
    try{
        Conectar conexion=new Conectar();
        String Buscar="Select * from articulo where "+columna+" like '"+valor+"'";
       
        ResultSet rs = conexion.consulta(Buscar);
        rs.next();

        miArticulo.setCodArticulo(Integer.parseInt(rs.getString("idarticulo")));

        return miArticulo;
        }    
    catch (Exception e){
        JOptionPane.showMessageDialog(null,"llamar articulo "+ e.getMessage());
        return null;
        }    
    }
}
