/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
      
      // Service methods
      //----------------------------Cliente-----------------------------------------------------
    public Cliente clienteGet(String cedula) throws Exception{
        Cliente result=data.getClientes().stream().filter(c->c.getCedula().equals(cedula)).findFirst().orElse(null);
        if (result!=null) return result;
        else throw new Exception("Cliente no existe");   
    }
      public List<Cliente> clienteSearch(String cedula){
        List<Cliente> result=data.getClientes().stream().filter(c->c.getCedula().startsWith(cedula)).collect(Collectors.toList());
       return result;        
    }
    
    public List<Cliente> clienteAll(){
        return data.getClientes();       
    }
    
    public void clienteAdd(Cliente cliente) throws Exception{
        Cliente old=data.getClientes().stream().filter(c->c.getCedula().equals(cliente.getCedula())).findFirst().orElse(null);
        if (old==null) data.getClientes().add(cliente);
        else throw new Exception("Cliente ya existe");           
        
    }  
    //---------------------------Provincias---------------------------------------------------
      public ArrayList<Canton> provincias(String nombre) throws Exception{
       ArrayList<Provincia> PS=(ArrayList) data.getProvincias();
        for(Provincia  p : PS ){
            if(p.getNombre().equals(nombre)){
                return (ArrayList<Canton>) p.getCantones();
            }
        }
         return null;   
    }
       public List<Provincia> provinciaAll(){
        return data.getProvincias();       
    }
        public List<Canton> cantonAll(){
        return data.getCantones();       
    }
       public List<Distrito> distritoAll(){
        return data.getDistritos();       
    }
    
    //-----------------------------Prestamos-----------------------------------------------------
       
        public Prestamo prestamoGet(String numero) throws Exception{
        Prestamo result=data.getPrestamos().stream().filter(c->c.getNumero().equals(numero)).findFirst().orElse(null);
        if (result!=null) return result;
        else throw new Exception("Prestamo no existe");   
    }
      public List<Prestamo> prestamoSearch(String numero){
        List<Prestamo> result=data.getPrestamos().stream().filter(c->c.getNumero().startsWith(numero)).collect(Collectors.toList());
       return result;        
    }
    
    public List<Prestamo> prestamoAll(){
        return data.getPrestamos();       
    }
    
    public void prestamoAdd(Prestamo prestamo) throws Exception{
        Prestamo old=data.getPrestamos().stream().filter(c->c.getNumero().equals(prestamo.getNumero())).findFirst().orElse(null);
        if (old==null) data.getPrestamos().add(prestamo);
        else throw new Exception("Prestamo ya existe");           
        
    }  
    
    //-----------------------------Mensualidad-----------------------------------------------------
       public Mensualidad mensualidadGet(String numero) throws Exception{
        Mensualidad result=data.getMensualidades().stream().filter(c->c.getNumero().equals(numero)).findFirst().orElse(null);
        if (result!=null) return result;
        else throw new Exception("Mensualidad no existe");   
    }
      public List<Mensualidad> mensualidadSearch(String numero){
        List<Mensualidad> result=data.getMensualidades().stream().filter(c->c.getNumero().startsWith(numero)).collect(Collectors.toList());
       return result;        
    }
      
       public List<Mensualidad> mensualidadAll(){
        return data.getMensualidades();       
    }
    
       public void mensualidadAdd(Mensualidad mensualidad) throws Exception{
        Mensualidad old=data.getMensualidades().stream().filter(c->c.getNumero().equals(mensualidad.getNumero())).findFirst().orElse(null);
        if (old==null) data.getMensualidades().add(mensualidad);
        else throw new Exception("mensualidad ya existe");           
        
    }  
    
    
    
    
       //-------------------------------------------------------------------------
           //Combo Box
    public Provincia buscarProvincia(String nombre){
        for(int i = 0;i < provinciaAll().size();i++){
            if(provinciaAll().get(i).getNombre().equals(nombre)){
                return provinciaAll().get(i);
            }
        }
        return null;
    }

      public Canton buscarCanton(String nombre){
        for(int i = 0;i < cantonAll().size();i++){
            if(cantonAll().get(i).getNombre().equals(nombre)){
                return cantonAll().get(i);
            }
        }
        return null;
    }
        public Distrito buscarDistrito(String nombre){
        for(int i = 0;i < distritoAll().size();i++){
            if(distritoAll().get(i).getNombre().equals(nombre)){
                return distritoAll().get(i);
            }
        }
        return null;
    }
       
       //---------------------------------------------------------------------------------------
       public void store(){
        try {
            XmlPersister.instance().store(data);
        } catch (Exception ex) {
        }
    }
    
    public Service() {
        try{
            data=XmlPersister.instance().load();
        }
        catch(Exception e){
            data =  new Data();
        }
        }
        

}