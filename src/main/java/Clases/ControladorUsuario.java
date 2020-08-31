package Clases;

import javax.swing.JOptionPane;

public class ControladorUsuario {
    
    public void altaUsuario(String name, String LastName, String NN, String Email, java.util.Date date, Boolean tipo, String Instituto){
        if(!tipo){
            usuario usu = new alumno(name, LastName, NN, Email, date);
            JOptionPane.showMessageDialog( null, "Usuario "+usu.getNN()+"\nAgregado Correctamente");
        }else{
            usuario usu = new docente(name, LastName, NN, Email, date, Instituto);
            JOptionPane.showMessageDialog( null, "Usuario "+usu.getNN()+"\nAgregado Correctamente");
        }
        
    }
}
