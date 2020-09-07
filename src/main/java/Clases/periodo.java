package Clases;

import java.util.Date;

public class periodo {
    private Date inicio;
    private Date fin;

    /**
     * @return the inicio
     */
    public Date getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    /**
     * @return the fin
     */
    public Date getFin() {
        return fin;
    }

    /**
     * @param fin the fin to set
     */
    public void setFin(Date fin) {
        this.fin = fin;
    }

    public periodo() {}

    public periodo(Date inicio, Date fin) {
        this.inicio = inicio;
        this.fin = fin;
    }
    
    
}
