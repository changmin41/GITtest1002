package edu.sm.service;

import edu.sm.dao.TotalOrderDao;
import edu.sm.dto.TotalOrder;
import edu.sm.dto.TotalOrderStats;
import edu.sm.frame.ConnectionPool;
import edu.sm.frame.MService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TotalOrderService implements MService<Integer, TotalOrder> {
    TotalOrderDao dao;
    ConnectionPool cp;
    public TotalOrderService() {
        dao = new TotalOrderDao();
        try {
            cp = ConnectionPool.create();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<TotalOrderStats> M21_1() throws Exception {
        Connection con = cp.getConnection();
        List<TotalOrderStats> result = null;
        try{
            result = dao.M21_1(con);
        }catch(Exception e) {
            throw e;
        }finally{
            cp.releaseConnection(con);
        }
        return result;
    }

    public List<TotalOrderStats> M22_1() throws Exception {
        Connection con = cp.getConnection();
        List<TotalOrderStats> result = null;
        try{
            result = dao.M22_1(con);
        }catch(Exception e){
            throw e;
        }finally{
            cp.releaseConnection(con);
        }
        return result;
    }
    public List<TotalOrderStats> M23_1() throws Exception {
        Connection con = cp.getConnection();
        List<TotalOrderStats> result = null;
        try{
            result = dao.M23_1(con);
        }catch(Exception e){
            throw e;
        }finally{
            cp.releaseConnection(con);
        }
        return result;
    }
    public List<TotalOrderStats> M24_1() throws Exception {
        Connection con = cp.getConnection();
        List<TotalOrderStats> result = null;
        try{
            result = dao.M24_1(con);
        }catch(Exception e){
            throw e;
        }finally{
            cp.releaseConnection(con);
        }
        return result;
    }

    public List<TotalOrder> C43_1(String s) throws Exception {
        Connection con = cp.getConnection();
        List<TotalOrder> result = null;
        try{
            result = dao.C43_1(s,con);
        }catch(Exception e){
            throw e;
        }finally{
            cp.releaseConnection(con);
        }
        return result;
    }

    public TotalOrder C431_1(Integer i) throws Exception{
        Connection con = cp.getConnection();
        TotalOrder result = null;
        try{
            result = dao.C431_1(i,con);
        } catch (Exception e) {
            throw e;
        }finally{
            cp.releaseConnection(con);
        }
        return result;
    }
}
