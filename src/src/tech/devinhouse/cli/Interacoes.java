package tech.devinhouse.cli;

import java.util.Scanner;

public class Interacoes {
    public void msg(String msg) {
        System.out.println(msg);
    }

    public void aguardar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Pressione enter para continuar...");
        sc.nextLine();
    }

    public static final String resetarCor = "\u001B[0m";
    public static final String vermelho = "\u001B[31m";
    public static final String verde = "\u001B[32m";
}
