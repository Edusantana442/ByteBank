package br.com.bytebank.observer;

public class NotificacaoSMS implements ObservadorConta {

    @Override
    public void atualizar(String mensagem) {
        System.out.println("[SMS] " + mensagem);
    }
}
