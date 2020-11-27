package Clases;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataCategoria {
    private long id;
    private String nombre;
    
    private List<categoria> categorias = null;
    
    public DataCategoria(){
        this.nombre = null;
        this.categorias = null;
    }
    
    public DataCategoria(categoria cat){
        this.id = cat.GetId();
        this.nombre = cat.Getnombre();
    }
    
    public void Setnombre(String name){this.nombre = name;}
    public void SetCategorias(List<categoria> cat){this.categorias = cat;}
    public String Getnombre(){return this.nombre;}
    public long GetId(){return this.id;}
    public List<categoria> GetCategoria(){return this.categorias;}
}
