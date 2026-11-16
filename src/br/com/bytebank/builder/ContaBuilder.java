package br.com.bytebank.builder;
import br.com.bytebank.model.Conta;

public class ContaBuilder {

    private String titular;
    private int numero;
    private String agencia;
    private String tipo;
    private double limite;
    private double saldo;

    public ContaBuilder titular(String titular) {
        this.titular = titular;
        return this;
    }
    public ContaBuilder numero(int numero) {
        this.numero = numero;
        return this;
    }
    public ContaBuilder agencia(String agencia) {
        this.agencia = agencia;
        return this;
    }
    public  ContaBuilder tipo(String tipo) {
        this.tipo = tipo;
        return this;
    }
    public ContaBuilder limite(double limite) {
        this.limite = limite;
        return this;
    }
    public ContaBuilder saldo(double saldo) {
        this.saldo = saldo;
        return this;
    }
    public Conta build() {
        return new Conta(titular, numero, agencia, tipo, limite, saldo);
    }
}
