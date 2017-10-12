package br.senac.donc.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="balancetes")

public class Balancete {

    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    private Vereador vereador;

    @Temporal(TemporalType.DATE)
    private Date dataInicial;
    
    @Temporal(TemporalType.DATE)
    private Date dataFinal;

    @Column(name = "cota_mensal")
    private Double cotaMensal;
    private Double creditos;
    private Double outros1;
    
    @Column(name = "ano_anterior")
    private Double anoAnterior;
    private Double debitos;
    
    @Column(name = "bolsa_estagio")
    private Double bolsaEstagio;
    private Double passagens;
    
    @Column(name = "telefone_fixo")
    private Double telefoneFixo;
    private Double xerox;
    private Double correio;
    
    @Column(name = "material_expediente")
    private Double materialExpediente;
    private Double diarias;
    private Double gratificacao;
    private Double outros2;
    private Double selos;
    private Double servicos;
    
    @Column(name = "telefone_movel")
    private Double telefoneMovel;
    private Double cursos;
    private Double carimbos;
    
    @Column(name = "saldo_anterior")
    private Double saldoAnterior;
    
    @Column(name = "saldo_acumulado")
    private Double saldoAcumulado;
    
    @Column(name = "creditos_mes")
    private Double creditosMes;
    
    @Column(name = "debitos_mes")
    private Double debitosMes;
    private Double interurbano;
    
    @Column(name = "debito_ano_anterior")
    private Double debitoAnoAnterior;
    
    @Column(name = "jornal_revista")
    private Double jornalRevista;

    public Balancete(Long id, Date dataInicial, Date dataFinal, Double cotaMensal, Double creditos, Double outros1, Double anoAnterior, Double debitos, Double bolsaEstagio, Double passagens, Double telefoneFixo, Double xerox, Double correio, Double materialExpediente, Double diarias, Double gratificacao, Double outros2, Double selos, Double servicos, Double telefoneMovel, Double cursos, Double carimbos, Double saldoAnterior, Double saldoAcumulado, Double creditosMes, Double debitosMes, Double interurbano, Double debitoAnoAnterior, Double jornalRevista) {
        this.id = id;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.cotaMensal = cotaMensal;
        this.creditos = creditos;
        this.outros1 = outros1;
        this.anoAnterior = anoAnterior;
        this.debitos = debitos;
        this.bolsaEstagio = bolsaEstagio;
        this.passagens = passagens;
        this.telefoneFixo = telefoneFixo;
        this.xerox = xerox;
        this.correio = correio;
        this.materialExpediente = materialExpediente;
        this.diarias = diarias;
        this.gratificacao = gratificacao;
        this.outros2 = outros2;
        this.selos = selos;
        this.servicos = servicos;
        this.telefoneMovel = telefoneMovel;
        this.cursos = cursos;
        this.carimbos = carimbos;
        this.saldoAnterior = saldoAnterior;
        this.saldoAcumulado = saldoAcumulado;
        this.creditosMes = creditosMes;
        this.debitosMes = debitosMes;
        this.interurbano = interurbano;
        this.debitoAnoAnterior = debitoAnoAnterior;
        this.jornalRevista = jornalRevista;
    }

    public Balancete() {
    }
    
    public Long getId() {
        return id;
    }

    public void setID(Long Id) {
        this.id = id;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Double getCotaMensal() {
        return cotaMensal;
    }

    public void setCotaMensal(Double cotaMensal) {
        this.cotaMensal = cotaMensal;
    }

    public Double getCreditos() {
        return creditos;
    }

    public void setCreditos(Double creditos) {
        this.creditos = creditos;
    }

    public Double getOutros1() {
        return outros1;
    }

    public void setOutros1(Double outros1) {
        this.outros1 = outros1;
    }

    public Double getAnoAnterior() {
        return anoAnterior;
    }

    public void setAnoAnterior(Double anoAnterior) {
        this.anoAnterior = anoAnterior;
    }

    public Double getDebitos() {
        return debitos;
    }

    public void setDebitos(Double debitos) {
        this.debitos = debitos;
    }

    public Double getBolsaEstagio() {
        return bolsaEstagio;
    }

    public void setBolsaEstagio(Double bolsaEstagio) {
        this.bolsaEstagio = bolsaEstagio;
    }

    public Double getPassagens() {
        return passagens;
    }

    public void setPassagens(Double passagens) {
        this.passagens = passagens;
    }

    public Double getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(Double telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public Double getXerox() {
        return xerox;
    }

    public void setXerox(Double xerox) {
        this.xerox = xerox;
    }

    public Double getCorreio() {
        return correio;
    }

    public void setCorreio(Double correio) {
        this.correio = correio;
    }

    public Double getMaterialExpediente() {
        return materialExpediente;
    }

    public void setMaterialExpediente(Double materialExpediente) {
        this.materialExpediente = materialExpediente;
    }

    public Double getDiarias() {
        return diarias;
    }

    public void setDiarias(Double diarias) {
        this.diarias = diarias;
    }

    public Double getGratificacao() {
        return gratificacao;
    }

    public void setGratificacao(Double gratificacao) {
        this.gratificacao = gratificacao;
    }

    public Double getOutros2() {
        return outros2;
    }

    public void setOutros2(Double outros2) {
        this.outros2 = outros2;
    }

    public Double getSelos() {
        return selos;
    }

    public void setSelos(Double selos) {
        this.selos = selos;
    }

    public Double getServicos() {
        return servicos;
    }

    public void setServicos(Double servicos) {
        this.servicos = servicos;
    }

    public Double getTelefoneMovel() {
        return telefoneMovel;
    }

    public void setTelefoneMovel(Double telefoneMovel) {
        this.telefoneMovel = telefoneMovel;
    }

    public Double getCursos() {
        return cursos;
    }

    public void setCursos(Double cursos) {
        this.cursos = cursos;
    }

    public Double getCarimbos() {
        return carimbos;
    }

    public void setCarimbos(Double carimbos) {
        this.carimbos = carimbos;
    }

    public Double getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(Double saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public Double getSaldoAcumulado() {
        return saldoAcumulado;
    }

    public void setSaldoAcumulado(Double saldoAcumulado) {
        this.saldoAcumulado = saldoAcumulado;
    }

    public Double getCreditosMes() {
        return creditosMes;
    }

    public void setCreditosMes(Double creditosMes) {
        this.creditosMes = creditosMes;
    }

    public Double getDebitosMes() {
        return debitosMes;
    }

    public void setDebitosMes(Double debitosMes) {
        this.debitosMes = debitosMes;
    }

    public Double getInterurbano() {
        return interurbano;
    }

    public void setInterurbano(Double interurbano) {
        this.interurbano = interurbano;
    }

    public Double getDebitoAnoAnterior() {
        return debitoAnoAnterior;
    }

    public void setDebitoAnoAnterior(Double debitoAnoAnterior) {
        this.debitoAnoAnterior = debitoAnoAnterior;
    }

    public Double getJornalRevista() {
        return jornalRevista;
    }

    public void setJornalRevista(Double jornalRevista) {
        this.jornalRevista = jornalRevista;
    }
    
}
