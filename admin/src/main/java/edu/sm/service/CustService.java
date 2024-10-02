package edu.sm.service;

import edu.sm.dao.CustDao;
import edu.sm.dto.Cust;
import edu.sm.frame.ConnectionPool;
import edu.sm.frame.MService;

import java.sql.Connection;
import java.sql.SQLException;

public class CustService implements MService<String, Cust> {
    CustDao dao;
    ConnectionPool cp;
    public CustService() {
        dao = new CustDao();
        try {
            cp = ConnectionPool.create();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Cust C4_1(String s) throws Exception{
        Connection con = cp.getConnection();
        Cust result = null;
        try{
            result = dao.C4_1(s, con);
        }catch(Exception e){
            throw e;
        }finally{
            cp.releaseConnection(con);
        }
        return result;
    }

    public Cust C91_1(Cust Cust) throws Exception {
        Connection con = cp.getConnection(); //db연결
        dao.C91_1(Cust, con);

        return Cust;
    }
}
