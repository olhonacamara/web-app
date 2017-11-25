/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.donc.api;

import br.senac.donc.relatorio.GastosMes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
/**
 *
 * @author smaicon
 */
public class BalanceteDAO {

    public List<Balancete> listar() {
        String sql = "SELECT * FROM balancetes";
        List<Balancete> retorno = new ArrayList<Balancete>();

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Balancete item = new Balancete();
                item.setId(res.getInt("id"));
                item.setAno_anterior(res.getDouble("ano_anterior"));
                item.setBolsa_estagio(res.getDouble("bolsa_estagio"));
                item.setCarimbos(res.getDouble("carimbos"));
                item.setCorreio(res.getDouble("correio"));
                 item.setCota_mensal(res.getDouble("cota_mensal"));
               item.setCreditos(res.getDouble("creditos"));
                item.setCreditos_mes(res.getDouble("creditos_mes"));
              item.setCursos(res.getDouble("cursos"));
                item.setDataFinal(res.getDate("dataFinal"));
                item.setDataInicial(res.getDate("dataInicial"));
                item.setDebito_ano_anterior(res.getDouble("debito_ano_anterior"));
                item.setDebitos(res.getDouble("debitos"));
                item.setDebitos_mes(res.getDouble("debitos_mes"));
               item.setDiarias(res.getDouble("diarias"));
             item.setGratificacao(res.getDouble("gratificacao"));
                item.setInterurbano(res.getDouble("interurbano"));
                item.setJornal_revista(res.getDouble("jornal_revista"));
                item.setMaterial_expediente(res.getDouble("material_expediente"));
                item.setOutros1(res.getDouble("outros1"));
                item.setOutros2(res.getDouble("outros2"));
                item.setPassagens(res.getDouble("passagens"));
                item.setSaldo_acumulado(res.getDouble("saldo_acumulado"));
                item.setSaldo_anterior(res.getDouble("saldo_anterior"));
                item.setSelos(res.getDouble("selos"));
                item.setServicos(res.getDouble("servicos"));
                item.setTelefone_fixo(res.getDouble("telefone_fixo"));
                item.setTelefone_movel(res.getDouble("telefone_movel"));
                item.setXerox(res.getDouble("xerox"));
                item.setVereador_id(res.getInt("vereador_id"));

                retorno.add(item);
                System.out.println(item);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VereadorDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

        return retorno;

    }
    
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
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public List<GastosMes> pesquisaGastoMesTest(String categoria, Session session) throws HibernateException {
        List<GastosMes> gastos = new ArrayList<>();
        GastosMes gastosMes;
        Query consulta;
        Double total;

        for (int i = 1; i <= 12; i++) {
            consulta = session.createQuery("select sum(b." + categoria + ") from Balancete b where b.dataInicial = '2017-" + i + "-01'");
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
