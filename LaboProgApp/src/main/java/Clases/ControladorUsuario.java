package Clases;

import SourcePackage.ConsultarUsuarios;

import SourcePackage.ModificarUsuarios;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorUsuario {
    
    public void altaUsuario(String name, String passwd, String LastName, String NN, String Email, java.util.Date date, Boolean tipo, String instituto){
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        ControladorUsuario CU = new ControladorUsuario();
        usuario usu;
        
        if(!tipo){
            usu = new alumno(name, passwd, LastName, NN, Email, date);
        }else{
            TypedQuery<Long> queryId = em.createQuery(  "SELECT id FROM instituto WHERE Facultad =:names", Long.class);
            queryId.setParameter("names", instituto);
            long ides = queryId.getSingleResult();

            instituto ins = em.find(instituto.class, ides);
            usu = new docente(name, passwd, LastName, NN, Email, date, ins);
        }
        
        
//        JOptionPane.showMessageDialog( null, "Usuario "+usu.getNN()+"\nAgregado Correctamente");
        em.getTransaction().begin();
        em.persist(usu);
        em.getTransaction().commit();
        em.close();
        
    }
     
    public List<usuario> buscarusuario(String NN){
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        
        List<usuario>lista;

        if(NN.equals("")){
            Query query = em.createQuery("SELECT xd FROM Usuario xd");

            lista = query.getResultList();
        }
        else{
            Query query = em.createQuery("SELECT xd FROM Usuario xd WHERE xd.nickname LIKE :nickname");
            query.setParameter("nickname", NN+"%");

            lista = query.getResultList();
            
        }
        return lista;
    }
    
    public void listausuarios(JTable tabla,String nickname){
        DefaultTableModel model;
        String [] titulo = {"Nickname","Nombre","Apellido"/*,"fecha nacimiento","Correo","Instituto"*/};
        model= new DefaultTableModel(null,titulo);
        curso curs=null;
        List<usuario>datos = buscarusuario(nickname);
        String [] datosusuarios = new String                   [7];
        for (usuario tbp : datos){
            
            datosusuarios[0]=tbp.getNN()+"";
            datosusuarios[1]=tbp.getName()+"";
            datosusuarios[2]=tbp.getLastName()+"";

            model.addRow(datosusuarios);

        }
        tabla.setModel(model);
    }
   
    public void mostrartabla(String nombres){listausuarios(ConsultarUsuarios.jTable1,nombres);}   
    
    public void mostrartabla2(String nombres){listausuarios(ModificarUsuarios.jTable1,nombres);}
    
    public static curso devolercurso(usuario alumn){
        String nombreal=alumn.getNN();
        EntityManager em = PersistenceManager.getInstance().createEntityManager();

        TypedQuery<Long> queryId = em.createQuery( "SELECT EdicionCurso FROM inscripcion xd WHERE xd.Alu =:nombreal", Long.class);
        queryId.setParameter("nombreal", nombreal);
        long ides = queryId.getSingleResult();

        edicionCurso EdC = em.find(edicionCurso.class, ides);
        curso cur = em.find(curso.class, EdC.getCurso().getId());
       
        return cur;
    }
    
    public void ModUsu(String name, String LastName, String NN, Boolean tipo, String instituto){
        
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        em.getTransaction().begin();
        
        usuario usu2= findusu(NN);
   
        usu2.setName(name);
        usu2.setLN(LastName);
        usu2=em.merge(usu2);
        em.getTransaction().commit();
        em.close();
    }
    
    public usuario findusu(String ID){
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
         
        try{
            return em.find(usuario.class,ID);
        }finally{
            em.close();
        }
    }
    
    public boolean findPass(usuario usu, String pass){
        if(usu.getPass().equals(pass)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean verFecha(Date fecha){
        Date now = new Date();
        if(fecha.compareTo(now) >= 0) {
          return false;
        }
        else{
          return true;
        }
    }
    
    public int tipoUsuario(String NN){
        int tipo=0;
        
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        docente doc=em.find(docente.class,NN);

        if (doc!=null)
            tipo = 1; //el usuario es docente
        else
            tipo = 2; //el usuario es alumno
            
        return tipo;
    }
}
