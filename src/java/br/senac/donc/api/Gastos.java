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
public class Gastos {
    private Integer id;
    private Double debitos_mes;
    private Vereador vereador;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getDebitos_mes() {
        return debitos_mes;
    }

    public void setDebitos_mes(Double debitos_mes) {
        this.debitos_mes = debitos_mes;
    }

    public Vereador getVereador() {
        return vereador;
    }

    public void setVereador(Vereador vereador) {
        this.vereador = vereador;
    }
    
    
}
