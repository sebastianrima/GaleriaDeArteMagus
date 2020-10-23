/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magus.galeriadearte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Isaac
 */
public class myDb {

    Connection con;

    public Connection getcon() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            if (this.con == null) {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lagaleriadeartemaguri?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(myDb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(myDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
