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
import java.util.Date;
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
@WebServlet(name = "consegirInfoTemporadaActual", urlPatterns = {"/consegirInfoTemporadaActual"})
public class consegirInfoTemporadaActual extends HttpServlet {
        
    
    private int contador= 0;
    private String urlimg1,urlimg2,textoTemporada,respuesta;
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
            /* TODO output your page here. You may use following sample code. */
            String sqlCode="";
            
            DateTimeFormatter mes = DateTimeFormatter.ofPattern("MM"); 
            DateTimeFormatter año = DateTimeFormatter.ofPattern("yyyy");
            sqlCode = "SELECT * FROM `exhibicion` WHERE month(fechaInicio) = " + mes.format(LocalDateTime.now()) + " and year(fechaInicio) =  " + año.format(LocalDateTime.now());
            String datos[]=new String[3];
            String nombreTemporada;
            myDb db = new myDb();
            Connection con = db.getcon();
            Statement stmt = con.createStatement();
           
         
            
            
            ResultSet resultadoConsulta = stmt.executeQuery(sqlCode);
            
            while (resultadoConsulta.next()) {
                datos[0] = resultadoConsulta.getString(1);
                datos[1] = resultadoConsulta.getString(2);
                
                rellenarDatos(datos[0]);
                contador++;
            }
            
            
            nombreTemporada=datos[1]; 
            textoTemporada=consegirDatosDeLaTemporada();
            respuesta=nombreTemporada+"ñ"+urlimg1+"ñ"+urlimg2+"ñ"+textoTemporada;
            
            out.println(respuesta) ;
            con.close();
        }
    }
    private void rellenarDatos(String codigoDeLaObra) throws SQLException
    {
        String url=consegirDatosDeLaObra(codigoDeLaObra);
        if (contador==0) {
            urlimg1 = url;
        }
        if(contador==1)
        {
            urlimg2 = url;
        }
    }
    private String consegirDatosDeLaObra(String codigoDeLaObra) throws SQLException
    {
        myDb db = new myDb();
        String[] datos;
        try (Connection con = db.getcon()) {
            Statement stmt = con.createStatement();
            String sqlCode = "SELECT imagen FROM `obras` WHERE codigo = " + codigoDeLaObra +";" ;
            datos = new String[3];
            ResultSet resultadoConsulta = stmt.executeQuery(sqlCode);
            while (resultadoConsulta.next()) {
                datos[0]  = resultadoConsulta.getString(1);
            }
            con.close();
        }
        return datos[0];
        
    }
    private String consegirDatosDeLaTemporada() throws SQLException
    {
        myDb db = new myDb();
        String[] datos;
        try (Connection con = db.getcon()) {
            Statement stmt = con.createStatement();
            DateTimeFormatter mes = DateTimeFormatter.ofPattern("MM"); 
            DateTimeFormatter año = DateTimeFormatter.ofPattern("yyyy");
            String sqlCode = "SELECT caracteristicas FROM `temporada` WHERE month(fechaInicio) = " + mes.format(LocalDateTime.now()) + " and year(fechaInicio) =  " + año.format(LocalDateTime.now()) ;
            datos = new String[3];
            ResultSet resultadoConsulta = stmt.executeQuery(sqlCode);
            while (resultadoConsulta.next()) {
                datos[0]  = resultadoConsulta.getString(1);
            }
            con.close();
        }
        return datos[0];
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
            Logger.getLogger(consegirInfoTemporadaActual.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(consegirInfoTemporadaActual.class.getName()).log(Level.SEVERE, null, ex);
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
