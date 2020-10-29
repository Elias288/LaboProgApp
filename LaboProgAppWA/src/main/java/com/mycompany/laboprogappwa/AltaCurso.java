/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboprogappwa;

import java.util.*;
import Clases.ControladorCurso;
import Clases.PersistenceManager;
import Clases.categoria;
import Clases.curso;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author nacho
 */
@WebServlet(name = "AltaCurso", urlPatterns = {"/altaCurso"})
public class AltaCurso extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        List<curso> CurList = new ArrayList<>();
        List<categoria> CatList = new ArrayList<>();
        List<String> listNomCurso = new ArrayList<>();
        List<String> listNomCat = new ArrayList<>();
        String instituto, nombre, descripcion, duracion, horas, creditos, url,docente;
        String previas[], categorias[];
        
        docente = request.getParameter("btnSubmit");
        instituto = request.getParameter("instituto");
        nombre = request.getParameter("nombre");
        descripcion= request.getParameter("descripcion");
        duracion = request.getParameter("duracion");
        horas = request.getParameter("horas");
        creditos = request.getParameter("creditos");
        url = request.getParameter("url");
        previas = request.getParameterValues("previas");//.split(",");
        categorias = request.getParameterValues("categorias");//.split(",");
        
        ControladorCurso cc = new ControladorCurso();
        
        Date date=java.util.Calendar.getInstance().getTime();
        
        for(int f = 0;f < previas.length;f++){
            listNomCurso.add(previas[f]);
            
        }
        for(int f = 0;f < categorias.length;f++){
            //listNomCat.add(categorias[f]);
            CatList.add(cc.cargarCategorias(categorias[f]));
        }
        
        CurList = cc.cargarCurso(listNomCurso);
        //CatList = cc.cargarCategoria(listNomCat);
        
        //verificar si ya existe el curso
        
        //curso cur = cc.findCurso(nombre);
        //if(cur != null){
        //    try (PrintWriter out = response.getWriter()) {
        //        out.println("<h1>ya existe el curso, desea reemplazarlo?</h1>");
        //    }
        //}
        //else{
        //    try (PrintWriter out = response.getWriter()) {
        //        out.println("<h1>ya existe el curso, desea reemplazarlo?</h1>");
        //    }
            cc.AltaCurso(nombre, instituto, descripcion, url, Integer.parseInt(duracion), Integer.parseInt(horas), date, Integer.parseInt(creditos), CurList, docente, CatList);
        //}
            
  
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("dato 1: "+instituto+"<br>");
            out.println("dato 2: "+nombre+"<br>");
            out.println("dato 2.2: "+docente+"<br>");
            out.println("dato 3: "+descripcion+"<br>");
            out.println("dato 4: "+duracion+"<br>");
            out.println("dato 5: "+horas+"<br>");
            out.println("dato 6: "+creditos+"<br>");
            out.println("dato 7: "+url+"<br>");
            out.println("dato 8: "+previas+"<br>");
            out.println("dato 9: "+categorias+"<br>");
            Iterator iter = CurList.iterator();
            while(iter.hasNext()){
                curso curs = (curso)iter.next();
                out.println("dato 8: "+ curs.getName()+"<br>");
            }
            Iterator iter2 = CatList.iterator();
            while(iter2.hasNext()){
                categoria cat = (categoria)iter2.next();
                out.println("dato 9: "+ cat.Getnombre()+"<br>");
                
            }
            out.println("fin de los datos <br>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
