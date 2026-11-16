# ByteBank - Sistema Bancário em Java

Projeto desenvolvido para praticar programação orientada a objetos e padrões de projeto (Design Patterns) utilizando Java.

## Funcionalidades

- Criação de contas correntes e poupanças.
- Depósitos e saques.
- Transferências entre contas.
- Validação de operações bancárias.
- Notificações por e-mail e SMS.
- Gerenciamento de contas utilizando listas.

## Design Patterns implementados

- **Singleton:** garante uma única instância da configuração do sistema.
- **Strategy:** permite executar diferentes operações bancárias.
- **Builder:** facilita a construção de objetos Conta.
- **Factory:** centraliza a criação de contas.
- **Observer:** permite notificar diferentes observadores sobre eventos nas contas.

## Tecnologias utilizadas

- Java
- Programação Orientada a Objetos
- IntelliJ IDEA

## Estrutura do projeto

```text
br.com.bytebank
├── builder
├── config
├── factory
├── model
├── observer
├── strategy
└── Main.java
```

## Como executar

1. Clone este repositório.
2. Abra o projeto no IntelliJ IDEA.
3. Localize a classe `Main.java`.
4. Execute o método `main()`.

## Objetivo

Consolidar conhecimentos em Java, orientação a objetos e padrões de projeto por meio de um sistema bancário desenvolvido para fins educacionais.