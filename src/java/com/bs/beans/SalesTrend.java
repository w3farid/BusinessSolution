/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.beans;

import com.bs.database.DB;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.ChartSeries;

@ManagedBean
public class SalesTrend implements Serializable {

    private BarChartModel barModel;
    private String dateforweb;
    private double totalSales=0;
    private double totalmemo=0;
    private int toutlet=0;
    private int aoutlet=0;
    private double weeklySales;
    private int weeklymemo;

    @PostConstruct
    public void init() {
        createBarModels();
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        ChartSeries rakib = new ChartSeries();
        rakib.setLabel("U1");

        ChartSeries shahin = new ChartSeries();
        shahin.setLabel("U2");       

        Connection con = null;
        try {
            Calendar rightNow = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
            String date = sdf.format(rightNow.getTime());
            setDateforweb(date);
            con = DB.getConnection();
            PreparedStatement stm = con.prepareStatement("select sum(Total) as Total, Sell_Date, Emp_Id from sales where Sell_Date=current_date() group by Emp_Id;");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                if (rs.getInt(3)==5) {
                    rakib.set(rs.getDate("Sell_Date"), rs.getDouble("Total"));
                }
                if (rs.getInt(3)==7) {
                    shahin.set(rs.getDate("Sell_Date"), rs.getDouble("Total"));
                }
            }
        } catch (Exception e) {
        }

        model.addSeries(rakib);
        model.addSeries(shahin); 
        return model;
    }

    private void createBarModels() {
        createBarModel();
    }

    private void createBarModel() {
        barModel = initBarModel();

        barModel.setTitle("Sales Trend Current Week");
        barModel.setLegendPosition("ne");

        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Weekly SR Sales Performances");

        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Saling Range");
        yAxis.setMin(0);
        yAxis.setMax(20000);
    }

    public String getDateforweb() {
        return dateforweb;
    }

    public void setDateforweb(String dateforweb) {
        this.dateforweb = dateforweb;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    public double getTotalmemo() {
        return totalmemo;
    }

    public void setTotalmemo(double totalmemo) {
        this.totalmemo = totalmemo;
    }

    public int getToutlet() {
        return toutlet;
    }

    public void setToutlet(int toutlet) {
        this.toutlet = toutlet;
    }

    public int getAoutlet() {
        return aoutlet;
    }

    public void setAoutlet(int aoutlet) {
        this.aoutlet = aoutlet;
    }

    public double getWeeklySales() {
        return weeklySales;
    }

    public void setWeeklySales(double weeklySales) {
        this.weeklySales = weeklySales;
    }

    public int getWeeklymemo() {
        return weeklymemo;
    }

    public void setWeeklymemo(int weeklymemo) {
        this.weeklymemo = weeklymemo;
    }

}
