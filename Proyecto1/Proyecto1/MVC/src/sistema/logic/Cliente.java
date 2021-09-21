/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.logic;

import java.util.Objects;

/**
 *
 * @author ESCINF
 */
public class Cliente {
    
    String Cedula;
    String nombre;
    String Telefono;
    Provincia provincia;
    Canton canton;
    Distrito distrito;

    public Cliente(String Cedula, String nombre, String Telefono) {
        this.Cedula = Cedula;
        this.nombre = nombre;
        this.Telefono = Telefono;
    }

    public Cliente() {
        this.Cedula = "";
        this.nombre = "";
        this.Telefono = "";
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.Cedula);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.Cedula, other.Cedula)) {
            return false;
        }
        return true;
    }
    
    
    
}
