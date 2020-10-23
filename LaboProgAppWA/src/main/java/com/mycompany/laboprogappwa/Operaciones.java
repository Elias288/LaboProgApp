package com.mycompany.laboprogappwa;
import Clases.*;
import javax.persistence.EntityManager;

public class Operaciones {
    
    ControladorUsuario CU = new ControladorUsuario();
    
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
    
}
