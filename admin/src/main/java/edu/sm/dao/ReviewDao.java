package edu.sm.dao;

import edu.sm.dto.Review;
import edu.sm.frame.Dao;
import edu.sm.frame.Sql;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReviewDao implements Dao<String, Review>{

             //후기(제목, 내용, 별점)를 수정할 수 있다. (ID: C211-1 )
    public Review C221_1(Review review, Connection con) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(Sql.C221_1);
            ps.setString(1, review.getReview_title());
            ps.setString(2, review.getReview_text());
            ps.setInt(3, review.getReview_star());
            ps.executeUpdate();
        }catch (Exception e) {
            throw e;
        }finally {
            if(ps != null) ps.close();
        }
        return review;
    }

    public Boolean C211_2(Review review, Connection con) throws Exception {
        // 후기삭제
        boolean b = false;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(Sql.C221_1);
            ps.setInt(1, review.getReview_id());
          int result =  ps.executeUpdate();
            if(result == 1){
                b = true;
            }
        }catch (Exception e) {
            throw e;
        }finally {
            if(ps != null) ps.close();
        }
        return b;
    }


}
