package Clases;

import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;

@Entity( name= "Alumno")
@DiscriminatorValue( value = "NS" )
public class alumno extends usuario{

    public alumno( String name, String LastName, String NN, String Email, java.util.Date date){
        super(name, LastName, NN, Email, date);
    }
    
    public alumno(){
        
    }
}

