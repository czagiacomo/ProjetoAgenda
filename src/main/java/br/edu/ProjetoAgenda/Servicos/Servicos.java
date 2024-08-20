package src.main.java.br.edu.ProjetoAgenda.Servicos;

import java.util.Objects;
import java.util.Scanner;

import static src.main.java.br.edu.ProjetoAgenda.Apresentacao.Apresentacao.*;
import static src.main.java.br.edu.ProjetoAgenda.Validacoes.Validacoes.*;

public class Servicos {
    static Scanner scanner = new Scanner(System.in);
    static String[][] contatos = new String[100][7];
    static short contador = 0;

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

        String telefone = "";
        while (true) {
            telefone = capturarTelefone();

            try {
                validarCampoTelefone(telefone, contador, contatos);
                validarTelefoneDuplicado(telefone, contatos, contador);
                break;
            } catch (Exception e) {
                System.out.println(STR."Erro: \{e.getMessage()}");
            }
        }

        String telefone2 = "";
        while (true) {
            System.out.println("Deseja cadastrar outro número de telefone? (S/N)");
            resp = scanner.nextLine();

            if (resp.equalsIgnoreCase("s")) {
                telefone2 = capturarTelefone();

                try {
                    validarCampoTelefone(telefone2, contador, contatos);
                    validarTelefoneDuplicado(telefone2, contatos, contador);
                    break;
                } catch (Exception e) {
                    System.out.println(STR."Erro: \{e.getMessage()}");
                }
            } else {
                break;
            }
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

        contatos[contador][0] = String.valueOf(contador + 1);
        contatos[contador][1] = nome;
        contatos[contador][2] = endereco;
        contatos[contador][3] = telefone;
        contatos[contador][4] = telefone2;
        contatos[contador][5] = email;
        contatos[contador][6] = "n";


        System.out.printf("Contato adicionado com sucesso! ID: %s%n ",
                contador + 1);
        contador++;
        listarContatos((short) 0);
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
    public static void listarContatos(short id) {
        mostrarCabecalhoContatos();
        if (id == 0) {
            for (int i = 0; i < contador; i++) {
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("ID: " + contatos[i][0] + ", Nome: " + contatos[i][1] +
                        (!Objects.equals(contatos[i][2], "") ? ", Endereço: " + contatos[i][2] : "") +
                        ", Telefone 1: " + contatos[i][3] +
                        (!Objects.equals(contatos[i][4], "") ? ", Telefone 2: " + contatos[i][4] : "") +
                        ", Email: " + contatos[i][5]);
                System.out.println("--------------------------------------------------------------------------");            }
        } else {
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("ID: " + contatos[id][0] + ", Nome: " + contatos[id][1] +
                    (!Objects.equals(contatos[id][2], "") ? ", Endereço: " + contatos[id][2] : "") +
                    ", Telefone 1: " + contatos[id][3] +
                    (!Objects.equals(contatos[id][4], "") ? ", Telefone 2: " + contatos[id][4] : "") +
                    ", Email: " + contatos[id][5]);
            System.out.println("--------------------------------------------------------------------------");        }
    }
}

