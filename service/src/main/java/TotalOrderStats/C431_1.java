package TotalOrderStats;

import edu.sm.dto.TotalOrder;
import edu.sm.service.TotalOrderService;

public class C431_1 {
    public static void main(String[] args) {
        TotalOrderService totalOrderService = new TotalOrderService();
        TotalOrder totalOrder = new TotalOrder();
        int i = 9;

        try{
            totalOrder = totalOrderService.C431_1(i);
            System.out.println("주문번호:" + totalOrder.getOrder_id() +" 주문날짜:"+ totalOrder.getOrder_date() +" 결제방식:"+ totalOrder.getPayment_method() +" 가격:"+ totalOrder.getPay_price() + " 주소:" +totalOrder.getReciver_add() + " 상세주소:" +totalOrder.getReciver_add_detail());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
