/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author marco
 */
public class FabricaConexao implements IMySQL{
    
    private FabricaConexao() {
         
    }
     
    public static Connection getConexao() {
        Connection con = null;

        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Mensagem: " + ex.getMessage());
        }

        return con;
    }

    public static boolean fechar(Connection con) {
        boolean b = false;
        if (con != null) {
            try {
                con.close();
                b = true;
            } catch (SQLException ex) {
                System.out.println("Mensagem: " + ex.getMessage());
            }
        }        
        return b;
    }
    
}
