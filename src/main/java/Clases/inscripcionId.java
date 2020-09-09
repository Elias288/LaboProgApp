/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class inscripcionId implements Serializable {
    @Column(name = "alumno_id")
    private String  alumno_id;
    @Column(name = "edicionCurso_id")
    private String edicionCurso_id;
    
    public inscripcionId(String Alumno, String EdicionCurso){
        this.alumno_id = Alumno;
        this.edicionCurso_id = EdicionCurso;
    }
}
