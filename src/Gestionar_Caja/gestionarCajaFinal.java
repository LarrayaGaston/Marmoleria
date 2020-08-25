/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestionar_Caja;

import Clases.CajaFinal;
import Componentes.conectar;
import Metodos.Conectar;

import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author fernando
 */
public class gestionarCajaFinal {
    private Connection connection=new conectar().conexion();

    public void GuardarCajaFinal(CajaFinal micaja) {
        try {
            Conectar miconexion= new Conectar();
            String sentenciaInsert= "Insert into caja_final (idcajafin,idcajaini,totalventa,totalingreso,totalegreso,total,"
                    + "cajafinal,totalefectivo,diferencia) values (?,?,?,?,?,?,?,?,?)";
            
            miconexion.psPrepararSentencias= miconexion.miconexion.prepareStatement(sentenciaInsert);
            miconexion.psPrepararSentencias.setString(1, ""+micaja.getcodcajafin());
            miconexion.psPrepararSentencias.setString(2, ""+micaja.getcodcajaini());
            miconexion.psPrepararSentencias.setString(3, ""+micaja.getventa());
            miconexion.psPrepararSentencias.setString(4, ""+micaja.getingreso());
            miconexion.psPrepararSentencias.setString(5, ""+micaja.getegreso());
            miconexion.psPrepararSentencias.setString(6, ""+micaja.gettotal());
            miconexion.psPrepararSentencias.setString(7, ""+micaja.gettotalcaja());
            miconexion.psPrepararSentencias.setString(8, ""+micaja.gettotalefectivo());
            miconexion.psPrepararSentencias.setString(9, ""+micaja.getdiferencia());
            miconexion.psPrepararSentencias.executeUpdate();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.toString()); //joptionpane para que aparezca un cartel con el error.
        }        
    }
}
