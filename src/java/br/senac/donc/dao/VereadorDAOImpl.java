package br.senac.donc.dao;

import br.senac.donc.model.Vereador;
import br.senac.donc.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class VereadorDAOImpl extends BaseDAOImpl<Vereador, Long>
        implements VereadorDAO, Serializable {

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

    @Override
    public Long pesquisaVereadorId(String vereador, Session session) throws HibernateException {
        Query consulta = session.createQuery("select v.id from Vereador v where v.nomeCompleto = :nome");
        consulta.setParameter("nome", vereador);
        return (Long) consulta.uniqueResult();

    }
    
    public static void main(String[] args) {
        VereadorDAOImpl vereadorDao = new VereadorDAOImpl();
        System.out.println(vereadorDao.pesquisaVereadorId("AFRÂNIO TADEU BOPPRÉ", HibernateUtil.abrirSessao()));
    }

}
