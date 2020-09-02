package Clases;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class ControladorUsuario {
    
    public void altaUsuario(String name, String LastName, String NN, String Email, java.util.Date date, Boolean tipo, String Instituto){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LaboProgApp");
        EntityManager em = emf.createEntityManager();
        if(!tipo){
            alumno usu = new alumno(name, LastName, NN, Email, date);
            JOptionPane.showMessageDialog( null, "Usuario "+usu.getNN()+"\nAgregado Correctamente");
            //JOptionPane.showMessageDialog( null, usu.getNN()+ " " + usu.getName()+ " " +usu.getLastName());
            em.getTransaction().begin();
            em.persist(usu);
            em.getTransaction().commit();
        }else{
            docente usu = new docente(name, LastName, NN, Email, date, Instituto);
            JOptionPane.showMessageDialog( null, "Usuario "+usu.getNN()+"\nAgregado Correctamente");
            em.getTransaction().begin();
            em.persist(usu);
            em.getTransaction().commit();
        }
        
    }
    
    
    public void ConsultaUsuario(){
        
    }
    public void ModificarUsuario(){
        
    }
}
