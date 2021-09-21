package sistema.presentation.clientes;

import static java.lang.System.in;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistema.logic.Canton;
import sistema.logic.Cliente;
import sistema.logic.Distrito;
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
        view.setModel(model);
        view.setController(this);
    }
    
    public void show(){
        this.view.setVisible(true);
    }
    
    // Controller methods that respond to View events
    // probably invoke methods from Service,
    // and set data to Model, which in turn causes the View to update 
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
    
    
    public void consultar(String cedula){
        try {
            //Service.instance().provincias();
            
         //   model.setCliente(cliente);
          //  model.commit();
        } catch (Exception ex) {
            model.setCliente(new Cliente());
            model.commit();
        }
        
    }
}
