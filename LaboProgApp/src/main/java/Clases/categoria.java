package Clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)

@Entity
@Table( name="Categoria" )
public class categoria {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    protected String nombre;
    
    public void Setnombre(String name){this.nombre = name;}
    public String Getnombre(){return this.nombre;}
    public long GetId(){return this.id;}
}
