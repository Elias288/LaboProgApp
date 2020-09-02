package Clases;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ControladorCurso {
    
    public void AltaCurso(String name, String desc, String link, Date duracion, Date cantHoras, Date fecha, int creditos){
        curso cur = new curso(name, desc, link, duracion, cantHoras, fecha, creditos);
    }
    
    public void ConsultaCurso(){
        
    }
    
    public void AltaInstituto(String name){
//        instituto ins = new instituto();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LaboProgApp");
        EntityManager em = emf.createEntityManager();
        
        String jpql = "SELECT * FROM instituto WHERE Facultad = "+ name;
        
        Query query = em.createQuery(jpql); 
        instituto ins = (instituto) query.getSingleResult();
        
        System.out.println(ins.getFacultad());
    }
    
    
}
