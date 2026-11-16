package br.com.bytebank.strategy;

import br.com.bytebank.model.Conta;

public class Saque implements OperacaoBancaria {

    @Override
    public void executar(Conta origem, Conta destino, double valor) {

        if (origem == null) {
            return;
        }

        origem.sacar(valor);
    }
}
