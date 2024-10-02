package edu.sm.dao;

import edu.sm.dto.TotalOrder;
import edu.sm.dto.TotalOrderStats;
import edu.sm.frame.AdminSql;
import edu.sm.frame.Dao;
import edu.sm.frame.Sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TotalOrderDao implements Dao<Integer, TotalOrder> {
    public List<TotalOrderStats> M21_1(Connection con) throws Exception {
        List<TotalOrderStats> totalOrderStatsList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            ps = con.prepareStatement(AdminSql.M21_1);
            rs = ps.executeQuery();

            // ResultSet에서 데이터 읽기
            while (rs.next()) {
                TotalOrderStats stats = new TotalOrderStats();
                stats.setGroup(rs.getString(1));
                stats.setTotalSalesCount(rs.getInt(2));
                stats.setPercentageOfTotalSalesCount(rs.getInt(3));
                stats.setTotalSalesAmount(rs.getInt(4));
                stats.setPercentageOfTotalSalesAmount(rs.getInt(5));
                // 리스트에 추가
                totalOrderStatsList.add(stats);
                System.out.println(stats.toString());
            }
        }catch(Exception e){
            throw e;
        }finally {
            if(ps != null) ps.close();
            if(rs != null) rs.close();
        }
        return totalOrderStatsList;
    }
    public List<TotalOrderStats> M22_1(Connection con) throws Exception {
        List<TotalOrderStats> totalOrderStatsList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(AdminSql.M22_1);
            rs = ps.executeQuery();

            // ResultSet에서 데이터 읽기
            while (rs.next()) {
                TotalOrderStats stats = new TotalOrderStats();
                stats.setGroup(rs.getString(1));
                stats.setTotalSalesCount(rs.getInt(2));
                stats.setPercentageOfTotalSalesCount(rs.getInt(3));
                stats.setTotalSalesAmount(rs.getInt(4));
                stats.setPercentageOfTotalSalesAmount(rs.getInt(5));
                // 리스트에 추가
                totalOrderStatsList.add(stats);
                System.out.println(stats.toString());
            }
        }catch(Exception e){
            throw e;
        }finally {
            if(ps != null) ps.close();
            if(rs != null) rs.close();
        }
        return totalOrderStatsList;
    }

    public List<TotalOrderStats> M23_1(Connection con) throws Exception {
        List<TotalOrderStats> totalOrderStatsList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(AdminSql.M23_1);
            rs = ps.executeQuery();

            // ResultSet에서 데이터 읽기
            while (rs.next()) {
                TotalOrderStats stats = new TotalOrderStats();
                stats.setGroup(rs.getString(1));
                stats.setTotalSalesCount(rs.getInt(2));
                stats.setPercentageOfTotalSalesCount(rs.getInt(3));
                stats.setTotalSalesAmount(rs.getInt(4));
                stats.setPercentageOfTotalSalesAmount(rs.getInt(5));
                // 리스트에 추가
                totalOrderStatsList.add(stats);
                System.out.println(stats.toString());
            }
        }catch(Exception e){
            throw e;
        }finally {
            if(ps != null) ps.close();
            if(rs != null) rs.close();
        }
        return totalOrderStatsList;
    }

    public List<TotalOrderStats> M24_1(Connection con) throws Exception {
        List<TotalOrderStats> totalOrderStatsList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(AdminSql.M24_1);
            rs = ps.executeQuery();
            // ResultSet에서 데이터 읽기
            while (rs.next()) {
                TotalOrderStats stats = new TotalOrderStats();
                stats.setGroup(rs.getString(1));
                stats.setTotalSalesCount(rs.getInt(2));
                stats.setPercentageOfTotalSalesCount(rs.getInt(3));
                stats.setTotalSalesAmount(rs.getInt(4));
                stats.setPercentageOfTotalSalesAmount(rs.getInt(5));
                // 리스트에 추가
                totalOrderStatsList.add(stats);
                System.out.println(stats.toString());
            }
        }catch(Exception e){
            throw e;
        }finally {
            if(ps != null) ps.close();
            if(rs != null) rs.close();
        }
        return totalOrderStatsList;
    }

    public List<TotalOrder> C43_1(String s,Connection con) throws Exception {
        List<TotalOrder> totalOrder = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(Sql.C43_1);
            ps.setString(1,s);
            rs = ps.executeQuery();
            while(rs.next()){
                TotalOrder totalOrders = new TotalOrder();
                totalOrders.setOrder_id(rs.getInt(1));
                totalOrders.setOrder_date(rs.getDate(2));
                totalOrders.setPay_price(rs.getInt(3));

                totalOrder.add(totalOrders);
                System.out.println(totalOrders.toString());
            }
        }catch(Exception e){
            throw e;
        }finally{
            if(ps != null) ps.close();
            if(rs != null) rs.close();
        }
        return totalOrder;
    }

    public TotalOrder C431_1(Integer i,Connection con) throws Exception {
        TotalOrder totalOrder = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement(Sql.C431_1);
            ps.setInt(1,i);
            rs = ps.executeQuery();
            rs.next();
            totalOrder = new TotalOrder();
            totalOrder.setOrder_id(rs.getInt(1));
            totalOrder.setOrder_date(rs.getDate(2));
            totalOrder.setPay_price(rs.getInt(3));
            totalOrder.setPayment_method(rs.getString(4));
            totalOrder.setReciver_add(rs.getString(5));
            totalOrder.setReciver_add_detail(rs.getString(6));
        }catch(Exception e){
            throw e;
        }finally{
            if(ps != null) ps.close();
            if(rs != null) rs.close();
        }
        return totalOrder;
    }
}
