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
public class Compra {
    private int idcompra;
    private int numfacproveedor;
            private int idproveedor;
            private int condpago;
            private double totalcompra;
            private Date fecha;
            

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public int getCondpago() {
        return condpago;
    }

    public void setCondpago(int condpago) {
        this.condpago = condpago;
    }



    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotalcompra() {
        return totalcompra;
    }

    public void setTotalcompra(double totalcompra) {
        this.totalcompra = totalcompra;
    }

    public int getNumfacproveedor() {
        return numfacproveedor;
    }

    public void setNumfacproveedor(int numfacproveedor) {
        this.numfacproveedor = numfacproveedor;
    }


            
            
            
}

