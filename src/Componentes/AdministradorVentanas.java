/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;


import Gestionar_Clientes.iFDescripcionClientes;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;

/**
 *
 * @author Gaston
 */
public class AdministradorVentanas {
    
        private static iFDescripcionClientes ftc;
    

    public static void mostrarVentanaFactura(JDesktopPane dp)
    {
        
        if(ftc != null && !ftc.isShowing())
       {
           ftc.show();
           dp.remove(ftc);
            try{
                dp.add(ftc, JLayeredPane.DEFAULT_LAYER); 
            }catch(IllegalArgumentException ex){               
                dp.add(ftc, JLayeredPane.DEFAULT_LAYER);                
            }    
       }
        
        if(ftc == null)
        {
          ftc = new iFDescripcionClientes();
          dp.add(ftc, JLayeredPane.DEFAULT_LAYER);
        } 
       activarVentana(dp,ftc);     
    }
    
      private static void activarVentana(JDesktopPane dp,JInternalFrame vnt)
    {
        try {
            vnt.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(AdministradorVentanas.class.getName()).log(Level.SEVERE, null, ex);
        }
        dp.setPosition(vnt, 0);
    }
}
