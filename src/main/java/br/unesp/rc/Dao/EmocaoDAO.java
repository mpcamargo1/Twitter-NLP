/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.Dao;

import br.unesp.rc.Model.Emocao;
import br.unesp.rc.Model.Tweet;
import br.unesp.rc.Model.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public interface EmocaoDAO {
    
     final String INSERT_EMOCAO
            = "INSERT into emocao (usuario,tweet,emocao) "
            + "VALUES ( ? , ? , ? )";
    
     final String CONSULTAR_EMOCAO
             ="SELECT emocao from emocao "
             +"WHERE tweet= ?";
     
    public abstract boolean salvar(Emocao emocao) throws SQLException;    
    public abstract String consultarEmocao(Tweet tweet) throws SQLException;
}
