package tech.devinhouse.models;

import java.util.Date;

public class Pedagogo extends Pessoa{
    public Integer qtdAtendimentos = 0;

    public Pedagogo(String nome, String telefone, String CPF, Date dataNasc) {
        super(nome, telefone, CPF, dataNasc);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", quantidade de atendimentos = " + qtdAtendimentos;
    }

    public Integer getQtdAtendimentos() {
        return qtdAtendimentos;
    }

    public void setQtdAtendimentos(Integer qtdAtendimentos) {
        this.qtdAtendimentos = qtdAtendimentos;
    }

}
