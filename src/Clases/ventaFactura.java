/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;

/**
 *
 * @author Gaston
 */
public class ventaFactura {
    
    private int idVFactura;
    private int idDetalleFactura;
    private String numeroFac;
    private int idCliente;
    private String nombre;
    private String apellido;
    private String cli_razonsocial;
    private int cli_cuit;
    private double TotalVenta;
    private double Descuento;
    private double SubTotal;
    private double IVA;
    private double TotalPagar;
    private Date FechaEmision;
    private Date FechaVencimiento;
    private String Estado;

    public ventaFactura() {
    }

    public int getIdVFactura() {
        return idVFactura;
    }

    public void setIdVFactura(int idVFactura) {
        this.idVFactura = idVFactura;
    }

    public int getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(int idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public String getNumeroFac() {
        return numeroFac;
    }

    public void setNumeroFac(String numeroFac) {
        this.numeroFac = numeroFac;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCli_razonsocial() {
        return cli_razonsocial;
    }

    public void setCli_razonsocial(String cli_razonsocial) {
        this.cli_razonsocial = cli_razonsocial;
    }

    public int getCli_cuit() {
        return cli_cuit;
    }

    public void setCli_cuit(int cli_cuit) {
        this.cli_cuit = cli_cuit;
    }

    public double getTotalVenta() {
        return TotalVenta;
    }

    public void setTotalVenta(double TotalVenta) {
        this.TotalVenta = TotalVenta;
    }

    public double getDescuento() {
        return Descuento;
    }

    public void setDescuento(double Descuento) {
        this.Descuento = Descuento;
    }

    public double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(double SubTotal) {
        this.SubTotal = SubTotal;
    }

    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    public Date getFechaEmision() {
        return FechaEmision;
    }

    public void setFechaEmision(Date FechaEmision) {
        this.FechaEmision = FechaEmision;
    }

    public Date getFechaVencimiento() {
        return FechaVencimiento;
    }

    public void setFechaVencimiento(Date FechaVencimiento) {
        this.FechaVencimiento = FechaVencimiento;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public double getTotalPagar() {
        return TotalPagar;
    }

    public void setTotalPagar(double TotalPagar) {
        this.TotalPagar = TotalPagar;
    }
    
    
}
