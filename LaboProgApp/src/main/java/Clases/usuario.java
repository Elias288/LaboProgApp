package Clases;

import java.util.Date;
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
    protected String pass;
    protected java.util.Date  FechaNac;
    
    
    public usuario(String name, String passwd, String LastName, String NN, String Email, java.util.Date date){
        this.FechaNac = date;
        this.apellido = LastName;
        this.nombre = name;
        this.nickname = NN;
        this.pass = passwd;
        this.correo = Email;
    }

    public usuario(){}
    public void setNN(String NN){this.nickname=NN;}
    public void setName(String name){this.nombre=name;}
    public void setLN(String apellido){this.apellido=apellido;}
    public void setEmail(String Email){this.correo=Email;}
    public void setDate(Date fech){this.FechaNac=fech;}
    public void setPass(String passwd){this.pass=passwd;}
    public String getName(){return this.nombre;}
    public String getLastName(){return this.apellido;}
    public String getEmail(){return this.correo;}
    public String getNN(){return this.nickname;}
    public java.util.Date getDate(){return this.FechaNac;}
    public String getPass(){return this.pass;}
//    public String getTipo(){
//        return @DiscriminatorValue;
//    }
}