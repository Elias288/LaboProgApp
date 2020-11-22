/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;


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
/**
 *
 * @author franc
 */
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

 
  
}
