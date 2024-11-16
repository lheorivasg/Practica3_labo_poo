/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

import java.time.LocalDate;

/**
 *
 * @author Equipo 5: Max Alvarez Alvarez, Hugo Rubio Romero y Leonardo Rivas Gutierrez
 */
public class Corriente extends Cuenta{    
    
    /**
     * Constructor de cuenta Corriente
     * @param titular
     * @param numCuenta
     * @param saldo 
     */
    public Corriente(String titular, String numCuenta, int saldo) {
        super(titular, numCuenta, saldo);
    }
    

    /**
     * Metodo de cobro de comision del banco
     * @return comision
     */
    public double comisionMantenimiento(){
        double comision;
        if(saldo < 1000){
            comision = 400*1.16;
        } else if(saldo < 2500) {
            comision = 300*1.16;            
        } else if(saldo < 3500) {
            comision = 200*1.16;
        } else if(saldo < 4000) {
            comision = 180*1.16;        
        } else {
            comision = 0;
        }
        
        return comision;        
    }
    
    
    
    
    /**
     * Metodo para cobrar comision el dia 29 de cada mes
     */
    public void actualizarSaldoMensual(){
        LocalDate hoy = LocalDate.now();
        if (hoy.getDayOfMonth()== 29){
            double comision = comisionMantenimiento();
            saldo -= comision;
            System.out.println("Comision aplicada: " + comision);
            System.out.println("Nuevo saldo: "+ saldo);
        } else {
            System.out.println("No se puede aplicar el proceso en un dia diferente al 29");
        }
    }
    
    
    
    /**
     * Metodo para retirar, pero si no tienes dinero te cobran una penalizacion, pero para valores int
     * @param monto 
     */
    @Override
    public void retirar(int monto){
        if(monto <= saldo){
            saldo -= monto;
            System.out.println("Se ha retirado "+ monto);
        } else {
            saldo -= 20;            
            System.out.println("Tienes una penalizacion por lo que ahora tu saldo es de: "+ saldo );
        }
    }
    
    
    /**
     * Metodo para retirar, pero si no tienes dinero te cobran una penalizacion, pero para valores double
     * @param monto 
     */
    public void retirar(double monto){
        if(monto <= saldo){
            saldo -= monto;
            System.out.println("Se ha retirado "+ monto);
        } else {
            saldo -= 20;
            System.out.println("Tienes una penalizacion por lo que ahora tu saldo es de: "+ saldo );
        }
    }
    
    
    /**
     * Metodo para imprimir los datos de la cuenta
     * @return Cadena de datos
     */
    @Override
    public String obtenerDatos() {
        double comision = comisionMantenimiento();
        return "Cuenta{" + "Titular=" + titular + ", numCuenta=" + numCuenta + ", saldo=" + saldo + ", comision="+ comision +  '}';
    }    
    
    
}
