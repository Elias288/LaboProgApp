package servidor;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;
import logica.Logica;

@WebService(serviceName = "Publicador")
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class Publicador {

    private Logica logica = new Logica();
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
    @WebMethod
    public int suma(int i, int j){
        Logica log = new Logica();
        int ret = log.sumar(i,j);
        return ret;
    }

    @WebMethod
    public int restar(int i, int j){
        int ret = logica.restar(i,j);
        return ret;
    }
    
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
}
