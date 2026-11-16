package br.com.bytebank.model;
import br.com.bytebank.observer.ObservadorConta;
import java.util.ArrayList;
import java.util.List;

public class Conta {

    private String titular;
    private int numero;
    private double saldo;
    private String agencia;
    private String tipo;
    private double limite;
    private List<ObservadorConta> observadores = new ArrayList<>();

    public Conta(String titular, int numero, String agencia,
                 String tipo, double limite, double saldo) {

        if (limite < 0) {
            throw new IllegalArgumentException("O limite não pode ser negativo!");
        }

        if (saldo < 0) {
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo!");
        }

        this.titular = titular;
        this.numero = numero;
        this.agencia = agencia;
        this.tipo = tipo;
        this.limite = limite;
        this.saldo = saldo;

    }

    public void depositar(double valor) {
        if (valor <= 0) {
            return;
        }

        saldo += valor;

        notificarObservadores(
                "Depósito de R$ " + valor + " realizado na conta de " + titular);

    }

    public boolean sacar(double valor){

        if (!realizarSaque(valor)) {
            return false;
        }

        notificarObservadores(
                "Saque de R$ " + valor + " realizado na conta de " + titular);

        return true;

    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public int getNumero() {
        return numero;
    }

    public void adicionarObservador(ObservadorConta observador) {

        if (observador == null) {
            return;
        }

        if (!observadores.contains(observador)) {
            observadores.add(observador);
        }

    }

    private void notificarObservadores(String mensagem) {
        for (ObservadorConta observador : observadores) {
            observador.atualizar(mensagem);
        }
    }

    public void notificarTransferencia(String mensagem) {
        notificarObservadores(mensagem);
    }

    public boolean receberTransferencia(double valor) {

        if (valor <= 0) {
            return false;
        }

        saldo += valor;

        return true;

    }

    public boolean sacarParaTransferencia(double valor) {

        return realizarSaque(valor);

    }

    private boolean realizarSaque(double valor) {

        if (valor <= 0) {
            return false;
        }
        if (valor > saldo + limite) {
            return false;
        }

        saldo -= valor;
        return true;

    }

}
