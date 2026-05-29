package com.github.lucasdevrj.principal;

import java.time.LocalDate;

public class Principal {
    public static void main(String[] args) {
        LocalDate dataDaCompra = LocalDate.now();
        LocalDate dataDaPrimeiraParcela = LocalDate.of(2026, 6, 10);
        LocalDate dataDaSegundaParcela = dataDaPrimeiraParcela.plusDays(30);

        System.out.println("Data da compra: " + dataDaCompra);
        System.out.println("Data da primeira parcela: " + dataDaPrimeiraParcela);
        System.out.println("Data da segunda parcela: " + dataDaSegundaParcela);
    }
}
