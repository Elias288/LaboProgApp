package Clases;

import java.util.Date;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;
@Entity
@Table( name= "Docente")
@PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "nickname"))
public class docente extends usuario{
    protected instituto Instituto;
    
    public docente(String name, String LastName, String NN, String Email, java.util.Date date, instituto Instituto){
        super(name, LastName, NN, Email, date);
        this.Instituto = Instituto;
    }
}
