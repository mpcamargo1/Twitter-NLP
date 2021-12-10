/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.Utils;

/**
 *
 * @author marcos
 */
public interface IMySQL {
    
    
    final String USER = "marcos";
    
    final String PASS = "root";
    
    //Version 5.0
    //final String URL = "jdbc:mysql://localhost:3306/livroapp;
    final String URL = "jdbc:mysql://localhost:8084/bd_acb?useTimezone=true&serverTimezone=UTC&useSSL=false";
    
    //final String Driver = "org.gjt.mm.mysql.Driver";
    final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
}
