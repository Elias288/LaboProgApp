package com.mycompany.laboprogappwa;
import Clases.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class Operaciones {
    
    ControladorUsuario CU = new ControladorUsuario();
    ControladorCurso CC = new ControladorCurso();
    
    public int loguear(String usuario, String passwd){
        usuario usu = CU.findusu(usuario);
        int tipo=0;
        
        if(usu != null){
            if(CU.findPass(usu, passwd)){
                tipo = CU.tipoUsuario(usu.getNN());
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
      
      public List<inscripcion> listinscrip (String nombrealumno){
     EntityManager em = PersistenceManager.getInstance().createEntityManager();
        
        List<inscripcion> lista;

        if(nombrealumno.equals("")){
            Query query = em.createQuery("SELECT xd FROM curso xd");

            lista = query.getResultList();
        }
        else{
            //SELECT * FROM curso xd, instituto ins WHERE xd.instituto_id=ins.id AND ins.facultad LIKE :nameins
            Query query = em.createQuery("SELECT xd FROM inscripcion xd WHERE xd.Alu LIKE :nameins");
            query.setParameter("nameins", nombrealumno+"%");

            lista = query.getResultList();
        }
        return lista;
    }
}