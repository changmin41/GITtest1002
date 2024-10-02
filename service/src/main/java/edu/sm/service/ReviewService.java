package edu.sm.service;

import edu.sm.dao.ReviewDao;
import edu.sm.dto.Review;
import edu.sm.frame.ConnectionPool;
import edu.sm.frame.MService;

import java.sql.Connection;
import java.sql.SQLException;

public class ReviewService implements MService<String, Review> {
    ReviewDao dao;
    ConnectionPool cp;

    public ReviewService() {
        dao = new ReviewDao();
        try {
            cp = ConnectionPool.create();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Review C221_1(Review review) throws Exception {
        Connection con = null;
        Review result = null;
        try {
            // 데이터베이스 연결 가져오기
            con = cp.getConnection();  // cp는 ConnectionPool 객체
            ReviewDao dao = new ReviewDao();

            // 후기 업데이트
            result = dao.C221_1(review, con);
        } catch (Exception e) {
            // 예외 처리
            throw e;
        } finally {
            if (con != null) {
                con.close();  // 연결 해제
            }
        }
        return review;
    }
    public Review C221_2(Review review) throws Exception {
        Connection con = cp.getConnection();
        dao.C211_2(review, con);
        cp.releaseConnection(con);
        return review;
    }
}



























