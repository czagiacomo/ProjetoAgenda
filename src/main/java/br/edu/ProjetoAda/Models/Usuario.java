package src.main.java.br.edu.ProjetoAda.Models;

import java.util.List;

public class Usuario extends Pessoa {
    private final int id;
//    private Conta conta;

    public Usuario(int id, String nome, List<String> telefone,
                   String endereco,  String email) {
        super(nome, telefone, endereco, email);
        this.id = id;
//        this.conta = conta;
    }

    public int getId() {
        return id;
    }

//    public Conta getConta() {
//        return conta;
//    }
//
//    @Override
//    public String toString() {
//        return "ID: " + id + "| Nome: " + getNome() + " | telefone: " + getTelefone() + " | Email: " + getEmail() + "\n"
//                + "Agência Bancária: " + conta.getAgencia() + " | Número: " + conta.getNumero() + "\n"
//                + "_".repeat(40);
//    }
}
