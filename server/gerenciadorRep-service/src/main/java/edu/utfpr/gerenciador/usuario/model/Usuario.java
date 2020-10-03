package edu.utfpr.gerenciador.usuario.model;

import edu.utfpr.gerenciador.util.GerenciadorRepUtil;

import javax.persistence.*;

@Table(name = "TB_USUARIO")
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
}