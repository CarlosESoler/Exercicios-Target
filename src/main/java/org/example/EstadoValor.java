package org.example;

import java.util.ArrayList;
import java.util.List;

public class EstadoValor {
    String sigla;
    Double faturamento;

    public static List<EstadoValor> estados = new ArrayList<>();

    public EstadoValor(String sigla, Double faturamento) {
        this.sigla = sigla;
        this.faturamento = faturamento;
        estados.add(this);
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Double getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(Double faturamento) {
        this.faturamento = faturamento;
    }
}
