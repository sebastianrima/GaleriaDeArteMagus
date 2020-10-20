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
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
            String sqlCode="";
            String[] codigoObras = new String[3];
            int contador=0;
            String nombreImg1,urlimg1,textoImg1,precioImg1,nombreImg2,urlimg2,textoImg2,precioImg2,nombreImg3,urlimg3,textoImg3,precioImg3,respuesta;
            DateTimeFormatter mes = DateTimeFormatter.ofPattern("MM"); 
            DateTimeFormatter año = DateTimeFormatter.ofPattern("yyyy");
            sqlCode = "SELECT  codigoObra FROM `votando` WHERE  month(fechaVotacion) = " + mes.format(LocalDateTime.now()) + " and year(fechaVotacion) =  " + año.format(LocalDateTime.now()) ;
            String sqlCode2="select * from obras where codigo=";
            
            myDb db = new myDb();
            Connection con = db.getcon();
            Statement stmt = con.createStatement();
           
         
            
            
            ResultSet resultadoConsulta = stmt.executeQuery(sqlCode);
            
            while (resultadoConsulta.next()) {
                codigoObras[0]  = resultadoConsulta.getString(1);
                codigoObras[1]= resultadoConsulta.getString(2);
                contador
            }
            
            
            nombreImg1="La Monalisa"; 
            urlimg1="https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Leonardo_da_Vinci_-_Mona_Lisa_%28Louvre%2C_Paris%29.jpg/368px-Leonardo_da_Vinci_-_Mona_Lisa_%28Louvre%2C_Paris%29.jpg";
            textoImg1="El Retrato de Lisa Gherardini, esposa de Francesco del Giocondo, ​ más conocido como La Gioconda o La Mona Lisa, es una obra pictórica del polímata renacentista italiano Leonardo da Vinci. Fue adquirida por el rey Francisco I de Francia a comienzos del siglo XVI y desde entonces es propiedad del Estado francés.";
            precioImg1="PRECIO BASE: COP $2.883.662";
            nombreImg2="La Monalisa"; 
            urlimg2="https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Leonardo_da_Vinci_-_Mona_Lisa_%28Louvre%2C_Paris%29.jpg/368px-Leonardo_da_Vinci_-_Mona_Lisa_%28Louvre%2C_Paris%29.jpg";
            textoImg2="El Retrato de Lisa Gherardini, esposa de Francesco del Giocondo, ​ más conocido como La Gioconda o La Mona Lisa, es una obra pictórica del polímata renacentista italiano Leonardo da Vinci. Fue adquirida por el rey Francisco I de Francia a comienzos del siglo XVI y desde entonces es propiedad del Estado francés.";
            precioImg2="PRECIO BASE: COP $2.883.662";
            nombreImg3="La Monalisa"; 
            urlimg3="https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Leonardo_da_Vinci_-_Mona_Lisa_%28Louvre%2C_Paris%29.jpg/368px-Leonardo_da_Vinci_-_Mona_Lisa_%28Louvre%2C_Paris%29.jpg";
            textoImg3="El Retrato de Lisa Gherardini, esposa de Francesco del Giocondo, ​ más conocido como La Gioconda o La Mona Lisa, es una obra pictórica del polímata renacentista italiano Leonardo da Vinci. Fue adquirida por el rey Francisco I de Francia a comienzos del siglo XVI y desde entonces es propiedad del Estado francés.";
            precioImg3="PRECIO BASE: COP $2.883.662";
            
            respuesta=nombreImg1+"ñ"+urlimg1+"ñ"+textoImg1+"ñ"+precioImg1+"ñ"+nombreImg2+"ñ"+urlimg2+"ñ"+textoImg2+"ñ"+precioImg2+"ñ"+nombreImg3+"ñ"+urlimg3+"ñ"+textoImg3+"ñ"+precioImg3;
            out.println(respuesta) ;
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
