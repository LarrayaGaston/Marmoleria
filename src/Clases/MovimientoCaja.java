/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;

/**
 *
 * @author fernando
 */
public class MovimientoCaja {
    private String codingreso;
    private String codegreso;
    private String detalle;
    private String monto;
    private Date fecha;
    
    public String getcodingreso() {
        return codingreso;
    }

    public void setcodingreso(String codingreso) {
        this.codingreso = codingreso;
    }
    
    public String getcodegreso() {
        return codegreso;
    }

    public void setcodegreso(String codegreso) {
        this.codegreso = codegreso;
    }
    
    public String getdetalle(){
        return detalle;
    }
    
    public void setdetalle(String detalle){
        this.detalle = detalle;
    }
    
    public String getmonto(){
        return monto;
    }
    
    public void setmonto(String monto){
        this.monto = monto;
    }
    
    public Date getfecha(){
    return fecha;
    }
    
    public void setfecha(Date fecha){
    this.fecha = fecha;
    }
}
