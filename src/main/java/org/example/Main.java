package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o numero que deseja: ");
        int num = scanner.nextInt();

        System.out.println(Exercicios.fibonacci(num));

        Exercicios.FaturamentoDistribuidora();

        EstadoValor sP = new EstadoValor("SP", 67836.43);
        EstadoValor rJ = new EstadoValor("RJ", 36678.66);
        EstadoValor mG = new EstadoValor("MG", 29229.88);
        EstadoValor eS = new EstadoValor("ES", 27165.48);
        EstadoValor outros = new EstadoValor("Outros", 19849.53);

        // TODO escalavel para alteração pelo usuario

        Exercicios.faturamentoMensal(EstadoValor.estados);
        Exercicios.reverseString("Carlos");

        scanner.close();
    }
}