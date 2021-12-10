/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.Dao;

import br.unesp.rc.Model.Tweet;
import br.unesp.rc.Utils.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author marco
 */
public class DenunciaDAOImpl implements DenunciaDAO {
    
    @Override
    public boolean addDenuncia(Tweet tweet) throws SQLException{
        
        Connection con = null;
        PreparedStatement pstm = null;
        con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                pstm = con.prepareStatement(INSERT_DENUNCIA);
                pstm.setString(1, tweet.getdenunciaTweet().getMotivo());
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
