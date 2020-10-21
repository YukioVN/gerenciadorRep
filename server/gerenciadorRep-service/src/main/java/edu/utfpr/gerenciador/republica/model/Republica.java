package edu.utfpr.gerenciador.republica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.utfpr.gerenciador.conta.model.Conta;
import edu.utfpr.gerenciador.evento.model.Evento;
import edu.utfpr.gerenciador.tarefa.model.Tarefa;
import edu.utfpr.gerenciador.usuario.model.Usuario;
import org.springframework.data.repository.cdi.Eager;

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
    private double valorEmCaixa;

    @OneToMany(mappedBy = "republica", fetch = FetchType.EAGER)
    private List<Usuario> moradores;

    @JsonIgnore
    @OneToMany(mappedBy = "republica")
    private List<Tarefa> tarefas;

    @JsonIgnore
    @OneToMany(mappedBy = "republica")
    private List<Conta> contas;

    @JsonIgnore
    @OneToMany(mappedBy = "republica")
    private List<Evento> eventos;

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

    public double getValorEmCaixa() {
        return valorEmCaixa;
    }

    public void setValorEmCaixa(double valorEmCaixa) {
        this.valorEmCaixa = valorEmCaixa;
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

    public List<Conta> getContas() {
        if (contas == null){
            contas = new ArrayList<>();
        }
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public List<Evento> getEventos() {
        if (eventos == null){
            eventos = new ArrayList<>();
        }
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
}