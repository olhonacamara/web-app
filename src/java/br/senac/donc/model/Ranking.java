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
public class Ranking {
        
    private String nome;
    private String gasto;
    private String partido;
    private String somaTotal;
    private String SomaGasto;
    

    public Ranking() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGasto() {
        return gasto;
    }

    public void setGasto(String gasto) {
        this.gasto = gasto;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getSomaTotal() {
        return somaTotal;
    }

    public void setSomaTotal(String somaTotal) {
        this.somaTotal = somaTotal;
    }

    public String getSomaGasto() {
        return SomaGasto;
    }

    public void setSomaGasto(String SomaGasto) {
        this.SomaGasto = SomaGasto;
    }
    
    
        
    
}
