/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class inscripcion {

    @ManyToOne
    private alumno Alumno;
    @ManyToOne
    private edicionCurso EdicionCurso;
    
    private Date Fecha;
    
    public inscripcion () {}
    
}
