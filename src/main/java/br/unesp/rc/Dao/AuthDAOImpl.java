/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.Dao;

import static br.unesp.rc.Dao.UsuarioDAO.LOGIN_USUARIO;
import br.unesp.rc.Model.associacaoTwitter;
import br.unesp.rc.Model.Usuario;
import br.unesp.rc.Utils.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author marco
 */
public class AuthDAOImpl implements AuthDAO {
    
     public AuthDAOImpl(){
    
    }
    @Override 
    public associacaoTwitter getAuth(Usuario usuario) throws SQLException{
        
        Connection con = null;
        PreparedStatement pstm = null;
        con = FabricaConexao.getConexao();
        associacaoTwitter at = new associacaoTwitter();
        if (con != null) {
            try {
                pstm = con.prepareStatement(AUTH_USER);
                pstm.setString(1, usuario.getNome());
                ResultSet rs = pstm.executeQuery();
                while(rs.next()){
                   at.setApiKey(rs.getString("apiKey"));
                   at.setApiSecretKey(rs.getString("apiSecretKey"));
                   at.setAccessToken(rs.getString("accessToken"));
                   at.setAccessTokenSecret(rs.getString("accessTokenSecret"));
                }
                rs.close();
                pstm.close();
                con.close();
                return at; 
            } catch (SQLException ex) {
                System.out.println("Mensagem: " + ex.getMessage());
            }
        }
        return null;
    }
    
}
