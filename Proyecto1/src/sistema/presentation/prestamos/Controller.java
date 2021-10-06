/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.prestamos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import sistema.Application;
import static sistema.Application.CLIENTES;
import static sistema.Application.PAGOS;
import sistema.logic.Cliente;
import sistema.logic.Prestamo;
import sistema.logic.Service;


public class Controller {
      Model model;
      View view;
      
      public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        // invoke Model sets for initialization before linking to the view
        // problably get the data from Service
        model.setPrestamo(new Prestamo());
        model.setPrestamos(new ArrayList<>());
        
        view.setModel(model);
        view.setController(this);
    }
        public void show(){
        this.view.setVisible(true);
    }
      
       public void hide(){
        this.view.setVisible(false);
        Application.CLIENTES.show();
    }    
      //Para pasar el cliente a prestamos 
       public void show(Cliente cliente){
        this.view.setVisible(true);
        model.setCliente(cliente);
        view.getClienteInfo().setText("Cliente: "+model.getCliente().getNombre()+ ", Cedula: "+model.getCliente().getCedula());
       
    }
       //-----------------------------------------------------------------------------
       public void prestamoGet(String numero){
        try {
            Prestamo prestamo = Service.instance().prestamoGet(numero);
            model.setPrestamo(prestamo);
            model.setPrestamos(Arrays.asList(prestamo));
            model.commit();
        } catch (Exception ex) {
            model.setPrestamo(new Prestamo());
            model.setPrestamos(new ArrayList<>());
            model.commit();
        }
    }
    
    public void  prestamoSearch(String numero){
        List<Prestamo> prestamos= Service.instance().prestamoSearch(numero);
        model.setPrestamo(new Prestamo(numero,"",0,0,0));
        model.setPrestamos(prestamos);
        model.commit();
    }
    
    public void prestamoEdit(int row){
        Prestamo prestamo = model.getPrestamos().get(row);
         Service.instance().store();
        model.setPrestamo(prestamo);
        model.commit();
    }
    
    public void prestamoAdd(Prestamo prestamo){
        try {
            Service.instance().prestamoAdd(prestamo);
             Service.instance().store();
            model.setPrestamo(new Prestamo("","",0,0,0));
            model.setPrestamos(Arrays.asList(prestamo));
            model.commit();
        } catch (Exception ex) {
            
        }
        
    }
    
    //recordar por parametro model.
    public void pagosShow(){
        this.hide();
        Application.PAGOS.show( model.getPrestamo());
    }
   
  
}
