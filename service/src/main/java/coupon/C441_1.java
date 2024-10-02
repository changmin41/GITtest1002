package coupon;

import edu.sm.dto.Coupon;
import edu.sm.dto.CouponBox;
import edu.sm.service.CouponService;

import java.util.List;

public class C441_1 {
    public static void main(String[] args) {
        CouponService couponService = new CouponService();
        int id = 4;
        Coupon coupon = null;
        try{
            coupon = couponService.C441_1(id);
            System.out.println(coupon);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
