package edu.sm.dao;

import edu.sm.dto.*;
import edu.sm.frame.AdminSql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ManagerDao {
    public AdminInfo selectByLogin(String id, String pwd, Connection con) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        AdminInfo adminInfo = null;
        try{
            ps = con.prepareStatement(AdminSql.selectCustByLogin);
            ps.setString(1, id);
            ps.setString(2, pwd);
            rs = ps.executeQuery();

            if (rs.next()) {
                adminInfo = new AdminInfo();
                adminInfo.setAdmin_id(rs.getString("admin_id"));
                adminInfo.setAdmin_pw(rs.getString("admin_pw"));
                adminInfo.setAdmin_name(rs.getString("admin_name"));
            }
        }catch(Exception e){
            throw e;
        }finally {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }

        return adminInfo;
    }

    public List<Item> M11_1(Connection con) throws Exception {
        List<Item> itemList = new ArrayList<>();  // 상품 목록을 저장할 리스트
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // SQL 쿼리 실행 (상위 카테고리 ID도 포함)
            ps = con.prepareStatement(AdminSql.M11_1);
            rs = ps.executeQuery();

            // 결과 처리
            while (rs.next()) {
                // item 테이블의 필드들
                int itemId = rs.getInt("item_id");
                int categoryId = rs.getInt("category_id");  // category_id 필드 추가
                String itemName = rs.getString("item_name");
                int itemPrice = rs.getInt("item_price");
                int itemStock = rs.getInt("item_stock");
                String itemImg = rs.getString("item_img");
                String itemText = rs.getString("item_text");
                boolean flag = rs.getBoolean("flag");
                Date firstDate = rs.getDate("first_date");
                Date updateDate = rs.getDate("update_date");

                // category 테이블의 필드들
                Integer categoryId2 = (Integer) rs.getObject("category_id2");  // 상위 카테고리 처리
                String categoryName = rs.getString("category_name");

                // Category 객체 생성
                Category category = new Category(categoryId, categoryId2, categoryName);

                // Item 객체 생성 및 리스트에 추가 (category_id도 포함)
                Item item = Item.builder()
                        .item_id(itemId)
                        .category_id(categoryId)  // category_id 추가
                        .item_name(itemName)
                        .itemPrice(itemPrice)
                        .item_stock(itemStock)
                        .item_img(itemImg)
                        .item_text(itemText)
                        .first_date(firstDate)
                        .update_date(updateDate)
                        .flag(flag)
                        .category(category)  // Category 객체 설정
                        .build();

                System.out.println(item.toString());
                itemList.add(item);


            }
        } catch (Exception e) {
            throw e;
        } finally {
            // 리소스 해제
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }
        return itemList;  // 조회된 상품 목록 반환
    }


    public Boolean M11_2(Item item, Connection con) throws Exception {
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(AdminSql.M111_1);
            ps.setBoolean(1, item.isFlag());
            ps.setInt(2, item.getItem_id());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) ps.close();
        }
    }

    public Boolean M111_1(Item item, Connection con) throws Exception {
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(AdminSql.M111_1);

            ps.setString(1, item.getItem_name());
            ps.setInt(2, item.getItem_id());

            int result = ps.executeUpdate();
            System.out.println("업데이트된 행의 수: " + result);

            return result > 0;
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) ps.close();
        }
    }


    public Item M112_1(Item item, Connection con) throws Exception {
        PreparedStatement ps = null;

        try {
            // SQL 문 준비
            ps = con.prepareStatement(AdminSql.M112_1);

            // 파라미터 설정
            ps.setInt(1, item.getCategory_id());  // 카테고리 ID
            ps.setString(2, item.getItem_name()); // 상품 이름
            ps.setInt(3, item.getItemPrice());    // 상품 가격
            ps.setInt(4, item.getItem_stock());   // 상품 재고
            ps.setString(5, item.getItem_img());  // 상품 이미지
            ps.setString(6, item.getItem_text()); // 상품 설명
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) ps.close();
        }
        return item;
    }


    public List<Cust> m41_1(Connection conn) throws Exception {
        List<Cust> custList = new ArrayList<>();  // 고객 목록을 저장할 리스트
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(AdminSql.M41_1);
            rs = ps.executeQuery();

            while (rs.next()) {
                Cust cust = new Cust();

                cust.setCust_id(rs.getString("cust_id"));
                cust.setCust_pwd(rs.getString("cust_pwd"));
                cust.setCust_name(rs.getString("cust_name"));
                cust.setCust_age(rs.getInt("cust_age"));
                cust.setGender(rs.getString("gender").charAt(0));  // 'm' 또는 'w' 등 1문자
                cust.setCust_num(rs.getString("cust_num"));
                cust.setCust_add(rs.getString("cust_add"));
                cust.setCust_mail(rs.getString("cust_mail"));
                cust.setCust_grade(rs.getString("cust_grade"));
                cust.setCust_point(rs.getInt("cust_point"));
                cust.setFirst_date(rs.getDate("first_date"));
                cust.setUpdate_date(rs.getDate("update_date"));
                custList.add(cust);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }

        return custList;
    }

    public Boolean M411_1(Cust cust, Connection con) throws Exception {
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(AdminSql.M411_1);

            ps.setString(1, cust.getCust_name());
            ps.setString(2, cust.getCust_id());
            int result = ps.executeUpdate();

            return result > 0;
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) ps.close();
        }
    }

    public List<Review> M31_1(Connection conn) throws Exception {
        List<Review> reviewList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(AdminSql.M31_1);
            rs = ps.executeQuery();
            while (rs.next()) {
                Review review = new Review();
                review.setReview_id(rs.getInt("review_id"));          // 리뷰 ID (int)
                review.setCust_id(rs.getString("cust_id"));           // 고객 ID (String)
                review.setReview_title(rs.getString("review_title")); // 리뷰 제목 (String)
                review.setReview_text(rs.getString("review_text"));   // 리뷰 내용 (String)
                review.setReview_star(rs.getInt("review_star"));      // 별점 (int)
                reviewList.add(review);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        }

        return reviewList;
    }

    public Answer M311_1(Answer answer, Connection con) throws Exception {
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(AdminSql.M311_1);

            ps.setInt(1, answer.getReview_id());
            ps.setString(2, answer.getAdmin_id());
            ps.setString(3, answer.getAnswer_detail());
            ps.executeUpdate();

            return answer;
        } catch (Exception e) {
            throw e;
        } finally {
            if (ps != null) ps.close();
        }
    }
}
