package com.mycompany.laboprogappwa;
import Clases.*;
import java.util.List;

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
    
    public String CursoDeEdCur(String nombreEdCur){
        curso cur = null;
        if(!nombreEdCur.isBlank() && CC.buscarEdicion(nombreEdCur)!=null){
            edicionCurso edi = CC.buscarEdicion(nombreEdCur);
            if(edi != null)
            cur = edi.getCurso();
            return cur.getName();
        }else
            return "no existe la edicion Curso";
    }
    
    public String insitutoCur(String nombreCur){
        curso curs = null;
        instituto ins = null;
        if (!nombreCur.isBlank() && CC.findCurso(nombreCur)!= null){
            curs = CC.findCurso(nombreCur);
            ins = curs.getInsti();
            return ins.getFacultad();
        }else
            return "no existe Instituto";
    }
    
}
