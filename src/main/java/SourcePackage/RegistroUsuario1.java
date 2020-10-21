package SourcePackage;

import Clases.*;
import static SourcePackage.Main.Escritorio;
import java.util.Iterator;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

public class RegistroUsuario1 extends javax.swing.JInternalFrame {
    
    ControladorUsuario CU = new ControladorUsuario();
    /**
     * Creates new form RegistroCliente1
     */
    public RegistroUsuario1() {
        initComponents();
        jComboBoxInstituto.setVisible(false);
        jLabel7.setVisible(false);
//        jButtonAceptar.setEnabled(false);
        listarinstitutos();
        
    }
    
    public static void listarinstitutos(){
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jButtonAceptar = new javax.swing.JButton();
        jTextFieldLastName = new javax.swing.JTextField();
        jButtonCancelar = new javax.swing.JButton();
        jTextFieldNN = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooserDate = new com.toedter.calendar.JDateChooser();
        jCheckBoxDocente = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxInstituto = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jPasswordFieldPasswd = new javax.swing.JPasswordField();

        setTitle("Registrar Usuario");
        setToolTipText("");

        jLabel4.setText("Nickname:");

        jLabel5.setText("Correo electrónico:");

        jLabel6.setText("Fecha de Nacimiento");

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Ingrese los siguientes datos:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellido:");

        jCheckBoxDocente.setText("Docente");
        jCheckBoxDocente.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBoxDocenteStateChanged(evt);
            }
        });
        jCheckBoxDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDocenteActionPerformed(evt);
            }
        });

        jLabel7.setText("Instituto");

        jComboBoxInstituto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxInstitutoActionPerformed(evt);
            }
        });

        jLabel8.setText("Contraseña");

        jPasswordFieldPasswd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldPasswdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(238, 238, 238)
                            .addComponent(jCheckBoxDocente))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(106, 106, 106)
                            .addComponent(jComboBoxInstituto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(151, 151, 151)
                            .addComponent(jButtonAceptar)
                            .addGap(6, 6, 6)
                            .addComponent(jButtonCancelar)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(78, 78, 78)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(91, 91, 91)
                                    .addComponent(jTextFieldNN, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(103, 103, 103)
                                    .addComponent(jTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(42, 42, 42)
                                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(33, 33, 33)
                                    .addComponent(jDateChooserDate, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel8))
                                    .addGap(85, 85, 85)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextFieldName, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                        .addComponent(jPasswordFieldPasswd)))))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4))
                    .addComponent(jTextFieldNN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jPasswordFieldPasswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2))
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3))
                    .addComponent(jTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5))
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jDateChooserDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jCheckBoxDocente)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel7))
                    .addComponent(jComboBoxInstituto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonCancelar))
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    public static void llamadaInstituto(){
        listarinstitutos();
    }
    
    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        
        String name = jTextFieldName.getText();
        String lastName = jTextFieldLastName.getText();
        String NN = jTextFieldNN.getText();
        String Email = jTextFieldEmail.getText();
        char[] Passwd = jPasswordFieldPasswd.getPassword();
        java.util.Date date = jDateChooserDate.getDate();
        String Ins = (String)jComboBoxInstituto.getSelectedItem();
        
        if(name.isBlank() || lastName.isBlank() || NN.isBlank() || Email.isBlank() || date == null){
            JOptionPane.showMessageDialog( null, "Hay campos incompletos");
        }else{
            
            if(jCheckBoxDocente.isSelected() && jComboBoxInstituto.getSelectedItem() == null){
                JOptionPane.showMessageDialog( null, "Necesita registrar un instituto");
                RegistroInstituto RG2 = new RegistroInstituto();
                RG2.llamadoUsuario();
                Escritorio.add(RG2);
                RG2.setVisible(true);
            }else{
//                System.out.println((String)jComboBoxInstituto.getSelectedItem());
                
                if(CU.findusu(NN)!=null){
                    JOptionPane.showMessageDialog( null, "Error!!\n El Usuario "+NN+"ya esta registrado");
                }else{
                    if(!CU.verFecha(date)){
                        JOptionPane.showMessageDialog( null, "Error!!\n La fecha no es válida.");
                    }
                    else{
                        CU.altaUsuario(name, Passwd, lastName, NN, Email, date, jCheckBoxDocente.isSelected(), Ins);
                        JOptionPane.showMessageDialog( null, "Usuario "+jTextFieldNN.getText()+"\nAgregado Correctamente");
                        limpiarPantalla();
                    }
                }
            }
        }        
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    public void limpiarPantalla(){
        jTextFieldName.setText("");
        jTextFieldLastName.setText("");
        jTextFieldNN.setText("");
        jTextFieldEmail.setText("");
        jCheckBoxDocente.setSelected(false);
        jComboBoxInstituto.setVisible(false);
        jLabel7.setVisible(false);
        jDateChooserDate.setCalendar(null);
    }
    
    private void jCheckBoxDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxDocenteActionPerformed
        if(jCheckBoxDocente.isSelected()){
            jComboBoxInstituto.setVisible(true);
            jLabel7.setVisible(true);
            
        }else{
            jComboBoxInstituto.setVisible(false);
            jLabel7.setVisible(false);
        }
    }//GEN-LAST:event_jCheckBoxDocenteActionPerformed

    private void jCheckBoxDocenteStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBoxDocenteStateChanged
        
    }//GEN-LAST:event_jCheckBoxDocenteStateChanged

    private void jComboBoxInstitutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxInstitutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxInstitutoActionPerformed

    private void jPasswordFieldPasswdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldPasswdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JCheckBox jCheckBoxDocente;
    private static javax.swing.JComboBox<String> jComboBoxInstituto;
    private com.toedter.calendar.JDateChooser jDateChooserDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField jPasswordFieldPasswd;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldLastName;
    private javax.swing.JTextField jTextFieldNN;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables
}
