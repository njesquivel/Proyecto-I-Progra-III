/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.data;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import sistema.logic.Cliente;
import sistema.logic.Provincia;
/**
 *
 * @author Maria Cruz
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {
     private List<Cliente> clientes;    
     private List<Provincia> provincias;
     
    public Data() {
        clientes = new ArrayList<>();    
        provincias= new  ArrayList<>();    
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    
}
