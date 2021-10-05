/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.pagos;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import sistema.Application;
//import static sistema.Application.CLIENTES;
//import sistema.logic.Cliente;
import sistema.logic.Mensualidad;
import sistema.logic.Service;

public class Controller {
     Model model;
      View view;
      
      public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        // invoke Model sets for initialization before linking to the view
        // problably get the data from Service
        model.setMensualidad(new Mensualidad());
        model.setMensualidades(new ArrayList<>());
        
        view.setModel(model);
        view.setController(this);
    }
    
      
       public void hide(){
        this.view.setVisible(false);
        Application.CLIENTES.show();
    }    
      
       public void show(){
        this.view.setVisible(true);
    }
    
       //-------------
       
        public void MensualidaGet(String numero){
        try {
            Mensualidad mensualidad = Service.instance().mensualidadGet(numero);
            model.setMensualidad(mensualidad);
            model.setMensualidades(Arrays.asList(mensualidad));
            model.commit();
        } catch (Exception ex) {
            model.setMensualidad(new Mensualidad());
            model.setMensualidades(new ArrayList<>());
            model.commit();
        }
    }
    
    public void mensualidadSearch(String numero){
        List<Mensualidad> mensualidas= Service.instance().mensualidadSearch(numero);
        model.setMensualidad(new Mensualidad(numero,0,0,0));
        model.setMensualidades(mensualidas);
        model.commit();
    }
    
    public void mensualidadEdit(int row){
       Mensualidad mensualidad = model.getMensualidades().get(row);
         Service.instance().store();
        model.setMensualidad(mensualidad);
        model.commit();
    }
    
    public void prestamoAdd(Mensualidad mensualidad){
        try {
            Service.instance().mensualidadAdd(mensualidad);
             Service.instance().store();
            model.setMensualidad(new Mensualidad("",0,0,0));
            model.setMensualidades(Arrays.asList(mensualidad));
            model.commit();
        } catch (Exception ex) {
            
        }
        
    }
       
    
}
