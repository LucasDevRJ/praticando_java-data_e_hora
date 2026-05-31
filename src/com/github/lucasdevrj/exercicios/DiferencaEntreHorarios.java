/**
 * Você é responsável pelo controle de tempo em projetos dentro de uma agência de desenvolvimento.
 * Você precisa monitorar o tempo gasto em cada tarefa para garantir que os projetos
 * sejam executados dentro do prazo.
 *
 * Para isso, crie um programa que:
 *
 * Receba dois horários representando o início e o término de uma atividade.
 * Calcule a diferença em horas e minutos entre esses dois horários.
 * Exiba o resultado formatado.
 */

package com.github.lucasdevrj.exercicios;

import java.time.LocalTime;
import java.util.Scanner;

public class DiferencaEntreHorarios {
    public static void main(String[] args) {
        LocalTime horarioDeInicio;
        LocalTime horarioDeFim;
        LocalTime diferencaEntreHorarios;

        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite as horas do início da atividade: ");
        int horasInicio = entrada.nextInt();

        while (horasInicio < 0 || horasInicio >= 24) {
            System.out.println("Digite uma hora válida!");
            System.out.print("Digite as horas do início da atividade: ");
            horasInicio = entrada.nextInt();
        }

        System.out.print("Digite os minutos do início da atividade: ");
        int minutosInicio = entrada.nextInt();

        while (minutosInicio < 0 || minutosInicio >= 60) {
            System.out.println("Digite uma minutagem válida!");
            System.out.print("Digite os minutos do início da atividade: ");
            minutosInicio = entrada.nextInt();
        }

        horarioDeInicio = LocalTime.of(horasInicio, minutosInicio);

        System.out.print("Digite as horas do fim da atividade: ");
        int horasFim = entrada.nextInt();

        while (horasFim < 0 || horasFim >= 24) {
            System.out.println("Digite uma hora válida!");
            System.out.print("Digite as horas do fim da atividade: ");
            horasFim = entrada.nextInt();
        }

        System.out.print("Digite os minutos do fim da atividade: ");
        int minutosFim = entrada.nextInt();

        while (minutosFim < 0 || minutosFim >= 24) {
            System.out.println("Digite uma hora válida!");
            System.out.print("Digite os minutos do fim da atividade: ");
            minutosFim = entrada.nextInt();
        }

        horarioDeFim = LocalTime.of(horasFim, minutosFim);

        while (horarioDeFim.isBefore(horarioDeInicio) || horarioDeFim.equals(horarioDeInicio)) {
            System.out.println("Digite horário válidos!");
            System.out.print("Digite as horas do fim da atividade: ");
            horasFim = entrada.nextInt();

            System.out.print("Digite os minutos do fim da atividade: ");
            minutosFim = entrada.nextInt();

            horarioDeFim = LocalTime.of(horasFim, minutosFim);
        }
        entrada.close();

        LocalTime diferencaDeHoras = horarioDeFim.minusHours(horarioDeInicio.getHour());
        LocalTime diferencaDeMinutos = horarioDeFim.minusMinutes(horarioDeInicio.getMinute());
        diferencaEntreHorarios = LocalTime.of(diferencaDeHoras.getHour(), diferencaDeMinutos.getMinute());

        System.out.printf("Diferença de tempo: %d horas e %d minutos", diferencaEntreHorarios.getHour(), diferencaEntreHorarios.getMinute());
    }
}
