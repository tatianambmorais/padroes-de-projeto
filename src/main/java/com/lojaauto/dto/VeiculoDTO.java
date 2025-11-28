package com.lojaauto.dto;

import lombok.Getter;

@Getter

public class VeiculoDTO {
    private String tipo;
    private String modelo;
    private int autonomiaKm;
    private double preco;

    public String getTipo() { return tipo; }
    public String getModelo() { return modelo; }
    public int getAutonomiaKm() { return autonomiaKm; }
    public double getPreco() { return preco; }
}

