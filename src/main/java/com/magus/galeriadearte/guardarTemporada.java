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
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "guardarTemporada", urlPatterns = {"/guardarTemporada"})
public class guardarTemporada extends HttpServlet {

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
            String data = request.getParameter("data");
            String color = request.getParameter("color");
            String campos[] = data.split(",,");
            ///prueba el codigo en un metodo de java normal
            String sqlCode = "INSERT INTO temporada(nombre,fechaInicio,caracteristicas) VALUES(\"" + campos[0] + "\",\"" + campos[1] + "\",\"" + campos[2] + "\");";
            myDb db = new myDb();
            Connection con = db.getcon();
            Statement stmt = con.createStatement();

            stmt.executeUpdate(sqlCode);
            out.print(sqlCode);
            con.close();
            agreagarObras(color,campos[0],campos[1]);
        } catch (SQLException ex) {
            Logger.getLogger(guardarObra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void agreagarObras(String color,String nombre,String fecha) {
        String sql = "select * from Obras where color= \"" + color + "\";";
        myDb db = new myDb();
        Connection con = db.getcon();
        Statement stmt;
        try {
            stmt = con.createStatement();
            ResultSet resultadoConsulta1 = stmt.executeQuery(sql);
            List codigos = new ArrayList<>();
            while (resultadoConsulta1.next()) {
                codigos.add(resultadoConsulta1.getString(1));
            }
            
            for (int i =0;i<codigos.size();i++) {
                String sql1 = "INSERT INTO exhibicion(codigoDeLaObra,nombreTemporada,fechaInicio) VALUES(\""+codigos.get(i)+"\", '"+nombre+"', '"+fecha+"');";
                stmt.executeUpdate(sql1);

            }
        
        } catch (SQLException ex) {
            Logger.getLogger(guardarTemporada.class.getName()).log(Level.SEVERE, null, ex);
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
