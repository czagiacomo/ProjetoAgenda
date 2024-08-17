package src.main.java.br.edu.ProjetoAgenda.Apresentacao;

public class Apresentacao {
    public static void exibirMenu() {
        System.out.println();
        System.out.println("##################");
        System.out.println("##### AGENDA #####");
        System.out.println("##################");
        System.out.println();
        System.out.println(">>>>> Menu Contato <<<<<");
        System.out.println("1 - Adicionar contato");
        System.out.println("2 - Detalhar contato");
        System.out.println("3 - Editar contato");
        System.out.println("4 - Remover contato");
        System.out.println("5 - Listar contatos");
        System.out.println("6 - Sair");
        System.out.println("Escolha uma opção: ");
    }

    public static void mostrarCabecalhoContatos() {
        System.out.println();
        System.out.println(">>>> Contatos <<<<");
        System.out.println("Id | Nome | Telefone | Email");
    }
}
