/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.donc.api;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;

/**
 *
 * @author smaicon
 */
public class GastosDAO {

    public List<Gasto> listarGastos() {

        String sql
                = "select v.id, v.nome_completo, sum(b.debitos_mes) as total,"
                + "avg(b.debitos_mes) as Media_Gastos_Mes FROM vereadores v "
                + " inner join balancetes b on v.id = b.vereador_id"
                + " group by nome_completo";
        List<Gasto> retorno = new ArrayList();

        Gasto gasto;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            ResultSet res = pst.executeQuery();
            while (res.next()) {
                gasto = new Gasto();
                gasto.setMediaGastos(res.getDouble("Media_Gastos_Mes"));
                gasto.setVereador(res.getString("nome_completo"));
                gasto.setTotal(res.getDouble("total"));
                gasto.setId(res.getInt("id"));

                retorno.add(gasto);

            }

        } catch (SQLException ex) {
            Logger.getLogger(VereadorDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

        return retorno;
    }

    ArrayList<GastoSERVICE> listarGastosPorId(int id, Session abrirSessao) {

        String sql = "select v.id, v.nome_completo, b.selos, b.debitos_mes, b.material_expediente, b.diarias FROM vereadores v inner join balancetes b on "
                + "v.id = b.vereador_id where v.id = ?";
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        ArrayList<GastoSERVICE> list=new ArrayList<>();
           
        try {
           pst.setInt(1, id);
           ResultSet res = pst.executeQuery();
           GastoSERVICE gasto;
           while (res.next()) {
                gasto = new GastoSERVICE();
                gasto.setNome_completo(res.getString("nome_completo"));
                gasto.setDebitos_mes(res.getDouble("debitos_mes"));
                gasto.setSelos(res.getDouble("selos"));
                gasto.setMaterial_expediente(res.getDouble("material_expediente"));
                gasto.setDiarias(res.getDouble("diarias"));
                list.add(gasto);
            }  

        } catch (SQLException ex) {
            Logger.getLogger(VereadorDAO.class.getName()).log(Level.SEVERE, null, ex);
          
        }

        return list;        
    }
}
