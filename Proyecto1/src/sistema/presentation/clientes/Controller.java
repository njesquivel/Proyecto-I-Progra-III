/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.clientes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import sistema.Application;
import sistema.logic.Canton;
import sistema.logic.Cliente;
import sistema.logic.Distrito;
import sistema.logic.Provincia;
import sistema.logic.Service;

public class Controller {
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        // invoke Model sets for initialization before linking to the view
        // problably get the data from Service
        model.setCliente(new Cliente());
        model.setClientes(new ArrayList<>());
        model.setCantones(Service.instance().cantonAll());
        model.setDistritos(Service.instance().distritoAll());
        view.setModel(model);
        view.setController(this);
    }
    
    public void show(){
        this.view.setVisible(true);
    }
       
    
    // Controller methods that respond to View events
    // probably invoke methods from Service,
    // and set data to Model, which in turn causes the View to update 
 //--------------------------------------------------------------------------------------------   
    public void clienteGet(String cedula){
        try {
            Cliente cliente = Service.instance().clienteGet(cedula);
            model.setCliente(cliente);
            model.setClientes(Arrays.asList(cliente));
            model.commit();
        } catch (Exception ex) {
            model.setCliente(new Cliente());
            model.setClientes(new ArrayList<>());
            model.commit();
        }
    }
    
    public void  clienteSearch(String cedula){
        List<Cliente> clientes= Service.instance().clienteSearch(cedula);
        Provincia p= new Provincia();
        Distrito d= new Distrito();
        Canton c= new Canton();
        model.setCliente(new Cliente(cedula,"","",p,c,d));        
        model.setClientes(clientes);
        model.commit();
    }
    
    public void clienteEdit(int row){
        Cliente cliente = model.getClientes().get(row);
        Service.instance().store();
        model.setCliente(cliente);
        model.commit();
    }
    
    public void clienteAdd(Cliente cliente){
        try {
            Service.instance().clienteAdd(cliente);
            Service.instance().store();
            model.setCliente(new Cliente("","",""));
            model.setClientes(Arrays.asList(cliente));
            model.commit();
        } catch (Exception ex) {
            
        }
        
    }
    //Combo Box-------------------------------------------------------------------------
    public Provincia getProvincia(String nombre){
        return Service.instance().buscarProvincia(nombre);
    }
     public Canton getCanton(String nombre){
        return Service.instance().buscarCanton(nombre);
    } 
      public Distrito getDistrito(String nombre){
        return Service.instance().buscarDistrito(nombre);
    } 
    
    
 //-Combo Box-----------------------------------------------------------------------
     public String[] Cantones(String nombre) throws Exception{
        
        ArrayList<Canton> aux = Service.instance().provincias(nombre);
        String [] cantones = new String[aux.size()]; 
        int index = 0;
        for (Canton a : aux) {
        
            cantones[index] = a.getNombre();
            index++;
        }
        
        return cantones; 
    }
    public String[] Distritos(String canton, String nombre) throws Exception{
        
        ArrayList<Canton> aux = Service.instance().provincias(canton);
       
        int index = 0;
        Canton X=new Canton();
        for (Canton a : aux) {
            if(a.getNombre().equals(nombre)){
                X = a;
            }
        }
        ArrayList<Distrito> dis = (ArrayList<Distrito>) X.getDistritos();
         String [] dist = new String[dis.size()]; 
        for(Distrito d : dis){
             dist[index] = d.getNombre();
            index++;
        }
        
        return dist; 
    }
    public void prestamosShow(){
        this.hide();
        Application.PRESTAMO.show();
    }
    public void hide(){
        this.view.setVisible(false);
    }
}

