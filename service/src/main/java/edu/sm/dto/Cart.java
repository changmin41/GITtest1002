package edu.sm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getter, setter, toString 자동 생성
@AllArgsConstructor //전체 파라미터 생성자 자동 생성
@NoArgsConstructor //기본 생성자 자동 생성
@Builder //객체 생성할때 new 로 안하고 Cust.bulider().id("").pwd("").build(); 원하는 값만 넣기 가능

public class Cart {
    private int cart_id;
    private String cust_Id;
    private Integer item_id;
    private Integer cnt;
}
