package edu.utfpr.gerenciador.util;

public class DefaultResponse {

    private String codigoErro;
    private String mensagemErro;
    private Object body;

    public String getCodigoErro() {
        return codigoErro;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }

    public void setMensagemErro(String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public void setCodigoErro(String codigoErro) {
        this.codigoErro = codigoErro;
    }
}
