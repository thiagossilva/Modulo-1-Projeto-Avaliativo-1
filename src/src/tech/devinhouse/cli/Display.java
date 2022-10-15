package tech.devinhouse.cli;

import tech.devinhouse.exception.OpcaoInvalidaMenu;
import tech.devinhouse.models.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class Display {
    Interacoes interacoes = new Interacoes();
    SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
    Scanner sc = new Scanner(System.in);

    public void exibirMenu() {
        System.out.println();
        System.out.println("---- MENU ----");
        System.out.println("1 - Cadastrar");
        System.out.println("2 - Listar");
        System.out.println("3 - Relatórios ");
        System.out.println("4 - Alterar situação do aluno");
        System.out.println("5 - Realizar atendimento pedagógico");
        System.out.println("6 - Sair");
        System.out.println();
    }

    public void menuRelatorios() {
        System.out.println();
        System.out.println("1 - Aluno");
        System.out.println("2 - Professor");
        System.out.println("3 - Pedagogo");
        System.out.println();
    }

    public void menuListarCadastro() {
        System.out.println();
        System.out.println("1 - Aluno");
        System.out.println("2 - Professor");
        System.out.println("3 - Pedagogo");
        System.out.println();
    }

    public void menuListarPessoa() {
        System.out.println();
        System.out.println("1 - Aluno");
        System.out.println("2 - Professor");
        System.out.println("3 - Pedagogo");
        System.out.println("4 - Todos");
        System.out.println();
    }

    public void relatorioAlunos() {
        System.out.println();
        System.out.println("1 - Ativo");
        System.out.println("2 - Irrelugar");
        System.out.println("3 - Atendimento pedagógico");
        System.out.println("4 - Inativo");
        System.out.println("5 - Alunos ordenados por atendimento pedagógico");
        System.out.println("6 - Todos");
    }

    public void relatorioProfessores() {
        System.out.println();
        System.out.println("1 - Front-End");
        System.out.println("2 - Back-End");
        System.out.println("3 - Full-Stack");
        System.out.println("4 - Todos");
    }

    public void menuFormacaoProf() {
        System.out.println();
        System.out.println("1 - Graduação incompleta");
        System.out.println("2 - Graduação completa");
        System.out.println("3 - Mestrado");
        System.out.println("4 - Doutorado");
    }

    public void menuExpProf() {
        System.out.println();
        System.out.println("1 - Front-End");
        System.out.println("2 - Back-End");
        System.out.println("3 - Full-Stack");
    }

    public void menuSituacaoProf() {
        System.out.println();
        System.out.println("1 - Ativo");
        System.out.println("2 - Inativo");
    }

    public void menuSituacaoAluno() {
        System.out.println();
        System.out.println("1 - Ativo");
        System.out.println("2 - Inativo");
        System.out.println("3 - Atendimento pedagógico");
        System.out.println("4 - Irregular");
    }

    public void participantesAtendimento() {
        System.out.println("Digite o ID do aluno e pedagogo que participaram do atendimento");
    }

    public Operacao obterOperacao() throws OpcaoInvalidaMenu {

        System.out.print("Digite a opção desejada: ");
        String entradaCodigo = sc.nextLine();
        Integer opcao = null;
        Operacao operacao = null;
        try {
            opcao = Integer.valueOf(entradaCodigo);
            if (opcao <= 0 || opcao > Operacao.values().length) {
                throw new OpcaoInvalidaMenu();
            }
        } catch (OpcaoInvalidaMenu e) {
            System.out.println("Opção escolhida inválida!");
        } catch (NumberFormatException e) {
            e.getMessage();
        }
        try {
            operacao = Operacao.obterCodigo(opcao);
        } catch (NullPointerException e) {
            System.out.println("Opção inválida, digite apenas os números do menu exibido");
        }
        return operacao;
    }

    // Cadastra uma nova pessoa de acordo com o que ela é, aluno, professor ou pedagogo
    public Pessoa cadastrar(TipoPessoa tipo) {

        System.out.print("Insira o nome: ");
        String nome = sc.nextLine();
        while (nome.isEmpty()) {
            System.out.println(interacoes.vermelho + "Nome não pode estar vazio" + interacoes.resetarCor);

            System.out.print("Insira o nome: ");
            nome = sc.nextLine();
        }

        System.out.print("Insira o telefone de contato: ");
        String telefone = sc.nextLine();

        while (telefone.isEmpty()) {
            System.out.println(interacoes.vermelho + "Telefone não pode estar vazio" + interacoes.resetarCor);
            System.out.print("Insira o telefone de contato: ");
            telefone = sc.nextLine();
        }

        System.out.print("Insira o CPF: ");
        String cpf = sc.nextLine();
        while (cpf.length() < 11 || cpf.isEmpty()) {
            System.out.println(interacoes.vermelho + "CPF não pode ser nulo ou ter menos de 11 caracteres" + interacoes.resetarCor);
            System.out.println();
            System.out.print("Insira o CPF: ");
            cpf = sc.nextLine();
        }

        System.out.println(interacoes.verde + "CPF cadastrado!" + interacoes.resetarCor);
        // data atual e data de "01/01/1920" para comparação com a data inserida
        LocalDate dataAtual = LocalDate.now();
        Date dataAtualComparacao = Date.from(dataAtual.atStartOfDay(ZoneId.systemDefault()).toInstant());
        String dataLimite = "01/01/1920";
        Date dataLimiteFormatada;
        SimpleDateFormat fmtDataLimite = new SimpleDateFormat("dd/MM/yyyy");

        Date data = new Date();

        try {

            dataLimiteFormatada = fmtDataLimite.parse(dataLimite);
            System.out.print("Insira a data de nascimento no formado dia/mês/ano: ");
            data = formata.parse(sc.nextLine());
            while (data.after(dataAtualComparacao) || data.before(dataLimiteFormatada)) {
                System.out.println("Data fora do intervalo permitido");

                System.out.print("Insira a data de nascimento no formado dia/mês/ano: ");
                data = formata.parse(sc.nextLine());
            }
            System.out.println(interacoes.verde + "Data cadastrada com sucesso!" + interacoes.resetarCor);
        } catch (ParseException e) {
            e.getMessage();
        }

        Pessoa pessoa = null;

        if (tipo == TipoPessoa.ALUNO) {
            menuSituacaoAluno();
            System.out.println("Qual a situação atual do aluno?");
            String situacaoString = sc.nextLine();
            Integer situacaoFmt = null;
            try {
                situacaoFmt = Integer.valueOf(situacaoString);
            } catch (NumberFormatException e) {
                System.out.println(interacoes.vermelho + "É preciso selecionar a situação do aluno" + interacoes.resetarCor);
            }
            String situacao = null;
            if (situacaoFmt == 1) {
                situacao = "ativo";
            } else if (situacaoFmt == 2) {
                situacao = "inativo";
            } else if (situacaoFmt == 3) {
                situacao = "atendimento pedagógico";
            } else if (situacaoFmt == 4) {
                situacao = "irregular";
            } else {
                System.out.println("Opção inválida");
            }
            System.out.println("Qual a nota do aluno?");
            String notaEmString = sc.nextLine();
            Double nota = null;
            try {
                nota = Double.valueOf(notaEmString);
            } catch (NumberFormatException e) {
                System.out.println(interacoes.vermelho + "É preciso atribuir uma nota" + interacoes.resetarCor);
            }
            if (nota < 0 || nota > 10) {
                System.out.println("Nota deve estar no intervalo de 0 a 10");
            } else {
                pessoa = new Aluno(nome, telefone, cpf, data, situacao, nota);
            }

        } else if (tipo == TipoPessoa.PROFESSOR) {
            menuFormacaoProf();
            System.out.println("Qual a formação acadêmica do professor?");
            String pegaFormacao = sc.nextLine();
            Integer pegaFormacaoFmt = Integer.valueOf(pegaFormacao);
            String formacao = null;
            if (pegaFormacaoFmt == 1) {
                formacao = "graduação incompleta";
            } else if (pegaFormacaoFmt == 2) {
                formacao = "graduação completa";
            } else if (pegaFormacaoFmt == 3) {
                formacao = "mestrado";

            } else if (pegaFormacaoFmt == 4) {
                formacao = "doutorado";
            } else {
                System.out.println("Opção inválida");
            }
            menuExpProf();
            System.out.println("Qual a experiência em desenvolvimento do professor?");
            String pegaExp = sc.nextLine();
            Integer pegaExpFmt = Integer.valueOf(pegaExp);
            String expDev = null;
            if (pegaExpFmt == 1) {
                expDev = "front-end";
            } else if (pegaExpFmt == 2) {
                expDev = "back-end";
            } else if (pegaExpFmt == 3) {
                expDev = "full-stack";
            } else {
                System.out.println("Opção inválida");
            }
            menuSituacaoProf();
            System.out.println("Qual a situação do professor?");
            String situacao = sc.nextLine();
            Integer situacaoFmt = Integer.valueOf(situacao);
            String estado = null;
            if (situacaoFmt == 1) {
                estado = "ativo";
            } else if (situacaoFmt == 2) {
                estado = "inativo";
            } else {
                System.out.println("Opção inválida");
            }

            pessoa = new Professor(nome, telefone, cpf, data, formacao, expDev, estado);
        } else if (tipo == TipoPessoa.PEDAGOGO) {
            pessoa = new Pedagogo(nome, telefone, cpf, data);
        }
        return pessoa;
    }
}
