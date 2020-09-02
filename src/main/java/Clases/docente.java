package Clases;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name= "Docente")
@DiscriminatorValue( value="TS" )
public class docente extends usuario{
    
    protected String Instituto;
    
    public docente(String name, String LastName, String NN, String Email, java.util.Date date, String Instituto){
        super(name, LastName, NN, Email, date);
        this.Instituto = Instituto;
    }
}
