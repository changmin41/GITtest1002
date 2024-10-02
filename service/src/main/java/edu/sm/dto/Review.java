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
public class Review {
    private Integer review_id;
    private String cust_id;
    private Integer order_detail_id;
    private Integer item_id;
    private String review_title;
    private String review_text;
    private Integer review_star;
    private Date review_date;
}
