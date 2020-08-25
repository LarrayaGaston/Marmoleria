/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestionar_Empleado;


import Clases.Empleado;
import Metodos.Conectar;
import javax.swing.JOptionPane;

/**
 *
 * @author luca
 */
public class gestionarEmpleado {
    
    
        
       public void GuardarEmpleado(Empleado miEmpleado) {
        try {
            Conectar miconexion= new Conectar();
            String sentenciaInsert= "Insert into empleados (idEmpleado, "
                    + "  emp_celular, emp_telefono, emp_email,"
                    + "emp_provincia, emp_ciudad, emp_direccion, emp_codpostal, idPersona, emp_CBU,emp_fecha_ingreso ) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?)"; 
            
            miconexion.psPrepararSentencias= miconexion.miconexion.prepareStatement(sentenciaInsert);
            
           miconexion.psPrepararSentencias.setInt(1, miEmpleado.getIdEmpleado());
         
            
           
            miconexion.psPrepararSentencias.setString(2,  miEmpleado.getEmp_celular());
            miconexion.psPrepararSentencias.setString(3,  miEmpleado.getEmp_telefono());
         
            miconexion.psPrepararSentencias.setString(4,  miEmpleado.getEmp_email());
            
            miconexion.psPrepararSentencias.setInt(5,  miEmpleado.getEmp_Provincia());
            miconexion.psPrepararSentencias.setInt(6,  miEmpleado.getEmp_Ciudad());
            miconexion.psPrepararSentencias.setString(7,  miEmpleado.getEmp_direccion());
            miconexion.psPrepararSentencias.setInt(8,  miEmpleado.getEmp_codPostal());
            
         
            
            miconexion.psPrepararSentencias.setInt(9,  miEmpleado.getIdPersona());
            
            miconexion.psPrepararSentencias.setString(10,  miEmpleado.getEmp_CBU());
            miconexion.psPrepararSentencias.setString(11, miEmpleado.getEmp_fecha_ingreso());
            miconexion.psPrepararSentencias.executeUpdate();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.toString()); //joptionpane para que aparezca un cartel con el error.
        }        
    }
    
       public void modEmpleado(Empleado modEmpleado) {
        try {
            Conectar miconexion = new Conectar();
            String sentenciaModificar = "UPDATE Empleados SET idpersona='" + modEmpleado.getIdPersona()
                    + "'," + "emp_direccion='" + modEmpleado.getEmp_direccion()
                    + "'," + "emp_email='" + modEmpleado.getEmp_email()
                    + "',emp_fecha_ingreso="  +modEmpleado.getEmp_fecha_ingreso()
                    + ",emp_telefono=" + modEmpleado.getEmp_telefono()
                    + ",emp_celular=" + modEmpleado.getEmp_celular()
                    + ",emp_provincia=" + modEmpleado.getEmp_Provincia()
                    + ",emp_ciudad=" + modEmpleado.getEmp_Ciudad()
                    + ",emp_codpostal=" + modEmpleado.getEmp_codPostal()
                    +",emp_CBU="+ modEmpleado.getEmp_CBU()
                    + " WHERE idempleado=" + modEmpleado.getIdEmpleado() + "";
            miconexion.psPrepararSentencias = miconexion.miconexion.prepareStatement(sentenciaModificar);
            miconexion.psPrepararSentencias.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
            System.out.print(e.getMessage());
        }

    }


}
