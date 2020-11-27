package Clases;

import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataUsuario {

    private List<usuario> usuarios;
    private String nickname;
    private String nombre;
    private String apellido;
    private String correo;
    private String pass;
    private java.util.Date  FechaNac;
    
    public DataUsuario(String name, String passwd, String LastName, String NN, String Email, java.util.Date date){
        this.FechaNac = date;
        this.apellido = LastName;
        this.nombre = name;
        this.nickname = NN;
        this.pass = passwd;
        this.correo = Email;
    }
    
    public DataUsuario(usuario user){
        this.FechaNac = user.getDate();
        this.apellido = user.getLastName();
        this.nombre = user.getName();
        this.nickname = user.getNN();
        this.pass = user.getPass();
        this.correo = user.getEmail();
    }

    public DataUsuario(){}
    
    
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
     public void setUsuarios(List<usuario> ins){this.usuarios = ins;}
      public List<usuario> getUsuarios(){return this.usuarios;}
}
