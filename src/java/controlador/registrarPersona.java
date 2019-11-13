package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controlador.listarPersonas;

/**
 *
 * @author andre
 */
@WebServlet(urlPatterns = {"/registrarPersona"})
public class registrarPersona extends HttpServlet {

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
        int documento = Integer.parseInt(request.getParameter("id"));
        String tipo = request.getParameter("tdoc");
        String nombre = request.getParameter("nom");
        String apellido = request.getParameter("ap");
        String correo = request.getParameter("cor");
        int celular = Integer.parseInt(request.getParameter("cel"));
        String contra = request.getParameter("pass");
        persona per = new persona();
        try (PrintWriter out = response.getWriter()) {
            //if(!per.existe(documento,tipo)) {
                if (per.registrar(documento, tipo, nombre, apellido, correo, celular, contra)) {
                    request.getRequestDispatcher("index.html").forward(request, response);
                } else {
                    request.getRequestDispatcher("registrar.jsp").forward(request, response);
                }
            //} else {
                //request.getRequestDispatcher("listarPersonas").forward(request, response);
           // }
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