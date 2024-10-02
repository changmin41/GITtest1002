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
public class Answer {
    private Integer answer_id;
    private Integer review_id;
    private String admin_id;
    private String answer_detail;
    private Date answer_date;
}
