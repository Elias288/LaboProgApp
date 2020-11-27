package com.mycompany.laboprogappwa;
import Clases.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import servidor.Curso;

public class Operaciones {
    
    ControladorUsuario CU = new ControladorUsuario();
    ControladorCurso CC = new ControladorCurso();
    
    public int loguear(String usuario, String passwd){
        usuario usu = CU.findusu(usuario);
        int tipo=0;
        if(usu.getNN().equals(usuario)){
        
            if(usu != null){
                if(CU.findPass(usu, passwd)){
                    tipo = CU.tipoUsuario(usu.getNN());
                }
            }
        }
        
        
        return tipo;
    }
    
    public List<instituto> institutos(){
        return CC.buscarInstituto("");
    }
    
    public List<categoria> categoria(){
        List<categoria> lista;
        lista = CC.buscarCategorias("");
        return lista;
    }
    
    public curso CursoDeEdCur(String nombreEdCur){
        curso cur = null;
        if(!nombreEdCur.isBlank() && CC.buscarEdicion(nombreEdCur)!=null){
            edicionCurso edi = CC.buscarEdicion(nombreEdCur);
            if(edi != null)
                cur = edi.getCurso();
        }
        return cur;
    }
    
    public String insitutoCur(String nomCurso){
        
        if(CC.buscarInstideCurso(nomCurso)!=null)
            return CC.buscarInstideCurso(nomCurso).getFacultad();
        else
            return "no existe El instituto";
    }
    
    public curso BuscarCurso(String nombreCur){
        return CC.findCurso(nombreCur);
    }
    public List<curso> BuscarCursos(String nombreCur){
        return CC.buscarCurso(nombreCur);
    }
    public List<edicionCurso> BuscarEdicionCurso(){
        return CC.buscarEdiciones("");
    }
    public List<curso> BuscarCursCate(String cat){
        return CC.buscarCursoCat(cat);
    }
    
      public curso findCurso2(String nombredoc){
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        TypedQuery<Long> queryId = em.createQuery("SELECT id FROM curso WHERE doc_nickname LIKE :names", Long.class);
        queryId.setParameter("names", nombredoc);
        long ides = queryId.getSingleResult();
        
        curso cur = em.find(curso.class, ides);
        return cur;
    }
    /*
    public List<inscripcion> listarInscripciones(){
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        List<inscripcion>lista=new ArrayList<>();
        
        Query query = em.createQuery("SELECT xd FROM inscripcion xd");
        lista = query.getResultList();
        return lista;
    }
    */
    public List<inscripcion> listarInscripciones(String nombreAlu, String nombreEd){
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        List<inscripcion>lista=new ArrayList<>();
        List<inscripcion>lista2=new ArrayList<>();
        Query query = em.createQuery("SELECT xd FROM inscripcion xd");
        lista = query.getResultList();
        
        if(!nombreAlu.equals("") && !nombreEd.equals("")){
            Iterator iter = lista.iterator();
            while(iter.hasNext()){
                inscripcion ins = (inscripcion)iter.next();
                if(ins.getedicion().getNombre().equals(nombreEd) && ins.getAlumno().getName().equals(nombreAlu)){
                    lista2.add(ins);
                }
            }
            return lista2;
        }else if(nombreAlu.equals("") && !nombreEd.equals("")){
            Iterator iter = lista.iterator();
            while(iter.hasNext()){
                inscripcion ins = (inscripcion)iter.next();
                if(ins.getedicion().getNombre().equals(nombreEd)){
                    lista2.add(ins);
                }
            }
            return lista2;
        }
        return lista;
    }
    
    public void editIsncripcion(inscripcion ins, String estado){
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        em.getTransaction().begin();
   
        ins.setEstado(estado);
        ins=em.merge(ins);
        em.getTransaction().commit();
        em.close();
    }


    // VISUALIZAR EDICIONES DE CURSOS PARA PROFESORES
    public servidor.EdicionCurso BuscarEdicion(String nombre){
        servidor.EdicionCurso result = new servidor.EdicionCurso();
        try { // Call Web Service Operation
            servidor.WebserverService service = new servidor.WebserverService();
            servidor.Webserver port = service.getWebserverPort();
            // TODO process result here
            result = port.buscarEdicion(nombre);
            return result;
            } 
        catch (Exception ex) {
            return null;

        }
      
    }
    
    
    public List<Curso> BuscarCursosWS(String nombreCur){
        List<Curso> cur = null;
        try { // Call Web Service Operation
            servidor.WebserverService service = new servidor.WebserverService();
            servidor.Webserver port = service.getWebserverPort();
            // TODO process result here
            servidor.DataCursos result = port.buscarCurso(nombreCur);
            
            cur = result.getCursos();
            
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        
        return cur;
    }
}
