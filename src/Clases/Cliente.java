/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author luca
 */
public class Cliente extends Persona{
    private int idCliente;
   
    private String cli_razonSocial;

    private String cli_telefono;
    private String cli_celular;
    private String cli_fax;
    private int cli_codPostal;
    private String cli_cuit;
    private int cli_condiva;
    private String cli_direccion;
    private String cli_email;
    private int cli_Provincia;
    private int cli_Ciudad;
//    private int cli_CBU;
//    private BigInteger cbu; 
   private String cli_CBU;

    public Cliente() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCli_razonSocial() {
        return cli_razonSocial;
    }

    public void setCli_razonSocial(String cli_razonSocial) {
        this.cli_razonSocial = cli_razonSocial;
    }

    public String getCli_telefono() {
        return cli_telefono;
    }

    public void setCli_telefono(String cli_telefono) {
        this.cli_telefono = cli_telefono;
    }

    public String getCli_celular() {
        return cli_celular;
    }

    public void setCli_celular(String cli_celular) {
        this.cli_celular = cli_celular;
    }

    public String getCli_fax() {
        return cli_fax;
    }

    public void setCli_fax(String cli_fax) {
        this.cli_fax = cli_fax;
    }

    public int getCli_codPostal() {
        return cli_codPostal;
    }

    public void setCli_codPostal(int cli_codPostal) {
        this.cli_codPostal = cli_codPostal;
    }

    public String getCli_cuit() {
        return cli_cuit;
    }

    public void setCli_cuit(String cli_cuit) {
        this.cli_cuit = cli_cuit;
    }

    public int getCli_condiva() {
        return cli_condiva;
    }

    public void setCli_condiva(int cli_condicion) {
        this.cli_condiva = cli_condicion;
    }

    public String getCli_direccion() {
        return cli_direccion;
    }

    public void setCli_direccion(String cli_direccion) {
        this.cli_direccion = cli_direccion;
    }

    public String getCli_email() {
        return cli_email;
    }

    public void setCli_email(String cli_email) {
        this.cli_email = cli_email;
    }

 
    public int getCli_Provincia() {
        return cli_Provincia;
    }

    public void setCli_Provincia(int cli_Provincia) {
        this.cli_Provincia = cli_Provincia;
    }

    public int getCli_Ciudad() {
        return cli_Ciudad;
    }

    public void setCli_Ciudad(int cli_Ciudad) {
        this.cli_Ciudad = cli_Ciudad;
    }

    public String getCli_CBU() {
        return cli_CBU;
    }

    public void setCli_CBU(String cli_CBU) {
        this.cli_CBU = cli_CBU;
    }

 

  
    
    
    
}
