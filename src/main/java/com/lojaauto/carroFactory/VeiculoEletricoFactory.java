package com.lojaauto.carroFactory;

public abstract class VeiculoEletricoFactory {
    public static VeiculoEletrico escolherVeiculo(String tipo){
        switch(tipo.toLowerCase()){
            case "carro":
                return new CarroEletrico();
            case "moto":
                return new MotoEletrica();
            case "patinete":
                return new PatineteEletrico();
            default:
                throw new IllegalArgumentException("Tipo desconhecido" + tipo);
        }
    }
}