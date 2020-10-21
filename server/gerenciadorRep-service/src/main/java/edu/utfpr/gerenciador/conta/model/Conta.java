package edu.utfpr.gerenciador.conta.model;

import edu.utfpr.gerenciador.republica.model.Republica;
import edu.utfpr.gerenciador.usuario.model.Usuario;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "TB_CONTA")
@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String descricao;
    private LocalDate dataVencimento;
    private Double valorDespesa;
    private Integer numeroPessoasParaRateiro;
    private Double valorPorPessoa;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", columnDefinition = "republica_id")
    private Republica republica;

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

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Double getValorDespesa() {
        return valorDespesa;
    }

    public void setValorDespesa(Double valorDespesa) {
        this.valorDespesa = valorDespesa;
    }

    public Double getValorPorPessoa() {
        return valorPorPessoa;
    }

    public void setValorPorPessoa(Double valorPorPessoa) {
        this.valorPorPessoa = valorPorPessoa;
    }

    public Integer getNumeroPessoasParaRateiro() {
        return numeroPessoasParaRateiro;
    }

    public void setNumeroPessoasParaRateiro(Integer numeroPessoasParaRateiro) {
        this.numeroPessoasParaRateiro = numeroPessoasParaRateiro;
    }

    public Republica getRepublica() {
        return republica;
    }

    public void setRepublica(Republica republica) {
        this.republica = republica;
    }

}
