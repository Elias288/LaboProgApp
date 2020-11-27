package Clases;

import java.util.Date;
import java.util.List;

public class DataEdiciones {
    private String nombre;
    private Date Pinicio;
    private Date Pfin;
    private int cupo;
    private Date fechaPublicacion;
    List<inscripcion> inscr;
    private curso Curso;
    
    private List<edicionCurso> ediciones = null;
    
    public DataEdiciones() {}
    
    public DataEdiciones(edicionCurso ed){
        this.nombre = ed.getNombre();
        this.Pinicio = ed.getPinicio();
        this.Pfin = ed.getPfin();
        this.cupo = ed.getCupo();
        this.fechaPublicacion = ed.getFechaPublicacion();
        this.inscr = ed.getInscripcion();
        this.Curso = ed.getCurso();
    }
    
    public DataEdiciones(String nombre, Date PInicio, Date PFin, int cupo, Date fechaPublicacion, curso Curso) {
        this.nombre = nombre;
        this.Pfin = PFin;
        this.Pinicio = PInicio;
        this.cupo = cupo;
        this.fechaPublicacion = fechaPublicacion;
        this.Curso=Curso;
    }

    public List<inscripcion> getInscripcion(){return this.inscr;}
    public void setInscripcion(List<inscripcion> insc){this.inscr = insc;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public int getCupo() {return cupo;}
    public void setCupo(int cupo) {this.cupo = cupo;}
    public Date getFechaPublicacion() {return fechaPublicacion;}
    public void setFechaPublicacion(Date fechaPublicacion) {this.fechaPublicacion = fechaPublicacion;}
    public Date getPinicio() {return Pinicio;}
    public void setPinicio(Date Pinicio) {this.Pinicio = Pinicio;}
    public Date getPfin() {return Pfin;}
    public void setPfin(Date Pfin) {this.Pfin = Pfin;}
    public curso getCurso() {return Curso;}
    public void setCurso(curso Curso) {this.Curso = Curso;}
    
    public void setEdiciones(List<edicionCurso> ed){this.ediciones = ed;}
    public List<edicionCurso> getEdiciones(){return this.ediciones;}
}
