/**
 * Você trabalha no setor administrativo de uma empresa e precisa de um sistema para acompanhar
 * os horários de entrada e saída dos funcionários. O sistema deve calcular o horário de saída
 * com base na hora de entrada e na carga horária diária.
 *
 * Além disso, para controle de banco de horas, o sistema deve calcular quantas horas um funcionário
 * trabalhou a mais ou a menos, caso o expediente tenha durado mais ou menos que o previsto.
 *
 * O programa deve:
 *
 * Capturar o horário de entrada.
 * Adicionar a carga horária diária para calcular o horário de saída previsto.
 * Capturar o horário real de saída
 * Calcular a diferença entre o tempo trabalhado e a carga horária.
 * Exibir as informações formatadas corretamente.
 */

package com.github.lucasdevrj.exercicios;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class ControleDoExpediente {
    public static void main(String[] args) {
        DateTimeFormatter formatoDoHorario = DateTimeFormatter.ofPattern("HH:mm");
        Scanner entrada = new Scanner(System.in);

        // Horário de entrada
        System.out.print("Digite o horário de entrada (Ex: HH:mm): ");
        LocalTime horarioDeEntrada = LocalTime.parse(entrada.next(), formatoDoHorario);

        // Carga horária
        int cargaHoraria;
        do {
            System.out.print("Digite a carga horária diária em horas: ");
            cargaHoraria = entrada.nextInt();
            if (cargaHoraria < 4) {
                System.out.println("Digite uma carga horária maior ou igual a 4 horas.");
            }
        } while (cargaHoraria < 4);

        // Horário de saída
        LocalTime horarioDeSaida;
        do {
            System.out.print("Digite o horário de saída (Ex: HH:mm): ");
            horarioDeSaida = LocalTime.parse(entrada.next(), formatoDoHorario);
            if (!horarioDeSaida.isAfter(horarioDeEntrada)) {
                System.out.println("Horário de saída tem que ser posterior ao de entrada.");
            }
        } while (!horarioDeSaida.isAfter(horarioDeEntrada));

        entrada.close();

        // Saída prevista
        LocalTime horarioDeSaidaPrevisto = horarioDeEntrada.plusHours(cargaHoraria);

        // ✅ Saldo em minutos
        long minutesTrabalhados = ChronoUnit.MINUTES.between(horarioDeEntrada, horarioDeSaida);
        long minutesEsperados   = cargaHoraria * 60L;
        long saldoTotalMinutos  = minutesTrabalhados - minutesEsperados;

        long saldoHoras   = saldoTotalMinutos / 60;
        long saldoMinutos = Math.abs(saldoTotalMinutos % 60);

        // Formatando saldo
        String sinal = saldoTotalMinutos >= 0 ? "+" : "-";
        String saldoFormatado = "%s%dh %dmin".formatted(sinal, Math.abs(saldoHoras), saldoMinutos);

        // Resultado
        String resultado = """
                Horário de entrada       : %s
                Horário de saída previsto: %s
                Horário real de saída    : %s
                Saldo de horas           : %s
                """.formatted(
                horarioDeEntrada.format(formatoDoHorario),
                horarioDeSaidaPrevisto.format(formatoDoHorario),
                horarioDeSaida.format(formatoDoHorario),
                saldoFormatado
        );

        System.out.println(resultado);
    }
}