package edu.sm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Coupon {
    private Integer coupon_id;
    private String coupon_serial;
    private Date effectivedate;
    private Integer discount;
    private String coupon_name;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Coupon(");

        if (coupon_id != null) sb.append("coupon_id=").append(coupon_id).append(", ");
        if (coupon_serial != null) sb.append("coupon_serial=").append(coupon_serial).append(", ");
        if (effectivedate != null) sb.append("effectivedate=").append(effectivedate).append(", ");
        if (discount != null) sb.append("discount=").append(discount).append(", ");
        if (coupon_name != null) sb.append("coupon_name=").append(coupon_name);

        // 마지막 쉼표 제거
        if (sb.toString().endsWith(", ")) {
            sb.setLength(sb.length() - 2);
        }
        sb.append(")");

        return sb.toString();
    }
}
