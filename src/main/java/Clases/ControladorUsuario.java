package Clases;

import javax.swing.JOptionPane;

public class ControladorUsuario {
    
    public usuario altaUsuario(String name, String LastName, String NN, String Email, java.util.Date date, Boolean tipo, instituto Instituto){
        if(!tipo){
            usuario usu = new alumno(name, LastName, NN, Email, date);
            JOptionPane.showMessageDialog( null, "Usuario "+usu.getNN()+"\nAgregado Correctamente");
            return usu;
        }else{
            usuario usu = new docente(name, LastName, NN, Email, date, Instituto);
            JOptionPane.showMessageDialog( null, "Usuario "+usu.getNN()+"\nAgregado Correctamente");
            return usu;
        }
    }
    
    
    public void ConsultaUsuario(){
        
    }
    public void ModificarUsuario(){
        
    }
}
