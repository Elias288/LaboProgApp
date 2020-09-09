/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SourcePackage;
import Clases.PersistenceManager;
import Clases.curso;
import Clases.instituto;
import java.util.*;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import Clases.*;

public class Inscribir extends javax.swing.JInternalFrame {

    /**
     * Creates new form Inscribir
     */
    public Inscribir() {
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

        jButton2 = new javax.swing.JButton();
        jComboBoxInstituto = new javax.swing.JComboBox<>();
        jComboBoxCursos = new javax.swing.JComboBox<>();
        jComboBoxAlumno = new javax.swing.JComboBox<>();
        jDateChooserFecha = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxEdicion = new javax.swing.JComboBox<>();
        jbtnAgregar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setTitle("Inscribir alumno");

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBoxInstituto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBoxInstituto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxInstitutoActionPerformed(evt);
            }
        });

        jComboBoxCursos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBoxCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCursosActionPerformed(evt);
            }
        });

        jComboBoxAlumno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel1.setText("Instituto");

        jLabel2.setText("Cursos");

        jLabel3.setText("Alumnos");

        jLabel4.setText("Ediciones");

        jComboBoxEdicion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jComboBoxEdicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEdicionActionPerformed(evt);
            }
        });

        jbtnAgregar.setText("Agregar");
        jbtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarActionPerformed(evt);
            }
        });

        jLabel5.setText("Fecha");
        jLabel5.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnAgregar)
                        .addGap(53, 53, 53)
                        .addComponent(jButton2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addGap(6, 6, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboBoxEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxInstituto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxCursos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBoxAlumno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
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
                    .addComponent(jDateChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnAgregar)
                    .addComponent(jButton2))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxInstitutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxInstitutoActionPerformed
        // TODO add your handling code here:
        String insti= jComboBoxInstituto.getSelectedItem().toString();
        listarcursos(insti);

    }//GEN-LAST:event_jComboBoxInstitutoActionPerformed

    private void jComboBoxCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCursosActionPerformed
        // TODO add your handling code here:
        listarEdiciones(jComboBoxEdicion.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBoxCursosActionPerformed

    private void jComboBoxEdicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEdicionActionPerformed
        
    }//GEN-LAST:event_jComboBoxEdicionActionPerformed

    private void jbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed
        ControladorCurso CC = new ControladorCurso();
        String edicion = (String)jComboBoxEdicion.getSelectedItem();
        String alumno = (String)jComboBoxAlumno.getSelectedItem();
        Date fecha = jDateChooserFecha.getDate();

        CC.Inscribir(edicion, alumno, fecha);

    }//GEN-LAST:event_jbtnAgregarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    public void listarEdiciones(String curso){
        if(jComboBoxEdicion.getItemCount() > 1){

            for(int i=0;i<jComboBoxEdicion.getItemCount();i++){
                jComboBoxEdicion.removeItemAt(0);
            }
            jComboBoxEdicion.addItem(" ");
            jComboBoxEdicion.removeItemAt(0);
        }
        EntityManager em = PersistenceManager.getInstance().createEntityManager();

        Query query = em.createQuery("SELECT xd FROM edicionCurso xd JOIN xd.Curso cur WHERE cur.nombre LIKE :nameins");
        query.setParameter("nameins", curso+"%");

        List<edicionCurso>lista = query.getResultList();
        
        Iterator it = query.getResultList().iterator();
        edicionCurso Edcur= null;

        try{
            while ( it.hasNext() ){
                Edcur = (edicionCurso) it.next();
                jComboBoxEdicion.addItem(Edcur.getNombre());
            }
        }catch (Exception e){
            System.out.println("no hay ediciones");
        }
    }
    
    public void listarAlumnos(){
        EntityManager em = PersistenceManager.getInstance().createEntityManager();

        Query query = em.createQuery("SELECT xd FROM Alumno xd ");

        Iterator it = query.getResultList().iterator();
        alumno alu= null;

        try{
            while ( it.hasNext() ){
                alu = (alumno) it.next();
                jComboBoxAlumno.addItem(alu.getNN());
            }
        }
        catch (Exception e){
            System.out.println("no hay Alumnos");
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
    private com.toedter.calendar.JDateChooser jDateChooserFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbtnAgregar;
    // End of variables declaration//GEN-END:variables
}
