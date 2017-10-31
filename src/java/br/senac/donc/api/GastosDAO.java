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


/**
 *
 * @author smaicon
 */
public class GastosDAO {
    
     public List<Balancete> listarGastos() {
         

        
        String sql = 
           
                "SELECT VEREADOR.ID, VEREADOR.NOME_COMPLETO"
                + "FROM VEREADOR"
                + "INNER JOIN BALANCETES ON VEREADOR.ID = BALANCETES.VEREADOR_ID"
                + "SELECT BALANCETES.DEBITOS_MES"
                + "FROM BALANCETES"
                + "ORDER BY ASC";
        List<Balancete> retorno = new ArrayList<Balancete>();

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Balancete bal = new Balancete();
                Vereador ver = new Vereador();
               
                bal.setDebitos_mes(res.getDouble("debitos_mes"));
                ver.setNome_completo(res.getString("nome_completo"));
                
                retorno.add(bal);
               // retorno.add(ver);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VereadorDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

        return retorno;
     }
}
