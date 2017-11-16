package br.senac.donc.dao;

import br.senac.donc.model.Vereador;
import br.senac.donc.relatorio.GastosMes;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public interface VereadorDAO extends BaseDAO<Vereador, Long> {
    
    public Long pesquisaVereadorId (String vereador, Session session)throws HibernateException;
    
        List<GastosMes> pesquisaGastoMes(Session session) throws HibernateException;
              
    
 
}
