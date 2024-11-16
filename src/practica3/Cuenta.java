/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3;

/**
 *
 * @author Kirigalla
 */
public abstract class Cuenta {
    protected String titular;
    protected String numCuenta;
    protected int saldo;

    public Cuenta(String titular, String numCuenta, int saldo) {
        this.titular = titular;
        this.numCuenta = numCuenta;
        this.saldo = saldo;
    }

    
    public int depositar(int monto){
        saldo += monto;
        return saldo;
    }
    
    
    public void retirar(int monto){
        saldo -= monto;
        System.out.println(saldo);;
    }


    public String obtenerDatos() {
        return "Cuenta{" + "Titular=" + titular + ", numCuenta=" + numCuenta + ", saldo=" + saldo + '}';
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
    
}
