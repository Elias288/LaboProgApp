package Clases;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
@Table( name="Curso" )
public class curso implements Serializable{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    protected String nombre;
    protected String descripcion, URL;
    protected int duracion;
    protected int cantHoras;
    protected Date fecha;
    protected int Creditos;
    
    @ManyToMany
    protected List<curso> Previas;
    
    @ManyToOne
    protected instituto instituto;
    
//    public curso(String name, String desc, String link, int duracion, int cantHoras, Date fecha, int creditos){
//        this.Creditos = creditos;
//        this.URL = URL;
//        this.cantHoras = cantHoras;
//        this.descripcion = desc;
//        this.duracion = duracion;
//        this.fecha = fecha;
//        this.nombre = name;
//    }
    
    public curso(){}
    
    public String getName(){
        return this.nombre;
    }
    public String getDesc(){
        return this.descripcion;
    }
    public int getDuracion(){
        return this.duracion;
    }
    public int getCreditos(){
       return this.Creditos;
    }
    public int getCantHoras(){
        return this.cantHoras;
    }
    public List<curso> getPrevias(){
        return this.Previas;
    }
    public void SetName(String name){
        this.nombre = name;
    }
    public void SetDescripcion(String desc){
        this.descripcion = desc;
    }
    public void SetURL(String url){
        this.URL = url;
    }
    public void SetCantH(int cant){
        this.cantHoras =cant;
    }
    public void SetDuracion(int dura){
        this.duracion=dura;
    }
    public void setFecha(Date fech){
        this.fecha = fech;
    }
    public void SetCreditos(int cred){
        this.Creditos= cred;
    }
    public void SetInstituto(instituto ins){
        this.instituto=ins;
    }
    public void SetPrevias(List<curso> prev){
        this.Previas = prev;
    }
    
}
