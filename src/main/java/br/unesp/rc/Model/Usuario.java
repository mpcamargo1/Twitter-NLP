/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.Model;

/**
 *
 * @author marco
 */
public class Usuario {
    
    private associacaoTwitter at;
    private Responsavel responsavel;
    private categoriaUsuario catuser;
    
    private String nome;
    private String senha;
    private String login;
    private Integer idade;
    private String telefone;
    private String cidade;
    
    public Usuario() {
    }
    
    public associacaoTwitter getAt(){
        return this.at;
    }
    public void setAt(associacaoTwitter at){
        this.at = at;
    }
    
    public Responsavel getResponsavel(){
        return this.responsavel;
    }
    public void setResponsavel(Responsavel responsavel){
        this.responsavel = responsavel;
    }
    
    public categoriaUsuario getCategoria(){
        return this.catuser;
    }
    public void setResponsavel(categoriaUsuario cat){
        this.catuser = cat;
    }
    

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
  
}
