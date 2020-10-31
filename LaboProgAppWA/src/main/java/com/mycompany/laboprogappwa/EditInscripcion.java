/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboprogappwa;

import Clases.inscripcion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Elias
 */
@WebServlet(name = "EditInscripcion", urlPatterns = {"/EditInscripcion"})
public class EditInscripcion extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            Operaciones OP = new Operaciones();
            inscripcion ins = null;
            String chequed[] = request.getParameterValues("checkboxAceptado");
            String chequed2[] = request.getParameterValues("checkbox");
            String nombreEd = request.getParameter("edicion");
            String nombreEst[] = request.getParameterValues("nombreEst");
            
            if(chequed!= null){
                for(int f = 0;f < chequed.length;f++){
                    out.println(chequed[f]);
                    out.println("chequeado<br>");
                    ins = OP.listarInscripciones(chequed[f], nombreEd).get(0);
                    OP.editIsncripcion(ins, "Aceptada");
                }
            }
            
            int semaforo=0;
            
            
            if(nombreEst!= null){
                for(int f = 0;f < nombreEst.length;f++){
                    out.println(nombreEst[f]);
                    if(chequed2 != null){
                        for(int x = 0;x < chequed2.length;x++){
                            if(chequed2[x].equals(nombreEst[f])){
                                semaforo = 1;
                            }
                        }
                    }
                    if(semaforo==0){
                        out.println("cambio<br>");
                        ins = OP.listarInscripciones(nombreEst[f], nombreEd).get(0);
                        OP.editIsncripcion(ins, "Rechazada");
                    }
                }
            }
            
            out.println("<script> location.replace('EdicionCurso.jsp?EdCur="+nombreEd+"');</script>");
            
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
