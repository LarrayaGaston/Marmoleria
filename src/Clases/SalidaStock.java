/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;

/**
 *
 * @author luca
 */
public class SalidaStock {
    private int idsalida;
    private int idmotivo;
    private Date fecha;

    public SalidaStock() {
    }

    public int getIdsalida() {
        return idsalida;
    }

    public void setIdsalida(int idsalida) {
        this.idsalida = idsalida;
    }

    public int getIdmotivo() {
        return idmotivo;
    }

    public void setIdmotivo(int idmotivo) {
        this.idmotivo = idmotivo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
