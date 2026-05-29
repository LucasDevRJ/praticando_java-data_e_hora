package com.github.lucasdevrj.principal;

import java.time.LocalDate;
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
    }
}
