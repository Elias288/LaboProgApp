package Clases;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table( name= "Docente")
public abstract class usuario {
    protected @Id String nickname, nombre, apellido, correo;
    java.util.Date  FechaNac;
    
    public usuario(String name, String LastName, String NN, String Email, java.util.Date date){
        this.FechaNac = date;
        this.apellido = LastName;
        this.nombre = name;
        this.nickname = NN;
        this.correo = Email;
    }
    
    public String getName(){
        return this.nombre;
    }
    public String getLastName(){
        return this.apellido;
    }
    public String getEmail(){
        return this.correo;
    }
    public String getNN(){
        return this.nickname;
    }
    public java.util.Date getDate(){
        return this.FechaNac;
    }
}