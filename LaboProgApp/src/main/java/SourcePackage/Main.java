package SourcePackage;
import servidor.webserver;
import Clases.*;
import java.util.*;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {
    boolean usuarioB = false, institutoB = false, categoriaB = false, cursoB = false, edicionB = false;
    
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        webserver p = new webserver();
        p.publicar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jMenuItem4 = new javax.swing.JMenuItem();
        Escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuInicio = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jMenuRegistro = new javax.swing.JMenu();
        jMenuItemRegistrarClientes = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItemAgregarPrograma = new javax.swing.JMenuItem();
        jMenuItemAgregarCursoPrograma = new javax.swing.JMenuItem();
        jMenuItemInscribirCursoPrograma = new javax.swing.JMenuItem();
        jMenuItemRegistrarEstudiantePrograma = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuConsultas = new javax.swing.JMenu();
        jMenuItemConsultaUsuario = new javax.swing.JMenuItem();
        jMenuItemConsultaCurso = new javax.swing.JMenuItem();
        jMenuItemEdicionCurso = new javax.swing.JMenuItem();
        jMenuItemConsultarPrograma = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemModificar = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 917, Short.MAX_VALUE)
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
        );

        jMenuBar1.setToolTipText("Edext");

        jMenuInicio.setText("Inicio");

        jMenuItem5.setText("Cargar Datos de Pruebas");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenuInicio.add(jMenuItem5);

        jMenuItemSalir.setText("Salir");
        jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalirActionPerformed(evt);
            }
        });
        jMenuInicio.add(jMenuItemSalir);

        jMenuBar1.add(jMenuInicio);

        jMenuRegistro.setText("Registros");

        jMenuItemRegistrarClientes.setText("Registrar Usuario");
        jMenuItemRegistrarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRegistrarClientesActionPerformed(evt);
            }
        });
        jMenuRegistro.add(jMenuItemRegistrarClientes);

        jMenuItem1.setText("Registrar Instituto");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuRegistro.add(jMenuItem1);

        jMenuItem2.setText("Registrar Curso");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuRegistro.add(jMenuItem2);

        jMenuItem3.setText("Registrar Edición Curso");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenuRegistro.add(jMenuItem3);

        jMenuItem6.setText("Registrar Inscripcion");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenuRegistro.add(jMenuItem6);

        jMenuItemAgregarPrograma.setText("Registrar Programa Formacion");
        jMenuItemAgregarPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAgregarProgramaActionPerformed(evt);
            }
        });
        jMenuRegistro.add(jMenuItemAgregarPrograma);

        jMenuItemAgregarCursoPrograma.setText("Registrar Curso a Programa ");
        jMenuItemAgregarCursoPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAgregarCursoProgramaActionPerformed(evt);
            }
        });
        jMenuRegistro.add(jMenuItemAgregarCursoPrograma);

        jMenuItemInscribirCursoPrograma.setText("Registrar Inscripcion Curso programa");
        jMenuItemInscribirCursoPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInscribirCursoProgramaActionPerformed(evt);
            }
        });
        jMenuRegistro.add(jMenuItemInscribirCursoPrograma);

        jMenuItemRegistrarEstudiantePrograma.setText("Registrar Estudiante a Programa");
        jMenuItemRegistrarEstudiantePrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRegistrarEstudianteProgramaActionPerformed(evt);
            }
        });
        jMenuRegistro.add(jMenuItemRegistrarEstudiantePrograma);

        jMenuItem7.setText("Registrar Categoria");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenuRegistro.add(jMenuItem7);

        jMenuBar1.add(jMenuRegistro);

        jMenuConsultas.setText("Consultas");

        jMenuItemConsultaUsuario.setText("Consultar Usuario");
        jMenuItemConsultaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaUsuarioActionPerformed(evt);
            }
        });
        jMenuConsultas.add(jMenuItemConsultaUsuario);

        jMenuItemConsultaCurso.setText("Consultar Curso");
        jMenuItemConsultaCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultaCursoActionPerformed(evt);
            }
        });
        jMenuConsultas.add(jMenuItemConsultaCurso);

        jMenuItemEdicionCurso.setText("Consultar Edicion Curso");
        jMenuItemEdicionCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEdicionCursoActionPerformed(evt);
            }
        });
        jMenuConsultas.add(jMenuItemEdicionCurso);

        jMenuItemConsultarPrograma.setText("Consultar Programa Formacion");
        jMenuItemConsultarPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultarProgramaActionPerformed(evt);
            }
        });
        jMenuConsultas.add(jMenuItemConsultarPrograma);

        jMenuItem8.setText("jMenuItem8");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenuConsultas.add(jMenuItem8);

        jMenuBar1.add(jMenuConsultas);

        jMenu1.setText("Modificar");

        jMenuItemModificar.setText("Modificar Usuario");
        jMenuItemModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModificarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemModificar);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Escritorio)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemRegistrarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRegistrarClientesActionPerformed
        RegistroUsuario1 RG1 = new RegistroUsuario1();
        Escritorio.add(RG1);
        RG1.setVisible(true);
    }//GEN-LAST:event_jMenuItemRegistrarClientesActionPerformed

    private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItemSalirActionPerformed

    private void jMenuItemConsultaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaUsuarioActionPerformed
        ConsultarUsuarios CU1 = new ConsultarUsuarios();
        Escritorio.add(CU1);
        CU1.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemConsultaUsuarioActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        RegistroInstituto RG2 = new RegistroInstituto();
        Escritorio.add(RG2);
        RG2.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        RegistroCurso RC = new RegistroCurso();
        Escritorio.add(RC);
        RC.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        RegistroEdicionCurso2 rec = new RegistroEdicionCurso2();
        Escritorio.add(rec);
        rec.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItemModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModificarActionPerformed
    ModificarUsuarios CU1 = new ModificarUsuarios();
        Escritorio.add(CU1);
        CU1.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemModificarActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        CargarDatos();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItemConsultaCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultaCursoActionPerformed
      ConsultarCursos CU1 = new ConsultarCursos();
      Escritorio.add(CU1);
      CU1.setVisible(true);        // TODO add your handling code here:    
    // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemConsultaCursoActionPerformed

    private void jMenuItemEdicionCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEdicionCursoActionPerformed
        // TODO add your handling code here:
       ConsultarEdicionCurso CU1 = new ConsultarEdicionCurso();
       Escritorio.add(CU1);
       CU1.setVisible(true);   
        
    }//GEN-LAST:event_jMenuItemEdicionCursoActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        Inscribir RI = new Inscribir();
        Escritorio.add(RI);
        RI.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItemAgregarProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAgregarProgramaActionPerformed
        // TODO add your handling code here:
        RegistrarProgramaFormacion prog = new RegistrarProgramaFormacion(); 
        Escritorio.add(prog);
        prog.setVisible(true);
    }//GEN-LAST:event_jMenuItemAgregarProgramaActionPerformed

    private void jMenuItemAgregarCursoProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAgregarCursoProgramaActionPerformed
        // TODO add your handling code here:
        AgregarCursoProgramaFormacion CurProg = new AgregarCursoProgramaFormacion(); 
        Escritorio.add(CurProg);
        CurProg.setVisible(true);
    }//GEN-LAST:event_jMenuItemAgregarCursoProgramaActionPerformed

    private void jMenuItemInscribirCursoProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInscribirCursoProgramaActionPerformed
        // TODO add your handling code here:
        AgregarCursoProgramaFormacion AgregarCur = new AgregarCursoProgramaFormacion(); 
        Escritorio.add(AgregarCur);
        AgregarCur.setVisible(true);
    }//GEN-LAST:event_jMenuItemInscribirCursoProgramaActionPerformed

    private void jMenuItemRegistrarEstudianteProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRegistrarEstudianteProgramaActionPerformed
        // TODO add your handling code here:
        InscribirEstudianteProgramaFormacion InscCurProg = new InscribirEstudianteProgramaFormacion(); 
        Escritorio.add(InscCurProg);
        InscCurProg.setVisible(true); 
    }//GEN-LAST:event_jMenuItemRegistrarEstudianteProgramaActionPerformed

    private void jMenuItemConsultarProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultarProgramaActionPerformed
        // TODO add your handling code here:
        ConsultarProgramaFormacion ConsProg = new ConsultarProgramaFormacion(); 
        Escritorio.add(ConsProg);
        ConsProg.setVisible(true); 
    }//GEN-LAST:event_jMenuItemConsultarProgramaActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        RegistroCategoria RC = new RegistroCategoria();
        Escritorio.add(RC);
        RC.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        ControladorCurso cc = new ControladorCurso();
        ControladorUsuario cu = new ControladorUsuario();
        //JOptionPane.showMessageDialog(null, cc.buscarEdicionXIns("Innova").size());
        //JOptionPane.showMessageDialog(null, cc.buscarCategorias("").get(0).Getnombre());

        //JOptionPane.showMessageDialog(null, cc.buscarEdiciones("").get(0).getNombre());
        //JOptionPane.showMessageDialog(null, cc.findCurso("programacion").getName());
        //JOptionPane.showMessageDialog(null, cc.buscarEdicionesxCurso("programacion").get(0).getNombre());
        JOptionPane.showMessageDialog(null, cc.findCursoXDocente("ElProfe").getCursos().get(0).getName());
        //JOptionPane.showMessageDialog(null, cc.listarInscripciones("","").get(0).getAlumno().getName());
        //List<inscripcion> ins = cc.listarInscripciones("Eleli", "");
        //JOptionPane.showMessageDialog(null, ins.size());
        //JOptionPane.showMessageDialog(null, ins.get(1).getedicion().getNombre());

    }//GEN-LAST:event_jMenuItem8ActionPerformed

    public void CargarDatos(){
        ControladorUsuario CU = new ControladorUsuario();
        ControladorCurso CC = new ControladorCurso();
        
        List<usuario>datos = CU.buscarusuario("");
        if(!datos.isEmpty()){
            for (usuario tbp : datos){
                if("Eleli".equals(tbp.getNN()) || "Fran123".equals(tbp.getNN()) ||"Furta3".equals(tbp.getNN()) || 
                        "Gonzalius".equals(tbp.getNN()) || "ElProfe".equals(tbp.getNN()) || "LaChina".equals(tbp.getNN()) ||
                        "queCapo".equals(tbp.getNN())){
                    usuarioB = false;
                }
            } 
        }else{
            usuarioB = true;
        }
        
        List<instituto>insititutos = CC.buscarInstituto("");
        if(!insititutos.isEmpty()){
            for (instituto tbp : insititutos){
                if("Innova".equals(tbp.getFacultad()) || "ITSP".equals(tbp.getFacultad()) ||
                        "IFD".equals(tbp.getFacultad()) ){
                    categoriaB = false;
                }
            } 
        }else{
            categoriaB = true;
        }
        
        List<categoria>cate = CC.buscarCategorias("");
        if(!cate.isEmpty()){
            for (categoria tbp : cate){
                if("informatica".equals(tbp.Getnombre()) || "General".equals(tbp.Getnombre()) ){
                    institutoB = false;
                }
            } 
        }else{
            institutoB = true;
        }
        
        List<curso>cur = CC.buscarCurso("");
        if(!cur.isEmpty()){
//            for (curso tbp : cur){
//                if("programacion".equals(tbp.getName()) || "Matematica".equals(tbp.getName()) || "Sebar mates".equals(tbp.getName())){
                    cursoB = false;
//                }
//            } 
        }else{
            cursoB = true;
        }
        
        List<edicionCurso>EdCur = CC.buscarEdiciones("");
        if(!EdCur.isEmpty()){
            for (edicionCurso tbp : EdCur){
                if("PYE".equals(tbp.getNombre()) || "Programacion de aplicaciones 2020".equals(tbp.getNombre()) || 
                        "chispa".equals(tbp.getNombre())){
                     edicionB= false;
                }
            } 
        }else{
            edicionB = true;
        }
        
        Date fechaE = new Date(100,4,5);
        Date fechaF = new Date(110,12,19);
        Date fechaJ = new Date(119,8,25);
        Date fechaG = new Date(118,3,15);
        Date fechaA = new Date(117,8,16);
        Date fechaN = new Date(120,4,22);
        
        if(institutoB ){
            CC.AltaInstituto("Innova");
            CC.AltaInstituto("ITSP");
            CC.AltaInstituto("IFD");
        }
        if(usuarioB){
            CU.altaUsuario("Elias", "user123","Bianchi","Eleli","bianchi@gmail.com", fechaE, false, "pene");
            CU.altaUsuario("Franccesco", "user456","Giordano","Fran123","Giordano@gmail.com", fechaF, false, "pene");
            CU.altaUsuario("Juan", "user123","Furtado","Furta3","Furtado@gmail.com", fechaJ, false, "pene");
            CU.altaUsuario("Gonzalo", "user456","Buriano","Gonzalius","bianchi@gmail.com", fechaG, false, "pene");
            CU.altaUsuario("Alvaro", "user456","Correa","ElProfe","Correa@gmail.com", fechaA, true, "Innova");
            CU.altaUsuario("Nancy", "user123","Lopez","LaChina","LaChina@gmail.com", fechaN, true, "ITSP");
            CU.altaUsuario("Fernando", "user456","Gerfaou","queCapo","queCapo@gmail.com", fechaG, true, "Innova");
            
        }
        if(categoriaB){
            CC.AltaCategoria("informatica");
            CC.AltaCategoria("General");
        }
        
        List<categoria> CatList1 = new ArrayList<>();
        List<categoria> CatList2 = new ArrayList<>();
        
        CatList1.add(CC.cargarCategorias("informatica"));
        CatList1.add(CC.cargarCategorias("General"));
        CatList2.add(CC.cargarCategorias("General"));
        
        
        if(cursoB){            
            CC.AltaCurso("programacion","Innova","programo","prog.com",1,2,fechaE,10, null, "ElProfe", CatList1);
            CC.AltaCurso("Matematica","Innova","matematiqueo","math.com",1,2,fechaA,10, null, "queCapo", CatList2);
            CC.AltaCurso("Sebar mates","ITSP","No acemo na wacho","google.com",1,2,fechaN,10, null, "LaChina", CatList2);
            
        }
        if(edicionB){
            CC.altaEdicion("PYE",fechaA,fechaJ,25,fechaN,"Matematica");
            CC.altaEdicion("Programacion de aplicaciones 2020",fechaA,fechaJ,25,fechaN,"programacion");
            CC.altaEdicion("chispa",fechaA,fechaJ,25,fechaN,"Sebar mates");
                    
            CC.Inscribir("Programacion de aplicaciones 2020", "Eleli", fechaN, "Aceptada",12);
            CC.Inscribir("chispa", "Eleli", fechaN, "Inscripto",10);
            CC.Inscribir("Programacion de aplicaciones 2020", "Fran123", fechaN, "Rechazada",12);
            CC.Inscribir("Programacion de aplicaciones 2020", "Furta3", fechaN, "Aceptada",10);
            CC.Inscribir("PYE", "Fran123", fechaN, "Aceptada",12);
        }
        
        if(usuarioB || institutoB || categoriaB || cursoB || edicionB){
            JOptionPane.showMessageDialog( null, "Todos los datos de prueba ya fueron cargados");
        }else{
            JOptionPane.showMessageDialog( null, "Los datos de prueba fueron agregados correctamente");
        }
    }
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });//Comentario
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane Escritorio;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuConsultas;
    private javax.swing.JMenu jMenuInicio;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItemAgregarCursoPrograma;
    private javax.swing.JMenuItem jMenuItemAgregarPrograma;
    private javax.swing.JMenuItem jMenuItemConsultaCurso;
    private javax.swing.JMenuItem jMenuItemConsultaUsuario;
    private javax.swing.JMenuItem jMenuItemConsultarPrograma;
    private javax.swing.JMenuItem jMenuItemEdicionCurso;
    private javax.swing.JMenuItem jMenuItemInscribirCursoPrograma;
    private javax.swing.JMenuItem jMenuItemModificar;
    private javax.swing.JMenuItem jMenuItemRegistrarClientes;
    private javax.swing.JMenuItem jMenuItemRegistrarEstudiantePrograma;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JMenu jMenuRegistro;
    // End of variables declaration//GEN-END:variables
}
