package edu.sm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetail {
    private int orderDetailId;  // 주문 상세 ID (Primary Key)
    private int orderId;        // 주문 ID (Foreign Key to totalOrder)
    private int itemId;         // 상품 ID (Foreign Key to item)
    private int itemNum;        // 주문한 상품 수량
    private Item item;          // 상품 정보 (item 객체 연결)
}
