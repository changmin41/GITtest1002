package manager;

import edu.sm.dao.ManagerDao;
import edu.sm.dto.Cust;
import edu.sm.frame.ConnectionPool;

import java.sql.Connection;

public class M411_1 {
    public static void main(String[] args) {
        ManagerDao managerDao = new ManagerDao();

        // 업데이트할 고객 정보 (cust_id는 존재하는 값이어야 함)
        Cust cust = Cust.builder()
                .cust_id("id02")             // 수정할 고객 ID
                .cust_name("이름 바뀜 테스트중")      // 새로운 이름
                .build();

        ConnectionPool connectionPool = null;
        Connection con = null;

        try {
            // ConnectionPool에서 Connection 가져오기
            connectionPool = ConnectionPool.create();
            con = connectionPool.getConnection();

            if (con != null) {
                // 이름 변경 메서드 호출
                boolean isUpdated = managerDao.M411_1(cust, con);

                // 결과 출력
                if (isUpdated) {
                    System.out.println("이름이 성공적으로 변경되었습니다.");
                } else {
                    System.out.println("이름 변경에 실패했습니다.");
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
