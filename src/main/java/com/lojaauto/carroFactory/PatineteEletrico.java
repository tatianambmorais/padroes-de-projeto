package com.lojaauto.carroFactory;

import com.lojaauto.VeiculoEletricoBase;

public class PatineteEletrico extends VeiculoEletricoBase {

    @Override
    public String toString() {
        return "Patinete Elétrico: " + getModelo();
    }
}
