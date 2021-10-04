/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.logic;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlIDREF;


public class Prestamo {
    double monto;
    double interes;
    int plazo;
    @XmlIDREF
    Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    

    public Prestamo(double monto, double interes, int plazo) {
        this.monto = monto;
        this.interes = interes;
        this.plazo = plazo;
    }

    public double getMonto() {
        return monto;
    }

    public double getInteres() {
        return interes;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }
    
    
    
    double cuota(){
     return ((monto * interes/100)/(1-(Math.pow((1+interes/100),(-plazo)))));
    }
    
    String mensualidades(){
        ArrayList<Mensualidad> listMensualidades = new ArrayList<Mensualidad>();
        Mensualidad aux;
        double saldo = monto;
        double intereses;
        double amortizacion=0;
        for(int i =0; i<plazo; i++){
            saldo = saldo - amortizacion;
            intereses = saldo * interes/100;
            amortizacion = cuota() - intereses;
            aux = new Mensualidad(i+1, saldo, intereses, amortizacion);
            listMensualidades.add(aux);
        }
        return listMensualidades.toString();
    }

    @Override
    public String toString() {
        return "Prestamo{" + "monto= " + monto + ", interes= " + interes + "%, plazo= " + plazo + ", cuota= " + cuota() + "}\n" + mensualidades();
    }
}
