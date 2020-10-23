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
@WebServlet(name = "consegirInfoSubastaActual", urlPatterns = {"/consegirInfoSubastaActual"})
public class consegirInfoSubastaActual extends HttpServlet {

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
            String sqlCode = "";
            String[] codigoObras = new String[3];
            int contador = 0;
            String[] nombre = new String[3];
            String[] url = new String[3];
            String[] texto = new String[3];
            String[] precio = new String[3];
            String nombreImg1, urlimg1, textoImg1, precioImg1, nombreImg2, urlimg2, textoImg2, precioImg2, nombreImg3, urlimg3, textoImg3, precioImg3, respuesta;
            DateTimeFormatter mes = DateTimeFormatter.ofPattern("MM");
            DateTimeFormatter año = DateTimeFormatter.ofPattern("yyyy");
            sqlCode = "SELECT  codigoObra FROM `votando` WHERE  month(fechaVotacion) = " + mes.format(LocalDateTime.now()) + " and year(fechaVotacion) =  " + año.format(LocalDateTime.now());

            myDb db = new myDb();
            Connection con = db.getcon();
            Statement stmt = con.createStatement();

            ResultSet resultadoConsulta = stmt.executeQuery(sqlCode);

            while (resultadoConsulta.next()) {
                codigoObras[contador] = resultadoConsulta.getString(1);
                contador++;
            }

            for (int i = 0; i < 3; i++) {
                String sqlCode2 = "select nombre,precioBase,imagen,descripcion from obras where codigo=";
                sqlCode2 += codigoObras[i] + ";";
                ResultSet resultadoConsulta2 = stmt.executeQuery(sqlCode2);
                while (resultadoConsulta2.next()) {
                    nombre[i] = resultadoConsulta2.getString(1);
                    precio[i] = resultadoConsulta2.getString(2);
                    url[i] = resultadoConsulta2.getString(3);
                    texto[i] = resultadoConsulta2.getString(4);
                }
            }

            respuesta = nombre[0] + ",," + url[0] + ",," + texto[0] + ",," + precio[0] + ",," + nombre[1] + ",," + url[1] + ",," + texto[1] + ",," + precio[1] + ",," + nombre[2] + ",," + url[2] + ",," + texto[2] + ",," + precio[2];
            out.println(respuesta);
        } catch (SQLException ex) {
            Logger.getLogger(consegirInfoSubastaActual.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getObrasInfo(String[] codigos) {
        try {

            myDb db = new myDb();
            Connection con = db.getcon();
            Statement stmt = con.createStatement();

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(consegirInfoSubastaActual.class.getName()).log(Level.SEVERE, null, ex);
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
