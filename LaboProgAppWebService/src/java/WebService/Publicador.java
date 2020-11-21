package WebService;

import Clases.ControladorCurso;
import Clases.ControladorUsuario;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.Endpoint;

@WebService(serviceName = "Publicador")
public class Publicador {

    private ControladorCurso CC = new ControladorCurso();
    private ControladorUsuario CU = new ControladorUsuario();
    private Endpoint endpoint = null;
    
    //Constructor
    public Publicador(){}
    
    @WebMethod(exclude = true)
    public void publicar(){
         endpoint = Endpoint.publish("http://localhost:9129/publicador", this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
    
    //Operaciones las cuales quiero publicar
    
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod
    public int logear(String nickname, String passwd) {
        ControladorUsuario CU2 = new ControladorUsuario();
        int ret = CU2.loguear(nickname, passwd);
        return ret;
    }
}
