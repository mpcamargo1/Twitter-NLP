/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.Dao;

import br.unesp.rc.Model.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public interface FollowDAO {
    
     final String FOLLOW_USUARIO
            = "SELECT Follow FROM usuario inner join follow "
            + "WHERE login = Me and login = ? "
            + "ORDER BY Follow ASC"; 
     
     final String FOLLOW_USUARIO_CATEGORIA
            = "SELECT Follow FROM follow inner join categoria_usuario "
            + "WHERE follow.Follow = categoria_usuario.login "
            + "and Me = ? and descricaoCategoria = ? "
            + "ORDER BY Follow ASC";

    public abstract ArrayList getFollowers(Usuario usuario) throws SQLException;
    public abstract ArrayList getFollowersCategoria(Usuario usuario, String Categoria) throws SQLException;
    
    
    
}
