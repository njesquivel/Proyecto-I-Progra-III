/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.logic;

public class Mensualidad {
      int numero;
    double saldo;
    double interes;
    double amortizacion;


    
    public Mensualidad(int numero, double saldo, double interes, double amortizacion) {
        this.numero = numero;
        this.saldo = saldo;
        this.interes = interes;
        this.amortizacion = amortizacion;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getInteres() {
        return interes;
    }

    public double getAmortizacion() {
        return amortizacion;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public void setAmortizacion(double amortizacion) {
        this.amortizacion = amortizacion;
    }

    @Override
    public String toString() {
        return "Mensualidad{" + "numero=" + numero + ", saldo=" + saldo + ", interes=" + interes + ", amortizacion=" + amortizacion + "}\n";
    }
}
