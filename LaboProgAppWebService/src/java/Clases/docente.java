package Clases;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity(name= "Docente")
@DiscriminatorValue( value="Profesor" )
public class docente extends usuario{
    
    @ManyToOne
    protected instituto instituto;
    
    public docente(String name, String passwd, String LastName, String NN, String Email, java.util.Date date, instituto Instituto){
        super(name, passwd, LastName, NN, Email, date);
        this.instituto = Instituto;
    }
    public docente(){}
    
    public void SetInstituto(instituto ins){this.instituto=ins;}
    public instituto getInstituto(){return  this.instituto;}
       
}
