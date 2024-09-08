package src.main.java.br.edu.ProjetoAda;

import java.util.Scanner;

import static src.main.java.br.edu.ProjetoAda.Apresentacao.Apresentacao.exibirMenu;
import static src.main.java.br.edu.ProjetoAda.Servicos.Servicos.*;
import static src.main.java.br.edu.ProjetoAda.Validacoes.Validacoes.validarCampoOpcao;

public class ProjetoAda {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        short opt = 0;

        do {
            exibirMenu();
            try {
                opt = validarCampoOpcao(scanner.nextLine());
                direcionarOpcao(opt);
            } catch (Exception e) {
                System.out.println(STR."Erro: \{e.getMessage()}");
                continue;
            }
        }
        while (opt != 0);
    }

    public static void direcionarOpcao(short opt) throws Exception {
        String data;
        short id;
        switch (opt) {
            case 1:
                adicionarContato();
                break;
//            case 2:
//                data = capturarTelefone();
//                id = buscarPorTelefone(data);
//                if (id != 0) {
//                    listarContatos(id);
//                } else {
//                    System.out.println("Telefone não encontrado!");
//                }
//                break;
//            case 3:
//                data = capturarTelefone();
//                id = buscarPorTelefone(data);
//                if (id != 0) {
//                    cabecalhoContatos();
//                    listarContatos(id);
//                    editarContato(id);
//                } else {
//                    System.out.println("Telefone não encontrado!");
//                }
//                break;
//            case 4:
//                data = capturarTelefone();
//                id = buscarPorTelefone(data);
//                if (id != 0) {
//                    cabecalhoContatos();
//                    listarContatos(id);
//                    removerContato(id);
//            listarContatos((short) 0);

//                } else {
//                    System.out.println("Telefone não encontrado!");
//                }
//                break;
//            case 5:
//                cabecalhoContatos();
//                listarContatos((short) 0);
//                break;

            case 8:
                listarContatos();
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
}
