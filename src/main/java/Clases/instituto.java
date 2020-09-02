package Clases;

import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class instituto {
    @Id
    protected String Facultad;
    
    public instituto(String facultad){
        this.Facultad = facultad;
    }
}
