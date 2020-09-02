package edu.utfpr.gerenciador.usuario.model;

import edu.utfpr.gerenciador.usuario.util.GerenciadorRepUtil;

import java.util.concurrent.atomic.AtomicLong;

public class Usuario {

    private final long id;
    private String nome;
    private String sobrenome;
    private String apelido;
    private String email;

    public Usuario(){
        // Construtor default
        this.id = GerenciadorRepUtil.novoId();
    }

    public Usuario(long id, String nome, String sobrenome, String apelido, String email) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.apelido = apelido;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(){
        this.apelido = apelido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}