package Clases;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)

@Entity
@Table(name="instituto")
public class instituto implements Serializable{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String Facultad;
    
    public instituto(String facultad){
        this.Facultad = facultad;
    }
    public instituto(){}
    
    public String getFacultad(){return this.Facultad;}
    
    public long getId(){return this.id;}
    
    public void setFacultad(String facu){this.Facultad = facu;}
}
