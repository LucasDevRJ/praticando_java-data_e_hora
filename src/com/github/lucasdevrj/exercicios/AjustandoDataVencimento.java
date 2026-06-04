/**
 * Você trabalha no setor financeiro de uma empresa de serviços e é responsável por gerenciar
 * o vencimento das faturas dos clientes. Em alguns casos, os clientes solicitam um adiamento
 * da data de pagamento, e o sistema precisa calcular a nova data de vencimento com base na
 * quantidade de meses adicionados.
 *
 * Crie um programa que:
 *
 * Receba uma data de vencimento original.
 * Adicione um número de meses ao vencimento.
 * A data ajustada deve ser exibida no formato dd-MM-yyyy.
 * Saída esperada:
 *
 * Se a data de vencimento original for 20 de março de 2025 e o adiamento for de 1 mês, a saída deve ser:
 * Nova data de vencimento: 20-04-2025
 */

package com.github.lucasdevrj.exercicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AjustandoDataVencimento {
    public static void main(String[] args) {
        LocalDate dataDeVencimento;
        String dataDeVencimentoDigitada = "";
        int numeroDeMesesParaVencimento;

        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite a data de vencimento da fatura: ");
        dataDeVencimentoDigitada = entrada.nextLine();

        while (!dataDeVencimentoDigitada.matches("\\d{2}/\\d{2}/\\d{4}")) {
            System.out.println("Digite uma data válida. Exemplo: 10/03/2026.");
            System.out.print("Digite a data de vencimento da fatura: ");
            dataDeVencimentoDigitada = entrada.nextLine();
        }

        System.out.print("Adicione o número de meses para o vencimento: ");
        numeroDeMesesParaVencimento = entrada.nextInt();

        while (numeroDeMesesParaVencimento <= 0) {
            System.out.println("Digite um número de meses faltante válido!");
            System.out.print("Adicione o número de meses para o vencimento: ");
            numeroDeMesesParaVencimento = entrada.nextInt();
        }

        String[] data = dataDeVencimentoDigitada.split("/");
        int dia = Integer.parseInt(data[0]);
        int mes = Integer.parseInt(data[1]);
        int ano = Integer.parseInt(data[2]);

        dataDeVencimento = LocalDate.of(ano, mes, dia);
        dataDeVencimento = dataDeVencimento.plusMonths(numeroDeMesesParaVencimento);

        DateTimeFormatter formatoDaData = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dataFormatada = dataDeVencimento.format(formatoDaData);

        System.out.println("Nova data de vencimento: " + dataFormatada);

        entrada.close();
    }
}
