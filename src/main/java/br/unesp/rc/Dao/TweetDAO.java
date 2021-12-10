/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.Dao;

import br.unesp.rc.Model.Tweet;
import br.unesp.rc.Model.Usuario;
import br.unesp.rc.Model.categoriaTweet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public interface TweetDAO {
    
    final String TWEET_USUARIO
            = "INSERT INTO tweets "
            + "VALUES ( ?, ?, ? ) ";
    
    final String CONSULTAR_TWEET
            = "SELECT idtweet FROM tweets "
            + "WHERE usuario = ? "
            + "ORDER BY dataPostagem ASC";
    
    final String REMOVER_TWEET
            = "DELETE FROM tweets "
            + "WHERE idtweet = ? ";
    
    final String CATEGORIA_TWEET
            = "INSERT into categoria_tweet(codigoCategoria,descricaoCategoria,idTweet) "
            + "VALUES ( ? , ? , ? )";
    
    final String UPDATE_CATEGORIA
            = "UPDATE categoria_tweet SET descricaoCategoria = ? "
            + "WHERE idtweet = ?";
    
    
    

    public abstract boolean salvarTweet(Tweet tweet) throws SQLException;
    public abstract ArrayList<String> consultarTweet(Usuario usuario) throws SQLException;
    public abstract boolean removerTweet(String idtweet) throws SQLException;
    public abstract boolean salvarCategoria(categoriaTweet ct) throws SQLException;
    public abstract boolean updateCategoria(Tweet tweet) throws SQLException;
    
}
