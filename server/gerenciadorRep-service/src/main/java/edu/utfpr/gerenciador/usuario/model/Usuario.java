package edu.utfpr.gerenciador.usuario.model;

import edu.utfpr.gerenciador.republica.model.Republica;
import edu.utfpr.gerenciador.tarefa.model.Tarefa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "TB_USUARIO")
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeCompleto;
    private String apelido;
    private String email;
    private Perfil perfil;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", columnDefinition = "republica_id")
    private Republica republica;

    @OneToMany(mappedBy = "usuarioDesignado")
    private List<Tarefa> tarefas;

    public Usuario(){
        // Construtor default
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

    public Republica getRepublica() {
        return republica;
    }

    public void setRepublica(Republica republica) {
        this.republica = republica;
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