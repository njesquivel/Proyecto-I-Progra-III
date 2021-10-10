/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.logic;

import java.util.ArrayList;

public class Pago {
    
    String numero;
    double monto;
    double saldo;
    double intereses;
    double amortizacion;
    int plazo;


    
    public Pago(String numero, double monto, double interes, double amortizacion) {
        this.numero = numero;
        this.saldo = monto;
        this.monto = monto;
        this.intereses = intereses;
        this.amortizacion = amortizacion;
    }

    public Pago(String numero, double monto, double interes) {
        this.numero = numero;
        this.monto = monto;
        this.saldo = monto;
        calculo(interes);
    }
    
    public Pago() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    

    

    public double getSaldo() {
        return saldo;
    }

    public double getIntereses() {
        return intereses;
    }

    public double getAmortizacion() {
        return amortizacion;
    }

    

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setInteres(double intereses) {
        this.intereses = intereses;
    }

    public void setAmortizacion(double amortizacion) {
        this.amortizacion = amortizacion;
    }

    void calculo(double interes){
       
            
            intereses = monto * interes/100;
            amortizacion = monto - intereses;
            saldo = monto - amortizacion;
            
        }
    }


