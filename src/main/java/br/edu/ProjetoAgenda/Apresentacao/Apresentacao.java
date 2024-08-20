package src.main.java.br.edu.ProjetoAgenda.Apresentacao;

import java.util.Scanner;

public class Apresentacao {
    static Scanner scanner = new Scanner(System.in);
    public static void exibirMenu() {
        System.out.println();
        System.out.println("##################");
        System.out.println("##### AGENDA #####");
        System.out.println("##################");
        System.out.println();
        System.out.println(">>>>> Menu Contato <<<<<");
        System.out.println("1 - Adicionar contato");
        System.out.println("2 - Buscar contato por telefone");
        System.out.println("3 - Buscar contato por nome");
        System.out.println("4 - Editar contato");
        System.out.println("5 - Remover contato");
        System.out.println("6 - Favoritar/Desfavoritar contato");
        System.out.println("7 - Listar contatos favoritos");
        System.out.println("8 - Exibir Todos os contatos");
        System.out.println("9 - Sair");
        System.out.println("Escolha uma opção: ");
    }

    public static void mostrarCabecalhoContatos() {
        System.out.println();
        System.out.println(">>>> Contatos <<<<");
    }

    public static void mostrarCabecalhoContatosFavoritos() {
        System.out.println();
        System.out.println(">>>> Contatos Favoritos <<<<");
    }

    public static String capturarNome() {
        System.out.println();
        System.out.println("Informe o nome do contato: ");
        return scanner.nextLine();
    }

    public static String capturarEndereco() {
        System.out.println();
        System.out.println("Informe o endereço do contato: ");
        return scanner.nextLine();
    }

    public static String capturarTelefone() {
        System.out.println();
        System.out.println("Informe o telefone do contato (11 caracteres): ");
        return scanner.nextLine();
    }

    public static String capturarEmail() {
        System.out.println();
        System.out.println("Informe o email do contato (exemplo@qualquer.com): ");
        return scanner.nextLine();
    }
}
