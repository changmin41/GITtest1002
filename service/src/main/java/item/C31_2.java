package item;

import edu.sm.dto.Item;
import edu.sm.service.ItemService;

import java.util.List;

public class C31_2 {
    public static void main(String[] args) {
        ItemService itemService = new ItemService();
        List<Item> items = null;
        String s = "의류";

        try{
            items = itemService.C31_2(s);
//            System.out.println(items);
        }catch(Exception e){

        }
    }
}
