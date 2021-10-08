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
import sistema.logic.Cliente;
import sistema.logic.Pago;
/**
 *
 * @author ESCINF
 */
public class Model extends Observable {
   Pago pago;
   List<Pago> pagos;
   
    //Prestamo para pagos
   Prestamo prestamo;

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
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
