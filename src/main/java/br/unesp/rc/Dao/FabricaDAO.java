/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.Dao;

/**
 *
 * @author marco
 */
public class FabricaDAO {
    
      private FabricaDAO() {

    }

    public static UsuarioDAO getUsuarioDAO() {
        return new UsuarioDAOImpl();
    }
    
    public static TweetDAO getTweetDAO() {
        return new TweetDAOImpl();
    }
    
    public static AuthDAO getOAuthDAO() {
        return new AuthDAOImpl();
    }
    
    public static FollowDAO getFollowDAO(){
        return new FollowDAOImpl();
    }
    
    public static EmocaoDAO getEmocaoDAO(){
        return new EmocaoDAOImpl();
    }
    
    public static DenunciaDAO getDenunciaDAO(){
        return new DenunciaDAOImpl();
    }
}
