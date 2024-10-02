package cust;

import edu.sm.dto.Cust;
import edu.sm.service.CustService;

public class C91_1 { // 회원가입(아이디, 비밀번호, 이름, 나이, 성별, 전화번호, 주소, 이메일) 후 DB 삽입만
    public static void main(String[] args) {
        CustService custService = new CustService();
        Cust cust = Cust.builder()
                .cust_id("1115")
                .cust_pwd("111")
                .cust_name("ssss")
                .cust_age(22)
                .gender('w')
                .cust_num("010-1234-5678")
                .cust_add("우리집")
                .cust_mail("ak@gmail.com")
                .build();

        try {
            custService.C91_1(cust);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
