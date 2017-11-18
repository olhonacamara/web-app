package br.senac.donc.dao;

import br.senac.donc.model.Balancete;
import br.senac.donc.model.Ranking;
import br.senac.donc.util.HibernateUtil;
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
    
    public static void main(String[] args) {
        BalanceteDAOImpl dao = new BalanceteDAOImpl();
        
        System.out.println(dao.listaRanking(HibernateUtil.abrirSessao()));
    }
    
    public List listaRanking(Session session) throws HibernateException {
        
        Query consulta = session.createSQLQuery("SELECT SUM(balancetes.debitos_mes) as total, vereadores.nome_completo FROM balancetes, vereadores where vereadores.id = balancetes.vereador_id group by vereadores.nome_completo order by total desc;");
        
        Ranking ranking1 = new Ranking();
        
        
        return consulta.list();
    }
    
}
