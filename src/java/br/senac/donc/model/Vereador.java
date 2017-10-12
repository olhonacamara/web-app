/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.donc.model;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author danilosetubal
 */
@Entity
@Table(name="veradores")
public class Vereador {
    
    @Id
    @GeneratedValue
    private Long id;
    private String nomeCompleto;
    private String nomePublico;
    
    @OneToMany(mappedBy = "vereador", targetEntity = Balancete.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Balancete> balancetes;
    
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    
    private String sexo;
    private String grauInstrucao;
    private String corRaca;
    private String foto;
    private String telefone;
    private String email;
    private String site;
    private String partido;
    private Integer totalVotos;
    
    @Temporal(TemporalType.DATE)
    private Date inicioMandato;
    
    @Temporal(TemporalType.DATE)
    private Date fimMandato;

    public Vereador() {
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomePublico() {
        return nomePublico;
    }

    public void setNomePublico(String nomePublico) {
        this.nomePublico = nomePublico;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getGrauInstrucao() {
        return grauInstrucao;
    }

    public void setGrauInstrucao(String grauInstrucao) {
        this.grauInstrucao = grauInstrucao;
    }

    public String getCorRaca() {
        return corRaca;
    }

    public void setCorRaca(String corRaca) {
        this.corRaca = corRaca;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public Integer getTotalVotos() {
        return totalVotos;
    }

    public void setTotalVotos(Integer totalVotos) {
        this.totalVotos = totalVotos;
    }

    public Date getInicioMandato() {
        return inicioMandato;
    }

    public void setInicioMandato(Date inicioMandato) {
        this.inicioMandato = inicioMandato;
    }

    public Date getFimMandato() {
        return fimMandato;
    }

    public void setFimMandato(Date fimMandato) {
        this.fimMandato = fimMandato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getNomeCompleto() + " - " + getTotalVotos() + " votos.";
    }    
    
}
