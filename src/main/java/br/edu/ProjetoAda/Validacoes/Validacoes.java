package src.main.java.br.edu.ProjetoAda.Validacoes;

import src.main.java.br.edu.ProjetoAda.Models.Usuario;

import java.util.List;

public class Validacoes {
    public static short validarCampoOpcao(String opt) throws Exception {
        try {
            return Short.parseShort(opt);
        } catch (NumberFormatException e) {
            throw new Exception("Opção inválida!");
        }
    }

    public static void validarCampoTelefone(String telefone) throws Exception {
        if (telefone.length() != 11)
            throw new Exception("Telefone inválido!");
    }

    public static void validarTelefoneDuplicado(String telefone,
                                                List<Usuario> contatos) throws Exception {
        if (contatos != null) {
            for (Usuario contato : contatos) {
                if (contato.getTelefone().contains(telefone)) {
                    throw new Exception("Telefone já cadastrado!");
                }
            }
        }
    }

    public static void validarCampoEmail(String email) throws Exception {
        if (!email.contains("@") || !email.contains(".")) {
            throw new Exception("Email inválido!");
        }
    }

    public static void validarCampoNome(String nome) throws Exception {
        if (nome.length() < 3) {
            throw new Exception("Nome inválido!");
        }
    }

}
