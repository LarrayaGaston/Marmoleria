/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import javax.swing.JInternalFrame;

/**
 *
 * @author Gaston
 */
public class InternalFrameImag extends JInternalFrame {
    
    private PanelImagen pi = new PanelImagen();
            
    public InternalFrameImag(){
        
        setContentPane(pi);
    }
            
    public void setImage(String nombreImagen){
        pi.setImage(nombreImagen);
    }
}
