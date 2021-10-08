/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.logic;

import java.util.Objects;

/**
 *
 * @author njesq
 */
public class Pago {
    String ID;
    double monto;
    double interes;
    double amortizacion;
    double saldo;

    public Pago(String ID, double interes, double amortizacion, double saldo) {
        this.ID = ID;
        this.interes = interes;
        this.amortizacion = amortizacion;
        this.saldo = saldo;
    }

    public Pago() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public double getAmortizacion() {
        return amortizacion;
    }

    public void setAmortizacion(double amortizacion) {
        this.amortizacion = amortizacion;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.ID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pago other = (Pago) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        return true;
    }

  



    
}