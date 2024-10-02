package cust;

import edu.sm.dto.Cust;
import edu.sm.service.CustService;

public class C4_1 {
    public static void main(String[] args) {
        CustService custService = new CustService();
        String id = "id01";
        Cust cust = null;
        try{
            cust = custService.C4_1(id);
            System.out.println(cust);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
