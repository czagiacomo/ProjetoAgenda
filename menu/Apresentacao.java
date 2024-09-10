package br.edu.grupo1.menu;

public class Apresentacao {

    public static void mostrarMenu() {
        System.out.println("_".repeat(40));
        System.out.println("\n--- Menu ---");
        System.out.println("1 - Adicionar Usuário");
        System.out.println("2 - Listar Usuários");
        System.out.println("3 - Editar informações de usuário");
        System.out.println("4 - Remover Conta");
        System.out.println("5 - Acessar Conta");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void mostrarCabecalhoContatos() {
        System.out.println();
        System.out.println(">>>> Contatos <<<<");
        System.out.println("Id | Nome | Telefone | Email");
    }


    static void mostrarMenuContaBancaria() {
        System.out.println("_".repeat(40));
        System.out.println("\n--- Menu Conta Bancária ---");
        System.out.println("1. Exibir informações da Conta Corrente");
        System.out.println("2. Consultar Saldo");
        System.out.println("3. Depositar");
        System.out.println("4. Sacar");
        System.out.println("5. Aplicar na poupança");
        System.out.println("6. Exibir informações da Conta Poupança");
        System.out.println("7. Transferir para conta corrente");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");
    }
}
