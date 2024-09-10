package br.edu.grupo1.banco;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Conta {

    private static Set<String> numerosDeConta = new HashSet<>();
    private String agencia;
    private String numero;
    private String senha;
    private double saldo;
    private ContaPoupanca contaPoupanca;

    public Conta(String senha) {
        this.agencia = gerarAgencia();
        this.numero = gerarNumeroDeConta();
        this.senha = senha;
        this.saldo = 0;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumero() {
        return numero;
    }

    public String getSenha() {
        return senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void consultarSaldo() {
        System.out.println("Saldo: " + saldo);
    }

    public void depositar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual o valor a ser depositado?");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual o valor a ser depositado?");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
            System.out.println("Seu saldo é de: " + saldo);
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente para o saque.");
        } else {
            System.out.println("Valor de saque inválido.");
        }
    }

    public void transferirParaPoupanca() {
        this.contaPoupanca = new ContaPoupanca(this.senha);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual o valor a ser transferido?");
        double valor = scanner.nextDouble();

        System.out.println("Qual o período de aplicação?");
        int periodo = scanner.nextInt();

        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            this.contaPoupanca.aplicarNaPoupanca(valor, periodo);
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente para a transferência.");
        } else {
            System.out.println("Valor de transferência inválido.");
        }
    }

    public void receberTransferencia(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Transferência de R$" + valor + " recebida com sucesso.");
        } else {
            System.out.println("Valor de transferência inválido.");
        }
    }

    public void exibirInformacoes() {
        System.out.println("Agência: " + agencia);
        System.out.println("Conta: " + numero);
        System.out.println("Saldo: R$" + saldo);
    }

    private String gerarAgencia() {
        Random random = new Random();
        int agenciaNumerica = 9000 + random.nextInt(1000);
        return String.valueOf(agenciaNumerica);
    }

    private String gerarNumeroDeConta() {
        Random random = new Random();
        String numeroGerado;

        do {
            int numeroNumerico = 10_000_000 + random.nextInt(90_000_000);
            numeroGerado = String.valueOf(numeroNumerico);
        } while (numerosDeConta.contains(numeroGerado));

        numerosDeConta.add(numeroGerado);
        return numeroGerado;
    }

    public ContaPoupanca getContaPoupanca() {
        if(contaPoupanca == null) {
            System.out.println("Conta poupança não encontrada.");
        }
        return contaPoupanca;
    }

}
