package src.main.java.br.edu.ProjetoAgenda.Validacoes;

public class Validacoes {
    public static short validarCampoOpcao(String opt) throws Exception {
        try {
            return Short.parseShort(opt);
        } catch (NumberFormatException e) {
            throw new Exception("Opção inválida!");
        }
    }

    public static void validarCampoTelefone(String telefone, int contador,
                                            String[][] contatos) throws Exception {
        if (telefone.length() != 11)
            throw new Exception("Telefone inválido!");


    }

    public static void validarTelefoneDuplicado(String telefone,
                                                String[][] contatos, short contador) throws Exception {
        if (contador != 0) {
            for (int i = 0; i < contador; i++) {
                if (contatos[i][3].equals(telefone) || contatos[i][4].equals(telefone)) {
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
