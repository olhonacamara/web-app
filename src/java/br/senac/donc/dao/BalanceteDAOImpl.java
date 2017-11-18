package br.senac.donc.dao;

import br.senac.donc.api.Conexao;
import br.senac.donc.api.Vereador;
import br.senac.donc.model.Balancete;
import br.senac.donc.model.Ranking;
import br.senac.donc.util.HibernateUtil;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import java.text.DecimalFormat;   
import java.text.NumberFormat;

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
    
//    public static void main(String[] args) {
//        
//    }
    
    public List<Ranking> listaRankingGeral() {
        
        String sql = "SELECT SUM(balancetes.debitos_mes) as total, vereadores.nome_completo FROM"
                + " balancetes, vereadores where vereadores.id = balancetes.vereador_id "
                + "group by vereadores.nome_completo order by total desc;";
        List<Ranking> retorno = new ArrayList<Ranking>();
        
        DecimalFormat df = new DecimalFormat("0.##");

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Ranking item = new Ranking();
                item.setNome(res.getString("nome_completo"));
                              
                BigDecimal valor = new BigDecimal (res.getDouble("total"));  
                NumberFormat nf = NumberFormat.getCurrencyInstance();  
                String formatado = nf.format (valor);
                System.out.println(formatado);
                
                item.setGasto(formatado);             
                
                retorno.add(item);
            }

        } catch (SQLException ex) {
            Logger.getLogger(br.senac.donc.api.VereadorDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

        return retorno;
    }
    
    public List<Ranking> listarRankingGasto(String nomeGasto) {
        
        String sql = "select vereadores.nome_completo as nome, SUM(balancetes." + nomeGasto + ") as gasto "
                + "from vereadores, balancetes where vereadores.id = balancetes.vereador_id "
                + "group by vereadores.nome_completo order by gasto desc;";
        
        List<Ranking> retorno = new ArrayList<Ranking>();
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Ranking item = new Ranking();
                item.setNome(res.getString("nome"));
                              
                BigDecimal valor = new BigDecimal (res.getDouble("gasto"));  
                NumberFormat nf = NumberFormat.getCurrencyInstance();  
                String formatado = nf.format (valor);
                System.out.println(formatado);
                
                item.setGasto(formatado);             
                
                retorno.add(item);
            }

        } catch (SQLException ex) {
            Logger.getLogger(br.senac.donc.api.VereadorDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

        return retorno;
                
    }
    
}
