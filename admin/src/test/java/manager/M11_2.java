package manager;

import edu.sm.dao.ManagerDao;
import edu.sm.dto.Item;
import edu.sm.frame.ConnectionPool;

import java.sql.Connection;

public class M11_2 {
    public static void main(String[] args) {
        ManagerDao managerDao = new ManagerDao();
        Item item = Item.builder()
                .item_id(1)
                .item_name("테스트")
                .build();

        ConnectionPool connectionPool = null;
        Connection con = null;

        try {
            connectionPool = ConnectionPool.create();
            con = connectionPool.getConnection();

            if (con != null) {
                Boolean isUpdated = managerDao.M111_1(item, con);

                if (isUpdated) {
                    System.out.println("상품이 성공적으로 업데이트되었습니다.");
                } else {
                    System.out.println("상품 업데이트에 실패했습니다.");
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
