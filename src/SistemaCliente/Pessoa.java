package SistemaCliente;
import java.util.Random;
import java.util.Scanner;

class Pessoa {
    String nome;
    String cpf;
    String endereco;
    String telefone;

    Pessoa(String nome, String cpf, String endereco, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }
}

class Conta {
    Pessoa titular;
    String agencia;
    String numeroConta;
    String senha;
    double saldo;

    Conta(Pessoa titular, String agencia, String numeroConta, String senha, double saldo) {
        this.titular = titular;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.senha = senha;
        this.saldo = saldo;
    }

    public String toString() {
        return "Agência: " + agencia + "\nConta: " + numeroConta;
    }
}

class ContaCorrente extends Conta {
    ContaCorrente(Pessoa titular, String agencia, String numeroConta, String senha, double saldo) {
        super(titular, agencia, numeroConta, senha, saldo);
    }
}

class ContaPoupanca extends Conta {
    ContaPoupanca(Pessoa titular, String agencia, String numeroConta, String senha, double saldo) {
        super(titular, agencia, numeroConta, senha, saldo);
    }
}

class SistemaBancario {
    static Conta conta;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar Conta");
            System.out.println("2 - Acessar Conta");
            System.out.println("3 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarConta(scanner);
                    break;
                case 2:
                    acessarConta(scanner);
                    break;
                case 3:
                    System.out.println("Obrigado por utilizar nosso sistema bancário!");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    static void cadastrarConta(Scanner scanner) {
        System.out.println("Digite seu nome completo:");
        String nome = scanner.next();

        System.out.println("Digite seu CPF:");
        String cpf = scanner.next();

        System.out.println("Digite seu endereço:");
        String endereco = scanner.next();

        System.out.println("Digite seu telefone:");
        String telefone = scanner.next();

        Pessoa titular = new Pessoa(nome, cpf, endereco, telefone);

        System.out.println("Digite o tipo de conta que deseja abrir (1 - Corrente, 2 - Poupança):");
        int tipoConta = scanner.nextInt();

        String agencia = gerarNumero(4);
        String numeroConta = gerarNumero(5);

        System.out.println("Digite uma senha numérica para sua conta:");
        String senha = scanner.next();

        System.out.println("Digite o saldo inicial da conta:");
        double saldo = scanner.nextDouble();

        if (tipoConta == 1) {
            conta = new ContaCorrente(titular, agencia, numeroConta, senha, saldo);
        } else if (tipoConta == 2) {
            conta = new ContaPoupanca(titular, agencia, numeroConta, senha, saldo);
        }

        System.out.println(conta.toString());
        System.out.println("Conta criada com sucesso!");
    }

    static void acessarConta(Scanner scanner) {
        System.out.println("Digite o número da agência:");
        String agencia = scanner.next();

        System.out.println("Digite o número da conta:");
        String numeroConta = scanner.next();

        System.out.println("Digite a senha:");
        int senha = scanner.nextInt();

        if (conta.agencia.equals(agencia) && conta.numeroConta.equals(numeroConta) && conta.senha.equals(senha)) {
            System.out.println("Acesso permitido!");
            System.out.println(conta.toString());
        } else {
            System.out.println("Acesso negado. Verifique os dados informados e tente novamente.");
        }
    }

    static String gerarNumero(int tamanho) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }
}