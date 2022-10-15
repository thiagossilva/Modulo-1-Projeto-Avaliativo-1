package tech.devinhouse.models;

import java.util.Date;

public class Aluno extends Pessoa {
    private String situacaoMatricula;
    private Double nota;
    public Integer qtdAtendimentos = 0;


    public Aluno(String nome, String telefone, String CPF, Date dataNasc, String situacaoMatricula, Double nota) {
        super(nome, telefone, CPF, dataNasc);
        this.situacaoMatricula = situacaoMatricula;
        this.nota = nota;
    }

    @Override
    public String toString() {
        return  super.toString() +
                ", situação da matricula = " + situacaoMatricula + ", nota do aluno = " + nota + ", quantidade de atendimentos pedagógicos = " + qtdAtendimentos;
    }

    public Integer getQtdAtendimentos() {
        return qtdAtendimentos;
    }

    public void setQtdAtendimentos(Integer qtdAtendimentos) {
        this.qtdAtendimentos = qtdAtendimentos;
    }

    public String getSituacaoMatricula() {
        return situacaoMatricula;
    }

    public void setSituacaoMatricula(String situacaoMatricula) {
        this.situacaoMatricula = situacaoMatricula;
    }

    public Double getNota() {
        return nota;
    }

}
