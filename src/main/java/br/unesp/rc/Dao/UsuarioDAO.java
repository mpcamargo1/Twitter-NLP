/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.Dao;

import br.unesp.rc.Model.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public interface UsuarioDAO {
    
    final String LOGIN_USUARIO
            = "SELECT login,senha FROM usuario "
            + "WHERE login = ? and senha = ?";
   
    final String DADOS_USUARIO
            = "SELECT nome,idade,telefone,cidade from usuario "
            + "WHERE login = ?";
    
    final String DADOS_RESPONSAVEL
            = "SELECT Nome from responsavel "
            + " WHERE login = ?";
    
    final String DADOS_CATEGORIA
            = "SELECT descricaoCategoria from categoria_usuario "
            + "WHERE login = ?";

    public abstract boolean login(Usuario usuario) throws SQLException;
    public abstract String getResponsavel(Usuario usuario) throws SQLException;
    public abstract String getCategoria(Usuario usuario) throws SQLException;
    public abstract ArrayList<String> getDados(Usuario usuario) throws SQLException;
    
    
    
}
