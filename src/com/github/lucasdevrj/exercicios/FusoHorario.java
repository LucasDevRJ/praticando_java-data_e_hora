/**
 * Você trabalha em uma empresa de viagens internacionais e precisa de um sistema que exiba o horário atual
 * em diferentes países. Como a empresa tem clientes no Japão, o sistema deve ser capaz de mostrar o horário
 * atual na cidade de Tóquio, independente do fuso horário do computador onde o programa está rodando.
 *
 * Crie um programa que exiba o horário atual no fuso horário de Tóquio (Asia/Tokyo). Utilize a classe
 * ZonedDateTime para realizar a tarefa. Lembre-se de formatar a saída para exibir apenas horas,
 * minutos e segundos.
 *
 * Saída esperada:
 *
 * Horário atual em Tóquio: 21:04:09
 */
package com.github.lucasdevrj.exercicios;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class FusoHorario {
    public static void main(String[] args) {
        ZoneId horarioNoJapao = ZoneId.of("Asia/Tokyo");

        ZonedDateTime horarioAtualBrasil = ZonedDateTime.now();

        ZonedDateTime horarioAtualJapao = horarioAtualBrasil.withZoneSameInstant(horarioNoJapao);

        DateTimeFormatter horarioFormatado = DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.println("Horário atual em Tóquio: " + horarioAtualJapao.format(horarioFormatado));
    }
}
