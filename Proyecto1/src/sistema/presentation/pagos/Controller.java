/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.pagos;

import java.util.ArrayList;
import sistema.Application;
import sistema.logic.Cliente;
import sistema.logic.Pago;
import sistema.logic.Prestamo;


public class Controller {
    Model model;
    View view;
    
       public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        // invoke Model sets for initialization before linking to the view
        // problably get the data from Service
        model.setPago(new Pago());
        model.setPagos(new ArrayList<>());
        
        view.setModel(model);
        view.setController(this);
    }
       //Para pasar el cliente a prestamos 
       public void show(Prestamo prestamo){
        this.view.setVisible(true);
        model.setPrestamo(prestamo);
        view.getPrestamoinfo().setText("Prestamo: "+model.getPrestamo().getNumero());
       
    }
       
      
        public void hide(){
        this.view.setVisible(false);
        Application.PRESTAMO.show();
    }  
      
        
}
