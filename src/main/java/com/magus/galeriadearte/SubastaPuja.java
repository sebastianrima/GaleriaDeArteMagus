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
@WebServlet(name = "SubastaPuja", urlPatterns = {"/SubastaPuja"})
public class SubastaPuja extends HttpServlet {

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
            
            String user= request.getParameter("u");
            String obra= request.getParameter("o");
            String sqlCode = "";
            String sqlCode2 = "";
            String codigo = null, autor = null, fotoAutor = null, obrasNum = null, descripcion = null, puntaje = null;
            //sqlCode = "SELECT * FROM `artista` WHERE artista.puntaje";         Así estaba
            
            sqlCode = "select codigoCliente,cantidadDePujas from clientes,votando where usuario = \""+user+"\";";
            myDb db = new myDb();
            Connection con = db.getcon();
            Statement stmt = con.createStatement();
            ResultSet resultadoConsulta1 = stmt.executeQuery(sqlCode);
            String code = "";
            while (resultadoConsulta1.next()) {
                    code = resultadoConsulta1.getString(1);
            }
            sqlCode2="update votando set cantidadDePujas=cantidadDePujas+1  , IDultimoPujador = \""+code+"\" where codigoObra = \""+obra+"\";";
            stmt.executeUpdate(sqlCode2);

            con.close();
            out.println("pujado satisfactoriamente!!");
        } catch (SQLException ex) {
            Logger.getLogger(SubastaPuja.class.getName()).log(Level.SEVERE, null, ex);
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
