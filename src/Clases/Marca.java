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
public class Marca {
    
    private int idMarca;
    private String DetalleMarca;
    private int idRubro;

    public Marca() {
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getDetalleMarca() {
        return DetalleMarca;
    }

    public void setDetalleMarca(String DetalleMarca) {
        this.DetalleMarca = DetalleMarca;
    }

    public int getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(int idRubro) {
        this.idRubro = idRubro;
    }
    
}
