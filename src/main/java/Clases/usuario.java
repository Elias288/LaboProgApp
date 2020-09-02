package Clases;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.DiscriminatorType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity( name= "Usuario" )
@Inheritance( strategy=InheritanceType.JOINED )
@DiscriminatorColumn(name="Tipo_Usuario", discriminatorType=DiscriminatorType.STRING)
public abstract class usuario {
    @Id 
    protected String nickname;
    protected String nombre;
    protected String apellido;
    protected String correo;
    protected java.util.Date  FechaNac;
    
    
    public usuario(String name, String LastName, String NN, String Email, java.util.Date date){
        this.FechaNac = date;
        this.apellido = LastName;
        this.nombre = name;
        this.nickname = NN;
        this.correo = Email;
    }
    
    public String getName(){return this.nombre;}
    public String getLastName(){return this.apellido;}
    public String getEmail(){return this.correo;}
    public String getNN(){return this.nickname;}
    public java.util.Date getDate(){return this.FechaNac;}
}