/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.Dao;

import br.unesp.rc.Model.Emocao;
import br.unesp.rc.Model.Tweet;
import br.unesp.rc.Utils.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author marco
 */
public class EmocaoDAOImpl implements EmocaoDAO {
    
    
    public EmocaoDAOImpl(){
    
    }
    
    @Override
    public boolean salvar(Emocao emocao)throws SQLException{
        
          Connection con = null;
        PreparedStatement pstm = null;
        con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                pstm = con.prepareStatement(INSERT_EMOCAO);
                pstm.setString(1, emocao.getUsuario());
                pstm.setLong(2, emocao.getTweet());
                pstm.setString(3, emocao.getEmoçao());
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
    public String consultarEmocao(Tweet tweet) throws SQLException{
        Connection con = null;
        PreparedStatement pstm = null;
        con = FabricaConexao.getConexao();
        String result = null;
        if (con != null) {
            try {
                pstm = con.prepareStatement(CONSULTAR_EMOCAO);
                pstm.setLong(1, tweet.getIdMensagem());
                ResultSet rs = pstm.executeQuery();
                while(rs.next()){
                    result = rs.getString("emocao");
                }
                rs.close();
                pstm.close();
                con.close();
                return result;
            } catch (SQLException ex) {
                System.out.println("Mensagem: " + ex.getMessage());
            }
        }    
        return result;
    }
    
}
