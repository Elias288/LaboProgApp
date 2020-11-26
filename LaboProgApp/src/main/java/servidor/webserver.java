package servidor;

import Clases.ControladorCurso;
import Clases.ControladorUsuario;
import Clases.edicionCurso;
import Clases.DataCursos;
import Clases.usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
        ControladorUsuario CU2 = new ControladorUsuario();
        int ret = CU2.loguear(nickname, passwd);
        return ret;
    }
    
    @WebMethod
    public edicionCurso buscarEdicion(String nombre){
        ControladorCurso cu = new ControladorCurso();
        return cu.buscarEdicion(nombre);
    }
    
    @WebMethod
    public DataCursos buscarCurso(String nombre){
        ControladorCurso cu = new ControladorCurso();
        DataCursos cursos = new DataCursos();
        cursos.SetCursos(cu.buscarCurso(nombre));
        return cursos;
    }
 
    @WebMethod
    public usuario findusu(String nombre){
        ControladorUsuario CU = new ControladorUsuario();
        return CU.findusu(nombre);
    }
}
