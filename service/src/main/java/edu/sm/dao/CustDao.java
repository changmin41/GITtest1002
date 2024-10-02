package edu.sm.dao;

import edu.sm.dto.Cust;
import edu.sm.frame.Dao;
import edu.sm.frame.Sql;

import java.sql.*;

public class CustDao implements Dao<String, Cust> {
    public Cust C4_1(String s, Connection con) throws Exception{
        PreparedStatement ps = null;
        ResultSet rs = null;
        Cust cust = null;
        try {
            ps = con.prepareStatement(Sql.C4_1);
            ps.setString(1, s);
            rs = ps.executeQuery();
            rs.next();
            cust = new Cust();
            cust.setCust_pwd(rs.getString(1));
            cust.setCust_name(rs.getString(2));
            cust.setCust_age(rs.getInt(3));
            cust.setGender(rs.getString(4).charAt(0));
            cust.setCust_num(rs.getString(5));
            cust.setCust_add(rs.getString(6));
            cust.setCust_mail(rs.getString(7));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally{
            if(ps != null){
                ps.close();
            }
            if(rs != null){
                rs.close();
            }
        }
        return cust;
    }

    public Cust C91_1(Cust cust, Connection con) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(Sql.C91_1);
            ps.setString(1, cust.getCust_id());
            ps.setString(2, cust.getCust_pwd());
            ps.setString(3, cust.getCust_name());
            ps.setInt(4, cust.getCust_age());
            ps.setString(5, String.valueOf(cust.getGender()));
            ps.setString(6, cust.getCust_num());
            ps.setString(7, cust.getCust_add());
            ps.setString(8, cust.getCust_mail());

            // 데이터베이스에 삽입
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cust;
    }
}
