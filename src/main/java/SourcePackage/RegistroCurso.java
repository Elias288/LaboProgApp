package SourcePackage;

import Clases.*;
import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

public class RegistroCurso extends javax.swing.JInternalFrame {

    List<curso> CurList = new ArrayList<>();
    int cont = 0;
    EntityManager em = PersistenceManager.getInstance().createEntityManager();
    ControladorCurso CC = new ControladorCurso();
    ControladorUsuario CU = new ControladorUsuario();
    
    /**
     * Creates new form RegistroCurso
     */
    public RegistroCurso() {
        initComponents();
        listarInstitutos();
 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLocaleChooser1 = new com.toedter.components.JLocaleChooser();
        jSpinField1 = new com.toedter.components.JSpinField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jSpinField3 = new com.toedter.components.JSpinField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldDesc = new javax.swing.JTextField();
        jTextFieldURL = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSpinnerCredits = new javax.swing.JSpinner();
        jDateChooserDate = new com.toedter.calendar.JDateChooser();
        jSpinnerHour = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jSpinnerDuracion = new javax.swing.JSpinner();
        jCBinstituto = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxCursos = new javax.swing.JComboBox<>();
        jButtonAgregarCurso = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxDocente = new javax.swing.JComboBox<>();

        setResizable(true);
        setTitle("Registrar Curso");

        jLabel1.setText("Nombre Curso");

        jLabel2.setText("Instituto");

        jLabel3.setText("Descripcion");

        jLabel4.setText("Cantdad de Horas");

        jLabel5.setText("Cantidad de Creditos");

        jLabel6.setText("URL");

        jLabel7.setText("Fecha de Alta");

        jTextFieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNameActionPerformed(evt);
            }
        });

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jSpinnerCredits.setModel(new javax.swing.SpinnerNumberModel(0, 0, 20, 1));

        jSpinnerHour.setModel(new javax.swing.SpinnerNumberModel(0, 0, 8, 1));

        jLabel8.setText("Duracion (meses)");

        jSpinnerDuracion.setModel(new javax.swing.SpinnerNumberModel(0, 0, 6, 1));

        jCBinstituto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBinstitutoActionPerformed(evt);
            }
        });

        jLabel9.setText("Seleccione las Previas");

        jComboBoxCursos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jButtonAgregarCurso.setText("Agregar");
        jButtonAgregarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarCursoActionPerformed(evt);
            }
        });

        jLabel10.setText("Docente");

        jComboBoxDocente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel6)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDateChooserDate, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                    .addComponent(jTextFieldURL)
                                    .addComponent(jTextFieldDesc)
                                    .addComponent(jTextFieldName)
                                    .addComponent(jSpinnerCredits)
                                    .addComponent(jSpinnerHour)
                                    .addComponent(jSpinnerDuracion, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jComboBoxCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonAgregarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCBinstituto, 0, 149, Short.MAX_VALUE)
                            .addComponent(jComboBoxDocente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jCBinstituto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBoxDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jSpinnerHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jSpinnerDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jSpinnerCredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jDateChooserDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBoxCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAgregarCurso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void listarInstitutos(){
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        
        Iterator it = em.createQuery("SELECT xd FROM instituto xd").getResultList().iterator();
        instituto ins= null;
        try{
            while ( it.hasNext() ){
                ins = (instituto) it.next();
                jCBinstituto.addItem(ins.getFacultad());
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "no hay institutos.");
        }
        em.close();
    }
    
    public void listarcursos(String instituto){
        if(jComboBoxCursos.getItemCount() > 1){
            jComboBoxCursos.removeAllItems();
            jComboBoxCursos.addItem(" ");
        }
        EntityManager em = PersistenceManager.getInstance().createEntityManager();

        Query query = em.createQuery("SELECT xd FROM curso xd JOIN xd.instituto ins WHERE ins.Facultad LIKE :nameins");
        query.setParameter("nameins", instituto);

        Iterator it = query.getResultList().iterator();
        curso cur= null;

        try{
            while ( it.hasNext() ){
                cur = (curso) it.next();
                jComboBoxCursos.addItem(cur.getName());
                jComboBoxCursos.repaint();
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "no hay cursos.");
        }  
    }
    
    public void listarDocente(String instituto){
        int cant = jComboBoxDocente.getItemCount();
        if(cant > 1){
            jComboBoxDocente.removeAllItems();
            jComboBoxDocente.addItem(" ");
        }
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        
        Query query = em.createQuery("SELECT xd FROM Docente xd JOIN xd.instituto ins WHERE ins.Facultad LIKE :nameins");
        query.setParameter("nameins", instituto);

        Iterator it = query.getResultList().iterator();
        docente doc= null;

        try{
            while ( it.hasNext() ){
                doc = (docente) it.next();
                jComboBoxDocente.addItem(doc.getNN());
                jComboBoxDocente.repaint();
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error!!!\nNo hay docentes.");
        }
    }
    
    public void cargarPrevias(){
        String Cursoname = (String)jComboBoxCursos.getSelectedItem();
        if(Cursoname.isBlank()){
            JOptionPane.showMessageDialog( null, "No hay cursos agregados");
        }else{
            TypedQuery<Long> queryId = em.createQuery(  "SELECT id FROM curso WHERE nombre LIKE :names", Long.class);
            queryId.setParameter("names", Cursoname);
            long ides = queryId.getSingleResult();
            
            curso Curs = em.find(curso.class, ides);
            
            CurList.add(Curs);
        }
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        int duracion = (int) jSpinnerDuracion.getValue();
        int horas = (int )jSpinnerHour.getValue();
        int credits = (int)jSpinnerCredits.getValue();
        
        Date fecha = jDateChooserDate.getDate();
        
        String name =jTextFieldName.getText();
        String instituto = (String)jCBinstituto.getSelectedItem();
        String docente = (String)jComboBoxDocente.getSelectedItem();
        String descripcion = jTextFieldDesc.getText();
        String Url = jTextFieldURL.getText();
        
        if(name.isBlank() || instituto.isBlank() || descripcion.isBlank() || Url.isBlank() || duracion == 0 
                || horas==0 || fecha == null || credits==0){
            JOptionPane.showMessageDialog( null, "Hay campos incompletos");
        }else{
            if(!CU.verFecha(fecha)){
                JOptionPane.showMessageDialog( null, "La fecha de alta no es válida.");
            }
            else{
                CC.AltaCurso(name, instituto, descripcion , Url, duracion,horas, fecha, credits, CurList, docente);
                JOptionPane.showMessageDialog( null, "Curso "+jTextFieldName.getText()+"\nAgregado Correctamente");
            }   
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCBinstitutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBinstitutoActionPerformed
        listarcursos(jCBinstituto.getSelectedItem().toString());
        listarDocente(jCBinstituto.getSelectedItem().toString());
    }//GEN-LAST:event_jCBinstitutoActionPerformed

    private void jTextFieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNameActionPerformed

    private void jButtonAgregarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarCursoActionPerformed
        cargarPrevias();
        JOptionPane.showMessageDialog(null, "Previa Cargada");
    }//GEN-LAST:event_jButtonAgregarCursoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAgregarCurso;
    private javax.swing.JComboBox<String> jCBinstituto;
    private javax.swing.JComboBox<String> jComboBoxCursos;
    private javax.swing.JComboBox<String> jComboBoxDocente;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooserDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.components.JLocaleChooser jLocaleChooser1;
    private com.toedter.components.JSpinField jSpinField1;
    private com.toedter.components.JSpinField jSpinField3;
    private javax.swing.JSpinner jSpinnerCredits;
    private javax.swing.JSpinner jSpinnerDuracion;
    private javax.swing.JSpinner jSpinnerHour;
    private javax.swing.JTextField jTextFieldDesc;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldURL;
    // End of variables declaration//GEN-END:variables
}
