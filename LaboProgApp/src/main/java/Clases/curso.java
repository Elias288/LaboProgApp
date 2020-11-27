package Clases;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Entity
@Table( name="Curso" )
@XmlAccessorType(XmlAccessType.FIELD)
public class curso implements Serializable{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String descripcion, URL;
    private int duracion;
    private int cantHoras;
    private Date fecha;
    private int Creditos;
    
    @ManyToMany
    private List<categoria> cat;
    
    @ManyToMany
    private List<curso> Previas;
    
    @ManyToOne
    private docente doc;
    
    @ManyToOne
    private instituto instituto;
    
   
    public curso(){}
    
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
    public Date getFecha(){return this.fecha;}
    
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
    
}
