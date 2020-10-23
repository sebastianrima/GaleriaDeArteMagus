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
 * @author Nicolas
 */
@WebServlet(name = "vistaObraServlet", urlPatterns = {"/vistaObraServlet"})
public class vistaObraServlet extends HttpServlet {

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
            String codigo = request.getParameter("c");
            String codigoArtista = "1";
            String sqlCode = "";
            String nombreArtista = "";
            String tituloObra = null, descripcion = null, codigoCliente = null, codigoAutor = null, precioBaseObra = null, fechaCreacion = null, tipo = null, color = null, emocion = null, tematica = null, movimiento = null, obraPicture = null, respuesta;
            sqlCode = "SELECT * FROM `obras` WHERE obras.codigo = " + codigo;

            myDb db = new myDb();
            Connection con = db.getcon();
            Statement stmt = con.createStatement();
            movimiento = " ";
            ResultSet resultadoConsulta = stmt.executeQuery(sqlCode);

            while (resultadoConsulta.next()) {
                tituloObra = resultadoConsulta.getString(2);
                precioBaseObra = resultadoConsulta.getString(3);
                obraPicture = resultadoConsulta.getString(4);
                fechaCreacion = resultadoConsulta.getString(5);
                tipo = resultadoConsulta.getString(6);
                color = resultadoConsulta.getString(7);
                emocion = resultadoConsulta.getString(8);
                tematica = resultadoConsulta.getString(9);
                movimiento = resultadoConsulta.getString(10);
                descripcion = resultadoConsulta.getString(11);
                codigoCliente = resultadoConsulta.getString(12);
                codigoAutor = resultadoConsulta.getString(13);
            }
            ResultSet resultadoConsulta2 = stmt.executeQuery("SELECT nombre FROM artista WHERE artista.codigoArtista=" + codigoArtista);

            while (resultadoConsulta2.next()) {
                nombreArtista = resultadoConsulta2.getString(1);
            }
            
            respuesta = tituloObra + ",," + descripcion + ",," + precioBaseObra + ",,"
                    + fechaCreacion + ",," + tipo + ",," + color + ",," + emocion + ",,"
                    + tematica + ",," + movimiento + ",," + obraPicture + ",," + nombreArtista+ ",," + codigoCliente+ ",," + codigoAutor;
            con.close();
            out.println(respuesta);
        } catch (SQLException ex) {
            Logger.getLogger(vistaObraServlet.class.getName()).log(Level.SEVERE, null, ex);
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
