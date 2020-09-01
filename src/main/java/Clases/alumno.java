package Clases;

import java.util.Date;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity
@Table( name= "Alumno")
@PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "nickname"))
public class alumno extends usuario{

    public alumno( String name, String LastName, String NN, String Email, java.util.Date date){
        super(name, LastName, NN, Email, date);
    }
    
}
