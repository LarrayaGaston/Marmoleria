/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;
import javax.swing.JTextField;

/**
 *
 * @author Gaston
 */
public class Persona {
    private int idPersona;
    private String nombre;
    private String apellido;
    private int dni;
   private String fechaNacimiento;
//    private String fechaNacimiento;
    
    public Persona() {
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

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

//    public Date getFechaNacimiento() {
//        return fechaNacimiento;
//    }
//
//    public void setFechaNacimiento(Date fechaNacimiento) {
//        this.fechaNacimiento = fechaNacimiento;
//    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

   
    
    
    
    
}
