/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import sistema.logic.Cliente;
import sistema.presentation.clientes.Controller;
import sistema.presentation.clientes.Model;
import sistema.presentation.clientes.View;


public class Application {
 
    public static void main(String[] args) {
        sistema.presentation.clientes.Model modelClientes=new sistema.presentation.clientes.Model() ;
        sistema.presentation.clientes.View viewClientes = new sistema.presentation.clientes.View();
        sistema.presentation.clientes.Controller controllerClientes = new sistema.presentation.clientes.Controller(modelClientes,viewClientes);
        CLIENTES = controllerClientes;

        sistema.presentation.prestamos.Model modelprestamo=new sistema.presentation.prestamos.Model() ;
        sistema.presentation.prestamos.View viewprestamo = new sistema.presentation.prestamos.View();
        sistema.presentation.prestamos.Controller controllerprestamo = new sistema.presentation.prestamos.Controller(modelprestamo,viewprestamo);
        PRESTAMO = controllerprestamo;
        PRESTAMO.show();
       
        sistema.presentation.pagos.Model modelpagos=new sistema.presentation.pagos.Model() ;
        sistema.presentation.pagos.View viewpagos = new sistema.presentation.pagos.View();
        sistema.presentation.pagos.Controller controllerpagos = new sistema.presentation.pagos.Controller(modelpagos,viewpagos);
        PAGOS = controllerpagos;

       CLIENTES.show();

    }
        public static sistema.presentation.clientes.Controller CLIENTES;
        public static sistema.presentation.prestamos.Controller PRESTAMO;
        public static sistema.presentation.pagos.Controller PAGOS;
}