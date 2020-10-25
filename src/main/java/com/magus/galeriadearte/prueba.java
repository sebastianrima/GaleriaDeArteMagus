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
        String codigo = "3";
            String sqlCode = "SELECT COUNT(*) FROM `obras` WHERE codigoArtista =" + codigo;
            myDb db = new myDb();
            Connection con = db.getcon();
            Statement stmt = con.createStatement();
            String respuesta = "";
            ResultSet resultadoConsulta = stmt.executeQuery(sqlCode);
            while (resultadoConsulta.next()) {
                respuesta += resultadoConsulta.getString(1);
            }
            con.close();
            System.out.print(respuesta);
    }
}
