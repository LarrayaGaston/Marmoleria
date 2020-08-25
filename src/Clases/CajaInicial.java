/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;

/**
 *
 * @author fernando, lucas y esteban
 */
public class CajaInicial {
    
    private String codcaja;
    private String efectivo;
    private Date fecha;
    
    public String getcodcaja() {
        return codcaja;
    }

    public void setcodcaja(String codcaja) {
        this.codcaja = codcaja;
    }
    
    public String getefectivo(){
        return efectivo;
    }
    
    public void setefectivo(String efectivo){
        this.efectivo = efectivo;
    }
    
    public Date getfecha() {
        return fecha;
    }

    public void setfecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
