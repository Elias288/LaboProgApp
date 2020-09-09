package Clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity( name= "Alumno")
@DiscriminatorValue( value = "Estudiante" )
public class alumno extends usuario{
    
//    @ManyToMany
//    protected List<edicionCurso> EdicionCursos;
    
    @OneToMany
    protected List<inscripcion> inscripcion = new ArrayList<>();
    
    public alumno( String name, String LastName, String NN, String Email, java.util.Date date){
        super(name, LastName, NN, Email, date);
    }
    
    public alumno(){}
    
    public void setInscripcion(List<inscripcion> insc){this.inscripcion = insc;}
    
    public List<inscripcion> getInscripcion(){
        return this.inscripcion;
    }
    
    public void addedicion(edicionCurso ed, Date fech) {
        inscripcion ins = new inscripcion(ed, this, fech);
        inscripcion.add(ins);
        ed.getInscripcion().add(ins);
    }
    
//    public void setCursos(List<edicionCurso> cursos){
//        this.EdicionCursos=cursos;
//    }
//    
//    public List<edicionCurso> getCursos(){
//        return this.EdicionCursos;
//    }
}

