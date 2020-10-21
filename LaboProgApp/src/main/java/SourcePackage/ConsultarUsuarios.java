package SourcePackage;

import Clases.*;
import static Clases.ControladorUsuario.devolercurso;
import static SourcePackage.Main.Escritorio;
import java.sql.Date;
import javax.persistence.EntityManager;


public class ConsultarUsuarios extends javax.swing.JInternalFrame {
    
    ControladorUsuario CU = new ControladorUsuario();
    /**
     * Creates new form RegistroCliente1
     */
    public ConsultarUsuarios() {
        initComponents();
        CU.mostrartabla("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane1 = new java.awt.ScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        campodetexto = new javax.swing.JTextField();
        buscarboton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setTitle("Consultar Usuarios");
        setToolTipText("");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setShowGrid(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        campodetexto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campodetextoKeyReleased(evt);
            }
        });

        buscarboton.setText("Buscar");
        buscarboton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarbotonActionPerformed(evt);
            }
        });

        jButton1.setText("SALIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(campodetexto, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(buscarboton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(campodetexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarboton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campodetextoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campodetextoKeyReleased
        
    }//GEN-LAST:event_campodetextoKeyReleased

    private void buscarbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarbotonActionPerformed
        
        CU.mostrartabla(campodetexto.getText());
    }//GEN-LAST:event_buscarbotonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        String tipo;
        int seleccionado=jTable1.rowAtPoint(evt.getPoint());
        String NN = (String)jTable1.getValueAt(seleccionado,0);
        String nombre = (String)jTable1.getValueAt(seleccionado,1);
        String apellido = (String)jTable1.getValueAt(seleccionado,2);
        
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        docente doc=em.find(docente.class,NN);
        if (doc==null){tipo="Alumno";}
        else{tipo="Profesor";}
        
        MostrarDatosUsuario MDU = new MostrarDatosUsuario();
        Escritorio.add(MDU);
        MDU.setVisible(true);
        MDU.cargarDatos(NN, nombre, apellido,tipo);
        
    }//GEN-LAST:event_jTable1MouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton buscarboton;
    private javax.swing.JTextField campodetexto;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    private java.awt.ScrollPane scrollPane1;
    // End of variables declaration//GEN-END:variables
}