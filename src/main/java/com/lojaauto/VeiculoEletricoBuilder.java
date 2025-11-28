package com.lojaauto;


import com.lojaauto.carroFactory.VeiculoEletrico;
import com.lojaauto.VeiculoEletricoBase;
import com.lojaauto.carroFactory.VeiculoEletricoFactory;

public class VeiculoEletricoBuilder {
    private String modelo;
    private int autonomiaKm;
    private double preco;
    private String tipo;

    public VeiculoEletricoBuilder modelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public VeiculoEletricoBuilder autonomia(int autonomiaKm) {
        this.autonomiaKm = autonomiaKm;
        return this;
    }

    public VeiculoEletricoBuilder preco(double preco) {
        this.preco = preco;
        return this;
    }

    public VeiculoEletricoBuilder tipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public VeiculoEletrico build() {
        VeiculoEletrico veiculo = VeiculoEletricoFactory.escolherVeiculo(tipo);
        if (veiculo instanceof VeiculoEletricoBase base) {
            base.setModelo(modelo);
            base.setAutonomiaKm(autonomiaKm);
            base.setPreco(preco);
        }
        return veiculo;
    }
}
