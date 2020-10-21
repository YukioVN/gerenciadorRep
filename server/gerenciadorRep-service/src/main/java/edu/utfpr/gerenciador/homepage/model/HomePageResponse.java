package edu.utfpr.gerenciador.homepage.model;

import edu.utfpr.gerenciador.conta.model.Conta;
import edu.utfpr.gerenciador.evento.model.Evento;
import edu.utfpr.gerenciador.republica.model.Republica;
import edu.utfpr.gerenciador.tarefa.model.Tarefa;

import java.util.List;

public class HomePageResponse {

    private Republica republica;
    private List<Conta> contas;
    private List<Evento> eventos;
    private List<Tarefa> tarefas;

    public Republica getRepublica() {
        return republica;
    }

    public void setRepublica(Republica republica) {
        this.republica = republica;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
}
