package com.github.lucasdevrj.principal;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Principal {
    public static void main(String[] args) {
        LocalDate dataDaCompra = LocalDate.now();
        LocalDate dataDoRecebimentoDoSalario = LocalDate.of(2026, 5, 5);
        LocalDate dataDaPrimeiraParcela = LocalDate.of(2026, 5, 28);
        LocalDate dataDaSegundaParcela = dataDaPrimeiraParcela.plusDays(30);

        System.out.println("Data da compra: " + dataDaCompra);
        System.out.println("Data da primeira parcela: " + dataDaPrimeiraParcela);
        System.out.println("Data da segunda parcela: " + dataDaSegundaParcela);

        if (dataDaPrimeiraParcela.isEqual(dataDaCompra)) {
            System.out.println("A parcela esta vencendo hoje.");
        }

        if (dataDoRecebimentoDoSalario.isBefore(dataDaPrimeiraParcela)) {
            System.out.println("Recebe salário antes da primeira fatura.");
        }

        DateTimeFormatter formatadorDeData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Data da compra formatada: " + dataDaCompra.format(formatadorDeData));

        ZonedDateTime dataDeOutraCompra = ZonedDateTime.now();
        System.out.println("Data de outra compra: " + dataDeOutraCompra);
        ZonedDateTime dataDeOutraCompraNY = dataDeOutraCompra.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("Data de outra compra em New York: " + dataDeOutraCompraNY);

        LocalTime inicioDoExpediente = LocalTime.of(9, 0);
        LocalTime fimDoExpediente = LocalTime.of(17, 30);
        Duration duracaoDoExpediente = Duration.between(inicioDoExpediente, fimDoExpediente);
        System.out.println("Duração do Expediente: " + duracaoDoExpediente.toHours() + " horas e "
                + duracaoDoExpediente.toMinutesPart() + " minutos.");

        LocalDate dataDoPagamento = LocalDate.parse("2026-10-30");
        Period periodo = Period.between(dataDaCompra, dataDoPagamento);
        int duracaoMesesParaDias = periodo.getMonths() * 30;
        int duracaoDiasParaAno = periodo.getYears() * 356;
        int duracaoDias = periodo.getDays();
        int duracaoTotalEmDias = duracaoMesesParaDias + duracaoDiasParaAno + duracaoDias;

        System.out.println("Diferença da data de compra e pagamento: " + duracaoTotalEmDias + " dias.");
    }
}
