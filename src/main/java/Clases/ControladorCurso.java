package Clases;

import java.util.Date;

public class ControladorCurso {
    
    public void AltaCurso(String name, String desc, String link, Date duracion, Date cantHoras, Date fecha, int creditos){
        curso cur = new curso(name, desc, link, duracion, cantHoras, fecha, creditos);
    }
    
    public void ConsultaCurso(){
        
    }
    
}
