package Clases;
import java.util.Date;

public class curso {
    protected String nombre, descripcion, URL;
    protected Date duracion, cantHoras, fecha;
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
