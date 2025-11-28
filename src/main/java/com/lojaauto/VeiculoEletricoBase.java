package com.lojaauto;

import com.lojaauto.carroFactory.VeiculoEletrico;

public abstract class VeiculoEletricoBase implements VeiculoEletrico {

    private Integer id;           // <-- novo
    private String modelo;
    private int autonomiaKm;
    private double preco;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public int getAutonomiaKm() {
        return autonomiaKm;
    }
    public void setAutonomiaKm(int autonomiaKm) {
        this.autonomiaKm = autonomiaKm;
    }

    @Override
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public void carregar() {
        System.out.println(modelo + " está carregando...");
    }
}
