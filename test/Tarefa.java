
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danilosetubal
 */

@Entity
@Table(name="tarefas")
public class Tarefa {
    
    @Id
    @GeneratedValue
    private Long id;
    private String descricao;
    private boolean finalizado;
    
    @Temporal(TemporalType.DATE)
    private Calendar dataFinalizacao;

    public Tarefa() {
    }

    public Tarefa(Long id, String descricao, boolean finalizado, Calendar dataFinalizacao) {
        this.id = id;
        this.descricao = descricao;
        this.finalizado = finalizado;
        this.dataFinalizacao = dataFinalizacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public Calendar getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(Calendar dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }
    
}
