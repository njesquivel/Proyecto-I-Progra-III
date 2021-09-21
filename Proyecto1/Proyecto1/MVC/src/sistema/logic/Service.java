package sistema.logic;

import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import sistema.data.Data;
import sistema.data.XmlPersister;

public class Service {
    
    // Singleton implementation
    private static Service theInstance;
    public static Service instance(){
        if (theInstance==null){ 
            theInstance=new Service();
        }
        return theInstance;
    }
    
    // Service data
      private Data data;
    //Map<String, Cliente> clientes;
    
    
    // Service methods
         public Cliente clienteGet(String cedula) throws Exception{
        Cliente result=data.getClientes().stream().filter(c->c.getCedula().equals(cedula)).findFirst().orElse(null);
        if (result!=null) return result;
        else throw new Exception("Cliente no existe");   
    }
         public ArrayList<Canton> provincias(String nombre) throws Exception{
       // Provincia  P = (Provincia) data.getProvincias().stream().filter(c->c.getNombre().equals(nombre));
       ArrayList<Provincia> PS=(ArrayList) data.getProvincias();
        for(Provincia  p : PS ){
            if(p.getNombre().equals(nombre)){
                return (ArrayList<Canton>) p.getCantones();
            }
        }
        

         return null;
                
      
        
    }
     /* 
         
    public Cliente clienteGet(String cedula) throws Exception{
        Cliente result=clientes.get(cedula);
        if(result!=null) return result;
        else throw new Exception("Cliente no existe");
    }
 */
      public Service() {
        try{
            data = XmlPersister.instance().load();
            //System.out.print(data);
        }
        catch(Exception e){
            data =  new Data();
        }
        
       //  clientes =new HashMap<>();
       // clientes.put("111", new Cliente("111","Maria Fernanda","63264136"));
       // clientes.put("222", new Cliente("222","Juan Perez ","88888888"));
        
    }
    
}
