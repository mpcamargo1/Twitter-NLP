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
public class UsuarioDAOImpl implements UsuarioDAO {
    
    public UsuarioDAOImpl(){
    
    }
    @Override 
    public boolean login(Usuario usuario) throws SQLException{
        
        Connection con = null;
        PreparedStatement pstm = null;
        con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                pstm = con.prepareStatement(LOGIN_USUARIO);
                pstm.setString(1, usuario.getNome());
                pstm.setString(2, usuario.getSenha());
                ResultSet rs = pstm.executeQuery();
                while(rs.next()){
                    return true;
                }
                rs.close();
                pstm.close();
                con.close();
            } catch (SQLException ex) {
                System.out.println("Mensagem: " + ex.getMessage());
            }
        }
        return false;
  }
    @Override
    public String getResponsavel(Usuario usuario) throws SQLException{
        Connection con = null;
        PreparedStatement pstm = null;
        con = FabricaConexao.getConexao();
        String result = null;
        if (con != null) {
            try {
                pstm = con.prepareStatement(DADOS_RESPONSAVEL);
                pstm.setString(1, usuario.getNome());
                ResultSet rs = pstm.executeQuery();          
                if(rs != null && rs.next()){
                return rs.getString("Nome");
            }
            } catch (SQLException ex) {
                System.out.println("Mensagem: " + ex.getMessage());
            }
        }    
        return result;
      }
    @Override
    public String getCategoria(Usuario usuario) throws SQLException{
        Connection con = null;
        PreparedStatement pstm = null;
        con = FabricaConexao.getConexao();
        String result = null;
        if (con != null) {
            try {
                pstm = con.prepareStatement(DADOS_CATEGORIA);
                pstm.setString(1, usuario.getNome());
                ResultSet rs = pstm.executeQuery();          
                if(rs != null && rs.next()){
                return rs.getString("descricaoCategoria");
            }
            } catch (SQLException ex) {
                System.out.println("Mensagem: " + ex.getMessage());
            }
        }    
        return result;
      }
     @Override
    public ArrayList<String> getDados(Usuario usuario) throws SQLException{
        ArrayList<String> dados = new ArrayList<String>();
        Connection con = null;
        PreparedStatement pstm = null;
        con = FabricaConexao.getConexao();
        String result = null;
        if (con != null) {
            try {
                pstm = con.prepareStatement(DADOS_USUARIO);
                pstm.setString(1, usuario.getNome());
                ResultSet rs = pstm.executeQuery();          
                while(rs.next()){
                   dados.add(rs.getString("nome"));
                   dados.add(rs.getString("idade"));
                   dados.add(rs.getString("telefone"));
                   dados.add(rs.getString("cidade"));
                 }
                return dados;
            } catch (SQLException ex) {
                System.out.println("Mensagem: " + ex.getMessage());
            }
        }    
        return null;
      }
}
