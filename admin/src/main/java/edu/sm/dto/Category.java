package edu.sm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {
    private int categoryId;       // 카테고리 ID (Primary Key)
    private Integer categoryId2;  // 상위 카테고리 ID (null 허용, 서브 카테고리일 때 상위 카테고리 ID)
    private String categoryName;  // 카테고리 이름
}
