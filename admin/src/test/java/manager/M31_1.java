package manager;

import edu.sm.dao.ManagerDao;
import edu.sm.dto.Review;
import edu.sm.frame.ConnectionPool;

import java.sql.Connection;
import java.util.List;

public class M31_1 {
    public static void main(String[] args) {
        ManagerDao managerDao = new ManagerDao();  // ManagerDao 객체 생성
        List<Review> reviews = null;              // 리뷰 목록을 저장할 리스트

        ConnectionPool connectionPool = null;
        Connection con = null;

        try {
            // ConnectionPool에서 Connection 가져오기
            connectionPool = ConnectionPool.create();
            con = connectionPool.getConnection();

            if (con != null) {
                // ManagerDao의 M31_1 메서드를 통해 리뷰 목록 조회
                reviews = managerDao.M31_1(con);

                // 리뷰 목록 출력
                for (Review review : reviews) {
                    System.out.println(review);
                }
            } else {
                System.out.println("데이터베이스 연결에 실패했습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Connection 반환
            if (con != null && connectionPool != null) {
                connectionPool.releaseConnection(con);
            }
        }
    }
}
