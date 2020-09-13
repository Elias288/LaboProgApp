package SourcePackage;

import Clases.*;
import java.util.Iterator;
import javax.persistence.*;
import javax.swing.JOptionPane;


public class ConsultarEdicionCurso extends javax.swing.JInternalFrame {
    ControladorCurso CC = new ControladorCurso();
    /**
     * Creates new form RegistroCliente1
     */
    public ConsultarEdicionCurso() {
        initComponents();
        listarinstitutos();
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
        jTableEdicionCurso = new javax.swing.JTable();
        campodetexto = new javax.swing.JTextField();
        buscarboton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jComboBoxInstituto = new javax.swing.JComboBox<>();
        jComboBoxCursos = new javax.swing.JComboBox<>();

        setTitle("Consultar Edicion Cursos");
        setToolTipText("");

        jTableEdicionCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableEdicionCurso);

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

        jComboBoxInstituto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxInstitutoItemStateChanged(evt);
            }
        });
        jComboBoxInstituto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxInstitutoActionPerformed(evt);
            }
        });

        jComboBoxCursos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCursosItemStateChanged(evt);
            }
        });
        jComboBoxCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCursosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jComboBoxInstituto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarboton)
                        .addGap(18, 18, 18)
                        .addComponent(campodetexto, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 295, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(26, 26, 26))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(campodetexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buscarboton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxInstituto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campodetextoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campodetextoKeyReleased
        
    }//GEN-LAST:event_campodetextoKeyReleased

    private void buscarbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarbotonActionPerformed
      
    }//GEN-LAST:event_buscarbotonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxInstitutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxInstitutoActionPerformed
        listarcursos(jComboBoxInstituto.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBoxInstitutoActionPerformed

    private void jComboBoxInstitutoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxInstitutoItemStateChanged
        
    }//GEN-LAST:event_jComboBoxInstitutoItemStateChanged

    private void jComboBoxCursosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCursosItemStateChanged
        CC.mostrartabla2(jComboBoxCursos.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBoxCursosItemStateChanged

    private void jComboBoxCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCursosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCursosActionPerformed

    public void listarinstitutos(){
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        
        Iterator it = em.createQuery("SELECT xd FROM instituto xd").getResultList().iterator();
        instituto ins= null;

        try{
            while ( it.hasNext() ){
                ins = (instituto) it.next();
                jComboBoxInstituto.addItem(ins.getFacultad());
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "no hay institutos.");
        }
    }

    public void listarcursos(String elemento){
        if(jComboBoxCursos.getItemCount() > 1){

            for(int i=0;i<jComboBoxCursos.getItemCount();i++){
                jComboBoxCursos.removeItemAt(0);
            }
            jComboBoxCursos.addItem(" ");
            jComboBoxCursos.removeItemAt(0);
        }
        EntityManager em = PersistenceManager.getInstance().createEntityManager();

        Query query = em.createQuery("SELECT xd FROM curso xd JOIN xd.instituto ins WHERE ins.Facultad LIKE :nameins");
        query.setParameter("nameins", elemento);

        Iterator it = query.getResultList().iterator();
        curso cur= null;

        try{
            while ( it.hasNext() ){
                cur = (curso) it.next();
                jComboBoxCursos.addItem(cur.getName());
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "no hay cursos.");;
        }  
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton buscarboton;
    private javax.swing.JTextField campodetexto;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxCursos;
    private javax.swing.JComboBox<String> jComboBoxInstituto;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTableEdicionCurso;
    private java.awt.ScrollPane scrollPane1;
    // End of variables declaration//GEN-END:variables
}
