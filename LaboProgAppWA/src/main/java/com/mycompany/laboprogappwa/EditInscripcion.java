package com.mycompany.laboprogappwa;

//import Clases.ControladorCurso;
//import Clases.inscripcion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servidor.EdicionCurso;

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
            
            servidor.Inscripcion insWS;
            
            String nombreEd = request.getParameter("edicion");
            String nombreEst[] = request.getParameterValues("nombreEst");
            String estado[] = request.getParameterValues("estado");
            String nota[]= request.getParameterValues("nota");
            String Cerrar = request.getParameter("cerrar");
            
            if(nombreEst!= null && estado!= null){
                for(int f =0; f < nombreEst.length; f++){
                    String est = nombreEst[f];
                    /*
                        out.println(nombreEst[f]);
                        out.println(nota[f]);
                        out.println(estado[f]+"<br>");
                    */
                    
                    if(estado[f].equals("Aceptada")){
                        insWS = OP.listarInscripcionesWS(nombreEst[f], nombreEd).get(0);
                        OP.editIsncripcionWS(insWS, "Aceptada",nota[f]);
                    }else if(estado[f].equals("Rechazada")){
                        insWS = OP.listarInscripcionesWS(est, nombreEd).get(0);
                        OP.editIsncripcionWS(insWS, "Rechazada","0");
                    }   
                }
            }
            
            if(Cerrar != null && Cerrar.equals("cerrar")){
                EdicionCurso edcur = OP.BuscarEdicionWS(nombreEd);
                OP.editVigenciaEdicion(edcur,false);
            }
                //funcion cerrar edicion
                
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
