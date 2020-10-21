package edu.utfpr.gerenciador.republica.model;

public class CaixinhaRequest {

    private Operacao operacao;
    private double valorOperacao;

    public Operacao getOperacao() {
        return operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    public double getValorOperacao() {
        return valorOperacao;
    }

    public void setValorOperacao(double valorOperacao) {
        this.valorOperacao = valorOperacao;
    }

    public enum Operacao{
        SOMAR, SUBTRAIR;
    }

}