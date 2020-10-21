package edu.utfpr.gerenciador.republica.model;

import edu.utfpr.gerenciador.tarefa.model.Tarefa;
import edu.utfpr.gerenciador.usuario.model.Usuario;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "TB_REPUBLICA")
@Entity
public class Republica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String rua;
    private int numero;
    private String cep;
    @OneToMany(mappedBy = "republica")
    private List<Usuario> moradores;

    @OneToMany(mappedBy = "republica")
    private List<Tarefa> tarefas;


    public Republica(){
        // Construtor default
    }

    public Republica(long id, String nome, String rua, int numero, String cep) {
        this.id = id;
        this.nome = nome;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public List<Usuario> getMoradores() {
        if (moradores == null){
            moradores = new ArrayList<>();
        }
        return moradores;
    }

    public void setMoradores(List<Usuario> moradores) {
        this.moradores = moradores;
    }

    public List<Tarefa> getTarefas() {
        if (tarefas == null){
            tarefas = new ArrayList<>();
        }
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
}