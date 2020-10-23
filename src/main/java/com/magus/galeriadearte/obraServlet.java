/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magus.galeriadearte;

import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
@WebServlet(name = "obraServlet", urlPatterns = {"/obraServlet"})
public class obraServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String data = request.getParameter("data");
            String campos = "1";
            String sqlCode = "";
            String NombreObra, imgObra, imgAutor, NombreAutor, PrecioDeSalida, PrecioSubasta, ValorActual, TiempoRestante, respuesta;
            respuesta = "";
            sqlCode = "SELECT * FROM `obras` WHERE obras.codigo =" + campos;

            myDb db = new myDb();
            Connection con = db.getcon();
            Statement stmt = con.createStatement();

            ResultSet resultadoConsulta = stmt.executeQuery(sqlCode);

            for (int i = 0; i < 8; i++) {
                respuesta += resultadoConsulta.getString(i);
                if (i != 7) {
                    respuesta += ",";
                }
            }
            out.print(respuesta);
            /*NombreObra="La Monalisa"; 
            imgObra="https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Leonardo_da_Vinci_-_Mona_Lisa_%28Louvre%2C_Paris%29.jpg/368px-Leonardo_da_Vinci_-_Mona_Lisa_%28Louvre%2C_Paris%29.jpg";
            NombreAutor="Nicolaos de Esparta";
            imgAutor="/PerfilAutor.png";
            PrecioDeSalida="10$";
            PrecioSubasta="900000$";
            ValorActual="2$";
            TiempoRestante="5H";
            
            respuesta= NombreObra+","+imgObra+","+NombreAutor+","+imgAutor+","+PrecioDeSalida+","+PrecioSubasta+","+ValorActual+","+TiempoRestante;
            out.println(respuesta);*/
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(obraServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(obraServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
