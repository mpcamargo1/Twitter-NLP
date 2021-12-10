/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.Dao;

import br.unesp.rc.Model.associacaoTwitter;
import br.unesp.rc.Model.Usuario;
import java.sql.SQLException;

/**
 *
 * @author marco
 */
public interface AuthDAO {
    
     final String AUTH_USER
            = "SELECT apiKey,apiSecretKey,accessToken,accessTokenSecret FROM associacao_twitter "
            + "WHERE login = ? ";

    
    public abstract associacaoTwitter getAuth(Usuario usuario) throws SQLException;
    
    
    
}
