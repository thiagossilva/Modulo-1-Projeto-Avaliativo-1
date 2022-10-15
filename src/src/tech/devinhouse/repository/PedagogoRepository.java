package tech.devinhouse.repository;

import tech.devinhouse.cli.Interacoes;
import tech.devinhouse.models.Pedagogo;
import tech.devinhouse.models.Pessoa;

import java.util.*;

public class PedagogoRepository {
    private List<Pessoa> dadosPessoa = new ArrayList<>();
    Interacoes interacoes = new Interacoes();

    public void listarPedagogo(List<Pessoa> pessoas) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Pedagogo) {
                Pedagogo pedagogo = (Pedagogo) pessoa;
                System.out.println("Código: " + pedagogo.getCodigo() + ", nome: " + pedagogo.getNome() + ", CPF: " + pedagogo.getCpf());
            }
        }
    }

    public int solicitarIdPedagogo() {
        System.out.print("Insira o ID do pedagogo: ");
        Scanner sc = new Scanner(System.in);
        String recebeId = sc.nextLine();
        Integer id = null;
        try {
            id = Integer.valueOf(recebeId);
        } catch (NumberFormatException e) {
            System.out.println(interacoes.vermelho + "Impossível realizar sem ID do pedagogo" + interacoes.resetarCor);
        }
        return id;
    }

    public void atendimentoPedagogo(int id, List<Pessoa> dadosPessoa) {
        try {
            for (Pessoa pedagogo : dadosPessoa) {
                if (pedagogo.getCodigo() == id) {
                    Pedagogo atdPedagogo = (Pedagogo) pedagogo;
                    Integer aumentaAtd = atdPedagogo.getQtdAtendimentos();
                    atdPedagogo.setQtdAtendimentos(++aumentaAtd);
                    System.out.println("Atendimento realizado");
                }
            }
        } catch (ClassCastException e) {
            System.out.println(interacoes.vermelho + "Só é possível a situação do aluno" + interacoes.resetarCor);
        }
    }

    public void listarPedagogosOrdenados(List<Pessoa> dadosPessoa) {
        List<Pedagogo> listaPedagogosOrdenados = new ArrayList<>();
        for (Pessoa pessoa : dadosPessoa) {
            if (pessoa instanceof Pedagogo) {
                listaPedagogosOrdenados.add((Pedagogo) pessoa);
            }
        }
        Collections.sort(listaPedagogosOrdenados, Comparator.comparingInt(Pedagogo::getQtdAtendimentos).reversed());
        for (Pessoa pedagogoOrdenado : listaPedagogosOrdenados) {
            Pedagogo pedagogoOrdem = (Pedagogo) pedagogoOrdenado;
            System.out.println("Código: " + pedagogoOrdem.getCodigo() + ", nome: " + pedagogoOrdem.getNome()
                    + ", total de atendimentos = "
                    + pedagogoOrdem.getQtdAtendimentos());
        }
    }
}
