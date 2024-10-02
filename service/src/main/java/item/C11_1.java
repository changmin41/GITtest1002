package item;

import edu.sm.dto.Item;
import edu.sm.service.ItemService;

import java.util.List;

//public class C11_1 {
//    public static void main(String[] args) {
//        ItemService itemService = new ItemService();
//        List<Item> items = null;
//
//        try {
//            items = itemService.C11_1();
//           System.out.println(items);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}

public class C11_1 {
    public static void main(String[] args) {
        ItemService itemService = new ItemService();
        List<Item> items = null;

        try {
            items = itemService.C11_1();

            // item_name과 itemprice만 출력
            for (Item item : items) {
                System.out.println("[상품이름]=" + item.getItem_name() + " [상품 가격]= " + item.getItemPrice());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

