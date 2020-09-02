package Clases;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name="Curso" )
public class curso implements Serializable{
    @Id
    protected String nombre;
    protected String descripcion, URL;
    protected Date duracion;
    protected Date cantHoras;
    protected Date fecha;
    protected int Creditos;
    
    public curso(String name, String desc, String link, Date duracion, Date cantHoras, Date fecha, int creditos){
        this.Creditos = creditos;
        this.URL = URL;
        this.cantHoras = cantHoras;
        this.descripcion = desc;
        this.duracion = duracion;
        this.fecha = fecha;
        this.nombre = name;
    }
    
}
