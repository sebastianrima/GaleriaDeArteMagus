/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.magus.galeriadearte;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nicolas
 */
@WebServlet(name="nuevaObraServlet", urlPatterns={"/nuevaObraServlet"})
public class nuevaObraServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
//Sacar info de la BD y guardarla en el select
            String squlCode1 = "SELECT * FROM `obras`";

           myDb db = new myDb();
           Connection con = db.getcon();
           Statement stmt = con.createStatement();
           ResultSet resultadoConsulta = stmt.executeQuery(sqlCode);
            
            while (resultadoConsulta.next()) {
            ArrayList<String> lista= new Arraylist<String>();
            lista.add(resultadoConsulta.getString(1)+","+resultadoConsulta.getString(2));
}


//Sacar la info de los campos del HTML y guardarla en la BD
            String data = request.getParameter("data");
            String campos[] = data.split(",");
            String sqlCode = "INSERT INTO obra(codigo,nombre,descripcion,precioBase,fecha,tipo,color,emocion,tematica,movimiento,url,codArtista,codObra) VALUES(";
 

        for (int i=0 ; i<campos.length-1;i++){
                sqlCode+="\""+campos[i]+"\",";
            }
      
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
