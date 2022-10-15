package tech.devinhouse.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pessoa {

    protected String nome;
    protected String telefone;
    protected String cpf;
    protected Date dataNasc;
    protected Integer codigo;

    public Pessoa() {}
    private SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
    public Pessoa(String nome, String telefone, String CPF, Date dataNasc) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = CPF;
        this.dataNasc = dataNasc;

    }

    @Override
    public String toString() {
        return "Nome= " + nome +
                ", Telefone= " + telefone +
                ", cpf= " + cpf +
                ", dataNasc= " + formata.format(dataNasc) +
                ", codigo= " + codigo;
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
