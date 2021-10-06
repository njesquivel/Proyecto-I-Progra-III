/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.pagos;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import sistema.logic.Cliente;
import sistema.logic.Mensualidad;
import sistema.logic.Prestamo;

/**
 *
 * @author ESCINF
 */
public class Model extends Observable {
   Mensualidad pago;
   List<Mensualidad> pagos;
   
    //Prestamo para pagos
   Prestamo prestamo;

    public Mensualidad getPago() {
        return pago;
    }

    public void setPago(Mensualidad pago) {
        this.pago = pago;
    }

    public List<Mensualidad> getPagos() {
        return pagos;
    }

    public void setPagos(List<Mensualidad> pagos) {
        this.pagos = pagos;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    //Prestamo para pagos
    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }
 
      @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o); 
        this.commit();
    }
    
    public void commit(){
        this.setChanged();
        this.notifyObservers();
    }
    
    
}
