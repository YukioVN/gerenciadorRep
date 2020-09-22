package edu.utfpr.gerenciador.usuario.model;

import edu.utfpr.gerenciador.util.GerenciadorRepUtil;

@Entity
public class Usuario {

    private final long id;
    private String nomeCompleto;
    private String apelido;
    private String email;

    public Usuario(){
        // Construtor default
        this.id = GerenciadorRepUtil.novoId();
    }

    public Usuario(long id, String nomeCompleto, String apelido, String email) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.apelido = apelido;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido){
        this.apelido = apelido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nomeCompleto;
    }

    public void setNome(String nome) {
        this.nomeCompleto = nomeCompleto;
    }
}