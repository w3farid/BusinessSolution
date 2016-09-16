/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.beans;

import com.bs.database.DB;
import com.bs.modelPojo.SeslesReport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Java Programmer
 */
@ManagedBean
@SessionScoped
public class AdminBean {
    private double gtSales;
    private double gtSalesmonth;
    private double gtdpurchases;
    private double gtyearsales;
    
    public AdminBean() {
        gtsales();
        gtsalesMonth();
        gtdpur();
        gtyear();
    }
    public void gtsales(){
         Connection con = DB.getConnection();
        try {
            PreparedStatement stm = con.prepareCall("SELECT sum(Total) as GT FROM sales where Sell_Date=DATE_FORMAT(NOW(),'%Y-%m-%d');");
            
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                setGtSales(rs.getDouble(1));
            }
        } catch (Exception e) {
        }
    }
    public void gtsalesMonth(){
         Connection con = DB.getConnection();
        try {
            PreparedStatement stm = con.prepareCall("SELECT sum(Total) as GT FROM sales where month(Sell_Date)= MONTH(current_date());");
            
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                setGtSalesmonth(rs.getDouble(1));
            }
        } catch (Exception e) {
        }
    }
    public void gtdpur(){
         Connection con = DB.getConnection();
        try {
            PreparedStatement stm = con.prepareCall("SELECT sum(Total_Price) as GT FROM purchases where Purchases_Date=DATE_FORMAT(NOW(),'%Y-%m-%d');");
            
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                setGtyearsales(rs.getDouble(1));
            }
        } catch (Exception e) {
        }
    }
    public void gtyear(){
         Connection con = DB.getConnection();
        try {
            PreparedStatement stm = con.prepareCall("SELECT sum(Total) as GT FROM sales where year(Sell_Date)= year(current_date());");
            
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                setGtyearsales(rs.getDouble(1));
            }
        } catch (Exception e) {
        }
    }

    public double getGtSales() {
        return gtSales;
    }

    public void setGtSales(double gtSales) {
        this.gtSales = gtSales;
    }

    public double getGtSalesmonth() {
        return gtSalesmonth;
    }

    public void setGtSalesmonth(double gtSalesmonth) {
        this.gtSalesmonth = gtSalesmonth;
    }
    public double getGtdpurchases() {
        return gtdpurchases;
    }

    public void setGtdpurchases(double gtdpurchases) {
        this.gtdpurchases = gtdpurchases;
    }

    public double getGtyearsales() {
        return gtyearsales;
    }

    public void setGtyearsales(double gtyearsales) {
        this.gtyearsales = gtyearsales;
    }
}
