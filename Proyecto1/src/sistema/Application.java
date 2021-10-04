/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import sistema.presentation.clientes.Controller;
import sistema.presentation.clientes.Model;
import sistema.presentation.clientes.View;


public class Application {

    public static void main(String[] args) {
        sistema.presentation.clientes.Model modelClientes=new sistema.presentation.clientes.Model() ;
        sistema.presentation.clientes.View viewClientes = new sistema.presentation.clientes.View();
        sistema.presentation.clientes.Controller controllerClientes = new sistema.presentation.clientes.Controller(modelClientes,viewClientes);
        CLIENTES = controllerClientes;
        CLIENTES.show();
        
        sistema.presentation.prestamo.Model modelprestamo=new sistema.presentation.prestamo.Model() ;
        sistema.presentation.prestamo.View viewprestamo = new sistema.presentation.prestamo.View();
        sistema.presentation.prestamo.Controller controllerprestamo = new sistema.presentation.prestamo.Controller(modelprestamo,viewprestamo);
        PRESTAMO = controllerprestamo;
        
        
        
    }
        public static sistema.presentation.clientes.Controller CLIENTES;
        public static sistema.presentation.prestamo.Controller PRESTAMO;
}
