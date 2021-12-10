/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.Dao;


import br.unesp.rc.Model.Usuario;
import br.unesp.rc.Utils.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class FollowDAOImpl implements FollowDAO {
    
    public FollowDAOImpl(){
    
    }
    
    @Override
    public ArrayList getFollowers(Usuario usuario) throws SQLException{
        ArrayList<String> fwers = new ArrayList<String>();    
        Connection con = null;
        PreparedStatement pstm = null;
        con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                pstm = con.prepareStatement(FOLLOW_USUARIO);
                pstm.setString(1, usuario.getNome());
                ResultSet rs = pstm.executeQuery();
                while(rs.next()){
                    fwers.add(rs.getString("Follow"));
                }
                rs.close();
                pstm.close();
                con.close();
                return fwers;
            } catch (SQLException ex) {
                System.out.println("Mensagem: " + ex.getMessage());
            }
        }
        return null;
    }
    
    
    @Override
    public ArrayList getFollowersCategoria(Usuario usuario, String categoria) throws SQLException{
        ArrayList<String> fwers = new ArrayList<String>();    
        Connection con = null;
        PreparedStatement pstm = null;
        con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                pstm = con.prepareStatement(FOLLOW_USUARIO_CATEGORIA);
                pstm.setString(1, usuario.getNome());
                pstm.setString(2, categoria);
                ResultSet rs = pstm.executeQuery();
                while(rs.next()){
                    fwers.add(rs.getString("Follow"));
                }
                rs.close();
                pstm.close();
                con.close();
                return fwers;
            } catch (SQLException ex) {
                System.out.println("Mensagem: " + ex.getMessage());
            }
        }
        return null;
    } 

    
}
