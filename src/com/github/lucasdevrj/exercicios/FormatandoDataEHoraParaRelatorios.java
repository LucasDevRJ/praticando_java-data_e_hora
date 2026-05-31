/**
 * Você trabalha no setor de tecnologia de uma empresa que gera relatórios diários.
 * Esses relatórios incluem informações como transações realizadas, atualizações de
 * pedidos e registros de atendimento ao cliente. A equipe responsável pela análise
 * dos relatórios solicitou que a data e a hora sejam exibidas em um formato mais
 * familiar para os usuários brasileiros.
 *
 * Para resolver essa tarefa, você deve:
 *
 * Capturar a data e a hora atuais.
 * Formatar a data no padrão dd-MM-yyyy (dia-mês-ano).
 * Formatar a hora no padrão HH:mm (hora e minutos).
 * Exibir o resultado da formatação.
 */

package com.github.lucasdevrj.exercicios;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FormatandoDataEHoraParaRelatorios {
    public static void main(String[] args) {
        LocalDate dataAtual = LocalDate.now();
        LocalTime horarioAtual = LocalTime.now();

        DateTimeFormatter formatoDaData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoDoHorario = DateTimeFormatter.ofPattern("HH:mm");

        String dataFormatada = dataAtual.format(formatoDaData);
        String horaFormatada = horarioAtual.format(formatoDoHorario);

        System.out.println("Data Atual: " + dataFormatada);
        System.out.println("Horário Atual: " + horaFormatada);
    }
}
