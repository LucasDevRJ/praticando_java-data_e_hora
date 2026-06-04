/**
 * Você é responsável pelos projetos em uma empresa de desenvolvimento de software.
 * Para garantir que os prazos sejam cumpridos, você precisa calcular a data de entrega
 * de cada projeto com base na data de início e no prazo estimado em dias.
 *
 * Você precisa criar um programa que:
 *
 * Receba uma data de início.
 * Adicione o prazo em dias ao início do projeto.
 * Exiba a data final formatada corretamente.
 * Saída esperada:
 *
 * Se a data de início for 15 de março de 2025 e o prazo for 15 dias, a saída deve ser:
 *
 * Data de entrega: 30-03-2025
 */

package com.github.lucasdevrj.exercicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CalculandoDataDeEntrega {
    public static void main(String[] args) {
        LocalDate dataInicio;
        LocalDate dataPrevistaEntrega;
        int prazoEmDias;
        String dataDigitada;

        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite a data(ex: 10/02/2026): ");
        dataDigitada = entrada.nextLine();

        while (!dataDigitada.matches("[0-9/]+")) {
            System.out.println("Digite a data no formato dd/MM/yyyy");
            System.out.print("Digite a data(ex: 10/02/2026): ");
            dataDigitada = entrada.nextLine();
        }

        String[] data = dataDigitada.split("/");
        int dia = Integer.parseInt(data[0]);
        int mes = Integer.parseInt(data[1]);
        int ano = Integer.parseInt(data[2]);
        dataInicio = LocalDate.of(ano, mes, dia);

        System.out.print("Prazo para receber a entrega: ");
        prazoEmDias = entrada.nextInt();
        entrada.close();

        dataPrevistaEntrega = dataInicio.plusDays(prazoEmDias);

        DateTimeFormatter formatoDaData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String dataComformatoDesejado = dataPrevistaEntrega.format(formatoDaData);
        System.out.println("Data de entrega: " + dataComformatoDesejado);
    }
}
