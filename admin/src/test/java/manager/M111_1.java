package manager;

import edu.sm.dao.ManagerDao;
import edu.sm.dto.Item;
import edu.sm.frame.ConnectionPool;

import java.sql.Connection;

public class M111_1 {
    public static void main(String[] args) {
        ManagerDao managerDao = new ManagerDao();
        Item item = Item.builder()
                .item_id(1)
                .flag(false)
                .build();

        ConnectionPool connectionPool = null;
        Connection con = null;

        try {
            connectionPool = ConnectionPool.create();
            con = connectionPool.getConnection();

            if (con != null) {
                managerDao.M11_2(item, con);
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
