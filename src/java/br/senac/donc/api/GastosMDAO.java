/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.donc.api;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author smaicon
 */
public class GastosMDAO {

    
    ///testar com este
    
         public List<GastoM> listarGastos2() {
        
        String sql = 
                    "SELECT dataInicial, dataFinal, debitos_mes, sum(b.debitos_mes) as total"
                + "from balancetes b where dataInicial = '2017-01-01' and dataFinal = '2017-02-01' ";
        List<GastoM> retorno = new ArrayList();

        
        GastoM gastoM;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            ResultSet res = pst.executeQuery();
            while (res.next()) {
              gastoM = new GastoM();
             /*   gastoM.setDataFinal(res.getDate("dataInicial"));
                gastoM.setDataInicial(res.getDate("dataInicial"));*/
               gastoM.setId(res.getInt("id"));
               gastoM.setTotal(res.getFloat("total"));
                
                retorno.add(gastoM);
          
            }

        } catch (SQLException ex) {
            Logger.getLogger(VereadorDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

        return retorno;
     }
}
