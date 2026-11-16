package br.com.bytebank;

import br.com.bytebank.model.Conta;
import java.util.ArrayList;
import br.com.bytebank.config.ConfiguracaoSistema;
import br.com.bytebank.strategy.OperacaoBancaria;
import br.com.bytebank.strategy.Deposito;
import br.com.bytebank.strategy.Saque;
import br.com.bytebank.strategy.Transferencia;
import br.com.bytebank.factory.ContaFactory;
import br.com.bytebank.observer.NotificacaoEmail;
import br.com.bytebank.observer.NotificacaoSMS;

public class Main {
    public static void main(String[] args) {

        ArrayList<Conta> contas = new ArrayList<>();

        ContaFactory factory = new ContaFactory();

        Conta conta1 = factory.criarConta("Corrente", "Eduardo",
                12345, 1000);

                NotificacaoEmail email = new NotificacaoEmail();

                conta1.adicionarObservador(email);

                NotificacaoSMS sms = new NotificacaoSMS();

                conta1.adicionarObservador(sms);

                conta1.depositar(300);

                OperacaoBancaria operacao = new Saque();
                operacao.executar(conta1, null, 450);

                System.out.println("Saldo após saque: " + conta1.getSaldo());

        Conta conta2 = factory.criarConta("Poupança", "Carlos",
                67890, 500);

        conta2.adicionarObservador(email);
        conta2.adicionarObservador(sms);

        Conta conta3 = factory.criarConta("Corrente", "Mariana",
                54321, 2000);

        try {
            Conta contaTeste = new Conta(
                    "Teste", 99999, "0001",
                    "Corrente", 500, -100
            );

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            Conta contaTeste = factory.criarConta(
                    "Corrente", "Teste", 99999, -500
            );

            System.out.println("Conta criada com sucesso!");

        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar conta: " + e.getMessage());
        }

        contas.add(conta1);
        contas.add(conta2);
        contas.add(conta3);

        operacao = new Deposito();
        operacao.executar(conta1, null, 500);

        operacao = new Saque();
        operacao.executar(conta1, null, 100);

        operacao = new Transferencia();

        operacao.executar(conta1, conta2, 200);
        operacao.executar(conta2, conta3, 100);

        System.out.println(contas.size());

    for (Conta conta : contas) {
        System.out.println("Titular: " + conta.getTitular());
        System.out.println("Número: " + conta.getNumero());
        System.out.println("Saldo: " + conta.getSaldo());
        System.out.println("----------------");

        }



        ConfiguracaoSistema config1 =
                ConfiguracaoSistema.getInstancia();

        ConfiguracaoSistema config2 =
                ConfiguracaoSistema.getInstancia();

        System.out.println(config1 == config2);

    }
}
