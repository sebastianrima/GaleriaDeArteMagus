/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magus.galeriadearte;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Isaac
 */
@WebServlet(name = "comprarObra", urlPatterns = {"/comprarObra"})
public class comprarObra extends HttpServlet {

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
            String codigoObra = request.getParameter("c");
            String user = request.getParameter("u");
            String codigoUser="";
            String sqlCode1 = "select codigoCliente from clientes where usuario =\""+user+"\";";
            String sqlCode3 ="select codigoArtista  from obras where codigo = "+codigoObra+";";
            String codigoArtista=""; 
            
            
            
            myDb db = new myDb();
            Connection con = db.getcon();
            Statement stmt = con.createStatement();
            
            ResultSet resultadoConsulta = stmt.executeQuery(sqlCode1);
            while (resultadoConsulta.next()) {
                codigoUser = resultadoConsulta.getString(1);
            }
            
            String sqlCode2 = "UPDATE obras  SET codigoCliente = "+codigoUser+ " WHERE obras.codigo="+codigoObra+";";
            stmt.executeUpdate(sqlCode2);
            
            ResultSet resultadoConsulta2 = stmt.executeQuery(sqlCode3);
            while (resultadoConsulta2.next()) {
                codigoArtista = resultadoConsulta2.getString(1);
            }
            
            String sqlCode4 = "UPDATE artista  SET puntaje=puntaje+50  WHERE codigoArtista="+codigoArtista;
            stmt.executeUpdate(sqlCode4);
            
            out.print("Obra comprada con exito!!!");
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(comprarObra.class.getName()).log(Level.SEVERE, null, ex);
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
