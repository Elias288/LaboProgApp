package Clases;

//import SourcePackage.ConsultarUsuarios;
import SourcePackage.ConsultarCursos;
import SourcePackage.ConsultarEdicionCurso;
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
        docente doc = em.find(docente.class, name);
        return doc;
    }
    
    public void AltaCategoria(String nombre){
        EntityManager em = PersistenceManager.getInstance().createEntityManager();

        List<categoria>insititutos = buscarCategorias(nombre);
        
        if(insititutos.size() == 1){
            String newName =  JOptionPane.showInputDialog("La categoria "+nombre+" ya existe \n Desea modificar el nombre de la categoria?");
            
            if(!newName.isBlank()){
                TypedQuery<Long> queryId = em.createQuery(  "SELECT id FROM categoria WHERE nombre =:names", Long.class);
                queryId.setParameter("names", nombre);
                long ides = queryId.getSingleResult();

                try {
                    categoria ins = em.find(categoria.class, ides);
                    ins.Setnombre(newName);

                    em.getTransaction().begin();
                    em.persist(ins);
                    em.getTransaction().commit();
                    em.close();
                }catch (Exception e) {
                    e.printStackTrace();
                    em.getTransaction().rollback();
                    em.close();
                }
                JOptionPane.showMessageDialog( null, "La Categoria " +nombre +" fue modificado correctamente");
            }
        }else{
            categoria categ = new categoria();
            categ.Setnombre(nombre);
            
            
            em.getTransaction().begin();
            em.persist(categ);
            em.getTransaction().commit();
            em.close();
        }
      
        em.close();
    }
    
    public void AltaCurso(String name, String instituto, String desc, String link, int duracion, int cantHoras, Date fecha, int creditos, List<curso> CursoList, String docente, 
            List<categoria> cate){
        
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        curso cur = new curso();
        
        instituto ins = obtenerIsntituto(instituto);
        docente doc = obtenerDocente(docente);
        
        cur.setFecha(fecha);
        cur.SetCreditos(creditos);
        cur.SetURL(link);
        cur.SetName(name);
        cur.SetDuracion(duracion);
        cur.SetDescripcion(desc);
        cur.SetCantH(cantHoras);
        cur.SetInstituto(ins);
        if(cate != null){
            cur.SetCategoria(cate);
        }
        if(CursoList != null){
            cur.SetPrevias(CursoList);
        }
        cur.SetDocente(doc);
        
        em.getTransaction().begin();
        em.persist(cur);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<instituto> buscarInstituto(String Facultad){
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        
        List<instituto>lista;

        if(Facultad.equals("")){
            Query query = em.createQuery("SELECT xd FROM instituto xd");
            lista = query.getResultList();
        }
        else{
            Query query = em.createQuery("SELECT xd FROM instituto xd WHERE xd.Facultad LIKE :nickname");
            query.setParameter("nickname", Facultad+"%");

            lista = query.getResultList();
            
        }
        return lista;
    }
    
    public List<categoria> buscarCategorias(String nombre){
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        
        List<categoria>lista;

        if(nombre.equals("")){
            Query query = em.createQuery("SELECT xd FROM categoria xd");
            lista = query.getResultList();
        }
        else{
            Query query = em.createQuery("SELECT xd FROM categoria xd WHERE xd.nombre LIKE :nickname");
            query.setParameter("nickname", nombre+"%");

            lista = query.getResultList();
            
        }
        return lista;
    }
    public categoria buscarCategoria(String nombre){
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        return em.find(categoria.class,nombre);
    }
    
    public void AltaInstituto(String name){
        EntityManager em = PersistenceManager.getInstance().createEntityManager();

        List<instituto>insititutos = buscarInstituto(name);
        
        if(insititutos.size() == 1){
            String newName =  JOptionPane.showInputDialog("El insitutuo "+name+" ya existe \n Desea modificar el nombre del instituto?");
            
            if(!newName.isBlank()){
                TypedQuery<Long> queryId = em.createQuery(  "SELECT id FROM instituto WHERE Facultad =:names", Long.class);
                queryId.setParameter("names", name);
                long ides = queryId.getSingleResult();

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
            }
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
          
    public List<curso> buscarCurso(String nombreins){
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
    
    public void listaCurso(JTable tabla,String nombreInstituto){
        DefaultTableModel model;
        String [] titulo = {"Nombre Curso","Descripción","Duración","Creditos","Cantidad Horas"};
        model= new DefaultTableModel(null,titulo);

        List<curso>datos = buscarCurso(nombreInstituto);
        String [] datosusuarios = new String [5];
        for (curso tbp : datos){
            datosusuarios[0]=tbp.getName()+"";
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
     
    public void mostrartabla(String nombres){
        listaCurso(ConsultarCursos.jTable1,nombres);
    } 
    
    public static List<edicionCurso> buscarEdicionCurso(String NN){
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        
        List<edicionCurso>lista;

        if(NN.equals("")){
            Query query = em.createQuery("SELECT xd FROM edicionCurso xd");

            lista = query.getResultList();
        }
        else{
            Query query = em.createQuery("SELECT xd FROM edicionCurso xd JOIN xd.Curso ins WHERE ins.nombre LIKE :nameins");
            query.setParameter("nameins", NN+"%");

            lista = query.getResultList();
            
        }
        return lista;
    }
    
    public void listaEdicionCurso(JTable tabla,String nickname){
        DefaultTableModel model;
        String [] titulo = {"Nombre","Cupo","Fecha publicacion","Inicio periodo","Fin de periodo","Curso",};
        model= new DefaultTableModel(null,titulo);

        List<edicionCurso>datos = buscarEdicionCurso(nickname);
        String [] datosusuarios = new String [6];
        for (edicionCurso tbp : datos){
            datosusuarios[0]=tbp.getNombre()+"";
            datosusuarios[1]=tbp.getCupo()+"";
            datosusuarios[2]=tbp.getFechaPublicacion()+"";
            datosusuarios[3]=tbp.getPinicio()+"";
            datosusuarios[4]=tbp.getPfin()+"";
            datosusuarios[5]=tbp.getCurso()+"";
            
            model.addRow(datosusuarios);

        }
        tabla.setModel(model);
    }
    
    public void ModificarUsuario(){
        
    }
   
    public void mostrartabla2(String nombres){
        listaEdicionCurso(ConsultarEdicionCurso.jTableEdicionCurso,nombres);
    }     
    
    public void Inscribir(String edicion, String alumno, Date fech){
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        
        em.getTransaction().begin();
        edicionCurso Curs = buscarEdicion(edicion);
      //  em.persist(Curs);
        
        alumno Alu = buscarAlumno(alumno);
        inscripcion ins=new inscripcion(Curs,Alu,fech);

        
       em.persist(ins);
        
        em.getTransaction().commit();
        em.close();
    }
    
    public edicionCurso buscarEdicion(String nombre){
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        return em.find(edicionCurso.class,nombre);
    }
    public List<edicionCurso> buscarEdiciones(String nombre){
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        
        List<edicionCurso>lista;

        if(nombre.equals("")){
            Query query = em.createQuery("SELECT xd FROM edicionCurso xd");
            lista = query.getResultList();
        }
        else{
            Query query = em.createQuery("SELECT xd FROM edicionCurso xd WHERE xd.nombre LIKE :nickname");
            query.setParameter("nickname", nombre+"%");

            lista = query.getResultList();
            
        }
        return lista;
    }
    
    public alumno buscarAlumno(String nombre){
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        return em.find(alumno.class,nombre);
    }
    
}