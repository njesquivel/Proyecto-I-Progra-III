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
    }
        public static sistema.presentation.clientes.Controller CLIENTES;
}
