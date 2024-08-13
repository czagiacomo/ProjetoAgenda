import java.util.Scanner;

import static java.lang.StringTemplate.STR;

public class ProjetoAgenda {
    static Scanner scanner = new Scanner(System.in);
    static String[][] contatos = new String[100][4];
    static short contador = 1;

    public static void main(String[] args) {
        short opt;
        do {
            opt = exibirMenu();
            selecionarOpcoes(opt);
        }
        while (opt != 6);
    }

    public static short exibirMenu() {
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
        return scanner.nextShort();
    }

    public static void selecionarOpcoes(short opt) {
        String data;
        short id;
        switch (opt) {
            case 1:
                adicionarContato();
                break;
            case 2:
                data = capturarTelefone();
                id = buscarPorTelefone(data);
                if (id != 0) {
                    cabecalhoContatos();
                    listarContatos(id);
                } else {
                    System.out.println("Telefone não encontrado!");
                }
                break;
            case 3:
                data = capturarTelefone();
                id = buscarPorTelefone(data);
                if (id != 0) {
                    cabecalhoContatos();
                    listarContatos(id);
                    editarContato(id);
                } else {
                    System.out.println("Telefone não encontrado!");
                }
                break;
            case 4:
                data = capturarTelefone();
                id = buscarPorTelefone(data);
                if (id != 0) {
                    cabecalhoContatos();
                    listarContatos(id);
                    removerContato(id);
                } else {
                    System.out.println("Telefone não encontrado!");
                }
                break;
            case 5:
                cabecalhoContatos();
                listarContatos((short) 0);
                break;
            case 6:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void adicionarContato() {
        System.out.println("Digite o nome do contato: ");
        String nome = scanner.next();
        System.out.println("Digite o telefone do contato (11 caracteres) ");
        String telefone = scanner.next();
        if (!validarCampoTelefone(telefone)) {
            return;
        }
        if (!validarSeExiste(telefone)) {
            return;
        }
        System.out.println("Digite o email do contato (exemplo@qualquer.com): ");
        String email = scanner.next();
        if (!validarCampoEmail(email)) {
            return;
        }

        contatos[contador][0] = String.valueOf(contador);
        contatos[contador][1] = nome;
        contatos[contador][2] = telefone;
        contatos[contador][3] = email;

        contador++;
        System.out.println("Contato adicionado com sucesso!");
        cabecalhoContatos();
        listarContatos((short) 0);
    }

    private static boolean validarCampoTelefone(String telefone) {
        if (telefone.length() != 11) {
            System.out.println("Telefone inválido!");
            return false;
        }
        return true;
    }

    private static boolean validarSeExiste(String telefone) {
        for (int i = 1; i < contador; i++) {
            if (contatos[i][2].equals(telefone)) {
                System.out.println("Telefone já cadastrado!");
                return false;
            }
        }
        return true;
    }

    private static boolean validarCampoEmail(String email) {
        if (!email.contains("@") || !email.contains(".")) {
            System.out.println("Email inválido!");
            return false;
        }
        return true;
    }

    private static void cabecalhoContatos() {
        System.out.println();
        System.out.println(">>>> Contatos <<<<");
        System.out.println("Id | Nome | Telefone | Email");
    }

    private static String capturarTelefone() {
        System.out.println();
        System.out.println("Informe o telefone do contato (11 caracteres): ");
        String data = scanner.next();
        scanner.nextLine();
        return data;
    }

    private static short buscarPorTelefone(String telefone) {
        for (int i = 1; i < contador; i++) {
            if (contatos[i][2].equals(telefone)) {
                return Short.parseShort((contatos[i][0]));
            }
        }
        return 0;
    }

    private static void editarContato(short id) {
        System.out.println("Digite o nome do contato: ");
        String nome = scanner.next();
        System.out.println("Digite o email do contato (exemplo@qualquer.com): ");
        String email = scanner.next();
        if (!validarCampoEmail(email)) {
            return;
        }

        contatos[id][1] = nome;
        contatos[id][3] = email;

        System.out.println("Contato alterado com sucesso!");
        cabecalhoContatos();
        listarContatos(id);
    }


    private static void removerContato(short id) {
        System.out.println("Deseja realmente remover o contato? (S/N)");
        String opt = scanner.next();
        if (opt.equalsIgnoreCase("S")) {
            contatos[id][0] = "---";
            contatos[id][1] = "---";
            contatos[id][2] = "---";
            contatos[id][3] = "---";
            System.out.println("Contato removido com sucesso!");
            cabecalhoContatos();
            listarContatos((short) 0);
        }
    }

    private static void listarContatos(short id) {
        if (id == 0) {
            for (int i = 1; i < contador; i++) {
                System.out.println(STR."\{i} | \{contatos[i][1]} | \{contatos[i][2]} | \{contatos[i][3]}");
            }
        } else {
            System.out.println(STR."\{id} | \{contatos[id][1]} | \{contatos[id][2]} | \{contatos[id][3]}");
        }
    }
}
