/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.Dao;

import br.unesp.rc.Model.Tweet;
import java.sql.SQLException;

/**
 *
 * @author marco
 */
public interface DenunciaDAO {
    
    
    final String INSERT_DENUNCIA
            = "INSERT into denuncia_tweet (motivo,idtweet) "
            + "VALUES ( ?, ? )";
    
    public abstract boolean addDenuncia(Tweet tweet) throws SQLException;
    
}
