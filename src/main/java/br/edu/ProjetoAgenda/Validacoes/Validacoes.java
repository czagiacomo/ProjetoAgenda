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

        if (contador != 0) {
            for (int i = 0; i < contador; i++) {
                if (contatos[i][2].equals(telefone)) {
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

}
