package sistema.presentation.clientes;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import sistema.logic.Cliente;

public class View extends javax.swing.JFrame implements java.util.Observer {

//**************  MVC ***********
    Controller controller;
    Model model;
    int x, y;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Controller getController() {
        return controller;
    }

    public void setModel(Model model) {
        this.model = model;
        model.addObserver(this);
    }

    public Model getModel() {
        return model;
    }

    @Override
    public void update(Observable o, Object arg) {
        Cliente cliente = model.getCliente();
        cedula.setText(cliente.getCedula());
        nombre.setText(cliente.getNombre());
        telefono.setText(cliente.getTelefono());

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

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cedula = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        consultar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        provincia = new javax.swing.JLabel();
        mapacrlb = new javax.swing.JLabel();
        cantonBox = new javax.swing.JComboBox<>();
        distritoBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        guardar = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cedula ");

        jLabel2.setText("Nombre");

        jLabel3.setText("Telefono");

        consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupa.png"))); // NOI18N
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });

        jLabel4.setText("Provincia");

        provincia.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        cantonBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cantonBoxMouseClicked(evt);
            }
        });
        cantonBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantonBoxActionPerformed(evt);
            }
        });

        jLabel5.setText("Cantón");

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel7");

        jLabel8.setText("Distrito");

        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mapacrlb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(provincia, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(22, 333, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel1))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cantonBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))
                                        .addGap(22, 22, 22)))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(distritoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(410, 410, 410)
                                .addComponent(jLabel6)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(provincia, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cantonBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(distritoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(mapacrlb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        controller.consultar(cedula.getText());
    }//GEN-LAST:event_consultarActionPerformed

    private void mapacrlbMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapacrlbMouseMoved
        // TODO add your handling code here:
        
        x = evt.getX();
        y = evt.getY();
        System.out.println("(" + x + ", " + y + ")");
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

    private void mapacrlbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapacrlbMouseClicked
        // TODO add your handling code here:
        x = evt.getX();
        y = evt.getY();
        distritoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{}));
        if (x > 40 && x < 140 && y > 16 && y < 133) {//Guanacaste
            provincia.setText("Guanacaste");

            try {
                cantonBox.setModel(new javax.swing.DefaultComboBoxModel<>(controller.Cantones("Guanacaste")));
            } catch (Exception ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (x > 140 && x < 240 && y > 16 && y < 150) {//Alajuela
                provincia.setText("Alajuela");
                try {
                    cantonBox.setModel(new javax.swing.DefaultComboBoxModel<>(controller.Cantones("Alajuela")));
                } catch (Exception ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                if (x > 240 && x < 272 && y > 16 && y < 150) {//Heredia
                    provincia.setText("Heredia");
                    try {
                        cantonBox.setModel(new javax.swing.DefaultComboBoxModel<>(controller.Cantones("Heredia")));
                    } catch (Exception ex) {
                        Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (x > 272 && x < 340 && y > 16 && y < 150 || x > 326 && x < 440 && y > 160 && y < 235) {//Limon
                        provincia.setText("Limón");
                        try {
                            cantonBox.setModel(new javax.swing.DefaultComboBoxModel<>(controller.Cantones("Limón")));
                        } catch (Exception ex) {
                            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        if (x > 269 && x < 320 && y > 140 && y < 190) {//Cartago
                            provincia.setText("Cartago");
                            try {
                                cantonBox.setModel(new javax.swing.DefaultComboBoxModel<>(controller.Cantones("Cartago")));
                            } catch (Exception ex) {
                                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            if (x > 260 && x < 320 && y > 200 && y < 225 || x > 198 && x < 269 && y > 153 && y < 180 || x > 236 && x < 280 && y > 180 && y < 200) {//SJ
                                provincia.setText("San José");
                                try {
                                    cantonBox.setModel(new javax.swing.DefaultComboBoxModel<>(controller.Cantones("San José")));
                                } catch (Exception ex) {
                                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } else {
                                if (x > 100 && x < 400 && y > 240 && y < 350 || x > 100 && x < 260 && y > 200 && y < 220 || x > 100 && x < 190 && y > 133 && y < 200) {//punta
                                    provincia.setText("Puntarenas");
                                    try {
                                        cantonBox.setModel(new javax.swing.DefaultComboBoxModel<>(controller.Cantones("Puntarenas")));
                                    } catch (Exception ex) {
                                        Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                } else {
                                    mapacrlb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistema/presentation/provincias/mapa.png")));
                                }
                            }

                        }

                    }

                }

            }
        }
    }//GEN-LAST:event_mapacrlbMouseClicked

    private void cantonBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cantonBoxMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_cantonBoxMouseClicked

    private void cantonBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantonBoxActionPerformed
        // TODO add your handling code here:
         String x = String.valueOf(cantonBox.getSelectedItem());
       // System.out.print(x);
             try {
                    distritoBox.setModel(new javax.swing.DefaultComboBoxModel<>(controller.Distritos(provincia.getText(),x)));
                } catch (Exception ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_cantonBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cantonBox;
    private javax.swing.JTextField cedula;
    private javax.swing.JButton consultar;
    private javax.swing.JComboBox<String> distritoBox;
    private javax.swing.JButton guardar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel mapacrlb;
    private javax.swing.JTextField nombre;
    private javax.swing.JLabel provincia;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}