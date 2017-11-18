package br.senac.donc.dao;

import br.senac.donc.model.Vereador;
import br.senac.donc.relatorio.GastosMes;
import br.senac.donc.util.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
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
//       System.out.println(vereadorDao.pesquisaVereadorId("AFRÂNIO TADEU BOPPRÉ", HibernateUtil.abrirSessao()));

        List<GastosMes> gastos = vereadorDao.pesquisaGastoMes(HibernateUtil.abrirSessao());
        System.out.println(gastos);
    }

    @Override
    public List<GastosMes> pesquisaGastoMes(Session session) throws HibernateException {
        List<GastosMes> gastos = new ArrayList<>();
        GastosMes gastosMes;
        Query consulta;
        Double total;

        for (int i = 1; i <= 12; i++) {
            consulta = session.createQuery("select sum(b.debitosMes) from Balancete b where b.dataInicial = '2017-" + i + "-01'");
            total = (Double) consulta.uniqueResult();
            gastosMes = new GastosMes();
            gastosMes.setTotalGasto(total);//pesquisar converter double em decimal moeda 2 casas
            switch (i) {
                case 1:
                    gastosMes.setMes("Janeiro");
                    break;
                case 2:
                    gastosMes.setMes("Fevereiro");
                    break;
                case 3:
                    gastosMes.setMes("Marco");
                    break;
                case 4:
                    gastosMes.setMes("Abril");
                    break;
                case 5:
                    gastosMes.setMes("Maio");
                    break;
                case 6:
                    gastosMes.setMes("Junho");
                    break;
                case 7:
                    gastosMes.setMes("Julho");
                    break;
                case 8:
                    gastosMes.setMes("Agosto");
                    break;
                case 9:
                    gastosMes.setMes("Setembro");
                    break;
                case 10:
                    gastosMes.setMes("Outubro");
                    break;
                case 11:
                    gastosMes.setMes("Novembro");
                    break;
                case 12:
                    gastosMes.setMes("Dezembro");
                    break;

            }
            gastos.add(gastosMes);

        }

        return gastos;
    }

}
