package Clases;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name="Curso" )
public class curso implements Serializable{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    protected String nombre;
    protected String instituto;
    protected String descripcion, URL;
    protected int duracion;
    protected int cantHoras;
    protected Date fecha;
    protected int Creditos;
    
    public curso(String name, String instituto, String desc, String link, int duracion, int cantHoras, Date fecha, int creditos){
        this.Creditos = creditos;
        this.URL = URL;
        this.instituto = instituto;
        this.cantHoras = cantHoras;
        this.descripcion = desc;
        this.duracion = duracion;
        this.fecha = fecha;
        this.nombre = name;
    }
    
    public curso(){}
    
    public String getName(){
        return this.nombre;
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
    public void SetInstituto(String ins){
        this.instituto=ins;
    }
    
}
