package Clases;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import javax.transaction.Transactional;

public class ControladorCurso {
    
    public void AltaCurso(String name, String desc, String link, Date duracion, Date cantHoras, Date fecha, int creditos){
        curso cur = new curso(name, desc, link, duracion, cantHoras, fecha, creditos);
    }
    
    public void ConsultaCurso(){
        
    }
    
    public void AltaInstituto(String name){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LaboProgApp");
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<Long> query = em.createQuery(  "SELECT Count(*) FROM instituto WHERE Facultad =:names", Long.class);
        query.setParameter("names", name);
	long total = query.getSingleResult();
        
        if(total == 1){
            String newName =  JOptionPane.showInputDialog("El insitutuo "+name+" ya existe \n Desea modificar el nombre del instituto?");
            
            TypedQuery<Long> queryId = em.createQuery(  "SELECT id FROM instituto WHERE Facultad =:names", Long.class);
            queryId.setParameter("names", name);
            long ides = queryId.getSingleResult();
//            System.out.println("id"+ides);

            try {
                instituto ins = em.find(instituto.class, ides);
                ins.setFacultad(newName);
                
                em.getTransaction().begin();
                em.persist(ins);
                em.getTransaction().commit();
            }catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
            }
            JOptionPane.showMessageDialog( null, "El insituto " +name +" fue modificado correctamente");
            
        }else{
            instituto inst = new instituto();
            inst.setFacultad(name);
            
            JOptionPane.showMessageDialog( null, name +" agregado correctamente");
            
            em.getTransaction().begin();
            em.persist(inst);
            em.getTransaction().commit();
        }
      
        em.close();
    }
    
    
}
