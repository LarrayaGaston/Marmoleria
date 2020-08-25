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
public class Empleado extends Persona {
    
    private int idEmpleado;
   
    private String emp_telefono;
    private String emp_celular;
    private int emp_codPostal;
    private String emp_direccion;
    private String emp_email;
    private int emp_Provincia;
    private int emp_Ciudad;
    private String emp_CBU;
    private String emp_fecha_ingreso; 
//    private Date emp_fecha_ingreso; 

    public Empleado() {
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    
    

    public String getEmp_telefono() {
        return emp_telefono;
    }

    public void setEmp_telefono(String emp_telefono) {
        this.emp_telefono = emp_telefono;
    }

    public String getEmp_celular() {
        return emp_celular;
    }

    public void setEmp_celular(String emp_celular) {
        this.emp_celular = emp_celular;
    }

    public int getEmp_codPostal() {
        return emp_codPostal;
    }

    public void setEmp_codPostal(int emp_codPostal) {
        this.emp_codPostal = emp_codPostal;
    }

    public String getEmp_direccion() {
        return emp_direccion;
    }

    public void setEmp_direccion(String emp_direccion) {
        this.emp_direccion = emp_direccion;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }

    public int getEmp_Provincia() {
        return emp_Provincia;
    }

    public void setEmp_Provincia(int emp_Provincia) {
        this.emp_Provincia = emp_Provincia;
    }

    public int getEmp_Ciudad() {
        return emp_Ciudad;
    }

    public void setEmp_Ciudad(int emp_Ciudad) {
        this.emp_Ciudad = emp_Ciudad;
    }

    public String getEmp_CBU() {
        return emp_CBU;
    }

    public void setEmp_CBU(String emp_CBU) {
        this.emp_CBU = emp_CBU;
    }

    public String getEmp_fecha_ingreso() {
        return emp_fecha_ingreso;
    }

    public void setEmp_fecha_ingreso(String emp_fecha_ingreso) {
        this.emp_fecha_ingreso = emp_fecha_ingreso;
    }

    

    
    
   
    
}
