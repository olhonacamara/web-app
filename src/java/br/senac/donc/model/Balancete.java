/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.donc.model;

/**
 *
 * @author danilosetubal
 */
public class Balancete {
    
    private String dataInicial;
    private String dataFinal;
    private Double cotaMensal;

    public Balancete() {
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Double getCotaMensal() {
        return cotaMensal;
    }

    public void setCotaMensal(Double cotaMensal) {
        this.cotaMensal = cotaMensal;
    }
    
    
    
}
