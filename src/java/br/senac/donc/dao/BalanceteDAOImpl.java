package br.senac.donc.dao;

import br.senac.donc.model.Balancete;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class BalanceteDAOImpl extends BaseDAOImpl<Balancete, Long> 
        implements BalanceteDAO, Serializable{

    @Override
    public Balancete pesquisarPorId(Long id, Session session) throws HibernateException {
        Balancete produto = (Balancete) session.get(Balancete.class, id);
        return produto;
    }

    @Override
    public List<Balancete> listarTodos(Session session) throws HibernateException {
        Query consulta = session.createQuery("from Balancete");
        return consulta.list();
    }
    
}
