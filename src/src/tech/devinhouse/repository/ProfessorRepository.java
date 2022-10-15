package tech.devinhouse.repository;

import tech.devinhouse.models.Pessoa;
import tech.devinhouse.models.Professor;

import java.util.ArrayList;
import java.util.List;

public class ProfessorRepository {
    private List<Pessoa> dadosPessoa = new ArrayList<>();


    public void listarProfessor(List<Pessoa> pessoas) {
        for (Pessoa pessoa: pessoas) {
            if (pessoa instanceof Professor) {
                Professor professor = (Professor) pessoa;
                System.out.println("Código: " + professor.getCodigo() + ", nome: " + professor.getNome() + ", CPF: " + professor.getCpf());
            }
        }
    }

    public void listarFrontEnd(List<Pessoa> dadosPessoa) {
        for (Pessoa professor : dadosPessoa) {
           if (professor instanceof Professor) {
               Professor professorFront = (Professor) professor;
               if (professorFront.equals(null)) {
                   System.out.println("Lista vazia");
               }
               else if (professorFront.getExpDev().equals("front-end")) {
                   System.out.println("Codigo: " + professorFront.getCodigo() + ", nome: " + professorFront.getNome() +
                           ", formação acadêmica: " + professorFront.getFormacaoAcademica() + ", estado: " + professorFront.getEstado());
               }
           }
        }
    }

    public void listarBackEnd(List<Pessoa> dadosPessoa) {
        for (Pessoa professor : dadosPessoa) {
            if (professor instanceof Professor) {
                Professor professorBack = (Professor) professor;
                if (professorBack.getExpDev().equals("back-end")) {
                    System.out.println("Codigo: " + professorBack.getCodigo() + ", nome: " + professorBack.getNome() +
                            ", formação acadêmica: " + professorBack.getFormacaoAcademica() + ", estado: " + professorBack.getEstado());
                }
            }
        }
    }

    public void listarFull(List<Pessoa> dadosPessoa) {
        for (Pessoa professor : dadosPessoa) {
            if (professor instanceof Professor) {
                Professor professorFull = (Professor) professor;
                if (professorFull.getExpDev().equals("full-stack")) {
                    System.out.println("Codigo: " + professorFull.getCodigo() + ", nome: " + professorFull.getNome() +
                            ", formação acadêmica: " + professorFull.getFormacaoAcademica() + ", estado: " + professorFull.getEstado());
                }
            } else {
                System.out.println("Lista de professores está vazia");
            }
        }
    }
    public void listarTodosProf(List<Pessoa> dadosPessoa) {
        for (Pessoa professor : dadosPessoa) {
            if (professor instanceof Professor) {
                Professor professorFull = (Professor) professor;
                System.out.println("Codigo: " + professorFull.getCodigo() + ", nome: " + professorFull.getNome() +
                        ", formação acadêmica: " + professorFull.getFormacaoAcademica() + ", estado: " + professorFull.getEstado());
            }
        }
    }

}
