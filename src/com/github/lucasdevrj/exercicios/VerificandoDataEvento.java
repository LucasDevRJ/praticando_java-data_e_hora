/**
 * Você trabalha em uma agência de turismo e é responsável pelo agendamento de eventos
 * como passeios e excursões. Para garantir uma boa organização, o sistema precisa verificar
 * se um evento já ocorreu ou ainda está por vir com base na data atual.
 *
 * Crie um programa que:
 *
 * Receba uma data de evento previamente cadastrada.
 * Compare essa data com a data atual.
 * Exiba a data do evento e a data atual no formato dd-MM-yyyy.
 * Informe se o evento já ocorreu ou ainda está por vir.
 * Saída esperada:
 *
 * Se a data do evento for 10 de março de 2025 e a data atual for 15 de março de 2025, a saída deve ser:
 *
 * Data do evento: 10-03-2025
 * Data atual: 15-03-2025
 * O evento já ocorreu.
 */

package com.github.lucasdevrj.exercicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class VerificandoDataEvento {
    public static void main(String[] args) {
        LocalDate dataDoEvento;
        LocalDate dataAtual = LocalDate.now();
        String dataDoEventoDigitada = "";
        String resposta = "";
        boolean eventoJaPassou = false;

        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite a data do evento: ");
        dataDoEventoDigitada = entrada.nextLine();

        while (!dataDoEventoDigitada.matches("\\d{2}/\\d{2}/\\d{4}")) {
            System.out.println("Digite uma data válida. Exemplo: 10/03/2026.");
            System.out.println("Digite a data do evento: ");
            dataDoEventoDigitada = entrada.nextLine();
        }

        entrada.close();

        String[] data = dataDoEventoDigitada.split("/");
        int dia = Integer.parseInt(data[0]);
        int mes = Integer.parseInt(data[1]);
        int ano = Integer.parseInt(data[2]);

        dataDoEvento = LocalDate.of(ano, mes, dia);

        eventoJaPassou = dataDoEvento.isAfter(dataAtual);
        resposta = eventoJaPassou ? "O evento não ocorreu." : "O evento já ocorreu.";

        DateTimeFormatter formatoDaData = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String resultado = String.format(
                "Data do evento: %s\nData atual: %s\n%s",
                dataDoEvento.format(formatoDaData),
                dataAtual.format(formatoDaData),
                resposta
        );

        System.out.println(resultado);
    }
}
