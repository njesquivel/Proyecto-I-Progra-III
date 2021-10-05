/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.pagos;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import sistema.logic.Mensualidad;

public class Model extends Observable {
    Mensualidad mensualidad;
    List<Mensualidad> mensualidades;

    public Mensualidad getMensualidad() {
        return mensualidad;
    }

    public void setMensualidad(Mensualidad mensualidad) {
        this.mensualidad = mensualidad;
    }

    public List<Mensualidad> getMensualidades() {
        return mensualidades;
    }

    public void setMensualidades(List<Mensualidad> mensualidades) {
        this.mensualidades = mensualidades;
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
