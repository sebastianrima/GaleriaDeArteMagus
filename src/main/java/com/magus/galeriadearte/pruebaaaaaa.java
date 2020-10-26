/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magus.galeriadearte;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Isaac
 */
public class pruebaaaaaa {
    public static void main(String[] args) throws SQLException {
        String codigo = "29";
            String codigoArtista = "1";
            String sqlCode = "";
            String nombreArtista = "";
            String tituloObra = null, descripcion = null, codigoCliente = null, codigoAutor = null, precioBaseObra = null, fechaCreacion = null, tipo = null, color = null, emocion = null, tematica = null, movimiento = null, obraPicture = null, respuesta;
            sqlCode = "SELECT * FROM `obras` WHERE obras.codigo = " + codigo;

            myDb db = new myDb();
            Connection con = db.getcon();
            Statement stmt = con.createStatement();
            movimiento = " ";
            ResultSet resultadoConsulta = stmt.executeQuery(sqlCode);

            while (resultadoConsulta.next()) {
                tituloObra = resultadoConsulta.getString(2);
                precioBaseObra = resultadoConsulta.getString(3);
                obraPicture = resultadoConsulta.getString(4);
                fechaCreacion = resultadoConsulta.getString(5);
                tipo = resultadoConsulta.getString(6);
                color = resultadoConsulta.getString(7);
                emocion = resultadoConsulta.getString(8);
                tematica = resultadoConsulta.getString(9);
                movimiento = resultadoConsulta.getString(10);
                descripcion = resultadoConsulta.getString(11);
                codigoCliente = resultadoConsulta.getString(12);
                codigoAutor = resultadoConsulta.getString(13);
            }
            ResultSet resultadoConsulta2 = stmt.executeQuery("SELECT nombre FROM artista WHERE artista.codigoArtista=" + codigoArtista);

            while (resultadoConsulta2.next()) {
                nombreArtista = resultadoConsulta2.getString(1);
            }
            
            respuesta = tituloObra + ",," + descripcion + ",," + precioBaseObra + ",,"
                    + fechaCreacion + ",," + tipo + ",," + color + ",," + emocion + ",,"
                    + tematica + ",," + movimiento + ",," + obraPicture + ",," + nombreArtista+ ",," + codigoCliente+ ",," + codigoAutor;
            con.close();
            System.out.println(respuesta);
    }
}
