package item;

import edu.sm.dto.Item;
import edu.sm.service.ItemService;

import java.util.List;

public class C31_1 {
    public static void main(String[] args) {
        ItemService itemService = new ItemService();
        List<Item> items = null;

        try{
            items = itemService.C31_1();
            System.out.println(items);
        }catch(Exception e){

        }

    }
}
