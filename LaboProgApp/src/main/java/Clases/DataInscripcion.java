package Clases;

import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataInscripcion {
    private long id;
    private String estado="";
    private alumno Alu;
    private edicionCurso EdicionCurso;
    private Date Fecha;
    
    private List<inscripcion> inscripciones = null;
    
    public DataInscripcion() {}
    
    public DataInscripcion(inscripcion ins) {
        this.id = ins.getId();
        this.estado = ins.getEstado();
        this.Alu = ins.getAlumno();
        this.EdicionCurso = ins.getedicion();
        this.Fecha = ins.getFecha();
    }
    
    public DataInscripcion(edicionCurso EdicionCurso, alumno Alumno, Date fech, String est){
        this.Alu = Alumno;
        this.EdicionCurso = EdicionCurso;
        this.Fecha = fech;
        this.estado = est;
    }
    
    public Date getFecha(){return this.Fecha;}
    public alumno getAlumno(){return this.Alu;}
    public edicionCurso getedicion(){return this.EdicionCurso;}
    public String getEstado(){return this.estado;}
    public List<inscripcion> getInscripciones(){return this.inscripciones;}
    
    public void setFecha(Date fecha){this.Fecha = fecha;}
    public void setAlumno(alumno al){this.Alu = al;}
    public void setEdicionCurso(edicionCurso EdC){this.EdicionCurso=EdC;}
    public void setEstado(String est){this.estado=est;}
    public void setInscripciones(List<inscripcion> ins){this.inscripciones = ins;}
}
