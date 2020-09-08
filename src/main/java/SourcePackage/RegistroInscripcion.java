/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SourcePackage;

import Clases.PersistenceManager;
import Clases.curso;
import Clases.instituto;
import java.util.Iterator;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class RegistroInscripcion extends javax.swing.JPanel {

    /**
     * Creates new form RegistroInscripcion
     */
    public RegistroInscripcion() {
        initComponents();
        listarinstitutos();
        listarAlumnos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jbtnAgregar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBoxInstituto = new javax.swing.JComboBox<>();
        jComboBoxCursos = new javax.swing.JComboBox<>();
        jComboBoxAlumno = new javax.swing.JComboBox<>();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxEdicion = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        jbtnAgregar.setText("Agregar");
        jbtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");

        jComboBoxInstituto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxInstitutoActionPerformed(evt);
            }
        });

        jComboBoxCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCursosActionPerformed(evt);
            }
        });

        jLabel1.setText("Instituto");

        jLabel2.setText("Cursos");

        jLabel3.setText("Alumnos");

        jLabel4.setText("Ediciones");

        jComboBoxEdicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEdicionActionPerformed(evt);
            }
        });

        jLabel5.setText("Fecha");
        jLabel5.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbtnAgregar)
                        .addGap(53, 53, 53)
                        .addComponent(jButton2)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxEdicion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxInstituto, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxCursos, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxAlumno, javax.swing.GroupLayout.Alignment.TRAILING, 0, 137, Short.MAX_VALUE))))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBoxInstituto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnAgregar)
                    .addComponent(jButton2))
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jbtnAgregarActionPerformed

    private void jComboBoxInstitutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxInstitutoActionPerformed
        // TODO add your handling code here:
        String insti= jComboBoxInstituto.getSelectedItem().toString();
        listarcursos(insti);
        
    }//GEN-LAST:event_jComboBoxInstitutoActionPerformed

    private void jComboBoxCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCursosActionPerformed
        // TODO add your handling code here:
        String curso= jComboBoxEdicion.getSelectedItem().toString();
        listarEdiciones(curso);
    }//GEN-LAST:event_jComboBoxCursosActionPerformed

    private void jComboBoxEdicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEdicionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEdicionActionPerformed
    
    public void listarEdiciones(String curso){
        System.out.println("Cantidad "+ jComboBoxEdicion.getItemCount());
        if(jComboBoxEdicion.getItemCount() > 1){
            System.out.println("if");

            for(int i=0;i<jComboBoxEdicion.getItemCount();i++){
                jComboBoxEdicion.removeItemAt(0);
            }
            jComboBoxEdicion.addItem(" ");
            jComboBoxEdicion.removeItemAt(0);
        }
        EntityManager em = PersistenceManager.getInstance().createEntityManager();

        Query query = em.createQuery("SELECT xd FROM edicioncurso xd WHERE  LIKE :name");// necesito curso id en este caso
        query.setParameter("name", curso);

        Iterator it = query.getResultList().iterator();
        curso cur= null;

        try{
            while ( it.hasNext() ){
                cur = (curso) it.next();
                jComboBoxEdicion.addItem(cur.getName());
            }
        }
        catch (Exception e){
            System.out.println("no hay cursos");
        }  
    }
    
    public void listarAlumnos(){
        EntityManager em = PersistenceManager.getInstance().createEntityManager();

        Query query = em.createQuery("SELECT xd FROM alumno xd ");

        Iterator it = query.getResultList().iterator();
        curso cur= null;

        try{
            while ( it.hasNext() ){
                cur = (curso) it.next();
                jComboBoxAlumno.addItem(cur.getName());
            }
        }
        catch (Exception e){
            System.out.println("no hay Alumnos");
        }  
    }
    
    public void listarcursos(String elemento){
        System.out.println("Cantidad "+ jComboBoxCursos.getItemCount());
        if(jComboBoxCursos.getItemCount() > 1){
            System.out.println("if");

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
        }
        catch (Exception e){
            System.out.println("no hay cursos");
        }  
    }
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
            System.out.println("no hay Institutos");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBoxAlumno;
    private javax.swing.JComboBox<String> jComboBoxCursos;
    private javax.swing.JComboBox<String> jComboBoxEdicion;
    private javax.swing.JComboBox<String> jComboBoxInstituto;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbtnAgregar;
    // End of variables declaration//GEN-END:variables
}
