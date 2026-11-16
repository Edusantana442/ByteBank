package br.com.bytebank.strategy;

import br.com.bytebank.model.Conta;

public class Transferencia implements OperacaoBancaria {

    @Override
    public void executar(Conta origem, Conta destino, double valor) {

        if (valor <= 0) {
            return;
        }

        if (origem == null || destino == null) {
            return;
        }

        if (origem == destino) {
            return;
        }

        boolean saqueRealizado = origem.sacarParaTransferencia(valor);

        if (saqueRealizado) {
            boolean transferenciaRecebida = destino.receberTransferencia(valor);

            if (!transferenciaRecebida) {
                origem.depositar(valor);
                return;

            }
                origem.notificarTransferencia(
                        "Você transferiu R$ " + valor + " para " + destino.getTitular());
                destino.notificarTransferencia(
                        "Você recebeu R$ " + valor + " de " + origem.getTitular());

        }
    }
}
