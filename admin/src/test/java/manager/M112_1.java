package manager;

import edu.sm.dao.ManagerDao;
import edu.sm.dto.Item;
import edu.sm.frame.ConnectionPool;

import java.sql.Connection;

public class M112_1 {
    public static void main(String[] args) {
        // ManagerDao 객체 생성
        ManagerDao managerDao = new ManagerDao();

        // 삽입할 Item 객체 생성
        Item item = Item.builder()
                .category_id(10)               // 카테고리 ID 설정
                .item_name("바지2")             // 상품 이름 설정
                .itemPrice(1500)               // 상품 가격 설정
                .item_stock(5)                 // 상품 재고 설정
                .item_img("바지2_이미지.jpg")   // 상품 이미지 설정 (예시)
                .item_text("바지에용")          // 상품 설명 설정
                .build();

        ConnectionPool connectionPool = null;
        Connection con = null;

        try {
            // ConnectionPool에서 Connection 가져오기
            connectionPool = ConnectionPool.create();
            con = connectionPool.getConnection();

            if (con != null) {
                // M112_1 메서드를 통해 Item 삽입
                Item insertedItem = managerDao.M112_1(item, con);

                // 삽입 결과 출력
                if (insertedItem != null) {
                    System.out.println("상품이 성공적으로 삽입되었습니다: " + insertedItem);
                } else {
                    System.out.println("상품 삽입에 실패했습니다.");
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
