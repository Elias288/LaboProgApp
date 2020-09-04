package Clases;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ManyToMany;

@Entity( name= "Alumno")
@DiscriminatorValue( value = "Estudiante" )
public class alumno extends usuario{
    @ManyToMany
    protected List<edicionCurso> Cursos;
    public alumno( String name, String LastName, String NN, String Email, java.util.Date date){
        super(name, LastName, NN, Email, date);
    }
    
    public alumno(){}
    
    public void setCursos(List<edicionCurso> cursos){
        this.Cursos=cursos;
    }
    
    public List<edicionCurso> getCursos(){
        return this.Cursos;
    }
}

