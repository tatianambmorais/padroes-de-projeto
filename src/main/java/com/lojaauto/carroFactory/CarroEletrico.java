package com.lojaauto.carroFactory;


import com.lojaauto.VeiculoEletricoBase;

public class CarroEletrico extends VeiculoEletricoBase {
    @Override
    public String toString() {
        return "Carro Elétrico: " + getModelo();
    }
}