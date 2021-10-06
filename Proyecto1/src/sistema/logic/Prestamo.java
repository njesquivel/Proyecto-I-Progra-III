/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.logic;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;

@XmlAccessorType(XmlAccessType.FIELD)
public class Prestamo {
    @XmlID  
    String numero;
    String descripción;
    @XmlIDREF
    Cliente cliente;
    double monto;
    double interes;
    int plazo;

    public Prestamo( String numero,String descripcion,double monto, double interes, int plazo) {
        this.monto = monto;
        this.interes = interes;
        this.plazo = plazo;
        this.numero=numero;
        this.descripción=descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Prestamo(String numero, String descripción, Cliente cliente, double monto, double interes, int plazo) {
        this.numero = numero;
        this.descripción = descripción;
        this.cliente = cliente;
        this.monto = monto;
        this.interes = interes;
        this.plazo = plazo;
    }

   public Prestamo(){
       
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }
    
    public double cuota(){
       // double mon =((monto * interes/100)/(1-(Math.pow((1+interes/100),(-plazo)))));
        DecimalFormat df =new DecimalFormat("0.00");
  
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
            aux = new Mensualidad(String.valueOf(i+1), saldo, intereses, amortizacion);
            listMensualidades.add(aux);
        }
        return listMensualidades.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Prestamo other = (Prestamo) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "monto= " + monto + ", interes= " + interes + "%, plazo= " + plazo + ", cuota= " + cuota() + "}\n" + mensualidades();
    }
}
