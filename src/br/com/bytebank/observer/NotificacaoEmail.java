package br.com.bytebank.observer;

public class NotificacaoEmail implements ObservadorConta {

    @Override
    public void atualizar(String mensagem) {
        System.out.println(mensagem);
    }

}
