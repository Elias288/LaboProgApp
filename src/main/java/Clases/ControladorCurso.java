package Clases;

//import SourcePackage.ConsultarUsuarios;
import SourcePackage.ConsultarCursos;
import java.util.*;
import javax.persistence.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ControladorCurso {
    
    
    public instituto obtenerIsntituto(String name){
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        
        
        TypedQuery<Long> queryId = em.createQuery(  "SELECT id FROM instituto WHERE Facultad =:names", Long.class);
        queryId.setParameter("names", name);
        long ides = queryId.getSingleResult();
        
        instituto ins = em.find(instituto.class, ides);
        return ins;
    }
    
    public docente obtenerDocente(String name){
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        
        
//        TypedQuery<Long> queryId = em.createQuery(  "SELECT nickname FROM docente WHERE nickname =:names", Long.class);
//        queryId.setParameter("names", name);
//        long ides = queryId.getSingleResult();
//        
        docente doc = em.find(docente.class, name);
        return doc;
    }
    
    public void AltaCurso(String name, String instituto, String desc, String link, int duracion, int cantHoras, Date fecha, int creditos, List<curso> CursoList, String docente){
        
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        curso cur = new curso();
        
        instituto ins = obtenerIsntituto(instituto);
        docente doc = obtenerDocente(docente);
        
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
        if(CursoList != null){
            cur.SetPrevias(CursoList);
        }
        cur.SetDocente(doc);
        
        em.getTransaction().begin();
        em.persist(cur);
        em.getTransaction().commit();
        em.close();
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
          
    public static List<curso> buscarCurso(String nombreins){
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        
        List<curso> lista;

        if(nombreins.equals("")){
            Query query = em.createQuery("SELECT xd FROM Usuario xd");

            lista = query.getResultList();
        }
        else{
            //SELECT * FROM curso xd, instituto ins WHERE xd.instituto_id=ins.id AND ins.facultad LIKE :nameins
            Query query = em.createQuery("SELECT xd FROM curso xd JOIN xd.instituto ins WHERE ins.Facultad LIKE :nameins");
            query.setParameter("nameins", nombreins+"%");

            lista = query.getResultList();
            
        }
        return lista;
    }
    
    public  static void listaCurso(JTable tabla,String nombreInstituto){
        DefaultTableModel model;
        String [] titulo = {"Nombre Curso","Descripción","Duración","Creditos","Cantidad Horas"};
        model= new DefaultTableModel(null,titulo);

        List<curso>datos = buscarCurso(nombreInstituto);
        String [] datosusuarios = new String [5];
        for (curso tbp : datos){
            datosusuarios[0]=tbp.getName()+"";
            System.out.println(tbp.getName());
            datosusuarios[1]=tbp.getDesc()+"";
            datosusuarios[2]=tbp.getDuracion()+"";
            datosusuarios[3]=tbp.getCreditos()+"";
            datosusuarios[4]=tbp.getCantHoras()+"";


            //EntityManager em = PersistenceManager.getInstance().createEntityManager();
           // curso cur = em.find(curso.class, tbp.getName());
           
            model.addRow(datosusuarios);

        }
        tabla.setModel(model);
    }
     
    
    
    public static void mostrartabla(String nombres){
        listaCurso(ConsultarCursos.jTable1,nombres);
    } 
}
