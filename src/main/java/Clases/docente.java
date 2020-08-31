package Clases;

import java.util.Date;

public class docente extends usuario{
    protected String Instituto;
    
    public docente(String name, String LastName, String NN, String Email, java.util.Date date, String Instituto){
        super(name, LastName, NN, Email, date);
        this.Instituto = Instituto;
    }
}
