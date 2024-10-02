package edu.sm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TotalOrderStats {
    private String Group;  // 그룹
    private int totalSalesCount;  // 그룹별 총 판매량 (주문 수)
    private double percentageOfTotalSalesCount;  // 전체 판매량 대비 비율
    private double totalSalesAmount;  // 그룹별 총 구매 금액
    private double percentageOfTotalSalesAmount;  // 전체 구매 금액 대비 비율
}
