package com.mycompany.laboprogappwa;
import Clases.*;
import java.util.List;
import javax.persistence.EntityManager;

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
        List<instituto>lista;
        lista = CC.buscarInstituto("");
        return lista;
    }
    
    public List<categoria> categoria(){
        List<categoria> lista;
        lista = CC.buscarCategorias("");
        return lista;
    }
    
}
