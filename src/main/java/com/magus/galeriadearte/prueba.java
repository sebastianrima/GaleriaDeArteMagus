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
        //prueba no estoy seguro ahora si al servlet 
            String data = "llega la primavera xd,,2020-11-10,,esta temporada se caracteriza por el uso de colores calidos como los amarillos y los sentimientos felices";
            String campos[] = data.split(",,");
            ///prueba el codigo en un metodo de java normal
            String sqlCode = "INSERT INTO temporada(nombre,fechaInicio,caracteristicas) VALUES(\"" + campos[0] + "\",\"" + campos[1] + "\",\"" + campos[2] + "\");";
            myDb db = new myDb();
            Connection con = db.getcon();
            Statement stmt = con.createStatement();

            stmt.executeUpdate(sqlCode);
            System.out.print(sqlCode);
            con.close();
    }
}
