/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.Model;

import java.util.Date;

/**
 *
 * @author Raphael
 */
public class Tweet {
    
    public categoriaTweet ct;
    public denunciaTweet dt;
    public Emocao emocao;
    private Usuario usuario;
    private Date dataPostagem;
    private long idMensagem;

    public categoriaTweet getCategoria(){
        return this.ct;
    }
    
    public void setCategoriaTweet(categoriaTweet categoria){
        this.ct = categoria;
    }
    
    public denunciaTweet getdenunciaTweet(){
        return this.dt;
    }
    
    public void setDenunciaTweet(denunciaTweet dt){
        this.dt = dt;
    }
    
    public Emocao getEmocao(){
        return this.emocao;
    }
    
    public void setEmocao(Emocao emocao){
        this.emocao = emocao;
    }
    
    public Usuario getUsuario(){
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    
    
    public Date getMomentoPostagem() {
        return dataPostagem;
    }

    public void setMomentoPostagem(Date momentoPostagem) {
        this.dataPostagem = momentoPostagem;
    }
  
    public long getIdMensagem() {
        return idMensagem;
    }

    public void setIdMensagem(long idMensagem) {
        this.idMensagem = idMensagem;
    }
   

}
