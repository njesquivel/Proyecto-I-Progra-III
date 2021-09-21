/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.logic;

import java.util.List;

/**
 *
 * @author Maria Cruz 
 * 
 * 
 * 
 * 
 * pruebas oreuebvas 
 */


public class Canton {
    String numero;
    String nombre;
    List<Distrito> distritos;

    public Canton(String numero, String nombre, List<Distrito> distritos) {
        this.numero = numero;
        this.nombre = nombre;
        this.distritos = distritos;
    }

    public Canton() {
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Distrito> getDistritos() {
        return distritos;
    }

    public void setDistritos(List<Distrito> distritos) {
        this.distritos = distritos;
    }
    
}
