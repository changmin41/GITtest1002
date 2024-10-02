package edu.sm.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CouponBox {
    private Integer coupon_box_id;
    private Integer coupon_id;
    private String cust_id;
    private boolean used;
    private Coupon coupon;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CouponBox(");

        if (coupon_box_id != null) sb.append("coupon_box_id=").append(coupon_box_id).append(", ");
        if (coupon_id != null) sb.append("coupon_id=").append(coupon_id).append(", ");
        if (cust_id != null) sb.append("cust_id=").append(cust_id).append(", ");
        sb.append("used=").append(used); // boolean은 null이 없으므로 직접 추가

        // Coupon이 null이 아닐 경우 추가
        if (coupon != null) sb.append(", coupon=").append(coupon);

        // 마지막 쉼표 제거
        if (sb.toString().endsWith(", ")) {
            sb.setLength(sb.length() - 2);
        }
        sb.append(")");

        return sb.toString();
    }
}
