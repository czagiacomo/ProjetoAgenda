package br.edu.grupo1.banco;

public class ContaCorrente extends Conta{
    private double limite;

    public ContaCorrente(String senha, double limite) {
        super(senha);
        this.limite = limite;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Limite: R$" + limite);
    }
}
