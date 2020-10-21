/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magus.galeriadearte;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Isaac
 */
public class prueba {
    public static void main(String[] args) {
        
            /* TODO output your page here. You may use following sample code. */
//Sacar info de la BD y guardarla en el select
            String sqlCode1 = "SELECT codigoArtista, nombre FROM `artista`";

         myDb db = new myDb();
         Connection con = db.getcon();
         Statement stmt;
        try {
            stmt = con.createStatement();
            ResultSet resultadoConsulta1 = stmt.executeQuery(sqlCode1);
          
           ArrayList<String> listaCodigos = new ArrayList<>();
           ArrayList<String> listaNombres = new ArrayList<>();
           
           while (resultadoConsulta1.next()) {
           listaCodigos.add(resultadoConsulta1.getString("codigoArtista"));
           listaNombres.add(resultadoConsulta1.getString("nombre"));
        }

 
        for(int i=0;i<listaCodigos.size()-1;i++){
            System.out.print(listaCodigos.get(i)+","+listaNombres.get(i)+",");
        }
            System.out.print(listaCodigos.get(listaCodigos.size()-1)+","+listaNombres.get(listaCodigos.size()-1));

        } catch (SQLException ex) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
}
