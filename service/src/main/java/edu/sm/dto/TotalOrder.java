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
public class TotalOrder {
    private int order_id;
    private String cust_id;
    private Integer cupon_id;
    private Date order_date;
    private String payment_method;
    private Integer pay_price;
    private String reciver;
    private String reciver_num;
    private String reciver_add;
    private String reciver_add_detail;
    private String request;

}
