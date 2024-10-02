package edu.sm.frame;

public class AdminSql {
    // [상품 전체 목록 & 삭제 페이지] (ID: M11)
    //  상품 목록을 조회 & 삭제 할 수 있다. (ID: M11-1)
    public static String M11_1 = "SELECT i.item_id, i.item_name," +
            " i.item_price, i.item_stock, i.item_img, i.item_text," +
            " i.flag, i.first_date, i.update_date, c.category_id," +
            " c.category_id2, c.category_name " +
            "FROM item i " +
            "JOIN category c ON i.category_id = c.category_id";
    public static String M11_2 = "UPDATE item SET flag = ? WHERE item_id = ?";

    // [상품 수정 페이지] (ID: M111)
    // 상품 수정을 할 수 있다. (ID: M111-1)
    public static String M111_1= "UPDATE item SET item_name = ? WHERE item_id = ?";

    // [상품 등록 페이지] (ID: M112)
    // 상품을 등록 할 수 있다.(ID: M112_1)
    public static String M112_1= "INSERT INTO item (category_id, item_name, item_price, item_stock, item_img, item_text, first_date, update_date, flag) " +
            "VALUES (?, ?, ?, ?, ?, ?, default, default, true)";
    // 회원 삭제 (ID: M41-2)
    // [회원목록 조회 & 삭제 페이지] (ID:  M41)
    //회원 목록 조회 (ID: M41-1)
    public static String M41_1= "SELECT * FROM cust";
    // 회원 삭제 (ID: M41-2)
    //  -- ??? --- 추가예정 @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    // [회원정보수정 페이지] (ID: M411)
    // 회원 정보를 수정할 수 있다. (ID: M411_1)
    public static String M411_1 = "UPDATE cust SET cust_name = ? WHERE cust_id = ?";

    // [후기목록 조회 & 삭제 페이지] (ID: M31)
    // 후기목록 조회 (ID: M31-1)
    public static String M31_1 =  "SELECT * FROM review";

    // 후기 삭제 (ID: M31-2) [※CASCADE 추가 예정※]
    public static String m31_2 = "DELETE FROM review WHERE review_id = ?";

    //-- [후기답변 페이지] (ID: M311-1)
    public static String M311_1 = "INSERT INTO answer (review_id, admin_id, answer_detail, answer_date) VALUES (?, ?, ?, NOW())";

//    [성별에 따른 통계 페이지] (ID: M21)
//    성별별 판매량, 판매금,판매비율  조회 (ID: M21-1)
    public static String M21_1 = "SELECT c.gender AS gender,COUNT(t.order_id) AS total_sales_count," +
        "ROUND(COUNT(t.order_id) / (SELECT COUNT(order_id) FROM totalOrder) * 100, 2) AS percentage_of_total_sales_count,SUM(t.pay_price) AS total_sales_amount,"+
        "ROUND(SUM(t.pay_price) / (SELECT SUM(pay_price) FROM totalOrder) * 100, 2) AS percentage_of_total_sales_amount "+
        "FROM totalOrder t JOIN cust c ON t.cust_id = c.cust_id GROUP BY c.gender ORDER BY c.gender";

//   [나이별 통계 페이지] (ID: M22)
//    나이대 별 판매량, 판매금 조회 (ID: M22-1)
    public static String M22_1 = "SELECT CONCAT(FLOOR(c.cust_age / 10) * 10, '-', FLOOR(c.cust_age / 10) * 10 + 9) AS age_group, COUNT(t.order_id) AS total_sales_count, " +
        "ROUND(COUNT(t.order_id) / (SELECT COUNT(order_id) FROM totalOrder) * 100, 2) AS percentage_of_total_sales_count,SUM(t.pay_price) AS total_sales_amount, "+
        "ROUND(SUM(t.pay_price) / (SELECT SUM(pay_price) FROM totalOrder) * 100, 2) AS percentage_of_total_sales_amount " +
        "FROM totalOrder t JOIN cust c ON t.cust_id = c.cust_id GROUP BY age_group ORDER BY age_group";

    // [날짜별 통계 확인 페이지] (ID: M23)
    public static String M23_1 = "SELECT year(order_date) AS order_day, COUNT(t.order_id) AS total_sales_count," +
            "ROUND(COUNT(t.order_id) / (SELECT COUNT(order_id) FROM totalOrder) * 100, 2) AS percentage_of_total_sales_count,  SUM(t.pay_price) AS total_sales_amount ," +
            "ROUND(SUM(t.pay_price) / (SELECT SUM(pay_price) FROM totalOrder) * 100, 2) AS percentage_of_total_sales_amount " +
            "FROM totalOrder t WHERE order_date BETWEEN '2020-01-01' AND now()  GROUP BY order_day ORDER BY order_day";

    // [지역별 통계 확인 페이지] (ID: M24)
    public static String M24_1 = "SELECT c.cust_add AS loc_group, COUNT(t.order_id) AS total_sales_count," +
            "ROUND(COUNT(t.order_id) / (SELECT COUNT(order_id) FROM totalOrder) * 100, 2) AS percentage_of_total_sales_count, SUM(t.pay_price) AS total_sales_amount," +
            "ROUND(SUM(t.pay_price) / (SELECT SUM(pay_price) FROM totalOrder) * 100, 2) AS percentage_of_total_sales_amount " +
            "FROM totalOrder t JOIN cust c ON t.cust_id = c.cust_id GROUP BY c.cust_add";


    //로그인 관련
    public static String selectCustByLogin = "SELECT admin_id, admin_pw, admin_name FROM adminInfo WHERE admin_id = ? AND admin_pw = ?";

}
