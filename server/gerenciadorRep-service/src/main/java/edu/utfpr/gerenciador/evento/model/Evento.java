package edu.utfpr.gerenciador.evento.model;

import edu.utfpr.gerenciador.republica.model.Republica;
import edu.utfpr.gerenciador.usuario.model.Usuario;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "TB_EVENTO")
@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String descricao;
    private LocalDate dataEvento;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", columnDefinition = "republica_id")
    private Republica republica;

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Republica getRepublica() {
        return republica;
    }

    public void setRepublica(Republica republica) {
        this.republica = republica;
    }
}



