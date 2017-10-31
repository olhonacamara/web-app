/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.donc.webService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                /*   item.setCota_mensal(res.getDouble("cota_mensal"));
                item.setCreditos(res.getDouble("creditos"));
                item.setCreditos_mes(res.getDouble("creditos_mes"));
                item.setCursos(res.getDouble("cursos"));
                item.setDataFinal(res.getDate("data_final"));
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
                item.setXerox(res.getDouble("xerox"));*/
                item.setVereador_id(res.getInt("vereador_id"));

                retorno.add(item);
                System.out.println(item);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VereadorDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

        return retorno;

    }

}
