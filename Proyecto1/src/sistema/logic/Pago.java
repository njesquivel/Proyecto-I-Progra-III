/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.logic;

/**
 *
 * @author njesq
 */
public class Pago {
    int ID;
    double monto;
    double interes;
    double amortizacion;
    double saldo;

    public Pago(int ID, double interes, double amortizacion, double saldo) {
        this.ID = ID;
        this.interes = interes;
        this.amortizacion = amortizacion;
        this.saldo = saldo;
    }

    public Pago() {
    }
    
}