package tech.devinhouse;

import tech.devinhouse.cli.Display;
import tech.devinhouse.cli.Interacoes;
import tech.devinhouse.exception.OpcaoInvalidaMenu;
import tech.devinhouse.models.Operacao;
import tech.devinhouse.models.Pessoa;
import tech.devinhouse.models.TipoPessoa;
import tech.devinhouse.repository.AlunoRepository;
import tech.devinhouse.repository.PedagogoRepository;
import tech.devinhouse.repository.PessoaRepository;
import tech.devinhouse.repository.ProfessorRepository;

import java.util.List;
import java.util.Scanner;

public class Aplicacao {
    Scanner sc = new Scanner(System.in);
    private PessoaRepository repo = new PessoaRepository();
    private AlunoRepository repoAluno = new AlunoRepository();
    private PedagogoRepository repoPedagogo = new PedagogoRepository();
    private ProfessorRepository repoProf = new ProfessorRepository();

    private Display display = new Display();
    private Interacoes interacoes = new Interacoes();
    //  private Pessoa pessoa = new Pessoa();


    public void executar() {
        Operacao operacao = null;

        while (operacao != Operacao.SAIR) {
            display.exibirMenu();
            try {
                operacao = display.obterOperacao();
                processar(operacao);
            } catch (NullPointerException e) {

            } catch (OpcaoInvalidaMenu e) {
                System.out.println(interacoes.vermelho + "A opção escolhida é inválida!" + interacoes.resetarCor);
            }
        }
    }

    private void processar(Operacao operacao) {
        switch (operacao) {
            case CADASTRAR:
                display.menuListarCadastro();
                System.out.print("Escolha a opção que deseja cadastrar: ");
                String opcao = sc.nextLine();
                Integer opcaoFormatada = null;

                try {
                    opcaoFormatada = Integer.valueOf(opcao);
                } catch (NumberFormatException e) {
                    System.out.println("Digite apenas números");
                }
                if (opcaoFormatada == 1) {
                    Pessoa aluno = display.cadastrar(TipoPessoa.ALUNO);
                    repo.inserir(aluno);
                    interacoes.msg("Aluno adicionado com id " + aluno.getCodigo());
                } else if (opcaoFormatada == 2) {
                    Pessoa professor = display.cadastrar(TipoPessoa.PROFESSOR);
                    repo.inserir(professor);
                    interacoes.msg("Professor adicionado com id " + professor.getCodigo());
                } else if (opcaoFormatada == 3) {
                    Pessoa pedagogo = display.cadastrar(TipoPessoa.PEDAGOGO);
                    repo.inserir(pedagogo);
                    interacoes.msg("Pedagogo adicionado com id " + pedagogo.getCodigo());
                } else {
                    System.out.println();
                    System.out.println("Opção inválida!");
                    executar();
                }
                interacoes.aguardar();
                break;
            case LISTAR:
                display.menuListarPessoa();
                System.out.print("Escolha a opção que deseja listar: ");
                String opcaoListar = sc.nextLine();
                Integer opcaoListarFormatada = null;
                try {
                    opcaoListarFormatada = Integer.valueOf(opcaoListar);
                } catch (NumberFormatException e) {
                    System.out.println(interacoes.vermelho + "Escolha apenas as opções exibidas" + interacoes.resetarCor);
                }
                if (opcaoListarFormatada == 1) {
                    List<Pessoa> aluno = repo.obterPessoas();
                    if (aluno.isEmpty()) {
                        System.out.println("Impossível consultar lista vazia");
                    } else {
                        repoAluno.listarAluno(aluno);
                    }
                } else if (opcaoListarFormatada == 2) {
                    List<Pessoa> professor = repo.obterPessoas();
                    if (professor.isEmpty()) {
                        System.out.println("Impossível consultar lista vazia");
                    } else {
                        repoProf.listarProfessor(professor);
                    }
                } else if (opcaoListarFormatada == 3) {
                    List<Pessoa> pedagogo = repo.obterPessoas();
                    if (pedagogo.isEmpty()) {
                        System.out.println("Impossível consultar lista vazia");
                    } else {
                        repoPedagogo.listarPedagogo(pedagogo);
                    }
                } else if (opcaoListarFormatada == 4) {
                    List<Pessoa> pessoa = repo.obterPessoas();
                    if (pessoa.isEmpty()) {
                        System.out.println("Impossível consultar lista vazia");
                    } else {
                        repo.listarTodos(pessoa);
                    }
                } else {
                    System.out.println("Opção inválida");
                }
                interacoes.aguardar();
                break;
            case RELATORIOS:
                display.menuRelatorios();
                System.out.print("Escolha a opção que deseja listar: ");
                String opcaoRelatorios = sc.nextLine();
                Integer listarRelatorios = Integer.valueOf(opcaoRelatorios);
                if (listarRelatorios == 1) {
                    List<Pessoa> obterListaParaExibirAlunos = repo.obterPessoas();
                    display.relatorioAlunos();
                    System.out.print("Escolha a opção que deseja listar: ");
                    String listarAlunos = sc.nextLine();
                    Integer listarAlunosFormatado = null;
                    try {
                        listarAlunosFormatado = Integer.valueOf(listarAlunos);
                    } catch (NumberFormatException e) {
                        System.out.println("Insira a opção desejado");
                    }
                    if (listarAlunosFormatado == 1) {
                        repoAluno.listarAlunosAtivos(obterListaParaExibirAlunos);
                    } else if (listarAlunosFormatado == 2) {
                        repoAluno.listarAlunosIrregulares(obterListaParaExibirAlunos);
                    } else if (listarAlunosFormatado == 3) {
                        repoAluno.listarAlunosEmAtendimento(obterListaParaExibirAlunos);
                    } else if (listarAlunosFormatado == 4) {
                        repoAluno.listarAlunosInativos(obterListaParaExibirAlunos);
                    } else if (listarAlunosFormatado == 5) {
                        repoAluno.listarAlunosOrdenados(obterListaParaExibirAlunos);
                    } else if (listarAlunosFormatado == 6) {
                        repoAluno.listarAlunoComNota(obterListaParaExibirAlunos);
                    } else {
                        System.out.println("Opção inválida!");
                    }
                } else if (listarRelatorios == 2) {
                    display.relatorioProfessores();
                    List<Pessoa> relatoriosProfessores = repo.obterPessoas();
                    System.out.println("Escolha como deseja listar de acordo com a experiência do professor");
                    String listarProfessores = sc.nextLine();
                    Integer listarProfessoresFmt = null;
                    try {
                        listarProfessoresFmt = Integer.valueOf(listarProfessores);
                    } catch (NumberFormatException e) {
                        System.out.println("Insira a opção desejada");
                    }
                    if (listarProfessoresFmt == 1) {
                        repoProf.listarFrontEnd(relatoriosProfessores);
                    } else if (listarProfessoresFmt == 2) {
                        repoProf.listarBackEnd(relatoriosProfessores);
                    } else if (listarProfessoresFmt == 3) {
                        repoProf.listarFull(relatoriosProfessores);
                    } else if (listarProfessoresFmt == 4) {
                        repoProf.listarTodosProf(relatoriosProfessores);
                    } else {
                        System.out.println("Opção inválida!");
                    }
                } else if (listarRelatorios == 3) {
                    List<Pessoa> obterListaParaExibirPedagogos = repo.obterPessoas();
                    repoPedagogo.listarPedagogosOrdenados(obterListaParaExibirPedagogos);
                } else {
                    System.out.println("Opção inválida");
                }
                interacoes.aguardar();
                break;
            case ALTERAR_SITUACAO_ALUNO:
                int id = repoAluno.solicitarIdAluno();
                Pessoa aluno = repo.consultarPorId(id);
                if (aluno == null) {
                    System.out.println(interacoes.vermelho + "Impossível listar sem alunos cadastrados" + interacoes.resetarCor);
                    break;
                } else {
                    repo.listar(aluno);
                }

                repoAluno.atualizarAluno(id, repo.obterPessoas());
                interacoes.aguardar();
                break;
            case REALIZAR_ATENDIMENTO:
                List<Pessoa> listaParaAtendimentos = repo.obterPessoas();
                if (listaParaAtendimentos.isEmpty()) {
                    System.out.println(interacoes.vermelho + "Não é possivel realizar atendimentos com lista vazia" + interacoes.resetarCor);
                } else {
                    display.participantesAtendimento();
                    int idAtdAluno = repoAluno.solicitarIdAluno();
                    repoAluno.atendimentoAluno(idAtdAluno, listaParaAtendimentos);
                    int idAtdPedagogo = repoPedagogo.solicitarIdPedagogo();
                    repoPedagogo.atendimentoPedagogo(idAtdPedagogo, listaParaAtendimentos);
                }
        }
    }


}


