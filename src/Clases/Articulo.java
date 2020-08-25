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
public class Articulo {
    
    private int idArticulo;
    private String detalle_articulo;
    private int codArticulo;
    private int idRubro;
    private int idMarca;
    private int idTipo;
    private double precioVta;
    private double precioCosto;
    private double precioTarjeta;
    
    private String largoBacha;
    private String altoBacha;
    private String anchoBacha;
    
    private String impuesto;
    private int StockMin;
    private int Stock;
    
   
    private int idProveedor;
   
    private double dimensionLargo;
    
    private double dimensionAlto;

    private String FechaAlta;
    
    public Articulo() {
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getDetalle_articulo() {
        return detalle_articulo;
    }

    public void setDetalle_articulo(String detalle_articulo) {
        this.detalle_articulo = detalle_articulo;
    }

    public int getCodArticulo() {
        return codArticulo;
    }

    public void setCodArticulo(int codArticulo) {
        this.codArticulo = codArticulo;
    }

    public int getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(int idRubro) {
        this.idRubro = idRubro;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public double getDimensionLargo() {
        return dimensionLargo;
    }

    public void setDimensionLargo(double dimensionLargo) {
        this.dimensionLargo = dimensionLargo;
    }

    public double getDimensionAlto() {
        return dimensionAlto;
    }

    public void setDimensionAlto(double dimensionAlto) {
        this.dimensionAlto = dimensionAlto;
    }

    public double getPrecioVta() {
        return precioVta;
    }

    public void setPrecioVta(double precioVta) {
        this.precioVta = precioVta;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public String getLargoBacha() {
        return largoBacha;
    }

    public void setLargoBacha(String largoBacha) {
        this.largoBacha = largoBacha;
    }

    public String getAltoBacha() {
        return altoBacha;
    }

    public void setAltoBacha(String altoBacha) {
        this.altoBacha = altoBacha;
    }

    public String getAnchoBacha() {
        return anchoBacha;
    }

    public void setAnchoBacha(String anchoBacha) {
        this.anchoBacha = anchoBacha;
    }

    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public double getPrecioTarjeta() {
        return precioTarjeta;
    }

    public void setPrecioTarjeta(double precioTarjeta) {
        this.precioTarjeta = precioTarjeta;
    }

    public int getStockMin() {
        return StockMin;
    }

    public void setStockMin(int StockMin) {
        this.StockMin = StockMin;
    }

    public String getFechaAlta() {
        return FechaAlta;
    }

    public void setFechaAlta(String FechaAlta) {
        this.FechaAlta = FechaAlta;
    }

            
}
