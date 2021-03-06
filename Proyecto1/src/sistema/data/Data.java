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
import sistema.logic.Canton;
import sistema.logic.Cliente;
import sistema.logic.Distrito;
import sistema.logic.Prestamo;
import sistema.logic.Provincia;
import sistema.logic.Pago;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {
    private List<Provincia> provincias;
    private List<Canton> cantones;
    private List<Distrito> distritos;
    private List<Cliente> clientes;   
    private List<Prestamo> prestamos;
    private List<Pago> pagos;
     
    
    public Data() {
        clientes = new ArrayList<>();
        provincias= new  ArrayList<>();
        cantones =new ArrayList<>();
        distritos =new ArrayList<>();
        prestamos= new ArrayList<>();
        pagos= new ArrayList<>();
        
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }

    

    public List<Canton> getCantones() {
        return cantones;
    }

    public void setCantones(List<Canton> cantones) {
        this.cantones = cantones;
    }

    public List<Distrito> getDistritos() {
        return distritos;
    }

    public void setDistritos(List<Distrito> distritos) {
        this.distritos = distritos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }
   
    
    

}

