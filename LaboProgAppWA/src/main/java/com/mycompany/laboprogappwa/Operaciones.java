package com.mycompany.laboprogappwa;
//import Clases.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import servidor.Categoria;
import servidor.Curso;
import servidor.Docente;

public class Operaciones {
    /*
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

    public List<categoria> categoria(){
        List<categoria> lista;
        lista = CC.buscarCategorias("");
        return lista;
    }
    */
    public servidor.Curso CursoDeEdCur(String nombreEdCur){
        servidor.Curso cur = null;
        if(!nombreEdCur.isBlank() && BuscarEdicionWS(nombreEdCur)!=null){
            servidor.EdicionCurso edi = BuscarEdicionWS(nombreEdCur);
            if(edi != null)
                cur = edi.getCurso();
        }
        return cur;
    }
    
//    public String insitutoCur(String nomCurso){
//        
//        if(CC.buscarInstideCurso(nomCurso)!=null)
//            return CC.buscarInstideCurso(nomCurso).getFacultad();
//        else
//            return "no existe El instituto";
//    }
    public String insitutoCur(String nomCurso){
        
        try { // Call Web Service Operation
            servidor.WebserverService service = new servidor.WebserverService();
            servidor.Webserver port = service.getWebserverPort();
            // TODO initialize WS operation arguments here
            
            // TODO process result here
            if(port.insitutoCur(nomCurso)!=null)
                return port.insitutoCur(nomCurso);
            else
                return "no existe El instituto";
//            java.lang.String result = port.insitutoCur(arg0);
//            return result;
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            return null;
        }

    }
    
    /*
    public curso BuscarCurso(String nombreCur){
        return CC.findCurso(nombreCur);
    }
    public List<curso> BuscarCursos(String nombreCur){
        return CC.buscarCurso(nombreCur);
    }
    public List<edicionCurso> BuscarEdicionCurso(){
        return CC.buscarEdiciones("");
    }
    */
    
    
//    public List<curso> BuscarCursCate(String cat){
//        return CC.buscarCursoCat(cat);
//    }
    
    
    /*
    public curso findCurso2(String nombredoc){ //busca curso por docente
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        TypedQuery<Long> queryId = em.createQuery("SELECT id FROM curso WHERE doc_nickname LIKE :names", Long.class);
        queryId.setParameter("names", nombredoc);
        long ides = queryId.getSingleResult();
        
        curso cur = em.find(curso.class, ides);
        return cur;
    }

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
    
    public void editIsncripcion(servidor.Inscripcion ins, String estado){
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        em.getTransaction().begin();
   
        ins.setEstado(estado);
        ins=em.merge(ins);
        em.getTransaction().commit();
        em.close();
    }*/


    // VISUALIZAR EDICIONES DE CURSOS PARA PROFESORES
    public servidor.EdicionCurso BuscarEdicionWS(String nombre){
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
    
    public List<servidor.Instituto> insitututosWS(String nombre){
        List<servidor.Instituto> insWS = null;
        
        try { // Call Web Service Operation
            servidor.WebserverService service = new servidor.WebserverService();
            servidor.Webserver port = service.getWebserverPort();
            // TODO process result here
            servidor.DataInstituto result = port.buscarInstituto(nombre);
            insWS = result.getInstitutos();
            return insWS;
        } catch (Exception ex) {
            return null;
        }
    }
    
    public List<servidor.Categoria> categoriaWS(String nombre){
        List<Categoria> cat = null;
        try { // Call Web Service Operation
            servidor.WebserverService service = new servidor.WebserverService();
            servidor.Webserver port = service.getWebserverPort();
            // TODO process result here
            servidor.DataCategoria result = port.buscarCategoria(nombre);
            cat = result.getCategorias();
            return cat;
        } catch (Exception ex) {
            return null;
        }

    }
    
    public Docente findDocenteWS(String nombre){
        try { // Call Web Service Operation
            servidor.WebserverService service = new servidor.WebserverService();
            servidor.Webserver port = service.getWebserverPort();
            // TODO process result here
            servidor.Docente result = port.findDocente(nombre);
            return result;
        } catch (Exception ex) {
            return null;
        }
    }
    
    public int loguearWS(String NN, String pass){
        
        try { // Call Web Service Operation
            servidor.WebserverService service = new servidor.WebserverService();
            servidor.Webserver port = service.getWebserverPort();
            // TODO process result here
            int result = port.logear(NN, pass);
            return result;
        } catch (Exception ex) {
            return 0;
        }
    }
    /*
    public List<servidor.Usuario> findusuWS(String nombre){
        List<servidor.Usuario>usuarios = null;
        try { // Call Web Service Operation
            servidor.WebserverService service = new servidor.WebserverService();
            servidor.Webserver port = service.getWebserverPort();
            // TODO process result here
            servidor.DataUsuario result = port.findusu(nombre);
            usuarios = result.getUsuarios();
            return usuarios;
        } catch (Exception ex) {
            return null;
        }

    }
    */
    public List<servidor.EdicionCurso> buscarEdicionesWS(String nombre){
        List<servidor.EdicionCurso> edWS = null;
        try { // Call Web Service Operation
            servidor.WebserverService service = new servidor.WebserverService();
            servidor.Webserver port = service.getWebserverPort();
            // TODO process result here
            servidor.DataEdiciones result = port.buscarEdiciones(nombre);
            edWS = result.getEdiciones();
            return edWS;
        } catch (Exception ex) {
            return null;
        }
    }
    
    public List<servidor.EdicionCurso> buscarEdicionesXCursoWS(String nombreCur){
        List<servidor.EdicionCurso> edWS = null;
        try { // Call Web Service Operation
            servidor.WebserverService service = new servidor.WebserverService();
            servidor.Webserver port = service.getWebserverPort();
            // TODO process result here
            servidor.DataEdiciones result = port.buscarEdicionesxCurso(nombreCur);
            edWS = result.getEdiciones();
            return edWS;
        } catch (Exception ex) {
            return null;
        }

    }
    
    public servidor.Curso findCursoWS(String nombre){
        
        try { // Call Web Service Operation
            servidor.WebserverService service = new servidor.WebserverService();
            servidor.Webserver port = service.getWebserverPort();
            // TODO process result here
            servidor.Curso result = port.findcurso(nombre);
            return result;
        } catch (Exception ex) {
            return null;
        }

    }
    /*
    public List<servidor.Instituto> institutosWS(){
        List<servidor.Instituto> inslista=null;

        try { 
            servidor.WebserverService service = new servidor.WebserverService();
            servidor.Webserver port = service.getWebserverPort();
            // TODO process result here
            servidor.DataInstituto result = port.institutos();
            System.out.println("Result = "+result);
            inslista=result.getInstitutos();
            return inslista;
        } catch (Exception ex) {
            return null;
        }
    }
    */ 
    public List<servidor.Usuario> buscarusuarioWS(String NN){
        List<servidor.Usuario> usulist=null;

        try { 
            servidor.WebserverService service = new servidor.WebserverService();
            servidor.Webserver port = service.getWebserverPort();
            // TODO process result here
            servidor.DataUsuario result = port.buscarusuario(NN);
            usulist=result.getUsuarios();
            return usulist;
        } catch (Exception ex) {
            return null;
        }
    }

    public  int tipousuarioWS(String NN){
        try { // Call Web Service Operation
            servidor.WebserverService service = new servidor.WebserverService();
            servidor.Webserver port = service.getWebserverPort();
            // TODO process result here
            int result = port.typeusu(NN);
            return result;

        } catch (Exception ex) {
             return 0; 
        }  
    }

    public servidor.Usuario findusupostaWS (String NN){
        try { 
            servidor.WebserverService service = new servidor.WebserverService();
            servidor.Webserver port = service.getWebserverPort();

            servidor.Usuario result = port.findusuconcreto(NN);
            return result;
        } catch (Exception ex) {
            return null;
        }
    }
    
    public List<servidor.Curso> findCursoXDocenteWS(String nombredoc){ //busca curso por docente
        List<servidor.Curso> cur = new ArrayList<>();
        try { // Call Web Service Operation
            servidor.WebserverService service = new servidor.WebserverService();
            servidor.Webserver port = service.getWebserverPort();
            // TODO process result here
            servidor.DataCursos result = port.findCursoXDocente(nombredoc);
            cur = result.getCursos();
            return cur;
        } catch (Exception ex) {
            return null;
        }
    }
    
    public List<servidor.Inscripcion> listarInscripcionesWS(String nombreAlu, String nombreEd){
        List<servidor.Inscripcion> ins;
        try { // Call Web Service Operation
            servidor.WebserverService service = new servidor.WebserverService();
            servidor.Webserver port = service.getWebserverPort();
            // TODO process result here
            servidor.DataInscripcion result = port.listarInscripciones(nombreAlu, nombreEd);
            ins = result.getInscripciones();
            return ins;
        } catch (Exception ex) {
            return null;
        }
    }
    
    public void editIsncripcionWS(servidor.Inscripcion ins, String estado, String nota){
        try { // Call Web Service Operation
            servidor.WebserverService service = new servidor.WebserverService();
            servidor.Webserver port = service.getWebserverPort();
            port.editIsncripcion(ins, estado,nota);
        } catch (Exception ex) {
        }
    }
    
    public void editVigenciaEdicion(servidor.EdicionCurso edcur, boolean vigente){
        
        try { // Call Web Service Operation
            servidor.WebserverService service = new servidor.WebserverService();
            servidor.Webserver port = service.getWebserverPort();
            // TODO initialize WS operation arguments here
            //servidor.EdicionCurso arg0 = new servidor.EdicionCurso();
            //boolean arg1 = false;
            port.editVigenciaEdicion(edcur, vigente);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

    }
    
    public void eliminarInscripcionWS(String nombreEst, String nombreEd){
        servidor.WebserverService service = new servidor.WebserverService();
        servidor.Webserver port = service.getWebserverPort();
        port.elimInscripcion(nombreEst, nombreEd);

    }
    
}
