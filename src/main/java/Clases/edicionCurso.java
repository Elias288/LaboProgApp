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
    private List<inscripcion> inscr = new ArrayList<>();
    
//    @ManyToMany(mappedBy="Cursos")
//    private List<alumno> alumnos;
    
    @ManyToOne
    private curso Curso;
    
    public edicionCurso() {
    }

    public edicionCurso(String nombre, Date PInicio, Date PFin, int cupo, Date fechaPublicacion, curso Curso) {
        this.nombre = nombre;
        this.Pfin = PFin;
        this.Pinicio = PInicio;
        this.cupo = cupo;
        this.fechaPublicacion = fechaPublicacion;
        this.Curso=Curso;
    }

    public List<inscripcion> getInscripcion(){
        return this.inscr;
    }
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the peridoVigencia
     */


    /**
     * @return the cupo
     */
    public int getCupo() {
        return cupo;
    }

    /**
     * @param cupo the cupo to set
     */
    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    /**
     * @return the fechaPublicacion
     */
    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     * @param fechaPublicacion the fechaPublicacion to set
     */
    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     * @return the Pinicio
     */
    public Date getPinicio() {
        return Pinicio;
    }

    /**
     * @param Pinicio the Pinicio to set
     */
    public void setPinicio(Date Pinicio) {
        this.Pinicio = Pinicio;
    }

    /**
     * @return the Pfin
     */
    public Date getPfin() {
        return Pfin;
    }

    /**
     * @param Pfin the Pfin to set
     */
    public void setPfin(Date Pfin) {
        this.Pfin = Pfin;
    }
        /**
     * @return the alumnos
     */
//    public List<alumno> getAlumnos() {
//        return alumnos;
//    }
//
//    /**
//     * @param alumnos the alumnos to set
//     */
//    public void setAlumnos(List<alumno> alumnos) {
//        this.alumnos = alumnos;
//    }

    /**
     * @return the Curso
     */
    public curso getCurso() {
        return Curso;
    }

    /**
     * @param Curso the Curso to set
     */
    public void setCurso(curso Curso) {
        this.Curso = Curso;
    }
    
}
