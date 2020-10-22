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

        
        
            String sqlCode= "select * from obras where codigo = 6";
            myDb db = new myDb();
         Connection con = db.getcon();
         Statement stmt;
        try {
            stmt = con.createStatement();
            ResultSet resultadoConsulta1 = stmt.executeQuery(sqlCode);
         String respuesta="";
         
            while (resultadoConsulta1.next()) {
                for(int i=0; i<8;i++){
             respuesta+=resultadoConsulta1.getString(i);
             if(i<7){
                 respuesta+=",";
            }
            }
                
            }
         
            System.out.print(respuesta);
    
        } catch (SQLException ex) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
         

 


         
    }
}
