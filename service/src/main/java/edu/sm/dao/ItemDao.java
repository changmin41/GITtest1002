package edu.sm.dao;

import edu.sm.dto.Item;
import edu.sm.frame.Dao;
import edu.sm.frame.Sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemDao implements Dao<Integer, Item> {
    public List<Item> C31_1(Connection con) throws Exception{
        List<Item> items = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            ps = con.prepareStatement(Sql.C31_1);
            rs = ps.executeQuery();
            while(rs.next()){
                Item item = new Item();
                item.setItem_id(rs.getInt(1));
                item.setItem_name(rs.getString(2));
                item.setItemPrice(rs.getInt(3));
                items.add(item);
                System.out.println(item.toString());
            }
        }catch(Exception e){
            throw e;
        }finally {
            if(ps != null) ps.close();
            if(rs != null) rs.close();
        }
        return items;
    }

    public List<Item> C31_2(String s,Connection con) throws Exception{
        List<Item> items = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            ps = con.prepareStatement(Sql.C31_2);
            ps.setString(1, s);
            rs = ps.executeQuery();
            while(rs.next()){
                Item item = new Item();
                item.setItem_id(rs.getInt(1));
                item.setItem_name(rs.getString(2));
                item.setItemPrice(rs.getInt(3));
                items.add(item);
                System.out.println(item.toString());
            }
        }catch(Exception e){
            throw e;
        }finally {
            if(ps != null) ps.close();
            if(rs != null) rs.close();
        }

        return items;
    }

    public Item C311_1(Integer i,Connection con) throws Exception{
        PreparedStatement ps = null;
        ResultSet rs = null;
        Item item = null;
        try{
            ps = con.prepareStatement(Sql.C311_1);
            ps.setInt(1, i);
            rs = ps.executeQuery();
            rs.next();
            item = new Item();
            item.setItem_id(rs.getInt(1));
            item.setItem_name(rs.getString(2));
            item.setItemPrice(rs.getInt(3));
            item.setItem_stock(rs.getInt(4));
            item.setItem_img(rs.getString(5));
            item.setItem_text(rs.getString(6));
            item.setFlag(rs.getBoolean(7));
        }catch(Exception e){
            throw e;
        }finally {
            if(ps != null) ps.close();
            if(rs != null) rs.close();
        }

        return item;
    }

    public List<Item> C11_1(Connection con) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Item> items = new ArrayList<>();
        try {
            ps = con.prepareStatement(Sql.C11_1);
            rs = ps.executeQuery();
            while(rs.next()) {
                Item item = new Item();
                item.setItem_name(rs.getString(1));
                item.setItemPrice(rs.getInt(2));
                items.add(item);
//                System.out.println(item);
            }
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return items;
    }
}
