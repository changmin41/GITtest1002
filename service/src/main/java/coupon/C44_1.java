package coupon;

import edu.sm.dto.Coupon;
import edu.sm.dto.CouponBox;
import edu.sm.service.CouponService;

import java.util.List;

public class C44_1 {
    public static void main(String[] args) {
        CouponService couponService = new CouponService();
        String id = "id05";
        List<CouponBox> couponBoxes = null;
        try{
            couponBoxes = couponService.C44_1(id);
            for(CouponBox couponBox : couponBoxes){
                System.out.println(couponBox);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
