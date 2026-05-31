/**
 * Você está desenvolvendo um sistema de log para um aplicativo de gerenciamento de tarefas.
 * Sempre que uma nova tarefa é criada, o sistema deve registrar a data e a hora exatas do
 * momento da criação.
 *
 * Para isso, implemente um programa que:
 *
 * Simule a criação de uma tarefa através de uma variável simples, por exemplo String tarefa =
 * "Enviar relatório semanal";.
 * Registre a data e a hora exatas da criação.
 * Exiba essas informações no formato adequado.
 */

package com.github.lucasdevrj.exercicios;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DataEHoraAtual {
    public static void main(String[] args) {
        String tarefaDigitada = "";
        Map<String, ZonedDateTime> tarefas = new LinkedHashMap<>();
        Scanner entrada = new Scanner(System.in);

        do {
            System.out.print("Digite uma tarefa ou nada para encerrar: ");
            tarefaDigitada = entrada.nextLine();

            if (!tarefaDigitada.isBlank()) {
                tarefas.put(tarefaDigitada, ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")));
                System.out.println("Tarefa adicionada com sucesso!");
            }

        } while (!tarefaDigitada.isBlank());
        entrada.close();

        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm z");

        System.out.println("--------------------|LISTA DE TAREFAS|--------------------");
        tarefas.forEach((tarefa, data) -> {
            System.out.printf("Tarefa: %s%n", tarefa);
            System.out.printf("Data: %s%n%n", data.format(dataFormatada));
        });
        System.out.println("----------------------------------------------------------");
    }
}
