/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import sistema.data.Data;
import sistema.data.XmlPersister;


//bibliotecas para PDF
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import java.io.*;


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
       //List<Prestamo> result=data.getPrestamos().stream().filter(c->c.getCliente().getCedula()..collect(Collectors.toList());
       
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
    
    /// pruebas 
    
  
    
    //-----------------------------Pago-----------------------------------------------------
       public Pago pagoGet(String numero) throws Exception{
        Pago result=data.getPagos().stream().filter(c->c.getNumero().equals(numero)).findFirst().orElse(null);
        if (result!=null) return result;
        else throw new Exception("Pago no existe");   
    }
      public List<Pago> pagoSearch(String numero){
        List<Pago> result=data.getPagos().stream().filter(c->c.getNumero().startsWith(numero)).collect(Collectors.toList());
       return result;        
    }
      
       public List<Pago> pagoAll(){
        return data.getPagos();       
    }
    
       public void pagoAdd(Pago pago) throws Exception{
        Pago old=data.getPagos().stream().filter(c->c.getNumero().equals(pago.getNumero())).findFirst().orElse(null);
        if (old==null) data.getPagos().add(pago);
        else throw new Exception("Pago ya existe");           
        
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
    
    
    //------------------------------PDF-------------------//
       
    
        public void CrearPDFcliente(String dest,Cliente cliente) throws IOException{
        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf, PageSize.A4.rotate());
        document.setMargins(20, 20, 20, 20);
       
        
        ImageData data = ImageDataFactory.create("logo.png");        
        Image img = new Image(data); 
        document.add(img);
        
        document.add(new Paragraph(""));
        
        document.add(new Paragraph("Clientes Banco S.A ").setFont(font).setBold().setFontSize(20f));
        
        Table table = new Table(6); // tabla 
        Cell c; 
        Color blanco= ColorConstants.WHITE;
        Color negro= ColorConstants.BLACK;
        c= new Cell(); c.add(new Paragraph("Cedula")).setBackgroundColor(blanco).setFontColor(negro); 
        table.addHeaderCell(c);
        c= new Cell(); c.add(new Paragraph("Nombre")).setBackgroundColor(blanco).setFontColor(negro);
        table.addHeaderCell(c);     
        c= new Cell(); c.add(new Paragraph("Telefono")).setBackgroundColor(blanco).setFontColor(negro);
        table.addHeaderCell(c); 
        c= new Cell(); c.add(new Paragraph("Provincia")).setBackgroundColor(blanco).setFontColor(negro);
        table.addHeaderCell(c); 
        c= new Cell(); c.add(new Paragraph("Canton")).setBackgroundColor(blanco).setFontColor(negro);
        table.addHeaderCell(c);
        c= new Cell(); c.add(new Paragraph("Distrito")).setBackgroundColor(blanco).setFontColor(negro);
        table.addHeaderCell(c); 
      
        List<Cliente> lista=this.clienteAll();
        for(Cliente c1:lista){
          
            table.addHeaderCell(c1.getCedula());
            table.addHeaderCell(c1.getNombre());
            table.addHeaderCell(c1.getTelefono());  
            table.addHeaderCell(c1.getProvincia().getNombre());             
            table.addHeaderCell(String.valueOf(c1.getCanton()));
            table.addHeaderCell(String.valueOf(c1.getDistrito()));
          
            }
           
        document.add(table);
        document.close();
        }
        
        
    
}