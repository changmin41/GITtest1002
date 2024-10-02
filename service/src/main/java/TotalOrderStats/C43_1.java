package TotalOrderStats;

import edu.sm.dto.TotalOrder;
import edu.sm.service.TotalOrderService;

import java.util.List;

public class C43_1 {
    public static void main(String[] args) {
        TotalOrderService totalOrderService = new TotalOrderService();
        List<TotalOrder> totalOrders = null;
        String s = "id09";

        try{
            totalOrders = totalOrderService.C43_1(s);
            for(TotalOrder totalOrder : totalOrders){
                System.out.println("주문번호:" + totalOrder.getOrder_id()+" 주문날짜:"+totalOrder.getOrder_date()+" 가격:"+totalOrder.getPay_price());
            }
        }catch(Exception e){

        }
    }
}
