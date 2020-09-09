/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Date;
import javax.persistence.*;

@Entity 
@Table( name="inscripcion" )
public class inscripcion {
    
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne@JoinColumn(name="alumnoninscrip")
    private alumno Alu;
    
    @ManyToOne @JoinColumn(name="edicioninscrip")
    private edicionCurso EdicionCurso;
    
    private Date Fecha;
    
    public inscripcion() {}
    
     public inscripcion(edicionCurso EdicionCurso, alumno Alumno, Date fech){
        this.Alu = Alumno;
        this.EdicionCurso = EdicionCurso;
        this.Fecha = fech;
    }
    
    public Date getFecha(){return this.Fecha;}
    public alumno getAlumno(){return this.Alu;}
    public edicionCurso getedicion(){return this.EdicionCurso;}
    
    public void setFecha(Date fecha){this.Fecha = fecha;}
    public void setAlumno(alumno al){this.Alu = al;}
    public void setEdicionCurso(edicionCurso EdC){this.EdicionCurso=EdC;}

}
