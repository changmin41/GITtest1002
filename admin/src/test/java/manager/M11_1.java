package manager;

import edu.sm.dao.ManagerDao;
import edu.sm.dto.Item;
import edu.sm.frame.ConnectionPool;

import java.sql.Connection;
import java.util.List;

public class M11_1 {
    public static void main(String[] args) {
        ManagerDao managerDao = new ManagerDao();
        List<Item> itemList = null;

        ConnectionPool connectionPool = null;
        Connection con = null;

        try {
            connectionPool = ConnectionPool.create();
            con = connectionPool.getConnection();

            if (con != null) {
                itemList = managerDao.M11_1(con);

                for (Item item : itemList) {
                    System.out.println(item);
                }
            } else {
                System.out.println("데이터베이스 연결에 실패했습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Connection을 ConnectionPool로 반환
            if (con != null && connectionPool != null) {
                connectionPool.releaseConnection(con);
            }
        }
    }
}
