/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.donc.api;

import br.senac.donc.model.Vereador;


/**
 *
 * @author smaicon
 */
public class GastoSERVICE {
    private String nome_completo;
    private double selos, debitos_mes, material_expediente, diarias;

    public GastoSERVICE(String nome_completo, double selos, double debitos_mes, double material_expediente, double diarias) {
        this.nome_completo = nome_completo;
        this.selos = selos;
        this.debitos_mes = debitos_mes;
        this.material_expediente = material_expediente;
        this.diarias = diarias;
    }

    public GastoSERVICE() {
    }
    
    

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public double getSelos() {
        return selos;
    }

    public void setSelos(double selos) {
        this.selos = selos;
    }

    public double getDebitos_mes() {
        return debitos_mes;
    }

    public void setDebitos_mes(double debitos_mes) {
        this.debitos_mes = debitos_mes;
    }

    public double getMaterial_expediente() {
        return material_expediente;
    }

    public void setMaterial_expediente(double material_expediente) {
        this.material_expediente = material_expediente;
    }

    public double getDiarias() {
        return diarias;
    }

    public void setDiarias(double diarias) {
        this.diarias = diarias;
    }
    
    

}
