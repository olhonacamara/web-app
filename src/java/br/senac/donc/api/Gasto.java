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
public class Gasto {
    private double mediaGastos;
    private String vereador;
    private double total;

    public double getMediaGastos() {
        return mediaGastos;
    }

    public void setMediaGastos(double mediaGastos) {
        this.mediaGastos = mediaGastos;
    }

    public String getVereador() {
        return vereador;
    }

    public void setVereador(String vereador) {
        this.vereador = vereador;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
   
   

}
