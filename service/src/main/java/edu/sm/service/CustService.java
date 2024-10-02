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

    public Cust loginCheck(String id, String pwd) throws Exception {
        Connection con = cp.getConnection();
        Cust result = null;
        try {
            result = dao.selectByLogin(id, pwd, con);  // ID와 비밀번호로 검증
            if (result != null) {
                System.out.println("로그인 성공: " + result.getCust_name());
            } else {

                System.out.println("로그인 실패: 아이디 또는 비밀번호가 올바르지 않습니다.");
            }
        } catch (Exception e) {
            throw e;
        } finally {
            cp.releaseConnection(con);
        }
        return result;  // null일 경우, 로그인 실패
    }
}
