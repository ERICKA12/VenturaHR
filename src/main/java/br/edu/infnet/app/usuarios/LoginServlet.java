package br.edu.infnet.app.usuarios;

import br.edu.infnet.domain.usuarios.Usuario;
import br.edu.infnet.infra.usuarios.UsuarioService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/usuarios/login"})
public class LoginServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       
        String telaInicial = "";                
        if(request.isUserInRole("empresa")) {
            telaInicial = "/empresas/index.jsp";
        } else if(request.isUserInRole("candidato")) {
            telaInicial = "/candidatos/index.jsp";
        } else {
            telaInicial = "/administradores/index.jsp";      
        }

        RequestDispatcher rd = request.getRequestDispatcher(telaInicial);
        rd.forward(request, response);
                
        String email = request.getRemoteUser();
        UsuarioService us = new UsuarioService();
        Usuario usuario = us.obterPorEmail(email);
        request.setAttribute("usuario", usuario);
    }
    



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
    } 
  
}
