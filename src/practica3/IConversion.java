/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

/**
 *
 * @author Equipo 5: Max Alvarez Alvarez, Hugo Rubio Romero y Leonardo Rivas Gutierrez
 */
public interface IConversion {
    /***
     * Establecer conversiones
     */
    double DOLAR = 16.78;
    double EURO = 18.18;
    double LIBRA = 21.18;
    
    double convertirDivisa(double cantidad, String tipoDivisa);
    
}
