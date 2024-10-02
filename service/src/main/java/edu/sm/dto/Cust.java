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

public class Cust {
    private String cust_id;
    private String cust_pwd;
    private String cust_name;
    private Integer cust_age;
    private Character gender;
    private String cust_num;
    private String cust_add;
    private String cust_mail;
    private String cust_grade;
    private Integer cust_point;
    private Date first_date;
    private Date update_date;
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder("Cust(");
//
//        if (cust_id != null) sb.append("cust_id=").append(cust_id).append(", ");
//        if (cust_pwd != null) sb.append("cust_pwd=").append(cust_pwd).append(", ");
//        if (cust_name != null) sb.append("cust_name=").append(cust_name).append(", ");
//        if (cust_age != null) sb.append("cust_age=").append(cust_age).append(", ");
//        if (gender != null) sb.append("gender=").append(gender).append(", ");
//        if (cust_num != null) sb.append("cust_num=").append(cust_num).append(", ");
//        if (cust_add != null) sb.append("cust_add=").append(cust_add).append(", ");
//        if (cust_mail != null) sb.append("cust_mail=").append(cust_mail);
//
//        // 마지막 쉼표 제거
//        if (sb.toString().endsWith(", ")) {
//            sb.setLength(sb.length() - 2);
//        }
//        sb.append(")");
//
//        return sb.toString();
//    }

}
