/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.*;
import javax.persistence.*;

@Entity (name = "edicionCurso")

 
public class edicionCurso {

    @Id
    private String nombre;
    //private periodo peridoVigencia;
    private Date Pinicio;
    private Date Pfin;
    private int cupo;
    private Date fechaPublicacion;
    
    @OneToMany
     List<inscripcion> inscr;
    
//    @ManyToMany(mappedBy="Cursos")
//    private List<alumno> alumnos;
    
    @ManyToOne
    private curso Curso;
    
    public edicionCurso() {}
    public edicionCurso(String nombre, Date PInicio, Date PFin, int cupo, Date fechaPublicacion, curso Curso) {
        this.nombre = nombre;
        this.Pfin = PFin;
        this.Pinicio = PInicio;
        this.cupo = cupo;
        this.fechaPublicacion = fechaPublicacion;
        this.Curso=Curso;
    }

    public List<inscripcion> getInscripcion(){return this.inscr;}
    public void setInscripcion(List<inscripcion> insc){this.inscr = insc;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public int getCupo() {return cupo;}
    public void setCupo(int cupo) {this.cupo = cupo;}
    public Date getFechaPublicacion() {return fechaPublicacion;}
    public void setFechaPublicacion(Date fechaPublicacion) {this.fechaPublicacion = fechaPublicacion;}
    public Date getPinicio() {return Pinicio;}
    public void setPinicio(Date Pinicio) {this.Pinicio = Pinicio;}
    public Date getPfin() {return Pfin;}
    public void setPfin(Date Pfin) {this.Pfin = Pfin;}
    public curso getCurso() {return Curso;}
    public void setCurso(curso Curso) {this.Curso = Curso;}
}
