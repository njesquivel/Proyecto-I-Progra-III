package sistema;

import sistema.presentation.clientes.Controller;
import sistema.presentation.clientes.Model;
import sistema.presentation.clientes.View;


public class Application {

    public static void main(String[] args) {
        Model model=new Model() ;
        View view = new View();
        Controller controller = new Controller(model,view);
        controller.show();
    }
//Maria Cruz
    //Norlan Esquivel
}
