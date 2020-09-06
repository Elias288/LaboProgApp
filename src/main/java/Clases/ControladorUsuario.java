package Clases;

import SourcePackage.ConsultarUsuarios;
import SourcePackage.ModificarUsuarios;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorUsuario {
    
    public void altaUsuario(String name, String LastName, String NN, String Email, java.util.Date date, Boolean tipo, String instituto){
        
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        
        usuario usu;
        
        TypedQuery<Long> queryId = em.createQuery(  "SELECT id FROM instituto WHERE Facultad =:names", Long.class);
        queryId.setParameter("names", instituto);
        long ides = queryId.getSingleResult();
        
        instituto ins = em.find(instituto.class, ides);
        
        System.out.println(ins.getFacultad());
        System.out.println(ins.getId());
        
        if(!tipo){
            usu = new alumno(name, LastName, NN, Email, date);
        }else{
            usu = new docente(name, LastName, NN, Email, date, ins);
        }
        JOptionPane.showMessageDialog( null, "Usuario "+usu.getNN()+"\nAgregado Correctamente");
        em.getTransaction().begin();
        em.persist(usu);
        em.getTransaction().commit();
        em.close();
        
    }
    
    
    public static List<usuario> buscarusuario(String NN){
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
    
public  static void listausuarios(JTable tabla,String nickname){
    DefaultTableModel model;
    String [] titulo = {"Nickname","fecha nacimiento","Apellido","Correo","Nombre","Instituto"};
    model= new DefaultTableModel(null,titulo);
     
    List<usuario>datos = buscarusuario(nickname);
    String [] datosusuarios = new String [7];
    for (usuario tbp : datos){
        datosusuarios[0]=tbp.getNN()+"";
        datosusuarios[1]=tbp.getDate()+"";
        datosusuarios[2]=tbp.getLastName()+"";
        datosusuarios[3]=tbp.getEmail()+"";
        datosusuarios[4]=tbp.getName()+"";
         
      
         EntityManager em = PersistenceManager.getInstance().createEntityManager();
            docente doc=em.find(docente.class,tbp.getNN());
           if (doc==null){
               datosusuarios[5]="null";
           //System.out.println("SOY DOCENTE CAPOOOOOOOOOOOOOOOOOOOOOOOOOOO");
           }else{
            System.out.println(nickname);
            System.out.println(doc.getInstituto().getFacultad());
            String hola;
            
            hola=doc.getInstituto().getFacultad()+"";
            datosusuarios[5]=hola;
    }
//         datosusuarios[5]=tbp.getTipoUsuario()+"";
         model.addRow(datosusuarios);
         
     }
     tabla.setModel(model);
    }
    
    public void ModificarUsuario(){
        
    }
   
    public static void mostrartabla(String nombres){
        listausuarios(ConsultarUsuarios.jTable1,nombres);
    }   
      public static void mostrartabla2(String nombres){
        listausuarios(ModificarUsuarios.jTable1,nombres);
    }
      
      public static void ModUsu(String name, String LastName, String NN, Boolean tipo, String instituto){
        
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        
   /* usuario usu=null;
        
      
       // if(!tipo){
            usu = new alumno();
            usu.setName(name);
            usu.setLN(LastName);*/
           // usu.setNN(NN);
       // }else{
           // usu = new docente(name, LastName, NN, date, ins);
     //   }
    //  JOptionPane.showMessageDialog( null, "Usuario "+usu.getNN()+"\nModificado Correctamente");
        em.getTransaction().begin();
        
       usuario usu2= findusu(NN);
   
            usu2.setName(name);
            usu2.setLN(LastName);
   //    System.out.println("usuario original nn: "+usu2.getNN());
    //    System.out.println("usuario trucho NN: "+usu.getNN());
    //    System.out.println("usuario trucho Name: "+usu.getName());
            usu2=em.merge(usu2);
       //      System.out.println("usuario trucho NN: "+usu.getNN());
       //       System.out.println("usu original nombre: "+usu2.getName());
            //   System.out.println("usuario trucho NN: "+usu.getNN());
        em.getTransaction().commit();
        em.close();
        
    }
      
      public static usuario findusu(String ID){
           EntityManager em = PersistenceManager.getInstance().createEntityManager();
         
          try{
              return em.find(usuario.class,ID);
          }finally{
              em.close();
          }
          

} 
}
