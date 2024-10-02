package edu.sm.frame;

public class Sql {
    // [회원가입 페이지](ID: C91)
    // 회원가입(아이디, 비번, 이름,나이, 성별, 전번, 주소, 이메일)을 할 수 있다. (ID: C91_1)
    public static String C91_1 = "insert into cust values(?,?,?,?,?,?,?,?,default,default,default,default)";

    // [주문 대기 목록 & 삭제 페이지] (ID: C11)
    // 상품이름, 가격 조회할 수있다 (ID : C11-1)
    public static String C11_1 =  "SELECT item_name, item_price FROM item";


    //[후기 수정 페이지 ] (ID: C211)
    //후기(제목, 내용, 별점)를 수정할 수 있다. (ID: C211-1 )
    public static String C221_1 = "UPDATE review SET review_title = ?, review_text = ?, review_star = ?";
    //후기를 삭제할 수 있다. (ID: C211-2 )
    public static String C211_2 = "delete from review  where review_id = ?";

    //[후기 작성 페이지] (ID: C22)
    //후기를 작성할 수 있다.(제목, 내용, 별점) (ID: C22_1)
    public static String C22_1 =
            "INSERT INTO review VALUES(0, 'id01', 1, ?, ?, ?, str_to_date('20-12-2023', '%d-%m-%Y'))";

//    [상품 조회 페이지] (ID : C31 )
//    상품 ID (카테고리,이름,가격) 조회 (ID : C31-1 )
    public static String C31_1 = "SELECT item_id, item_name, item_price FROM item";
//    의류,가전,식품.도서 목록 페이지 조회 (ID : C31-2 )
    public static String C31_2 = "SELECT i.item_id,i.item_name,i.item_price,i.item_stock " +
        "FROM item i JOIN category c ON i.category_id = c.category_id " +
        "WHERE c.category_name = ?";

//    [상품 상세 페이지] (ID : C311 )
//    상품ID (이름,가격, 재고,이미지,설명, 표시 여부) 조회 (ID : C311-1 )
    public static String C311_1 = "SELECT i.item_id, i.item_name,i.item_price,i.item_stock,i.item_img, i.item_text ,i.flag " +
        "FROM item i WHERE i.item_id = ?";

//    [마이페이지] (ID : C4  )
//    아이디(비밀번호,이름,나이,성별,전화번호,주소,이메일)를 조회할수 있다. (ID : C4-1 )
    public static String C4_1 = "SELECT cust_pwd,cust_name,cust_age, gender,cust_num,cust_add,cust_mail FROM cust WHERE cust_id = ?";
//    [장바구니 페이지 ]  (ID : C41)
//    장바구니 ID(회원아이디,상품번호,상품수량) 조회. (ID : C41-1)
    public static String C41_1 = "SELECT c.cust_id, i.item_name, i.item_price FROM item i,cart ca,cust c WHERE c.cust_id = ca.cust_id" +
    "AND ca.item_id = i.item_id AND c.cust_id = ?";
    //    장바구니 추가(회원아이디,상품번호,상품수량 (ID : C41-2)
    public static String C41_2 = "INSERT INTO cart VALUES(0, ?, ?, ?)";
//    [회원정보 수정] (ID : C42)
//    회원정보(아이디, 비번, 이름,나이, 성별, 전번, 주소, 이메일)를 수정 할 수 있다. (ID : C42-1)
    public static String C42_1 = "UPDATE cust SET cust_pwd = ?,cust_name = ?,cust_age = ?,gender = ?, cust_num = ?,cust_add = ?,cust_mail = ? WHERE cust_id = ?";
//    [구매목록 페이지] (ID : C43)
//    주문ID (주문ID, 주문날짜, 결제 금액) (ID : C43-1)
    public static String C43_1 = "SELECT o.order_id,o.order_date,o.pay_price from totalOrder o WHERE cust_id =?";
//    [구매 상세] (ID : C431)
//    주문상세ID( 주문ID, 주문날짜, 결제 금액, 결제방식, 주문번호, 배송지 ) (ID : C431-1)
    //수정 필요@@@@@@@@@@@@@@@@@@@@@@@
    public static String C431_1 = "SELECT order_id,order_date,pay_price,payment_method,receiver_add,receiver_add_detail FROM totalorder WHERE order_id = ?";
//    [쿠폰 목록 조회 페이지] (ID : C44)
//    쿠폰함에있는 쿠폰 아이디(이름,할인가격,사용 여부)를 불러올 수 있다. (ID : C44-1)
    public static String C44_1 = "SELECT cpb.coupon_box_id,cp.coupon_name, cp.discount, cpb.used FROM couponbox cpb,cust c,coupon cp " +
        "WHERE c.cust_id = cpb.cust_id AND cpb.coupon_id = cp.coupon_id and c.cust_id = ? and cpb.used = 0";
//    [쿠폰 상세 페이지] (ID : C441)
//    쿠폰ID(일련번호,유효일자, 이름,할인가격)를 불러올 수 있다. (ID : C441-1)
    public static String C441_1 = "SELECT cp.coupon_serial, cp.effectivedate, cp.coupon_name, cp.discount FROM couponbox cpb,cust c,coupon cp " +
    "WHERE c.cust_id = cpb.cust_id and cpb.coupon_id = cp.coupon_id and cpb.coupon_box_id = ?";

}
