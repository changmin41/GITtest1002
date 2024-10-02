package edu.sm.service;

import edu.sm.dao.CouponDao;
import edu.sm.dto.Coupon;
import edu.sm.dto.CouponBox;
import edu.sm.frame.ConnectionPool;
import edu.sm.frame.MService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CouponService implements MService <Integer, Coupon>{
    CouponDao dao;
    ConnectionPool cp;
    public CouponService() {
        dao = new CouponDao();
        try {
            cp = ConnectionPool.create();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<CouponBox> C44_1(String s) throws Exception{
        Connection con = cp.getConnection();
        List<CouponBox> result = null;
        try{
            result = dao.C44_1(s, con);
        }catch(Exception e){
            throw e;
        }finally{
            cp.releaseConnection(con);
        }

        return result;
    }

    public Coupon C441_1(Integer i) throws Exception{
        Connection con = cp.getConnection();
        Coupon result = null;
        try{
            result = dao.C441_1(i, con);
        }catch(Exception e){
            throw e;
        }finally{
            cp.releaseConnection(con);
        }
        return result;
    }
}
