package Clases;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity( name= "Docente" )
@Inheritance( strategy=InheritanceType.JOINED )
public abstract class usuario {
    @Id @Column(name = "UsuNickname") 
    protected String nickname;
    
    @Column(name = "UsuName") 
    protected String nombre;
    
    @Column(name = "UsuLastName") 
    protected String apellido;
    
    @Column(name = "UsuEmail") 
    protected String correo;
    
    @Column(name = "UsuDate")
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