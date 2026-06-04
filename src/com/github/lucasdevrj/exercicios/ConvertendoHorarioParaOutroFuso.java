/**
 * Você trabalha em uma empresa global e precisa agendar reuniões com colegas da Austrália.
 * Como os horários variam de acordo com o fuso horário, você precisa de um sistema que
 * converta automaticamente o horário local para o horário de Sydney.
 *
 * Crie um programa que converta o horário atual do sistema (fuso horário padrão) para o
 * fuso horário de Sydney (Australia/Sydney) e exiba apenas as horas e os minutos.
 * Dica: Utilize o método withZoneSameInstant() para realizar a conversão.
 * Saída esperada:
 * Horário atual no sistema: 12:00
 * Horário atual em Sydney: 22:00
 */

package com.github.lucasdevrj.exercicios;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ConvertendoHorarioParaOutroFuso {
    public static void main(String[] args) {
        ZonedDateTime horarioAtualSistema = ZonedDateTime.now();
        ZoneId australia = ZoneId.of("Australia/Sydney");
        ZonedDateTime horarialAtualAustralia = horarioAtualSistema.withZoneSameInstant(australia);
        DateTimeFormatter horarioFormatado = DateTimeFormatter.ofPattern("HH:mm");

        String horarios = String.format(
                "Horário atual no sistema: %s\nHorário atual em Sydney: %s",
                horarioAtualSistema.format(horarioFormatado),
                horarialAtualAustralia.format(horarioFormatado)
        );

        System.out.println(horarios);
    }
}
