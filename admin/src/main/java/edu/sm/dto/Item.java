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
public class Item {
    private int item_id;
    private int category_id;
    private String item_name;
    private int itemPrice;
    private int item_stock;
    private String item_img;
    private String item_text;
    private Date first_date;
    private Date update_date;
    private boolean flag;

    private Category category;
}




