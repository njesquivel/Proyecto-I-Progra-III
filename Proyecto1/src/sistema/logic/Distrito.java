/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.logic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;

@XmlAccessorType(XmlAccessType.FIELD)
public class Distrito {
   @XmlID  
   String numero;
   String nombre;

    public Distrito(String numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    public Distrito() {
        this.numero = " ";
        this.nombre = " ";
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
      @Override
    public String toString() {
        return nombre;
    }
}
