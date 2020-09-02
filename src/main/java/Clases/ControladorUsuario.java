package Clases;

import SourcePackage.ConsultarUsuarios;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorUsuario {
    
    public void altaUsuario(String name, String LastName, String NN, String Email, java.util.Date date, Boolean tipo, String Instituto){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LaboProgApp");
        EntityManager em = emf.createEntityManager();
        
        usuario usu;
        
        if(!tipo){
            usu = new alumno(name, LastName, NN, Email, date);
        }else{
            usu = new docente(name, LastName, NN, Email, date, Instituto);
        }
        JOptionPane.showMessageDialog( null, "Usuario "+usu.getNN()+"\nAgregado Correctamente");
        em.getTransaction().begin();
        em.persist(usu);
        em.getTransaction().commit();
        em.close();
        
    }
    
    
    public static List<usuario> buscarusuario(String NN){
        usuario usu;
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("LaboProgApp");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT * FROM usuario u WHERE u.nickname LIKE '"+NN+"%'");
        query.setParameter("nikcname", NN+"%");
        List<usuario>lista = query.getResultList();
        return lista;
    }
    
    public  static void listausuarios(JTable tabla,String nickname){
     DefaultTableModel model;
     String [] titulo = {"nickname","fecha nacimiento","Apellido","correo","nombre"};
     model= new DefaultTableModel(null,titulo);
     
     List<usuario>datos = buscarusuario(nickname);
     String [] datosusuarios = new String [5];
     for (usuario tbp : datos){
         datosusuarios[0]=tbp.getNN()+"";
         datosusuarios[1]=tbp.getDate()+"";
         datosusuarios[2]=tbp.getLastName()+"";
         datosusuarios[3]=tbp.getEmail()+"";
         datosusuarios[4]=tbp.getName()+"";
         
         
     }
     tabla.setModel(model);
    }
    public void ModificarUsuario(){
        
    }
   
          public static void mostrartabla(String nombres){
    listausuarios(ConsultarUsuarios.jTable1,nombres);
    }   
}
