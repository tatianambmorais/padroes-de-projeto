package com.lojaauto.carroFactory;


import com.lojaauto.VeiculoEletricoBase;

public class MotoEletrica extends VeiculoEletricoBase {
    @Override
    public String toString() {
        return "Moto Elétrica: " + getModelo();
    }
}
