package edu.sm.service;
import edu.sm.dao.ItemDao;
import edu.sm.dto.Item;
import edu.sm.frame.ConnectionPool;
import edu.sm.frame.MService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ItemService implements MService<Integer, Item> {
    ItemDao dao;
    ConnectionPool cp;
    public ItemService() {
        dao = new ItemDao();
        try {
            cp = ConnectionPool.create();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Item> C31_1() throws Exception {
        Connection con = cp.getConnection();
        List<Item> result = null;
        try{
            result = dao.C31_1(con);
        }catch(Exception e){
            throw e;
        }finally{
            cp.releaseConnection(con);
        }
        return result;
    }

    public List<Item> C31_2(String s) throws Exception {
        Connection con = cp.getConnection();
        List<Item> result = null;
        try{
            result = dao.C31_2(s, con);
        }catch(Exception e){
            throw e;
        }finally {
            cp.releaseConnection(con);
        }
        return result;
    }

    public Item C311_1(Integer i)throws Exception {
        Connection con = cp.getConnection();
        Item result = null;
        try{
            result = dao.C311_1(i, con);
        }catch(Exception e){
            throw e;
        }finally{
            cp.releaseConnection(con);
        }
        return result;
    }

    public List<Item> C11_1() throws Exception{
        Connection con = cp.getConnection();
        List<Item> result = null;
        try {
            result = dao.C11_1(con);
        } catch (Exception e) {
            throw e;
        }finally {
            cp.releaseConnection(con);
        }
        return result;
    }
}
