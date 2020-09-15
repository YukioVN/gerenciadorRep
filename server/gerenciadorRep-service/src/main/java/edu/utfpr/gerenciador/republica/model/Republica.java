package edu.utfpr.gerenciador.republica.model;

import edu.utfpr.gerenciador.util.GerenciadorRepUtil;

public class Republica {

    private final long id;
    private String nome;
    private String sobrenome;
    private String apelido;
    private String email;

    public Republica(){
        // Construtor default
        this.id = GerenciadorRepUtil.novoId();
    }

    public Republica(long id, String nome, String sobrenome, String apelido, String email) {
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

    public void setApelido(String apelido){
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