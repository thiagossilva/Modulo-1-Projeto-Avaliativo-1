package tech.devinhouse.repository;

import tech.devinhouse.models.Aluno;
import tech.devinhouse.models.Pedagogo;
import tech.devinhouse.models.Pessoa;
import tech.devinhouse.models.Professor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PessoaRepository {
    private List<Pessoa> dadosPessoa = new ArrayList<>();

    private static Integer idInicial = 0;

    // Adiciona a pessoa na lista e seta o codigo como codigo atual +1

//    public List<Pessoa> obterNova() {
//        return new ArrayList<>(dadosPessoa);
//    }
    public Pessoa inserir(Pessoa pessoa) {
        pessoa.setCodigo(++idInicial);
        dadosPessoa.add(pessoa);
        return pessoa;
    }

    public List<Pessoa> obterPessoas() {
        return dadosPessoa;
    }


    public void listarTodos(List<Pessoa> pessoas) {
        for (Pessoa pessoa: pessoas) {
            System.out.println(pessoa);
        }
    }
    public void listar(Pessoa pessoa) {
        System.out.println(pessoa);
    }

    // solicita o ID do aluno que será exibido


    // exibe a pessoa cadastrada filtrado pelo id
    public Pessoa consultarPorId(int id) {
        for (Pessoa pessoa: dadosPessoa) {
            if (pessoa.getCodigo() == id)
                return pessoa;
        }
        return null;
    }
}
