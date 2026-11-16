package br.com.bytebank.config;

public class ConfiguracaoSistema {

    private static ConfiguracaoSistema instancia;

    private ConfiguracaoSistema() {

    }

    public static ConfiguracaoSistema getInstancia() {

        if (instancia == null) {
            instancia = new ConfiguracaoSistema();

        }
        return instancia;
    }
}
