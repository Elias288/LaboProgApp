package Clases;

import java.util.List;
import javax.persistence.*;

@Entity( name= "Alumno")
@DiscriminatorValue( value = "Estudiante" )
public class alumno extends usuario{
        
    @OneToMany 
     List<inscripcion> inscripciones ;
    
    public alumno( String name, char[] passwd, String LastName, String NN, String Email, java.util.Date date){
        super(name, passwd, LastName, NN, Email, date);
    }
    
    public alumno(){}
    
    public void setInscripcion(List<inscripcion> insc){this.inscripciones = insc;}
    
    public List<inscripcion> getInscripcion(){
        return this.inscripciones;
    }
}

