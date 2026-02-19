package br.edu.ifsp.list01;

import java.util.Scanner;

/*
    Faça um programa que leia um conjunto de valores que correspondem as idades de pessoas de uma comunidade. Quando
    o valor fornecido for um número negativo, significa que não existem mais idades para serem lidas. Após a leitura,
    o programa deve informar:

    A média das idades das pessoas (com duas casas decimais)
    A quantidade de pessoas maiores de idade
    A porcentagem de pessoas idosas (considere quem uma pessoa idosa tem mais de 75 anos) (com duas casas decimais)

    Exemplos de entrada e saída:
    | Entrada             | Saída          |
    | -------             | ------         |
    | 10 20 30 80 -1      | 35.00 3 25.00% |
    | 25 30 45 -1         | 33.33 3 0.00%  |
    => Exercício gentilmente cedido pelos profs. Jorge Cutigi (IFSP/SCL) e Adenilso Simão (ICMC/USP)
*/
public class Ex09 {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        java.util.ArrayList<Integer> lista = new java.util.ArrayList<>();

        int idade = scanner.nextInt();

        while (idade >= 0) {
            lista.add(idade);
            idade = scanner.nextInt();
        }

        int[] input = new int[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            input[i] = lista.get(i);
        }


        final Ex09 ex09 = new Ex09();
        System.out.println(ex09.compute(input));

    }

    String compute(int[] input) {
        int n = 0;
        int soma = 0;
        int deMaior = 0;
        int idoso =0;
        for(int i = 0; i < input.length; i++) {
            if(input[i] >= 0) {
                soma += input[i];
                n++;
                if (input[i] >= 18) {
                    deMaior++;
                }
                if (input[i] > 75) {
                    idoso++;
                }
            }
        }

        double media = (double) soma / n;
        double p_idoso = ((double) idoso / n) * 100;

        return String.format(java.util.Locale.US, "%.2f %d %.2f%%", media, deMaior, p_idoso);

    }
}
