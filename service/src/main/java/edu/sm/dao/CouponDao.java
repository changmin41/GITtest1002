package edu.sm.dao;

import edu.sm.dto.Coupon;
import edu.sm.dto.CouponBox;
import edu.sm.frame.Dao;
import edu.sm.frame.Sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CouponDao implements Dao<Integer, Coupon> {
    public List<CouponBox> C44_1(String s, Connection con)throws Exception{
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<CouponBox> couponBoxes = new ArrayList<>();
        try {
            // SQL 준비
            ps = con.prepareStatement(Sql.C44_1);
            ps.setString(1, s); // ?에 문자열 s를 바인딩

            // 쿼리 실행
            rs = ps.executeQuery();

            // 결과가 여러 행일 수 있으므로 while 루프로 처리
            while (rs.next()) {
                // CouponBox 객체 생성 및 데이터 설정
                CouponBox couponBox = CouponBox.builder()
                        .coupon_box_id(rs.getInt(1))
                        .used(rs.getBoolean(4))
                        .build();

                // Coupon 객체 생성 및 데이터 설정
                Coupon coupon = Coupon.builder()
//                        .coupon_id(rs.getInt(1))
                        .coupon_name(rs.getString(2))
                        .discount(rs.getInt(3))
                        .build();

                // Coupon 객체를 CouponBox에 설정 (필요 시 CouponBox에 Coupon을 포함시킬 수 있음)
                couponBox.setCoupon(coupon); // CouponBox 클래스에 Coupon 필드를 추가해야 함

                // 리스트에 추가
                couponBoxes.add(couponBox);
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 출력
            throw new Exception("Error executing query", e);
        } finally {
            // 리소스 정리
            if (rs != null) try { rs.close(); } catch (Exception e) {}
            if (ps != null) try { ps.close(); } catch (Exception e) {}
        }
        return couponBoxes;
    }

    public Coupon C441_1(Integer i, Connection con)throws Exception{
        Coupon coupon = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            // SQL 준비
            ps = con.prepareStatement(Sql.C441_1);
            ps.setInt(1, i);
            // 쿼리 실행
            rs = ps.executeQuery();
            rs.next();
            coupon = Coupon.builder()
                    .coupon_serial(rs.getString(1))
                    .effectivedate(rs.getDate(2))
                    .coupon_name(rs.getString(3))
                    .discount(rs.getInt(4))
                    .build();


        }catch(Exception e){

        }finally {
            if (rs != null) try { rs.close(); } catch (Exception e) {}
            if (ps != null) try { ps.close(); } catch (Exception e) {}
        }

        return coupon;
    }
}
