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
     List<inscripcion> inscripciones ;
    
    public alumno( String name, String LastName, String NN, String Email, java.util.Date date){
        super(name, LastName, NN, Email, date);
    }
    
    public alumno(){}
    
    public void setInscripcion(List<inscripcion> insc){this.inscripciones = insc;}
    
    public List<inscripcion> getInscripcion(){
        return this.inscripciones;
    }
    
    
//    public void setCursos(List<edicionCurso> cursos){
//        this.EdicionCursos=cursos;
//    }
//    
//    public List<edicionCurso> getCursos(){
//        return this.EdicionCursos;
//    }
}

