/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboprogappwa;

import Clases.ControladorCurso;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        
        String instituto, nombre, descripcion, duracion, horas, creditos, url;
        String previas[], categorias[];
        
        instituto = request.getParameter("instituto");
        nombre = request.getParameter("nombre");
        descripcion= request.getParameter("descripcion");
        duracion = request.getParameter("duracion");
        horas = request.getParameter("horas");
        creditos = request.getParameter("creditos");
        url = request.getParameter("url");
        previas = request.getParameter("previas").split(",");
        categorias = request.getParameter("categorias").split(",");
        
        ControladorCurso cc = new ControladorCurso();
        
        //cc.AltaCurso(nombre, instituto, descripcion, url, 0, 0, int. fecha, 0, CursoList, nombre, cate);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("dato 1: "+instituto);
            out.println("dato 2: "+nombre);
            out.println("dato 3: "+descripcion);
            out.println("dato 4: "+duracion);
            out.println("dato 5: "+horas);
            out.println("dato 6: "+creditos);
            out.println("dato 7: "+url);
            for(int f=0;f<previas.length;f++){
                out.println("dato 8: "+previas[f]);
            }
            for(int f=0;f<categorias.length;f++){
                out.println("dato 9: "+categorias[f]);
            }
            out.println("fin de los datos");
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
