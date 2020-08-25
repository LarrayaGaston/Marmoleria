/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Gaston
 */
public class DetalleFactura {
    
    private int idDetalleFactura;
    private int idVFactura;
    private double Precio;
    private double altoP;
    private double largoP;
    private double M2;
    private double PrecioM2; 
    private int cantidad;
    private int idProducto;
    private String codArticulo;
    private double TotalPagar;

    public DetalleFactura() {
    }

    public int getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(int idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public int getIdVFactura() {
        return idVFactura;
    }

    public void setIdVFactura(int idVFactura) {
        this.idVFactura = idVFactura;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public double getPrecioM2() {
        return PrecioM2;
    }

    public void setPrecioM2(double PrecioM2) {
        this.PrecioM2 = PrecioM2;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public double getAltoP() {
        return altoP;
    }

    public void setAltoP(double altoP) {
        this.altoP = altoP;
    }

    public double getLargoP() {
        return largoP;
    }

    public void setLargoP(double largoP) {
        this.largoP = largoP;
    }

    public double getM2() {
        return M2;
    }

    public void setM2(double M2) {
        this.M2 = M2;
    }

    public String getCodArticulo() {
        return codArticulo;
    }

    public void setCodArticulo(String codArticulo) {
        this.codArticulo = codArticulo;
    }

    public double getTotalPagar() {
        return TotalPagar;
    }

    public void setTotalPagar(double TotalPagar) {
        this.TotalPagar = TotalPagar;
    }
    
    
}
