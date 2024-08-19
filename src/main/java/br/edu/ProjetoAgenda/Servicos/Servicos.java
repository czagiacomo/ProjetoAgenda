package src.main.java.br.edu.ProjetoAgenda.Servicos;

import java.util.Scanner;

import static src.main.java.br.edu.ProjetoAgenda.Apresentacao.Apresentacao.mostrarCabecalhoContatos;
import static src.main.java.br.edu.ProjetoAgenda.Validacoes.Validacoes.validarCampoEmail;
import static src.main.java.br.edu.ProjetoAgenda.Validacoes.Validacoes.validarCampoTelefone;

public class Servicos {
    static Scanner scanner = new Scanner(System.in);
    static String[][] contatos = new String[100][4];
    static short contador = 0;

    public static void adicionarContato() {
        System.out.println("Digite o nome do contato: ");
        String nome = scanner.next();
        System.out.println("Digite o telefone do contato (11 caracteres) ");
        String telefone = scanner.next();

        try {
            validarCampoTelefone(telefone, contador, contatos);
        } catch (Exception e) {
            System.out.println(STR."Erro: \{e.getMessage()}");
            return;
        }

        System.out.println("Digite o email do contato (exemplo@qualquer.com): ");
        String email = scanner.next();

        try {
            validarCampoEmail(email);
        } catch (Exception e) {
            System.out.println(STR."Erro: \{e.getMessage()}");
            return;
        }

        contatos[contador][0] = String.valueOf(contador + 1);
        contatos[contador][1] = nome;
        contatos[contador][2] = telefone;
        contatos[contador][3] = email;

        contador++;
        System.out.println("Contato adicionado com sucesso!");
        listarContatos((short) 0);
    }

    private static short buscarPorTelefoneDuplicado(String telefone) {
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
        try{
            validarCampoEmail(email);
        } catch (Exception e) {
            System.out.println(STR."Erro: \{e.getMessage()}");
        }

        contatos[id][1] = nome;
        contatos[id][3] = email;

        System.out.println("Contato alterado com sucesso!");
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
        }
    }

    public static void listarContatos(short id) {
        mostrarCabecalhoContatos();
        if (id == 0) {
            for (int i = 0; i < contador; i++) {
                System.out.println(STR."\{contatos[i][0]} | \{contatos[i][1]} | \{contatos[i][2]} | \{contatos[i][3]}");
            }
        } else {
            System.out.println(STR."\{contatos[id][0]} | \{contatos[id][1]} | \{contatos[id][2]} | \{contatos[id][3]}");
        }
    }

}
