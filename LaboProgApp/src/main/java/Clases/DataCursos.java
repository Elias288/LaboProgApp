package Clases;

import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataCursos {
    private long id;
    protected String nombre;
    protected String descripcion, URL;
    protected int duracion;
    protected int cantHoras;
    protected Date fecha;
    protected int Creditos;
    protected List<categoria> cat;
    protected List<curso> Previas;
    protected docente doc;
    protected instituto instituto;
    
    private List<curso> cursos = null;
    
    public DataCursos(){}
    
    public String getName(){return this.nombre;}
    public String getDesc(){return this.descripcion;}
    public String getURL(){return this.URL;}
    public int getDuracion(){return this.duracion;}
    public int getCreditos(){return this.Creditos;}
    public int getCantHoras(){return this.cantHoras;}
    public docente getDocente(){return this.doc;}
    public List<curso> getPrevias(){return this.Previas;}
    public long getId(){return this.id;}
    public instituto getInsti(){return this.instituto;}
    public List<categoria> getCategorias(){return this.cat;}
    public void SetName(String name){this.nombre = name;}
    public void SetDocente(docente doce){this.doc = doce;}
    public void SetDescripcion(String desc){this.descripcion = desc;}
    public void SetURL(String url){this.URL = url;}
    public void SetCantH(int cant){this.cantHoras =cant;}
    public void SetDuracion(int dura){this.duracion=dura;}
    public void setFecha(Date fech){this.fecha = fech;}
    public void SetCreditos(int cred){this.Creditos= cred;}
    public void SetInstituto(instituto ins){this.instituto=ins;}
    public void SetPrevias(List<curso> prev){this.Previas = prev;}
    public void SetCategoria(List<categoria> cat){this.cat = cat;}
    
    public void SetCursos(List<curso> cur){this.cursos= cur;}
    public List<curso> getCursos(){return this.cursos;}
}
