/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.Model;

/**
 *
 * @author Raphael
 */
public class Emocao {
    private String usuario;
    private long tweet;
    private String emoçao;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public long getTweet() {
        return tweet;
    }

    public void setTweet(long tweet) {
        this.tweet = tweet;
    }

    public String getEmoçao() {
        return emoçao;
    }

    public void setEmoçao(String emoçao) {
        this.emoçao = emoçao;
    }

    
    
}
