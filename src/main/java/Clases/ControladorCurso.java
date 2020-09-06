package Clases;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

public class ControladorCurso {
    
    public void AltaCurso(String name, String instituto, String desc, String link, int duracion, int cantHoras, Date fecha, int creditos){
        
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        
        curso cur = new curso();
        
        TypedQuery<Long> queryId = em.createQuery(  "SELECT id FROM instituto WHERE Facultad =:names", Long.class);
        queryId.setParameter("names", instituto);
        long ides = queryId.getSingleResult();
        
        instituto ins = em.find(instituto.class, ides);
        
//        System.out.println(ins.getFacultad());
//        System.out.println(ins.getId());
        
        cur.setFecha(fecha);
        cur.SetCreditos(creditos);
        cur.SetURL(link);
        cur.SetName(name);
        cur.SetDuracion(duracion);
        cur.SetDescripcion(desc);
        cur.SetCantH(cantHoras);
        cur.SetInstituto(ins);
        
        em.getTransaction().begin();
        em.persist(cur);
        em.getTransaction().commit();
        em.close();
        
        JOptionPane.showMessageDialog( null, "Curso "+cur.getName()+"\nAgregado Correctamente");
    }
    
    public void ConsultaCurso(){
        
    }
    
    public void AltaInstituto(String name){
        
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        
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
                em.close();
            }catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
                em.close();
            }
            JOptionPane.showMessageDialog( null, "El insituto " +name +" fue modificado correctamente");
            
        }else{
            instituto inst = new instituto();
            inst.setFacultad(name);
            
//            JOptionPane.showMessageDialog( null, name +" agregado correctamente");
            
            em.getTransaction().begin();
            em.persist(inst);
            em.getTransaction().commit();
            em.close();
        }
      
        em.close();
    }
    
    public void altaEdicion(String nombre, Date PInicio, Date PFin, int cupos, Date fechaPublicacion, String Curso){
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        
        TypedQuery<Long> queryId = em.createQuery(  "SELECT id FROM curso WHERE nombre =:names", Long.class);
        queryId.setParameter("names", Curso);
        long ides = queryId.getSingleResult();
        
        curso cur = em.find(curso.class, ides);
        
        try {
            edicionCurso edCurso = new edicionCurso(nombre, PInicio, PFin, cupos,fechaPublicacion, cur);
            em.getTransaction().begin();
            em.persist(edCurso);
            em.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
}
