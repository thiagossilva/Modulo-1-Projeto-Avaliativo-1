package tech.devinhouse.models;

import java.util.Date;

public class Professor extends Pessoa {
    private String formacaoAcademica;
    private String expDev;
    private String estado;

    public Professor(String nome, String telefone, String CPF, Date dataNasc, String formacaoAcademica, String expDev, String estado) {
        super(nome, telefone, CPF, dataNasc);
        this.formacaoAcademica = formacaoAcademica;
        this.expDev = expDev;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return super.toString() +
                " formacaoAcademica= " + formacaoAcademica +
                ", experiência em desenvolvimento: " + expDev +
                ", situação atual: " + estado;
    }

    public String getFormacaoAcademica() {
        return formacaoAcademica;
    }

    public String getExpDev() {
        return expDev;
    }

    public String getEstado() {
        return estado;
    }


}
