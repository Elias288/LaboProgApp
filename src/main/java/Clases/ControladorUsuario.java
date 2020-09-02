package Clases;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

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
    
    
    public void ConsultaUsuario(){
        
    }
    public void ModificarUsuario(){
        
    }
}
