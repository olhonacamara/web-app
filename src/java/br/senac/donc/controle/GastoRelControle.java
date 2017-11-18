/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.donc.controle;

import br.senac.donc.dao.VereadorDAO;
import br.senac.donc.relatorio.GastosMes;
import br.senac.donc.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import org.hibernate.Session;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author smaicon
 */
@ManagedBean(value = "gastoRel")
public class GastoRelControle implements Serializable{
    
    private LineChartModel lineModel1;
    private VereadorDAO vereadorDAO;
    private Session session;
    
     @PostConstruct
    public void init() {
        createLineModels();
    }
 
    public LineChartModel getLineModel1() {
        return lineModel1;
    }
    
    private void createLineModels() {
        lineModel1 = initLinearModel();
        lineModel1.setTitle("Linear Chart");
        lineModel1.setLegendPosition("e");
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
         
        yAxis.setLabel("Births");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }
    
    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
 
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Gastos xxx");
        session = HibernateUtil.abrirSessao();
        List<GastosMes> gastos = vereadorDAO.pesquisaGastoMes(session);
        for (GastosMes gasto : gastos) {
            series1.set(gasto.getMes(), gasto.getTotalGasto());
        }
 
        model.addSeries(series1);
         
        return model;
    }
 
}
