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
            String data = "Hombre de Vitruvio,,1500000,,https://upload.wikimedia.org/wikipedia/commons/thumb/f/f1/Vitruvian_Man_by_Leonardo_da_Vinci.jpg/245px-Vitruvian_Man_by_Leonardo_da_Vinci.jpg,,1492-05-14,,1,,gris,,felicidad,,cuerpo humano,,renacimiento,,El Hombre de Vitruvio o Estudio de las proporciones ideales del cuerpo humano es un famoso dibujo acompañado de notas anatómicas de Leonardo da Vinci realizado alrededor de 1490 en uno de sus diarios. Representa una figura masculina desnuda en dos posiciones sobreimpresas de brazos y piernas e inscrita en una circunferencia y un cuadrado (Ad quadratum). Se trata de un estudio de las proporciones del cuerpo humano, realizado a partir de los textos de arquitectura de Vitruvio, arquitecto de la antigua Roma, del cual el dibujo toma su nombre.,,2";
            String campos[] = data.split(",,");
            String sqlCode = "INSERT INTO obras(nombre,precioBase,imagen,fechaCreacion,pintura,color,emocion ,tematica,movimiento,descripcion,codigoArtista) VALUES(\""+ campos[0]+"\","+campos[1]+",\""+campos[2]+"\",\""+campos[3]+"\","+campos[4]+",\""+campos[5]+"\",\""+campos[6]+"\",\""+campos[7]+"\",\""+campos[8]+"\",\""+campos[9]+"\""+campos[10]+");";
           
            
            
            
            System.out.print(sqlCode);
        
    }
}
