/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.Dao;

import br.unesp.rc.Model.Tweet;
import br.unesp.rc.Model.Usuario;
import br.unesp.rc.Model.categoriaTweet;
import br.unesp.rc.Utils.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Raphael
 */
public class TweetDAOImpl implements TweetDAO{
    
    
    @Override
    public boolean salvarTweet(Tweet tweet) throws SQLException{
       
        java.sql.Date sqlDate = new java.sql.Date(tweet.getMomentoPostagem().getTime());
        
        Connection con = null;
        PreparedStatement pstm = null;
        con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                pstm = con.prepareStatement(TWEET_USUARIO);
                pstm.setLong(1, tweet.getIdMensagem());
                pstm.setString(2, tweet.getUsuario().getNome());
                pstm.setDate(3, sqlDate);
                pstm.executeUpdate();
                pstm.close();
                con.close();
                return true;
            } catch (SQLException ex) {
                System.out.println("Mensagem: " + ex.getMessage());
            }
        }
        return false;
  }
    @Override
    public ArrayList<String> consultarTweet(Usuario usuario) throws SQLException{
        Connection con = null;
        PreparedStatement pstm = null;
        con = FabricaConexao.getConexao();
        ArrayList<String> ListaTweet = new ArrayList<String>();
        if (con != null) {
            try {
                pstm = con.prepareStatement(CONSULTAR_TWEET);
                pstm.setString(1, usuario.getNome());
                ResultSet rs = pstm.executeQuery();
                while(rs.next()){
                    ListaTweet.add(rs.getString("idtweet"));
                }
                rs.close();
                pstm.close();
                con.close();
                return ListaTweet;
               
            } catch (SQLException ex) {
                System.out.println("Mensagem: " + ex.getMessage());
            }
        }
        return null;
    }
    @Override
    public boolean removerTweet(String idtweet) throws SQLException{
        
        Connection con = null;
        PreparedStatement pstm = null;
        con = FabricaConexao.getConexao();
        
        if (con != null) {
            try {
                pstm = con.prepareStatement(REMOVER_TWEET);
                pstm.setString(1, idtweet);
                pstm.executeUpdate();
                pstm.close();
                con.close();
                return true;
            } catch (SQLException ex) {
                System.out.println("Mensagem: " + ex.getMessage());
            }
        }
        return false;
    }
    
    @Override
    public boolean salvarCategoria(categoriaTweet ct)throws SQLException{
         Connection con = null;
        PreparedStatement pstm = null;
        con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                pstm = con.prepareStatement(CATEGORIA_TWEET);
                pstm.setString(1, ct.getCodigoCategoria());
                pstm.setString(2, ct.getDescricaoCategoria());
                pstm.setLong(3, ct.getIdTweet());
                pstm.executeUpdate();
                pstm.close();
                con.close();
                return true;
            } catch (SQLException ex) {
                System.out.println("Mensagem: " + ex.getMessage());
            }
        }
        return false;
    
    }
    
    @Override
    public boolean updateCategoria(Tweet tweet) throws SQLException{
    Connection con = null;
        PreparedStatement pstm = null;
        con = FabricaConexao.getConexao();
        
        if (con != null) {
            try {
                pstm = con.prepareStatement(UPDATE_CATEGORIA);
                pstm.setString(1, "Tweet em verificação");
                pstm.setLong(2, tweet.getIdMensagem());
                pstm.executeUpdate();
                pstm.close();
                con.close();
                return true;
            } catch (SQLException ex) {
                System.out.println("Mensagem: " + ex.getMessage());
            }
        }
        return false;
    }
}
