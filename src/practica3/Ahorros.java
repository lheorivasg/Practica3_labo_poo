/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Equipo 5: Max Alvarez Alvarez, Hugo Rubio Romero y Leonardo Rivas Gutierrez
 */
public class Ahorros extends Cuenta {
    private LocalDate fechaInicioAhorro;
    private double tasaMensual;

    
    /**
     * Constructor de cuenta de Ahorros
     * @param titular
     * @param numCuenta
     * @param saldo
     * @param tasaMensual
     * @param fechaInicioAhorro 
     */
    public Ahorros(String titular, String numCuenta, int saldo, double tasaMensual, LocalDate fechaInicioAhorro) {
        super(titular, numCuenta, saldo);
        this.tasaMensual = tasaMensual;
        this.fechaInicioAhorro = fechaInicioAhorro;
    }
    
    

    public LocalDate getFechaInicioAhorro() {
        return fechaInicioAhorro;
    }

    public void setFechaInicioAhorro(LocalDate fechaInicioAhorro) {
        this.fechaInicioAhorro = fechaInicioAhorro;
    }

    public double getTasaMensual() {
        return tasaMensual;
    }

    public void setTasaMensual(double tasaMensual) {
        this.tasaMensual = tasaMensual;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String Titular) {
        this.titular = Titular;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    
    
    /**
     * Metodo para Calcular las ganancias de ahorro con respecto a una tasa mensual, 
     * a partir del tiempo desde el cual tienes la cuenta
     * @return ganancia de ahorro
     */
    public double calcularGananciaTotal(){
        int meses = (int) ChronoUnit.MONTHS.between(fechaInicioAhorro, LocalDate.now());
        return tasaMensual * meses * saldo;
    }
    
    
    /**
     * Metodo para retirar pero siempre y cuando no sea mas del 30%
     * @param monto 
     */
    public void retirar(double monto){
        if(monto <= saldo * 0.3 && monto <= saldo){
            saldo -= monto;
            System.out.println("Se ha retirado "+ monto);
        } else {
            System.out.println("No se puede retirar mas del 30%");
        }
    }
    
    
    /**
     * Metodo para depositar
     * @param monto
     * @return saldo ya con el monto agregado
     */
    public double depositar(double monto){
        saldo += monto;
        return saldo;
    }    
    
    
    /**
     * Metodo para imprimir los datos de la cuenta
     * @return Cadena de datos
     */
    @Override
    public String obtenerDatos() {
        int meses = (int) java.time.temporal.ChronoUnit.MONTHS.between(fechaInicioAhorro, LocalDate.now());
        
        return "Cuenta{" + "Titular=" + titular + ", numCuenta=" + numCuenta + ", saldo=" + saldo + 
                ", Ganancia total del ahorro="+ calcularGananciaTotal() +", tasaInteres="+ tasaMensual +
                ", fechaAhorro="+ fechaInicioAhorro +'}';
        
    }
    
    
    
}
