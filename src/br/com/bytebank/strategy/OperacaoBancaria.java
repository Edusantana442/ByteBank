package br.com.bytebank.strategy;

import br.com.bytebank.model.Conta;

public interface OperacaoBancaria {

    void executar(Conta origem, Conta destino, double valor);

}
