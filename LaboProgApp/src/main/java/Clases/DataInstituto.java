package Clases;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)

public class DataInstituto {
    private long id;
    private String Facultad;
    private List<instituto> institutos = null;
    
    public DataInstituto(String facultad){
        this.Facultad = facultad;
    }
    
    public DataInstituto(instituto ins){
        this.Facultad = ins.getFacultad();
        this.id = ins.getId();
    }
    
    public DataInstituto(){}
    public String getFacultad(){return this.Facultad;}
    public long getId(){return this.id;}    
    public List<instituto> getInstitutos(){return this.institutos;}
 //   public void setFacultad(String facu){this.Facultad = facu;}
     public void SetFacultad(List<instituto> cat){this.institutos = cat;}
    public void setInstitutos(List<instituto> ins){this.institutos = ins;}

}
