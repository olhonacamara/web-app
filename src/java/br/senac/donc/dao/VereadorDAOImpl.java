package br.senac.donc.dao;

import br.senac.donc.model.Vereador;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class VereadorDAOImpl extends BaseDAOImpl<Vereador, Long> 
        implements VereadorDAO, Serializable{

    @Override
    public Vereador pesquisarPorId(Long id, Session session) throws HibernateException {
        Vereador produto = (Vereador) session.get(Vereador.class, id);
        return produto;
    }

    @Override
    public List<Vereador> listarTodos(Session session) throws HibernateException {
        Query consulta = session.createQuery("from Vereador");
        return consulta.list();
    }
    
}
