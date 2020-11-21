package WebService;

import Clases.ControladorCurso;
import Clases.PersistenceManager;
import javax.persistence.EntityManager;

public class main {
    public static void main(String[] args) {
        EntityManager em = PersistenceManager.getInstance().createEntityManager();
        ControladorCurso CC = new ControladorCurso();
        
        CC.AltaInstituto("Innova2");
        
        Publicador p = new Publicador();
        p.publicar();
    }
}
