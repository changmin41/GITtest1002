package manager;

import edu.sm.dao.ManagerDao;
import edu.sm.dto.Answer;
import edu.sm.frame.ConnectionPool;

import java.sql.Connection;

public class M311_1 {
    public static void main(String[] args) {
        ManagerDao managerDao = new ManagerDao();

        Answer answer = Answer.builder()
                .review_id(4)
                .admin_id("admin02")
                .answer_detail("잘쓰세요")
                .build();

        ConnectionPool connectionPool = null;
        Connection con = null;

        try {
            connectionPool = ConnectionPool.create();
            con = connectionPool.getConnection();

            if (con != null) {
                Answer insertedAnswer = managerDao.M311_1(answer, con);
                if (insertedAnswer != null) {
                    System.out.println("답변이 성공적으로 삽입되었습니다: " + insertedAnswer);
                } else {
                    System.out.println("답변 삽입에 실패했습니다.");
                }
            } else {
                System.out.println("데이터베이스 연결에 실패했습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null && connectionPool != null) {
                connectionPool.releaseConnection(con);
            }
        }
    }
}
