package Clases;

import javax.swing.JOptionPane;

public class ControladorUsuario {
    public void altaUsuario(String name, String LastName, String NN, String Email, java.util.Date date, Boolean tipo){
        if(!tipo){
            usuario usu = new alumno(name, LastName, NN, Email, date);
            JOptionPane.showMessageDialog( null, "Nombre: "+usu.getName()+"\nApellido: "+usu.getLastName()+"\nNickname: "+usu.getNN()+"\nCorreo: "+usu.getEmail()+"\nFecha de nacimiento: "+usu.getDate());
        }else{
            usuario usu = new docente(name, LastName, NN, Email, date);
            JOptionPane.showMessageDialog( null, "Nombre: "+usu.getName()+"\nApellido: "+usu.getLastName()+"\nNickname: "+usu.getNN()+"\nCorreo: "+usu.getEmail()+"\nFecha de nacimiento: "+usu.getDate());
        }
        
    }
}
