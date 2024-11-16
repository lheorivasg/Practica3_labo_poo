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
public class Practica3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Ejemplo de objeto para cuenta de Ahorros
        System.out.println("Prueba 1 Cuenta ahorros");
        Ahorros cuentaAhorros = new Ahorros(
                "Laura Rodriguez",
                "6985",
                5000,
                3.0,
                LocalDate.of(2023,01,30)
        );
        cuentaAhorros.depositar(1000);
        cuentaAhorros.retirar(3000);
        System.out.println(cuentaAhorros.obtenerDatos());
        
        
        // Ejemplo de objeto para cuenta Internacional      
        System.out.println("\nPrueba 2 Cuenta internacional");
        Internacional cuentaInternacional = new Internacional(
                "Pedro Garcia",
                "36985",
                10000,
                "europea"
        );
        cuentaInternacional.depositar(100);
        cuentaInternacional.retirar(2000);
        cuentaInternacional.depositar(100);
        cuentaInternacional.depositar(100);
        cuentaInternacional.depositar(100);
        cuentaInternacional.depositar(15000);  // No deberia permitirse esta transaccion

        double saldoConvertido = cuentaInternacional.convertirDivisa();
        System.out.println("Saldo convertido a " + cuentaInternacional.getTipoDivisas() + ": " + saldoConvertido);    
        
        cuentaInternacional.obtenerDatos();
        System.out.println(cuentaInternacional.obtenerDatos());
        
        
        
        // Ejemplo de objeto para cuenta Corriente        
        System.out.println("\nPrueba 3 Cuenta corriente");
        Corriente cuentaCorriente = new Corriente(
                "Arturo",
                "56987",
                2400
        );
        cuentaCorriente.depositar(100);
        cuentaCorriente.retirar(3000);
        cuentaCorriente.actualizarSaldoMensual();
        System.out.println(cuentaCorriente.obtenerDatos());
        
        
        
    }
    
}
