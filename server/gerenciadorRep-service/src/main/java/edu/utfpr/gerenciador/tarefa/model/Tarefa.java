package edu.utfpr.gerenciador.tarefa.model;

import edu.utfpr.gerenciador.republica.model.Republica;
import edu.utfpr.gerenciador.usuario.model.Usuario;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "TB_TAREFA")
@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String descricao;
    private LocalDate dataLimite;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", columnDefinition = "republica_id")
    private Republica republica;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", columnDefinition = "usuario_id")
    private Usuario usuarioDesignado;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(LocalDate dataLimite) {
        this.dataLimite = dataLimite;
    }

    public Republica getRepublica() {
        return republica;
    }

    public void setRepublica(Republica republica) {
        this.republica = republica;
    }

    public Usuario getUsuarioDesignado() {
        return usuarioDesignado;
    }

    public void setUsuarioDesignado(Usuario usuarioDesignado) {
        this.usuarioDesignado = usuarioDesignado;
    }
}
