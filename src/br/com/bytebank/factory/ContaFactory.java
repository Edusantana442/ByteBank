package br.com.bytebank.factory;
import br.com.bytebank.builder.ContaBuilder;
import br.com.bytebank.model.Conta;

public class ContaFactory {

    public Conta criarConta(String tipo, String titular, int numero, double limite) {

        String tipoConta = null;

        if ("Corrente".equals(tipo)) {
            tipoConta = "Corrente";

        } else if ("Poupança".equals(tipo)) {
            tipoConta = "Poupança";

        } else {
            throw new IllegalArgumentException("Tipo de conta inválido!");
        }

        Conta conta = new ContaBuilder()
                .titular(titular)
                .numero(numero)
                .agencia("0001")
                .tipo(tipoConta)
                .limite(limite)
                .saldo(0)
                .build();

        return conta;

    }

}
