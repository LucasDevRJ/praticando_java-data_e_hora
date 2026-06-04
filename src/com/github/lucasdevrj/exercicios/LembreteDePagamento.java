/**
 * Você trabalha no setor financeiro de uma empresa e precisa garantir que as contas sejam
 * pagas antes do vencimento. Para isso, o sistema deve calcular a data exata em que um
 * lembrete de pagamento deve ser disparado com base no prazo de antecedência definido.
 *
 * Por exemplo, se uma conta vence no dia 20 de um mês e os lembretes devem ser enviados
 * 10 dias antes, a notificação deve ser disparada no dia 10. Já se o vencimento for 30
 * de março de 2025 e a antecedência for de 5 dias, o lembrete deverá ser enviado no dia
 * 25 de março de 2025.
 *
 * Crie um programa que, a partir de uma data de vencimento e um período de antecedência em dias,
 * calcule e exiba a data que o lembrete para pagamento deve ser disparado.
 *
 * Saída esperada:
 *
 * Se a data de vencimento for 30 de março de 2025 e o período de antecedência for 5 dias, a saída deve ser:
 * Data do lembrete: 25-03-2025
 */

package com.github.lucasdevrj.exercicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LembreteDePagamento {
    public static void main(String[] args) {
        LocalDate dataDeVencimento;
        LocalDate dataDoLembrete;
        String dataDeVencimentoDigitada = "";
        int diasDeAntecedencia = 0;

        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite a data de vencimento: ");
        dataDeVencimentoDigitada = entrada.nextLine();

        while (!dataDeVencimentoDigitada.matches("\\d{2}/\\d{2}/\\d{4}")) {
            System.out.println("Digite uma data válida. Exemplo: 10/03/2026.");
            System.out.print("Digite a data de vencimento: ");
            dataDeVencimentoDigitada = entrada.nextLine();
        }

        System.out.print("Digite o período de antecedencia em dias: ");
        diasDeAntecedencia = entrada.nextInt();

        while (diasDeAntecedencia <= 0) {
            System.out.println("Digite um período de antecedencia válido. Exemplo: 5");
            System.out.print("Digite o período de antecedencia em dias: ");
            diasDeAntecedencia = entrada.nextInt();
        }

        entrada.close();

        String[] data = dataDeVencimentoDigitada.split("/");
        int dia = Integer.parseInt(data[0]);
        int mes = Integer.parseInt(data[1]);
        int ano = Integer.parseInt(data[2]);
        dataDeVencimento = LocalDate.of(ano, mes, dia);
        dataDoLembrete = LocalDate.of(ano, mes, dia);

        dataDoLembrete = dataDoLembrete.minusDays(diasDeAntecedencia);

        DateTimeFormatter formatoDaData = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println("Data do lembrete: " + dataDoLembrete.format(formatoDaData));
    }
}
