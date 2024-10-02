package edu.sm;

import edu.sm.dto.AdminInfo;
import edu.sm.dto.Item;
import edu.sm.service.AdminService;
import edu.sm.service.TotalOrderService;

import java.util.Scanner;

public class AdminMain {
    public static void main(String[] args) {
        boolean lobby = true;
        boolean login = false;
        Scanner sc = new Scanner(System.in);
        AdminService adminService = new AdminService();
        TotalOrderService totalOrderService = new TotalOrderService();

        while (lobby) {
            System.out.println("ㅡㅡㅡㅡㅡㅡㅡ쇼핑몰 관리 프로그램ㅡㅡㅡㅡㅡㅡㅡ");
            System.out.print("1.[로그인] 2.[종료] : ");
            int num = sc.nextInt();

            //로그인
            if (num == 1) {
                System.out.println("*****[로그인]*****");
                System.out.print("아이디 : ");
                String id = sc.next();
                System.out.print("비밀번호 : ");
                String pwd = sc.next();
                AdminInfo adminInfo = null;
                try {
                    adminInfo = adminService.loginCheck(id, pwd);
                    if (adminInfo != null) {
                        System.out.println("로그인 성공! 환영합니다, " + adminInfo.getAdmin_name() + "님!");
                        login = true;
                    } else {
                        System.out.println("로그인 실패! 아이디 또는 비밀번호를 확인하세요.");
                    }
                } catch (Exception e) {
                    System.out.println("시스템 오류로 로그인을 처리할 수 없습니다.");
                    e.printStackTrace();
                }

                //로그인 성공시
                while (login) {
                    System.out.println("ㅡㅡㅡㅡㅡㅡㅡ메인화면ㅡㅡㅡㅡㅡㅡㅡ");
                    System.out.print("1.[상품관리] 2.[통계] 3.[후기관리] 4.[회원관리] 5.[로그아웃]: ");
                    int menu = sc.nextInt();
                    if(menu == 1){
                        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ상품관리ㅡㅡㅡㅡㅡㅡㅡ");
                        System.out.print("1.[상품목록조회] 2.[상품수정] 3.[상품등록] 4.[뒤로가기]: ");
                        int itemMenu = sc.nextInt();

                        //상품 목록 조회
                        if(itemMenu == 1){
                            try {
                                adminService.M11_1();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }

                            //상품 수정
                        }else if(itemMenu == 2){
                            System.out.println("ㅡㅡㅡㅡㅡㅡㅡ상품수정ㅡㅡㅡㅡㅡㅡㅡ");
                            System.out.print("수정할 상품번호 입력 : ");
                            int itemNum = sc.nextInt();
                            System.out.print("변경할 이름 입력 : ");
                            String itemSetName = sc.next();
                            Item item = Item.builder()
                                    .item_id(itemNum)
                                    .item_name(itemSetName)
                                    .build();
                            try {
                                adminService.M111_1(item);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }

                            //상품 등록
                        }else if(itemMenu == 3){
                            System.out.println("ㅡㅡㅡㅡㅡㅡㅡ상품등록ㅡㅡㅡㅡㅡㅡㅡ");
                            System.out.print("상품카테고리 입력[10:의류, 11:가전, 12:식품, 13:도서] : ");
                            int itemNewCategory = sc.nextInt();
                            System.out.print("상품명 입력 : ");
                            String itemNewName = sc.next();
                            System.out.print("가격 입력 : ");
                            int itemNewPrice = sc.nextInt();
                            System.out.print("재고 입력 : ");
                            int itemNewStock = sc.nextInt();
                            System.out.print("상품 이미지 입력 : ");
                            String itemNewImg = sc.next();
                            System.out.print("상품 설명 입력 : ");
                            String itemNewText = sc.next();

                            Item item = Item.builder()
                                    .category_id(itemNewCategory)
                                    .item_name(itemNewName)
                                    .itemPrice(itemNewPrice)
                                    .item_stock(itemNewStock)
                                    .item_img(itemNewImg)
                                    .item_text(itemNewText)
                                    .build();

                            try {
                                adminService.M112_1(item);
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }else if(itemMenu == 4){
                            continue;
                        }else{
                            System.out.println("올바른 번호를 입력하세요..!");
                        }
                    }else if(menu == 2){
                        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ통계 확인ㅡㅡㅡㅡㅡㅡㅡ");
                        System.out.print("1.[성별] 2.[나이] 3.[날짜] 4.[지역별] 5.[뒤로가기]: ");
                        int statsNum = sc.nextInt();
                        if(statsNum == 1){
                            try {
                                totalOrderService.M21_1();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }else if(statsNum == 2){
                            try {
                                totalOrderService.M22_1();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }else if(statsNum == 3){
                            try {
                                totalOrderService.M23_1();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }else if(statsNum == 4){
                            try {
                                totalOrderService.M24_1();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }else if(statsNum == 5){
                            continue;
                        }else{
                            System.out.println("올바른 번호를 입력하세요..!");
                        }
                    }else if(menu == 3){
                        System.out.print("1.[후기목록조회] 2.[후기삭제(추가예정)] 3.[답변입력] 4.[뒤로가기]: ");
                        int reviewNum = sc.nextInt();
                        if(reviewNum == 1){
                            try {
                                adminService.M31_1();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }else if(reviewNum == 2){

                        }else if(reviewNum == 3){

                        }else if (reviewNum == 4){

                        }else{
                            System.out.println("올바른 번호를 입력하세요..!");
                        }
                    }else if(menu == 4){

                    }else if(menu == 5){
                        login = false;
                    }else{
                        System.out.println("올바른 번호를 입력하세요..!");
                    }
                }


                //종료
            } else if (num == 2) {
                System.exit(0);
            } else {
                System.out.println("올바른 번호를 입력하세요..!");
            }
        }
    }
}
