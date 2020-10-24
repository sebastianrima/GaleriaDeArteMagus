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
 * @author Isaac
 */
@WebServlet(name = "votar", urlPatterns = {"/votar"})
public class votar extends HttpServlet {

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
           String usuario = request.getParameter("u");
             String sql = "update votando set votos=votos+1 where codigoObra="+codigoObra;
           String sql1 = "update clientes set  fechaUltimaVotacion = current_date() where usuario=\""+usuario+"\"";
           String fecha="";
           String busqueda = "select month(fechaUltimaVotacion),year(fechaUltimaVotacion) from clientes where usuario=\""+usuario+"\";";
           String mesUltima="";
           String añoUltima="";
           DateTimeFormatter mes = DateTimeFormatter.ofPattern("MM");
           DateTimeFormatter año = DateTimeFormatter.ofPattern("yyyy");
           
           
           //dia.format(LocalDateTime.now());
           
           
           
           
           myDb db = new myDb();
           Connection con = db.getcon();
           Statement stmt = con.createStatement();
           
           ResultSet resultadoConsulta1 = stmt.executeQuery(busqueda);
           while (resultadoConsulta1.next()) {
                
                    mesUltima= resultadoConsulta1.getString(1);
                   añoUltima=  resultadoConsulta1.getString(2);
            }
           if(!(fecha instanceof String))
           {
                stmt.executeUpdate(sql1);
           
                stmt.executeUpdate(sql);
                out.print("Has votado correctamente");
           }else
           {
               if(mes.format(LocalDateTime.now()).equals(mesUltima) && año.format(LocalDateTime.now()).equals(añoUltima))
                   out.print("false");
                 
               else
               {
                    stmt.executeUpdate(sql1);
                    stmt.executeUpdate(sql);
                    out.print("Has votado correctamente");
               }
           }
          
           
        } catch (SQLException ex) {
            Logger.getLogger(votar.class.getName()).log(Level.SEVERE, null, ex);
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
