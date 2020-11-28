package servidor;

import Clases.ControladorCurso;
import Clases.ControladorUsuario;
import Clases.DataCategoria;
import Clases.edicionCurso;
import Clases.DataCursos;
import Clases.DataEdiciones;
import Clases.DataInscripcion;
import Clases.DataInstituto;
import Clases.DataUsuario;
import Clases.categoria;
import Clases.curso;
import Clases.docente;
import Clases.inscripcion;
import Clases.instituto;
import Clases.usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

 @WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class webserver {
     
    ControladorCurso CC = new ControladorCurso();
    ControladorUsuario CU = new ControladorUsuario();


    private Endpoint endpoint = null;
    //Constructor
    public  webserver(){
     
    }

    @WebMethod(exclude = true)
    public void publicar(){
         endpoint = Endpoint.publish("http://localhost:9128/webservices", this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }

    // Operaciones las cuales quiero publicar
    @WebMethod
    public int obtenerApellido(int dp){
           int l ;
       return 0;
    }
    @WebMethod
    public int obtenerConvocados(String apellido){
        int l ;
       return 0;
    }
    
    @WebMethod
    public int logear(String nickname, String passwd) {
        int ret = CU.loguear(nickname, passwd);
        return ret;
    }
    
    @WebMethod
    public edicionCurso buscarEdicion(String nombre){
        return CC.buscarEdicion(nombre);
    }
    
    @WebMethod
    public DataEdiciones buscarEdiciones(String nombre){
        List<edicionCurso> ed = CC.buscarEdiciones(nombre);
        DataEdiciones Ded = new DataEdiciones();
        Ded.setEdiciones(ed);
        return Ded;
    }
    
    @WebMethod
    public DataEdiciones buscarEdicionesxCurso(String nombreCurso){
        List<edicionCurso> ed = CC.buscarEdicionesxCurso(nombreCurso);
        DataEdiciones Ded = new DataEdiciones();
        Ded.setEdiciones(ed);
        return Ded;
    }
    
    @WebMethod
    public DataUsuario findusu(String nombre){
        DataUsuario DU = new DataUsuario(CU.findusu(nombre));
        return DU;
    }
    
    @WebMethod
    public instituto obtenerIsntituto(String nombre){
        return CC.obtenerIsntituto(nombre);
    }
    
    
    @WebMethod
    public DataCursos buscarCurso(String nombre){
        List<curso> cur = CC.buscarCurso(nombre);
        DataCursos cursos = new DataCursos();
        
        cursos.SetCursos(cur);
        
        return cursos;
    }
    
    @WebMethod
    public curso findcurso(String nombre){
        curso cur = CC.findCurso(nombre);
        return cur;
    }
    
    @WebMethod 
    public DataInstituto buscarInstituto(String nombre){
        List<instituto> ins = CC.buscarInstituto(nombre);
        DataInstituto Dins = new DataInstituto();
        Dins.setInstitutos(ins);
        return Dins;
    }
    
    @WebMethod
    public docente findDocente(String nombre){
        docente doc = CU.findDocente(nombre);
        return doc;
    }
    
    //no funciona ??
    @WebMethod
    public DataCategoria buscarCategoria(String nombre){
        List<categoria> cat = CC.buscarCategorias(nombre);
        DataCategoria Dcat = new DataCategoria();
        Dcat.SetCategorias(cat);
        return Dcat;
    }
    
    @WebMethod
    public DataInstituto institutos(){
        List<instituto> ins = CC.buscarInstituto("");
        DataInstituto ins2 =  new DataInstituto();
        ins2.SetFacultad(ins);
        return ins2;
    }
    
    @WebMethod
    public DataUsuario buscarusuario(String NN){
            
        List<usuario> usulist = CU.buscarusuario(NN);
        DataUsuario usu2 =  new DataUsuario();
        usu2.setUsuarios(usulist);
        return usu2;    
    }
    @WebMethod
    public int typeusu(String NN){
        return CU.tipoUsuario(NN);
    }
        
    @WebMethod
    public usuario findusuconcreto(String NN){
        return  CU.findusu(NN);
    }
    
    @WebMethod
    public DataInscripcion listarInscripciones(String nombreAlu, String nombreEd){
        List<inscripcion> ins = CC.listarInscripciones(nombreAlu, nombreEd);
        DataInscripcion Dins = new DataInscripcion();
        Dins.setInscripciones(ins);
        return Dins;
    }
    
    @WebMethod
    public void editIsncripcion(inscripcion ins, String estado){
        CC.editIsncripcion(ins, estado);
    }
    
    @WebMethod
    public DataCursos findCursoXDocente(String nombredoc){
        return CC.findCursoXDocente(nombredoc);
    }
    
    @WebMethod
    public String insitutoCur (String nomCurso){
        if(CC.buscarInstideCurso(nomCurso) != null)
            return CC.buscarInstideCurso(nomCurso).getFacultad();
        else
            return "no existe El instituto";
    }
          
 }