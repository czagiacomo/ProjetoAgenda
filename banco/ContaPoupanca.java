package br.edu.grupo1.banco;

import java.util.Scanner;

public class ContaPoupanca extends Conta {
    private double saldoPoupanca = 0;
    private double juros = 0.5;

    public ContaPoupanca(String senha) {
        super(senha);
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Saldo Poupança: R$" + saldoPoupanca);
    }

    public void aplicarNaPoupanca(double valor, int periodo) {
        if (valor > 0) {
            saldoPoupanca += valor;
            this.calcularRendimento(periodo);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void calcularRendimento(int periodo) {
        int ciclosDe30Dias = periodo / 30;

        for (int i = 0; i < ciclosDe30Dias; i++) {
            double rendimento = saldoPoupanca * juros / 100;
            saldoPoupanca += rendimento;
        }

        System.out.println("Saldo da poupança será de R$" + saldoPoupanca + " após " + periodo + " dias.");
    }

    public void transferirParaContaCorrente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Valor a resgatar: ");
        double valor = scanner.nextDouble();

        if (valor > 0 && valor <= saldoPoupanca) {
            saldoPoupanca -= valor;
            super.receberTransferencia(valor);
            System.out.println("Transferência realizada com sucesso.");
        } else {
            System.out.println("Valor de transferência inválido.");
        }
    }


}
