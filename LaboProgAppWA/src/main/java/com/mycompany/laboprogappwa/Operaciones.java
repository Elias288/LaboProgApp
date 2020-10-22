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
                
                EntityManager em = PersistenceManager.getInstance().createEntityManager();
                docente doc=em.find(docente.class,usu.getNN());
                
                if (doc!=null)
                    tipo = 1; //el usuario es docente
                else
                    tipo = 2; //el usuario es alumno
            }
        }
        
        return tipo;
    }
    
}
