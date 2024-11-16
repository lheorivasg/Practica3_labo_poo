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
public class Internacional extends Cuenta implements IConversion{
    private int numTransacciones;
    private String tipoDivisa;

    
    /**
     * Constructor
     * @param titular
     * @param numCuenta
     * @param saldo
     * @param tipoDivisa 
     */
    public Internacional(String titular, String numCuenta, int saldo, String tipoDivisa) {
        super(titular, numCuenta, saldo);
        this.tipoDivisa = tipoDivisa;
        this.numTransacciones =0;
    }
    
    
    
    /**
     * Metodo para convertir saldo en una divisa
     * @param saldo
     * @param tipoDivisa
     * @return saldo en otra divisa
     */
    public double convertirDivisa(double saldo, String tipoDivisa) {
        switch(tipoDivisa.toLowerCase()){
            case "estadounidense":
                return saldo / DOLAR;
            case "europea":
                return saldo / EURO;
            case "inglesa":
                return saldo / LIBRA;
            default:
                throw new IllegalArgumentException("Tipo de divisa no valido: " + tipoDivisa);
        }
    }
    
    
    /**
     * Convertir divisa
     * @return saldo en otra divisa
     */
    public double convertirDivisa(){
        return convertirDivisa(saldo, tipoDivisa);
    }
    
    
    
  
    public boolean puedeRealizarTransaccion(){
        if(this.numTransacciones >= 5){
            System.out.println("No se puede hacer la transaccion");
            return false;
        }
        return true;
    }
    
    /**
     * Metodo para retirar dinero
     * @param monto 
     */
    
    public void retirar(double monto){
        if (!puedeRealizarTransaccion()) return;
        
        if(monto <= saldo){
            saldo -= monto;
            this.numTransacciones++; // Tambien se podria usar el metodo de setNumeroTransacicones(this.numTransacciones + 1)
            System.out.println("Se ha retirado "+ monto);
        } else {
            System.out.println("Saldo insuficiente");
        }
    }
    
    
    /**
     * Metodo para depositar
     * @param monto 
     */
    public void depositar(double monto){
        if (!puedeRealizarTransaccion()) return;

        
        if(monto > 0){
            saldo += monto;
            this.numTransacciones++; // Tambien se podria usar el metodo de setNumeroTransacicones(this.numTransacciones + 1)
            System.out.println("Se ha depositado "+ monto);
        } else {
            System.out.println("No se pueden depositar valores negativos");
        }
    }    

    

    
    
    
    public int getNumeroTransacicones() {
        return numTransacciones;
    }

    public void setNumeroTransacicones(int numeroTransacicones) {
        this.numTransacciones = numeroTransacicones;
    }

    public String getTipoDivisas() {
        return tipoDivisa;
    }

    public void setTipoDivisas(String tipoDivisas) {
        this.tipoDivisa = tipoDivisas;
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
     * Metodo para imprimir los datos de la cuenta
     * @return Cadena de datos
     */
    @Override
    public String obtenerDatos() {
        
        return "Cuenta{" + "Titular=" + titular + ", numCuenta=" + numCuenta + ", saldo=" + saldo + 
                ", tipoDivisa="+ this.tipoDivisa +", numTransaccion="+ this.numTransacciones +
                ", SaldoExtranjero="+ convertirDivisa() +'}';
        
    }       

    
}
