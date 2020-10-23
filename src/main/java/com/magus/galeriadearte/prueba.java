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
            String codigo = "4";
            String user = "ihy";
            String codigoUser="";
            String sqlCode1 = "select codigoCliente from clientes where usuario =\""+user+"\";";
            
                
            myDb db = new myDb();
            Connection con = db.getcon();
            Statement stmt = con.createStatement();
            
            ResultSet resultadoConsulta = stmt.executeQuery(sqlCode1);
            while (resultadoConsulta.next()) {
                codigoUser = resultadoConsulta.getString(1);
            }
            
            String sqlCode2 = "UPDATE obras  SET codigoCliente = "+codigoUser+ " WHERE obras.codigo="+codigo+";";
            stmt.executeUpdate(sqlCode2);
            
            
            
            System.out.print("Obra comprada con exito!!!");
            con.close();
        
    }
}
