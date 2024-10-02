package item;

import edu.sm.dto.Item;
import edu.sm.service.ItemService;

import java.util.List;

public class C311_1 {
    public static void main(String[] args) {
        ItemService itemService = new ItemService();
        Item item = null;
        int id = 1;

        try{
            item = itemService.C311_1(id);
            System.out.println(item);
        }catch(Exception e){

        }
    }
}
