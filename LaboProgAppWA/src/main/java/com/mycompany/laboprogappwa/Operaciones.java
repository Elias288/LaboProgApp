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
    
    public curso CursoDeEdCur(String nombreEdCur){
        curso cur = null;
        if(!nombreEdCur.isBlank() && CC.buscarEdicion(nombreEdCur)!=null){
            edicionCurso edi = CC.buscarEdicion(nombreEdCur);
            if(edi != null)
                cur = edi.getCurso();
        }
        return cur;
    }
    
    public String insitutoCur(String nomCurso){
        
        if(CC.buscarInstideCurso(nomCurso)!=null)
            return CC.buscarInstideCurso(nomCurso).getFacultad();
        else
            return "no existe El instituto";
    }
    
    public curso BuscarCurso(String nombreCur){
        return CC.findCurso(nombreCur);
    }
    public List<edicionCurso> BuscarEdicionCurso(){
        return CC.buscarEdiciones("");
    }
}
