/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentation.clientes;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import sistema.logic.Cliente;


public class View extends javax.swing.JFrame implements java.util.Observer {

    //**************  MVC ***********
    Controller controller;
    Model model;
    int x, y;
    boolean selected = false;
    
    public void setController(Controller controller){
        this.controller=controller;
    }

    public Controller getController() {
        return controller;
    }
    
    public void setModel(Model model){
        this.model=model;
         model.addObserver(this);
    }

    public Model getModel() {
        return model;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        Cliente cliente = model.getCliente();
        llenarDatos(cliente);
    }
    public void llenarDatos(Cliente cliente){
        cedula.setText(cliente.getCedula());
        nombre.setText(cliente.getNombre());
        telefono.setText(cliente.getTelefono());
        if(cliente.getCanton()!=null && cliente.getDistrito()!=null && cliente.getProvincia()!=null){
             selected = true;
           canton.setModel(new javax.swing.DefaultComboBoxModel<>(new String []{cliente.getCanton().getNombre()}));
           distrito.setModel(new javax.swing.DefaultComboBoxModel<>(new String []{cliente.getDistrito().getNombre()}));
           if("Guanacaste".equals(cliente.getProvincia().getNombre())){
                provincia.setText("Guanacaste");
                mapacrlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/provincias/Guanacaste.png")));
           }
            if("Heredia".equals(cliente.getProvincia().getNombre())){
                provincia.setText("Heredia");
                mapacrlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/provincias/here.png")));
           }
            if("Cartago".equals(cliente.getProvincia().getNombre())){
               provincia.setText("Cartago");
                mapacrlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/provincias/Cartago.png")));
           }
            if("Puntarenas".equals(cliente.getProvincia().getNombre())){
               provincia.setText("Puntarenas");
                mapacrlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/provincias/Puntarenas.png")));
           }
             if("Alajuela".equals(cliente.getProvincia().getNombre())){
               provincia.setText("Alajuela");
                mapacrlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/provincias/alajuela.png")));
           }
              if("Limón".equals(cliente.getProvincia().getNombre())){
               provincia.setText("Limón");
                mapacrlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/provincias/limon.png")));
           }
               if("San José".equals(cliente.getProvincia().getNombre())){
               provincia.setText("San José");
                mapacrlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/provincias/sj.png")));
           }
        }
        
        clientes.setModel(new ClientesTableModel(model.getClientes()));
        
    }
//************** END MVC ***********
    
    public View() {
        initComponents();
        setIconImage(getIconImage());
        setLocationRelativeTo(null);
        this.setTitle("Clientes");
    }
    
     //colocar icono del jframe
    @Override
    public Image getIconImage() {
        Image retValeu = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/registro.png"));
        return retValeu;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cedula = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        clientes = new javax.swing.JTable();
        consultar = new javax.swing.JButton();
        listar = new javax.swing.JButton();
        agregar = new javax.swing.JButton();
        mapacrlb = new javax.swing.JLabel();
        provincia = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        canton = new javax.swing.JComboBox<>();
        distrito = new javax.swing.JComboBox<>();
        prestamos = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Cedula");
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Nombre ");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Telefono");

        cedula.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        nombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        telefono.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        clientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        clientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(clientes);

        consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/lupa.png"))); // NOI18N
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });

        listar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/listar.png"))); // NOI18N
        listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarActionPerformed(evt);
            }
        });

        agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/guardar.png"))); // NOI18N
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        mapacrlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/provincias/mapa.png"))); // NOI18N
        mapacrlb.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                mapacrlbMouseMoved(evt);
            }
        });
        mapacrlb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mapacrlbMouseClicked(evt);
            }
        });

        provincia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Provincia");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Cantón");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Distrito");

        canton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantonActionPerformed(evt);
            }
        });

        prestamos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/iconos/prestamos.png"))); // NOI18N
        prestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prestamosActionPerformed(evt);
            }
        });

        jButton1.setText("Reporte PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(136, 136, 136)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(canton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(provincia, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(88, 88, 88)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(distrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(listar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(mapacrlb, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(prestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(99, 99, 99))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(listar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(mapacrlb, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(provincia, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(canton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(distrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(92, 92, 92)
                        .addComponent(prestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(223, 223, 223))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        // TODO add your handling code here:
         controller.clienteGet(cedula.getText());
    }//GEN-LAST:event_consultarActionPerformed

    private void listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarActionPerformed
        // TODO add your handling code here:
         controller.clienteSearch(cedula.getText());
    }//GEN-LAST:event_listarActionPerformed

    private void clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientesMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            controller.clienteEdit(clientes.getSelectedRow());
        }
    }//GEN-LAST:event_clientesMouseClicked

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        if (!"".equals(provincia.getText()) &&
                !"".equals((String) canton.getSelectedItem()) 
                && !"".equals((String) distrito.getSelectedItem())&&
                !"".equals(cedula.getText())
                &&!"".equals(nombre.getText())
                &&!"".equals(telefono.getText())) {
            controller.clienteAdd(new Cliente(cedula.getText(), nombre.getText(), telefono.getText(), controller.getProvincia(provincia.getText()), controller.getCanton((String) canton.getSelectedItem()), controller.getDistrito((String) distrito.getSelectedItem())));
      JOptionPane.showMessageDialog(null,"Operación realizada correctamente", "Exitoso",JOptionPane.INFORMATION_MESSAGE);
        }else{
              JOptionPane.showMessageDialog(null,"Existen campos invalidos ", "ERROR",JOptionPane.ERROR_MESSAGE);
        }
        canton.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{}));
        distrito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{}));
        selected = false;
        mapacrlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/provincias/mapa.png")));
    }//GEN-LAST:event_agregarActionPerformed

    private void mapacrlbMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapacrlbMouseMoved
        // TODO add your handling code here:
        
        x = evt.getX();
        y = evt.getY();
     //   System.out.println("(" + x + ", " + y + ")");
     if (!selected){
        if (x > 40 && x < 140 && y > 16 && y < 133) {//Guanacaste
            mapacrlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/provincias/Guanacaste.png")));
       
        } else {
            if (x > 140 && x < 240 && y > 16 && y < 150) {//Alajuela
                mapacrlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/provincias/alajuela.png")));
            } else {
                if (x > 240 && x < 272 && y > 16 && y < 150) {//Heredia
                    mapacrlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/provincias/here.png")));
                } else {
                    if (x > 272 && x < 340 && y > 16 && y < 150 || x > 326 && x < 440 && y > 160 && y < 235) {//Limon
                        mapacrlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/provincias/limon.png")));
                    } else {
                        if (x > 269 && x < 320 && y > 140 && y < 190) {//Cartago
                            mapacrlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/provincias/Cartago.png")));
                        } else {
                            if (x > 260 && x < 320 && y > 200 && y < 225 || x > 198 && x < 269 && y > 153 && y < 180 || x > 236 && x < 280 && y > 180 && y < 200) {//SJ
                                mapacrlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/provincias/sj.png")));
                            } else {
                                if (x > 100 && x < 400 && y > 240 && y < 350 || x > 100 && x < 260 && y > 200 && y < 220 || x > 100 && x < 190 && y > 133 && y < 200) {//punta
                                    mapacrlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/provincias/Puntarenas.png")));
                                }
                            }

                        }

                    }

                }

            }
        }
    }//GEN-LAST:event_mapacrlbMouseMoved
    }
    private void mapacrlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapacrlbMouseClicked
        // TODO add your handling code here:
        if(!selected){ 
        canton.setModel(new javax.swing.DefaultComboBoxModel<>(new String []{}));
        distrito.setModel(new javax.swing.DefaultComboBoxModel<>(new String []{}));
        x = evt.getX();
        y = evt.getY();
       // distrito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{}));
       
           if (x > 40 && x < 140 && y > 16 && y < 133) {//Guanacaste
                provincia.setText("Guanacaste");
                selected = true;
                try {
                    canton.setModel(new javax.swing.DefaultComboBoxModel<>(controller.Cantones("Guanacaste")));
                } catch (Exception ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            } else {
                if (x > 140 && x < 240 && y > 16 && y < 150) {//Alajuela
                    provincia.setText("Alajuela");
                    selected = true;            
                    try {
                        canton.setModel(new javax.swing.DefaultComboBoxModel<>(controller.Cantones("Alajuela")));
                    } catch (Exception ex) {
                        Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (x > 240 && x < 272 && y > 16 && y < 150) {//Heredia
                        provincia.setText("Heredia");
                        selected = true; 
                        try {
                            canton.setModel(new javax.swing.DefaultComboBoxModel<>(controller.Cantones("Heredia")));
                        } catch (Exception ex) {
                            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        if (x > 272 && x < 340 && y > 16 && y < 150 || x > 326 && x < 440 && y > 160 && y < 235) {//Limon
                            provincia.setText("Limón");
                            selected = true; 
                            try {
                                canton.setModel(new javax.swing.DefaultComboBoxModel<>(controller.Cantones("Limón")));
                            } catch (Exception ex) {
                                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            if (x > 269 && x < 320 && y > 140 && y < 190) {//Cartago
                                provincia.setText("Cartago");
                                selected = true; 
                                try {
                                    canton.setModel(new javax.swing.DefaultComboBoxModel<>(controller.Cantones("Cartago")));
                                } catch (Exception ex) {
                                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } else {
                                if (x > 260 && x < 320 && y > 200 && y < 225 || x > 198 && x < 269 && y > 153 && y < 180 || x > 236 && x < 280 && y > 180 && y < 200) {//SJ
                                    provincia.setText("San José");
                                    selected = true; 
                                    try {
                                        canton.setModel(new javax.swing.DefaultComboBoxModel<>(controller.Cantones("San José")));
                                    } catch (Exception ex) {
                                        Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                } else {
                                    if (x > 100 && x < 400 && y > 240 && y < 350 || x > 100 && x < 260 && y > 200 && y < 220 || x > 100 && x < 190 && y > 133 && y < 200) {//punta
                                        provincia.setText("Puntarenas");
                                        selected = true; 
                                        try {
                                            canton.setModel(new javax.swing.DefaultComboBoxModel<>(controller.Cantones("Puntarenas")));
                                        } catch (Exception ex) {
                                            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    } else {
                                        mapacrlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/provincias/mapa.png")));
                                        selected = false;
                                    }
                                }

                            }

                        }

                    }

                }
            }
        }
    }//GEN-LAST:event_mapacrlbMouseClicked

    private void cantonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantonActionPerformed
        // TODO add your handling code here:
        String x = String.valueOf(canton.getSelectedItem());
          
             try {
                    distrito.setModel(new javax.swing.DefaultComboBoxModel<>(controller.Distritos(provincia.getText(),x)));
                } catch (Exception ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_cantonActionPerformed

    private void prestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prestamosActionPerformed
        // TODO add your handling code here:
      controller.prestamosShow();
    }//GEN-LAST:event_prestamosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JComboBox<String> canton;
    private javax.swing.JTextField cedula;
    private javax.swing.JTable clientes;
    private javax.swing.JButton consultar;
    private javax.swing.JComboBox<String> distrito;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton listar;
    private javax.swing.JLabel mapacrlb;
    private javax.swing.JTextField nombre;
    private javax.swing.JButton prestamos;
    private javax.swing.JLabel provincia;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
