package SourcePackage;

import Clases.*;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class RegistroEdicionCurso2 extends javax.swing.JInternalFrame {
    ControladorCurso CC = new ControladorCurso();
    /**
     * Creates new form RegistroCliente1
     */
    public RegistroEdicionCurso2() {
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jBregistrar = new javax.swing.JButton();
        jDCfechaFin = new com.toedter.calendar.JDateChooser();
        jDCfechaPub = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jDCfechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jTFnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jBcancelar = new javax.swing.JButton();
        jCBcurso = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jSpinnerCupos = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setResizable(true);
        setTitle("Registro Edicion de Curso");
        setToolTipText("");

        jLabel5.setText("Fecha Inicio:");

        jLabel6.setText("Fecha Fin:");

        jBregistrar.setText("Registrar");
        jBregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBregistrarActionPerformed(evt);
            }
        });

        jLabel7.setText("Fecha de publciacion:");

        jLabel1.setText("Nombre: ");

        jLabel3.setText("Cupos:");

        jBcancelar.setText("Cancelar");
        jBcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcancelarActionPerformed(evt);
            }
        });

        jCBcurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jCBcurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBcursoActionPerformed(evt);
            }
        });

        jLabel2.setText("Curso:");

        jSpinnerCupos.setModel(new javax.swing.SpinnerNumberModel(0, 0, 30, 1));

        jLabel4.setText("Institutos");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jBregistrar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jBcancelar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jDCfechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDCfechaPub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDCfechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jSpinnerCupos, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(43, 43, 43)
                        .addComponent(jTFnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCBcurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBcurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTFnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jSpinnerCupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDCfechaPub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jDCfechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDCfechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBcancelar)
                            .addComponent(jBregistrar))))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBregistrarActionPerformed
        // TODO add your handling code here:
        java.util.Date fechaPub;
        java.util.Date fechaInicio;
        java.util.Date fechaFin;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        fechaPub = jDCfechaPub.getDate();
        fechaInicio = jDCfechaInicio.getDate();
        fechaFin = jDCfechaFin.getDate();
        //String dateTime = (String) sdf.format(jDateChooser1.getDate());
        
        if((int)jSpinnerCupos.getValue()> 0 && !jTFnombre.getText().equals("") && jDCfechaPub.getDate()!=null && jDCfechaInicio.getDate()!=null && jDCfechaFin.getDate()!=null){
            if(fechaInicio.compareTo(fechaFin) < 0){
                ControladorCurso ca = new ControladorCurso();
                ca.altaEdicion(jTFnombre.getText(), fechaInicio, fechaFin, (int)jSpinnerCupos.getValue(), fechaPub,(String)jCBcurso.getSelectedItem());
                JOptionPane.showMessageDialog(null, "Edicion: "+jTFnombre.getText()+ " agregado correctamente");
            }
            else{
                JOptionPane.showMessageDialog(null, "La fecha de inicio no puede ser menor o igual a la fecha de fin.");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Debe llenar todos lo campos para registrar la Edición.");
        }
        
    }//GEN-LAST:event_jBregistrarActionPerformed

    private void jBcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jBcancelarActionPerformed

    private void jCBcursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBcursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBcursoActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        listarcursos(jComboBox1.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBox1ActionPerformed
    
    public void listarcursos(String instituto){
        if(jCBcurso.getItemCount() > 1){
            jCBcurso.removeAllItems();
            jCBcurso.addItem(" ");
        }
        EntityManager em = PersistenceManager.getInstance().createEntityManager();

        Query query = em.createQuery("SELECT xd FROM curso xd JOIN xd.instituto ins WHERE ins.Facultad LIKE :nameins");
        query.setParameter("nameins", instituto);

        Iterator it = query.getResultList().iterator();
        curso cur= null;

        try{
            while ( it.hasNext() ){
                cur = (curso) it.next();
                jCBcurso.addItem(cur.getName());
                jCBcurso.repaint();
            }
        }catch (Exception e){
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
                jComboBox1.addItem(ins.getFacultad());
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "no hay institutos.");
        }
    }
    
    public void limpiarForm(){
            jSpinnerCupos.setValue(0);
            jTFnombre.setText("");
            jDCfechaFin.setCalendar(null);
            jDCfechaInicio.setCalendar(null);
            jDCfechaPub.setCalendar(null);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBcancelar;
    private javax.swing.JButton jBregistrar;
    private javax.swing.JComboBox<String> jCBcurso;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDCfechaFin;
    private com.toedter.calendar.JDateChooser jDCfechaInicio;
    private com.toedter.calendar.JDateChooser jDCfechaPub;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSpinner jSpinnerCupos;
    private javax.swing.JTextField jTFnombre;
    private java.awt.ScrollPane scrollPane1;
    // End of variables declaration//GEN-END:variables
}
