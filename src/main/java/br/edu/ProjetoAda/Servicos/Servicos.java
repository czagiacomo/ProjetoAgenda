package src.main.java.br.edu.ProjetoAda.Servicos;

import src.main.java.br.edu.ProjetoAda.Models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static src.main.java.br.edu.ProjetoAda.Apresentacao.Apresentacao.*;
import static src.main.java.br.edu.ProjetoAda.Validacoes.Validacoes.*;

public class Servicos {
    static Scanner scanner = new Scanner(System.in);
    static List<Usuario> contatos = new ArrayList<>();

    public static boolean numeroDeRegistro() {
        if (contatos.isEmpty()) {
            System.out.printf(" Nenhum registro armazenado.%n");
            return false;
        }
        return true;
    }

    public static void adicionarContato() throws Exception {
        String nome = "";
        while (true) {
            nome = capturarNome();

            try {
                validarCampoNome(nome);
                break;
            } catch (Exception e) {
                System.out.println(STR."Erro: \{e.getMessage()}");
            }
        }

        System.out.println("Deseja cadastrar o endereço residencial? (S/N)");
        String resp = scanner.nextLine();
        String endereco = "";
        if (resp.equalsIgnoreCase("s")) {
            endereco = capturarEndereco();
        }

        List<String> telefone = new ArrayList<>();
        telefone.add(capturarTelefoneValido(contatos));

        System.out.println("Deseja cadastrar outro número de telefone? (S/N)");
        resp = scanner.nextLine();

        if (resp.equalsIgnoreCase("s")) {
            telefone.add(capturarTelefoneValido(contatos));
        }

        String email = "";
        while (true) {
            email = capturarEmail();

            try {
                validarCampoEmail(email);
                break;
            } catch (Exception e) {
                System.out.println(STR."Erro: \{e.getMessage()}");
            }
        }

        cadastrarRegistro(nome, endereco, telefone, email);

        System.out.printf("Contato adicionado com sucesso! ID: %s%n ",
                contatos.size());
        listarContatos();
    }

    private static void cadastrarRegistro(String nome, String endereco,
                                          List<String> telefone,
                                          String email) {
        contatos.add(new Usuario((contatos.isEmpty() ? 1 :
                contatos.size() + 1), nome,
                telefone,
                endereco, email));
    }

    public static String capturarTelefoneValido(List<Usuario> contatos) {
        String telefone = "";
        while (true) {
            telefone = capturarTelefone();

            try {
                validarCampoTelefone(telefone);
                validarTelefoneDuplicado(telefone, contatos);
                break;
            } catch (Exception e) {
                System.out.println(STR."Erro: \{e.getMessage()}");
            }
        }
        return telefone;
    }

//    public static short buscarPorTelefone(String telefone) {
//
//        try {
//            validarCampoTelefone(telefone, contador, contatos);
//        } catch (Exception e) {
//            System.out.println(STR."Erro: \{e.getMessage()}");
//        }
//
//        for (int i = 1; i < contador; i++) {
//            if (contatos[i][2].equals(telefone)) {
//                return Short.parseShort((contatos[i][0]));
//            }
//        }
//        return 0;
//    }
//
//    private static void editarContato(short id) {
//        System.out.println("Digite o nome do contato: ");
//        String nome = scanner.next();
//        System.out.println("Digite o email do contato (exemplo@qualquer.com): ");
//        String email = scanner.next();
//        try{
//            validarCampoEmail(email);
//        } catch (Exception e) {
//            System.out.println(STR."Erro: \{e.getMessage()}");
//        }
//
//        contatos[id][1] = nome;
//        contatos[id][3] = email;
//
//        System.out.println("Contato alterado com sucesso!");
//    }
//
//
//    private static void removerContato(short id) {
//        System.out.println("Deseja realmente remover o contato? (S/N)");
//        String opt = scanner.next();
//        if (opt.equalsIgnoreCase("S")) {
//            contatos[id][0] = "---";
//            contatos[id][1] = "---";
//            contatos[id][2] = "---";
//            contatos[id][3] = "---";
//            System.out.println("Contato removido com sucesso!");
//        }
//    }
//
    public static void listarContatos() {
        mostrarCabecalhoContatos();
        for (Usuario contato : contatos) {
            System.out.println("-".repeat(80));

            System.out.println("ID: " + contato.getId() + ", Nome: " + contato.getNome() +
                    (!Objects.equals(contato.getEndereco(), "") ? ", " +
                            "Endereço: " + contato.getEndereco() : "") +
                    ", Telefone 1: " + contato.getTelefone().get(0) +
                    ((contato.getTelefone().size() != 1) ?
                            ", Telefone 2: " + contato.getTelefone().get(1) : "") +
                    ", Email: " + contato.getEmail());
        }
            System.out.println("-".repeat(80));
    }
}

