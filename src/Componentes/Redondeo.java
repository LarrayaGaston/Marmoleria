/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

/**
 *
 * @author Gaston
 */
public class Redondeo {
    
    public static double redondear(double numero)
    {
        return Math.rint(numero*100)/100;
    }
}
