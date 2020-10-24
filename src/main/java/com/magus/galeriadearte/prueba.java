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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Isaac
 */
public class prueba {
    
    public static void main(String[] args) throws SQLException {
            String codigoObra = "4";
           String usuario = "ihy";
             String sql = "update votando set votos=votos+1 where codigoObra="+codigoObra;
           String sql1 = "update clientes set  fechaUltimaVotacion = current_date() where usuario=\""+usuario+"\"";
           String fecha="";
           String busqueda = "select month(fechaUltimaVotacion),year(fechaUltimaVotacion) from clientes where usuario=\""+usuario+"\";";
           DateTimeFormatter mes = DateTimeFormatter.ofPattern("MM");
           DateTimeFormatter año = DateTimeFormatter.ofPattern("yyyy");
           DateTimeFormatter dia = DateTimeFormatter.ofPattern("dd");
           String mesUltima="";
           String añoUltima="";
           
           
           
           System.out.print(dia.format(LocalDateTime.now()));
           
           
           
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
                System.out.print("Has votado correctamente");
           }else
           {
               if(mes.format(LocalDateTime.now()).equals(mesUltima) && año.format(LocalDateTime.now()).equals(añoUltima))
                   System.out.print("false");
                 
               else
               {
                   System.out.print("votar");
               }
           }
    }
}
