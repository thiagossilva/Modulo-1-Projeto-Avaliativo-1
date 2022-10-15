package tech.devinhouse.models;

public enum Operacao {
    CADASTRAR,

    LISTAR,
    RELATORIOS,

    ALTERAR_SITUACAO_ALUNO,

    REALIZAR_ATENDIMENTO,
    SAIR;

    public static Operacao obterCodigo(int codigo) {
        Operacao[] operacaos = Operacao.values();

        if (codigo > operacaos.length || codigo <0 ) {
            return null;
        }
        return operacaos[codigo-1];
    }
}
