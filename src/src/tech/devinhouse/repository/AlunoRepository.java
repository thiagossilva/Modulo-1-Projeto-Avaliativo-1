package tech.devinhouse.repository;

import tech.devinhouse.cli.Display;
import tech.devinhouse.cli.Interacoes;
import tech.devinhouse.models.Aluno;
import tech.devinhouse.models.Pessoa;

import java.util.*;

public class AlunoRepository {
    private List<Pessoa> dadosPessoa = new ArrayList<>();
    Display display = new Display();
    Interacoes interacoes = new Interacoes();
    Scanner sc = new Scanner(System.in);

    public void listarAluno(List<Pessoa> pessoas) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Aluno) {
                Aluno aluno = (Aluno) pessoa;
                System.out.println("Código: " + aluno.getCodigo() + ", nome: " + aluno.getNome() + ", CPF: " + aluno.getCpf());
            }
        }
    }

    public int solicitarIdAluno() {
        System.out.print("Insira o ID do aluno: ");
        String recebeId = sc.nextLine();
        Integer id = null;
        try {
            id = Integer.valueOf(recebeId);
        } catch (NumberFormatException e) {
            System.out.println(interacoes.vermelho + "É preciso informar o ID do aluno" + interacoes.resetarCor);
        }
        return id;
    }

    public void atualizarAluno(int id, List<Pessoa> dadosPessoa) {
        System.out.println("Escolha a atualização de situação do aluno");
        display.menuSituacaoAluno();
        String situacao = sc.nextLine();
        Integer situacaoFmt = null;
        try {
           situacaoFmt = Integer.valueOf(situacao);
        } catch (NumberFormatException e) {
            System.out.println(interacoes.vermelho + "É preciso selecionar a situação do aluno" + interacoes.resetarCor);
        } if (situacaoFmt == 1) {
            for (Pessoa aluno : dadosPessoa) {
                if (aluno.getCodigo() == id) {
                    Aluno alunoAlterarSituacao = (Aluno) aluno;
                    alunoAlterarSituacao.setSituacaoMatricula("ativo");
                    System.out.println(interacoes.verde + "Situação alterada com sucesso!"+ interacoes.resetarCor);
                } else {
                    System.out.println("Não foi possível encontrar aluno com esse ID");
                }
            }
        } else if (situacaoFmt == 2) {
            for (Pessoa aluno : dadosPessoa) {
                if (aluno.getCodigo() == id) {
                    Aluno alunoAlterarSituacao = (Aluno) aluno;
                    alunoAlterarSituacao.setSituacaoMatricula("inativo");
                    System.out.println(interacoes.verde + "Situação alterada com sucesso!"+ interacoes.resetarCor);
                } else {
                    System.out.println("Não foi possível encontrar aluno com esse ID");
                }
            }
        } else if (situacaoFmt == 3) {
            for (Pessoa aluno : dadosPessoa) {
                if (aluno.getCodigo() == id) {
                    Aluno alunoAlterarSituacao = (Aluno) aluno;
                    alunoAlterarSituacao.setSituacaoMatricula("atendimento pedagógico");
                    System.out.println(interacoes.verde + "Situação alterada com sucesso!"+ interacoes.resetarCor);
                } else {
                    System.out.println("Não foi possível encontrar aluno com esse ID");
                }
            }
        } else if (situacaoFmt == 4) {
            for (Pessoa aluno : dadosPessoa) {
                if (aluno.getCodigo() == id) {
                    Aluno alunoAlterarSituacao = (Aluno) aluno;
                    alunoAlterarSituacao.setSituacaoMatricula("irregular");
                    System.out.println(interacoes.verde + "Situação alterada com sucesso!"+ interacoes.resetarCor);
                } else {
                    System.out.println("Não foi possível encontrar aluno com esse ID");
                }
            }
        } else {
            System.out.println("Opção incorreta");
        }

    }

    public void atendimentoAluno(int id, List<Pessoa> dadosPessoa) {
        try {
            for (Pessoa aluno : dadosPessoa) {
                if (aluno.getCodigo() == id) {
                    Aluno atdAluno = (Aluno) aluno;
                    atdAluno.setSituacaoMatricula("atendimento pedagógico");
                    Integer aumentaAtd = atdAluno.getQtdAtendimentos();
                    atdAluno.setQtdAtendimentos(++aumentaAtd);
                    System.out.println("Matrícula atualizada com sucesso!");
                } else {
                    System.out.println("Não foi possível encontrar aluno com esse ID");
                }
            }
        } catch (ClassCastException e) {
            System.out.println(interacoes.vermelho + "Impossível realizar sem ID do aluno" + interacoes.resetarCor);
        }
    }

    public void listarAlunosAtivos(List<Pessoa> dadosPessoa) {
        for (Pessoa aluno : dadosPessoa) {
            Aluno alunoAtivo = (Aluno) aluno;
            if (alunoAtivo.getSituacaoMatricula().equals("ativo")) {
                System.out.println("Codigo: " + alunoAtivo.getCodigo() + ", nome: " + alunoAtivo.getNome() + "," +
                        " nota: " + alunoAtivo.getNota() +
                        ", total de atendimentos = " + alunoAtivo.getQtdAtendimentos());
            }
        }
    }

    public void listarAlunosIrregulares(List<Pessoa> dadosPessoa) {
        for (Pessoa aluno : dadosPessoa) {
            Aluno alunoIrregular = (Aluno) aluno;
            if (alunoIrregular.getSituacaoMatricula().equals("irregular")) {
                System.out.println("Codigo: " + alunoIrregular.getCodigo() + ", nome: " + alunoIrregular.getNome() + "," +
                        " nota: " + alunoIrregular.getNota() +
                        ", total de atendimentos = " + alunoIrregular.getQtdAtendimentos());
            }
        }
    }

    public void listarAlunosInativos(List<Pessoa> dadosPessoa) {
        for (Pessoa aluno : dadosPessoa) {
            Aluno alunoInativo = (Aluno) aluno;
            if (alunoInativo.getSituacaoMatricula().equals("inativo")) {
                System.out.println("Codigo: " + alunoInativo.getCodigo() + ", nome: " + alunoInativo.getNome() + "," +
                        " nota: " + alunoInativo.getNota() +
                        ", total de atendimentos = " + alunoInativo.getQtdAtendimentos());
            }
        }
    }

    public void listarAlunosEmAtendimento(List<Pessoa> dadosPessoa) {
        for (Pessoa aluno : dadosPessoa) {
            Aluno alunoAtendimento = (Aluno) aluno;
            if (alunoAtendimento.getSituacaoMatricula().equals("atendimento pedagógico")) {
                System.out.println("Codigo: " + alunoAtendimento.getCodigo() + ", nome: " + alunoAtendimento.getNome() + "," +
                        " nota: " + alunoAtendimento.getNota() +
                        ", total de atendimentos = " + alunoAtendimento.getQtdAtendimentos());
            }
        }
    }

    public void listarAlunoComNota(List<Pessoa> dadosPessoa) {
        for (Pessoa pessoa : dadosPessoa) {
            if (pessoa instanceof Aluno) {
                Aluno alunoTodos = (Aluno) pessoa;
                System.out.println("Código: " + alunoTodos.getCodigo() + ", nome: " + alunoTodos.getNome() + ",nota = " + alunoTodos.getNota() + ", total de atendimentos = " + alunoTodos.getQtdAtendimentos());
            }
        }
    }

    public void listarAlunosOrdenados(List<Pessoa> dadosPessoa) {
        List<Aluno> listaAlunosOrdenados = new ArrayList<>();
        for (Pessoa pessoa : dadosPessoa) {
            if (pessoa instanceof Aluno) {
                listaAlunosOrdenados.add((Aluno) pessoa);
            }
        }
        Collections.sort(listaAlunosOrdenados, Comparator.comparingInt(Aluno::getQtdAtendimentos).reversed());
        for (Pessoa alunoOrdenado : listaAlunosOrdenados) {
            Aluno alunoOrdem = (Aluno) alunoOrdenado;
            System.out.println("Código: " + alunoOrdem.getCodigo() + ", nome: " + alunoOrdem.getNome()
                    + ", total de atendimentos = "
                    + alunoOrdem.getQtdAtendimentos());
        }
    }


}
